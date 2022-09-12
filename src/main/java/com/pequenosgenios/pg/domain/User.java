package com.pequenosgenios.pg.domain;

import lombok.*;

import javax.persistence.*;

@Entity(name = "user_auth")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    @Column(columnDefinition = "text")
    private String password;

    private String role;
}

