package com.example.cambus;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NotionApiService {
    @Multipart
    @POST("notion/") // Django API URL
    Call<Notion> uploadNotice(
            @Part("title") String title,
            @Part("content") String content,
            @Part MultipartBody.Part image
    );
    @GET("notion/")
    Call<List<Notion>> getNotions();

    @GET("notion/{notionId}/")
    Call<Notion> getNotice(@Path("notionId") int notionId);

    @Multipart
    @POST("product/") // Replace with actual server endpoint
    Call<Notion> uploadProduct(
            @Part("productTitle") String productTitle,
            @Part("productContent") String productContent,
            @Part("productPrice") MultipartBody.Part productPrice,
            @Part("productOption") String productOption,
            @Part String Image
    );

    @GET("product/")
    Call<List<Notion>> getProduct();

}