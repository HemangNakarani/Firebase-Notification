package com.hemangnh18.infiniteservice;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers(

            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAMtbu3zI:APA91bH3pSu4UeoPgeOPq-zkcAm68V0Rr6tLT7qIF8J66N8TqrY0xtNYJynlkEbzh2pHhJ-KzhaIiEbA289TTwIwNbetLFFOaRmPXHuJoP1uxF7y3rlWu1VJ5R-AA5OW6tMryq8T9VP3"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);


}
