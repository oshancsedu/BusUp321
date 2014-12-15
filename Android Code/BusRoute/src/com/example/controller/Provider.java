package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.domain.StandsDetail;
import com.google.android.gms.maps.model.LatLng;

import android.util.Log;
import android.widget.ListView;

public class Provider {

	private static String[] BusName= new String[200];
	private static String[] BusStand= new String[200];
	private static String[] Color= new String[200];
	private static int numOfBus;
	private boolean viewMmap;
	private ArrayList<StandsDetail> Stand = new ArrayList<StandsDetail>();
	private ArrayList<ArrayList <LatLng>> allBusRoute= new ArrayList<ArrayList <LatLng>>();
	private HashMap<String, Integer> StandMap= new HashMap<String, Integer>();
	private HashMap<Integer, Integer> MapBuslist= new HashMap<Integer, Integer>();
	private volatile static Provider provider;
	
	public ArrayList<ArrayList <LatLng>> getAllBusRoute() {
		return allBusRoute;
	}

	public void setAllBusRoute(ArrayList<ArrayList <LatLng>> busRoute) {
		this.allBusRoute=busRoute;
	}

	private Provider(){}

	public static Provider getProvider() {
        if(provider==null) {
            synchronized(Provider.class) {
                if(provider==null)
                    provider =new Provider();
            }
        }
        return provider;
    }
	
	
	public static String[] getBusName() {
		return BusName;
	}

	public static String[] getBusStand() {
		return BusStand;
	}

	public static int getNumOfBus() {
		return numOfBus;
	}

	public static void setBusName(String[] busName) {
		BusName = busName;
	}

	public static void setBusStand(String[] busStand) {
		BusStand = busStand;
	}

	public static void setNumOfBus(int numOfBus) {
		Provider.numOfBus = numOfBus;
	}

	public ArrayList<StandsDetail> getStand() {
		return Stand;
	}

	public HashMap<String, Integer> getStandMap() {
		return StandMap;
	}

	public void setStand(ArrayList<StandsDetail> stand) {
		Stand = stand;
	}

	public void setStandMap(HashMap<String, Integer> standMap) {
		StandMap = standMap;
	}
	
	public HashMap<Integer, Integer> getMapBuslist() {
		return MapBuslist;
	}

	public void setMapBuslist(HashMap<Integer, Integer> mapBuslist) {
		MapBuslist = mapBuslist;
	}

	public static String[] getColor() {
		return Color;
	}

	public static void setColor(String[] color) {
		Color = color;
	}

	public boolean isViewMmap() {
		return viewMmap;
	}

	public void setViewMmap(boolean viewMmap) {
		this.viewMmap = viewMmap;
	}
	
}