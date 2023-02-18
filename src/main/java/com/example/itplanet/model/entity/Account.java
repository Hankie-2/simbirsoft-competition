package com.example.itplanet.model.entity;

import com.example.itplanet.validation.NotSpaces;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @NotEmpty
    @NotSpaces
    String firstName;

    @NotNull
    @NotEmpty
    @NotSpaces
    String lastName;

    @Email
    @NotNull
    @NotSpaces
    String email;

    @NotNull
    @NotEmpty
    @NotSpaces
    String password;
}
