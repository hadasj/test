package cz.i.test.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author jan.hadas@i.cz
 */
public class Obyvatel implements Serializable {
  private static final long serialVersionUID = 8982553440436559783L;

  private Long id;
  private String firstName;
  private String surName;
  private LocalDate birthDate;
  private String address;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this);
    builder.append("id", id).append("firstName", firstName).append("surName", surName).append("birthDate", birthDate).append("address", address);
    return builder.toString();
  }
}
