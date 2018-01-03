# DroidsterHttpAPICall

Step 1. Add it in your root build.gradle at the end of repositories:

  allprojects {
  
  	repositories {
			...
			maven { url 'https://jitpack.io' }
		}
    
	}
  
  Step 2. Add the dependency
 
  dependencies {
	    compile 'com.github.droidstered:DroidsterHttpAPICall:1.1'
	}
	
   In Applilcation class
	
	  BaseAsyncHttpRequest.init(getApplicationContext());
	
	
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
  
