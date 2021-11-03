package jsm.reto4.reto4.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jsm.reto4.reto4.Model.Mensaje;
import jsm.reto4.reto4.Repository.MensajeRepositorio;

@Service
public class MensajeServicio {
    @Autowired
    private MensajeRepositorio mensajeRepositorio;

    public List<Mensaje>getAll(){
        return mensajeRepositorio.getAll();
    }
    public Optional<Mensaje>getMessage(int messageId){
        return mensajeRepositorio.getMessage(messageId);
    }
    public Mensaje save(Mensaje message){
        if(message.getIdMessage()==null){
            return mensajeRepositorio.save(message);
        }else{
            Optional<Mensaje> consulta=mensajeRepositorio.getMessage(message.getIdMessage());
            if(consulta.isEmpty()){
                return mensajeRepositorio.save(message);
            }else{
                return message;
            }
        }
    }
    public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> consulta= mensajeRepositorio.getMessage(message.getIdMessage());
            if(!consulta.isEmpty()){
                if(message.getMessageText()!=null){
                    consulta.get().setMessageText(message.getMessageText());
                }
                mensajeRepositorio.save(consulta.get());
                return consulta.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            mensajeRepositorio.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}

