package com.alexdhenry.pantheon;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

//This simply populates all the PantheonLists that exist. A method will have to be implemented
//to populate each list itself.
public class DisplayLists extends Activity {
	ArrayList<PantheonList> plists = new ArrayList<PantheonList>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.fillList();
		
		//Display Toast for testing purposes
		Toast.makeText(this, plists.toString(), Toast.LENGTH_LONG).show();
	}
	
	//Queries the sql server and fills the PantheonList with what is there
	public void fillList() {
		String result = "";

		/*
		//the year data to send
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("year","1980"));
		*/
	
		//http post
		try{
		        HttpClient httpclient = new DefaultHttpClient();
		        HttpPost httppost = new HttpPost("http://localhost/getmovies.php");
		        //httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        HttpResponse response = httpclient.execute(httppost);
		        HttpEntity entity = response.getEntity();
		        InputStream is = entity.getContent();
		        
		        //convert response to string
		        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
		        StringBuilder sb = new StringBuilder();
		        String line = null;
		        while ((line = reader.readLine()) != null) {
		        	sb.append(line + "\n");		                
		        }
		        is.close();
		        result = sb.toString();
		        
		}catch(Exception e){
		        Log.e("log_tag", "Error converting result "+e.toString());
		}
	
		//parse json data
		try{
		        JSONArray jArray = new JSONArray(result);
		        for (int i = 0; i < jArray.length(); i++){		        	
		                JSONObject json_data = jArray.getJSONObject(i);
		                Log.i("log_tag","name: " + json_data.getString("name"));
		                
		                //Create a new PantheonList from the data and add it to the pop
		                plists.add(new PantheonList(json_data.getString("name")));
		        }
		} catch(JSONException e){
		        Log.e("log_tag", "Error parsing data " + e.toString());
		}
	}
	
	
}
