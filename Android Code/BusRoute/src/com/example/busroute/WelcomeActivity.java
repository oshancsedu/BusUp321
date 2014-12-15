package com.example.busroute;

import java.util.ArrayList;
import java.util.HashMap;


import com.example.controller.Provider;
import com.example.controller.HttpConnection;
import com.example.domain.StandsDetail;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.android.gms.maps.model.LatLng;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class WelcomeActivity extends Activity {

	private final static String URL = "http://192.168.103.1:8084/CityBusRoute/JSONUpdateController";
	private static String name="",stand="",source="",destination="";
	private static String[] BusName= new String[200];
	private static String[] BusStand= new String[200];
	private static String[] Color=new String[200];
	private ListView BusListView;
	private static int numOfBus=0;
	private ArrayList<StandsDetail> Stand = new ArrayList<StandsDetail>();
	private ArrayList<ArrayList <LatLng>> allBusRoute = new ArrayList<ArrayList <LatLng>>();
	private HashMap<String, Integer> StandMap= new HashMap<String, Integer>();
	
	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		ImageView player = (ImageView) findViewById(R.id.player);
		player.setImageResource(R.drawable.frameanim);
		AnimationDrawable anim = (AnimationDrawable) player.getDrawable();
		anim.start();
		
		new MyAsyncTask().execute();
	}

	private class MyAsyncTask extends AsyncTask <String,String,String> {

		@Override
		protected String doInBackground(String... params) {
			String result = null;
			try {
				HttpConnection http = new HttpConnection();
				result = http.readUrl(URL);
			} catch (Exception e) {
				Log.d("Background Task", e.toString());
			}
			
			try{
				Log.i("Result",result);
				
				/*if(result.equalsIgnoreCase(""))
				Toast.makeText(WelcomeActivity.this, "Check your internet", Toast.LENGTH_LONG).show();
					*/
					
				JSONObject RootjsonObject = new JSONObject(result);
				
				JSONObject jBusStandObject = RootjsonObject.getJSONObject("Stand Detail");
				JSONArray jBusStandArray = jBusStandObject.optJSONArray("Stand");
				for(int i = 0; i < jBusStandArray.length(); i++){
					JSONObject jsonChildNode = jBusStandArray.getJSONObject(i);
					String name = jsonChildNode.getString("name");
					double latUp = jsonChildNode.getDouble("latUp");
					double latDown = jsonChildNode.getDouble("latDown");
					double longUp = jsonChildNode.getDouble("longUp");
					double longDown = jsonChildNode.getDouble("longDown");
					StandsDetail std = new StandsDetail(name, latUp, latDown, longUp, longDown);
					Stand.add(std);
					StandMap.put(name, i);
				}
				
				JSONObject jBusNameObject = RootjsonObject.getJSONObject("Bus Name");
				JSONArray jBusNameArray = jBusNameObject.optJSONArray("BusName");
				numOfBus = jBusNameArray.length();
				for(int i = 0; i < numOfBus; i++){
				JSONObject jsonChildNode = jBusNameArray.getJSONObject(i);
				BusName[i] = jsonChildNode.optString("name").toString();
				Color[i] = jsonChildNode.optString("color").toString();
				name += jsonChildNode.optString("name").toString()+"\n";
				}
				
				JSONObject jStandObject = RootjsonObject.getJSONObject("Stand of Each Bus");
				JSONArray jStandArray = jStandObject.optJSONArray("Bus Stands");
				for(int i = 0; i < numOfBus; i++) {
				JSONObject jOneBusStandObject = jStandArray.optJSONObject(i);
				jOneBusStandObject = jOneBusStandObject.getJSONObject(BusName[i]);
				JSONArray jsonMainNode = jOneBusStandObject.optJSONArray("Stands");
				
				stand="Stopage: ";
				ArrayList<LatLng> latlng = new ArrayList<LatLng>();
				for(int j = 0; j < jsonMainNode.length(); j++) {
					JSONObject jsonChildNode = jsonMainNode.getJSONObject(j);
					String check = jsonChildNode.optString("name").toString();
					if(!check.equalsIgnoreCase("")) {
						if(stand.length()>10)
							stand+=", ";
					stand += jsonChildNode.optString("name").toString();
				    }
					latlng.add(new LatLng(jsonChildNode.optDouble("lat"), jsonChildNode.optDouble("long")));
				}
				allBusRoute.add(latlng);
				BusStand[i] = stand;
			}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			Provider provider=Provider.getProvider();
			provider.setBusName(BusName);
			provider.setBusStand(BusStand);
			provider.setNumOfBus(numOfBus);
			provider.setStand(Stand);
			provider.setStandMap(StandMap);
			provider.setColor(Color);
			provider.setAllBusRoute(allBusRoute);
			provider.setViewMmap(true);
			Intent intent= new Intent(WelcomeActivity.this,TabLocalActivity.class);
			Log.i("Post"," "+numOfBus);
			if(numOfBus==0){
				Thread timer = new Thread() {
					public void run() {
						try {
							sleep(4000);
						} catch (InterruptedException e) {

						} finally {
							finish();
						}
					}
				};
				Toast.makeText(WelcomeActivity.this, "No internet connection.Please connect to interner", Toast.LENGTH_LONG).show();
				timer.start();
			}
			else
			startActivity(intent);
		}
	}
}