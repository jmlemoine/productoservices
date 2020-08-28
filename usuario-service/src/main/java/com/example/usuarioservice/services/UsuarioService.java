package com.example.usuarioservice.services;

import com.example.usuarioservice.entidades.Rol;
import com.example.usuarioservice.entidades.Usuario;
import com.example.usuarioservice.repositorios.RolRepositorio;
import com.example.usuarioservice.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepositorio usuarioRepo;

    @Autowired
    private RolRepositorio rolRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Usuario crearUsuario(Usuario usuario){
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
       return usuarioRepo.save(usuario);
    }


    public List<Usuario> listarUsuarios(){

        return usuarioRepo.findAll();
    }

    public Optional<Usuario> getUsuario(String usuario) {
        return usuarioRepo.findById(usuario);
    }


   /* public Usuario encontrarUsuarioPorId(long id){

        return usuarioRepo.findUsuarioById(id);
    }*/

    public Usuario encontrarUsuarioPorUsername(String username){

        return usuarioRepo.findByUsername(username);
    }

    /*public void eliminarUsuario(long id){

        Usuario usuarioToDelete = usuarioRepo.findUsuarioById(id);

        usuarioRepo.delete(usuarioToDelete);
    }*/
    public Usuario devolverNuevoCliente(Usuario usuario){

        return usuarioRepo.save(usuario);
    }


    public void crearRol(Rol rol){

        rolRepo.save(rol);
    }


    public List<Rol> listarRoles(){

        return rolRepo.findAll();
    }


    public Rol encontrarRol(String role){

        return rolRepo.findByRole(role);
    }

    public Usuario encontrarUsuarioPorCorreo(String correo){

        return usuarioRepo.findByCorreo(correo);
    }
    public ArrayList<Usuario> usuariosEmpleados() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for (Usuario usuario: usuarioRepo.findAll()) {
            for (Rol rol: usuario.getRoles()) {
                if (rol.getRole().equals("ROLE_EMPLEADO")) {
                    usuarios.add(usuario);
                    System.out.println(usuario.getUsername());
                }
            }
        }
        return usuarios;
    }
    public ArrayList<Usuario> usuariosCliente() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for (Usuario usuario: usuarioRepo.findAll()) {
            for (Rol rol: usuario.getRoles()) {
                if (rol.getRole().equals("ROLE_CLIENT")) {
                    usuarios.add(usuario);
                    System.out.println(usuario.getUsername());
                }
            }
        }
        return usuarios;
    }

}
