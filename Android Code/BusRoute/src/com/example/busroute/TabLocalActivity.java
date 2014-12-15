package com.example.busroute;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabLocalActivity extends TabActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("Tab", "Tab");
		setContentView(R.layout.tab);
		TabHost tabhost= getTabHost();
		tabhost.setup();
		
		TabSpec scoresp=tabhost.newTabSpec("bus_detail");
		scoresp.setIndicator(getSpan("Bus Detail"));
		Intent scoreIntent=new Intent(TabLocalActivity.this,BusDetailActivity.class);
		scoresp.setContent(scoreIntent);
		
		TabSpec resultsp=tabhost.newTabSpec("get_my_bus");
		resultsp.setIndicator(getSpan("Get My Bus"));
		Intent resultIntent=new Intent(TabLocalActivity.this,BusHomeActivity.class);
		resultsp.setContent(resultIntent);
	
		tabhost.addTab(scoresp); 
        tabhost.addTab(resultsp);
	}
	
	private Spannable getSpan(String str) {
		Spannable span = new SpannableString(str);
		span.setSpan(new RelativeSizeSpan(1.5f), 0, span.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return span;
	}
}