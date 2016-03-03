package com.MWC.map_runner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements SensorEventListener {

	private TextView timerValue;
	private long startTime = 0L;
	private Handler customHandler = new Handler();
	double SIMANS_BOTTOMMARGIN=0.01,SIMANS_LEFTMARGIN=0.45;
	long timeInMilliseconds = 0L;
	long timeSwapBuff = 0L;
	long updatedTime = 0L;

	Animation _translateAnimation;
	// TranslateAnimation tAnimation1, tAnimation2, tAnimation3, tAnimation4;
	int ANIMATIONCOUNT = 1, SECINDANIMATIONCOUNT = 5;

	ImageView img1, img2, img3, img4, img5, img6, img7, img8;
	RelativeLayout relativeLayout, relativeLayout2,parentLayout;
	ScrollView scrollView, scrollView2;
	int STARTSEC=0;
	long MILISEC=0;

	public static DisplayMetrics metrics;
	int ROAD_LEFTRIGHT_MARGIN = 0;
	
	public boolean IsLEFTSWIP = false, IsRIGHTSWIP = false,isValidMove=false,isGAMEOVER=false;

	public String SWIPPATH = "";

	private GestureDetector mGestureDetector;
	private SensorManager mgr;
	private Sensor accelerometer;
	private TextView text;
	static Context con;
	public ImageView BOB_Btn,SIMANS_IMAGE;

	private int mRotation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		
		setContentView(R.layout.activity_main);
		
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		ROAD_LEFTRIGHT_MARGIN = (int) ((metrics.widthPixels) * 0.30);

		con = this;
		BOB_Btn = (ImageView) findViewById(R.id.BOB);
		SIMANS_IMAGE = (ImageView) findViewById(R.id.SIMANS);
		setSIMANSMargins(BOB_Btn, 0.45, 0.001, 0.001, 0.30);
		setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
		timerValue = (TextView) findViewById(R.id.timerValue);


		img1 = (ImageView) findViewById(R.id.img);
		setSIMANSMargins(img1, 0.20, 0.001,0.20, 0.001);
		
		img2 = (ImageView) findViewById(R.id.pathimg1);
//		img3 = (ImageView) findViewById(R.id.img3);
//		img4 = (ImageView) findViewById(R.id.img4);

		// img5 = (ImageView) findViewById(R.id.img5);
		// img6 = (ImageView) findViewById(R.id.img6);
		// img7 = (ImageView) findViewById(R.id.img7);
		// img8 = (ImageView) findViewById(R.id.img8);

		// img1.setVisibility(View.VISIBLE);
		VerticalAnimation(img1);
		// img2.setVisibility(View.GONE);
		// img3.setVisibility(View.GONE);
		// img4.setVisibility(View.GONE);
		
		RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.pathimg2);
		mainLayout.setRotation(35.0f);
		//setMargins(mainLayout, 190, 1000, 0, 0);
		
		RelativeLayout mainLayout2 = (RelativeLayout) findViewById(R.id.pathimg3);
		mainLayout2.setRotation(-34.50f);
		//setMargins(mainLayout2, 0, 1000, 1, 1);
		
		relativeLayout = (RelativeLayout) findViewById(R.id.BACKLAYOUT);
		
		parentLayout = (RelativeLayout) findViewById(R.id.global_relative);
		LayoutAnimation(relativeLayout);

		scrollView = (ScrollView) findViewById(R.id.SCROLLVIEW1);
		scrollView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				return true;
			}
		});

		// scrollView2 = (ScrollView) findViewById(R.id.SCROLLVIEW2);
		// scrollView2.setOnTouchListener(new View.OnTouchListener() {
		// @Override
		// public boolean onTouch(View v, MotionEvent event) {
		// // TODO Auto-generated method stub
		// return true;
		// }
		// });

		ImageView layout = (ImageView) findViewById(R.id.SWIPIMAGEVIEW);
		layout.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
			public void onSwipeTop() {
				Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT)
						.show();
			}

			public void onSwipeRight() {
				Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT)
						.show();
				SWIPPATH = "right";
				if((MILISEC)>1000&&(MILISEC)<2500)
                {
				//SIMANS_BOTTOMMARGIN=5;
				SIMANS_IMAGE.setVisibility(View.GONE);
				isValidMove=true;
				RightRotation_Animation();
                }
				else   if((MILISEC)>3200&&(MILISEC)<4950)
                {
               	   isValidMove=true;
               	RightVerticaRotation_Animation();
                }
                else if((MILISEC)>4900)
                {
                	 isValidMove=false;
    				//LeftRotation_Animation();
                	 RightVerticaRotation_Animation();
                }
                else 
                {
               	 isValidMove=false;
               	RightRotation_Animation();
     				// LeftVerticalRotation_Animation();
                }
			}// end of Right shift
			public void onSwipeLeft() {
//				Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT)
//						.show();
				SWIPPATH = "left";
				if((MILISEC)>1000&&(MILISEC)<2500)
                {
				//SIMANS_BOTTOMMARGIN=5;
				SIMANS_IMAGE.setVisibility(View.GONE);
				isValidMove=true;
				LeftRotation_Animation();
                }
				else   if((MILISEC)>3200&&(MILISEC)<4950)
                {
               	   isValidMove=true;
               	 LeftVerticalRotation_Animation();
                }
				 else if((MILISEC)>4900)
                {
                	 isValidMove=false;
    				//LeftRotation_Animation();
                	 LeftVerticalRotation_Animation();
                }
                else 
                {
               	 isValidMove=false;
               	LeftRotation_Animation();
     				// LeftVerticalRotation_Animation();
                }
			}// end of Left shift

			public void onSwipeBottom() {
				Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT)
						.show();
			}

			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		});

		mgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);
		accelerometer = mgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		text = (TextView) findViewById(R.id.Counttextview);
		WindowManager window = (WindowManager) this
				.getSystemService(WINDOW_SERVICE);
		int apiLevel = Integer.parseInt(Build.VERSION.SDK);
		if (apiLevel < 8) {
			mRotation = window.getDefaultDisplay().getOrientation();
		} else {
			mRotation = window.getDefaultDisplay().getRotation();
		}
	}//end of oncreate

	@Override
	protected void onResume() {
		mgr.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
		super.onResume();
	}

	@Override
	protected void onPause() {
		mgr.unregisterListener(this, accelerometer);
		super.onPause();
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}

	public void onSensorChanged(SensorEvent event) {
		String msg = String.format(
				"X: %8.4f\nY: %8.4f\nZ: %8.4f\nRotation: %d", event.values[0],
				event.values[1], event.values[2], mRotation);

		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT&&!isGAMEOVER) {
			// Do some stuff
			float Tilipos = (event.values[0]);

			if (Tilipos < 1 && Tilipos > -1) {
				System.out.println("/nMiddle  " + Tilipos);
				// Toast.makeText(getApplicationContext(), "Middle  " +Tilipos ,
				// Toast.LENGTH_LONG).show();
				setSIMANSMargins(BOB_Btn, 0.45, 0.001, 0.001, 0.30);
				SIMANS_LEFTMARGIN=0.45;
				setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
			} else if (Tilipos > 0) {
				System.out.println("/nLeft  " + Tilipos);
				// Toast.makeText(getApplicationContext(), "Left  " +Tilipos ,
				// Toast.LENGTH_LONG).show();
				if (Tilipos > 0 && Tilipos < 2)
				{
					setSIMANSMargins(BOB_Btn, 0.41, 0.001, 0.001, 0.30);
					SIMANS_LEFTMARGIN=0.41;
					setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
				}
				else if (Tilipos > 1 && Tilipos < 3){
					setSIMANSMargins(BOB_Btn, 0.36, 0.001, 0.001, 0.30);
					SIMANS_LEFTMARGIN=0.36;
					setSIMANSMargins(SIMANS_IMAGE,SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
				}
				else if (Tilipos > 2 && Tilipos < 4){
					setSIMANSMargins(BOB_Btn, 0.31, 0.001, 0.001, 0.30);
					SIMANS_LEFTMARGIN=0.31;
					setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
				}
				else if (Tilipos > 3 && Tilipos < 5){
					setSIMANSMargins(BOB_Btn, 0.27, 0.001, 0.001, 0.30);
					SIMANS_LEFTMARGIN=0.27;
					setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
				}
				else if (Tilipos > 4 && Tilipos < 6){
					setSIMANSMargins(BOB_Btn, 0.23, 0.001, 0.001, 0.30);
					SIMANS_LEFTMARGIN=0.23;
					setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
				}
				else if (Tilipos > 5 && Tilipos < 7)
				{
					isGAMEOVER=true;
					setSIMANSMargins(BOB_Btn, 0.18, 0.001, 0.001, 0.30);
					SIMANS_LEFTMARGIN=0.22;
					setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
					 img1.clearAnimation();
					 relativeLayout.clearAnimation();
					 BOB_Btn.clearAnimation();
					 AppUtils.ShowAlertDialog(MainActivity.this, "You have made a wrong move..!!");
					// SIMANS_BOTTOMMARGIN=0.01;
				}

			} else if (Tilipos < 0) {
				System.out.println("/nRight  " + Tilipos);
				// Toast.makeText(getApplicationContext(), "Right  " +Tilipos ,
				// Toast.LENGTH_LONG).show();
				// setMargins(BOB_Btn, 160, 30, 1, 1);

				if (Tilipos < 0 && Tilipos > -2){
					setSIMANSMargins(BOB_Btn, 0.49, 0.001, 0.001, 0.30);
					SIMANS_LEFTMARGIN=0.49;
					setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
				}
				else if (Tilipos > -1 && Tilipos > -3){
					setSIMANSMargins(BOB_Btn, 0.53, 0.001, 0.001, 0.30);
					SIMANS_LEFTMARGIN=0.53;
					setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
				}
				else if (Tilipos > -2 && Tilipos > -4){
					setSIMANSMargins(BOB_Btn, 0.57, 0.001, 0.001, 0.30);
					SIMANS_LEFTMARGIN=0.57;
					setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
				}
				else if (Tilipos > -3 && Tilipos > -5){
					setSIMANSMargins(BOB_Btn, 0.61, 0.001, 0.001, 0.30);
					SIMANS_LEFTMARGIN=0.61;
					setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
				}
				else if (Tilipos > -4 && Tilipos > -6){
					setSIMANSMargins(BOB_Btn, 0.65, 0.001, 0.001, 0.30);
					SIMANS_LEFTMARGIN=0.65;
					setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
				}
				else if (Tilipos > -5 && Tilipos > -7)
				{
					 isGAMEOVER=true;
					setSIMANSMargins(BOB_Btn, 0.69, 0.001, 0.001, 0.30);
					SIMANS_LEFTMARGIN=0.66;
					setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN);
					 img1.clearAnimation();
					 relativeLayout.clearAnimation();
					 BOB_Btn.clearAnimation();
					 AppUtils.ShowAlertDialog(MainActivity.this, "You have made a wrong move..!!");
					// SIMANS_BOTTOMMARGIN=0.01;
					
				}

			}
			// else

		}// end of portrate
		else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE&&!isGAMEOVER) {
			// Do some stuff
			float Tilipos = (event.values[1]);

			if (Tilipos < 1 && Tilipos > -1) {
				System.out.println("/nMiddle  " + Tilipos);
				// Toast.makeText(getApplicationContext(), "Middle  " +Tilipos ,
				// Toast.LENGTH_LONG).show();
				setMargins(BOB_Btn, 155, 130, 1, 160);
			} else if (Tilipos > 0) {
				System.out.println("/nLeft  " + Tilipos);
				// Toast.makeText(getApplicationContext(), "Left  " +Tilipos ,
				// Toast.LENGTH_LONG).show();
				if (Tilipos > 0 && Tilipos < 2)
					setMargins(BOB_Btn, 151, 130, 1, 160);
				else if (Tilipos > 1 && Tilipos < 3)
					setMargins(BOB_Btn, 147, 130, 1, 160);
				else if (Tilipos > 2 && Tilipos < 4)
					setMargins(BOB_Btn, 143, 130, 1, 160);
				else if (Tilipos > 3 && Tilipos < 5)
					setMargins(BOB_Btn, 139, 130, 1, 160);
				else if (Tilipos > 4 && Tilipos < 6)
					setMargins(BOB_Btn, 135, 130, 1, 160);
				else if (Tilipos > 5 && Tilipos < 7)
					setMargins(BOB_Btn, 131, 130, 1, 160);

			} else if (Tilipos < 0) {
				System.out.println("/nRight  " + Tilipos);
				// Toast.makeText(getApplicationContext(), "Right  " +Tilipos ,
				// Toast.LENGTH_LONG).show();
				// setMargins(BOB_Btn, 160, 30, 1, 1);

				if (Tilipos < 0 && Tilipos > -2)
					setMargins(BOB_Btn, 159, 130, 1, 1);
				else if (Tilipos > -1 && Tilipos > -3)
					setMargins(BOB_Btn, 163, 130, 1, 1);
				else if (Tilipos > -2 && Tilipos > -4)
					setMargins(BOB_Btn, 167, 130, 1, 1);
				else if (Tilipos > -3 && Tilipos > -5)
					setMargins(BOB_Btn, 171, 130, 1, 1);
				else if (Tilipos > -4 && Tilipos > -6)
					setMargins(BOB_Btn, 175, 130, 1, 1);
				else if (Tilipos > -5 && Tilipos > -7)
					setMargins(BOB_Btn, 179, 130, 1, 1);

			}
			// else

		}// end of landscape

		text.setText(msg);
		text.invalidate();
	}

	public static void setMargins(View v, int l, int t, int r, int b) {
		if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
			ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v
					.getLayoutParams();

			final float scale = con.getResources().getDisplayMetrics().density;
			l = (int) (l * scale + 0.5f);
			t = (int) (t * scale + 0.5f);
			r = (int) (r * scale + 0.5f);
			b = (int) (b * scale + 0.5f);

			p.setMargins(l, t, r, b);
			v.requestLayout();
		}
	}
	public static void setSIMANSMargins(View v, double l, double t, double r, double b) {
		if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
			ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v
					.getLayoutParams();

			final float scale = con.getResources().getDisplayMetrics().density;
		int 	lpx = (int) ((metrics.widthPixels) * l);
		int	tpx = (int) ((metrics.heightPixels) * t);
		int	rpx= (int) ((metrics.widthPixels) * r);
		int	bpx = (int) ((metrics.heightPixels) * b);

			p.setMargins(lpx, tpx, rpx, bpx);
			v.requestLayout();
		}
	}
	
	private Runnable updateTimerThread = new Runnable() {

		public void run() {

			timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

			updatedTime = timeSwapBuff + timeInMilliseconds;
			int secs = (int) (updatedTime / 1000);
			int mins = secs / 60;
			secs = secs % 60;
			int milliseconds = (int) (updatedTime % 1000);
			
			MILISEC=timeInMilliseconds;
			STARTSEC=Integer.parseInt(String.format("%02d", secs));
			
			
		if(!isGAMEOVER)
		{
			if(STARTSEC==16&&mins<1)
			{
				isGAMEOVER=true;
				setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN+=0.08);
				 timeSwapBuff += timeInMilliseconds+1000000;
				 customHandler.removeCallbacks(updateTimerThread);
				 
				 img1.clearAnimation();
				 relativeLayout.clearAnimation();
				 BOB_Btn.clearAnimation();
				 
				 AppUtils.ShowAlertDialog(MainActivity.this, "You have been caught..!!");
				 SIMANS_BOTTOMMARGIN=0.01;
				
			}
			else if(STARTSEC<16&&mins<1)
				setSIMANSMargins(SIMANS_IMAGE, SIMANS_LEFTMARGIN, 0.001, 0.001, SIMANS_BOTTOMMARGIN+=0.0003);
		}
			
			
			timerValue.setText("" + mins + ":" + String.format("%02d", secs)
					+ ":" + String.format("%03d", milliseconds)+"\n  "+MILISEC);
			customHandler.postDelayed(this, 0);
		}

	}; // end of update timer

	public void LayoutAnimation(RelativeLayout relativeLayout) {

		TranslateAnimation tAnimation = new TranslateAnimation(0, 0, -4000, 0);
		tAnimation.setDuration(10000);
		// tAnimation.setRepeatMode(Animation.INFINITE);
		tAnimation.setRepeatCount(-1);
		tAnimation.setInterpolator(new LinearInterpolator());
		tAnimation.setFillAfter(true);

		tAnimation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
			}
		});

		relativeLayout.startAnimation(tAnimation);

	}// end of LayoutAnimation

	public void VerticalAnimation(final ImageView imgView) {

		TranslateAnimation tAnimation1 = new TranslateAnimation(0, 0, -4000, 0);
		tAnimation1.setDuration(18000);
		tAnimation1.setRepeatMode(Animation.INFINITE);
		tAnimation1.setRepeatCount(-1);
		tAnimation1.setInterpolator(new LinearInterpolator());
		tAnimation1.setFillAfter(true);
		tAnimation1.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				SWIPPATH = "";
				timeSwapBuff = 0;
				customHandler.removeCallbacks(updateTimerThread);
				
				SIMANS_BOTTOMMARGIN=0.01;
				timeSwapBuff = 0;
				startTime = SystemClock.uptimeMillis();
				customHandler.postDelayed(updateTimerThread, 0);
				SIMANS_IMAGE.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
//				if (SWIPPATH.equalsIgnoreCase("")) {
//					img1.clearAnimation();
//					relativeLayout.clearAnimation();
//					AppUtils.ShowAlertDialog(MainActivity.this, "GAME OVER....");
//				} else if (SWIPPATH.equalsIgnoreCase("left")) {
//					//LeftRotation_Animation();
//				} else if (SWIPPATH.equalsIgnoreCase("right")) {
//					//RightRotation_Animation();
//
//				}
			}
		});

		imgView.startAnimation(tAnimation1);

	}// end of VerticalAnimation

	public void LEFTSWIPAnimation(ImageView imgView) {

		TranslateAnimation tAnimation1 = new TranslateAnimation(0, 0, -4000, 0);
		tAnimation1.setDuration(18000);
		tAnimation1.setRepeatMode(Animation.INFINITE);
		tAnimation1.setRepeatCount(0);
		tAnimation1.setInterpolator(new LinearInterpolator());
		tAnimation1.setFillAfter(true);
		tAnimation1.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				SWIPPATH = "";
				timeSwapBuff = 0;
				customHandler.removeCallbacks(updateTimerThread);
				
				SIMANS_BOTTOMMARGIN=0.01;
				timeSwapBuff = 0;
				startTime = SystemClock.uptimeMillis();
				customHandler.postDelayed(updateTimerThread, 0);
				SIMANS_IMAGE.setVisibility(View.VISIBLE);
				
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				if(!isGAMEOVER)
				{
				if (SWIPPATH.equalsIgnoreCase("")) {
					img1.clearAnimation();
					relativeLayout.clearAnimation();
					AppUtils.ShowAlertDialog(MainActivity.this, "You have made a wrong move..!!");
				} else if (SWIPPATH.equalsIgnoreCase("left")) {
					
					//LeftRotation_Animation();
				
				} else if (SWIPPATH.equalsIgnoreCase("right")) {
					//RightRotation_Animation();

				}
				}
			}
		});

		imgView.startAnimation(tAnimation1);

	}// end of Animation1

	public void RIGHTSWIPAnimationAnimation(ImageView imgView) {
		TranslateAnimation tAnimation1 = new TranslateAnimation(0, 0, -4000, 0);
		tAnimation1.setDuration(18000);
		tAnimation1.setRepeatMode(Animation.INFINITE);
		tAnimation1.setRepeatCount(0);
		tAnimation1.setInterpolator(new LinearInterpolator());
		tAnimation1.setFillAfter(true);
		tAnimation1.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				SWIPPATH = "";
				timeSwapBuff = 0;
				customHandler.removeCallbacks(updateTimerThread);
				
				SIMANS_BOTTOMMARGIN=0.01;
				timeSwapBuff = 0;
				startTime = SystemClock.uptimeMillis();
				customHandler.postDelayed(updateTimerThread, 0);
				SIMANS_IMAGE.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				if(!isGAMEOVER)
				{
				if (SWIPPATH.equalsIgnoreCase("")) {
					img1.clearAnimation();
					relativeLayout.clearAnimation();
					AppUtils.ShowAlertDialog(MainActivity.this, "You have made a wrong move..!!");
				} else if (SWIPPATH.equalsIgnoreCase("left")) {
					//LeftRotation_Animation();
				} else if (SWIPPATH.equalsIgnoreCase("right")) {
					//RightRotation_Animation();
				}
				}
			}
		});

		imgView.startAnimation(tAnimation1);

	}// end of Animation1

	
	
	public void RightRotation_Animation()
	{
		 RotateAnimation rotate = new RotateAnimation(0,90,(float) (metrics.widthPixels-(metrics.widthPixels*SIMANS_LEFTMARGIN)),(float) (metrics.widthPixels-(metrics.widthPixels*SIMANS_LEFTMARGIN)));
	        rotate.setDuration(500);
	       // rotate.setRepeatCount(Animation.INFINITE);
	        rotate.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					
					if(!isGAMEOVER)
					{
					BOB_Btn.clearAnimation();
					img1.clearAnimation();
					relativeLayout.clearAnimation();

					if(isValidMove)
		     		{
					RIGHTSWIPAnimationAnimation(img1);
					LayoutAnimation(relativeLayout);
		     		}
		     		else
		     		{
		     			isGAMEOVER=true;
		     			AppUtils.ShowAlertDialog(MainActivity.this, "You have made a wrong move..!!");
		     		}
					}
				}
			});
	        BOB_Btn.setAnimation(rotate);
	        
	}//end of Right rotation
	public void LeftRotation_Animation()
	{
		 RotateAnimation rotate = new RotateAnimation(0,-90,-(float) (metrics.widthPixels-(metrics.widthPixels*SIMANS_LEFTMARGIN)),(float) (metrics.widthPixels-(metrics.widthPixels*SIMANS_LEFTMARGIN)));
	        rotate.setDuration(500);
	       // rotate.setRepeatCount(Animation.INFINITE);
	        rotate.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					if(!isGAMEOVER)
					{
					BOB_Btn.clearAnimation();
					img1.clearAnimation();
		     		relativeLayout.clearAnimation();
		     		if(isValidMove)
		     		{
					LEFTSWIPAnimation(img1);
					LayoutAnimation(relativeLayout);
		     		}
		     		else
		     		{
		     			isGAMEOVER=true;
		     			AppUtils.ShowAlertDialog(MainActivity.this, "You have made a wrong move..!!");
		     		}
					}//ens of game over
				}
			});
	        
	        BOB_Btn.setAnimation(rotate);
	}//end of left rotation
	
	public void RightVerticaRotation_Animation()
	{
		 RotateAnimation rotate = new RotateAnimation(0,90,(float) (metrics.widthPixels-(metrics.widthPixels*SIMANS_LEFTMARGIN)),90);
	        rotate.setDuration(900);
	       // rotate.setRepeatCount(Animation.INFINITE);
	        rotate.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					if(!isGAMEOVER)
					{
					BOB_Btn.clearAnimation();
					img1.clearAnimation();
					relativeLayout.clearAnimation();
					if(isValidMove)
		     		{
					RIGHTSWIPAnimationAnimation(img1);
					LayoutAnimation(relativeLayout);
		     		}
		     		else
		     		{
		     			isGAMEOVER=true;
		     			AppUtils.ShowAlertDialog(MainActivity.this, "You have made a wrong move..!!");
		     		}
					}//end of game over
				}
			});
	        BOB_Btn.setAnimation(rotate);
	}//end of Right Vertical rotation
	
	public void LeftVerticalRotation_Animation()
	{
		 RotateAnimation rotate = new RotateAnimation(0,-90,-250,60);
	        rotate.setDuration(900);
	       // rotate.setRepeatCount(Animation.INFINITE);
	        rotate.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub

				}
				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					if(!isGAMEOVER)
					{
					BOB_Btn.clearAnimation();
					img1.clearAnimation();
		     		relativeLayout.clearAnimation();
		     		if(isValidMove)
		     		{
					LEFTSWIPAnimation(img1);
					LayoutAnimation(relativeLayout);
		     		}
		     		else
		     		{
		     			isGAMEOVER=true;
		     			AppUtils.ShowAlertDialog(MainActivity.this, "You have made a wrong move..!!");
		     		}
				}//end of game over
				}
			});
	        
	        BOB_Btn.setAnimation(rotate);
	}//end of left Verticals rotation
	
	
} // end of Activity