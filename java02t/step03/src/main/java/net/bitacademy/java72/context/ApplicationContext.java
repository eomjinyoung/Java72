package net.bitacademy.java72.context;

import static org.reflections.ReflectionUtils.getMethods;
import static org.reflections.ReflectionUtils.withAnnotation;
import static org.reflections.ReflectionUtils.withParametersCount;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.reflections.Reflections;

import net.bitacademy.java72.annotation.Autowired;
import net.bitacademy.java72.annotation.Controller;
import net.bitacademy.java72.annotation.Repository;

public class ApplicationContext {
  HashMap<String,Object> beanContainer;
  
  public ApplicationContext(String basePackage) {
    prepareCommandFromAnnotation(basePackage);
    prepareRepositoryFromAnnotation(basePackage);
    injectDependencies();
  }
  
  public Object getBean(String name) {
    return beanContainer.get(name);
  }
  
  public void addBean(String name, Object obj) {
    beanContainer.put(name, obj);
    injectDependencies();
  }
  
  private void prepareCommandFromAnnotation(
      String basePackage) {
    try {
      Reflections reflections = 
          new Reflections(basePackage);
      
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
  
  private void prepareRepositoryFromAnnotation(
      String basePackage) {
    try {
      Reflections reflections = 
          new Reflections(basePackage);
      
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
  
  @SuppressWarnings("unchecked")
  private void injectDependencies() {
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
          }
        }
      } catch (Exception e) {}
    }
    
  }
  
  private Object findObject(Class<?> clazz) 
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
