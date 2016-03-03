package com.MWC.map_runner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AppUtils {

	
	// For Checking the Internet
		public static boolean isNetworkAvailable(Context context) {
			// Get Connectivity Manager class object from Systems Service
			ConnectivityManager cm = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);

			// Get Network Info from connectivity Manager
			NetworkInfo networkInfo = cm.getActiveNetworkInfo();

			// if no network is available networkInfo will be null
			// otherwise check if we are connected
			if (networkInfo != null && networkInfo.isConnected()) {
				return true;
			}
			return false;
		}

	
	public static void ShowAlertDialog(final Context context,String message)
	{
		try {
			
		
		AlertDialog.Builder builder = new AlertDialog.Builder(
				context);
		builder.setTitle("Map Runner");
		builder.setMessage(message)
				.setCancelable(false)
				.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialog, int id) {
//								Intent intent=new Intent(context,FirstRoadScreen.class);
//								context.startActivity(intent);
//								((Activity) context).finish();
							}
						});
		AlertDialog alert = builder.create();
		alert.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
