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
import jsm.reto4.reto4.Model.Tipo;
import jsm.reto4.reto4.Services.TipoServicio;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class TipoControlador {
    @Autowired
    private TipoServicio tipoServicio;
    @GetMapping("/all")
    public List<Tipo>getTipo(){
        return tipoServicio.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Tipo>getTipo(@PathVariable("id")int categoriaid){
        return tipoServicio.getTipo(categoriaid);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Tipo save(@RequestBody Tipo tipo){
        return tipoServicio.save(tipo);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Tipo update(@RequestBody Tipo tipo) {
        return tipoServicio.update(tipo);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int tipoId) {
        return tipoServicio.deletetipo(tipoId);
    }
}

