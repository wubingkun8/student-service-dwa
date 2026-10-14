package hu.unimiskolc.student_service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String neptunCode;
    private String email;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNeptunCode() { return neptunCode; }
    public void setNeptunCode(String neptunCode) { this.neptunCode = neptunCode; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
