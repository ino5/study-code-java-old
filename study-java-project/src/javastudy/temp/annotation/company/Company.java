package javastudy.temp.annotation.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 클래스에 사용 가능
@Retention(RetentionPolicy.RUNTIME) // 런타임 시에도 사용 가능
public @interface Company { // @interface로 어노테이션 선언
	String name() default "ABC"; // 어노테이션을 사용할 때 name 값을 String으로 지정할 수 있고 지정하지 않으면 기본 값은 "ABC"이다.
	String city() default "XYZ"; // 어노테이션을 사용할 때 city 값을 String으로 지정할 수 있고 지정하지 않으면 기본 값은 "XYZ"이다.
}
