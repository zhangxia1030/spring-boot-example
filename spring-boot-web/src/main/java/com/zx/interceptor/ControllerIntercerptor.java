package com.zx.interceptor;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 拦截器：对controller层进行拦截
 * @author zx
 * @date 2017-03-10
 */
@Aspect
@Component
public class ControllerIntercerptor {
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerIntercerptor.class);
	
	
	/**
	 * 定义拦截规则：拦截com.zx.controller包下面的所有类中，有@RequestMapping注解的方法。
	 */
	@Pointcut("execution(* com.zx.controller..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void controllerMethodPointcut(){
	}
	
	@Before("controllerMethodPointcut()")
	public void before(JoinPoint joinPoint)
	{
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("================@before(controllerMethodPointcut())");
	}
	
	@After("controllerMethodPointcut()")
	public void After(JoinPoint joinPoint)
	{
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("================@After(controllerMethodPointcut())");
	}
	
	@Around("controllerMethodPointcut()")
	public Object Around(ProceedingJoinPoint joinPoint) throws Throwable
	{
		System.out.println(joinPoint.getSignature().getName());
		
		System.out.println("================@Around(controllerMethodPointcut())");
		
		return joinPoint.proceed();
	}
	
	/**
	 * 拦截器具体实现
	 * @param pjp
	 * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
	 */
	@Around("controllerMethodPointcut()") //指定拦截器规则；也可以直接把“execution(* com.zx.........)”写进这里
	public Object Interceptor(ProceedingJoinPoint pjp){
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod(); //获取被拦截的方法
		String methodName = method.getName(); //获取被拦截的方法名
		
		//Set<Object> allParams = new LinkedHashSet<>(); //保存所有请求参数，用于输出到日志中
		
		System.out.println("================@Around(controllerMethodPointcut())");
		
		Object result = null;

		Object[] args = pjp.getArgs();
		for(Object arg : args){
			System.out.println(arg);
		}
		
		// 一切正常的情况下，继续执行被拦截的方法
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}  
