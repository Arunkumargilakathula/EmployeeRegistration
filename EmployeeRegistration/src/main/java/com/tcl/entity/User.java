package com.tcl.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="UserCredentilas")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @NaturalId(mutable = true)
    private String email;
    private String password;
    private String roles;
}
//"firstName": "Pavani",
//"lastName": "panjala",
//"email": "pavani@gmail.com",
//"password": "pavani123",
//"roles": "USER"

