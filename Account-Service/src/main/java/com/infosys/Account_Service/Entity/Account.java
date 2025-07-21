package com.infosys.Account_Service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account
{
    @Id
    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @Transient
    private String confirmPassword;

    @Email
    @Column(unique = true)
    private String email;
}
