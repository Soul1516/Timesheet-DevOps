package tn.esprit.tpprojet4ds4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
public class TpProjet4Ds4Application {

    public static void main(String[] args) {
        SpringApplication.run(TpProjet4Ds4Application.class, args);
    }

}
