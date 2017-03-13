package retrofit.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public final class GsonConverterFactory extends retrofit.Converter.Factory {
  public static GsonConverterFactory create() {
    return create(new Gson());
  }

  public static GsonConverterFactory create(Gson gson) {
    return new GsonConverterFactory(gson);
  }

  private final Gson gson;

  private GsonConverterFactory(Gson gson) {
    if (gson == null) throw new NullPointerException("gson == null");
    this.gson = gson;
  }

  @Override
  public retrofit.Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                                   retrofit.Retrofit retrofit) {
    TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
    return new GsonResponseBodyConverter<>(gson, adapter);
  }

  @Override
  public retrofit.Converter<?, RequestBody> requestBodyConverter(Type type,
                                                                 Annotation[] parameterAnnotations, Annotation[] methodAnnotations, retrofit.Retrofit retrofit) {
    TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
    return new retrofit.converter.gson.GsonRequestBodyConverter<>(gson, adapter);
  }
}
