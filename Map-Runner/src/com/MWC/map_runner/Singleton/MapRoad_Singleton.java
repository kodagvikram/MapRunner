package com.MWC.map_runner.Singleton;

import com.MWC.map_runner.R;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MapRoad_Singleton {

	public Context context;
	public static MapRoad_Singleton mapRoad_Singleton = null;

	public RelativeLayout layout, NameLayout;
	public int road_width = 0;
	public Typeface type;
	public int textsize = 10, bigtextsize = 25;
	public int devicewidth = 0;
	public int deviceheight = 0;
	public double landmarksize = 0.05;

	public RelativeLayout.LayoutParams layoutParams, NameLayoutparam;

	public MapRoad_Singleton(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		layoutParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		NameLayoutparam = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layout = new RelativeLayout(context);
		NameLayout = new RelativeLayout(context);

		type = Typeface.createFromAsset(context.getAssets(),
				"fonts/HoboStd.otf");
	}// end of constructure

	public static MapRoad_Singleton getInstance(Context context) {
		mapRoad_Singleton = new MapRoad_Singleton(context);
		return mapRoad_Singleton;

	}

	// --------------------------------------------------Start of Map Road
	public void MapRods_Row_1_1() {
		try {
			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.80), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.66), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.91), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.90), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.46), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.71));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.11));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.41));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.96));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.81));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.901));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 0.10);
			params1.leftMargin = (int) (devicewidth * 0.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 0.22);
			params2.leftMargin = (int) (devicewidth * 0.20);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 0.30);
			params3.leftMargin = (int) (devicewidth * 0.10);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 0.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 0.10);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 0.50);
			params5.leftMargin = (int) (devicewidth * 0.10);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 0.65);
			params6.leftMargin = (int) (devicewidth * 0.10);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 0.75);
			params7.leftMargin = (int) (devicewidth * 0.10);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 0.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 0.45);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 0.10);
			params9.topMargin = (int) (deviceheight * 0.05);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 0.25);
			params10.topMargin = (int) (deviceheight * 0.65);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 0.35);
			params11.topMargin = (int) (deviceheight * 0.10);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 0.50);
			params12.topMargin = (int) (deviceheight * 0.05);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 0.75);
			params13.topMargin = (int) (deviceheight * 0.10);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 0.90);
			params14.topMargin = (int) (deviceheight * 0.10);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.50), (int) (deviceheight * 0.235));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam.topMargin = (int) (deviceheight * 0.765);
			waterparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			//waterlayout1.setBackgroundColor(Color.parseColor("#b5cd83"));
			// waterlayout1.setRotation(-80.0f);

			RelativeLayout.LayoutParams waterparam2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 1.25), (int) (deviceheight * 1));
			RelativeLayout waterlayout2 = new RelativeLayout(context);
			waterparam2.topMargin = (int) (deviceheight * 2.995);
			waterparam2.leftMargin = (int) (devicewidth * 1.94);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout2.setBackgroundColor(Color.parseColor("#d2be96"));

			RelativeLayout.LayoutParams waterparam3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 1.78), (int) (deviceheight * 0.10));
			RelativeLayout waterlayout3 = new RelativeLayout(context);
			// waterparam3.topMargin = (int) (deviceheight * 0.765);
			// waterparam3.leftMargin = (int) (devicewidth*0.931);
			waterparam3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout3.setBackgroundColor(Color.parseColor("#b5cd83"));

			RelativeLayout.LayoutParams waterparam4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.10), (int) (deviceheight * 1.70));
			RelativeLayout waterlayout4 = new RelativeLayout(context);
			// waterparam3.topMargin = (int) (deviceheight * 0.765);
			// waterparam3.leftMargin = (int) (devicewidth*0.931);
			waterparam4.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout4.setBackgroundColor(Color.parseColor("#b5cd83"));

			RelativeLayout.LayoutParams waterparam5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.10), (int) (deviceheight * 1.20));
			RelativeLayout waterlayout5 = new RelativeLayout(context);
			//waterparam5.topMargin = (int) (deviceheight * 0.90);
			//waterparam5.leftMargin = (int) (devicewidth * 0.90);
			// waterparam5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout5.setBackgroundColor(Color.parseColor("#d2be96"));

			RelativeLayout.LayoutParams waterparam6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 1), (int) (deviceheight * 3.50));
			RelativeLayout waterlayout6 = new RelativeLayout(context);
			 waterparam6.topMargin = (int) (deviceheight * 0.70);
			waterparam6.leftMargin = (int) (devicewidth * 3.0);
			// waterparam5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout6.setBackgroundColor(Color.parseColor("#beebfe"));

			RelativeLayout.LayoutParams waterparam7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 4), (int) (deviceheight * 1));
			RelativeLayout waterlayout7 = new RelativeLayout(context);
			waterparam7.topMargin = (int) (deviceheight * 3.0);
			// waterparam7.leftMargin = (int) (devicewidth);
			// waterparam5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout7.setBackgroundColor(Color.parseColor("#beebfe"));

			RelativeLayout.LayoutParams waterparam8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.87), (int) (deviceheight * 0.20));
			RelativeLayout waterlayout8 = new RelativeLayout(context);
			waterparam8.topMargin = (int) (deviceheight * 1.90);
			waterparam8.leftMargin = (int) (devicewidth * 0.90);
			// waterparam5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout8.setBackgroundColor(Color.parseColor("#b5cd83"));

			RelativeLayout.LayoutParams waterparam9 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.37), (int) (deviceheight * 0.30));
			RelativeLayout waterlayout9 = new RelativeLayout(context);
			waterparam9.topMargin = (int) (deviceheight * 1.75);
			waterparam9.leftMargin = (int) (devicewidth * 0.90);
			// waterparam5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout9.setBackgroundColor(Color.parseColor("#b5cd83"));

			RelativeLayout.LayoutParams waterparam10 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.61), (int) (deviceheight * 0.20));
			RelativeLayout waterlayout10 = new RelativeLayout(context);
			waterparam10.topMargin = (int) (deviceheight * 1.90);
			waterparam10.leftMargin = (int) (devicewidth * 1.90);
			// waterparam5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout10.setBackgroundColor(Color.parseColor("#b5cd83"));

			RelativeLayout.LayoutParams waterparam11 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.37), (int) (deviceheight * 0.30));
			RelativeLayout waterlayout11 = new RelativeLayout(context);
			waterparam11.topMargin = (int) (deviceheight * 1.75);
			waterparam11.leftMargin = (int) (devicewidth * 1.90);
			// waterparam5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout11.setBackgroundColor(Color.parseColor("#b5cd83"));

			// -------------------hexa gon images--------------------
			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 0.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 0.27);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Marylebone Road");

			RelativeLayout.LayoutParams locationNameparamNW1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW1 = new TextView(context);
			locationNameparamNW1.topMargin = (int) (deviceheight * 0.40);
			locationNameparamNW1.leftMargin = (int) (devicewidth * 0.25);
			locationNameTxtviewNW1.setTypeface(type);
			locationNameTxtviewNW1.setTextSize(bigtextsize);
			locationNameTxtviewNW1.setText("M A R Y L E B O N E");

			RelativeLayout.LayoutParams locationNameparamNW2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW2 = new TextView(context);
			locationNameparamNW2.topMargin = (int) (deviceheight * 2);
			locationNameparamNW2.leftMargin = (int) (devicewidth * 0.35);
			locationNameTxtviewNW2.setTypeface(type);
			locationNameTxtviewNW2.setTextSize(20);
			locationNameTxtviewNW2.setText("GREEN PARK");

			RelativeLayout.LayoutParams locationNameparamNW3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW3 = new TextView(context);
			locationNameparamNW3.topMargin = (int) (deviceheight * 2);
			locationNameparamNW3.leftMargin = (int) (devicewidth * 2);
			locationNameTxtviewNW3.setTypeface(type);
			locationNameTxtviewNW3.setTextSize(20);
			locationNameTxtviewNW3.setText("");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 0.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 0.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2.setText("B\na\nk\ne\nr\n\nS\nt\nr\ne\ne\nt");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 0.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 0.25);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Edgware Road");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 0.55);
			locationNameparam4.leftMargin = (int) (devicewidth * 0.51);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4
					.setText("G\nl\no\nu\nc\ne\ns\nt\ne\nr\n\nP\nl\na\nc\ne");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 0.305);
			locationNameparam5.leftMargin = (int) (devicewidth * 0.20);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("Paddington Street ");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 0.77);
			locationNameparam6.leftMargin = (int) (devicewidth * 0.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6
					.setText("M\na\nr\ny\nl\ne\nb\no\nn\ne\n\nH\ni\ng\nh\n\nS\nt\nr\ne\ne\nt");

			RelativeLayout.LayoutParams locationNameparam7 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview7 = new TextView(context);
			locationNameparam7.topMargin = (int) (deviceheight * 0.01);
			locationNameparam7.leftMargin = (int) (devicewidth * 0.40);
			locationNameTxtview7.setTypeface(type);
			locationNameTxtview7.setText("REGENTS PARK ");
			locationNameTxtview7.setTextSize(20);

			RelativeLayout.LayoutParams locationNameparam8 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview8 = new TextView(context);
			locationNameparam8.topMargin = (int) (deviceheight * 0.90);
			locationNameparam8.leftMargin = (int) (devicewidth * 0.20);
			locationNameTxtview8.setTypeface(type);
			locationNameTxtview8.setText(" ");
			locationNameTxtview8.setTextSize(20);

			// ---------------end of road names
			locationNameTxtview1.setTextSize(textsize);
			locationNameTxtview2.setTextSize(textsize);
			locationNameTxtview3.setTextSize(textsize);
			locationNameTxtview4.setTextSize(textsize);
			locationNameTxtview5.setTextSize(textsize);
			locationNameTxtview6.setTextSize(textsize);
			// --------------------------------------------------Add views
			layout.addView(waterlayout1, waterparam);
			layout.addView(waterlayout2, waterparam2);
			layout.addView(waterlayout3, waterparam3);
			layout.addView(waterlayout4, waterparam4);
			

			layout.addView(waterlayout6, waterparam6);
			layout.addView(waterlayout7, waterparam7);
			// layout.addView(waterlayout8, waterparam8);
			// layout.addView(waterlayout9, waterparam9);
			// layout.addView(waterlayout10, waterparam10);
			// layout.addView(waterlayout11, waterparam11);
			
			layout.addView(waterlayout5, waterparam5);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);
			NameLayout.addView(locationNameTxtview7, locationNameparam7);
			NameLayout.addView(locationNameTxtview8, locationNameparam8);

			NameLayout.addView(locationNameTxtviewNW1, locationNameparamNW1);
			NameLayout.addView(locationNameTxtviewNW2, locationNameparamNW2);
			NameLayout.addView(locationNameTxtviewNW3, locationNameparamNW3);

			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// ----------------------------------------------------end of Map
		// Roads1-------

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()
	public void MapRods_ROW_1_2() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.91), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.93), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.26), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.91), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.94), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.53), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.66));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.16));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.51));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.91));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.91));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.723));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 0.10);
			params1.leftMargin = (int) (devicewidth * 1.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 0.22);
			params2.leftMargin = (int) (devicewidth * 0.99);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 0.30);
			params3.leftMargin = (int) (devicewidth * 1.10);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 0.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 1.10);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 0.50);
			params5.leftMargin = (int) (devicewidth);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 0.65);
			params6.leftMargin = (int) (devicewidth * 1.60);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 0.75);
			params7.leftMargin = (int) (devicewidth * 0.99);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 0.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 1.25);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 1.10);
			params9.topMargin = (int) (deviceheight * 0.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 1.25);
			params10.topMargin = (int) (deviceheight * 0.75);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 1.35);
			params11.topMargin = (int) (deviceheight * 0.10);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 1.50);
			params12.topMargin = (int) (deviceheight * 0.10);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 1.75);
			params13.topMargin = (int) (deviceheight * 0.10);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 1.90);
			params14.topMargin = (int) (deviceheight * 0.05);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.21), (int) (deviceheight * 0.123));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam.topMargin = (int) (deviceheight * 0.65);
			waterparam.leftMargin = (int) (devicewidth * 1.90);
			waterlayout1.setBackgroundColor(Color.parseColor("#b5cd83"));

			RelativeLayout.LayoutParams waterparam2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.15), (int) (deviceheight * 0.35));
			RelativeLayout waterlayout2 = new RelativeLayout(context);
			waterparam2.topMargin = (int) (deviceheight * 0.75);
			waterparam2.leftMargin = (int) (devicewidth * 1.76);
			waterlayout2.setBackgroundColor(Color.parseColor("#b5cd83"));

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 0.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 1.27);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Euston Square");

			RelativeLayout.LayoutParams locationNameparamNW1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW1 = new TextView(context);
			locationNameparamNW1.topMargin = (int) (deviceheight * 0.40);
			locationNameparamNW1.leftMargin = (int) (devicewidth * 1.40);
			locationNameTxtviewNW1.setTypeface(type);
			locationNameTxtviewNW1.setTextSize(bigtextsize);
			locationNameTxtviewNW1.setText("B L O O M S B U R Y");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 0.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 1.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2.setText("G\no\nw\ne\nr\n\nS\nt\nr\ne\ne\nt");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 0.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 1.15);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Goodge Street");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 0.55);
			locationNameparam4.leftMargin = (int) (devicewidth * 1.51);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4
					.setText("T\no\nt\nt\ne\nn\nh\na\nm\n\nC\no\nu\nr\nt\n\nR\no\na\nd");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 0.75);
			locationNameparam5.leftMargin = (int) (devicewidth * 1.66);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("Tower Bridge Road");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 0.50);
			locationNameparam6.leftMargin = (int) (devicewidth * 1.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6
					.setText("R\nu\ns\ns\ne\nl\nl\n\nS\nq\nu\na\nr\ne");

			RelativeLayout.LayoutParams locationNameparam7 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview7 = new TextView(context);
			locationNameparam7.topMargin = (int) (deviceheight * 0.85);
			locationNameparam7.leftMargin = (int) (devicewidth * 1.755);
			locationNameTxtview7.setTypeface(type);
			locationNameTxtview7
					.setText("B\nl\no\no\nm\ns\nb\nu\nr\ny\n\nS\nt\nr\ne\ne\nt");

			// ---------------end of road names
			locationNameTxtview1.setTextSize(textsize);
			locationNameTxtview2.setTextSize(textsize);
			locationNameTxtview3.setTextSize(textsize);
			locationNameTxtview4.setTextSize(textsize);
			locationNameTxtview5.setTextSize(textsize);
			locationNameTxtview6.setTextSize(textsize);
			locationNameTxtview7.setTextSize(textsize);
			// --------------------------------------------------Add views
			layout.addView(waterlayout1, waterparam);
			// layout.addView(waterlayout2, waterparam2);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			// NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);
			NameLayout.addView(locationNameTxtview7, locationNameparam7);

			NameLayout.addView(locationNameTxtviewNW1, locationNameparamNW1);

			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// -------------------------------end of
		// MapRods_ABOVE_MIDDLE_ROAD_1-------

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()
	public void MapRods_ROW_1_3() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.93), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.43), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.26), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.65), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.91), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.53), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.91));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.16));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.51));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.81));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.91));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.705));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 0.10);
			params1.leftMargin = (int) (devicewidth * 1.99);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 0.22);
			params2.leftMargin = (int) (devicewidth * 2.50);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 0.30);
			params3.leftMargin = (int) (devicewidth * 2.35);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 0.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 2.10);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 0.50);
			params5.leftMargin = (int) (devicewidth * 2.35);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 0.65);
			params6.leftMargin = (int) (devicewidth * 1.99);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 0.75);
			params7.leftMargin = (int) (devicewidth * 2.10);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 0.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 2.25);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 2.10);
			params9.topMargin = (int) (deviceheight * 0.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 2.25);
			params10.topMargin = (int) (deviceheight * 0.75);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 2.35);
			params11.topMargin = (int) (deviceheight * 0.10);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 2.50);
			params12.topMargin = (int) (deviceheight * 0.10);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 2.75);
			params13.topMargin = (int) (deviceheight * 0.10);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 2.90);
			params14.topMargin = (int) (deviceheight * 0.10);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.32), (int) (deviceheight * 0.235));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam.topMargin = (int) (deviceheight * 0.765);
			waterparam.leftMargin = (int) (devicewidth * 1.931);
			waterparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout1.setBackgroundColor(Color.parseColor("#8dc63f"));
			// waterlayout1.setRotation(-80.0f);

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 0.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 2.65);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("King's Cross");

			RelativeLayout.LayoutParams locationNameparamNW1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW1 = new TextView(context);
			locationNameparamNW1.topMargin = (int) (deviceheight * 0.65);
			locationNameparamNW1.leftMargin = (int) (devicewidth * 2.55);
			locationNameTxtviewNW1.setTypeface(type);
			locationNameTxtviewNW1.setTextSize(bigtextsize);
			locationNameTxtviewNW1.setText("H O L B O R N");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 0.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 2.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2
					.setText("A\nr\ng\ny\nl\ne\n\nS\nq\nu\na\nr\ne");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 0.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 2.35);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Theobalds Road");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 0.60);
			locationNameparam4.leftMargin = (int) (devicewidth * 2.51);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4.setText("J\nu\nd\nd\n\ns\nt\nr\ne\ne\nt");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 0.75);
			locationNameparam5.leftMargin = (int) (devicewidth * 2.66);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("High Holborn");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 0.30);
			locationNameparam6.leftMargin = (int) (devicewidth * 2.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6
					.setText("G\nr\na\ny\n's\n\nI\nn\nn\n\nR\no\na\nd");

			RelativeLayout.LayoutParams locationNameparam7 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview7 = new TextView(context);
			locationNameparam7.topMargin = (int) (deviceheight * 0.65);
			locationNameparam7.leftMargin = (int) (devicewidth * 2.105);
			locationNameTxtview7.setTypeface(type);
			locationNameTxtview7
					.setText("S\no\nu\nt\nh\na\nm\np\nt\no\nn\n\nR\no\nw ");

			// ---------------end of road names

			locationNameTxtview1.setTextSize(textsize);
			locationNameTxtview2.setTextSize(textsize);
			locationNameTxtview3.setTextSize(textsize);
			locationNameTxtview4.setTextSize(textsize);
			locationNameTxtview5.setTextSize(textsize);
			locationNameTxtview6.setTextSize(textsize);
			locationNameTxtview7.setTextSize(textsize);
			// --------------------------------------------------Add views
			// layout.addView(waterlayout1, waterparam);

			// layout.addView(hexalayout1, hexagonparam1);
			// layout.addView(hexalayout2, hexagonparam2);
			// layout.addView(hexalayout3, hexagonparam3);
			// layout.addView(hexalayout4, hexagonparam4);
			// layout.addView(hexalayout5, hexagonparam5);
			// layout.addView(hexalayout6, hexagonparam6);
			// layout.addView(hexalayout7, hexagonparam7);
			// layout.addView(hexalayout8, hexagonparam8);
			// layout.addView(hexalayout9, hexagonparam9);
			// layout.addView(hexalayout10, hexagonparam10);
			// layout.addView(hexalayout11, hexagonparam11);
			// layout.addView(hexalayout12, hexagonparam12);
			// layout.addView(hexalayout13, hexagonparam13);
			// layout.addView(hexalayout14, hexagonparam14);
			// layout.addView(hexalayout15, hexagonparam15);
			// layout.addView(hexalayout16, hexagonparam16);
			// layout.addView(hexalayout17, hexagonparam17);
			// layout.addView(hexalayout18, hexagonparam18);
			// layout.addView(hexalayout19, hexagonparam19);
			// layout.addView(hexalayout20, hexagonparam20);
			// layout.addView(hexalayout21, hexagonparam21);
			// layout.addView(hexalayout22, hexagonparam22);
			// layout.addView(hexalayout23, hexagonparam23);
			// layout.addView(hexalayout24, hexagonparam24);
			// layout.addView(hexalayout25, hexagonparam25);
			// // layout.addView(hexalayout26, hexagonparam26);
			// layout.addView(hexalayout27, hexagonparam27);
			// layout.addView(hexalayout28, hexagonparam28);
			// layout.addView(hexalayout29, hexagonparam29);
			// layout.addView(hexalayout30, hexagonparam30);
			// layout.addView(hexalayout31, hexagonparam31);
			// layout.addView(hexalayout32, hexagonparam32);
			// layout.addView(hexalayout33, hexagonparam33);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);
			NameLayout.addView(locationNameTxtview7, locationNameparam7);

			NameLayout.addView(locationNameTxtviewNW1, locationNameparamNW1);

			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// -------------------------------end of
		// MapRods_ABOVE_MIDDLE_ROAD_1-------

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()
	public void MapRods_ROW_1_4() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.50), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.26), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.65), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.50), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.91), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.66));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.25));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.51));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.81));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.81));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 0.10);
			params1.leftMargin = (int) (devicewidth * 3.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 0.22);
			params2.leftMargin = (int) (devicewidth * 3.50);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 0.30);
			params3.leftMargin = (int) (devicewidth * 3.10);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 0.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 3.10);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 0.50);
			params5.leftMargin = (int) (devicewidth * 2.995);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 0.65);
			params6.leftMargin = (int) (devicewidth * 3.50);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 0.75);
			params7.leftMargin = (int) (devicewidth * 2.995);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 0.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 3.50);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 3.10);
			params9.topMargin = (int) (deviceheight * 0.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 3.25);
			params10.topMargin = (int) (deviceheight * 0.75);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 3.35);
			params11.topMargin = (int) (deviceheight * 0.10);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 3.50);
			params12.topMargin = (int) (deviceheight * 0.10);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 3.75);
			params13.topMargin = (int) (deviceheight * 0.10);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 3.90);
			params14.topMargin = (int) (deviceheight * 0.10);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.32), (int) (deviceheight * 0.235));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam.topMargin = (int) (deviceheight * 0.765);
			waterparam.leftMargin = (int) (devicewidth * 2.931);
			waterparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout1.setBackgroundColor(Color.parseColor("#8dc63f"));
			// waterlayout1.setRotation(-80.0f);

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 0.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 3.65);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Piccadilly");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 0.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 3.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2.setText("S\nt\n\nj\na\nm\ne\ns\n\nS\nt");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 0.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 3.20);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("pall mall");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 0.55);
			locationNameparam4.leftMargin = (int) (devicewidth * 3.51);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4
					.setText("R\ne\ng\ne\nn\nt\n\nS\nt\nr\ne\ne\nt");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 0.75);
			locationNameparam5.leftMargin = (int) (devicewidth * 3.66);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("Hay market");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 0.50);
			locationNameparam6.leftMargin = (int) (devicewidth * 3.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6.setText("W\nh\ni\nt\ne\nh\na\nl\nl");

			// ---------------end of road names

			// --------------------------------------------------Add views
			// layout.addView(waterlayout1, waterparam);

			// layout.addView(hexalayout1, hexagonparam1);
			// layout.addView(hexalayout2, hexagonparam2);
			// layout.addView(hexalayout3, hexagonparam3);
			// layout.addView(hexalayout4, hexagonparam4);
			// layout.addView(hexalayout5, hexagonparam5);
			// layout.addView(hexalayout6, hexagonparam6);
			// layout.addView(hexalayout7, hexagonparam7);
			// layout.addView(hexalayout8, hexagonparam8);
			// layout.addView(hexalayout9, hexagonparam9);
			// layout.addView(hexalayout10, hexagonparam10);
			// layout.addView(hexalayout11, hexagonparam11);
			// layout.addView(hexalayout12, hexagonparam12);
			// layout.addView(hexalayout13, hexagonparam13);
			// layout.addView(hexalayout14, hexagonparam14);
			// layout.addView(hexalayout15, hexagonparam15);
			// layout.addView(hexalayout16, hexagonparam16);
			// layout.addView(hexalayout17, hexagonparam17);
			// layout.addView(hexalayout18, hexagonparam18);
			// layout.addView(hexalayout19, hexagonparam19);
			// layout.addView(hexalayout20, hexagonparam20);
			// layout.addView(hexalayout21, hexagonparam21);
			// layout.addView(hexalayout22, hexagonparam22);
			// layout.addView(hexalayout23, hexagonparam23);
			// layout.addView(hexalayout24, hexagonparam24);
			// layout.addView(hexalayout25, hexagonparam25);
			// // layout.addView(hexalayout26, hexagonparam26);
			// layout.addView(hexalayout27, hexagonparam27);
			// layout.addView(hexalayout28, hexagonparam28);
			// layout.addView(hexalayout29, hexagonparam29);
			// layout.addView(hexalayout30, hexagonparam30);
			// layout.addView(hexalayout31, hexagonparam31);
			// layout.addView(hexalayout32, hexagonparam32);
			// layout.addView(hexalayout33, hexagonparam33);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);

			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// -------------------------------end of
		// MapRods_ABOVE_MIDDLE_ROAD_1-------

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()
	public void MapRods_ROW_2_2() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.90), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.25), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.91), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.53), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.66));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.16));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.51));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.91));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 1.003));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 1.10);
			params1.leftMargin = (int) (devicewidth * 1.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 1.22);
			params2.leftMargin = (int) (devicewidth * 1.10);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 1.30);
			params3.leftMargin = (int) (devicewidth * 0.99);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 1.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 1.50);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 1.50);
			params5.leftMargin = (int) (devicewidth * 1.10);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 1.65);
			params6.leftMargin = (int) (devicewidth * 0.99);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 1.75);
			params7.leftMargin = (int) (devicewidth * 1.10);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 1.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 1.25);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 1.10);
			params9.topMargin = (int) (deviceheight * 1.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 1.25);
			params10.topMargin = (int) (deviceheight * 1.75);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 1.35);
			params11.topMargin = (int) (deviceheight * 1.10);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 1.50);
			params12.topMargin = (int) (deviceheight * 0.99);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 1.75);
			params13.topMargin = (int) (deviceheight * 0.99);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 1.90);
			params14.topMargin = (int) (deviceheight * 1.10);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.32), (int) (deviceheight * 0.235));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam.topMargin = (int) (deviceheight * 1.765);
			waterparam.leftMargin = (int) (devicewidth * 0.931);
			waterparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout1.setBackgroundColor(Color.parseColor("#8dc63f"));
			// waterlayout1.setRotation(-80.0f);

			// -------------------hexa gon images--------------------
			// ------first row
			RelativeLayout.LayoutParams hexagonparam1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout1 = new RelativeLayout(context);
			hexagonparam1.topMargin = (int) (deviceheight * 1.09);
			hexagonparam1.leftMargin = (int) (devicewidth * 1.09);
			hexalayout1.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout2 = new RelativeLayout(context);
			hexagonparam2.topMargin = (int) (deviceheight * 1.09);
			hexagonparam2.leftMargin = (int) (devicewidth * 1.34);
			hexalayout2.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout3 = new RelativeLayout(context);
			hexagonparam3.topMargin = (int) (deviceheight * 1.09);
			hexagonparam3.leftMargin = (int) (devicewidth * 1.49);
			hexalayout3.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout4 = new RelativeLayout(context);
			hexagonparam4.topMargin = (int) (deviceheight * 1.09);
			hexagonparam4.leftMargin = (int) (devicewidth * 1.74);
			hexalayout4.setBackgroundResource(R.drawable.hexagon_shape);

			// ------2 row
			RelativeLayout.LayoutParams hexagonparam5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout5 = new RelativeLayout(context);
			hexagonparam5.topMargin = (int) (deviceheight * 1.21);
			hexagonparam5.leftMargin = (int) (devicewidth * 1.34);
			hexalayout5.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout6 = new RelativeLayout(context);
			hexagonparam6.topMargin = (int) (deviceheight * 1.21);
			hexagonparam6.leftMargin = (int) (devicewidth * 1.49);
			hexalayout6.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout7 = new RelativeLayout(context);
			hexagonparam7.topMargin = (int) (deviceheight * 1.21);
			hexagonparam7.leftMargin = (int) (devicewidth * 1.74);
			hexalayout7.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout8 = new RelativeLayout(context);
			hexagonparam8.topMargin = (int) (deviceheight * 1.21);
			hexagonparam8.leftMargin = (int) (devicewidth * 1.89);
			hexalayout8.setBackgroundResource(R.drawable.hexagon_shape);

			// ---------3row
			RelativeLayout.LayoutParams hexagonparam9 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout9 = new RelativeLayout(context);
			hexagonparam9.topMargin = (int) (deviceheight * 1.29);
			hexagonparam9.leftMargin = (int) (devicewidth * 1.09);
			hexalayout9.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam10 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout10 = new RelativeLayout(context);
			hexagonparam10.topMargin = (int) (deviceheight * 1.29);
			hexagonparam10.leftMargin = (int) (devicewidth * 1.34);
			hexalayout10.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam11 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout11 = new RelativeLayout(context);
			hexagonparam11.topMargin = (int) (deviceheight * 1.29);
			hexagonparam11.leftMargin = (int) (devicewidth * 1.49);
			hexalayout11.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam12 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.02), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout12 = new RelativeLayout(context);
			hexagonparam12.topMargin = (int) (deviceheight * 1.29);
			hexagonparam12.leftMargin = (int) (devicewidth * 1.74);
			hexalayout12.setBackgroundResource(R.drawable.hexagon_shape);

			// ----------4row
			RelativeLayout.LayoutParams hexagonparam13 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.02), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout13 = new RelativeLayout(context);
			hexagonparam13.topMargin = (int) (deviceheight * 1.39);
			hexagonparam13.leftMargin = (int) (devicewidth * 1.12);
			hexalayout13.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam14 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout14 = new RelativeLayout(context);
			hexagonparam14.topMargin = (int) (deviceheight * 1.39);
			hexagonparam14.leftMargin = (int) (devicewidth * 1.34);
			hexalayout14.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam15 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout15 = new RelativeLayout(context);
			hexagonparam15.topMargin = (int) (deviceheight * 1.39);
			hexagonparam15.leftMargin = (int) (devicewidth * 1.49);
			hexalayout15.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam16 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout16 = new RelativeLayout(context);
			hexagonparam16.topMargin = (int) (deviceheight * 1.39);
			hexagonparam16.leftMargin = (int) (devicewidth * 1.74);
			hexalayout16.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam17 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.02), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout17 = new RelativeLayout(context);
			hexagonparam17.topMargin = (int) (deviceheight * 1.39);
			hexagonparam17.leftMargin = (int) (devicewidth * 1.89);
			hexalayout17.setBackgroundResource(R.drawable.hexagon_shape);

			// -----------5 row
			RelativeLayout.LayoutParams hexagonparam18 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout18 = new RelativeLayout(context);
			hexagonparam18.topMargin = (int) (deviceheight * 1.49);
			hexagonparam18.leftMargin = (int) (devicewidth * 1.09);
			hexalayout18.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam19 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.02));
			RelativeLayout hexalayout19 = new RelativeLayout(context);
			hexagonparam19.topMargin = (int) (deviceheight * 1.49);
			hexagonparam19.leftMargin = (int) (devicewidth * 1.34);
			hexalayout19.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam20 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout20 = new RelativeLayout(context);
			hexagonparam20.topMargin = (int) (deviceheight * 1.49);
			hexagonparam20.leftMargin = (int) (devicewidth * 1.49);
			hexalayout20.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam21 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout21 = new RelativeLayout(context);
			hexagonparam21.topMargin = (int) (deviceheight * 1.49);
			hexagonparam21.leftMargin = (int) (devicewidth * 1.74);
			hexalayout21.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam22 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout22 = new RelativeLayout(context);
			hexagonparam22.topMargin = (int) (deviceheight * 1.49);
			hexagonparam22.leftMargin = (int) (devicewidth * 1.89);
			hexalayout22.setBackgroundResource(R.drawable.hexagon_shape);

			// -------6 row
			RelativeLayout.LayoutParams hexagonparam23 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.02), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout23 = new RelativeLayout(context);
			hexagonparam23.topMargin = (int) (deviceheight * 1.64);
			hexagonparam23.leftMargin = (int) (devicewidth * 1.12);
			hexalayout23.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam24 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.02));
			RelativeLayout hexalayout24 = new RelativeLayout(context);
			hexagonparam24.topMargin = (int) (deviceheight * 1.66);
			hexagonparam24.leftMargin = (int) (devicewidth * 1.24);
			hexalayout24.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam25 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout25 = new RelativeLayout(context);
			hexagonparam25.topMargin = (int) (deviceheight * 1.64);
			hexagonparam25.leftMargin = (int) (devicewidth * 1.49);
			hexalayout25.setBackgroundResource(R.drawable.hexagon_shape);

			// ---------7 row
			RelativeLayout.LayoutParams hexagonparam26 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout26 = new RelativeLayout(context);
			hexagonparam26.topMargin = (int) (deviceheight * 1.74);
			hexagonparam26.leftMargin = (int) (devicewidth * 1.09);
			hexalayout26.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam27 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.02));
			RelativeLayout hexalayout27 = new RelativeLayout(context);
			hexagonparam27.topMargin = (int) (deviceheight * 0.74);
			hexagonparam27.leftMargin = (int) (devicewidth * 1.24);
			hexalayout27.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam28 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout28 = new RelativeLayout(context);
			hexagonparam28.topMargin = (int) (deviceheight * 1.74);
			hexagonparam28.leftMargin = (int) (devicewidth * 1.49);
			hexalayout28.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam29 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout29 = new RelativeLayout(context);
			hexagonparam29.topMargin = (int) (deviceheight * 1.74);
			hexagonparam29.leftMargin = (int) (devicewidth * 1.74);
			hexalayout29.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam30 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout30 = new RelativeLayout(context);
			hexagonparam30.topMargin = (int) (deviceheight * 1.74);
			hexagonparam30.leftMargin = (int) (devicewidth * 1.89);
			hexalayout30.setBackgroundResource(R.drawable.hexagon_shape);

			// -----------8 row
			RelativeLayout.LayoutParams hexagonparam31 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout31 = new RelativeLayout(context);
			hexagonparam31.topMargin = (int) (deviceheight * 1.89);
			hexagonparam31.leftMargin = (int) (devicewidth * 1.49);
			hexalayout31.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam32 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.05), (int) (deviceheight * 0.02));
			RelativeLayout hexalayout32 = new RelativeLayout(context);
			hexagonparam32.topMargin = (int) (deviceheight * 1.89);
			hexagonparam32.leftMargin = (int) (devicewidth * 1.74);
			hexalayout32.setBackgroundResource(R.drawable.hexagon_shape);

			RelativeLayout.LayoutParams hexagonparam33 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.02), (int) (deviceheight * 0.04));
			RelativeLayout hexalayout33 = new RelativeLayout(context);
			hexagonparam33.topMargin = (int) (deviceheight * 1.89);
			hexagonparam33.leftMargin = (int) (devicewidth * 1.89);
			hexalayout33.setBackgroundResource(R.drawable.hexagon_shape);
			// --------------------end hexa gon
			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 1.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 1.17);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setTextSize(10);
			locationNameTxtview1.setText("Oxford Street");

			RelativeLayout.LayoutParams locationNameparamNW1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW1 = new TextView(context);
			locationNameparamNW1.topMargin = (int) (deviceheight * 1.30);
			locationNameparamNW1.leftMargin = (int) (devicewidth * 1.55);
			locationNameTxtviewNW1.setTypeface(type);
			locationNameTxtviewNW1.setTextSize(bigtextsize);
			locationNameTxtviewNW1.setText("S O H O");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 1.40);
			locationNameparam2.leftMargin = (int) (devicewidth * 1.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2
					.setText("S\nh\na\nf\nt\ne\ns\nb\nu\nr\ny\n\nA\nV\ne\nn\nu\ne");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 1.40);
			locationNameparam3.leftMargin = (int) (devicewidth * 1.505);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3
					.setText("R\ne\ng\ne\nn\nt\n\nS\nt\nr\ne\ne\nt");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 1.60);
			locationNameparam4.leftMargin = (int) (devicewidth * 1.51);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4.setText("");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 1.75);
			locationNameparam5.leftMargin = (int) (devicewidth * 1.55);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("Piccadilly");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 1.25);
			locationNameparam6.leftMargin = (int) (devicewidth * 1.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6
					.setText("C\nh\na\nr\ni\nn\ng\n\nC\nr\no\ns\ns\n\nR\no\na\nd");

			locationNameTxtview1.setTextSize(textsize);
			locationNameTxtview2.setTextSize(textsize);
			locationNameTxtview3.setTextSize(textsize);
			locationNameTxtview4.setTextSize(textsize);
			locationNameTxtview5.setTextSize(textsize);
			locationNameTxtview6.setTextSize(textsize);
			// ---------------end of road names

			// --------------------------------------------------Add views
			// layout.addView(waterlayout1, waterparam);

			// layout.addView(hexalayout1, hexagonparam1);
			// layout.addView(hexalayout2, hexagonparam2);
			// layout.addView(hexalayout3, hexagonparam3);
			// layout.addView(hexalayout4, hexagonparam4);
			// layout.addView(hexalayout5, hexagonparam5);
			// layout.addView(hexalayout6, hexagonparam6);
			// layout.addView(hexalayout7, hexagonparam7);
			// layout.addView(hexalayout8, hexagonparam8);
			// layout.addView(hexalayout9, hexagonparam9);
			// layout.addView(hexalayout10, hexagonparam10);
			// layout.addView(hexalayout11, hexagonparam11);
			// layout.addView(hexalayout12, hexagonparam12);
			// layout.addView(hexalayout13, hexagonparam13);
			// layout.addView(hexalayout14, hexagonparam14);
			// layout.addView(hexalayout15, hexagonparam15);
			// layout.addView(hexalayout16, hexagonparam16);
			// layout.addView(hexalayout17, hexagonparam17);
			// layout.addView(hexalayout18, hexagonparam18);
			// layout.addView(hexalayout19, hexagonparam19);
			// layout.addView(hexalayout20, hexagonparam20);
			// layout.addView(hexalayout21, hexagonparam21);
			// layout.addView(hexalayout22, hexagonparam22);
			// layout.addView(hexalayout23, hexagonparam23);
			// layout.addView(hexalayout24, hexagonparam24);
			// layout.addView(hexalayout25, hexagonparam25);
			// // layout.addView(hexalayout26, hexagonparam26);
			// layout.addView(hexalayout27, hexagonparam27);
			// layout.addView(hexalayout28, hexagonparam28);
			// layout.addView(hexalayout29, hexagonparam29);
			// layout.addView(hexalayout30, hexagonparam30);
			// layout.addView(hexalayout31, hexagonparam31);
			// layout.addView(hexalayout32, hexagonparam32);
			// layout.addView(hexalayout33, hexagonparam33);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);

			NameLayout.addView(locationNameTxtviewNW1, locationNameparamNW1);
			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// -------------------------------end of
		// MapRods_ABOVE_MIDDLE_ROAD_1-------

	// ---------------------------Start of// MapRods_Below1()
	public void MapRods_ROW_2_1() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.73), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.76), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.26), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.90), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.35));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.51));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.85));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.923));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 1.10);
			params1.leftMargin = (int) (devicewidth * 0.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 1.22);
			params2.leftMargin = (int) (devicewidth * 0.10);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 1.30);
			params3.leftMargin = (int) (devicewidth * 0.25);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 1.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 0.10);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 1.50);
			params5.leftMargin = (int) (devicewidth * 0.10);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 1.65);
			params6.leftMargin = (int) (devicewidth * 0.10);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 1.75);
			params7.leftMargin = (int) (devicewidth * 0.10);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 1.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 0.10);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 0.10);
			params9.topMargin = (int) (deviceheight * 1.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 0.25);
			params10.topMargin = (int) (deviceheight * 1.65);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 0.35);
			params11.topMargin = (int) (deviceheight * 1.10);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 0.50);
			params12.topMargin = (int) (deviceheight);
			// ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 0.75);
			params13.topMargin = (int) (deviceheight * 1.10);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 0.90);
			params14.topMargin = (int) (deviceheight);
			// ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.50), (int) (deviceheight * 0.102));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam1.topMargin = (int) (deviceheight * 0.999);
			waterparam1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			//waterlayout1.setBackgroundColor(Color.parseColor("#b5cd83"));

			RelativeLayout.LayoutParams waterparam2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), (int) (deviceheight * 0.16));
			RelativeLayout waterlayout2 = new RelativeLayout(context);
			waterparam2.leftMargin = (int) (devicewidth * 0.11);
			waterparam2.topMargin = (int) (deviceheight * 1.505);
			waterlayout2.setBackgroundColor(Color.parseColor("#b5cd83"));

			RelativeLayout.LayoutParams waterparam3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.68), (int) (deviceheight * 0.20));
			RelativeLayout waterlayout3 = new RelativeLayout(context);
			waterparam3.leftMargin = (int) (devicewidth * 0.26);
			waterparam3.topMargin = (int) (deviceheight * 1.91);
			waterlayout3.setBackgroundColor(Color.parseColor("#b5cd83"));
			
			RelativeLayout.LayoutParams waterparam5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.10), (int) (deviceheight * 1.20));
			RelativeLayout waterlayout5 = new RelativeLayout(context);
			//waterparam5.topMargin = (int) (deviceheight * 0.90);
			//waterparam5.leftMargin = (int) (devicewidth * 0.90);
			// waterparam5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout5.setBackgroundColor(Color.parseColor("#d2be96"));

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 1.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 0.27);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Bond Street");

			RelativeLayout.LayoutParams locationNameparamNW1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW1 = new TextView(context);
			locationNameparamNW1.topMargin = (int) (deviceheight * 1.45);
			locationNameparamNW1.leftMargin = (int) (devicewidth * 0.20);
			locationNameTxtviewNW1.setTypeface(type);
			locationNameTxtviewNW1.setTextSize(bigtextsize);
			locationNameTxtviewNW1.setText("M A Y F A I R");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 1.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 0.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2
					.setText("N\ne\nw\n\nB\no\nn\nd\n\nS\nt\nr\ne\ne\nt");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 1.305);
			locationNameparam3.leftMargin = (int) (devicewidth * 0.36);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Grosvenor Street ");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 1.67);
			locationNameparam4.leftMargin = (int) (devicewidth * 0.26);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4
					.setText("S\nt\nr\na\nt\nt\no\nn\n\nS\nt\nr\ne\ne\nt ");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 1.75);
			locationNameparam5.leftMargin = (int) (devicewidth * 0.65);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 1.67);
			locationNameparam6.leftMargin = (int) (devicewidth * 0.505);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6
					.setText("B\ne\nr\nk\ne\nl\ne\ny\n\nS\nt\nr\ne\ne\nt ");

			RelativeLayout.LayoutParams locationNameparam7 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview7 = new TextView(context);
			locationNameparam7.topMargin = (int) (deviceheight * 1.20);
			locationNameparam7.leftMargin = (int) (devicewidth * 0.03);
			locationNameTxtview7.setTypeface(type);
			locationNameTxtview7.setText("H\nY\nD\nE\n\nP\nA\nR\nK ");
			locationNameTxtview7.setTextSize(30);

			RelativeLayout.LayoutParams locationNameparam8 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview8 = new TextView(context);
			locationNameparam8.topMargin = (int) (deviceheight * 1.57);
			locationNameparam8.leftMargin = (int) (devicewidth * 0.25);
			locationNameTxtview8.setTypeface(type);
			locationNameTxtview8.setText("Berkeley\nSquare ");
			locationNameTxtview8.setTextSize(16);
			// ---------------end of road names

			locationNameTxtview1.setTextSize(textsize);
			locationNameTxtview2.setTextSize(textsize);
			locationNameTxtview3.setTextSize(textsize);
			locationNameTxtview4.setTextSize(textsize);
			locationNameTxtview5.setTextSize(textsize);
			locationNameTxtview6.setTextSize(textsize);
			// --------------------------------------------------Add views
			layout.addView(waterlayout1, waterparam1);
			layout.addView(waterlayout2, waterparam2);
			layout.addView(waterlayout3, waterparam3);
			
			layout.addView(waterlayout5, waterparam5);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);
			NameLayout.addView(locationNameTxtview7, locationNameparam7);
			NameLayout.addView(locationNameTxtview8, locationNameparam8);

			NameLayout.addView(locationNameTxtviewNW1, locationNameparamNW1);

			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// ---------------------------------------------end of Map Roads
		// BElow1-------

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()

	public void MapRods_ROW_2_3() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.43), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.65), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.90), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.69), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.26), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.53), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.76));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.16));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.51));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.927));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 1.10);
			params1.leftMargin = (int) (devicewidth * 2.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 1.22);
			params2.leftMargin = (int) (devicewidth * 1.995);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 1.30);
			params3.leftMargin = (int) (devicewidth * 2.35);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 1.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 2.10);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 1.50);
			params5.leftMargin = (int) (devicewidth * 2.22);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 1.65);
			params6.leftMargin = (int) (devicewidth * 2.10);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 1.75);
			params7.leftMargin = (int) (devicewidth * 1.995);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 1.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 2.25);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 2.10);
			params9.topMargin = (int) (deviceheight * 0.995);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 2.25);
			params10.topMargin = (int) (deviceheight * 1.75);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 2.35);
			params11.topMargin = (int) (deviceheight * 1.10);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 2.50);
			params12.topMargin = (int) (deviceheight * 1.10);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 2.75);
			params13.topMargin = (int) (deviceheight * 0.995);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 2.90);
			params14.topMargin = (int) (deviceheight * 1.10);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.32), (int) (deviceheight * 0.235));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam.topMargin = (int) (deviceheight * 1.765);
			waterparam.leftMargin = (int) (devicewidth * 1.931);
			waterparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout1.setBackgroundColor(Color.parseColor("#8dc63f"));
			// waterlayout1.setRotation(-80.0f);

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 1.105);
			locationNameparam1.leftMargin = (int) (devicewidth * 2.30);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Long Acre");

			RelativeLayout.LayoutParams locationNameparamNW1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW1 = new TextView(context);
			locationNameparamNW1.topMargin = (int) (deviceheight * 1.35);
			locationNameparamNW1.leftMargin = (int) (devicewidth * 2.18);
			locationNameTxtviewNW1.setTypeface(type);
			locationNameTxtviewNW1.setTextSize(bigtextsize);
			locationNameTxtviewNW1.setText("C O V E N T \n G A R D E N");

			RelativeLayout.LayoutParams locationNameparamNW2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW2 = new TextView(context);
			locationNameparamNW2.topMargin = (int) (deviceheight * 1.50);
			locationNameparamNW2.leftMargin = (int) (devicewidth * 3.05);
			locationNameTxtviewNW2.setTypeface(type);
			locationNameTxtviewNW2.setTextSize(bigtextsize);
			locationNameTxtviewNW2.setText("R I V E R\nT H A M E S");

			RelativeLayout.LayoutParams locationNameparamNW3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW3 = new TextView(context);
			locationNameparamNW3.topMargin = (int) (deviceheight * 3.10);
			locationNameparamNW3.leftMargin = (int) (devicewidth * 0.25);
			locationNameTxtviewNW3.setTypeface(type);
			locationNameTxtviewNW3.setTextSize(bigtextsize);
			locationNameTxtviewNW3.setText("R I V E R    T H A M E S");

			RelativeLayout.LayoutParams locationNameparamNW4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW4 = new TextView(context);
			locationNameparamNW4.topMargin = (int) (deviceheight * 3.10);
			locationNameparamNW4.leftMargin = (int) (devicewidth * 2.25);
			locationNameTxtviewNW4.setTypeface(type);
			locationNameTxtviewNW4.setTextSize(bigtextsize);
			locationNameTxtviewNW4.setText("R I V E R    T H A M E S");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 1.35);
			locationNameparam2.leftMargin = (int) (devicewidth * 2.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2.setText("S\nt\nr\na\nn\nd");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 1.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 2.45);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Aldwych");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 1.55);
			locationNameparam4.leftMargin = (int) (devicewidth * 2.505);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4.setText("W\nh\ni\nt\ne\nh\na\nl\nl");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 1.90);
			locationNameparam5.leftMargin = (int) (devicewidth * 2.30);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("Parliament Street");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 1.60);
			locationNameparam6.leftMargin = (int) (devicewidth * 2.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6
					.setText("V\ni\nc\nt\no\nr\ni\na\n\nE\nm\nb\na\nn\nk\nm\ne\nn\nt");

			RelativeLayout.LayoutParams locationNameparam7 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview7 = new TextView(context);
			locationNameparam7.topMargin = (int) (deviceheight * 1.16);
			locationNameparam7.leftMargin = (int) (devicewidth * 2.11);
			locationNameTxtview7.setTypeface(type);
			locationNameTxtview7
					.setText("S\nt\n\nM\na\nr\nt\ni\nn\n's\n\nL\na\nn\ne");

			RelativeLayout.LayoutParams locationNameparam8 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview8 = new TextView(context);
			locationNameparam8.topMargin = (int) (deviceheight * 1.305);
			locationNameparam8.leftMargin = (int) (devicewidth * 2.40);
			locationNameTxtview8.setTypeface(type);
			locationNameTxtview8.setText("Kingsway ");

			// ---------------end of road names
			locationNameTxtview1.setTextSize(textsize);
			locationNameTxtview2.setTextSize(textsize);
			locationNameTxtview3.setTextSize(textsize);
			locationNameTxtview4.setTextSize(textsize);
			locationNameTxtview5.setTextSize(textsize);
			locationNameTxtview6.setTextSize(textsize);
			locationNameTxtview7.setTextSize(textsize);
			locationNameTxtview8.setTextSize(textsize);

			// --------------------------------------------------Add views
			// layout.addView(waterlayout1, waterparam);

			// layout.addView(hexalayout1, hexagonparam1);
			// layout.addView(hexalayout2, hexagonparam2);
			// layout.addView(hexalayout3, hexagonparam3);
			// layout.addView(hexalayout4, hexagonparam4);
			// layout.addView(hexalayout5, hexagonparam5);
			// layout.addView(hexalayout6, hexagonparam6);
			// layout.addView(hexalayout7, hexagonparam7);
			// layout.addView(hexalayout8, hexagonparam8);
			// layout.addView(hexalayout9, hexagonparam9);
			// layout.addView(hexalayout10, hexagonparam10);
			// layout.addView(hexalayout11, hexagonparam11);
			// layout.addView(hexalayout12, hexagonparam12);
			// layout.addView(hexalayout13, hexagonparam13);
			// layout.addView(hexalayout14, hexagonparam14);
			// layout.addView(hexalayout15, hexagonparam15);
			// layout.addView(hexalayout16, hexagonparam16);
			// layout.addView(hexalayout17, hexagonparam17);
			// layout.addView(hexalayout18, hexagonparam18);
			// layout.addView(hexalayout19, hexagonparam19);
			// layout.addView(hexalayout20, hexagonparam20);
			// layout.addView(hexalayout21, hexagonparam21);
			// layout.addView(hexalayout22, hexagonparam22);
			// layout.addView(hexalayout23, hexagonparam23);
			// layout.addView(hexalayout24, hexagonparam24);
			// layout.addView(hexalayout25, hexagonparam25);
			// // layout.addView(hexalayout26, hexagonparam26);
			// layout.addView(hexalayout27, hexagonparam27);
			// layout.addView(hexalayout28, hexagonparam28);
			// layout.addView(hexalayout29, hexagonparam29);
			// layout.addView(hexalayout30, hexagonparam30);
			// layout.addView(hexalayout31, hexagonparam31);
			// layout.addView(hexalayout32, hexagonparam32);
			// layout.addView(hexalayout33, hexagonparam33);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);
			NameLayout.addView(locationNameTxtview7, locationNameparam7);
			NameLayout.addView(locationNameTxtview8, locationNameparam8);

			NameLayout.addView(locationNameTxtviewNW1, locationNameparamNW1);
			NameLayout.addView(locationNameTxtviewNW2, locationNameparamNW2);

			NameLayout.addView(locationNameTxtviewNW3, locationNameparamNW3);
			NameLayout.addView(locationNameTxtviewNW4, locationNameparamNW4);

			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// -------------------------------end of
		// MapRods_ABOVE_MIDDLE_ROAD_1-------

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()
	public void MapRods_ROW_2_4() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.50), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.26), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.65), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.50), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.90), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.66), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.81));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.16));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.81));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.51));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 1.10);
			params1.leftMargin = (int) (devicewidth * 3.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 1.22);
			params2.leftMargin = (int) (devicewidth * 3.35);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 1.30);
			params3.leftMargin = (int) (devicewidth * 2.995);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 1.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 2.995);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 1.50);
			params5.leftMargin = (int) (devicewidth * 3.35);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 1.65);
			params6.leftMargin = (int) (devicewidth * 3.10);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 1.75);
			params7.leftMargin = (int) (devicewidth * 3.10);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 1.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 3.10);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 3.10);
			params9.topMargin = (int) (deviceheight * 1.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 3.25);
			params10.topMargin = (int) (deviceheight * 0.995);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 3.35);
			params11.topMargin = (int) (deviceheight * 1.10);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 3.50);
			params12.topMargin = (int) (deviceheight * 1.10);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 3.75);
			params13.topMargin = (int) (deviceheight * 1.10);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 3.90);
			params14.topMargin = (int) (deviceheight * 0.995);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.32), (int) (deviceheight * 0.235));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam.topMargin = (int) (deviceheight * 1.765);
			waterparam.leftMargin = (int) (devicewidth * 2.931);
			waterparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout1.setBackgroundColor(Color.parseColor("#8dc63f"));
			// waterlayout1.setRotation(-80.0f);

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 1.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 3.65);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Road name 1");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 1.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 3.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2.setText("R\no\na\nd\nn\na\nm\ne\n2");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 1.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 3.38);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Road name 3");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 1.55);
			locationNameparam4.leftMargin = (int) (devicewidth * 3.51);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4.setText("R\no\na\nd\nn\na\nm\ne\n4");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 1.75);
			locationNameparam5.leftMargin = (int) (devicewidth * 3.66);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("Road name 5");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 1.35);
			locationNameparam6.leftMargin = (int) (devicewidth * 3.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6.setText("R\no\na\nd\nn\na\nm\ne\n6");

			// ---------------end of road names

			// --------------------------------------------------Add views
			// layout.addView(waterlayout1, waterparam);

			// layout.addView(hexalayout1, hexagonparam1);
			// layout.addView(hexalayout2, hexagonparam2);
			// layout.addView(hexalayout3, hexagonparam3);
			// layout.addView(hexalayout4, hexagonparam4);
			// layout.addView(hexalayout5, hexagonparam5);
			// layout.addView(hexalayout6, hexagonparam6);
			// layout.addView(hexalayout7, hexagonparam7);
			// layout.addView(hexalayout8, hexagonparam8);
			// layout.addView(hexalayout9, hexagonparam9);
			// layout.addView(hexalayout10, hexagonparam10);
			// layout.addView(hexalayout11, hexagonparam11);
			// layout.addView(hexalayout12, hexagonparam12);
			// layout.addView(hexalayout13, hexagonparam13);
			// layout.addView(hexalayout14, hexagonparam14);
			// layout.addView(hexalayout15, hexagonparam15);
			// layout.addView(hexalayout16, hexagonparam16);
			// layout.addView(hexalayout17, hexagonparam17);
			// layout.addView(hexalayout18, hexagonparam18);
			// layout.addView(hexalayout19, hexagonparam19);
			// layout.addView(hexalayout20, hexagonparam20);
			// layout.addView(hexalayout21, hexagonparam21);
			// layout.addView(hexalayout22, hexagonparam22);
			// layout.addView(hexalayout23, hexagonparam23);
			// layout.addView(hexalayout24, hexagonparam24);
			// layout.addView(hexalayout25, hexagonparam25);
			// // layout.addView(hexalayout26, hexagonparam26);
			// layout.addView(hexalayout27, hexagonparam27);
			// layout.addView(hexalayout28, hexagonparam28);
			// layout.addView(hexalayout29, hexagonparam29);
			// layout.addView(hexalayout30, hexagonparam30);
			// layout.addView(hexalayout31, hexagonparam31);
			// layout.addView(hexalayout32, hexagonparam32);
			// layout.addView(hexalayout33, hexagonparam33);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);
			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// -------------------------------end of
		// MapRods_ABOVE_MIDDLE_ROAD_1-------

	// ---------------------------Start of// MapRods_Below1()
	public void MapRods_ROW_3_1() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.73), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.51), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.26), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.91), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.91), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.91));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.35));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.51));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.95));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.81));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 2.10);
			params1.leftMargin = (int) (devicewidth * 0.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 2.22);
			params2.leftMargin = (int) (devicewidth * 0.10);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 2.30);
			params3.leftMargin = (int) (devicewidth * 0.25);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 2.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 0.10);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 2.50);
			params5.leftMargin = (int) (devicewidth * 0.10);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 2.65);
			params6.leftMargin = (int) (devicewidth * 0.10);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 2.75);
			params7.leftMargin = (int) (devicewidth * 0.10);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 2.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 0.10);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 0.10);
			params9.topMargin = (int) (deviceheight * 1.995);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 0.25);
			params10.topMargin = (int) (deviceheight * 1.995);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 0.35);
			params11.topMargin = (int) (deviceheight * 2.30);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 0.50);
			params12.topMargin = (int) (deviceheight * 2.05);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 0.75);
			params13.topMargin = (int) (deviceheight * 2.10);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 0.90);
			params14.topMargin = (int) (deviceheight * 2.10);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.50), (int) (deviceheight * 0.102));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam1.topMargin = (int) (deviceheight * 1.999);
			waterparam1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout1.setBackgroundColor(Color.parseColor("#8dc63f"));

			RelativeLayout.LayoutParams waterparam2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.75), (int) (deviceheight * 0.099));
			RelativeLayout waterlayout2 = new RelativeLayout(context);
			waterparam2.leftMargin = (int) (deviceheight * 0.16);
			waterparam2.topMargin = (int) (deviceheight * 2.90);
			waterlayout2.setBackgroundColor(Color.parseColor("#8dc63f"));

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 2.105);
			locationNameparam1.leftMargin = (int) (devicewidth * 0.30);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Knightsbridge ");

			RelativeLayout.LayoutParams locationNameparamNW1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW1 = new TextView(context);
			locationNameparamNW1.topMargin = (int) (deviceheight * 2.16);
			locationNameparamNW1.leftMargin = (int) (devicewidth * 0.255);
			locationNameTxtviewNW1.setTypeface(type);
			locationNameTxtviewNW1.setTextSize(textsize);
			locationNameTxtviewNW1.setText("Q\nu\ne\ne\nn\n's\n\nG\na\nt\ne ");

			RelativeLayout.LayoutParams locationNameparamNW2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW2 = new TextView(context);
			locationNameparamNW2.topMargin = (int) (deviceheight * 2.65);
			locationNameparamNW2.leftMargin = (int) (devicewidth * 0.20);
			locationNameTxtviewNW2.setTypeface(type);
			locationNameTxtviewNW2.setTextSize(bigtextsize);
			locationNameTxtviewNW2.setText("S O U T H\nK E N S I N G T O N");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 2.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 0.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2
					.setText("B\nr\no\nm\np\nt\no\nn\n\nR\no\na\nd");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 2.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 0.25);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Thurloe Place");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 2.65);
			locationNameparam4.leftMargin = (int) (devicewidth * 0.51);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4
					.setText("G\nl\no\nu\nc\ne\ns\nt\ne\nr\n\nR\no\na\nd");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 2.75);
			locationNameparam5.leftMargin = (int) (devicewidth * 0.66);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("King's Road");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 2.52);
			locationNameparam6.leftMargin = (int) (devicewidth * 0.105);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6
					.setText("G\nl\no\nu\nc\ne\ns\nt\ne\nr\n\nR\no\na\nd ");

			RelativeLayout.LayoutParams locationNameparam7 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview7 = new TextView(context);
			locationNameparam7.topMargin = (int) (deviceheight * 2.905);
			locationNameparam7.leftMargin = (int) (devicewidth * 0.55);
			locationNameTxtview7.setTypeface(type);
			locationNameTxtview7.setText("Chelsea Embankment ");

			// ---------------end of road names

			locationNameTxtview1.setTextSize(textsize);
			locationNameTxtview2.setTextSize(textsize);
			locationNameTxtview3.setTextSize(textsize);
			locationNameTxtview4.setTextSize(textsize);
			locationNameTxtview5.setTextSize(textsize);
			locationNameTxtview6.setTextSize(textsize);
			locationNameTxtview7.setTextSize(textsize);
			// --------------------------------------------------Add views
			// layout.addView(waterlayout1, waterparam1);
			// layout.addView(waterlayout2, waterparam2);

			// layout.addView(hexalayout1, hexagonparam1);
			// layout.addView(hexalayout2, hexagonparam2);
			// layout.addView(hexalayout3, hexagonparam3);
			// layout.addView(hexalayout4, hexagonparam4);
			// layout.addView(hexalayout5, hexagonparam5);
			// layout.addView(hexalayout6, hexagonparam6);
			// layout.addView(hexalayout7, hexagonparam7);
			// layout.addView(hexalayout8, hexagonparam8);
			// layout.addView(hexalayout9, hexagonparam9);
			// layout.addView(hexalayout10, hexagonparam10);
			// layout.addView(hexalayout11, hexagonparam11);
			// layout.addView(hexalayout12, hexagonparam12);
			// layout.addView(hexalayout13, hexagonparam13);
			// layout.addView(hexalayout14, hexagonparam14);
			// layout.addView(hexalayout15, hexagonparam15);
			// layout.addView(hexalayout16, hexagonparam16);
			// layout.addView(hexalayout17, hexagonparam17);
			// layout.addView(hexalayout18, hexagonparam18);
			// layout.addView(hexalayout19, hexagonparam19);
			// layout.addView(hexalayout20, hexagonparam20);
			// layout.addView(hexalayout21, hexagonparam21);
			// layout.addView(hexalayout22, hexagonparam22);
			// layout.addView(hexalayout23, hexagonparam23);
			// layout.addView(hexalayout24, hexagonparam24);
			// layout.addView(hexalayout25, hexagonparam25);
			// // layout.addView(hexalayout26, hexagonparam26);
			// layout.addView(hexalayout27, hexagonparam27);
			// layout.addView(hexalayout28, hexagonparam28);
			// layout.addView(hexalayout29, hexagonparam29);
			// layout.addView(hexalayout30, hexagonparam30);
			// layout.addView(hexalayout31, hexagonparam31);
			// layout.addView(hexalayout32, hexagonparam32);
			// layout.addView(hexalayout33, hexagonparam33);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			// NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);
			NameLayout.addView(locationNameTxtview7, locationNameparam7);

			NameLayout.addView(locationNameTxtviewNW1, locationNameparamNW1);
			NameLayout.addView(locationNameTxtviewNW2, locationNameparamNW2);

			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// ---------------------------------------------end of Map Roads
		// BElow1-------

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()
	public void MapRods_ROW_3_2() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.26), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.51), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.91), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.53), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.66));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.16));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.51));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.75));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 1.005));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 2.10);
			params1.leftMargin = (int) (devicewidth * 1.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 2.22);
			params2.leftMargin = (int) (devicewidth * 1.10);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 2.30);
			params3.leftMargin = (int) (devicewidth * 1.10);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 2.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 1.50);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 2.50);
			params5.leftMargin = (int) (devicewidth * 1.10);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 2.65);
			params6.leftMargin = (int) (devicewidth * 1.10);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 2.75);
			params7.leftMargin = (int) (devicewidth * 0.995);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 2.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 0.995);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 1.10);
			params9.topMargin = (int) (deviceheight * 2.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 1.25);
			params10.topMargin = (int) (deviceheight * 2.75);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 1.35);
			params11.topMargin = (int) (deviceheight * 2.10);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 1.50);
			params12.topMargin = (int) (deviceheight * 2.10);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 1.75);
			params13.topMargin = (int) (deviceheight * 1.99);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 1.90);
			params14.topMargin = (int) (deviceheight * 1.995);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 1), (int) (deviceheight * 0.28));
			RelativeLayout waterlayout = new RelativeLayout(context);
			waterparam.topMargin = (int) (deviceheight * 1.98);
			waterparam.leftMargin = (int) (devicewidth * 3);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout.setBackgroundColor(Color.parseColor("#beebfe"));

			RelativeLayout.LayoutParams waterparam2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 1.25), (int) (deviceheight * 1));
			RelativeLayout waterlayout2 = new RelativeLayout(context);
			waterparam2.topMargin = (int) (deviceheight * 3);
			waterparam2.leftMargin = (int) (devicewidth * 0.94);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout2.setBackgroundColor(Color.parseColor("#beebfe"));

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 2.50);
			locationNameparam1.leftMargin = (int) (devicewidth * 1.105);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1
					.setText("C\na\nd\no\ng\na\nn\n\nP\nl\na\nc\ne ");

			RelativeLayout.LayoutParams locationNameparamNW1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW1 = new TextView(context);
			locationNameparamNW1.topMargin = (int) (deviceheight * 2.35);
			locationNameparamNW1.leftMargin = (int) (devicewidth * 1.25);
			locationNameTxtviewNW1.setTypeface(type);
			locationNameTxtviewNW1.setTextSize(bigtextsize);
			locationNameTxtviewNW1.setText("B E L G R A V I A");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 2.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 1.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2
					.setText("G\nr\no\ns\nv\ne\nn\nO\nr\n\nP\nl\na\nc\ne");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 2.45);
			locationNameparam3.leftMargin = (int) (devicewidth * 1.355);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("E\na\nt\no\nn\n\nS\nq\nu\na\nr\ne ");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 2.55);
			locationNameparam4.leftMargin = (int) (devicewidth * 1.51);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4
					.setText("B\nu\nc\nk\ni\nn\ng\nh\na\nm\n\nP\na\nl\na\nc\ne\n\nR\no\na\nd");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 2.35);
			locationNameparam5.leftMargin = (int) (devicewidth * 0.905);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("S\nl\no\na\nn\ne\n\nS\nt\nr\ne\ne\nt");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 2.35);
			locationNameparam6.leftMargin = (int) (devicewidth * 1.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6.setText("E\nc\nc\nl\ne\ns\nt\nO\nn\n\nS\nt\nr\ne\ne\nt");

			RelativeLayout.LayoutParams locationNameparam7 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview7 = new TextView(context);
			locationNameparam7.topMargin = (int) (deviceheight * 2.655);
			locationNameparam7.leftMargin = (int) (devicewidth * 1.60);
			locationNameTxtview7.setTypeface(type);
			locationNameTxtview7.setText("Belgrave Road ");

			// ---------------end of road names
			locationNameTxtview1.setTextSize(textsize);
			locationNameTxtview2.setTextSize(textsize);
			locationNameTxtview3.setTextSize(textsize);
			locationNameTxtview4.setTextSize(textsize);
			locationNameTxtview5.setTextSize(textsize);
			locationNameTxtview6.setTextSize(textsize);
			locationNameTxtview7.setTextSize(textsize);
			// --------------------------------------------------Add views
			layout.addView(waterlayout, waterparam);
			layout.addView(waterlayout2, waterparam2);

			// layout.addView(hexalayout1, hexagonparam1);
			// layout.addView(hexalayout2, hexagonparam2);
			// layout.addView(hexalayout3, hexagonparam3);
			// layout.addView(hexalayout4, hexagonparam4);
			// layout.addView(hexalayout5, hexagonparam5);
			// layout.addView(hexalayout6, hexagonparam6);
			// layout.addView(hexalayout7, hexagonparam7);
			// layout.addView(hexalayout8, hexagonparam8);
			// layout.addView(hexalayout9, hexagonparam9);
			// layout.addView(hexalayout10, hexagonparam10);
			// layout.addView(hexalayout11, hexagonparam11);
			// layout.addView(hexalayout12, hexagonparam12);
			// layout.addView(hexalayout13, hexagonparam13);
			// layout.addView(hexalayout14, hexagonparam14);
			// layout.addView(hexalayout15, hexagonparam15);
			// layout.addView(hexalayout16, hexagonparam16);
			// layout.addView(hexalayout17, hexagonparam17);
			// layout.addView(hexalayout18, hexagonparam18);
			// layout.addView(hexalayout19, hexagonparam19);
			// layout.addView(hexalayout20, hexagonparam20);
			// layout.addView(hexalayout21, hexagonparam21);
			// layout.addView(hexalayout22, hexagonparam22);
			// layout.addView(hexalayout23, hexagonparam23);
			// layout.addView(hexalayout24, hexagonparam24);
			// layout.addView(hexalayout25, hexagonparam25);
			// // layout.addView(hexalayout26, hexagonparam26);
			// layout.addView(hexalayout27, hexagonparam27);
			// layout.addView(hexalayout28, hexagonparam28);
			// layout.addView(hexalayout29, hexagonparam29);
			// layout.addView(hexalayout30, hexagonparam30);
			// layout.addView(hexalayout31, hexagonparam31);
			// layout.addView(hexalayout32, hexagonparam32);
			// layout.addView(hexalayout33, hexagonparam33);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);
			//
			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);
			NameLayout.addView(locationNameTxtview7, locationNameparam7);

			NameLayout.addView(locationNameTxtviewNW1, locationNameparamNW1);
			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// ------------------end of MapRods_ABOVE_MIDDLE_ROAD_1-------

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()
	public void MapRods_ROW_3_3() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.43), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.46), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.76), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.79), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.28), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.75), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.76));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.16));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.78));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.36));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.51));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 2.10);
			params1.leftMargin = (int) (devicewidth * 2.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 2.22);
			params2.leftMargin = (int) (devicewidth * 1.995);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 2.30);
			params3.leftMargin = (int) (devicewidth * 2.35);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 2.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 1.995);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 2.50);
			params5.leftMargin = (int) (devicewidth * 2.22);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 2.65);
			params6.leftMargin = (int) (devicewidth * 1.995);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 2.75);
			params7.leftMargin = (int) (devicewidth * 1.995);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 2.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 2.25);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 2.10);
			params9.topMargin = (int) (deviceheight * 2.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 2.25);
			params10.topMargin = (int) (deviceheight * 2.75);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 2.35);
			params11.topMargin = (int) (deviceheight * 2.22);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 2.50);
			params12.topMargin = (int) (deviceheight * 1.995);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 2.75);
			params13.topMargin = (int) (deviceheight * 2.10);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 2.90);
			params14.topMargin = (int) (deviceheight * 1.995);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.32), (int) (deviceheight * 0.235));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam.topMargin = (int) (deviceheight * 2.765);
			waterparam.leftMargin = (int) (devicewidth * 1.931);
			waterparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout1.setBackgroundColor(Color.parseColor("#8dc63f"));
			// waterlayout1.setRotation(-80.0f);

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 2.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 2);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Buckingham Gate");

			RelativeLayout.LayoutParams locationNameparamNW1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtviewNW1 = new TextView(context);
			locationNameparamNW1.topMargin = (int) (deviceheight * 2.15);
			locationNameparamNW1.leftMargin = (int) (devicewidth * 2.25);
			locationNameTxtviewNW1.setTypeface(type);
			locationNameTxtviewNW1.setTextSize(bigtextsize);
			locationNameTxtviewNW1.setText("W E S T M I N S T E R");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 2.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 2.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2.setText("M\na\nr\ns\nh\na\nm\n\nS\nt\nr\ne\ne\nt");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 2.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 2.25);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Horeberry Road");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 2.55);
			locationNameparam4.leftMargin = (int) (devicewidth * 2.105);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4
					.setText("R\no\nc\nh\ne\ns\nt\ne\nr\n\nR\no\nw");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 2.90);
			locationNameparam5.leftMargin = (int) (devicewidth * 2.55);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("Vauxhall Bridge Road");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 2.25);
			locationNameparam6.leftMargin = (int) (devicewidth * 2.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6.setText("M\ni\nl\nl\nb\na\nn\nk");

			RelativeLayout.LayoutParams locationNameparam7 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview7 = new TextView(context);
			locationNameparam7.topMargin = (int) (deviceheight * 2.105);
			locationNameparam7.leftMargin = (int) (devicewidth * 2.60);
			locationNameTxtview7.setTypeface(type);
			locationNameTxtview7.setText("Victoria Street ");

			RelativeLayout.LayoutParams locationNameparam8 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview8 = new TextView(context);
			locationNameparam8.topMargin = (int) (deviceheight * 2.405);
			locationNameparam8.leftMargin = (int) (devicewidth * 2.40);
			locationNameTxtview8.setTypeface(type);
			locationNameTxtview8.setText("Great Peter St reet");

			RelativeLayout.LayoutParams waterparam2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout2 = new RelativeLayout(context);
			waterparam2.topMargin = (int) (deviceheight * 0.257);
			waterparam2.leftMargin = (int) (devicewidth * 0.42);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout2.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout3 = new RelativeLayout(context);
			waterparam3.topMargin = (int) (deviceheight * 0.364);
			waterparam3.leftMargin = (int) (devicewidth * 0.82);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout3.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout4 = new RelativeLayout(context);
			waterparam4.topMargin = (int) (deviceheight * 0.47);
			waterparam4.leftMargin = (int) (devicewidth * 0.26);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout4.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout5 = new RelativeLayout(context);
			waterparam5.topMargin = (int) (deviceheight * 0.525);
			waterparam5.leftMargin = (int) (devicewidth * 0.30);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout5.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout6 = new RelativeLayout(context);
			waterparam6.topMargin = (int) (deviceheight * 0.125);
			waterparam6.leftMargin = (int) (devicewidth * 1.29);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout6.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout7 = new RelativeLayout(context);
			waterparam7.topMargin = (int) (deviceheight * 0.247);
			waterparam7.leftMargin = (int) (devicewidth * 1.55);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout7.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout8 = new RelativeLayout(context);
			waterparam8.topMargin = (int) (deviceheight * 0.247);
			waterparam8.leftMargin = (int) (devicewidth * 1.67);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout8.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam9 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout9 = new RelativeLayout(context);
			waterparam9.topMargin = (int) (deviceheight * 0.53);
			waterparam9.leftMargin = (int) (devicewidth * 1.42);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout9.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam10 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout10 = new RelativeLayout(context);
			waterparam10.topMargin = (int) (deviceheight * 0.78);
			waterparam10.leftMargin = (int) (devicewidth * 1.55);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout10.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam11 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout11 = new RelativeLayout(context);
			waterparam11.topMargin = (int) (deviceheight * 0.175);
			waterparam11.leftMargin = (int) (devicewidth * 2.2);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout11.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam12 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout12 = new RelativeLayout(context);
			waterparam12.topMargin = (int) (deviceheight * 0.175);
			waterparam12.leftMargin = (int) (devicewidth * 2.80);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout12.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam13 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout13 = new RelativeLayout(context);
			waterparam13.topMargin = (int) (deviceheight * 0.73);
			waterparam13.leftMargin = (int) (devicewidth * 1.98);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout13.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam14 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout14 = new RelativeLayout(context);
			waterparam14.topMargin = (int) (deviceheight * 1.24);
			waterparam14.leftMargin = (int) (devicewidth * 0.15);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout14.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam15 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout15 = new RelativeLayout(context);
			waterparam15.topMargin = (int) (deviceheight * 1.24);
			waterparam15.leftMargin = (int) (devicewidth * 0.42);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout15.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam16 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout16 = new RelativeLayout(context);
			waterparam16.topMargin = (int) (deviceheight * 1.88);
			waterparam16.leftMargin = (int) (devicewidth * 0.04);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout16.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam17 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout17 = new RelativeLayout(context);
			waterparam17.topMargin = (int) (deviceheight * 1.93);
			waterparam17.leftMargin = (int) (devicewidth * 0.49);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout17.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam18 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout18 = new RelativeLayout(context);
			waterparam18.topMargin = (int) (deviceheight * 1.24);
			waterparam18.leftMargin = (int) (devicewidth * 1.52);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout18.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam19 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout19 = new RelativeLayout(context);
			waterparam19.topMargin = (int) (deviceheight * 1.717);
			waterparam19.leftMargin = (int) (devicewidth * 1.55);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout19.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam20 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout20 = new RelativeLayout(context);
			waterparam20.topMargin = (int) (deviceheight * 1.717);
			waterparam20.leftMargin = (int) (devicewidth * 1.995);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout20.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam21 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout21 = new RelativeLayout(context);
			waterparam21.topMargin = (int) (deviceheight * 1.05);
			waterparam21.leftMargin = (int) (devicewidth * 2.50);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout21.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam22 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout22 = new RelativeLayout(context);
			waterparam22.topMargin = (int) (deviceheight * 1.45);
			waterparam22.leftMargin = (int) (devicewidth * 2.22);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout22.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam23 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout23 = new RelativeLayout(context);
			waterparam23.topMargin = (int) (deviceheight * 1.60);
			waterparam23.leftMargin = (int) (devicewidth * 2.82);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout23.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam24 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout24 = new RelativeLayout(context);
			waterparam24.topMargin = (int) (deviceheight * 2.477);
			waterparam24.leftMargin = (int) (devicewidth * 0.055);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout24.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam25 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout25 = new RelativeLayout(context);
			waterparam25.topMargin = (int) (deviceheight * 2.462);
			waterparam25.leftMargin = (int) (devicewidth * 0.30);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout25.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam26 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout26 = new RelativeLayout(context);
			waterparam26.topMargin = (int) (deviceheight * 2.775);
			waterparam26.leftMargin = (int) (devicewidth * 0.96);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout26.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam27 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout27 = new RelativeLayout(context);
			waterparam27.topMargin = (int) (deviceheight * 2.07);
			waterparam27.leftMargin = (int) (devicewidth * 1.515);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout27.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam28 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout28 = new RelativeLayout(context);
			waterparam28.topMargin = (int) (deviceheight * 2.363);
			waterparam28.leftMargin = (int) (devicewidth * 1.8);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout28.setBackgroundResource(R.drawable.landmark);

			RelativeLayout.LayoutParams waterparam29 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * landmarksize),
					(int) (devicewidth * landmarksize));
			RelativeLayout waterlayout29 = new RelativeLayout(context);
			waterparam29.topMargin = (int) (deviceheight * 2.06);
			waterparam29.leftMargin = (int) (devicewidth * 2.8);
			// waterparam2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout29.setBackgroundResource(R.drawable.landmark);

			// ---------------end of road names

			locationNameTxtview1.setTextSize(textsize);
			locationNameTxtview2.setTextSize(textsize);
			locationNameTxtview3.setTextSize(textsize);
			locationNameTxtview4.setTextSize(textsize);
			locationNameTxtview5.setTextSize(textsize);
			locationNameTxtview6.setTextSize(textsize);
			locationNameTxtview7.setTextSize(textsize);
			locationNameTxtview8.setTextSize(textsize);
			// --------------------------------------------------Add views
			layout.addView(waterlayout2, waterparam2);
			layout.addView(waterlayout3, waterparam3);
			layout.addView(waterlayout4, waterparam4);
			layout.addView(waterlayout5, waterparam5);

			layout.addView(waterlayout6, waterparam6);
			layout.addView(waterlayout7, waterparam7);
			layout.addView(waterlayout8, waterparam8);
			layout.addView(waterlayout9, waterparam9);
			layout.addView(waterlayout10, waterparam10);

			layout.addView(waterlayout11, waterparam11);
			layout.addView(waterlayout12, waterparam12);
			layout.addView(waterlayout13, waterparam13);

			layout.addView(waterlayout14, waterparam14);
			layout.addView(waterlayout15, waterparam15);
			layout.addView(waterlayout16, waterparam16);
			layout.addView(waterlayout17, waterparam17);

			layout.addView(waterlayout18, waterparam18);
			layout.addView(waterlayout19, waterparam19);
			layout.addView(waterlayout20, waterparam20);

			layout.addView(waterlayout21, waterparam21);
			layout.addView(waterlayout22, waterparam22);
			layout.addView(waterlayout23, waterparam23);

			layout.addView(waterlayout24, waterparam24);
			layout.addView(waterlayout25, waterparam25);
			layout.addView(waterlayout26, waterparam26);

			layout.addView(waterlayout27, waterparam27);
			layout.addView(waterlayout28, waterparam28);
			layout.addView(waterlayout29, waterparam29);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);
			NameLayout.addView(locationNameTxtview7, locationNameparam7);
			NameLayout.addView(locationNameTxtview8, locationNameparam8);
			NameLayout.addView(locationNameTxtviewNW1, locationNameparamNW1);

			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// ------------------end of MapRods_ABOVE_MIDDLE_ROAD_1-------

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()
	public void MapRods_ROW_3_4() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.50), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.90), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.65), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.90), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.66), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.78), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.81));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.50));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.51));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.66));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.92));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 2.10);
			params1.leftMargin = (int) (devicewidth * 3.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 2.22);
			params2.leftMargin = (int) (devicewidth * 3.25);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 2.30);
			params3.leftMargin = (int) (devicewidth * 3.10);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 2.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 3.10);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 2.50);
			params5.leftMargin = (int) (devicewidth * 2.995);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 2.65);
			params6.leftMargin = (int) (devicewidth * 3.10);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 2.75);
			params7.leftMargin = (int) (devicewidth * 3.10);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 2.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 2.995);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 3.10);
			params9.topMargin = (int) (deviceheight * 2.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 3.25);
			params10.topMargin = (int) (deviceheight * 2.50);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 3.35);
			params11.topMargin = (int) (deviceheight * 1.995);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 3.50);
			params12.topMargin = (int) (deviceheight * 2.10);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 3.75);
			params13.topMargin = (int) (deviceheight * 1.995);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 3.90);
			params14.topMargin = (int) (deviceheight * 2.10);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			// RelativeLayout.LayoutParams waterparam = new
			// RelativeLayout.LayoutParams(
			// (int) (devicewidth * 0.32), (int) (deviceheight * 0.235));
			// RelativeLayout waterlayout1 = new RelativeLayout(context);
			// waterparam.topMargin = (int) (deviceheight * 2.765);
			// waterparam.leftMargin = (int) (devicewidth*2.931);
			// waterparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			// waterlayout1.setBackgroundColor(Color.parseColor("#8dc63f"));
			// // waterlayout1.setRotation(-80.0f);

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 2.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 3.65);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Road name 1");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 2.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 3.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2.setText("R\no\na\nd\nn\na\nm\ne\n2");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 2.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 3.38);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Road name 3");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 2.55);
			locationNameparam4.leftMargin = (int) (devicewidth * 3.51);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4.setText("R\no\na\nd\nn\na\nm\ne\n4");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 2.75);
			locationNameparam5.leftMargin = (int) (devicewidth * 3.66);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("Road name 5");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 2.35);
			locationNameparam6.leftMargin = (int) (devicewidth * 3.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6.setText("R\no\na\nd\nn\na\nm\ne\n6");

			// ---------------end of road names

			// --------------------------------------------------Add views
			// layout.addView(waterlayout1, waterparam);

			// layout.addView(hexalayout1, hexagonparam1);
			// layout.addView(hexalayout2, hexagonparam2);
			// layout.addView(hexalayout3, hexagonparam3);
			// layout.addView(hexalayout4, hexagonparam4);
			// layout.addView(hexalayout5, hexagonparam5);
			// layout.addView(hexalayout6, hexagonparam6);
			// layout.addView(hexalayout7, hexagonparam7);
			// layout.addView(hexalayout8, hexagonparam8);
			// layout.addView(hexalayout9, hexagonparam9);
			// layout.addView(hexalayout10, hexagonparam10);
			// layout.addView(hexalayout11, hexagonparam11);
			// layout.addView(hexalayout12, hexagonparam12);
			// layout.addView(hexalayout13, hexagonparam13);
			// layout.addView(hexalayout14, hexagonparam14);
			// layout.addView(hexalayout15, hexagonparam15);
			// layout.addView(hexalayout16, hexagonparam16);
			// layout.addView(hexalayout17, hexagonparam17);
			// layout.addView(hexalayout18, hexagonparam18);
			// layout.addView(hexalayout19, hexagonparam19);
			// layout.addView(hexalayout20, hexagonparam20);
			// layout.addView(hexalayout21, hexagonparam21);
			// layout.addView(hexalayout22, hexagonparam22);
			// layout.addView(hexalayout23, hexagonparam23);
			// layout.addView(hexalayout24, hexagonparam24);
			// layout.addView(hexalayout25, hexagonparam25);
			// // layout.addView(hexalayout26, hexagonparam26);
			// layout.addView(hexalayout27, hexagonparam27);
			// layout.addView(hexalayout28, hexagonparam28);
			// layout.addView(hexalayout29, hexagonparam29);
			// layout.addView(hexalayout30, hexagonparam30);
			// layout.addView(hexalayout31, hexagonparam31);
			// layout.addView(hexalayout32, hexagonparam32);
			// layout.addView(hexalayout33, hexagonparam33);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);

			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// --------------end of MapRods_ABOVE_MIDDLE_ROAD_1-------

	// ---------------------------Start of// MapRods_Below1()
	public void MapRods_ROW_4_1() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.90), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.51), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.26), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.90), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.66), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.682), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.35));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.60));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.66));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.91));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.56));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 3.10);
			params1.leftMargin = (int) (devicewidth * 0.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 3.22);
			params2.leftMargin = (int) (devicewidth * 0.10);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 3.30);
			params3.leftMargin = (int) (devicewidth * 0.25);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 3.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 0.10);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 3.50);
			params5.leftMargin = (int) (devicewidth * 0.10);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 3.65);
			params6.leftMargin = (int) (devicewidth * 0.10);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 3.75);
			params7.leftMargin = (int) (devicewidth * 0.10);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 3.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 0.10);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 0.10);
			params9.topMargin = (int) (deviceheight * 3.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 0.25);
			params10.topMargin = (int) (deviceheight * 3.05);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 0.35);
			params11.topMargin = (int) (deviceheight * 3.40);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 0.50);
			params12.topMargin = (int) (deviceheight * 2.995);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 0.75);
			params13.topMargin = (int) (deviceheight * 2.995);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 0.90);
			params14.topMargin = (int) (deviceheight * 3.10);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.50), (int) (deviceheight * 0.102));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam1.topMargin = (int) (deviceheight * 3.999);
			waterparam1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout1.setBackgroundColor(Color.parseColor("#8dc63f"));

			RelativeLayout.LayoutParams waterparam2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.75), (int) (deviceheight * 0.099));
			RelativeLayout waterlayout2 = new RelativeLayout(context);
			waterparam2.leftMargin = (int) (deviceheight * 0.16);
			waterparam2.topMargin = (int) (deviceheight * 3.90);
			waterlayout2.setBackgroundColor(Color.parseColor("#8dc63f"));

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 3.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 0.27);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Road name 1");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 3.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 0.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2.setText("R\no\na\nd\nn\na\nm\ne\n2");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 3.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 0.25);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Road name 3");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 3.55);
			locationNameparam4.leftMargin = (int) (devicewidth * 0.51);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4.setText("R\no\na\nd\nn\na\nm\ne\n4");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 3.75);
			locationNameparam5.leftMargin = (int) (devicewidth * 0.40);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("Road name 5");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 3.35);
			locationNameparam6.leftMargin = (int) (devicewidth * 0.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6.setText("R\no\na\nd\nn\na\nm\ne\n6");
			// ---------------end of road names

			// --------------------------------------------------Add views
			// layout.addView(waterlayout1, waterparam1);
			// layout.addView(waterlayout2, waterparam2);

			// layout.addView(hexalayout1, hexagonparam1);
			// layout.addView(hexalayout2, hexagonparam2);
			// layout.addView(hexalayout3, hexagonparam3);
			// layout.addView(hexalayout4, hexagonparam4);
			// layout.addView(hexalayout5, hexagonparam5);
			// layout.addView(hexalayout6, hexagonparam6);
			// layout.addView(hexalayout7, hexagonparam7);
			// layout.addView(hexalayout8, hexagonparam8);
			// layout.addView(hexalayout9, hexagonparam9);
			// layout.addView(hexalayout10, hexagonparam10);
			// layout.addView(hexalayout11, hexagonparam11);
			// layout.addView(hexalayout12, hexagonparam12);
			// layout.addView(hexalayout13, hexagonparam13);
			// layout.addView(hexalayout14, hexagonparam14);
			// layout.addView(hexalayout15, hexagonparam15);
			// layout.addView(hexalayout16, hexagonparam16);
			// layout.addView(hexalayout17, hexagonparam17);
			// layout.addView(hexalayout18, hexagonparam18);
			// layout.addView(hexalayout19, hexagonparam19);
			// layout.addView(hexalayout20, hexagonparam20);
			// layout.addView(hexalayout21, hexagonparam21);
			// layout.addView(hexalayout22, hexagonparam22);
			// layout.addView(hexalayout23, hexagonparam23);
			// layout.addView(hexalayout24, hexagonparam24);
			// layout.addView(hexalayout25, hexagonparam25);
			// // layout.addView(hexalayout26, hexagonparam26);
			// layout.addView(hexalayout27, hexagonparam27);
			// layout.addView(hexalayout28, hexagonparam28);
			// layout.addView(hexalayout29, hexagonparam29);
			// layout.addView(hexalayout30, hexagonparam30);
			// layout.addView(hexalayout31, hexagonparam31);
			// layout.addView(hexalayout32, hexagonparam32);
			// layout.addView(hexalayout33, hexagonparam33);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);
			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// -------------------------end of Map Roads

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()
	public void MapRods_ROW_4_2() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.41), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.90), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.51), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.65), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.936), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.432), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.53), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.66));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.25));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.51));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.76));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.66));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 3.10);
			params1.leftMargin = (int) (devicewidth * 1.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 3.22);
			params2.leftMargin = (int) (devicewidth * 0.995);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 3.30);
			params3.leftMargin = (int) (devicewidth * 1.10);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 3.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 1.35);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 3.50);
			params5.leftMargin = (int) (devicewidth * 1.35);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 3.65);
			params6.leftMargin = (int) (devicewidth * 0.995);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 3.75);
			params7.leftMargin = (int) (devicewidth * 1.10);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 3.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 1.25);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 1.10);
			params9.topMargin = (int) (deviceheight * 3.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 1.25);
			params10.topMargin = (int) (deviceheight * 3.75);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 1.35);
			params11.topMargin = (int) (deviceheight * 3.10);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 1.50);
			params12.topMargin = (int) (deviceheight * 2.995);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 1.75);
			params13.topMargin = (int) (deviceheight * 3.10);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 1.90);
			params14.topMargin = (int) (deviceheight * 2.995);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.32), (int) (deviceheight * 0.235));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam.topMargin = (int) (deviceheight * 3.765);
			waterparam.leftMargin = (int) (devicewidth * 1.931);
			waterparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout1.setBackgroundColor(Color.parseColor("#8dc63f"));
			// waterlayout1.setRotation(-80.0f);

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 3.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 1.27);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Road name 1");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 3.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 1.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2.setText("R\no\na\nd\nn\na\nm\ne\n2");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 3.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 1.40);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Road name 3");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 3.55);
			locationNameparam4.leftMargin = (int) (devicewidth * 1.51);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4.setText("R\no\na\nd\nn\na\nm\ne\n4");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 3.75);
			locationNameparam5.leftMargin = (int) (devicewidth * 1.15);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("Road name 5");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 3.35);
			locationNameparam6.leftMargin = (int) (devicewidth * 1.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6.setText("R\no\na\nd\nn\na\nm\ne\n6");
			// ---------------end of road names

			// --------------------------------------------------Add views
			// layout.addView(waterlayout1, waterparam);

			// layout.addView(hexalayout1, hexagonparam1);
			// layout.addView(hexalayout2, hexagonparam2);
			// layout.addView(hexalayout3, hexagonparam3);
			// layout.addView(hexalayout4, hexagonparam4);
			// layout.addView(hexalayout5, hexagonparam5);
			// layout.addView(hexalayout6, hexagonparam6);
			// layout.addView(hexalayout7, hexagonparam7);
			// layout.addView(hexalayout8, hexagonparam8);
			// layout.addView(hexalayout9, hexagonparam9);
			// layout.addView(hexalayout10, hexagonparam10);
			// layout.addView(hexalayout11, hexagonparam11);
			// layout.addView(hexalayout12, hexagonparam12);
			// layout.addView(hexalayout13, hexagonparam13);
			// layout.addView(hexalayout14, hexagonparam14);
			// layout.addView(hexalayout15, hexagonparam15);
			// layout.addView(hexalayout16, hexagonparam16);
			// layout.addView(hexalayout17, hexagonparam17);
			// layout.addView(hexalayout18, hexagonparam18);
			// layout.addView(hexalayout19, hexagonparam19);
			// layout.addView(hexalayout20, hexagonparam20);
			// layout.addView(hexalayout21, hexagonparam21);
			// layout.addView(hexalayout22, hexagonparam22);
			// layout.addView(hexalayout23, hexagonparam23);
			// layout.addView(hexalayout24, hexagonparam24);
			// layout.addView(hexalayout25, hexagonparam25);
			// // layout.addView(hexalayout26, hexagonparam26);
			// layout.addView(hexalayout27, hexagonparam27);
			// layout.addView(hexalayout28, hexagonparam28);
			// layout.addView(hexalayout29, hexagonparam29);
			// layout.addView(hexalayout30, hexagonparam30);
			// layout.addView(hexalayout31, hexagonparam31);
			// layout.addView(hexalayout32, hexagonparam32);
			// layout.addView(hexalayout33, hexagonparam33);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);

			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// ------------------end of MapRods_ABOVE_MIDDLE_ROAD_1-------

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()
	public void MapRods_ROW_4_3() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.65), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.46), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.76), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.79), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.832), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.28), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.75), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.16));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.78));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.50));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.92));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.56));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 3.10);
			params1.leftMargin = (int) (devicewidth * 2.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 3.22);
			params2.leftMargin = (int) (devicewidth * 2.35);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 3.30);
			params3.leftMargin = (int) (devicewidth * 1.995);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 3.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 2.10);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 3.50);
			params5.leftMargin = (int) (devicewidth * 1.995);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 3.65);
			params6.leftMargin = (int) (devicewidth * 2.10);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 3.75);
			params7.leftMargin = (int) (devicewidth * 2.10);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 3.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 2.25);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 2.10);
			params9.topMargin = (int) (deviceheight * 3.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 2.25);
			params10.topMargin = (int) (deviceheight * 3.75);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 2.35);
			params11.topMargin = (int) (deviceheight * 2.995);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 2.50);
			params12.topMargin = (int) (deviceheight * 3.50);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 2.75);
			params13.topMargin = (int) (deviceheight * 2.995);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 2.90);
			params14.topMargin = (int) (deviceheight * 3.10);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.32), (int) (deviceheight * 0.235));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam.topMargin = (int) (deviceheight * 3.765);
			waterparam.leftMargin = (int) (devicewidth * 1.931);
			waterparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout1.setBackgroundColor(Color.parseColor("#8dc63f"));
			// waterlayout1.setRotation(-80.0f);

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 3.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 2.40);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Road name 1");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 3.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 2.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2.setText("R\no\na\nd\nn\na\nm\ne\n2");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 3.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 2.55);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Road name 3");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 3.55);
			locationNameparam4.leftMargin = (int) (devicewidth * 2.105);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4.setText("R\no\na\nd\nn\na\nm\ne\n4");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 3.90);
			locationNameparam5.leftMargin = (int) (devicewidth * 2.55);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("Road name 5");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 3.35);
			locationNameparam6.leftMargin = (int) (devicewidth * 2.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6.setText("R\no\na\nd\nn\na\nm\ne\n6");

			// ---------------end of road names

			// --------------------------------------------------Add views
			// layout.addView(waterlayout1, waterparam);

			// layout.addView(hexalayout1, hexagonparam1);
			// layout.addView(hexalayout2, hexagonparam2);
			// layout.addView(hexalayout3, hexagonparam3);
			// layout.addView(hexalayout4, hexagonparam4);
			// layout.addView(hexalayout5, hexagonparam5);
			// layout.addView(hexalayout6, hexagonparam6);
			// layout.addView(hexalayout7, hexagonparam7);
			// layout.addView(hexalayout8, hexagonparam8);
			// layout.addView(hexalayout9, hexagonparam9);
			// layout.addView(hexalayout10, hexagonparam10);
			// layout.addView(hexalayout11, hexagonparam11);
			// layout.addView(hexalayout12, hexagonparam12);
			// layout.addView(hexalayout13, hexagonparam13);
			// layout.addView(hexalayout14, hexagonparam14);
			// layout.addView(hexalayout15, hexagonparam15);
			// layout.addView(hexalayout16, hexagonparam16);
			// layout.addView(hexalayout17, hexagonparam17);
			// layout.addView(hexalayout18, hexagonparam18);
			// layout.addView(hexalayout19, hexagonparam19);
			// layout.addView(hexalayout20, hexagonparam20);
			// layout.addView(hexalayout21, hexagonparam21);
			// layout.addView(hexalayout22, hexagonparam22);
			// layout.addView(hexalayout23, hexagonparam23);
			// layout.addView(hexalayout24, hexagonparam24);
			// layout.addView(hexalayout25, hexagonparam25);
			// // layout.addView(hexalayout26, hexagonparam26);
			// layout.addView(hexalayout27, hexagonparam27);
			// layout.addView(hexalayout28, hexagonparam28);
			// layout.addView(hexalayout29, hexagonparam29);
			// layout.addView(hexalayout30, hexagonparam30);
			// layout.addView(hexalayout31, hexagonparam31);
			// layout.addView(hexalayout32, hexagonparam32);
			// layout.addView(hexalayout33, hexagonparam33);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);

			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// ------------------end of MapRods_ABOVE_MIDDLE_ROAD_1-------

	// ---------------------------Start of// MapRods_ABOVE_MIDDLE_ROAD_1()
	public void MapRods_ROW_4_4() {
		try {

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.45), road_width);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.81), road_width);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.90), road_width);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.65), road_width);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.90), road_width);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.66), road_width);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.78), road_width);

			RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.81));
			RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.41));
			RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.50));
			RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.66));
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.90));
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
					road_width, (int) (deviceheight * 0.66));
			RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);
			RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
					road_width, LayoutParams.MATCH_PARENT);

			RelativeLayout hor_road1 = new RelativeLayout(context);
			params1.topMargin = (int) (deviceheight * 3.10);
			params1.leftMargin = (int) (devicewidth * 3.10);
			hor_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road2 = new RelativeLayout(context);
			params2.topMargin = (int) (deviceheight * 3.22);
			params2.leftMargin = (int) (devicewidth * 2.995);
			hor_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road3 = new RelativeLayout(context);
			params3.topMargin = (int) (deviceheight * 3.30);
			params3.leftMargin = (int) (devicewidth * 3.10);
			hor_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road4 = new RelativeLayout(context);
			params4.topMargin = (int) (deviceheight * 3.40);
			// params4.rightMargin = (int) (devicewidth * 0.09);
			params4.leftMargin = (int) (devicewidth * 3.10);
			hor_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road5 = new RelativeLayout(context);
			params5.topMargin = (int) (deviceheight * 3.50);
			params5.leftMargin = (int) (devicewidth * 2.995);
			hor_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road6 = new RelativeLayout(context);
			params6.topMargin = (int) (deviceheight * 3.65);
			params6.leftMargin = (int) (devicewidth * 3.10);
			// params6.rightMargin = (int) (devicewidth * 0.49);
			hor_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road7 = new RelativeLayout(context);
			params7.topMargin = (int) (deviceheight * 3.75);
			params7.leftMargin = (int) (devicewidth * 3.10);
			hor_road7.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout hor_road8 = new RelativeLayout(context);
			params8.topMargin = (int) (deviceheight * 3.90);
			// params8.rightMargin = (int) (devicewidth * 0.09);
			params8.leftMargin = (int) (devicewidth * 2.995);
			hor_road8.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road1 = new RelativeLayout(context);
			params9.leftMargin = (int) (devicewidth * 3.10);
			params9.topMargin = (int) (deviceheight * 3.10);
			// params9.bottomMargin = (int) (deviceheight * 0.24);
			ver_road1.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road2 = new RelativeLayout(context);
			params10.leftMargin = (int) (devicewidth * 3.25);
			params10.topMargin = (int) (deviceheight * 2.995);
			// params10.bottomMargin = (int) (deviceheight * 0.24);
			ver_road2.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road3 = new RelativeLayout(context);
			params11.leftMargin = (int) (devicewidth * 3.35);
			params11.topMargin = (int) (deviceheight * 3.50);
			ver_road3.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road4 = new RelativeLayout(context);
			params12.leftMargin = (int) (devicewidth * 3.50);
			params12.topMargin = (int) (deviceheight * 3.10);
			ver_road4.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road4.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road5 = new RelativeLayout(context);
			params13.leftMargin = (int) (devicewidth * 3.75);
			params13.topMargin = (int) (deviceheight * 3.10);
			ver_road5.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout ver_road6 = new RelativeLayout(context);
			params14.leftMargin = (int) (devicewidth * 3.90);
			params14.topMargin = (int) (deviceheight * 2.995);
			ver_road6.setBackgroundColor(Color.parseColor("#FFFFFF"));
			// ver_road6.setBackgroundResource(R.drawable.rounded_corner_xml);

			RelativeLayout.LayoutParams waterparam = new RelativeLayout.LayoutParams(
					(int) (devicewidth * 0.32), (int) (deviceheight * 0.235));
			RelativeLayout waterlayout1 = new RelativeLayout(context);
			waterparam.topMargin = (int) (deviceheight * 3.765);
			waterparam.leftMargin = (int) (devicewidth * 2.931);
			waterparam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			waterlayout1.setBackgroundColor(Color.parseColor("#8dc63f"));
			// waterlayout1.setRotation(-80.0f);

			// -----------Road Name
			RelativeLayout.LayoutParams locationNameparam1 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview1 = new TextView(context);
			locationNameparam1.topMargin = (int) (deviceheight * 3.22);
			locationNameparam1.leftMargin = (int) (devicewidth * 3.20);
			locationNameTxtview1.setTypeface(type);
			locationNameTxtview1.setText("Road name 1");

			RelativeLayout.LayoutParams locationNameparam2 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview2 = new TextView(context);
			locationNameparam2.topMargin = (int) (deviceheight * 3.25);
			locationNameparam2.leftMargin = (int) (devicewidth * 3.76);
			locationNameTxtview2.setTypeface(type);
			locationNameTxtview2.setText("R\no\na\nd\nn\na\nm\ne\n2");

			RelativeLayout.LayoutParams locationNameparam3 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview3 = new TextView(context);
			locationNameparam3.topMargin = (int) (deviceheight * 3.50);
			locationNameparam3.leftMargin = (int) (devicewidth * 3.38);
			locationNameTxtview3.setTypeface(type);
			locationNameTxtview3.setText("Road name 3");

			RelativeLayout.LayoutParams locationNameparam4 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview4 = new TextView(context);
			locationNameparam4.topMargin = (int) (deviceheight * 3.55);
			locationNameparam4.leftMargin = (int) (devicewidth * 3.51);
			locationNameTxtview4.setTypeface(type);
			locationNameTxtview4.setText("R\no\na\nd\nn\na\nm\ne\n4");

			RelativeLayout.LayoutParams locationNameparam5 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview5 = new TextView(context);
			locationNameparam5.topMargin = (int) (deviceheight * 3.75);
			locationNameparam5.leftMargin = (int) (devicewidth * 3.66);
			locationNameTxtview5.setTypeface(type);
			locationNameTxtview5.setText("Road name 5");

			RelativeLayout.LayoutParams locationNameparam6 = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView locationNameTxtview6 = new TextView(context);
			locationNameparam6.topMargin = (int) (deviceheight * 3.35);
			locationNameparam6.leftMargin = (int) (devicewidth * 3.91);
			locationNameTxtview6.setTypeface(type);
			locationNameTxtview6.setText("R\no\na\nd\nn\na\nm\ne\n6");

			// ---------------end of road names

			// --------------------------------------------------Add views
			// layout.addView(waterlayout1, waterparam);

			// layout.addView(hexalayout1, hexagonparam1);
			// layout.addView(hexalayout2, hexagonparam2);
			// layout.addView(hexalayout3, hexagonparam3);
			// layout.addView(hexalayout4, hexagonparam4);
			// layout.addView(hexalayout5, hexagonparam5);
			// layout.addView(hexalayout6, hexagonparam6);
			// layout.addView(hexalayout7, hexagonparam7);
			// layout.addView(hexalayout8, hexagonparam8);
			// layout.addView(hexalayout9, hexagonparam9);
			// layout.addView(hexalayout10, hexagonparam10);
			// layout.addView(hexalayout11, hexagonparam11);
			// layout.addView(hexalayout12, hexagonparam12);
			// layout.addView(hexalayout13, hexagonparam13);
			// layout.addView(hexalayout14, hexagonparam14);
			// layout.addView(hexalayout15, hexagonparam15);
			// layout.addView(hexalayout16, hexagonparam16);
			// layout.addView(hexalayout17, hexagonparam17);
			// layout.addView(hexalayout18, hexagonparam18);
			// layout.addView(hexalayout19, hexagonparam19);
			// layout.addView(hexalayout20, hexagonparam20);
			// layout.addView(hexalayout21, hexagonparam21);
			// layout.addView(hexalayout22, hexagonparam22);
			// layout.addView(hexalayout23, hexagonparam23);
			// layout.addView(hexalayout24, hexagonparam24);
			// layout.addView(hexalayout25, hexagonparam25);
			// // layout.addView(hexalayout26, hexagonparam26);
			// layout.addView(hexalayout27, hexagonparam27);
			// layout.addView(hexalayout28, hexagonparam28);
			// layout.addView(hexalayout29, hexagonparam29);
			// layout.addView(hexalayout30, hexagonparam30);
			// layout.addView(hexalayout31, hexagonparam31);
			// layout.addView(hexalayout32, hexagonparam32);
			// layout.addView(hexalayout33, hexagonparam33);

			layout.addView(hor_road1, params1);
			layout.addView(hor_road2, params2);
			layout.addView(hor_road3, params3);
			layout.addView(hor_road4, params4);
			layout.addView(hor_road5, params5);
			layout.addView(hor_road6, params6);
			layout.addView(hor_road7, params7);
			layout.addView(hor_road8, params8);

			layout.addView(ver_road1, params9);
			layout.addView(ver_road2, params10);
			layout.addView(ver_road3, params11);
			layout.addView(ver_road4, params12);
			layout.addView(ver_road5, params13);
			layout.addView(ver_road6, params14);

			NameLayout.addView(locationNameTxtview1, locationNameparam1);
			NameLayout.addView(locationNameTxtview2, locationNameparam2);
			NameLayout.addView(locationNameTxtview3, locationNameparam3);
			NameLayout.addView(locationNameTxtview4, locationNameparam4);
			NameLayout.addView(locationNameTxtview5, locationNameparam5);
			NameLayout.addView(locationNameTxtview6, locationNameparam6);

			// --------------------------------Addviews to main layout

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// --------------end of MapRods_ABOVE_MIDDLE_ROAD_1-------

	public float pxFromDp(float dp) {
		return dp * context.getResources().getDisplayMetrics().density;
	}

}// end of class

