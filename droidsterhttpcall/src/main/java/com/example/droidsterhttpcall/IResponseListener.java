package com.example.droidsterhttpcall;

/**
 * Created by Piyush on 28-12-2017.
 */
public interface IResponseListener {
    void onSuccess(String success, String type);

    void onError(String error);

}
