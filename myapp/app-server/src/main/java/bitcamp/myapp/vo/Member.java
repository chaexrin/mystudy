package bitcamp.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {

  private static final long serialVersionUID = 100L;

  private String email;
  private String name;
  private String password;
  private Date createdDate;
  private int no;

  @Override
  public String toString() {
    return "Member{" +
        "email='" + email + '\'' +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", createdDate=" + createdDate +
        ", no=" + no +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

 
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}