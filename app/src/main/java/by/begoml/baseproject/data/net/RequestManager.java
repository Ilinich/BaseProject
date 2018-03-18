package by.begoml.baseproject.data.net;

import android.content.Context;
import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import by.begoml.baseproject.data.exception.BaseResponseException;
import by.begoml.baseproject.data.exception.NoConnectionException;
import by.begoml.baseproject.system.di.ApplicationContext;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ilinich on 18.03.2018.
 */

public class RequestManager {

    private final static int CONNECT_TIMEOUT = 30;

    private static Retrofit retrofit = null;
    private final static String HOST_API = "http://www.mocky.io";


    private OkHttpClient okHttpClient;

    public RequestManager(@ApplicationContext Context context) {
        this.okHttpClient = createOkHttpClient(context);
    }

    public OkHttpClient createOkHttpClient(Context context) {
        OkHttpClient.Builder httpClient = getHttpClient(context);

        //Add headers
        httpClient.interceptors().add(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Content-Type", "application/json")
                    .build();

            return chain.proceed(request);
        });
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(interceptor);

        return httpClient.build();
    }

    private OkHttpClient.Builder getHttpClient(Context context) {
        return new OkHttpClient().newBuilder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new ErrorInterceptor(context));
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public RestApi getClient() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.baseUrl(HOST_API);
        builder.client(getOkHttpClient());
        return builder.build().create(RestApi.class);
    }

    private static class ErrorInterceptor implements Interceptor {
        private Context context;
        private ErrorInterceptor(Context context) {
            this.context = context;
        }

        @Override
        public Response intercept(@NonNull Chain chain) throws BaseResponseException {
            if (!NetworkUtils.isOnline(context)) {
                throw new NoConnectionException();
            } else {
                try {
                    Request request = chain.request();
                    Response response = chain.proceed(request);
                    ResponseBody responseBody = response.body();

                    if (responseBody != null) {
                        return getResponse(response, responseBody, responseBody.string());
                    } else {
                        throw new BaseResponseException(BaseResponseException.ERR_CONNECT_NO_DATA);
                    }
                } catch (SocketTimeoutException | EOFException e) {
                    throw new BaseResponseException(BaseResponseException.ERR_CONNECT_TIME_OUT_CODE);
                } catch (BaseResponseException e) {
                    throw e;
                } catch (IOException e) {
                    throw new BaseResponseException(BaseResponseException.ERR_CONNECT_CODE);
                }
            }
        }
    }

    private static Response getResponse(Response response, ResponseBody responseBody, String responseBodyString) {
        MediaType contentType = responseBody.contentType();
        return response.newBuilder().body(ResponseBody.create(contentType, responseBodyString)).build();
    }

}
