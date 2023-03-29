package com.example.ratelimitting.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDao {

  private Integer empId;

  private String name;

  private String adderess;

  private String mobileNumber;

  private String pinCode;

  private String fatherName;

  private String motherName;

}
