package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint jointPoint) throws Throwable{

        String methodName = jointPoint.getSignature().getName();
        Object[] arguments = jointPoint.getArgs();

        logger.info("Service Class Method Name is: " + methodName + " and parameters are: " + Arrays.asList(arguments));

        Object returnedByMethod = jointPoint.proceed();

        logger.info("Method executed and returned." + returnedByMethod);

        return returnedByMethod;

    }
}
