package com.example.liquibasetest.model;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "employees")
@SQLDelete(sql = "UPDATE employees SET is_deleted = true WHERE id=? ")
@Where(clause = "is_deleted=false")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "name")
    private String name;
    @ToStringExclude
    @Column(name = "social_security_number", unique = true)
    private String socialSecurityNumber;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
}
