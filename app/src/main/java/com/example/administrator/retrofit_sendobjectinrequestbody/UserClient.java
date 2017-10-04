package com.example.administrator.retrofit_sendobjectinrequestbody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Administrator on 10/4/2017.
 */

public interface UserClient {
    @POST("user")
    Call<User> createUser(@Body User user);
}
