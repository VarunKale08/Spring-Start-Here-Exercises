package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(2)
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());


    public void setLogger(Logger logger){
        this.logger = logger;
    }

    @Around(value="@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("Executing the logging aspect");

        Object returnValue = joinPoint.proceed();

        logger.info("Logging Aspect executed and returned value: " + returnValue);

        return returnValue;
    }
}
