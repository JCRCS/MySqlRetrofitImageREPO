package com.example.sanros.mysqlretrofitimagerepo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sanros on 7/08/17.
 */

public class ApiClient {

    public static final String Base_Url = "http://192.168.0.17/TigoApp/imageupload/";
    public static Retrofit retrofit;

    public static  Retrofit getApiClient()
    {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder().baseUrl(Base_Url).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
