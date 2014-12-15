package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;


import com.example.controller.Provider;
import com.example.controller.HttpConnection;
import com.example.domain.StandsDetail;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

public class DecodeStands {

	private String stand, temp;
	private int index, StandIndex;
	private String Stands[]=new String[30];
	private ArrayList<StandsDetail> StandPosition = new ArrayList<StandsDetail>();
	private HashMap<String, Integer> StandMap = new HashMap<String, Integer>();
	private ArrayList<LatLng> StandLatlng = new ArrayList<LatLng>();
	private Provider provider;
	
	public ArrayList<LatLng> getLatLong(String stand) {
		provider = Provider.getProvider();
		StandPosition = provider.getStand();
		StandMap = provider.getStandMap();
		this.stand = stand;
		stand = stand.substring(9)+", ";
		
		for(int i = 0; stand.length() > 1; i++) {
			index = stand.indexOf(",");
			Stands[i] = stand.substring(0, index);
			stand = stand.substring(index+2);
			StandIndex = StandMap.get(Stands[i]);
			StandsDetail standsDetail = new StandsDetail();
			standsDetail = StandPosition.get(StandIndex);
			StandLatlng.add(new LatLng(standsDetail.getLatUp(),standsDetail.getLongUp()));
		}
		return StandLatlng;
	}

	public String[] getStand() {
		return Stands;
	}
}
