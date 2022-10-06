package uz.master.DTOs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String surName;
    private String university;
    private String degree;
    private String bio;
    private String email1;
    private String email2;
    private String phone;
    private String address;
    private String picture;
    private Integer posts;
    private Integer more;
    private Integer articles;
    private Integer conference;
    private boolean deleted;



}
