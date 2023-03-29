package com.example.ratelimitting.entity;

import java.time.LocalDate;
import java.util.UUID;

import com.sun.istack.NotNull;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "users")
@JsonIgnoreProperties
public class User {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @NotNull
  @Column(name = "emp_id")
  private Integer empId;

  @NotNull
  private String name;

  @NotNull
  private String adderess;

  @NotNull
  @Column(name = "mobile_number")
  private String mobileNumber;

  @NotNull
  @Column(name = "pin_code")
  private String pinCode;


  @Column(name = "father_name")
  private String fatherName;

  @Column(name = "mother_name")
  private String motherName;

  @NotNull
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  @DateTimeFormat(iso = ISO.DATE)
  @CreationTimestamp
  private LocalDate createdDate;

}
