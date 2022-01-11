package com.example.usuarioservice.controller;

import com.example.usuarioservice.controller.DAO.Login;
import com.example.usuarioservice.controller.DAO.RegistroResponseDao;
import com.sendgrid.*;
import com.example.usuarioservice.controller.DAO.LoginResponse;
import com.example.usuarioservice.controller.DAO.UsuarioDao;
import com.example.usuarioservice.entidades.Rol;
import com.example.usuarioservice.entidades.Usuario;
import com.example.usuarioservice.repositorios.UsuarioRepositorio;
import com.example.usuarioservice.services.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@RestController
@RequestMapping("/api/")
public class AuthController {
    @Autowired
    UsuarioRepositorio usuarioRepository;

    @Autowired
    UsuarioService usuarioService;

    @Value("${token_jwt}")
    private String llaveSecreta;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @CrossOrigin(origins = "http://localhost:8003")
    @PostMapping("/auth")
    public ResponseEntity<LoginResponse> auth(@RequestBody Login username){
        String token;
        Usuario usuario = usuarioRepository.findByUsername(username.username);
        System.out.println(username);
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        if(usuario==null && !usuario.getPassword().equals(bCryptPasswordEncoder.encode(username.password))){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        token = generarToken(usuario);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.token = token;
        loginResponse.username = username.username;
        loginResponse.email = usuario.getCorreo();
        for (Rol r: usuario.getRoles()) {
            loginResponse.roles.add(r.getRole());
        }
        return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
    }

    @PostMapping("/auth/registrarse")
    public UsuarioDao registrarse(@RequestBody UsuarioDao username) {

        Usuario admin = new Usuario();
        admin.setUsername(username.username);
        admin.setNombre(username.nombre);
        admin.setApellido(username.apellido);
        admin.setCorreo(username.email);
        admin.setPassword(bCryptPasswordEncoder.encode(username.password));
        Rol rolCliente = new Rol("ROLE_CLIENT");
        admin.setRoles(new HashSet<>(Arrays.asList(rolCliente)));
        usuarioService.crearUsuario(admin);

        return username;
    }
    ArrayList<LoginResponse> loginResponses = new ArrayList<>();
    @GetMapping("/auth/empleados")
    public ArrayList<LoginResponse> empleados() {
        ArrayList<Usuario> usuarios = usuarioService.usuariosEmpleados();
//        ArrayList<LoginResponse> loginResponses = new ArrayList<>();
        for (Usuario u: usuarios) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.email = u.getCorreo();
            loginResponse.username = u.getUsername();
            loginResponse.token = "NO-TOKEN";
            for (Rol r: u.getRoles()) {
                loginResponse.roles.add(r.getRole());
            }
            loginResponses.add(loginResponse);
        }
        return loginResponses;
    }
    @GetMapping("/auth/clientes")
    public ArrayList<LoginResponse> clientes() {
        ArrayList<Usuario> usuarios = usuarioService.usuariosCliente();
        for (Usuario u: usuarios) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.email = u.getCorreo();
            loginResponse.username = u.getUsername();
            loginResponse.token = "NO-TOKEN";
            for (Rol r: u.getRoles()) {
                loginResponse.roles.add(r.getRole());
            }
            loginResponses.add(loginResponse);
        }
        return loginResponses;
    }

    @RequestMapping("/")
    public String index(){
        return "Hola Mundo con JWT";
    }


    /**
     *
     * @param usuario
     * @return
     */
    private String generarToken(Usuario usuario) {

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(usuario.getUsername())
                .claim("roles",usuario.getRoles())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        llaveSecreta.getBytes()).compact();

        return token;
    }
    @PostMapping("/auth/emailRegistro")
    public void enviarEmailRegistro(@RequestBody RegistroResponseDao loginResponse) throws IOException {
        Email from = new Email("deparmento@fotosjr.com");
        String subject = "Bienvenido a nuestros servicios";

        System.out.println(loginResponse.email);
        Email to = new Email(loginResponse.email);
        Content content = new Content("text/plain", "Se ha completado el registro del usuario " + loginResponse.username);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sg.api(request);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
    }
}
