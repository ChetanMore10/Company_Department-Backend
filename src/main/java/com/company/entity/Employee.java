package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "department") // Avoid infinite loop
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("fName")
    private String fName;

    @JsonProperty("lName")
    private String lName;

    private String position;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Department department;
}