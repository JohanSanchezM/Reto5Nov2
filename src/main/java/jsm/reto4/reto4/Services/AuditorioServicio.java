package jsm.reto4.reto4.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jsm.reto4.reto4.Model.Auditorio;
import jsm.reto4.reto4.Repository.AuditorioRepositorio;

@Service
public class AuditorioServicio {
    @Autowired
    private AuditorioRepositorio auditorioRepositorio;

    public List<Auditorio>getAll(){
        return auditorioRepositorio.getAll();
    }
    public Optional<Auditorio> getAuditorio(int auditorioId){
        return auditorioRepositorio.getAuditorio(auditorioId);
    }
    public Auditorio save(Auditorio audience){
        if(audience.getId()==null){
            return auditorioRepositorio.save(audience);
        }else{
            Optional<Auditorio>consulta=auditorioRepositorio.getAuditorio(audience.getId());
            if(consulta.isEmpty()){
                return auditorioRepositorio.save(audience);
            }else{
                return audience;
            }

        }
    }
    public Auditorio update(Auditorio audience){
        if(audience.getId()!=null){
            Optional<Auditorio>consulta=auditorioRepositorio.getAuditorio(audience.getId());
            if(!consulta.isEmpty()){
                if(audience.getName()!=null){
                    consulta.get().setName(audience.getName());
                }
                if(audience.getOwner()!=null){
                    consulta.get().setOwner(audience.getOwner());
                }
                if(audience.getCapacity()!=null){
                    consulta.get().setCapacity(audience.getCapacity());
                }
                if(audience.getDescription()!=null){
                    consulta.get().setDescription(audience.getDescription());
                }
                if(audience.getCategory()!=null){
                    consulta.get().setCategory(audience.getCategory());
                }
                auditorioRepositorio.save(consulta.get());
                return consulta.get();                 
            }else{
                return audience;
            }
        }else{
            return audience;
        }
    }
    public boolean deleteAudience(int audienceId){
        Boolean aBoolean=getAuditorio(audienceId).map(audience -> {
            auditorioRepositorio.delete(audience);
            return true;
        }).orElse(false);
        return aBoolean;
    }


    
}

