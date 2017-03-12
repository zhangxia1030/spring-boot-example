package com.zx.interceptor;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.NativeWebRequest;

/** 
 * 1、通过@ControllerAdvice注解可以将对于控制器的全局配置放在同一个位置。
 * 2、注解了@Controller的类的方法可以使用@ExceptionHandler、@InitBinder、@ModelAttribute注解到方法上。
 * 3、@ControllerAdvice注解将作用在所有注解了@RequestMapping的控制器的方法上。
 * 4、@ExceptionHandler：用于全局处理控制器里的异常。
 * 5、@InitBinder：用来设置WebDataBinder，用于自动绑定前台请求参数到Model中。
 * 6、@ModelAttribute：本来作用是绑定键值对到Model中，此处让全局的@RequestMapping都能获得在此处设置的键值对
 * 
 * @author zx
 * @date 2017-03-10
 */
@ControllerAdvice
public class GlobalControllerInterceptor 
{
	@ModelAttribute
	//应用到所有@RequestMapping注解方法
	//此处将键值对添加到全局，注解了@RequestMapping的方法都可以获得此键值对
    public void addUser(Model model) { 
		model.addAttribute("msg", "此处将键值对添加到全局，注解了@RequestMapping的方法都可以获得此键值对");
    }  
  
    @InitBinder  
    //应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
    //用来设置WebDataBinder，用于自动绑定前台请求参数到Model中。
    public void initBinder(WebDataBinder binder) {  
    }  
  
    @ExceptionHandler(Exception.class)  
    //应用到所有@RequestMapping注解的方法，在其抛出Exception异常时执行
    //定义全局异常处理，value属性可以过滤拦截条件，此处拦截所有的Exception
    public String processUnauthenticatedException(NativeWebRequest request, Exception e) {  
        return "error"; //返回一个逻辑视图名  
    }  
}
