package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Around(value="@annotation(ToLog)")
    public Object log(ProceedingJoinPoint jointPoint) throws Throwable{

        logger.info("Executing the Logging Aspect");

        Object returnValue = jointPoint.proceed();

        logger.info("Logging Aspect executed and returned: " + returnValue);

        return returnValue;
    }
}
