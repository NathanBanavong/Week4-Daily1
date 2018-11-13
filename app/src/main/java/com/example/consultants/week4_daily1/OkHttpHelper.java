package com.example.consultants.week4_daily1;

import android.util.Log;

import com.example.consultants.week4_daily1.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpHelper {

    public static final String TAG = OkHttpHelper.class.getSimpleName() + "_TAG";
    List<Person> listPeople = new ArrayList<>();

    OkHttpClient client;

    public OkHttpHelper() {
        client = new OkHttpClient();
    }

    public void execute(String gender, String nationality) {

        String searchfilter = "?gender=" + gender + "&?nat=" + nationality + "&inc=gender,name,nat,dob&?results=20";

        //reference the Network Helper URL
        final Request request = new Request.Builder()
                .url(NetworkHelper.RANDOM_USER_URL + searchfilter)
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

//why newCall not working
                    String response = client.newCall(request).execute().body().string();
                    listPeople = RandomParser.parsePerson(response);

                    //pass the client request call (RandomParser) into an array list of people
//                    listPeople = client.newCall(request).execute();

                    Log.d(TAG, "execute: " + listPeople);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
