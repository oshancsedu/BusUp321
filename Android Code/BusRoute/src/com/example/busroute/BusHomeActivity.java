package com.example.busroute;

import java.util.ArrayList;
import java.util.List;


import com.example.controller.Provider;
import com.example.controller.HttpConnection;
import com.example.domain.StandsDetail;

import com.google.android.gms.maps.model.LatLng;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class BusHomeActivity extends Activity implements OnClickListener {

	private Button btGetBus;
	private Spinner spSource, spDestination;
	private List list = new ArrayList();
	private Provider provider;
	private ArrayList<StandsDetail> tempStand;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		addItemOnSource();
		addItemOnDestination();
	}

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void init() {
		btGetBus = (Button) findViewById(R.id.btGetBus);
		btGetBus.setOnClickListener(this);
		spSource = (Spinner) findViewById(R.id.spSource);
		spDestination = (Spinner) findViewById(R.id.spDestination);
		provider= Provider.getProvider();
		tempStand= new ArrayList<StandsDetail>();
		tempStand= provider.getStand();
		for(int i = 0; i < tempStand.size(); i++)
			list.add(tempStand.get(i).getStandName());
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		intent = new Intent(this, GetMyBusActivity.class);
		intent.putExtra("source",spSource.getSelectedItem().toString());
		intent.putExtra("destination",spDestination.getSelectedItem().toString());
		startActivity(intent);
	}
	
	private void addItemOnDestination() {
		ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spDestination.setAdapter(dataAdapter);
	}

	private void addItemOnSource() {
		ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spSource.setAdapter(dataAdapter);
	}
}