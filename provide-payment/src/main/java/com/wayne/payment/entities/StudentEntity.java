package com.wayne.payment.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "student")
@Entity
public class StudentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "age", nullable = false)
  private Integer age;


}
