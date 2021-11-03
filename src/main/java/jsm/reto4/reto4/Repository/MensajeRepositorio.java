package jsm.reto4.reto4.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jsm.reto4.reto4.Model.Mensaje;
import jsm.reto4.reto4.Repository.Crud.MensajeCrudRepositorio;

@Repository
public class MensajeRepositorio {
    @Autowired
    private MensajeCrudRepositorio mensajeCrudRepositorio;
    public List<Mensaje>getAll(){
        return (List<Mensaje>) mensajeCrudRepositorio.findAll();
    }
    public Optional<Mensaje>getMessage(int id){
        return mensajeCrudRepositorio.findById(id);
    }
    public Mensaje save(Mensaje message){
        return mensajeCrudRepositorio.save(message);
    }
    public void delete (Mensaje message){
        mensajeCrudRepositorio.delete(message);
    }   
}

