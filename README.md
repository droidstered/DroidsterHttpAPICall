# DroidsterHttpAPICall

#### Step 1. Add it in your root build.gradle at the end of repositories:

    allprojects {
  
  	repositories {
			...
			maven { url 'https://jitpack.io' }
		}
    
	}
  
#### Step 2. Add the dependency
 
    dependencies {
	    compile 'com.github.droidstered:DroidsterHttpAPICall:1.1'
	}
	
 Now before access method of this class you must initialize **BaseAsyncHttpRequest** in your **Application** class otherwise it will throw error.
	
	
	  BaseAsyncHttpRequest.init(getApplicationContext());
	
	
After initialize your class you can use method for your API call in your activity class by,

	 BaseAsyncHttpRequest.executeRequest(this,"Your url", new RequestParams(), new IResponseListener() {
            @Override
            public void onSuccess(String success,String response_type) {
                //response_type can be json array or json object

                Log.v("Response",success +" ::: "+response_type);

            }

            @Override
            public void onError(String error) {

            }
        },true);
	
In **executeRequest** method , you must pass your activity context , host url , your requested parameters and callback for getting status of your response.

If you want to pass **String** or **Integer** data type as a parameters then you can use,

       RequestParams params = new RequestParams();
       params.put("your_key","string_value");   // same as for Integer.
       
 Then pass params to **executeRequest** method,
 
        BaseAsyncHttpRequest.executeRequest(this,"Your url", params, new IResponseListener() {
            @Override
            public void onSuccess(String success,String response_type) {
                //response_type can be json array or json object

                Log.v("Response",success +" ::: "+response_type);

            }

            @Override
            public void onError(String error) {

            }
        },true);
       
  If you want to send image or video file to your server then you can use 
  
        RequestParams params = new RequestParams();
	        try {
                	params.put("file_name",new File(filepath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
       
At last, if you want to show Progress bar then you must pass **true** as a parameters and if you don't want to show it then you must pass it to **false**;
