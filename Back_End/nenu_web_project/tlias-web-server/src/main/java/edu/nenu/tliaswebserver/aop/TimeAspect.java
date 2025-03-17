package edu.nenu.tliaswebserver.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class TimeAspect {

    /**
     * execution表达式语法：execution([访问修饰符] 返回值 [包名.类名].方法名(方法参数) [throws 异常])
     * [] 中的内容可省略
     * 可用 || 或 && 对两个execution进行拼接
     * -- * 代表可省略的单个任意符号 -- .. 代表任意多个连续任意符号
     * ========================================================
     * annotation可将使用了改注解的都加入切片管理
     * 如果是@Before @AfterReturning @AfterThrowing
     * 传入的对象类型需要是JoinPoint是ProceedingJoinPoint的父类
     */
    // 指定范围 service包下的所有方法
    // @Around("execution(* edu.nenu.tliaswebserver.service.DeptService.deptList()) ||execution(* edu.nenu.tliaswebserver.service.DeptService.delete(*))")
    @Around("@annotation(edu.nenu.tliaswebserver.aop.MyLog)")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 获取目标对象类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        log.info("className:{}",className);
        // 获取目标签名方法名
        String signatureName  = proceedingJoinPoint.getSignature().getName();
        log.info("signatureName:{}",signatureName);
        // 获取目标运行参数
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("运行参数:{}", Arrays.toString(args));
        // 记录开始执行的时间
        long begin = System.currentTimeMillis();

        // 动态代理 调用对应的方法 放行
        Object result = proceedingJoinPoint.proceed();

        // 记录执行结束时间
        long end = System.currentTimeMillis();

        // 给方法返回结果 获取目标方法签名
        log.info(proceedingJoinPoint.getSignature() + "执行时长{}", end - begin);
        return result;
    }

}
