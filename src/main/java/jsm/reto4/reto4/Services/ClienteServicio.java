package jsm.reto4.reto4.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jsm.reto4.reto4.Model.Cliente;
import jsm.reto4.reto4.Repository.ClienteRepositorio;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente>getAll(){
        return clienteRepositorio.getAll();
    }
    public Optional<Cliente>getClient(int clientId){
        return clienteRepositorio.getCliente(clientId);
    }
    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return clienteRepositorio.save(client);
        }else{
            Optional<Cliente> consulta=clienteRepositorio.getCliente(client.getIdClient());
            if(consulta.isEmpty()){
                return clienteRepositorio.save(client);
            }else{
                return client;
            }
        }
    }
    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente>consulta=clienteRepositorio.getCliente(client.getIdClient());
            if(!consulta.isEmpty()){
                if(client.getName()!=null){
                    consulta.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    consulta.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    consulta.get().setPassword(client.getPassword());
                }
                clienteRepositorio.save(consulta.get());
                return consulta.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    public boolean deleteClient(int clientId){
        Boolean aBoolean=getClient(clientId).map(client ->{
            clienteRepositorio.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

