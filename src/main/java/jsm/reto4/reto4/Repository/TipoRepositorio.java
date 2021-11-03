package jsm.reto4.reto4.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsm.reto4.reto4.Model.Tipo;
import jsm.reto4.reto4.Repository.Crud.TipoCrudRepositorio;

@Repository
public class TipoRepositorio {
    @Autowired
    private TipoCrudRepositorio tipoCrudRepositorio;
    public List<Tipo>getAll(){
        return(List<Tipo>)tipoCrudRepositorio.findAll();
    }
    public Optional<Tipo>getTipo(int id){
        return tipoCrudRepositorio.findById(id);
    }
    public Tipo save (Tipo tipo){
        return tipoCrudRepositorio.save(tipo);
    }
    public void delete (Tipo category){
        tipoCrudRepositorio.delete(category);
    }
        
}

