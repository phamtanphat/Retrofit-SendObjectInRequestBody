package com.example.administrator.retrofit_sendobjectinrequestbody;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btnsendobject;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsendobject = (Button) findViewById(R.id.buttonsendobject);
        user = new User("phat","phatdroid@gmail.com",11,new String[]{"android","php"});
        sendobjectdata();
    }

    private void sendobjectdata() {
        OkHttpClient.Builder okhttp = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                                .baseUrl("http://192.168.2.64/test.php")
                                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.client(okhttp.build()).build();
        UserClient userClient = retrofit.create(UserClient.class);
        Call<User> userCall = userClient.createUser(user);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this, "Yeah! User-ID" + response.body().getId(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
