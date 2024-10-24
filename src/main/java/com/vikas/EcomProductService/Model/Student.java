package com.vikas.EcomProductService.Model;

import jakarta.persistence.Entity;

@Entity
public class Student extends User{
    private String studentName;
    private String batchName;
}
