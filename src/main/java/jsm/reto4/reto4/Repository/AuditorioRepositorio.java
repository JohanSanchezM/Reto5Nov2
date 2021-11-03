package jsm.reto4.reto4.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jsm.reto4.reto4.Model.Auditorio;
import jsm.reto4.reto4.Repository.Crud.AuditorioCrudRepositorio;

@Repository
public class AuditorioRepositorio {
    @Autowired
    private AuditorioCrudRepositorio auditorioCrudRepositorio;

    public List<Auditorio>getAll(){
        return (List<Auditorio>) auditorioCrudRepositorio.findAll();
    }
    public Optional<Auditorio>getAuditorio(int id){
        return auditorioCrudRepositorio.findById(id);
    }
    public Auditorio save (Auditorio audience){
        return auditorioCrudRepositorio.save(audience);
    }
    public void delete (Auditorio audience){
        auditorioCrudRepositorio.delete(audience);
    }
   
}

