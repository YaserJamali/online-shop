package samplelogs;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Aspect
@Component

public class LoggerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init() {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }


    @Around("execution(* com.hmaitech.onlineshop.controller..*(..))")
    public Object logger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
      LogModel logModel=new LogModel();
      logModel.setMethodName(signature.getName());


        LOGGER.info("Method Called: " + signature.getName());
//        String args = Arrays.stream(proceedingJoinPoint.getArgs())
//                .map(i -> {
//                    try {
//                        return objectMapper.writeValueAsString(i);
//                    } catch (JsonProcessingException e) {
//                        throw new RuntimeException(e);
//                    }
//                })
//                .collect(Collectors.joining("\n"));
        logModel.setRequest(proceedingJoinPoint.getArgs());

//        LOGGER.info("Parameters(ARGS) Called: " + args);

        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
            if (value != null)

             logModel.setResponse(value);
//                LOGGER.info("LOGGER RETURNED: " + objectMapper.writeValueAsString(value));
        } catch (Throwable e) {
            StringWriter writer = new StringWriter();
            PrintWriter printWriter=new PrintWriter(writer);

            e.printStackTrace(printWriter);
            writer.close();
            printWriter.close();
            logModel.setErrorTrace(writer.toString());

            //            LOGGER.error("Method Got Error: ",e);
            throw e;
        }
        return value;
    }

}
