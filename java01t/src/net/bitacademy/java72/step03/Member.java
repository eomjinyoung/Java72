package net.bitacademy.java72.step03;

import java.util.Date;

public class Member {
  String name;
  String id;
  String password;
  String email;
  String tel;
  Date regDate;
  
  @Override
  public String toString() {
    return "Member [name=" + name + ", id=" + id + ", password=" + password
        + ", email=" + email + ", tel=" + tel + ", regDate=" + regDate + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
    result = prime * result + ((tel == null) ? 0 : tel.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Member other = (Member) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (regDate == null) {
      if (other.regDate != null)
        return false;
    } else if (!regDate.equals(other.regDate))
      return false;
    if (tel == null) {
      if (other.tel != null)
        return false;
    } else if (!tel.equals(other.tel))
      return false;
    return true;
  }

  public String getName() {
    return name;
  }

  public Member setName(String name) {
    this.name = name;
    return this;
  }

  public String getId() {
    return id;
  }

  public Member setId(String id) {
    this.id = id;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public Member setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Member setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getTel() {
    return tel;
  }

  public Member setTel(String tel) {
    this.tel = tel;
    return this;
  }

  public Date getRegDate() {
    return regDate;
  }

  public Member setRegDate(Date regDate) {
    this.regDate = regDate;
    return this;
  }
  
  
  
  
  
}