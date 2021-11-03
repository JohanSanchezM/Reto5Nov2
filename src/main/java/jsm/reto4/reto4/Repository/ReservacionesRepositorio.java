package jsm.reto4.reto4.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsm.reto4.reto4.Model.Cliente;
import jsm.reto4.reto4.Model.Reservaciones;
import jsm.reto4.reto4.Repository.Crud.ReservacionesCrudRepositorio;

@Repository
public class ReservacionesRepositorio {
    @Autowired
    private ReservacionesCrudRepositorio reservacionesCrudRepositorio;
    public List<Reservaciones>getAll(){
        return (List<Reservaciones>) reservacionesCrudRepositorio.findAll();
    }
    public Optional<Reservaciones>getReservation(int id){
        return reservacionesCrudRepositorio.findById(id);
    }
    public Reservaciones save (Reservaciones reservation){
        return reservacionesCrudRepositorio.save(reservation);
    }  
    public void delete (Reservaciones reservation){
        reservacionesCrudRepositorio.delete(reservation);
    }   


    public List<Reservaciones>ReservacionesStatusRepositorio(String status){
        return reservacionesCrudRepositorio.findAllByStatus(status);
    }
    public List<Reservaciones>ReservacionesTiempoRepositorio(Date a, Date b){
        return reservacionesCrudRepositorio.findByStartDateAfterAndStartDateBefore(a, b);
    }
    public List<ContadorClientes>getClientesRepositorio(){
        List<ContadorClientes> res=new ArrayList<>();
        List<Object[]> report = reservacionesCrudRepositorio.countTotalReservationsByCliente();
        for(int i=0; i<report.size(); i++){
            res.add(new ContadorClientes ((Long)report.get(i)[1],(Cliente)report.get(i)[0]));
            
        }
        return res;
    }
    
}

