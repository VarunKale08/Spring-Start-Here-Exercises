package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class SecurityAspect {

    Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Around(value="@annotation(ToLog)")
    public Object secure(ProceedingJoinPoint jointPoint) throws Throwable{

        logger.info("Executing the Security Aspect");

        Object returnValue = jointPoint.proceed();

        logger.info("Security Aspect executed and returned: " + returnValue);

        return returnValue;
    }

}
