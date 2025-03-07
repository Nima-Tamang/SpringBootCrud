package com.texas.Miniproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @SequenceGenerator(name = "instructor_sequence", sequenceName = "instructor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_sequence")
    private Long id;

    private String name;
    private String email;
    private String phone;

    @ManyToOne
    private Department department;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
