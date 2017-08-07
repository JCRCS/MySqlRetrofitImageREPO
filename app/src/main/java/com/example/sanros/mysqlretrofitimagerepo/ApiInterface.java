package com.example.sanros.mysqlretrofitimagerepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by sanros on 7/08/17.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("upload.php")
    Call<ImageClass> uploadImage(@Field("title") String title,@Field("image") String image);
}
