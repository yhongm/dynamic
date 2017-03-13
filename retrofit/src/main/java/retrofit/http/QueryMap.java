package retrofit.http;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(PARAMETER)
@Retention(RUNTIME)
public @interface QueryMap {
  /** Specifies whether parameter names and values are already URL encoded. */
  boolean encoded() default false;
}
