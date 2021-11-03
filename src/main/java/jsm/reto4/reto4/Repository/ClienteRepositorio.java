package jsm.reto4.reto4.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsm.reto4.reto4.Model.Cliente;
import jsm.reto4.reto4.Repository.Crud.ClienteCrudRepositorio;

@Repository
public class ClienteRepositorio {
    @Autowired
    private ClienteCrudRepositorio clienteCrudRepositorio;

    public List<Cliente>getAll(){
        return(List<Cliente>) clienteCrudRepositorio.findAll();
    }
    public Optional<Cliente>getCliente(int id){
        return clienteCrudRepositorio.findById(id);
    }
    public Cliente save(Cliente cliente){
        return clienteCrudRepositorio.save(cliente);
    }
    public void delete (Cliente cliente){
        clienteCrudRepositorio.delete(cliente);
    }
}

