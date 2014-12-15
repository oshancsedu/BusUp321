package com.example.busroute;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class GetMyBusActivity extends BusDetailActivity {

	private String source;
	private String destination;
	
	protected void onCreate(Bundle savedInstanceState) {

		source = getIntent().getExtras().getString("source");
		destination = getIntent().getExtras().getString("destination");
		super.setSource(source);
		super.setDestination(destination);
		super.onCreate(savedInstanceState);
	}
}
