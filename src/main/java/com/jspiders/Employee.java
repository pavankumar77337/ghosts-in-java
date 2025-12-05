package com.jspiders;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="empno")
    private Long empNo;

    @Column(name ="ename", nullable = false)
    private String empName;

    @Column(name = "email",nullable = false,unique = true)
    private String empEmail;
}
