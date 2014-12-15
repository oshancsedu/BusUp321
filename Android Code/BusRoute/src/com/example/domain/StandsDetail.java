package com.example.domain;

public class StandsDetail {

	String StandName;
	double latUp,latDown,longUp,longDown;
	
	public double getLatUp() {
		return latUp;
	}

	public double getLatDown() {
		return latDown;
	}

	public double getLongUp() {
		return longUp;
	}

	public double getLongDown() {
		return longDown;
	}

	public String getStandName() {
		return StandName;
	}

	public void setStandName(String standName) {
		StandName = standName;
	}

	public StandsDetail(String StandName,double latUp,double latDown,double longUp,double longDown) {
		this.StandName=StandName;this.latUp=latUp;this.latDown=latDown;this.longDown=longDown;this.longUp=longUp;
	}
	
	public StandsDetail(){}
}