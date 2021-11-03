package jsm.reto4.reto4.Repository.Crud;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import jsm.reto4.reto4.Model.Reservaciones;

public interface ReservacionesCrudRepositorio extends CrudRepository<Reservaciones,Integer>{
    public List<Reservaciones>findAllByStatus(String status);
    public List<Reservaciones>findByStartDateAfterAndStartDateBefore(Date dateOne, Date datetwo);

    @Query("SELECT c.client, COUNT(c.client) from Reservaciones AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByCliente();

}

