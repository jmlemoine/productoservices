package com.example.usuarioservice.services;

import com.example.usuarioservice.entidades.Rol;
import com.example.usuarioservice.entidades.Usuario;
import com.example.usuarioservice.repositorios.RolRepositorio;
import com.example.usuarioservice.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class SeguridadService implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepo;

    @Autowired
    private RolRepositorio rolRepositorio;

    //Para encriptar la información
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void crearUsuarioAdmin(){
        //creo los roles

        Rol rolClient = new Rol();
        rolClient.setRole("ROLE_CLIENT");
        rolRepositorio.save(rolClient);

        Rol rolAdmin = new Rol("ROLE_ADMIN");
        rolRepositorio.save(rolAdmin);

        Rol rolEmpleado = new Rol("ROLE_EMPLEADO");
        rolRepositorio.save(rolEmpleado);

        Usuario usuarioAdmin = new Usuario();
        usuarioAdmin.setUsername("admin");
        usuarioAdmin.setNombre("Admin");
        usuarioAdmin.setApellido("Admin");
        usuarioAdmin.setRoles(new HashSet<>(Arrays.asList(rolAdmin)));
        usuarioAdmin.setCorreo("admin@example.com");
        // creo la passwrod, pero tambien la encripto con el password encoder
        usuarioAdmin.setPassword(passwordEncoder.encode("123456"));

        //Empleado
        Usuario usuarioEmpleado = new Usuario();
        usuarioEmpleado.setUsername("jean");
        usuarioEmpleado.setNombre("Jean");
        usuarioEmpleado.setApellido("Lemoine");
        usuarioEmpleado.setRoles(new HashSet<>(Arrays.asList(rolEmpleado)));
        usuarioEmpleado.setCorreo("jeanmelvinlp27@gmail.com");
        // creo la passwrod, pero tambien la encripto con el password encoder
        usuarioEmpleado.setPassword(passwordEncoder.encode("123456"));


        usuarioRepo.save(usuarioAdmin);
        usuarioRepo.save(usuarioEmpleado);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario user = usuarioRepo.findByUsername(username);

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, grantedAuthorities);
    }
}
