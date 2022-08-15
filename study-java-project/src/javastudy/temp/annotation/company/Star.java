package javastudy.temp.annotation.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD}) // 필드 또는 메소드에 어노테이션 사용 가능
@Retention(RetentionPolicy.RUNTIME) // 런타임 시에도 사용 가능
public @interface Star {
	int value() default 30;
}
