package com.osman.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;
    @Column(name = "verification_code", length = 128)
    private String verificationCode;
    private boolean enabled;

    @Column(name = "reset_password_token", length = 128)
    private String resetPasswordToken;

    public String getUsername() {
        return this.firstName + " " + this.lastName;
    }
}
