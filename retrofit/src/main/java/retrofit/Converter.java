package retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
public interface Converter<F, T> {
  T convert(F value) throws IOException;
  abstract class Factory {
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
        Retrofit retrofit) {
      return null;
    }
    public Converter<?, RequestBody> requestBodyConverter(Type type,
        Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
      return null;
    }
    public Converter<?, String> stringConverter(Type type, Annotation[] annotations,
        Retrofit retrofit) {
      return null;
    }
  }
}
