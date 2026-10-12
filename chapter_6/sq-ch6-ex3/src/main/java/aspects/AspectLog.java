package aspects;

import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class AspectLog {

    private Logger logger = Logger.getLogger(AspectLog.class.getName());

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{

        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();

        logger.info("Method name: " + methodName + " method arguments: " + Arrays.asList(methodArgs));



        Comment comment = new Comment();
        comment.setAuthor("varun");
        comment.setContent("method has been altered with proxy using AOP.");

        Object[] newArgument = {comment};
        Object returnedByMethod = joinPoint.proceed(newArgument);

        logger.info("Method executed and returned: " + returnedByMethod);

        return "FAILURE";
    }

}
