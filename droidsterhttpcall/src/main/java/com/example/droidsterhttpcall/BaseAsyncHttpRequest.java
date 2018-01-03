package com.example.droidsterhttpcall;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.concurrent.atomic.AtomicBoolean;
import cz.msebera.android.httpclient.Header;

public class BaseAsyncHttpRequest {

    private static final AtomicBoolean initialized = new AtomicBoolean();

    public static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public BaseAsyncHttpRequest() {

    }

    public static void executeRequest(final Activity activity, String url, RequestParams requestParams, final IResponseListener iResponseListener, final boolean showprogressbarornot) {
        if (mContext == null) {
            throw new AssertionError("You must initialize BaseAsyncHttpRequest before use it.");
        }
        if(showprogressbarornot) {
            new ProgressBarHandler(activity);
        }
        if(TextUtils.isEmpty(url))
        {
            Toast.makeText(activity,"Your host URL can not be empty",Toast.LENGTH_LONG).show();
            return;
        }
        final AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(30000);
        Log.v(activity.getClass().getSimpleName() + " Params", requestParams.toString() + " Piyush");
        client.post(url, requestParams,
                new JsonHttpResponseHandler() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        if(showprogressbarornot) {
                            ProgressBarHandler.show(activity);
                        }
                    }
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if(showprogressbarornot) {
                            ProgressBarHandler.hide(activity);
                        }
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers,
                                          JSONObject response) {
                        if(showprogressbarornot) {
                            ProgressBarHandler.hide(activity);
                        }

                        if (iResponseListener != null) {
                            iResponseListener.onSuccess(response.toString(),"JSONObject");
                        }
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers,
                                          JSONArray response) {
                        // TODO Auto-generated method stub
                        super.onSuccess(statusCode, headers, response);


                        if(showprogressbarornot) {
                            ProgressBarHandler.hide(activity);
                        }

                        if (iResponseListener != null) {
                            iResponseListener.onSuccess(response.toString(),"JSONArray");
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers,
                                          Throwable throwable, JSONArray errorResponse) {
                        // TODO Auto-generated method stub
                        super.onFailure(statusCode, headers, throwable,
                                errorResponse);

                        if(showprogressbarornot) {
                            ProgressBarHandler.hide(activity);
                        }


                        if (iResponseListener != null) {
                            iResponseListener.onError("Error");
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers,
                                          Throwable throwable, JSONObject errorResponse) {
                        // TODO Auto-generated method stub

                        super.onFailure(statusCode, headers, throwable,
                                errorResponse);

                        if(showprogressbarornot) {
                            ProgressBarHandler.hide(activity);
                        }


                        if (iResponseListener != null) {
                            iResponseListener.onError("Error");
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        super.onFailure(statusCode, headers, responseString, throwable);

                        if(showprogressbarornot) {
                            ProgressBarHandler.hide(activity);
                        }

                        if (iResponseListener != null) {
                            iResponseListener.onError("Error");
                        }
                    }
                });
    }

}
