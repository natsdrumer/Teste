package com.example.teste.model;

import java.util.Date;

public class User {
    String name;
    String pasword;
    String email;
    String number;
    String dateBirth;
    String sexo;

    public User(String name, String pasword, String email, String number, String dateBirth, String sexo) {
        this.name = name;
        this.pasword = pasword;
        this.email = email;
        this.number = number;
        this.dateBirth = dateBirth;
        this.sexo = sexo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
