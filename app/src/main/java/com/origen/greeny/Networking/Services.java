package com.origen.greeny.Networking;

import com.origen.greeny.Model.DetailModel;
import com.origen.greeny.Model.HomeModel;
import com.origen.greeny.Model.IotModel;
import com.origen.greeny.Model.MyGardenModel;
import com.origen.greeny.Model.SearchModel;
import com.origen.greeny.Model.WeatherModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Services {

    @Headers("Content-Type: application/json")
    @GET("api/greenyapi/mainpage.php")
    Call<List<HomeModel>> getMainList();

    @Headers("Content-Type: application/json")
    @GET("api/greenyapi/weather.php")
    Call<WeatherModel> getWeather();

    @Headers("Content-Type: application/json")
    @GET("api/greenyapi/mygarden.php")
    Call<List<MyGardenModel>> getMyGarden();

    @Headers("Content-Type: application/json")
    @GET("api/greenyapi/iot.php")
    Call<List<IotModel>> getMyIots();




    @Headers("Content-Type: application/json")
    @POST("api/greenyapi/search.php")
    Call<List<SearchModel>> search(@Body String s);

    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("api/greenyapi/detail.php")
    Call<DetailModel> detail(@Field("id") String id);


}
