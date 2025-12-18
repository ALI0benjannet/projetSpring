package org.esprim.gestionfoyer.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectProcess {
    @Before("execution(* org.esprim.gestionfoyer.services.*.*(..))")
    public void logMothodEntry (JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("***** In method " + name + " : ");
    }

    @After("execution(* org.esprim.gestionfoyer.services.*.*(..))")
    public void logMothodExit (JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("***** Exiting method " + name + " : ");
    }

    @Around("execution(* org.esprim.gestionfoyer.services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            Object obj = pjp.proceed();
            return obj;
        }finally {
            long endTime = System.currentTimeMillis()-startTime;
            String methodName = pjp.getSignature().getName();
            log.info("***** Method " + methodName + " : " + endTime + " ms");
        }
    }

}
