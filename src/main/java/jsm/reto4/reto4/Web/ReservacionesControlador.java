package jsm.reto4.reto4.Web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jsm.reto4.reto4.Model.Reservaciones;
import jsm.reto4.reto4.Repository.ContadorClientes;
import jsm.reto4.reto4.Repository.StatusReservaciones;
import jsm.reto4.reto4.Services.ReservacionesServicio;


@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservacionesControlador{
    @Autowired
    private ReservacionesServicio reservacionesServicio;
    @GetMapping("/all")
    public List<Reservaciones>getReservations(){
        return reservacionesServicio.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservaciones>getReservation(@PathVariable("id")int reservationId){
        return reservacionesServicio.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservation){
        return reservacionesServicio.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones update(@RequestBody Reservaciones reservation) {
        return reservacionesServicio.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return reservacionesServicio.deleteReservation(reservationId);
    }
    @GetMapping("/report-status")
    public StatusReservaciones getReservaciones() {
        return reservacionesServicio.reporteStatusServicio();
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservaciones>getReservasTiempo(@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo){
        return reservacionesServicio.reporteTiempoServicio(dateOne, dateTwo);
    }
    @GetMapping("/report-clients")
    public List<ContadorClientes>getClientes() {
        return reservacionesServicio.reporteClientesSevicio();
    }
    
    

}

