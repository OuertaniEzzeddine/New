package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.AboutEvent.DTO.FactureDTO;
import com.example.demo.AboutEvent.Models.Event;
import com.example.demo.AboutEvent.Models.Rapport;

import java.util.List;



@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.demo.AboutEvent.Service.EventServiceImpl.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method execution started: {}", joinPoint.getSignature());
    }

    @AfterThrowing(pointcut = "execution(* com.example.demo.AboutEvent.Service.EventServiceImpl.*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("Exception occurred in method: {}", joinPoint.getSignature());
        logger.error("Exception message: {}", exception.getMessage());
    }

    @Around("execution(* com.example.demo.AboutEvent.Service.EventServiceImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Before method invocation: {}", joinPoint.getSignature());

        Object returnValue;
        try {
            returnValue = joinPoint.proceed();
        } catch (Exception e) {
            logger.error("Exception occurred in method: {}", joinPoint.getSignature());
            logger.error("Exception message: {}", e.getMessage());
            throw e; 
        }

        logger.info("After method invoked: {}", joinPoint.getSignature());
        if (returnValue instanceof Rapport) {
            logger.info("Return value is a Rapport: {}", joinPoint.getArgs()[0]);
        } else if (returnValue instanceof Event) {
            logger.info("Return value is an Event: {}", joinPoint.getArgs()[0]);
        }

        if (returnValue instanceof List) {
            logger.info("Method execution completed: {}", joinPoint.getSignature());
            logger.info("Return value is a List: {}", returnValue);
        } else {
            logger.info("Method execution completed: {}", joinPoint.getSignature());
            logger.info("Return value is not a List");
        }

        return returnValue;
    }

}
