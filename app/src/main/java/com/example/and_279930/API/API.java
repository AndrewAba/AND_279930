package com.example.and_279930.API;

import com.example.and_279930.Model.Dice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("json/d4")
    Call<List<Dice>> getD4();

    @GET ("/json/d6")
    Call<List<Dice>> getD6();

    @GET("/json/d8")
    Call<List<Dice>> getD8();

    @GET("/json/d10")
    Call<List<Dice>> getD10();

    @GET("/json/d12")
    Call<List<Dice>> getD12();

    @GET("/json/d20")
    Call<List<Dice>> getD20();

    @GET("/json/d100")
    Call<List<Dice>> getD100();

}
