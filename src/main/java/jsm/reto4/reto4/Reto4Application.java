package jsm.reto4.reto4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"jsm.reto4.reto4.Model"})
@SpringBootApplication
public class Reto4Application {

    public static void main(String[] args) {
        SpringApplication.run(Reto4Application.class, args);
    }

}

