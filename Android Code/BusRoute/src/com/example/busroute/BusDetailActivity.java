package com.example.busroute;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.android.gms.maps.model.LatLng;

import com.example.controller.Provider;
import com.example.controller.HttpConnection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class BusDetailActivity extends Activity {

	private ListView BusListView;
	private static String source = "", destination = "";
	private ArrayList<LatLng> test = new ArrayList<LatLng>();
	private Provider provider;
	private HashMap<Integer, Integer> MapBuslist;
	private boolean gettingBus, viewMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_bus_name);
		BusListView = (ListView) findViewById(R.id.lvShowBus);
		gettingBus=false;
		BusListView.setAdapter(new BusAdapter (BusDetailActivity.this, source, destination) );
		if(!source.equalsIgnoreCase(""))
			gettingBus=true;
		source = "" ;
		destination = "";
		
		BusListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				provider=Provider.getProvider();
				if(provider.isViewMmap()) {
					Intent intent = new Intent(BusDetailActivity.this, GmapActivity.class);
					if(gettingBus) {
						MapBuslist = provider.getMapBuslist();
						position = MapBuslist.get(position);
					}
					intent.putExtra("index", position);
					startActivity(intent);
				}
			}
        });
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public void setDestination(String destination){
		this.destination = destination;
	}
}