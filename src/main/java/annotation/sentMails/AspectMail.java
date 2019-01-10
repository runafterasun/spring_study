package annotation.sentMails;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AspectMail {
	
	private static int COUNTER = 0;
	
	@Autowired
	public EmailService emailService;

	@Pointcut("execution(* annotation.controller.HomeController.*(..))")
	public void WebService() {}
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void ControllersPointcat() {}
	
	
//	 @Around("WebService()")
//	  public Object logWebServiceCall(ProceedingJoinPoint thisJoinPoint) throws Throwable {
//		 	String methodName = thisJoinPoint.getSignature().getName();
//		    Object[] methodArgs = thisJoinPoint.getArgs();
//
//		    String message = "Simple message number " + COUNTER++;
//			 emailService.sendSimpleMessage(message); 
//
//		    Object result = thisJoinPoint.proceed();  
//		    return result;
//				 
//	  }
	 
	 @After("WebService() && ControllersPointcat()")
	  public void logWebServiceCall(){
		    String message = "Simple message number " + COUNTER++;
			emailService.sendSimpleMessage(message); 	 
	  }
}
