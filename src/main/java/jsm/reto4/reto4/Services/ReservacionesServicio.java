package jsm.reto4.reto4.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jsm.reto4.reto4.Model.Reservaciones;
import jsm.reto4.reto4.Repository.ContadorClientes;
import jsm.reto4.reto4.Repository.ReservacionesRepositorio;
import jsm.reto4.reto4.Repository.StatusReservaciones;

@Service
public class ReservacionesServicio {
    @Autowired
    private ReservacionesRepositorio reservacionesRepositorio;

    public List<Reservaciones>getAll(){
        return reservacionesRepositorio.getAll();
    }
    public Optional<Reservaciones>getReservation(int reservationId){
        return reservacionesRepositorio.getReservation(reservationId);
    }
    public Reservaciones save (Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return reservacionesRepositorio.save(reservation);
        }else{
            Optional<Reservaciones> consulta=reservacionesRepositorio.getReservation(reservation.getIdReservation());
            if(consulta.isEmpty()){
                return reservacionesRepositorio.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> consulta= reservacionesRepositorio.getReservation(reservation.getIdReservation());
            if(!consulta.isEmpty()){

                if(reservation.getStartDate()!=null){
                    consulta.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    consulta.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    consulta.get().setStatus(reservation.getStatus());
                }
                reservacionesRepositorio.save(consulta.get());
                return consulta.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservacionesRepositorio.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public StatusReservaciones reporteStatusServicio (){
        List<Reservaciones>completed=reservacionesRepositorio.ReservacionesStatusRepositorio("completed");
        List<Reservaciones>cancelled=reservacionesRepositorio.ReservacionesStatusRepositorio("cancelled");
        return new StatusReservaciones(completed.size(), cancelled.size());
    }
    public List<Reservaciones>reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");

        Date datoUno = new Date();
        Date datoDos = new Date();

        try{
            datoUno=parser.parse(datoA);
            datoDos=parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservacionesRepositorio.ReservacionesTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }
    public List<ContadorClientes> reporteClientesSevicio(){
        return reservacionesRepositorio.getClientesRepositorio();
    }
    
}

