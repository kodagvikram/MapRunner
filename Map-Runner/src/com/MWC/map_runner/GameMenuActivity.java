package com.MWC.map_runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.MWC.map_runner.FirstRoadScreen.setSIMANSMargins;
import com.MWC.map_runner.Singleton.MapRoad_Singleton;
import com.MWC.map_runner.VO.SimansMarginsVO;

public class GameMenuActivity extends Activity implements AnimationListener {
	public Typeface type;
	Vibrator vibe ;
	Animation zoominanimation,zoomoutanimation,animBounce;
	public ImageView Logoimage,leftimage,rightimage;
	 public static DisplayMetrics metrics;
	    int devicewidth = 0;
	    int deviceheight = 0;
	    public ArrayList<SimansMarginsVO> simanmarginList = new ArrayList<SimansMarginsVO>();
	    int simanindex = 0, simanspeed = 1;
	    long STARTSEC = 0, CURRENTSEC = 0;
	    
	    private Handler customHandler = new Handler();
	    private long Score_startTime = 0L;
		long Score_timeInMilliseconds = 0L;
		long Score_timeSwapBuff = 0L;
		long Score_updatedTime = 0L;
		int updatemint = 1;
		public boolean isGAMEOVER = false, isMovingUp = true, isMovingLeft = false,
				isMovingRight = false, isMovingDown = false, isPause = false,
				isSimanMove = false, isWait = false,isBottom_to_Top=true,isTop_to_Bottom=false,isLeft_to_Right=true,isRight_to_Left=false;
	
		public ImageView BOB_IMAGE, SIMANS_IMAGE;

		double BOB_BOTTOM_MARGIN = -0.80, BOB_LEFT_MARGIN = 0.0,
				BOB_T0P_MARGIN = 0.0, BOB_RIGHT_MARGIN = -0.80,
				SIMAN_LEFT_MARGIN = 0.0, SIMAN_T0P_MARGIN = 0.0;
		public MapRoad_Singleton mapRoad_Singleton;
		
