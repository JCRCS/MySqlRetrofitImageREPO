package com.example.sanros.mysqlretrofitimagerepo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sanros on 7/08/17.
 */

public class ImageClass {


    @SerializedName("title")
    private String Title;

    @SerializedName("image")
    private String Image;

    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }
}
