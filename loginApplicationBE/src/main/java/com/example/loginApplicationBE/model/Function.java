package com.example.loginApplicationBE.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FUNCTION_")
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FUNCTION_ID", unique = true, nullable = false)
    private Long functionId;

    @Column(name = "FUNCTION_NAME")
    private String functionName;

    @Column(name = "FUNCTION_CODE")
    private String functionCode;

    @Column(name = "FUNCTION_DESCRIPTION")
    private String functionDescription;
}
