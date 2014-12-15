package com.example.busroute;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.controller.Provider;
import com.example.controller.HttpConnection;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BusAdapter extends BaseAdapter {

		private ArrayList<SingleRow> busList;
		private LayoutInflater inflater;
		private Context context;
		private int numOfBus;
		private String source = "", destination= "";
		private static String[] BusName = new String[200];
		private static String[] BusStand = new String[200];
		private static String[] Color = new String[200];
		private ArrayList<Integer> onlySource, onlyDestination;
        private boolean GetBusFlag;
        private HashMap<Integer, Integer> MapBuslist;
    	
        public BusAdapter(Context c, String source, String destination) {
			busList = new ArrayList<SingleRow>();
			onlySource = new ArrayList<Integer>();
			onlyDestination = new ArrayList<Integer>();
			context = c;
			inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			Provider provider = Provider.getProvider();
			BusName = provider.getBusName();
			BusStand = provider.getBusStand();
			numOfBus = provider.getNumOfBus();
			Color = provider.getColor();
			setDestination(destination);
			setSource(source);
			GetBusFlag = false;
			MapBuslist = new HashMap<Integer, Integer>();
			
			if( !source.equals("") && !destination.equals("") ) {
				for(int i = 0, position = 0; i < numOfBus; i++) {
					if( check(BusStand[i], i) ) {
						busList.add(new SingleRow(BusName[i], BusStand[i], Color[i]));
						MapBuslist.put(position, i);
						position++;
						provider.setViewMmap(true);
						GetBusFlag = true;
					}
				}
				
				if( !GetBusFlag ) {
					LCS lcs = new LCS();
					provider.setViewMmap(false);
					MapBuslist = null;
					for(int i = 0; i < onlySource.size(); i++) {
				  		int src = onlySource.get(i);
				  		for(int j = 0; j < onlyDestination.size(); j++) {
				  			int dest = onlyDestination.get(j);
				  			Log.i("Source",BusStand[src].substring(9) );
				  			Log.i("destination",BusStand[dest].substring(9) );
				  		    String lcsString = lcs.longestCommonSubstring(BusStand[src].substring(9)+", ", BusStand[dest].substring(9)+", ");
				  		    Log.i("result", lcsString);
				  		    if( lcsString.length() > 5 ) {
				  		    	int index = lcsString.lastIndexOf(",");
				  		    	lcsString = lcsString.substring(0,index);
				  		    	index = lcsString.lastIndexOf(",", 5);
				  		    	if(index != -1)
				  		    		lcsString = lcsString.substring(index+2);
				  		    	busList.add( new SingleRow( BusName[src]+" & "+BusName[dest], "Common Stopage: "+ lcsString, "" ) );
				  		    }
				  		}
				  	}
				}
				provider.setMapBuslist(MapBuslist);
			}
			else {
				for(int i = 0; i < numOfBus; i++) {
					busList.add( new SingleRow( BusName[i], BusStand[i], Color[i] ) );
				}
			}
		}
		
		@Override
		public int getCount() {
			return busList.size();
		}

		@Override
		public Object getItem(int position) {
			return busList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView( int position, View convertView, ViewGroup parent ) {
			
			View row = convertView;
		    if(convertView == null)
				row = inflater.inflate( R.layout.single_row, parent, false );
			TextView title = (TextView) row.findViewById( R.id.tvBusName );
			TextView description = (TextView) row.findViewById( R.id.tvBusDescription );
			ImageView image = (ImageView) row.findViewById( R.id.ivBusNameList );
			title.setText( busList.get(position).Bus );
			description.setText( busList.get(position).Stopage );
			image.setImageResource( busList.get(position).BusImage );
			return row;
		}
		
		public void setSource(String source) {
			this.source= source;
		}
		
		public void setDestination(String destination) {
			this.destination= destination;
		}
		
		private boolean check(String stands, int index) {
			boolean findSource = stands.contains(source);
			boolean findDestination = stands.contains(destination);
			if(findSource == true && findDestination == false)
				onlySource.add(index);
		    if(findSource == false && findDestination == true)
		    	onlyDestination.add(index);
			return findSource & findDestination;
		}
}

 class SingleRow {
	String Bus,Stopage;
	int BusImage;
	public SingleRow(String BusName, String Stopage, String Color) {
	this.Bus = BusName;
	this.Stopage = Stopage;
		if(Color.equalsIgnoreCase("green")) {
		    BusImage = R.drawable.buslistgreen;
	    }
		else if(Color.equalsIgnoreCase("lightgreen")) {
			BusImage = R.drawable.buslistlightgreen;
		}
		else if(Color.equalsIgnoreCase("white")) {
			BusImage = R.drawable.buslistwhite;
	    }
		else if(Color.equalsIgnoreCase("indigo")) {
			BusImage = R.drawable.buslistindigo;
		}
		else {
			BusImage = R.drawable.buslist;
		}
	}
}
 
class LCS { 
	    public static String longestCommonSubstring(String S1, String S2) {
	         
		String X=S1,Y=S2;
		int m=X.length();
		int n=Y.length();
		String LCSuff[][]= new String[m+1][n+1];
		String result="";  
		    
		for (int i=0; i<=m; i++) {
			for (int j=0; j<=n; j++) {
		        if (i == 0 || j == 0)
		        	LCSuff[i][j] = "";
		        else if (X.charAt(i-1) == Y.charAt(j-1)) {
		            LCSuff[i][j] = LCSuff[i-1][j-1] + ""+X.charAt(i-1);
		            if(result.length() < LCSuff[i][j].length())
		            	result=LCSuff[i][j];
		            }
		        else LCSuff[i][j] = "";
		        }
		    }
	  return result;
	  }
}