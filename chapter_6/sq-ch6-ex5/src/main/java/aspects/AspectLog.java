package aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class AspectLog {

    Logger logger = Logger.getLogger(AspectLog.class.getName());


    public void setLogger(Logger logger){
        this.logger = logger;
    }


    @AfterReturning(value = "@annotation(ToLog)", returning = "returnedValue")
    public void log(Object returnedValue){
        logger.info("Intercepted method returned value: " + returnedValue);
    }

}
