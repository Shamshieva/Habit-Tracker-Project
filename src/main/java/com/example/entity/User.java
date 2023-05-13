package com.example.entity;

import com.example.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1, initialValue = 5)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String icon;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = ALL, mappedBy = "user")
    private Calendar calendar;

    @OneToMany(cascade = ALL, mappedBy = "user")
    private List<Achievement> achievements;
}
