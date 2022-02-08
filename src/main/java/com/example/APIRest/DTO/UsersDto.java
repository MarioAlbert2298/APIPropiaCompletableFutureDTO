package com.example.APIRest.DTO;

import org.apache.catalina.User;

import java.io.Serializable;

public class UsersDto implements Serializable {
    private String name;
    private String apellido;
    public UsersDto(String name, String apellido){
        this.name=name;
        this.apellido=apellido;
    }
    public UsersDto(){

    }

}
