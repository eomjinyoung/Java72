package net.bitacademy.java72.domain;

import java.io.Serializable;
import java.sql.Date;

/* 값을 실어 나르는 클래스(Data Transfer Object)
 * => 값을 표현하는 클래스
 * => 특정 업무 영역의 데이터를 표현한다고 해서 Business Domain Object라고도 한다.
 * => 줄여서 Domain Object 객체라고 한다.
 * 
 * Serializable 인터페이스
 * => 클래스의 데이터를 바이트 배열로 직렬화할 수 있음을 표시할 때 사용.
 * => 메서드가 없다. 단지 JVM에게 직렬화를 허용한다고 표시하는 용도로 사용한다.
 */
public class Board implements Serializable {
  /* 질력화될 때 데이터의 버전 정보도 함께 저장된다.
   * 나중에 바이트 배열을 다시 객체로 복원할 때, 버전을 검사하는 데 사용한다.
   */
  private static final long serialVersionUID = 1L;

  protected int     no;
  protected String  title;
  protected String  content;
  protected Date    createDate;
  protected int     viewCount;
  protected String  attachFile1;
  protected String  attachFile2;
  protected String  attachFile3;
  protected String  password;
  protected String  yyyyMMdd;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
    this.yyyyMMdd = createDate.toString();
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public String getAttachFile1() {
    return attachFile1;
  }
  public void setAttachFile1(String attachFile1) {
    this.attachFile1 = attachFile1;
  }
  public String getAttachFile2() {
    return attachFile2;
  }
  public void setAttachFile2(String attachFile2) {
    this.attachFile2 = attachFile2;
  }
  public String getAttachFile3() {
    return attachFile3;
  }
  public void setAttachFile3(String attachFile3) {
    this.attachFile3 = attachFile3;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getYyyyMMdd() {
    return yyyyMMdd; 
  }
  public void setYyyyMMdd(String yyyyMMdd) {
    this.setCreateDate(Date.valueOf(yyyyMMdd));
  }
  
  
}





















