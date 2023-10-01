package com.example.loginApplicationBE.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ROLE_FUNCTION")
public class RoleFunction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_FUNCTION_ID", unique = true, nullable = false)
    private Long roleFunctionId;

    @OneToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    private Role role;

    @OneToOne
    @JoinColumn(name = "FUNCTION_ID", referencedColumnName = "FUNCTION_ID")
    private Function function;
}
