package com.example.usuarioservice.controller.DAO;

import java.util.ArrayList;

public class LoginResponse {
    public String username;
    public String token;
    public String email;
    public ArrayList<String> roles = new ArrayList<>();
}