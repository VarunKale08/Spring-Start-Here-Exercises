package aspect;

import org.apache.commons.logging.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(1)
public class SecurityAspect {

    private Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    public void setLogger(Logger logger){
        this.logger = logger;
    }


    @Around(value="@annotation(ToLog)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("Executing security aspect.");

        Object returnValue = joinPoint.proceed();

        logger.info("Security aspect executed and returned value: " + returnValue);

        return returnValue;
    }
}
