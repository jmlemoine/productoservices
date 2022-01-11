package com.example.itemservice.controllers;

import com.example.itemservice.controllers.DAO.Login;
import com.example.itemservice.controllers.DAO.LoginResponse;
import com.example.itemservice.controllers.DAO.UserRegisterDao;
import com.example.itemservice.controllers.DAO.UsuarioDao;
import com.example.itemservice.models.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping ("/api")
public class UsuarioController {

    @Autowired
    SenderRabbitMQ senderRabbitMQ;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping(value = "/auth")
    public LoginResponse login(@RequestParam("username") String username, @RequestParam("password") String password) throws JsonProcessingException {
        Usuario usuario = new Usuario();

        usuario.setPassword(password);
        usuario.setUsername(username);

        ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        final String jsonNode = mapper.writeValueAsString(usuario);
        System.out.println(jsonNode);

        // {
        //	"usuario": "admin",
        //	"password": "123456"
        //}
        Login login = new Login();
        login.password = password;
        login.username = username;
        LoginResponse loginResponse = restTemplate.postForObject("http://servicio-usuarios/api/auth", login,LoginResponse.class);

        return loginResponse;
    }

    @CrossOrigin(origins = "http://localhost:8002")
    @PostMapping(value = "/auth/registrarse")
    public UsuarioDao registrarse(@RequestBody UsuarioDao usuario) throws JsonProcessingException {
        UsuarioDao loginResponse = restTemplate.postForObject("http://servicio-usuarios/api/auth/registrarse", usuario, UsuarioDao.class);

        UserRegisterDao ur = new UserRegisterDao();
        ur.password = usuario.password;
        System.out.println(usuario.email);
        ur.email = usuario.email;
        ur.username = usuario.username;
        restTemplate.postForObject("http://servicio-usuarios/api/auth/emailRegistro", ur, UserRegisterDao.class);
    /*    if(loginResponse != null) {
            //
            convertirString(ur);
        }*/

        return loginResponse;
    }
    public void convertirString(UserRegisterDao userRegisterDao) throws JsonProcessingException {
        ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        final String jsonNode = mapper.writeValueAsString(userRegisterDao);
        senderRabbitMQ.send(jsonNode);
    }

}
