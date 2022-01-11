package com.example.usuarioservice.services;

import com.example.usuarioservice.entidades.Cliente;
import com.example.usuarioservice.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepositorio clienteRepo;

    @Transactional
    public void crearCliente(Cliente cliente){

        clienteRepo.save(cliente);
    }


    public List<Cliente> listarClientes(){

        return clienteRepo.findAll();
    }


    public Cliente encontrarClientePorId(long id){

        return clienteRepo.findClienteById(id);
    }


    public void eliminarCliente(long id){

        Cliente clienteToDelete = clienteRepo.findClienteById(id);

        clienteRepo.delete(clienteToDelete);
    }
}