		public void onBackPressed() {
		     Intent startMain = new Intent(Intent.ACTION_MAIN);
		        startMain.addCategory(Intent.CATEGORY_HOME);
		        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		        startActivity(startMain);
		        finish();
		}
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_game_menu);
		try {
			
			metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            devicewidth = (int) (metrics.widthPixels);
            deviceheight = (int) (metrics.heightPixels);
            
            mapRoad_Singleton = MapRoad_Singleton.getInstance(this);

			mapRoad_Singleton.devicewidth = devicewidth;
			mapRoad_Singleton.deviceheight = deviceheight;
		
		 vibe = (Vibrator) this
				.getSystemService(Context.VIBRATOR_SERVICE);
		
		 type = Typeface.createFromAsset(
					this.getAssets(), "fonts/HoboStd.otf");
		final Button playbtn = (Button) findViewById(R.id.PLAYBTN);
		final Button share = (Button) findViewById(R.id.SHARE);
		
		playbtn.setTypeface(type);
		
		setMargins(playbtn, 0.30, 0.60, 0, 0);
		//exit.setTypeface(type);
		share.setTypeface(type);
		
		
		zoominanimation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
		zoomoutanimation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
		animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
		
        
        playbtn.startAnimation(zoomoutanimation);
        zoomoutanimation.setAnimationListener(new AnimationListener() {
			
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
						playbtn.startAnimation(zoomoutanimation);
			}
		});
        
        share.startAnimation(zoominanimation);
        zoominanimation.setAnimationListener(new AnimationListener() {
			
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
				share.startAnimation(zoominanimation);
			}
		});
        
        
		playbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				customHandler.removeCallbacks(updateScoreThread);
				vibe.vibrate(50);
				Intent intent = new Intent(getApplicationContext(),
						FirstRoadScreen.class);
				startActivity(intent);
				finish();
			}
		});

		

      share.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					vibe.vibrate(50);
					launchFacebook();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		});
      
      RelativeLayout mainlayout2 = (RelativeLayout) findViewById(R.id.MAIN_ROAD_RELATIVRLAYOUT);
		int bodsize = (int) (metrics.widthPixels * 0.12);
		int devicewidth = (int) (metrics.widthPixels);
		int deviceheight = (int) (metrics.heightPixels);

		RelativeLayout.LayoutParams Bobparam = new RelativeLayout.LayoutParams(
				bodsize, bodsize);
		BOB_IMAGE = new ImageView(this);
		BOB_IMAGE.setImageResource(R.drawable.bobimage);
		Bobparam.leftMargin = (int) (devicewidth * 0.48);
		Bobparam.topMargin = (int) (deviceheight * 0.48);

		BOB_LEFT_MARGIN = 0.48;
		BOB_T0P_MARGIN = 0.48;
		RelativeLayout.LayoutParams Simanparam = new RelativeLayout.LayoutParams(
				bodsize, bodsize);
		SIMANS_IMAGE = new ImageView(this);
		SIMANS_IMAGE.setImageResource(R.drawable.simamimage);
		Simanparam.leftMargin = (int) (devicewidth * 0.48);
		Simanparam.topMargin = (int) (deviceheight * 0.50);

		SIMAN_LEFT_MARGIN = 0.48;
		SIMAN_T0P_MARGIN = 0.50;
		
		
		mainlayout2.addView(BOB_IMAGE, Bobparam);
		mainlayout2.addView(SIMANS_IMAGE, Simanparam);
		
		setMargins(BOB_IMAGE, BOB_LEFT_MARGIN, BOB_T0P_MARGIN, -6, -6);
		setMargins(SIMANS_IMAGE, BOB_LEFT_MARGIN, BOB_T0P_MARGIN, -6, -6);
		
		Score_startTime = SystemClock.uptimeMillis();
		customHandler.postDelayed(updateScoreThread, 0);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	} //end of oncreate()
	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	
	public final void launchFacebook() {
		try {
		
        final String urlFb = "fb://page/"+"534278026736224";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlFb));

        // If a Facebook app is installed, use it. Otherwise, launch
        // a browser
        final PackageManager packageManager = getPackageManager();
        List<ResolveInfo> list =
            packageManager.queryIntentActivities(intent,
            PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() == 0) {
            final String urlBrowser = "https://www.facebook.com/pages/"+"534278026736224";
            intent.setData(Uri.parse(urlBrowser));
        }

        startActivity(intent);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }//end of Facebook Open
	
	public  void setMargins(View v, double l, double t, double r, double b) {
		if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
			ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v
					.getLayoutParams();

			final float scale = this.getResources().getDisplayMetrics().density;
			int lpx = (int) ((metrics.widthPixels) * l);
			int tpx = (int) ((metrics.heightPixels) * t);
			int rpx = (int) ((metrics.widthPixels) * r);
			int bpx = (int) ((metrics.heightPixels) * b);

			p.setMargins(lpx, tpx, rpx, bpx);
			v.requestLayout();
		}
	}
	
	private Runnable updateScoreThread = new Runnable() {

		public void run() {
			try {
				
			

			Score_timeInMilliseconds = SystemClock.uptimeMillis()
					- Score_startTime;

			Score_updatedTime = Score_timeSwapBuff + Score_timeInMilliseconds;

			
			CURRENTSEC = Score_updatedTime;

			if (CURRENTSEC > STARTSEC + 5000)
			{
				STARTSEC=CURRENTSEC;
				
				 if(randInt(4)==3)
				{
					isMovingUp = false;
					isMovingDown = false;
					isMovingLeft = false;
					isMovingRight = true;
				}
				
				
			}
			
			if (!isGAMEOVER) {
				
				int leftmargin = (int) ((metrics.widthPixels) * BOB_LEFT_MARGIN);
				int topmargin = (int) ((metrics.heightPixels) * BOB_T0P_MARGIN);

				if (isMovingUp) {
					
					if(topmargin<(int) (deviceheight*0.07))
					{
						isMovingUp = false;
						isMovingDown = false;
						isMovingLeft = false;
						isMovingRight = true;
					}
					else
					setMargins(BOB_IMAGE, BOB_LEFT_MARGIN,
							BOB_T0P_MARGIN -= 0.003, 0, 0);
				}// end of moving up
				else if (isMovingDown) {
					if(topmargin>(int) (deviceheight*0.92))
					{
						isMovingUp = false;
						isMovingDown = false;
						isMovingLeft = true;
						isMovingRight = false;
					}
						else
					setMargins(BOB_IMAGE, BOB_LEFT_MARGIN,
							BOB_T0P_MARGIN += 0.003, 0, 0);
				}// end of moving down
				else if (isMovingLeft) {
					if(leftmargin<(int) (devicewidth*0.05))
					{
						isMovingUp = true;
						isMovingDown = false;
						isMovingLeft = false;
						isMovingRight = false;
					}
						else
					setMargins(BOB_IMAGE, BOB_LEFT_MARGIN-=0.005,
							BOB_T0P_MARGIN, 0, 0);
				}// end of moving left
				else if (isMovingRight) {
					if(leftmargin>(int) (devicewidth*0.80))
					{
						isMovingUp = false;
						isMovingDown = true;
						isMovingLeft = false;
						isMovingRight = false;
					}
						else
					setMargins(BOB_IMAGE, BOB_LEFT_MARGIN+=0.005,
							BOB_T0P_MARGIN, 0, 0);
				}// end of moving right
				
						SimansMarginsVO marginsVO = new SimansMarginsVO();
						marginsVO.SIMAN_LEFT_MARGIN = BOB_LEFT_MARGIN;
						marginsVO.SIMAN_T0P_MARGIN =BOB_T0P_MARGIN;
						simanmarginList.add(marginsVO);

						if (simanmarginList.size() > 100
								&& simanindex < simanmarginList.size()
								) {
							try {
								 
								SIMAN_LEFT_MARGIN = simanmarginList
										.get(simanindex).SIMAN_LEFT_MARGIN;
								SIMAN_T0P_MARGIN = simanmarginList
										.get(simanindex).SIMAN_T0P_MARGIN;
								
								setMargins(SIMANS_IMAGE, SIMAN_LEFT_MARGIN,
										SIMAN_T0P_MARGIN, 0, 0);
								//simanmarginList.remove(simanindex);
								    simanindex += 1;

							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}// end of if
				
				


			}// end of if ISGAME OVER

			customHandler.postDelayed(this, 0);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		
	}; // ---------Update scorere end
	
	
	public  int randInt(int max) {
     
		try {
			Random rand = new Random();
			int x = rand.nextInt(max);
			    return x;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			 return 1;
		}
	   
	}


}//end of Activity
