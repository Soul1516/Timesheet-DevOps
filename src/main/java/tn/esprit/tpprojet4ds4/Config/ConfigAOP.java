package tn.esprit.tpprojet4ds4.Config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class ConfigAOP {

    @Before("execution(* tn.esprit.tpprojet4ds4.Services.*.afficher*(..))")
   public void methodeAOP(){
       log.info("Mehtode executee");
   }

   @Around("execution(* tn.esprit.tpprojet4ds4.Services.*.*(..))")
   public Object profile(ProceedingJoinPoint pjp) throws Throwable {
       long start = System.currentTimeMillis();
       Object obj = pjp.proceed();
       long elapsedTime = System.currentTimeMillis() - start;
       log.info("Method execution time: " + elapsedTime + " milliseconds.");
       return obj;
   }
}
