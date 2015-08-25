package net.bitacademy.java72.domain;

import java.io.Serializable;

public class FileItem implements Serializable {
  private static final long serialVersionUID = 1L;

  protected String  name;
  protected long    size;
  protected String  originName;
  
  public String getName() {
    return name;
  }
  public FileItem setName(String name) {
    this.name = name;
    return this;
  }
  public long getSize() {
    return size;
  }
  public FileItem setSize(long size) {
    this.size = size;
    return this;
  }
  public String getOriginName() {
    return originName;
  }
  public FileItem setOriginName(String originName) {
    this.originName = originName;
    return this;
  }
  
  
}
