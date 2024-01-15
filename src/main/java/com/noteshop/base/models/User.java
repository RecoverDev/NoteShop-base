package com.noteshop.base.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String login;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String street;
	private String city;
	private String state;

	private boolean isadmin;
	
	
}
