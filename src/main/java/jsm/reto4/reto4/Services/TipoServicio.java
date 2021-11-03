package jsm.reto4.reto4.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jsm.reto4.reto4.Model.Tipo;
import jsm.reto4.reto4.Repository.TipoRepositorio;

@Service
public class TipoServicio {
    @Autowired
    private TipoRepositorio tipoRepositorio;

    public List<Tipo>getAll(){
        return tipoRepositorio.getAll();
    }
    public Optional<Tipo>getTipo(int tipoId){
        return tipoRepositorio.getTipo(tipoId);
    }
    public Tipo save (Tipo tipo){
        if(tipo.getId()==null){
            return tipoRepositorio.save(tipo);
        }else{
            Optional<Tipo> consulta=tipoRepositorio.getTipo(tipo.getId());
            if(consulta.isEmpty()){
                return tipoRepositorio.save(tipo);
            }else{
                return tipo;
            }
        }
    }
    public Tipo update(Tipo tipo){
        if(tipo.getId()!=null){
            Optional<Tipo>consulta2=tipoRepositorio.getTipo(tipo.getId());
            if(!consulta2.isEmpty()){
                if(tipo.getDescription()!=null){
                    consulta2.get().setDescription(tipo.getDescription());
                }
                if(tipo.getName()!=null){
                    consulta2.get().setName(tipo.getName());
                }
                return tipoRepositorio.save(consulta2.get());
            }
        }
        return tipo;
    }
    public boolean deletetipo(int tipoId){
        Boolean del=getTipo(tipoId).map(tipo ->{
            tipoRepositorio.delete(tipo);
            return true;
        }).orElse(false);
        return del;
    }
    
}

