package com.hemangnh18.infiniteservice;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    APIService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = Client.getClient("https://fcm.googleapis.com/").create(APIService.class);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data data = new Data("",R.drawable.ic_launcher_background,"Hemang: HELOOOOOO","New Message","");
                Sender sender = new Sender(data, "c_tBgkKI1Ng:APA91bFR8mbYf6Igl7rzdL_N6zxCbXfZy35KLSJGOcD3inQAPLJRE0NkS3dOJ0p611F2kWzLtgzFUXkCSBe7C1paAGRjWxCnBGdU6rxETfrKmU5lUT7pge0VonK9drjmYzXFWr8bnkp0");
                apiService.sendNotification(sender).enqueue(new Callback<MyResponse>() {
                    @Override
                    public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                        if(response.code()==200)
                        {
                            if(response.body().success!=1)
                            {
                                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MyResponse> call, Throwable t) {

                    }
                });
            }
        });


    }

}
