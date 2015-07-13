package net.bitacademy.java72.step07.v09;

import static org.reflections.ReflectionUtils.getMethods;
import static org.reflections.ReflectionUtils.withAnnotation;
import static org.reflections.ReflectionUtils.withParametersCount;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.reflections.Reflections;

public class BoardApp {
  static Scanner scanner;
  static BoardDao boardDao;
  static HashMap<String,Object> beanContainer;
  
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    beanContainer = new HashMap<String,Object>();
    
    prepareMybatis();
    prepareCommandFromAnnotation();
    prepareRepositoryFromAnnotation();
    injectDependencies();
    
    String command = null;
    Object commandWorker = null;
    
    do {
      try {
        System.out.print("명령> ");
        command = scanner.nextLine().toLowerCase();
        
        HashMap<String,Object> paramMap = 
            new HashMap<String,Object>();
        paramMap.put("inputScanner", scanner);
      
        commandWorker = beanContainer.get(command);
        Set<Method> methods = null;
        Method temp = null;
        if (commandWorker != null) {
          //@RequestMapping이 붙어있는 메서드를 찾아서 호출한다.
          methods = getMethods(
              commandWorker.getClass(), 
              withAnnotation(RequestMapping.class));
          temp = (Method)methods.toArray()[0];
          temp.invoke(commandWorker, paramMap);
        } else {
          System.out.println("해당 명령을 지원하지 않습니다!");
        }
      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생!");
      }
      
    } while (!command.toLowerCase().equals("quit"));
    
    scanner.close();
  }

  @SuppressWarnings("unchecked")
  private static void injectDependencies() {
    // beanContainer에 들어 있는 모든 객체에 대해
    // 의존 객체를 주입해 준다.
    Collection<Object> objList = beanContainer.values();
    for (Object obj : objList) {
      // obj의 클래스에서 @Autowired가 붙은 메서드를 찾는다.
      Set<Method> methods = null;
      try {
        methods = getMethods(
          obj.getClass(), 
          withAnnotation(Autowired.class),
          withParametersCount(1));
        Parameter parameter = null;
        Object dependency = null;
        
        for (Method m : methods) {
          // 셋터의 파라미터 정보를 추출한다.
          parameter = m.getParameters()[0];
          
          // 셋터의 파라미터에 맞는 객체를 찾는다.
          dependency = findObject(parameter.getType());
          
          if (dependency != null) {
            // 셋터를 호출하여 의존 객체를 주입한다. 
            m.invoke(obj, dependency);
            System.out.printf("%s.%s(%s)\n",
                obj.getClass().getName(),
                m.getName(),
                dependency.getClass().getName());
          }
        }
      } catch (Exception e) {}
    }
    
  }

  private static void prepareMybatis() {
    try {
      String resource = "net/bitacademy/java72/step07/v09/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      beanContainer.put("sqlSessionFactory", 
          sqlSessionFactory);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static void prepareRepositoryFromAnnotation() {
    try {
      Reflections reflections = new Reflections(
          "net.bitacademy.java72.step07.v09");
      
      Set<Class<?>> daoList = 
          reflections.getTypesAnnotatedWith(
              Repository.class);
      
      Repository anno = null;
      String value = null;
      
      for (Class<?> clazz : daoList) {
        anno = clazz.getAnnotation(
            Repository.class);
        if (anno.value().equals("")) {
          value = clazz.getName();
        } else {
          value = anno.value();
        }
        beanContainer.put(value, clazz.newInstance());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static void prepareCommandFromAnnotation() {
    try {
      Reflections reflections = new Reflections(
          "net.bitacademy.java72.step07.v09");
      
      Set<Class<?>> commandList = 
          reflections.getTypesAnnotatedWith(
              Controller.class);
      
      Controller anno = null;
      String value = null;
      
      for (Class<?> clazz : commandList) {
        anno = clazz.getAnnotation(
            Controller.class);
        if (anno.value().equals("")) {
          value = clazz.getName();
        } else {
          value = anno.value();
        }
        beanContainer.put(value, clazz.newInstance());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static Object findObject(Class<?> clazz) 
      throws Exception {
    Collection<Object> objList = 
        beanContainer.values();
    
    for (Object obj : objList) {
      if (clazz.isInstance(obj)) {
        return obj;
      }
    }
    
    return null;
  }
  


}









