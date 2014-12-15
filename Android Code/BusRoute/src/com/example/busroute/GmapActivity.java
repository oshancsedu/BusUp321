package com.example.busroute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.example.controller.*;

import org.json.JSONObject;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.app.Activity;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

public class GmapActivity extends FragmentActivity {
	private GoogleMap map;
	private LatLng latLng;
	private String BusName[] = new String[200];
	private String BusStand[] = new String[200];
	private String Stand[] = new String[40];
	private ArrayList<LatLng> StandLatlng = new ArrayList<LatLng>();
	private ArrayList<ArrayList <LatLng>> allBusRoute = new ArrayList<ArrayList <LatLng>>();
	private ArrayList<LatLng> busRoute = new ArrayList<LatLng>();
	private String LatLongurl;
	private Location myLocation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gmap);
		int index = getIntent().getExtras().getInt("index");
		Provider provider = Provider.getProvider();
		BusName = provider.getBusName();
		BusStand = provider.getBusStand();
		allBusRoute = provider.getAllBusRoute();
		busRoute = allBusRoute.get(index);
		DecodeStands decoder = new DecodeStands();
		StandLatlng = decoder.getLatLong(BusStand[index]);
		Stand = decoder.getStand();
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		try{
			initialize();
			addRoute();
			Criteria criteria = new Criteria();
			String provide = locationManager.getBestProvider(criteria, true);
			myLocation = locationManager.getLastKnownLocation(provide);
			moveCamera();
			addMarkers();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void moveCamera() {
		double latitude = myLocation.getLatitude();
		double longitude = myLocation.getLongitude();
		latLng = new LatLng(latitude, longitude);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20.0f));
	}

	private void addMarkers() {
		MarkerOptions marker = new MarkerOptions();
		marker.icon( BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN) );
		for(int i = 0; i < StandLatlng.size(); i++) {
			marker.position(StandLatlng.get(i)).title(Stand[i]);map.addMarker(marker);
		}
	}

	private void addRoute() {
	map.addPolyline((new PolylineOptions()).addAll(busRoute).width(5).color(Color.DKGRAY).geodesic(true));
	}

	private void initialize() {
		
		if (map == null) {
			map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(
					R.id.gMap)).getMap();
			map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
			map.setMyLocationEnabled(true);
			map.getUiSettings().setZoomControlsEnabled(true);
			map.getUiSettings().setMyLocationButtonEnabled(true);
			map.getUiSettings().setCompassEnabled(true);
			map.getUiSettings().setRotateGesturesEnabled(true);
			map.getUiSettings().setZoomGesturesEnabled(true);
			if (map == null) {
				Toast.makeText(getApplicationContext(), "Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
			}
		}
	}
}