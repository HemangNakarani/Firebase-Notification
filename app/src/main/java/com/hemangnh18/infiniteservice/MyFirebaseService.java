package com.hemangnh18.infiniteservice;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.content.ContentValues.TAG;

public class MyFirebaseService extends FirebaseMessagingService
{
    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);


        String title= remoteMessage.getData().get("title");
        String body= remoteMessage.getData().get("body");

        Log.e(TAG,title+"    "+body);
        SendNoti sendNoti = new SendNoti(this,title,body);
        sendNoti.Send();

    }
}
