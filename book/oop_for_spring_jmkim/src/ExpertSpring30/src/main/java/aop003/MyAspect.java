package aop003;

// import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	@Before("execution(* runSomething())")
	public void before(JoinPoint joinPoint) {
		System.out.println("�� �ν� Ȯ��: ���� �����϶�");
		// System.out.println("����� ���� ���� ���� ����.");
	}
}
