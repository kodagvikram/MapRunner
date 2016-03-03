package com.MWC.map_runner;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.MWC.map_runner.SimpleGestureFilter.SimpleGestureListener;
import com.MWC.map_runner.Singleton.MapRoad_Singleton;
import com.MWC.map_runner.VO.SimansMarginsVO;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class FirstRoadScreen extends Activity implements SimpleGestureListener,
		AnimationListener {

	InterstitialAd mInterstitialAd;
	private SimpleGestureFilter detector;
	private TextView ScoretextView, HighScoretextView;
	Animation zoominanimation, zoomoutanimation, zoomoutanimation2;
	public Button pauseplayImageview;
	public AlertDialog myAlertDialog = null;
	public Typeface type;
	public SharedPreferences sharedPreferences;
	long CURRENT_SCORE = 0;
	int VER_SCROLLINGSPEED = 800;
	int HOR_SCROLLINGSPEED = 350;
	long score = 0, redline = 500, Updatescoretime = 500;
	private long Score_startTime = 0L;
	long Score_timeInMilliseconds = 0L;
	long Score_timeSwapBuff = 0L;
	long Score_updatedTime = 0L;
	int updatemint = 1;

	public double hor_1_top = 0.085, hor_2_top = 0.205, hor_3_top = 0.285,
			hor_4_top = 0.385, hor_5_top = 0.485, hor_6_top = 0.635,
			hor_7_top = 0.735, hor_8_top = 0.885;
	public double ver_1_left = 0.08, ver_2_left = 0.23, ver_3_left = 0.33,
			ver_4_left = 0.48, ver_5_left = 0.73, ver_6_left = 0.88;

	private long startTime = 0L;
	private Handler customHandler = new Handler();
	double SIMANS_BOTTOMMARGIN = 0.01, SIMANS_LEFTMARGIN = 0.45;
	long timeInMilliseconds = 0L;
	long timeSwapBuff = 0L;
	long updatedTime = 0L;
	public ArrayList<SimansMarginsVO> simanmarginList = new ArrayList<SimansMarginsVO>();
	public ArrayList<SimansMarginsVO> GameoverList = new ArrayList<SimansMarginsVO>();

	public boolean isGAMEOVER = false, isMovingUp = true, isMovingLeft = false,
			isMovingRight = false, isMovingDown = false, isPause = false,
			isSimanMove = false, isWait = false, isBottom_to_Top = true,
			isTop_to_Bottom = false, isLeft_to_Right = true,
			isRight_to_Left = false, isValidMove = false;

	public boolean isMaproad1_1 = false, isMaproad1_2 = false,
			isMaproad1_3 = false, isMaproad1_4 = false, isMaproad2_1 = false,
			isMaproad2_2 = true, isMaproad2_3 = false, isMaproad2_4 = false,
			isMaproad3_1 = false, isMaproad3_2 = false, isMaproad3_3 = false,
			isMaproad3_4 = false, isMaproad4_1 = false, isMaproad4_2 = false,
			isMaproad4_3 = false, isMaproad4_4 = false;

	long STARTSEC = 0, CURRENTSEC = 0;
	int simanindex = 0, simanspeed = 1, Overbobindex = 0, Oversimanindex = 0;
	public static DisplayMetrics metrics;
	static Context con;
	public ImageView BOB_IMAGE, SIMANS_IMAGE, tempBOB_IMAGE, tempSIMANS_IMAGE;

	double BOB_BOTTOM_MARGIN = -0.80, BOB_LEFT_MARGIN = 0.0,
			BOB_T0P_MARGIN = 0.0, BOB_RIGHT_MARGIN = -0.80,
			SIMAN_LEFT_MARGIN = 0.0, SIMAN_T0P_MARGIN = 0.0;
	public ScrollView VERTICALSCROLLVIEW;
	public HorizontalScrollView MYHORIZONTALSCROLLVIEW;

	public RelativeLayout layout;
	int road_width = 0;
	int devicewidth = 0;
	int deviceheight = 0;
	public Vibrator vibe;

	public MapRoad_Singleton mapRoad_Singleton;
	public NumberFormat formatter = new DecimalFormat("#0.000");

	public void onBackPressed() {
		pauseplayImageview.performClick();
		Intent startMain = new Intent(Intent.ACTION_MAIN);
		startMain.addCategory(Intent.CATEGORY_HOME);
		startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(startMain);
		finish();

		// runOnUiThread(new Runnable() {
		// public void run() {
		//
		// if (!isPause) {
		// ShowDialog();
		// isPause = true;
		// vibe.vibrate(50);
		// Score_timeSwapBuff += Score_timeInMilliseconds;
		// customHandler
		// .removeCallbacks(updateScoreThread);
		//
		// // try {
		// // MusicService.myservice.pauseMusic();
		// //
		// // } catch (Exception e) {
		// // // TODO: handle exception
		// // e.printStackTrace();
		// // }
		// // pauseplayImageview
		// // .setBackgroundResource(R.drawable.play);
		//
		// }
		// }
		// });
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	// --------------------------------On Create()
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_first_road_screen);
		try {
			mInterstitialAd = new InterstitialAd(this);
			mInterstitialAd
					.setAdUnitId("ca-app-pub-1192482966027684/6699631853");

			// try {
			// Intent music = new Intent();
			// music.setClass(this,MusicService.class);
			// startService(music);
			//
			// } catch (Exception e) {
			// // TODO: handle exception
			// e.printStackTrace();
			// }

			double temp1 = 0.06;
			double temp2 = 0.537;
			GameoverList.clear();

			for (int i = 0; i < 72; i++) {

				SimansMarginsVO marginsVO = new SimansMarginsVO();
				marginsVO.SIMAN_LEFT_MARGIN = temp1 += 0.005;
				marginsVO.SIMAN_T0P_MARGIN = temp2;
				GameoverList.add(marginsVO);
			}

			for (int i = 0; i < 24; i++) {
				SimansMarginsVO marginsVO = new SimansMarginsVO();
				marginsVO.SIMAN_LEFT_MARGIN = temp1;
				marginsVO.SIMAN_T0P_MARGIN = temp2 += 0.003;
				GameoverList.add(marginsVO);
			}

			for (int i = 0; i < 80; i++) {
				SimansMarginsVO marginsVO = new SimansMarginsVO();
				marginsVO.SIMAN_LEFT_MARGIN = temp1 += 0.005;
				marginsVO.SIMAN_T0P_MARGIN = temp2;
				GameoverList.add(marginsVO);
			}

			// zoominanimation=
			// AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
			zoomoutanimation = AnimationUtils.loadAnimation(
					getApplicationContext(), R.anim.zoom_in);
			zoomoutanimation2 = AnimationUtils.loadAnimation(
					getApplicationContext(), R.anim.zoom_out);

			vibe = (Vibrator) FirstRoadScreen.this
					.getSystemService(Context.VIBRATOR_SERVICE);

			type = Typeface.createFromAsset(this.getAssets(),
					"fonts/HoboStd.otf");

			sharedPreferences = PreferenceManager
					.getDefaultSharedPreferences(getApplicationContext());
			con = this;
			metrics = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(metrics);

			// road_width = (int) (metrics.widthPixels * 0.04);
			devicewidth = (int) (metrics.widthPixels);
			deviceheight = (int) (metrics.heightPixels);

			mapRoad_Singleton = MapRoad_Singleton.getInstance(this);

			mapRoad_Singleton.devicewidth = devicewidth;
			mapRoad_Singleton.deviceheight = deviceheight;
			mapRoad_Singleton.road_width = (int) (metrics.widthPixels * 0.04);

			MapRods_Row_1_1(); // ------------------------Dynamic add map roads

			VERTICALSCROLLVIEW = (ScrollView) findViewById(R.id.VERTICAL_SCROLLVIEW);
			VERTICALSCROLLVIEW.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					return true;
				}
			});

			ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
					VERTICALSCROLLVIEW, "scrollY", (int) (deviceheight),
					(int) (deviceheight * 1)).setDuration(1);
			objectAnimator.start();

			MYHORIZONTALSCROLLVIEW = (HorizontalScrollView) findViewById(R.id.HORIZANTAL_SCROLLVIEW);
			MYHORIZONTALSCROLLVIEW
					.setOnTouchListener(new View.OnTouchListener() {
						@Override
						public boolean onTouch(View v, MotionEvent event) {
							// TODO Auto-generated method stub
							return true;
						}
					});
			ObjectAnimator objectAnimator2 = ObjectAnimator.ofInt(
					MYHORIZONTALSCROLLVIEW, "scrollX", (int) (devicewidth),
					(int) (devicewidth * 1)).setDuration(1);
			objectAnimator2.start();

			ScoretextView = (TextView) findViewById(R.id.SCORETEXTVIEW);
			HighScoretextView = (TextView) findViewById(R.id.HIGHSCORETEXTVIEW);
			// timeSwapBuff = 0;

			if (sharedPreferences.getString("HIGHSCORE", "").equalsIgnoreCase(
					"")) {
				HighScoretextView.setText("0");
			} else {
				HighScoretextView.setText(sharedPreferences.getString(
						"HIGHSCORE", ""));
			}

			detector = new SimpleGestureFilter(this, this); // Swip detecter

			pauseplayImageview = (Button) findViewById(R.id.PAUSEPLAY);
			pauseplayImageview.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					runOnUiThread(new Runnable() {
						public void run() {

							if (!isPause) {
								ShowDialog();
								isPause = true;
								vibe.vibrate(50);
								Score_timeSwapBuff += Score_timeInMilliseconds;
								customHandler
										.removeCallbacks(updateScoreThread);

								// try {
								// MusicService.myservice.pauseMusic();
								//
								// } catch (Exception e) {
								// // TODO: handle exception
								// e.printStackTrace();
								// }
								// pauseplayImageview
								// .setBackgroundResource(R.drawable.play);

							}
						}
					});
				}
			});

			RelativeLayout mainlayout2 = (RelativeLayout) findViewById(R.id.MAIN_ROAD_RELATIVRLAYOUT);
			int bodsize = (int) (metrics.widthPixels * 0.07);
			int devicewidth = (int) (metrics.widthPixels);
			int deviceheight = (int) (metrics.heightPixels);

			RelativeLayout.LayoutParams Bobparam = new RelativeLayout.LayoutParams(
					bodsize, bodsize);
			BOB_IMAGE = new ImageView(this);
			BOB_IMAGE.setImageResource(R.drawable.bobimage);
			Bobparam.leftMargin = (int) (devicewidth * 1.48);
			Bobparam.topMargin = (int) (deviceheight * 1.48);

			BOB_LEFT_MARGIN = 1.48;
			BOB_T0P_MARGIN = 1.48;
			RelativeLayout.LayoutParams Simanparam = new RelativeLayout.LayoutParams(
					bodsize, bodsize);
			SIMANS_IMAGE = new ImageView(this);
			SIMANS_IMAGE.setImageResource(R.drawable.simamimage);
			Simanparam.leftMargin = (int) (devicewidth * 1.48);
			Simanparam.topMargin = (int) (deviceheight * 1.50);

			SIMAN_LEFT_MARGIN = 1.48;
			SIMAN_T0P_MARGIN = 1.50;

			mainlayout2.addView(mapRoad_Singleton.NameLayout,
					mapRoad_Singleton.NameLayoutparam);
			mainlayout2.addView(BOB_IMAGE, Bobparam);
			mainlayout2.addView(SIMANS_IMAGE, Simanparam);

			setMargins(BOB_IMAGE, BOB_LEFT_MARGIN, BOB_T0P_MARGIN, 0, 0);
			setMargins(SIMANS_IMAGE, BOB_LEFT_MARGIN, BOB_T0P_MARGIN, 0, 0);

			Score_startTime = SystemClock.uptimeMillis();
			customHandler.postDelayed(updateScoreThread, 0);
			

			AdRequest adRequest = new AdRequest.Builder().build();
			mInterstitialAd.loadAd(adRequest);
			
			mInterstitialAd.setAdListener(new AdListener() {
	            @Override
	            public void onAdClosed() {
	               
	            }
	        });


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// -------------------------------------- end of OnCreate()

	@Override
	public boolean dispatchTouchEvent(MotionEvent me) {
		// Call onTouchEvent of SimpleGestureFilter class
		this.detector.onTouchEvent(me);
		return super.dispatchTouchEvent(me);
	}

	@Override
	public void onSwipe(int direction) {
		String str = "";

		if (!isPause) {
			isWait = true;
			vibe.vibrate(50);
			STARTSEC = CURRENTSEC;
			switch (direction) {
			case SimpleGestureFilter.SWIPE_RIGHT:

				isLeft_to_Right = true;
				isRight_to_Left = false;

				isMovingUp = false;
				isMovingDown = false;
				isMovingLeft = false;
				isMovingRight = true;
				break;// end Swip right
			case SimpleGestureFilter.SWIPE_LEFT:

				isLeft_to_Right = false;
				isRight_to_Left = true;

				isMovingUp = false;
				isMovingDown = false;
				isMovingLeft = true;
				isMovingRight = false;

				break;// end Swip left
			case SimpleGestureFilter.SWIPE_DOWN:

				isTop_to_Bottom = true;
				isBottom_to_Top = false;

				isMovingUp = false;
				isMovingDown = true;
				isMovingLeft = false;
				isMovingRight = false;
				break;// end Swip down
			case SimpleGestureFilter.SWIPE_UP:

				isTop_to_Bottom = false;
				isBottom_to_Top = true;

				isMovingUp = true;
				isMovingDown = false;
				isMovingLeft = false;
				isMovingRight = false;
				break; // end Swip up
			}// end of switch case
			isWait = false;
		} // end of if is not pause
	}// end of detecter

	@Override
	public void onDoubleTap() {
		// Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
	}

	public void setMargins(View v, double l, double t, double r, double b) {
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

			Score_timeInMilliseconds = SystemClock.uptimeMillis()
					- Score_startTime;

			Score_updatedTime = Score_timeSwapBuff + Score_timeInMilliseconds;

			CURRENTSEC = Score_updatedTime;

			if (CURRENTSEC > STARTSEC + 700)
				isSimanMove = true;
			else
				isSimanMove = false;

			if (!isGAMEOVER && !isPause && !isWait) {

				if (Score_updatedTime > redline) {
					redline = Score_updatedTime + 250;
					new Thread(new AddColorView()).start();
				}
				if (Score_updatedTime > Updatescoretime) {
					// score = (long) (Score_updatedTime * 0.005);
					score += 5;
					Updatescoretime += 500;
					CURRENT_SCORE = score;
					// ScoretextView.setText(""+score);
					new Thread(new setMargins()).start();
				}

				int leftmargin = (int) ((metrics.widthPixels) * BOB_LEFT_MARGIN);
				int topmargin = (int) ((metrics.heightPixels) * BOB_T0P_MARGIN);

				if (isMovingUp) {
					if (isLeft_to_Right)
						MoveUP(leftmargin, topmargin);
					else
						MoveUP_Right_to_Left(leftmargin, topmargin);

					// BOB_T0P_MARGIN-=0.003;
					// new Thread(new setBobMargins()).start();

					MoveUpAnimation();
				}// end of moving up
				else if (isMovingDown) {
					if (isLeft_to_Right)
						MoveDown(leftmargin, topmargin);
					else
						MoveDownRight_to_Left(leftmargin, topmargin);

					// BOB_T0P_MARGIN+=0.003;
					// new Thread(new setBobMargins()).start();

					MoveDOWNAnimation();
				}// end of moving down
				else if (isMovingLeft) {
					if (isTop_to_Bottom)
						MoveLeft(leftmargin, topmargin);
					else
						MoveLeftDown_to_up(leftmargin, topmargin);

					// BOB_LEFT_MARGIN-=0.005;
					// new Thread(new setBobMargins()).start();

					MoveLEFTAnimation();
				}// end of moving left
				else if (isMovingRight) {

					if (isTop_to_Bottom)
						MoveRight(leftmargin, topmargin);
					else
						MoveRightDown_to_up(leftmargin, topmargin);

					// BOB_LEFT_MARGIN+=0.005;
					// new Thread(new setBobMargins()).start();

					MoveRIGHTAnimation();
				}// end of moving right

				runOnUiThread(new Runnable() {
					public void run() {
						SimansMarginsVO marginsVO = new SimansMarginsVO();
						marginsVO.SIMAN_LEFT_MARGIN = BOB_LEFT_MARGIN;
						marginsVO.SIMAN_T0P_MARGIN = BOB_T0P_MARGIN;
						if (isMovingUp || isMovingDown)
							marginsVO.isMovingUp = true;
						else
							marginsVO.isMovingUp = false;

						if (isMovingLeft || isMovingRight)
							marginsVO.isMovingRight = true;
						else
							marginsVO.isMovingRight = false;

						simanmarginList.add(marginsVO);

						if (simanmarginList.size() > 100
								&& simanindex < simanmarginList.size()
								&& isSimanMove) {
							try {
								if (simanindex == simanmarginList.size() - 2) {
									isGAMEOVER = true;
									GAMEOVERDIALOG("GAME OVER");

								} else {
									SIMAN_LEFT_MARGIN = simanmarginList
											.get(simanindex).SIMAN_LEFT_MARGIN;
									SIMAN_T0P_MARGIN = simanmarginList
											.get(simanindex).SIMAN_T0P_MARGIN;

									setMargins(SIMANS_IMAGE, SIMAN_LEFT_MARGIN,
											SIMAN_T0P_MARGIN, -6, -6);
									// new Thread(new
									// setSIMANSMargins()).start();
									simanindex += 2;
								}// end of else

							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}// end of if
					}
				});
				runOnUiThread(new Runnable() {
					public void run() {
						for (int k = 0; k < simanmarginList.size() - 3; k++) {
							double simanleftmargin = simanmarginList.get(k).SIMAN_LEFT_MARGIN;
							double simantopmargin = simanmarginList.get(k).SIMAN_T0P_MARGIN;

							// System.out.println("\n\n\n"+simanmarginList+"\n"+simanleftmargin+"\n"+simantopmargin);
							if (simanmarginList.get(k).isMovingUp) {
								if (BOB_LEFT_MARGIN == simanleftmargin
										&& ((BOB_T0P_MARGIN + 0.003) >= simantopmargin && (BOB_T0P_MARGIN - 0.003) <= simantopmargin)) {
									isGAMEOVER = true;
									GAMEOVERDIALOG("GAME OVER");
									break;
								}
							} else {
								if (((BOB_LEFT_MARGIN + 0.005) >= simanleftmargin && (BOB_LEFT_MARGIN - 0.005) <= simanleftmargin)
										&& BOB_T0P_MARGIN == simantopmargin) {
									isGAMEOVER = true;
									GAMEOVERDIALOG("GAME OVER");
									break;
								}
							}// end of else
						}// end of for

					}// end of Run
				});

			}// end of if ISGAME OVER

			customHandler.postDelayed(this, 0);
		}

	}; // ---------Update scorere end

	// --------------------------------------------------Start of Map Road
	void MapRods_Row_1_1() {
		try {

			RelativeLayout mainlayout = (RelativeLayout) findViewById(R.id.MIDDLE_MAP_ROAD);
			mainlayout.removeAllViews();

			mapRoad_Singleton.MapRods_Row_1_1();// ------------------------ROW 1
			mapRoad_Singleton.MapRods_ROW_1_2();
			mapRoad_Singleton.MapRods_ROW_1_3();
			// mapRoad_Singleton.MapRods_ROW_1_4();

			mapRoad_Singleton.MapRods_ROW_2_1(); // ----------ROW 2
			mapRoad_Singleton.MapRods_ROW_2_2();
			mapRoad_Singleton.MapRods_ROW_2_3();
			// mapRoad_Singleton.MapRods_ROW_2_4();

			mapRoad_Singleton.MapRods_ROW_3_1(); // -----------ROW 3
			mapRoad_Singleton.MapRods_ROW_3_2();
			mapRoad_Singleton.MapRods_ROW_3_3();
			// mapRoad_Singleton.MapRods_ROW_3_4();

			// mapRoad_Singleton.MapRods_ROW_4_1(); // ------------ROW 4
			// mapRoad_Singleton.MapRods_ROW_4_2();
			// mapRoad_Singleton.MapRods_ROW_4_3();
			// mapRoad_Singleton.MapRods_ROW_4_4();

			mainlayout.addView(mapRoad_Singleton.layout,
					mapRoad_Singleton.layoutParams);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of list values
		// ----------------------------------------------------end of Map
		// Roads1-------

	public void ShowDialog() {

		try {
			final AlertDialog.Builder popDialog = new AlertDialog.Builder(
					FirstRoadScreen.this);
			final LayoutInflater inflater = (LayoutInflater) FirstRoadScreen.this
					.getSystemService(LAYOUT_INFLATER_SERVICE);

			final View Viewlayout = inflater.inflate(R.layout.activity_dialog,
					(ViewGroup) findViewById(R.id.layout_dialog));

			final Button play = (Button) Viewlayout
					.findViewById(R.id.RESUMEbtn);
			final Button backtomenu = (Button) Viewlayout
					.findViewById(R.id.RETURN_TO_MENU);

			try {
				AdView mAdView3 = (AdView) Viewlayout
						.findViewById(R.id.adView3);
				AdRequest adRequest3 = new AdRequest.Builder().build();
				mAdView3.loadAd(adRequest3);

				AdView mAdView4 = (AdView) Viewlayout
						.findViewById(R.id.adView4);
				AdRequest adRequest4 = new AdRequest.Builder().build();
				mAdView4.loadAd(adRequest4);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			play.setTypeface(type);
			backtomenu.setTypeface(type);
			setMargins(play, 0, 0.05, 0, 0.005);
			// setMargins(back , 0, 0.05, 10, 0.005);
			popDialog.setView(Viewlayout);

			play.startAnimation(zoomoutanimation);
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

					play.startAnimation(zoomoutanimation);

				}
			});

			play.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					vibe.vibrate(50);
					if (isPause) {
						isPause = false;
						Score_startTime = SystemClock.uptimeMillis();
						customHandler.postDelayed(updateScoreThread, 0);
						timeSwapBuff += timeInMilliseconds;

					}

					myAlertDialog.dismiss();
				}
			});

			backtomenu.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						vibe.vibrate(50);
						Intent intent = new Intent(getApplicationContext(),
								GameMenuActivity.class);
						startActivity(intent);
						myAlertDialog.dismiss();
						finish();

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			});

			// myAlertDialog.dismiss();

			myAlertDialog = popDialog.create();
			myAlertDialog.setCancelable(false);
			myAlertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			WindowManager.LayoutParams wmlp = myAlertDialog.getWindow()
					.getAttributes();
			wmlp.gravity = Gravity.CENTER_VERTICAL;
			// wmlp.x = 100; //x position
			// wmlp.y = 100; //y position
			myAlertDialog.show();
			myAlertDialog.getWindow().setLayout(
					(int) (metrics.widthPixels * 1),
					(int) (metrics.heightPixels * 0.70));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}// end of showdialog

	public void Show_GAMEOVER_Dialog(String Message) {
		try {

			final AlertDialog.Builder popDialog = new AlertDialog.Builder(this);
			final LayoutInflater inflater = (LayoutInflater) this
					.getSystemService(LAYOUT_INFLATER_SERVICE);

			final View Viewlayout = inflater.inflate(R.layout.gameover_dialog,
					(ViewGroup) findViewById(R.id.gameover_Relativelayout));

			final Button play = (Button) Viewlayout
					.findViewById(R.id.PLAYAGAIN);
			final Button backtomenu = (Button) Viewlayout
					.findViewById(R.id.RETURN_TO_MENU);

			final TextView msgtextView = (TextView) Viewlayout
					.findViewById(R.id.MESSAGETEXTVIEW);
			final TextView currentscore = (TextView) Viewlayout
					.findViewById(R.id.CURRENTSCORETEXIWIEW);

			msgtextView.setText(Message);
			play.setTypeface(type);
			backtomenu.setTypeface(type);
			popDialog.setView(Viewlayout);

			// ---------------------------------
			try {

				try {
					AdView mAdView = (AdView) Viewlayout
							.findViewById(R.id.adView);
					AdRequest adRequest = new AdRequest.Builder().build();
					mAdView.loadAd(adRequest);

					AdView mAdView2 = (AdView) Viewlayout
							.findViewById(R.id.adView2);
					AdRequest adRequest2 = new AdRequest.Builder().build();
					mAdView2.loadAd(adRequest2);

					if (!sharedPreferences.getString("ADDCOUNT", "")
							.equalsIgnoreCase("")) {
						int temp = Integer.parseInt(sharedPreferences
								.getString("ADDCOUNT", "1"));
						if (temp < 5) {
							temp++;
							SharedPreferences.Editor editor = sharedPreferences
									.edit();
							editor.putString("ADDCOUNT", "" + temp);
							editor.commit();
						} else {
							try {
								if (mInterstitialAd.isLoaded()) {
									mInterstitialAd.show();
								}

							} catch (Exception e) {
								e.printStackTrace();
							}

							temp = 1;
							SharedPreferences.Editor editor = sharedPreferences
									.edit();
							editor.putString("ADDCOUNT", "" + temp);
							editor.commit();
						}
					} else {
						SharedPreferences.Editor editor = sharedPreferences
								.edit();
						editor.putString("ADDCOUNT", "" + 1);
						editor.commit();
					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				tempBOB_IMAGE = (ImageView) Viewlayout
						.findViewById(R.id.BobImage);
				tempSIMANS_IMAGE = (ImageView) Viewlayout
						.findViewById(R.id.SIMANSImage);

				ViewGroup.LayoutParams params3 = tempBOB_IMAGE
						.getLayoutParams();
				params3.height = (int) (devicewidth * 0.07);
				params3.width = (int) (devicewidth * 0.07);

				ViewGroup.LayoutParams params4 = tempSIMANS_IMAGE
						.getLayoutParams();
				params4.height = (int) (devicewidth * 0.07);
				params4.width = (int) (devicewidth * 0.07);

				setMargins(tempBOB_IMAGE,
						GameoverList.get(Overbobindex).SIMAN_LEFT_MARGIN,
						GameoverList.get(Overbobindex).SIMAN_T0P_MARGIN, -1, -1);

				setMargins(tempSIMANS_IMAGE,
						GameoverList.get(Overbobindex).SIMAN_LEFT_MARGIN,
						GameoverList.get(Overbobindex).SIMAN_T0P_MARGIN, -1, -1);

				customHandler.postDelayed(GameoverThread, 0);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			// ---------------------------------

			play.startAnimation(zoomoutanimation);
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

					play.startAnimation(zoomoutanimation);

				}
			});

			zoomoutanimation2.setAnimationListener(new AnimationListener() {

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

					currentscore.startAnimation(zoomoutanimation2);

				}
			});

			if (!sharedPreferences.getString("HIGHSCORE", "").equalsIgnoreCase(
					"")) {
				int temp = Integer.parseInt(sharedPreferences.getString(
						"HIGHSCORE", "0"));
				if (CURRENT_SCORE > temp) {
					SharedPreferences.Editor editor = sharedPreferences.edit();
					editor.putString("HIGHSCORE", "" + CURRENT_SCORE);
					editor.commit();
					currentscore.setText("High Score: " + CURRENT_SCORE);
					currentscore.startAnimation(zoomoutanimation2);
				} else
					currentscore.setText("Score: " + CURRENT_SCORE);
			} else {
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.putString("HIGHSCORE", "" + CURRENT_SCORE);
				editor.commit();
				currentscore.setText("High Score: " + CURRENT_SCORE);
				currentscore.startAnimation(zoomoutanimation2);
			}

			play.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						customHandler.removeCallbacks(GameoverThread, 0);
						vibe.vibrate(50);
						Intent intent = new Intent(getApplicationContext(),
								FirstRoadScreen.class);
						startActivity(intent);
						myAlertDialog.dismiss();
						finish();

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

				}
			});

			backtomenu.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						customHandler.removeCallbacks(GameoverThread, 0);
						vibe.vibrate(50);
						Intent intent = new Intent(getApplicationContext(),
								GameMenuActivity.class);
						startActivity(intent);
						myAlertDialog.dismiss();
						finish();

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			});

			// myAlertDialog.dismiss();

			myAlertDialog = popDialog.create();
			myAlertDialog.setCancelable(false);
			myAlertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			WindowManager.LayoutParams wmlp = myAlertDialog.getWindow()
					.getAttributes();
			wmlp.gravity = Gravity.CENTER_VERTICAL;
			// wmlp.x = 100; //x position
			// wmlp.y = 100; //y position
			myAlertDialog.show();
			myAlertDialog.getWindow().setLayout((int) (metrics.widthPixels),
					(int) (metrics.heightPixels * 0.80));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of showdialog

	public void GAMEOVERDIALOG(String MSG) {
		try {

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// This method will be executed once the timer is over
					vibe.vibrate(50);

				}
			}, 200);

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// This method will be executed once the timer is over
					vibe.vibrate(50);

				}
			}, 350);

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// This method will be executed once the timer is over
					vibe.vibrate(50);

				}
			}, 550);

			Show_GAMEOVER_Dialog(MSG);
			// try {
			// MusicService.myservice.pauseMusic();
			//
			// } catch (Exception e) {
			// // TODO: handle exception
			// e.printStackTrace();
			// }

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}// end of GAMEOVERDIALOD

	// public void ScrollVie
	class setMargins implements Runnable {
		@Override
		public void run() {
			runOnUiThread(new Runnable() {
				public void run() {
					try {
						ScoretextView.setText("" + CURRENT_SCORE);

					} catch (Exception e) {
						e.printStackTrace();
					}// end of catch
				}
			});

		}// end of run
	}// end of Class Thread BOB MOVING RIGHT

	// public void ScrollVie
	class AddColorView implements Runnable {
		@Override
		public void run() {
			runOnUiThread(new Runnable() {
				public void run() {
					try {

						RelativeLayout mainlayout = (RelativeLayout) findViewById(R.id.MIDDLE_MAP_ROAD);
						// ----------------------

						RelativeLayout.LayoutParams params1 = null;
						params1 = new RelativeLayout.LayoutParams(
								(int) (devicewidth * 0.025),
								(int) (deviceheight * 0.02));
						if (isMovingUp) {
							params1.topMargin = (int) (deviceheight * (BOB_T0P_MARGIN + 0.02));
							params1.leftMargin = (int) (devicewidth * (BOB_LEFT_MARGIN + 0.025));
						} else if (isMovingDown) {
							params1.topMargin = (int) (deviceheight * (BOB_T0P_MARGIN));
							params1.leftMargin = (int) (devicewidth * (BOB_LEFT_MARGIN + 0.025));
						} else if (isMovingRight) {
							params1.topMargin = (int) (deviceheight * (BOB_T0P_MARGIN + 0.015));
							params1.leftMargin = (int) (devicewidth * (BOB_LEFT_MARGIN));
						} else if (isMovingLeft) {
							params1.topMargin = (int) (deviceheight * (BOB_T0P_MARGIN + 0.015));
							params1.leftMargin = (int) (devicewidth * (BOB_LEFT_MARGIN + 0.02));
						}

						RelativeLayout hor_road1 = new RelativeLayout(
								FirstRoadScreen.this);
						// hor_road1.setBackgroundColor(Color.parseColor("#f21308"));
						hor_road1
								.setBackgroundResource(R.drawable.circle_shape);

						// --------------------------------Addviews to main
						// layout
						mainlayout.addView(hor_road1, params1);

					} catch (Exception e) {
						e.printStackTrace();
					}// end of catch
				}
			});

		}// end of run
	}// end of Class Thread BOB MOVING RIGHT

	class setSIMANSMargins implements Runnable {
		@Override
		public void run() {
			runOnUiThread(new Runnable() {
				public void run() {
					try {

						if (SIMANS_IMAGE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
							ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) SIMANS_IMAGE
									.getLayoutParams();

							int lpx = (int) ((metrics.widthPixels) * SIMAN_LEFT_MARGIN);
							int tpx = (int) ((metrics.heightPixels) * SIMAN_T0P_MARGIN);
							int rpx = (int) ((metrics.widthPixels) * 0);
							int bpx = (int) ((metrics.heightPixels) * 0);

							p.setMargins(lpx, tpx, rpx, bpx);
							SIMANS_IMAGE.requestLayout();
						}

					} catch (Exception e) {
						e.printStackTrace();
					}// end of catch
				}
			});

		}// end of run
	}// end of Class Thread BOB MOVING RIGHT

	class setBobMargins implements Runnable {
		@Override
		public void run() {
			runOnUiThread(new Runnable() {
				public void run() {
					try {

						if (BOB_IMAGE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
							ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) BOB_IMAGE
									.getLayoutParams();

							int lpx = (int) ((metrics.widthPixels) * BOB_LEFT_MARGIN);
							int tpx = (int) ((metrics.heightPixels) * BOB_T0P_MARGIN);
							int rpx = (int) ((metrics.widthPixels) * 0);
							int bpx = (int) ((metrics.heightPixels) * 0);

							p.setMargins(lpx, tpx, rpx, bpx);
							BOB_IMAGE.requestLayout();
						}

					} catch (Exception e) {
						e.printStackTrace();
					}// end of catch
				}
			});

		}// end of run
	}// end of Class Thread BOB MOVING RIGHT

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

	public void MoveUP(int leftmargin, int topmargin) {

		if (isMaproad1_1) {
			// -----ver 4
			if ((topmargin > (deviceheight * 0.02) && topmargin < (deviceheight * 1.20))
					&& (leftmargin > (int) ((metrics.widthPixels * 0.465)) && leftmargin < (int) ((metrics.widthPixels * 0.495)))) {
				BOB_LEFT_MARGIN = ver_4_left;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.02)
					&& topmargin < (deviceheight * 0.76)
					&& (leftmargin > ((devicewidth * 0.065))) && leftmargin < (devicewidth * 0.095))) {
				BOB_LEFT_MARGIN = ver_1_left;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 0.61)
					&& topmargin < (deviceheight * 0.76)
					&& (leftmargin > (devicewidth * 0.215)) && leftmargin < (devicewidth * 0.245))) {
				BOB_LEFT_MARGIN = ver_2_left;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.51)
					&& (leftmargin > (devicewidth * 0.315)) && leftmargin < (devicewidth * 0.345))) {
				BOB_LEFT_MARGIN = ver_3_left;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.06)
					&& topmargin < (deviceheight * 0.91)
					&& (leftmargin > (devicewidth * 0.715)) && leftmargin < (devicewidth * 0.745))) {
				BOB_LEFT_MARGIN = ver_5_left;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.06)
					&& topmargin < (deviceheight * 1.20)
					&& (leftmargin > (devicewidth * 0.865)) && leftmargin < (devicewidth * 0.895))) {
				BOB_LEFT_MARGIN = ver_6_left;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is mapRoad 1_1
		else if (isMaproad2_1) {

			if ((deviceheight * BOB_T0P_MARGIN) < (deviceheight * 0.98)) {
				isMaproad1_1 = true;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 0.80) && topmargin < (deviceheight * 1.91))
					&& (leftmargin > (int) ((metrics.widthPixels * 0.465)) && leftmargin < (int) ((metrics.widthPixels * 0.495)))) {
				BOB_LEFT_MARGIN = ver_4_left;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 1.06)
					&& topmargin < (deviceheight * 2.20)
					&& (leftmargin > ((devicewidth * 0.065))) && leftmargin < (devicewidth * 0.095))) {
				BOB_LEFT_MARGIN = ver_1_left;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.61)
					&& topmargin < (deviceheight * 2.20)
					&& (leftmargin > (devicewidth * 0.215)) && leftmargin < (devicewidth * 0.245))) {
				BOB_LEFT_MARGIN = ver_2_left;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 1.06)
					&& topmargin < (deviceheight * 1.61)
					&& (leftmargin > (devicewidth * 0.315)) && leftmargin < (devicewidth * 0.345))) {
				BOB_LEFT_MARGIN = ver_3_left;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 1.06)
					&& topmargin < (deviceheight * 1.95)
					&& (leftmargin > (devicewidth * 0.715)) && leftmargin < (devicewidth * 0.745))) {
				BOB_LEFT_MARGIN = ver_5_left;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.80)
					&& topmargin < (deviceheight * 1.91)
					&& (leftmargin > (devicewidth * 0.865)) && leftmargin < (devicewidth * 0.895))) {
				BOB_LEFT_MARGIN = ver_6_left;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is mapRoad 2_1
		else if (isMaproad1_2) {
			// -----ver 4
			if ((topmargin > (deviceheight * 0.07) && topmargin < (deviceheight * 1.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 1.465)) && leftmargin < (int) ((metrics.widthPixels * 1.495)))) {
				BOB_LEFT_MARGIN = ver_4_left + 1;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.76)
					&& (leftmargin > ((devicewidth * 1.065))) && leftmargin < (devicewidth * 1.095))) {
				BOB_LEFT_MARGIN = ver_1_left + 1;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 0.715)
					&& topmargin < (deviceheight * 0.91)
					&& (leftmargin > (devicewidth * 1.215)) && leftmargin < (devicewidth * 1.245))) {
				BOB_LEFT_MARGIN = ver_2_left + 1;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.61)
					&& (leftmargin > (devicewidth * 1.315)) && leftmargin < (devicewidth * 1.345))) {
				BOB_LEFT_MARGIN = ver_3_left + 1;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 1.10)
					&& (leftmargin > (devicewidth * 1.715)) && leftmargin < (devicewidth * 1.745))) {
				BOB_LEFT_MARGIN = ver_5_left + 1;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.03)
					&& topmargin < (deviceheight * 0.75)
					&& (leftmargin > (devicewidth * 1.865)) && leftmargin < (devicewidth * 1.895))) {
				BOB_LEFT_MARGIN = ver_6_left + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 1_2

		else if (isMaproad2_2) {
			if ((deviceheight * BOB_T0P_MARGIN) < (deviceheight * 0.98)) {
				isMaproad1_1 = false;
				isMaproad1_2 = true;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 0.93) && topmargin < (deviceheight * 1.90))
					&& (leftmargin > (int) ((metrics.widthPixels * 1.465)) && leftmargin < (int) ((metrics.widthPixels * 1.495)))) {
				BOB_LEFT_MARGIN = ver_4_left + 1;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.76)
					&& (leftmargin > ((devicewidth * 1.065))) && leftmargin < (devicewidth * 1.095))) {
				BOB_LEFT_MARGIN = ver_1_left + 1;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.715)
					&& topmargin < (deviceheight * 1.91)
					&& (leftmargin > (devicewidth * 1.215)) && leftmargin < (devicewidth * 1.245))) {
				BOB_LEFT_MARGIN = ver_2_left + 1;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.61)
					&& (leftmargin > (devicewidth * 1.315)) && leftmargin < (devicewidth * 1.345))) {
				BOB_LEFT_MARGIN = ver_3_left + 1;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.93)
					&& topmargin < (deviceheight * 2.10)
					&& (leftmargin > (devicewidth * 1.715)) && leftmargin < (devicewidth * 1.745))) {
				BOB_LEFT_MARGIN = ver_5_left + 1;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.065)
					&& topmargin < (deviceheight * 2.10)
					&& (leftmargin > (devicewidth * 1.865)) && leftmargin < (devicewidth * 1.895))) {
				BOB_LEFT_MARGIN = ver_6_left + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 2_2

		else if (isMaproad1_3) {
			// -----ver 4
			if ((topmargin > (deviceheight * 0.07) && topmargin < (deviceheight * 0.90))
					&& (leftmargin > (int) ((metrics.widthPixels * 2.465)) && leftmargin < (int) ((metrics.widthPixels * 2.495)))) {
				BOB_LEFT_MARGIN = ver_4_left + 2;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 1.20)
					&& (leftmargin > ((devicewidth * 2.065))) && leftmargin < (devicewidth * 2.095))) {
				BOB_LEFT_MARGIN = ver_1_left + 2;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 0.715)
					&& topmargin < (deviceheight * 0.91)
					&& (leftmargin > (devicewidth * 2.215)) && leftmargin < (devicewidth * 2.245))) {
				BOB_LEFT_MARGIN = ver_2_left + 2;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.61)
					&& (leftmargin > (devicewidth * 2.315)) && leftmargin < (devicewidth * 2.345))) {
				BOB_LEFT_MARGIN = ver_3_left + 2;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.065)
					&& topmargin < (deviceheight * 1.10)
					&& (leftmargin > (devicewidth * 2.715)) && leftmargin < (devicewidth * 2.745))) {
				BOB_LEFT_MARGIN = ver_5_left + 2;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.065)
					&& topmargin < (deviceheight * 0.81)
					&& (leftmargin > (devicewidth * 2.865)) && leftmargin < (devicewidth * 2.895))) {
				BOB_LEFT_MARGIN = ver_6_left + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 1_3
		else if (isMaproad2_3) {

			if ((deviceheight * BOB_T0P_MARGIN) < (deviceheight * 0.98)
					&& (deviceheight * BOB_T0P_MARGIN) > (deviceheight * 0.94)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = true;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 2.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 2.465)) && leftmargin < (int) ((metrics.widthPixels * 2.495)))) {
				BOB_LEFT_MARGIN = ver_4_left + 2;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.93)
					&& topmargin < (deviceheight * 1.75)
					&& (leftmargin > ((devicewidth * 2.065))) && leftmargin < (devicewidth * 2.095))) {
				BOB_LEFT_MARGIN = ver_1_left + 2;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.715)
					&& topmargin < (deviceheight * 1.90)
					&& (leftmargin > (devicewidth * 2.215)) && leftmargin < (devicewidth * 2.245))) {
				BOB_LEFT_MARGIN = ver_2_left + 2;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.60)
					&& (leftmargin > (devicewidth * 2.315)) && leftmargin < (devicewidth * 2.345))) {
				BOB_LEFT_MARGIN = ver_3_left + 2;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.93)
					&& topmargin < (deviceheight * 1.90)
					&& (leftmargin > (devicewidth * 2.715)) && leftmargin < (devicewidth * 2.745))) {
				BOB_LEFT_MARGIN = ver_5_left + 2;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.065)
					&& topmargin < (deviceheight * 2.10)
					&& (leftmargin > (devicewidth * 2.865)) && leftmargin < (devicewidth * 2.895))) {
				BOB_LEFT_MARGIN = ver_6_left + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 2_3
		else if (isMaproad3_1) {

			if ((deviceheight * BOB_T0P_MARGIN) < (deviceheight * 2)
					&& (deviceheight * BOB_T0P_MARGIN) > (deviceheight * 1.94)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = true;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----ver 4
			if ((topmargin > (deviceheight * 2.01) && topmargin < (deviceheight * 3.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 0.465)) && leftmargin < (int) ((metrics.widthPixels * 0.495)))) {
				BOB_LEFT_MARGIN = ver_4_left;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.90)
					&& (leftmargin > ((devicewidth * 0.065))) && leftmargin < (devicewidth * 0.095))) {
				BOB_LEFT_MARGIN = ver_1_left;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.35)
					&& (leftmargin > (devicewidth * 0.215)) && leftmargin < (devicewidth * 0.245))) {
				BOB_LEFT_MARGIN = ver_2_left;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 2.265)
					&& topmargin < (deviceheight * 2.80)
					&& (leftmargin > (devicewidth * 0.315)) && leftmargin < (devicewidth * 0.345))) {
				BOB_LEFT_MARGIN = ver_3_left;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 0.715)) && leftmargin < (devicewidth * 0.745))) {
				BOB_LEFT_MARGIN = ver_5_left;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.90)
					&& (leftmargin > (devicewidth * 0.865)) && leftmargin < (devicewidth * 0.895))) {
				BOB_LEFT_MARGIN = ver_6_left;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is mapRoad 3_1
		else if (isMaproad3_2) {
			if ((deviceheight * BOB_T0P_MARGIN) < (deviceheight * 1.99)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = true;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 3.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 1.465)) && leftmargin < (int) ((metrics.widthPixels * 1.495)))) {
				BOB_LEFT_MARGIN = ver_4_left + 1;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.75)
					&& (leftmargin > ((devicewidth * 1.065))) && leftmargin < (devicewidth * 1.095))) {
				BOB_LEFT_MARGIN = ver_1_left + 1;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 2.715)
					&& topmargin < (deviceheight * 2.905)
					&& (leftmargin > (devicewidth * 1.215)) && leftmargin < (devicewidth * 1.245))) {
				BOB_LEFT_MARGIN = ver_2_left + 1;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.61)
					&& (leftmargin > (devicewidth * 1.315)) && leftmargin < (devicewidth * 1.345))) {
				BOB_LEFT_MARGIN = ver_3_left + 1;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.75)
					&& (leftmargin > (devicewidth * 1.715)) && leftmargin < (devicewidth * 1.745))) {
				BOB_LEFT_MARGIN = ver_5_left + 1;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 1.865)) && leftmargin < (devicewidth * 1.895))) {
				BOB_LEFT_MARGIN = ver_6_left + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 3_2
		else if (isMaproad3_3) {
			if ((deviceheight * BOB_T0P_MARGIN) < (deviceheight * 2)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = true;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----ver 4
			if ((topmargin > (deviceheight * 1.93) && topmargin < (deviceheight * 2.35))
					&& (leftmargin > (int) ((metrics.widthPixels * 2.465)) && leftmargin < (int) ((metrics.widthPixels * 2.495)))) {
				BOB_LEFT_MARGIN = ver_4_left + 2;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.85)
					&& (leftmargin > ((devicewidth * 2.065))) && leftmargin < (devicewidth * 2.095))) {
				BOB_LEFT_MARGIN = ver_1_left + 2;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 2.715)
					&& topmargin < (deviceheight * 2.90)
					&& (leftmargin > (devicewidth * 2.215)) && leftmargin < (devicewidth * 2.245))) {
				BOB_LEFT_MARGIN = ver_2_left + 2;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 2.185)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 2.315)) && leftmargin < (devicewidth * 2.345))) {
				BOB_LEFT_MARGIN = ver_3_left + 2;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 2.715)) && leftmargin < (devicewidth * 2.745))) {
				BOB_LEFT_MARGIN = ver_5_left + 2;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.50)
					&& (leftmargin > (devicewidth * 2.865)) && leftmargin < (devicewidth * 2.895))) {
				BOB_LEFT_MARGIN = ver_6_left + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is mapRoad 3_3

		if (isValidMove)
			setMargins(BOB_IMAGE, BOB_LEFT_MARGIN, BOB_T0P_MARGIN -= 0.0037,
					-6, -6);
		else {
			isGAMEOVER = true;
			GAMEOVERDIALOG("GAME OVER");
		}

	}// end of is moving up

	public void MoveDown(int leftmargin, int topmargin) {

		if (isMaproad1_1) {
			if ((deviceheight * BOB_T0P_MARGIN) > (deviceheight * 0.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = true;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 0.02) && topmargin < (deviceheight * 1.20))
					&& (leftmargin > (int) ((metrics.widthPixels * 0.465)) && leftmargin < (int) ((metrics.widthPixels * 0.495)))) {
				BOB_LEFT_MARGIN = ver_4_left;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.02)
					&& topmargin < (deviceheight * 0.76)
					&& (leftmargin > ((devicewidth * 0.065))) && leftmargin < (devicewidth * 0.095))) {
				BOB_LEFT_MARGIN = ver_1_left;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 0.61)
					&& topmargin < (deviceheight * 0.76)
					&& (leftmargin > (devicewidth * 0.215)) && leftmargin < (devicewidth * 0.245))) {
				BOB_LEFT_MARGIN = ver_2_left;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.51)
					&& (leftmargin > (devicewidth * 0.315)) && leftmargin < (devicewidth * 0.345))) {
				BOB_LEFT_MARGIN = ver_3_left;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.06)
					&& topmargin < (deviceheight * 0.91)
					&& (leftmargin > (devicewidth * 0.715)) && leftmargin < (devicewidth * 0.745))) {
				BOB_LEFT_MARGIN = ver_5_left;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.06)
					&& topmargin < (deviceheight * 1.20)
					&& (leftmargin > (devicewidth * 0.865)) && leftmargin < (devicewidth * 0.895))) {
				BOB_LEFT_MARGIN = ver_6_left;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 1_1
		else if (isMaproad2_1) {
			if ((deviceheight * BOB_T0P_MARGIN) > (deviceheight * 1.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = true;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 0.80) && topmargin < (deviceheight * 1.91))
					&& (leftmargin > (int) ((metrics.widthPixels * 0.465)) && leftmargin < (int) ((metrics.widthPixels * 0.495)))) {
				BOB_LEFT_MARGIN = ver_4_left;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 1.06)
					&& topmargin < (deviceheight * 2.20)
					&& (leftmargin > ((devicewidth * 0.065))) && leftmargin < (devicewidth * 0.095))) {
				BOB_LEFT_MARGIN = ver_1_left;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.61)
					&& topmargin < (deviceheight * 2.20)
					&& (leftmargin > (devicewidth * 0.215)) && leftmargin < (devicewidth * 0.245))) {
				BOB_LEFT_MARGIN = ver_2_left;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 1.06)
					&& topmargin < (deviceheight * 1.61)
					&& (leftmargin > (devicewidth * 0.315)) && leftmargin < (devicewidth * 0.345))) {
				BOB_LEFT_MARGIN = ver_3_left;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.95)
					&& (leftmargin > (devicewidth * 0.715)) && leftmargin < (devicewidth * 0.745))) {
				BOB_LEFT_MARGIN = ver_5_left;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.80)
					&& topmargin < (deviceheight * 1.91)
					&& (leftmargin > (devicewidth * 0.865)) && leftmargin < (devicewidth * 0.895))) {
				BOB_LEFT_MARGIN = ver_6_left;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is mapRoad 2_1
		else if (isMaproad1_2) {
			if ((deviceheight * BOB_T0P_MARGIN) > (deviceheight * 0.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = true;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 0.07) && topmargin < (deviceheight * 1.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 1.465)) && leftmargin < (int) ((metrics.widthPixels * 1.495)))) {
				BOB_LEFT_MARGIN = ver_4_left + 1;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.76)
					&& (leftmargin > ((devicewidth * 1.065))) && leftmargin < (devicewidth * 1.095))) {
				BOB_LEFT_MARGIN = ver_1_left + 1;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 0.715)
					&& topmargin < (deviceheight * 0.91)
					&& (leftmargin > (devicewidth * 1.215)) && leftmargin < (devicewidth * 1.245))) {
				BOB_LEFT_MARGIN = ver_2_left + 1;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.61)
					&& (leftmargin > (devicewidth * 1.315)) && leftmargin < (devicewidth * 1.345))) {
				BOB_LEFT_MARGIN = ver_3_left + 1;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 1.10)
					&& (leftmargin > (devicewidth * 1.715)) && leftmargin < (devicewidth * 1.745))) {
				BOB_LEFT_MARGIN = ver_5_left + 1;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.03)
					&& topmargin < (deviceheight * 0.75)
					&& (leftmargin > (devicewidth * 1.865)) && leftmargin < (devicewidth * 1.895))) {
				BOB_LEFT_MARGIN = ver_6_left + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 1_2

		else if (isMaproad2_2) {
			if ((deviceheight * BOB_T0P_MARGIN) > (deviceheight * 1.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = true;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----ver 4
			if ((topmargin > (deviceheight * 0.93) && topmargin < (deviceheight * 1.90))
					&& (leftmargin > (int) ((metrics.widthPixels * 1.465)) && leftmargin < (int) ((metrics.widthPixels * 1.495)))) {
				BOB_LEFT_MARGIN = ver_4_left + 1;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.76)
					&& (leftmargin > ((devicewidth * 1.065))) && leftmargin < (devicewidth * 1.095))) {
				BOB_LEFT_MARGIN = ver_1_left + 1;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.715)
					&& topmargin < (deviceheight * 1.91)
					&& (leftmargin > (devicewidth * 1.215)) && leftmargin < (devicewidth * 1.245))) {
				BOB_LEFT_MARGIN = ver_2_left + 1;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.61)
					&& (leftmargin > (devicewidth * 1.315)) && leftmargin < (devicewidth * 1.345))) {
				BOB_LEFT_MARGIN = ver_3_left + 1;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.93)
					&& topmargin < (deviceheight * 2.10)
					&& (leftmargin > (devicewidth * 1.715)) && leftmargin < (devicewidth * 1.745))) {
				BOB_LEFT_MARGIN = ver_5_left + 1;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.065)
					&& topmargin < (deviceheight * 2.10)
					&& (leftmargin > (devicewidth * 1.865)) && leftmargin < (devicewidth * 1.895))) {
				BOB_LEFT_MARGIN = ver_6_left + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 2_2
		else if (isMaproad1_3) {

			if ((deviceheight * BOB_T0P_MARGIN) > (deviceheight * 0.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = true;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 0.07) && topmargin < (deviceheight * 0.90))
					&& (leftmargin > (int) ((metrics.widthPixels * 2.465)) && leftmargin < (int) ((metrics.widthPixels * 2.495)))) {
				BOB_LEFT_MARGIN = ver_4_left + 2;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 1.20)
					&& (leftmargin > ((devicewidth * 2.065))) && leftmargin < (devicewidth * 2.095))) {
				BOB_LEFT_MARGIN = ver_1_left + 2;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 0.715)
					&& topmargin < (deviceheight * 0.91)
					&& (leftmargin > (devicewidth * 2.215)) && leftmargin < (devicewidth * 2.245))) {
				BOB_LEFT_MARGIN = ver_2_left + 2;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.61)
					&& (leftmargin > (devicewidth * 2.315)) && leftmargin < (devicewidth * 2.345))) {
				BOB_LEFT_MARGIN = ver_3_left + 2;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.065)
					&& topmargin < (deviceheight * 1.10)
					&& (leftmargin > (devicewidth * 2.715)) && leftmargin < (devicewidth * 2.745))) {
				BOB_LEFT_MARGIN = ver_5_left + 2;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.065)
					&& topmargin < (deviceheight * 0.81)
					&& (leftmargin > (devicewidth * 2.865)) && leftmargin < (devicewidth * 2.895))) {
				BOB_LEFT_MARGIN = ver_6_left + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 1_3
		else if (isMaproad2_3) {
			if ((deviceheight * BOB_T0P_MARGIN) > (deviceheight * 1.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = true;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----ver 4
			if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 2.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 2.465)) && leftmargin < (int) ((metrics.widthPixels * 2.495)))) {
				BOB_LEFT_MARGIN = ver_4_left + 2;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.93)
					&& topmargin < (deviceheight * 1.75)
					&& (leftmargin > ((devicewidth * 2.065))) && leftmargin < (devicewidth * 2.095))) {
				BOB_LEFT_MARGIN = ver_1_left + 2;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.715)
					&& topmargin < (deviceheight * 1.90)
					&& (leftmargin > (devicewidth * 2.215)) && leftmargin < (devicewidth * 2.245))) {
				BOB_LEFT_MARGIN = ver_2_left + 2;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.60)
					&& (leftmargin > (devicewidth * 2.315)) && leftmargin < (devicewidth * 2.345))) {
				BOB_LEFT_MARGIN = ver_3_left + 2;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.93)
					&& topmargin < (deviceheight * 1.90)
					&& (leftmargin > (devicewidth * 2.715)) && leftmargin < (devicewidth * 2.745))) {
				BOB_LEFT_MARGIN = ver_5_left + 2;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.065)
					&& topmargin < (deviceheight * 2.10)
					&& (leftmargin > (devicewidth * 2.865)) && leftmargin < (devicewidth * 2.895))) {
				BOB_LEFT_MARGIN = ver_6_left + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 2_3

		else if (isMaproad3_1) {

			// -----ver 4
			if ((topmargin > (deviceheight * 2.01) && topmargin < (deviceheight * 3.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 0.465)) && leftmargin < (int) ((metrics.widthPixels * 0.495)))) {
				BOB_LEFT_MARGIN = ver_4_left;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.90)
					&& (leftmargin > ((devicewidth * 0.065))) && leftmargin < (devicewidth * 0.095))) {
				BOB_LEFT_MARGIN = ver_1_left;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.35)
					&& (leftmargin > (devicewidth * 0.215)) && leftmargin < (devicewidth * 0.245))) {
				BOB_LEFT_MARGIN = ver_2_left;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 2.265)
					&& topmargin < (deviceheight * 2.80)
					&& (leftmargin > (devicewidth * 0.315)) && leftmargin < (devicewidth * 0.345))) {
				BOB_LEFT_MARGIN = ver_3_left;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 0.715)) && leftmargin < (devicewidth * 0.745))) {
				BOB_LEFT_MARGIN = ver_5_left;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.90)
					&& (leftmargin > (devicewidth * 0.865)) && leftmargin < (devicewidth * 0.895))) {
				BOB_LEFT_MARGIN = ver_6_left;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is mapRoad 3_1
		else if (isMaproad3_2) {

			// -----ver 4
			if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 3.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 1.465)) && leftmargin < (int) ((metrics.widthPixels * 1.495)))) {
				BOB_LEFT_MARGIN = ver_4_left + 1;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.75)
					&& (leftmargin > ((devicewidth * 1.065))) && leftmargin < (devicewidth * 1.095))) {
				BOB_LEFT_MARGIN = ver_1_left + 1;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 2.715)
					&& topmargin < (deviceheight * 2.905)
					&& (leftmargin > (devicewidth * 1.215)) && leftmargin < (devicewidth * 1.245))) {
				BOB_LEFT_MARGIN = ver_2_left + 1;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.61)
					&& (leftmargin > (devicewidth * 1.315)) && leftmargin < (devicewidth * 1.345))) {
				BOB_LEFT_MARGIN = ver_3_left + 1;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.75)
					&& (leftmargin > (devicewidth * 1.715)) && leftmargin < (devicewidth * 1.745))) {
				BOB_LEFT_MARGIN = ver_5_left + 1;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 1.865)) && leftmargin < (devicewidth * 1.895))) {
				BOB_LEFT_MARGIN = ver_6_left + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 3_2
		else if (isMaproad3_3) {

			// -----ver 4
			if ((topmargin > (deviceheight * 1.93) && topmargin < (deviceheight * 2.35))
					&& (leftmargin > (int) ((metrics.widthPixels * 2.465)) && leftmargin < (int) ((metrics.widthPixels * 2.495)))) {
				BOB_LEFT_MARGIN = ver_4_left + 2;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.85)
					&& (leftmargin > ((devicewidth * 2.065))) && leftmargin < (devicewidth * 2.095))) {
				BOB_LEFT_MARGIN = ver_1_left + 2;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 2.715)
					&& topmargin < (deviceheight * 2.90)
					&& (leftmargin > (devicewidth * 2.215)) && leftmargin < (devicewidth * 2.245))) {
				BOB_LEFT_MARGIN = ver_2_left + 2;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 2.185)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 2.315)) && leftmargin < (devicewidth * 2.345))) {
				BOB_LEFT_MARGIN = ver_3_left + 2;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 2.715)) && leftmargin < (devicewidth * 2.745))) {
				BOB_LEFT_MARGIN = ver_5_left + 2;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.50)
					&& (leftmargin > (devicewidth * 2.865)) && leftmargin < (devicewidth * 2.895))) {
				BOB_LEFT_MARGIN = ver_6_left + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 3_3

		if (isValidMove)
			setMargins(BOB_IMAGE, BOB_LEFT_MARGIN, BOB_T0P_MARGIN += 0.0037,
					-6, -6);
		else {
			isGAMEOVER = true;
			GAMEOVERDIALOG("GAME OVER");
		}
	}// end of move down

	public void MoveLeft(int leftmargin, int topmargin) {
		if (isMaproad1_1) {
			// -----hor 5
			if ((topmargin > (deviceheight * 0.465) && topmargin < (deviceheight * 0.495))
					&& (leftmargin > (devicewidth * 0.06) && leftmargin < ((devicewidth * 1.20)))) {
				BOB_T0P_MARGIN = hor_5_top;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 0.065) && topmargin < (deviceheight * 0.095))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_1_top;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 0.185) && topmargin < (deviceheight * 0.215))
					&& (leftmargin > ((devicewidth * 0.165)) && leftmargin < ((devicewidth * 1.20)))) {
				BOB_T0P_MARGIN = hor_2_top;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 0.265) && topmargin < (deviceheight * 0.295))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.76)))) {
				BOB_T0P_MARGIN = hor_3_top;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 0.365) && topmargin < (deviceheight * 0.395))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_4_top;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 0.615) && topmargin < (deviceheight * 0.645))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.51)))) {
				BOB_T0P_MARGIN = hor_6_top;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 0.715) && topmargin < (deviceheight * 0.745))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 1.20)))) {
				BOB_T0P_MARGIN = hor_7_top;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 0.865) && topmargin < (deviceheight * 0.895))
					&& (leftmargin > ((devicewidth * 0.415)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_8_top;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 1_1
		else if (isMaproad2_1) {
			// -----hor 5
			if ((topmargin > (deviceheight * 1.465) && topmargin < (deviceheight * 1.495))
					&& (leftmargin > (devicewidth * 0.06) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_5_top + 1;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 1.095))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_1_top + 1;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 1.185) && topmargin < (deviceheight * 1.215))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.83)))) {
				BOB_T0P_MARGIN = hor_2_top + 1;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 1.265) && topmargin < (deviceheight * 1.295))
					&& (leftmargin > ((devicewidth * 0.215)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_3_top + 1;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 1.365) && topmargin < (deviceheight * 1.395))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.36)))) {
				BOB_T0P_MARGIN = hor_4_top + 1;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 1.615) && topmargin < (deviceheight * 1.645))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_6_top + 1;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 1.715) && topmargin < (deviceheight * 1.745))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_7_top + 1;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 1.865) && topmargin < (deviceheight * 1.895))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_8_top + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 2_1
		else if (isMaproad1_2) {

			if ((devicewidth * BOB_LEFT_MARGIN) < (devicewidth)) {
				isMaproad1_1 = true;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----hor 5
			if ((topmargin > (deviceheight * 0.465) && topmargin < (deviceheight * 0.495))
					&& (leftmargin > (devicewidth * 0.96) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_5_top;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 0.065) && topmargin < (deviceheight * 0.095))
					&& (leftmargin > ((devicewidth * 1.06)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_1_top;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 0.185) && topmargin < (deviceheight * 0.215))
					&& (leftmargin > ((devicewidth * 0.96)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_2_top;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 0.265) && topmargin < (deviceheight * 0.295))
					&& (leftmargin > ((devicewidth * 1.06)) && leftmargin < ((devicewidth * 1.35)))) {
				BOB_T0P_MARGIN = hor_3_top;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 0.365) && topmargin < (deviceheight * 0.395))
					&& (leftmargin > ((devicewidth * 1.06)) && leftmargin < ((devicewidth * 1.51)))) {
				BOB_T0P_MARGIN = hor_4_top;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 0.615) && topmargin < (deviceheight * 0.645))
					&& (leftmargin > ((devicewidth * 1.565)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_6_top;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 0.715) && topmargin < (deviceheight * 0.745))
					&& (leftmargin > ((devicewidth * 0.96)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_7_top;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 0.865) && topmargin < (deviceheight * 0.895))
					&& (leftmargin > ((devicewidth * 1.215)) && leftmargin < ((devicewidth * 1.75)))) {
				BOB_T0P_MARGIN = hor_8_top;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 1_2
		else if (isMaproad2_2) {
			if ((devicewidth * BOB_LEFT_MARGIN) < (devicewidth)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = true;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----hor 5
			if ((topmargin > (deviceheight * 1.465) && topmargin < (deviceheight * 1.495))
					&& (leftmargin > (devicewidth * 1.065) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 1;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 1.095))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 1;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 1.185) && topmargin < (deviceheight * 1.215))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_2_top + 1;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 1.265) && topmargin < (deviceheight * 1.295))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.25)))) {
				BOB_T0P_MARGIN = hor_3_top + 1;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 1.365) && topmargin < (deviceheight * 1.395))
					&& (leftmargin > ((devicewidth * 1.465)) && leftmargin < ((devicewidth * 1.905)))) {
				BOB_T0P_MARGIN = hor_4_top + 1;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 1.615) && topmargin < (deviceheight * 1.645))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.40)))) {
				BOB_T0P_MARGIN = hor_6_top + 1;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 1.715) && topmargin < (deviceheight * 1.745))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_7_top + 1;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 1.865) && topmargin < (deviceheight * 1.895))
					&& (leftmargin > ((devicewidth * 1.215)) && leftmargin < ((devicewidth * 1.75)))) {
				BOB_T0P_MARGIN = hor_8_top + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 2_2

		else if (isMaproad1_3) {
			if ((devicewidth * BOB_LEFT_MARGIN) < (devicewidth * 2)) {
				isMaproad1_1 = false;
				isMaproad1_2 = true;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----hor 5
			if ((topmargin > (deviceheight * 0.465) && topmargin < (deviceheight * 0.495))
					&& (leftmargin > (devicewidth * 2.315) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_5_top;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 0.065) && topmargin < (deviceheight * 0.095))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.91)))) {
				BOB_T0P_MARGIN = hor_1_top;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 0.185) && topmargin < (deviceheight * 0.215))
					&& (leftmargin > ((devicewidth * 2.46)) && leftmargin < ((devicewidth * 2.91)))) {
				BOB_T0P_MARGIN = hor_2_top;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 0.265) && topmargin < (deviceheight * 0.295))
					&& (leftmargin > ((devicewidth * 2.315)) && leftmargin < ((devicewidth * 2.60)))) {
				BOB_T0P_MARGIN = hor_3_top;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 0.365) && topmargin < (deviceheight * 0.395))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.51)))) {
				BOB_T0P_MARGIN = hor_4_top;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 0.615) && topmargin < (deviceheight * 0.645))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.40)))) {
				BOB_T0P_MARGIN = hor_6_top;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 0.715) && topmargin < (deviceheight * 0.745))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_7_top;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 0.865) && topmargin < (deviceheight * 0.895))
					&& (leftmargin > ((devicewidth * 2.215)) && leftmargin < ((devicewidth * 2.75)))) {
				BOB_T0P_MARGIN = hor_8_top;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 1_3
		else if (isMaproad2_3) {

			if ((devicewidth * BOB_LEFT_MARGIN) < (devicewidth * 2)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = true;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----hor 5
			if ((topmargin > (deviceheight * 1.465) && topmargin < (deviceheight * 1.495))
					&& (leftmargin > (devicewidth * 2.185) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 1;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 1.095))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 1;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 1.185) && topmargin < (deviceheight * 1.215))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.40)))) {
				BOB_T0P_MARGIN = hor_2_top + 1;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 1.265) && topmargin < (deviceheight * 1.295))
					&& (leftmargin > ((devicewidth * 2.315)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_3_top + 1;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 1.365) && topmargin < (deviceheight * 1.395))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_4_top + 1;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 1.615) && topmargin < (deviceheight * 1.645))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_6_top + 1;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 1.715) && topmargin < (deviceheight * 1.745))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.25)))) {
				BOB_T0P_MARGIN = hor_7_top + 1;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 1.865) && topmargin < (deviceheight * 1.895))
					&& (leftmargin > ((devicewidth * 2.215)) && leftmargin < ((devicewidth * 2.75)))) {
				BOB_T0P_MARGIN = hor_8_top + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 2_3
		else if (isMaproad3_1) {
			// -----hor 5
			if ((topmargin > (deviceheight * 2.465) && topmargin < (deviceheight * 2.495))
					&& (leftmargin > (devicewidth * 0.06) && leftmargin < ((devicewidth * 0.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 2;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 2.095))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_1_top + 2;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 2.185) && topmargin < (deviceheight * 2.215))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.81)))) {
				BOB_T0P_MARGIN = hor_2_top + 2;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 2.265) && topmargin < (deviceheight * 2.295))
					&& (leftmargin > ((devicewidth * 0.215)) && leftmargin < ((devicewidth * 0.75)))) {
				BOB_T0P_MARGIN = hor_3_top + 2;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 2.365) && topmargin < (deviceheight * 2.395))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.35)))) {
				BOB_T0P_MARGIN = hor_4_top + 2;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 2.615) && topmargin < (deviceheight * 2.645))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.50)))) {
				BOB_T0P_MARGIN = hor_6_top + 2;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 2.715) && topmargin < (deviceheight * 2.745))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_7_top + 2;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 2.865) && topmargin < (deviceheight * 2.895))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_8_top + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 3_1
		else if (isMaproad3_2) {
			if ((devicewidth * BOB_LEFT_MARGIN) < (devicewidth)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = true;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----hor 5
			if ((topmargin > (deviceheight * 2.465) && topmargin < (deviceheight * 2.495))
					&& (leftmargin > (devicewidth * 1.065) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 2;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 2.095))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 2;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 2.185) && topmargin < (deviceheight * 2.215))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.51)))) {
				BOB_T0P_MARGIN = hor_2_top + 2;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 2.265) && topmargin < (deviceheight * 2.295))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.35)))) {
				BOB_T0P_MARGIN = hor_3_top + 2;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 2.365) && topmargin < (deviceheight * 2.395))
					&& (leftmargin > ((devicewidth * 1.465)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_4_top + 2;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 2.615) && topmargin < (deviceheight * 2.645))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_6_top + 2;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 2.715) && topmargin < (deviceheight * 2.745))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.40)))) {
				BOB_T0P_MARGIN = hor_7_top + 2;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 2.865) && topmargin < (deviceheight * 2.895))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.51)))) {
				BOB_T0P_MARGIN = hor_8_top + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 3_2
		else if (isMaproad3_3) {
			if ((devicewidth * BOB_LEFT_MARGIN) < (devicewidth * 1.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = true;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----hor 5
			if ((topmargin > (deviceheight * 2.465) && topmargin < (deviceheight * 2.495))
					&& (leftmargin > (devicewidth * 2.185) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_5_top + 2;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 2.095))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 2;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 2.185) && topmargin < (deviceheight * 2.215))
					&& (leftmargin > ((devicewidth * 1.99)) && leftmargin < ((devicewidth * 2.40)))) {
				BOB_T0P_MARGIN = hor_2_top + 2;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 2.265) && topmargin < (deviceheight * 2.295))
					&& (leftmargin > ((devicewidth * 2.315)) && leftmargin < ((devicewidth * 2.80)))) {
				BOB_T0P_MARGIN = hor_3_top + 2;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 2.365) && topmargin < (deviceheight * 2.395))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.75)))) {
				BOB_T0P_MARGIN = hor_4_top + 2;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 2.615) && topmargin < (deviceheight * 2.645))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.80)))) {
				BOB_T0P_MARGIN = hor_6_top + 2;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 2.715) && topmargin < (deviceheight * 2.745))
					&& (leftmargin > ((devicewidth * 1.99)) && leftmargin < ((devicewidth * 2.26)))) {
				BOB_T0P_MARGIN = hor_7_top + 2;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 2.865) && topmargin < (deviceheight * 2.895))
					&& (leftmargin > ((devicewidth * 2.215)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_8_top + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 3_3

		if (isValidMove)
			setMargins(BOB_IMAGE, BOB_LEFT_MARGIN -= 0.0057, BOB_T0P_MARGIN,
					-6, -6);
		else {
			isGAMEOVER = true;
			GAMEOVERDIALOG("GAME OVER");
		}
	}// end of move left

	public void MoveRight(int leftmargin, int topmargin) {

		if (isMaproad1_1) {
			if ((devicewidth * BOB_LEFT_MARGIN) > (devicewidth * 0.98)) {
				isMaproad1_1 = false;
				isMaproad1_2 = true;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----hor 5
			if ((topmargin > (deviceheight * 0.465) && topmargin < (deviceheight * 0.495))
					&& (leftmargin > (devicewidth * 0.06) && leftmargin < ((devicewidth * 1.20)))) {
				BOB_T0P_MARGIN = hor_5_top;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 0.065) && topmargin < (deviceheight * 0.095))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_1_top;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 0.185) && topmargin < (deviceheight * 0.215))
					&& (leftmargin > ((devicewidth * 0.165)) && leftmargin < ((devicewidth * 1.20)))) {
				BOB_T0P_MARGIN = hor_2_top;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 0.265) && topmargin < (deviceheight * 0.295))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.76)))) {
				BOB_T0P_MARGIN = hor_3_top;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 0.365) && topmargin < (deviceheight * 0.395))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_4_top;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 0.615) && topmargin < (deviceheight * 0.645))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.51)))) {
				BOB_T0P_MARGIN = hor_6_top;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 0.715) && topmargin < (deviceheight * 0.745))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 1.20)))) {
				BOB_T0P_MARGIN = hor_7_top;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 0.865) && topmargin < (deviceheight * 0.895))
					&& (leftmargin > ((devicewidth * 0.415)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_8_top;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 1_1
		else if (isMaproad2_1) {
			if ((devicewidth * BOB_LEFT_MARGIN) > (devicewidth * 0.93)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = true;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----hor 5
			if ((topmargin > (deviceheight * 1.465) && topmargin < (deviceheight * 1.495))
					&& (leftmargin > (devicewidth * 0.06) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_5_top + 1;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 1.095))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_1_top + 1;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 1.185) && topmargin < (deviceheight * 1.215))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.83)))) {
				BOB_T0P_MARGIN = hor_2_top + 1;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 1.265) && topmargin < (deviceheight * 1.295))
					&& (leftmargin > ((devicewidth * 0.215)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_3_top + 1;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 1.365) && topmargin < (deviceheight * 1.395))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.36)))) {
				BOB_T0P_MARGIN = hor_4_top + 1;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 1.615) && topmargin < (deviceheight * 1.645))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_6_top + 1;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 1.715) && topmargin < (deviceheight * 1.745))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_7_top + 1;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 1.865) && topmargin < (deviceheight * 1.895))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_8_top + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 2_1
		else if (isMaproad1_2) {

			if ((devicewidth * BOB_LEFT_MARGIN) > (devicewidth * 1.96)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = true;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----hor 5
			if ((topmargin > (deviceheight * 0.465) && topmargin < (deviceheight * 0.495))
					&& (leftmargin > (devicewidth * 0.95) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_5_top;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 0.065) && topmargin < (deviceheight * 0.095))
					&& (leftmargin > ((devicewidth * 1.06)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_1_top;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 0.185) && topmargin < (deviceheight * 0.215))
					&& (leftmargin > ((devicewidth * 0.96)) && leftmargin < ((devicewidth * 1.91)))) {
				BOB_T0P_MARGIN = hor_2_top;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 0.265) && topmargin < (deviceheight * 0.295))
					&& (leftmargin > ((devicewidth * 1.06)) && leftmargin < ((devicewidth * 1.35)))) {
				BOB_T0P_MARGIN = hor_3_top;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 0.365) && topmargin < (deviceheight * 0.395))
					&& (leftmargin > ((devicewidth * 1.06)) && leftmargin < ((devicewidth * 1.51)))) {
				BOB_T0P_MARGIN = hor_4_top;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 0.615) && topmargin < (deviceheight * 0.645))
					&& (leftmargin > ((devicewidth * 1.565)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_6_top;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 0.715) && topmargin < (deviceheight * 0.745))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_7_top;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 0.865) && topmargin < (deviceheight * 0.895))
					&& (leftmargin > ((devicewidth * 1.215)) && leftmargin < ((devicewidth * 1.75)))) {
				BOB_T0P_MARGIN = hor_8_top;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 1_2
		else if (isMaproad2_2) {
			if ((devicewidth * BOB_LEFT_MARGIN) > (devicewidth * 1.96)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = true;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----hor 5
			if ((topmargin > (deviceheight * 1.465) && topmargin < (deviceheight * 1.495))
					&& (leftmargin > (devicewidth * 1.065) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 1;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 1.095))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 1;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 1.185) && topmargin < (deviceheight * 1.215))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_2_top + 1;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 1.265) && topmargin < (deviceheight * 1.295))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.25)))) {
				BOB_T0P_MARGIN = hor_3_top + 1;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 1.365) && topmargin < (deviceheight * 1.395))
					&& (leftmargin > ((devicewidth * 1.465)) && leftmargin < ((devicewidth * 1.905)))) {
				BOB_T0P_MARGIN = hor_4_top + 1;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 1.615) && topmargin < (deviceheight * 1.645))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.40)))) {
				BOB_T0P_MARGIN = hor_6_top + 1;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 1.715) && topmargin < (deviceheight * 1.745))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_7_top + 1;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 1.865) && topmargin < (deviceheight * 1.895))
					&& (leftmargin > ((devicewidth * 1.215)) && leftmargin < ((devicewidth * 1.75)))) {
				BOB_T0P_MARGIN = hor_8_top + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 2_2
		else if (isMaproad1_3) {
			// -----hor 5
			if ((topmargin > (deviceheight * 0.465) && topmargin < (deviceheight * 0.495))
					&& (leftmargin > (devicewidth * 2.315) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_5_top;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 0.065) && topmargin < (deviceheight * 0.095))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.91)))) {
				BOB_T0P_MARGIN = hor_1_top;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 0.185) && topmargin < (deviceheight * 0.215))
					&& (leftmargin > ((devicewidth * 2.46)) && leftmargin < ((devicewidth * 2.91)))) {
				BOB_T0P_MARGIN = hor_2_top;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 0.265) && topmargin < (deviceheight * 0.295))
					&& (leftmargin > ((devicewidth * 2.315)) && leftmargin < ((devicewidth * 2.60)))) {
				BOB_T0P_MARGIN = hor_3_top;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 0.365) && topmargin < (deviceheight * 0.395))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.51)))) {
				BOB_T0P_MARGIN = hor_4_top;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 0.615) && topmargin < (deviceheight * 0.645))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.40)))) {
				BOB_T0P_MARGIN = hor_6_top;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 0.715) && topmargin < (deviceheight * 0.745))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_7_top;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 0.865) && topmargin < (deviceheight * 0.895))
					&& (leftmargin > ((devicewidth * 2.215)) && leftmargin < ((devicewidth * 2.75)))) {
				BOB_T0P_MARGIN = hor_8_top;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 1_3
		else if (isMaproad2_3) {
			// -----hor 5
			if ((topmargin > (deviceheight * 1.465) && topmargin < (deviceheight * 1.495))
					&& (leftmargin > (devicewidth * 2.185) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 1;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 1.095))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 1;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 1.185) && topmargin < (deviceheight * 1.215))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.40)))) {
				BOB_T0P_MARGIN = hor_2_top + 1;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 1.265) && topmargin < (deviceheight * 1.295))
					&& (leftmargin > ((devicewidth * 2.315)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_3_top + 1;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 1.365) && topmargin < (deviceheight * 1.395))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_4_top + 1;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 1.615) && topmargin < (deviceheight * 1.645))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_6_top + 1;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 1.715) && topmargin < (deviceheight * 1.745))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.25)))) {
				BOB_T0P_MARGIN = hor_7_top + 1;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 1.865) && topmargin < (deviceheight * 1.895))
					&& (leftmargin > ((devicewidth * 2.215)) && leftmargin < ((devicewidth * 2.75)))) {
				BOB_T0P_MARGIN = hor_8_top + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 2_3
		else if (isMaproad3_1) {
			if ((devicewidth * BOB_LEFT_MARGIN) > (devicewidth * 0.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = true;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----hor 5
			if ((topmargin > (deviceheight * 2.465) && topmargin < (deviceheight * 2.495))
					&& (leftmargin > (devicewidth * 0.06) && leftmargin < ((devicewidth * 0.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 2;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 2.095))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_1_top + 2;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 2.185) && topmargin < (deviceheight * 2.215))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.81)))) {
				BOB_T0P_MARGIN = hor_2_top + 2;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 2.265) && topmargin < (deviceheight * 2.295))
					&& (leftmargin > ((devicewidth * 0.215)) && leftmargin < ((devicewidth * 0.75)))) {
				BOB_T0P_MARGIN = hor_3_top + 2;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 2.365) && topmargin < (deviceheight * 2.395))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.35)))) {
				BOB_T0P_MARGIN = hor_4_top + 2;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 2.615) && topmargin < (deviceheight * 2.645))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.50)))) {
				BOB_T0P_MARGIN = hor_6_top + 2;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 2.715) && topmargin < (deviceheight * 2.745))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_7_top + 2;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 2.865) && topmargin < (deviceheight * 2.895))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_8_top + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 3_1
		else if (isMaproad3_2) {

			if ((devicewidth * BOB_LEFT_MARGIN) > (devicewidth * 1.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = true;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----hor 5
			if ((topmargin > (deviceheight * 2.465) && topmargin < (deviceheight * 2.495))
					&& (leftmargin > (devicewidth * 1.065) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 2;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 2.095))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 2;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 2.185) && topmargin < (deviceheight * 2.215))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.51)))) {
				BOB_T0P_MARGIN = hor_2_top + 2;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 2.265) && topmargin < (deviceheight * 2.295))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.35)))) {
				BOB_T0P_MARGIN = hor_3_top + 2;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 2.365) && topmargin < (deviceheight * 2.395))
					&& (leftmargin > ((devicewidth * 1.465)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_4_top + 2;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 2.615) && topmargin < (deviceheight * 2.645))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_6_top + 2;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 2.715) && topmargin < (deviceheight * 2.745))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.40)))) {
				BOB_T0P_MARGIN = hor_7_top + 2;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 2.865) && topmargin < (deviceheight * 2.895))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.51)))) {
				BOB_T0P_MARGIN = hor_8_top + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 3_2
		else if (isMaproad3_3) {
			// -----hor 5
			if ((topmargin > (deviceheight * 2.465) && topmargin < (deviceheight * 2.495))
					&& (leftmargin > (devicewidth * 2.185) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_5_top + 2;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 2.095))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 2;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 2.185) && topmargin < (deviceheight * 2.215))
					&& (leftmargin > ((devicewidth * 1.99)) && leftmargin < ((devicewidth * 2.40)))) {
				BOB_T0P_MARGIN = hor_2_top + 2;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 2.265) && topmargin < (deviceheight * 2.295))
					&& (leftmargin > ((devicewidth * 2.315)) && leftmargin < ((devicewidth * 2.80)))) {
				BOB_T0P_MARGIN = hor_3_top + 2;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 2.365) && topmargin < (deviceheight * 2.395))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.75)))) {
				BOB_T0P_MARGIN = hor_4_top + 2;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 2.615) && topmargin < (deviceheight * 2.645))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.80)))) {
				BOB_T0P_MARGIN = hor_6_top + 2;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 2.715) && topmargin < (deviceheight * 2.745))
					&& (leftmargin > ((devicewidth * 1.99)) && leftmargin < ((devicewidth * 2.26)))) {
				BOB_T0P_MARGIN = hor_7_top + 2;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 2.865) && topmargin < (deviceheight * 2.895))
					&& (leftmargin > ((devicewidth * 2.215)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_8_top + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 3_3
		if (isValidMove)
			setMargins(BOB_IMAGE, BOB_LEFT_MARGIN += 0.0057, BOB_T0P_MARGIN,
					-6, -6);
		else {
			isGAMEOVER = true;
			GAMEOVERDIALOG("GAME OVER");
		}
	}// end of move Right

	public void MoveUpAnimation() {
		try {
			// -----------------scrolling animation
			if ((BOB_T0P_MARGIN * deviceheight) > deviceheight * 0.65
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 0.654) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 0.25), 0).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > deviceheight * 0.90
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 0.904) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 0.50),
						(int) (deviceheight * 0.25)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > (deviceheight * 1.15)
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 1.154) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 0.75),
						(int) (deviceheight * 0.50)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > (deviceheight * 1.40)
					&& (BOB_T0P_MARGIN * deviceheight) < (deviceheight * 1.404)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY", (int) (deviceheight),
						(int) (deviceheight * 0.75)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > deviceheight * 1.65
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 1.654) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 1.25), deviceheight).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > deviceheight * 1.90
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 1.904) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 1.50),
						(int) (deviceheight * 1.25)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > (deviceheight * 2.15)
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 2.154) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 1.75),
						(int) (deviceheight * 1.50)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > (deviceheight * 2.40)
					&& (BOB_T0P_MARGIN * deviceheight) < (deviceheight * 2.404)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 2), (int) (deviceheight * 1.75))
						.setDuration(VER_SCROLLINGSPEED);
				objectAnimator.start();
			}
			// ---------
			else if ((BOB_T0P_MARGIN * deviceheight) > deviceheight * 2.65
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 2.654) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 2.25), deviceheight * 2)
						.setDuration(VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > deviceheight * 2.90
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 2.904) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 2.50),
						(int) (deviceheight * 2.25)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > (deviceheight * 3.15)
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 3.154) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 2.75),
						(int) (deviceheight * 2.50)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > (deviceheight * 3.40)
					&& (BOB_T0P_MARGIN * deviceheight) < (deviceheight * 3.404)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 3), (int) (deviceheight * 2.75))
						.setDuration(VER_SCROLLINGSPEED);
				objectAnimator.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}// end of move up Animation

	public void MoveDOWNAnimation() {
		try {
			// -----------------scrolling animation
			if ((BOB_T0P_MARGIN * deviceheight) > deviceheight * 0.65
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 0.66) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY", 0,
						(int) (deviceheight * 0.25)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > deviceheight * 0.90
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 0.91) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 0.25),
						(int) (deviceheight * 0.50)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > (deviceheight * 1.15)
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 1.16) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 0.50),
						(int) (deviceheight * 0.75)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > (deviceheight * 1.40)
					&& (BOB_T0P_MARGIN * deviceheight) < (deviceheight * 1.41)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 0.75), (int) (deviceheight))
						.setDuration(VER_SCROLLINGSPEED);
				objectAnimator.start();
			}

			else if ((BOB_T0P_MARGIN * deviceheight) > deviceheight * 1.65
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 1.66) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY", deviceheight,
						(int) (deviceheight * 1.25)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > deviceheight * 1.90
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 1.91) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 1.25),
						(int) (deviceheight * 1.50)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > (deviceheight * 2.15)
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 2.16) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 1.50),
						(int) (deviceheight * 1.75)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > (deviceheight * 2.40)
					&& (BOB_T0P_MARGIN * deviceheight) < (deviceheight * 2.41)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 1.75), (int) (deviceheight * 2))
						.setDuration(VER_SCROLLINGSPEED);
				objectAnimator.start();
			}
			// ---------
			else if ((BOB_T0P_MARGIN * deviceheight) > deviceheight * 2.65
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 2.66) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY", deviceheight * 2,
						(int) (deviceheight * 2.25)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > deviceheight * 2.90
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 2.91) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 2.25),
						(int) (deviceheight * 2.50)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > (deviceheight * 3.15)
					&& (BOB_T0P_MARGIN * deviceheight) < deviceheight * 3.16) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 2.50),
						(int) (deviceheight * 2.75)).setDuration(
						VER_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_T0P_MARGIN * deviceheight) > (deviceheight * 3.40)
					&& (BOB_T0P_MARGIN * deviceheight) < (deviceheight * 3.41)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						VERTICALSCROLLVIEW, "scrollY",
						(int) (deviceheight * 2.75), (int) (deviceheight * 3))
						.setDuration(VER_SCROLLINGSPEED);
				objectAnimator.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of move down Animation

	public void MoveLEFTAnimation() {
		try {

			// -----------------scrolling animation
			if ((BOB_LEFT_MARGIN * devicewidth) > devicewidth * 0.65
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 0.66) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 0.25), 0).setDuration(
						HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > devicewidth * 0.90
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 0.91) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 0.50), (int) (devicewidth * 0.25))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 1.15)
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 1.16) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 0.75), (int) (devicewidth * 0.50))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 1.40)
					&& (BOB_LEFT_MARGIN * devicewidth) < (devicewidth * 1.41)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX", (int) (devicewidth),
						(int) (devicewidth * 0.75)).setDuration(
						HOR_SCROLLINGSPEED);
				objectAnimator.start();
			}
			// -------------
			else if ((BOB_LEFT_MARGIN * devicewidth) > devicewidth * 1.65
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 1.66) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 1.25), (int) (devicewidth))
						.setDuration(700);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > devicewidth * 1.90
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 1.91) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 1.50), (int) (devicewidth * 1.25))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 2.15)
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 2.16) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 1.75), (int) (devicewidth * 1.50))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 2.40)
					&& (BOB_LEFT_MARGIN * devicewidth) < (devicewidth * 2.41)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 2), (int) (devicewidth * 1.75))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			}
			// -------------
			else if ((BOB_LEFT_MARGIN * devicewidth) > devicewidth * 2.65
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 2.66) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 2.25), (int) (devicewidth * 2))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > devicewidth * 2.90
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 2.91) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 2.50), (int) (devicewidth * 2.25))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 3.15)
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 3.16) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 2.75), (int) (devicewidth * 2.50))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 3.40)
					&& (BOB_LEFT_MARGIN * devicewidth) < (devicewidth * 3.41)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 3), (int) (devicewidth * 2.75))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 3.86)
					&& (BOB_LEFT_MARGIN * devicewidth) < (devicewidth * 3.87)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 3.50), (int) (devicewidth * 3))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of move LEFt Animation

	public void MoveRIGHTAnimation() {
		try {
			// -----------------scrolling animation
			if ((BOB_LEFT_MARGIN * devicewidth) > devicewidth * 0.60
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 0.61) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX", 0,
						(int) (devicewidth * 0.25)).setDuration(
						HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > devicewidth * 0.85
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 0.86) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 0.25), (int) (devicewidth * 0.50))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 1.15)
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 1.16) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 0.50), (int) (devicewidth * 0.75))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 1.40)
					&& (BOB_LEFT_MARGIN * devicewidth) < (devicewidth * 1.41)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 0.75), (int) (devicewidth))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			}
			// -------------
			else if ((BOB_LEFT_MARGIN * devicewidth) > devicewidth * 1.60
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 1.61) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX", (int) (devicewidth),
						(int) (devicewidth * 1.25)).setDuration(
						HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > devicewidth * 1.85
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 1.86) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 1.25), (int) (devicewidth * 1.50))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 2.15)
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 2.16) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 1.50), (int) (devicewidth * 1.75))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 2.40)
					&& (BOB_LEFT_MARGIN * devicewidth) < (devicewidth * 2.41)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 1.75), (int) (devicewidth * 2))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			}
			// -------------
			else if ((BOB_LEFT_MARGIN * devicewidth) > devicewidth * 2.60
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 2.61) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 2), (int) (devicewidth * 2.25))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > devicewidth * 2.85
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 2.86) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 2.25), (int) (devicewidth * 2.50))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 3.15)
					&& (BOB_LEFT_MARGIN * devicewidth) < devicewidth * 3.16) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 2.50), (int) (devicewidth * 2.75))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			} else if ((BOB_LEFT_MARGIN * devicewidth) > (devicewidth * 3.40)
					&& (BOB_LEFT_MARGIN * devicewidth) < (devicewidth * 3.41)) {

				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(
						MYHORIZONTALSCROLLVIEW, "scrollX",
						(int) (devicewidth * 2.75), (int) (devicewidth * 3))
						.setDuration(HOR_SCROLLINGSPEED);
				objectAnimator.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of move RIGHT Animation

	private Runnable GameoverThread = new Runnable() {

		public void run() {

			if (Overbobindex < GameoverList.size()) {
				try {

					setMargins(tempBOB_IMAGE,
							GameoverList.get(Overbobindex).SIMAN_LEFT_MARGIN,
							GameoverList.get(Overbobindex).SIMAN_T0P_MARGIN, 0,
							0);
					Overbobindex += 1;

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}// end of if

			if (Overbobindex > 30) {
				setMargins(tempSIMANS_IMAGE,
						GameoverList.get(Oversimanindex).SIMAN_LEFT_MARGIN,
						GameoverList.get(Oversimanindex).SIMAN_T0P_MARGIN, 0, 0);
				Oversimanindex += 1;

			}

			if (Overbobindex == GameoverList.size() - 5) {
				Overbobindex = 0;
				Oversimanindex = 0;

				setMargins(tempSIMANS_IMAGE,
						GameoverList.get(Oversimanindex).SIMAN_LEFT_MARGIN,
						GameoverList.get(Oversimanindex).SIMAN_T0P_MARGIN, 0, 0);
			}

			customHandler.postDelayed(this, 0);
		}

	}; // ---------Update scorere end

	public void MoveUP_Right_to_Left(int leftmargin, int topmargin) {

		if (isMaproad1_1) {
			// -----ver 4
			if ((topmargin > (deviceheight * 0.02) && topmargin < (deviceheight * 1.20))
					&& (leftmargin > (int) ((metrics.widthPixels * 0.465)) && leftmargin < (int) ((metrics.widthPixels * 0.535)))) {
				BOB_LEFT_MARGIN = ver_4_left;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.02)
					&& topmargin < (deviceheight * 0.76)
					&& (leftmargin > ((devicewidth * 0.065))) && leftmargin < (devicewidth * 0.135))) {
				BOB_LEFT_MARGIN = ver_1_left;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 0.61)
					&& topmargin < (deviceheight * 0.76)
					&& (leftmargin > (devicewidth * 0.215)) && leftmargin < (devicewidth * 0.285))) {
				BOB_LEFT_MARGIN = ver_2_left;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.51)
					&& (leftmargin > (devicewidth * 0.315)) && leftmargin < (devicewidth * 0.385))) {
				BOB_LEFT_MARGIN = ver_3_left;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.06)
					&& topmargin < (deviceheight * 0.91)
					&& (leftmargin > (devicewidth * 0.715)) && leftmargin < (devicewidth * 0.785))) {
				BOB_LEFT_MARGIN = ver_5_left;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.06)
					&& topmargin < (deviceheight * 1.20)
					&& (leftmargin > (devicewidth * 0.865)) && leftmargin < (devicewidth * 0.935))) {
				BOB_LEFT_MARGIN = ver_6_left;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is mapRoad 1_1
		else if (isMaproad2_1) {

			if ((deviceheight * BOB_T0P_MARGIN) < (deviceheight * 0.98)) {
				isMaproad1_1 = true;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 0.80) && topmargin < (deviceheight * 1.91))
					&& (leftmargin > (int) ((metrics.widthPixels * 0.465)) && leftmargin < (int) ((metrics.widthPixels * 0.535)))) {
				BOB_LEFT_MARGIN = ver_4_left;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 1.06)
					&& topmargin < (deviceheight * 2.20)
					&& (leftmargin > ((devicewidth * 0.065))) && leftmargin < (devicewidth * 0.135))) {
				BOB_LEFT_MARGIN = ver_1_left;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.61)
					&& topmargin < (deviceheight * 2.20)
					&& (leftmargin > (devicewidth * 0.215)) && leftmargin < (devicewidth * 0.285))) {
				BOB_LEFT_MARGIN = ver_2_left;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 1.06)
					&& topmargin < (deviceheight * 1.61)
					&& (leftmargin > (devicewidth * 0.315)) && leftmargin < (devicewidth * 0.385))) {
				BOB_LEFT_MARGIN = ver_3_left;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 1.06)
					&& topmargin < (deviceheight * 1.95)
					&& (leftmargin > (devicewidth * 0.715)) && leftmargin < (devicewidth * 0.785))) {
				BOB_LEFT_MARGIN = ver_5_left;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.80)
					&& topmargin < (deviceheight * 1.91)
					&& (leftmargin > (devicewidth * 0.865)) && leftmargin < (devicewidth * 0.935))) {
				BOB_LEFT_MARGIN = ver_6_left;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is mapRoad 2_1
		else if (isMaproad1_2) {
			// -----ver 4
			if ((topmargin > (deviceheight * 0.07) && topmargin < (deviceheight * 1.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 1.465)) && leftmargin < (int) ((metrics.widthPixels * 1.535)))) {
				BOB_LEFT_MARGIN = ver_4_left + 1;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.76)
					&& (leftmargin > ((devicewidth * 1.065))) && leftmargin < (devicewidth * 1.135))) {
				BOB_LEFT_MARGIN = ver_1_left + 1;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 0.715)
					&& topmargin < (deviceheight * 0.91)
					&& (leftmargin > (devicewidth * 1.215)) && leftmargin < (devicewidth * 1.285))) {
				BOB_LEFT_MARGIN = ver_2_left + 1;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.61)
					&& (leftmargin > (devicewidth * 1.315)) && leftmargin < (devicewidth * 1.385))) {
				BOB_LEFT_MARGIN = ver_3_left + 1;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 1.10)
					&& (leftmargin > (devicewidth * 1.715)) && leftmargin < (devicewidth * 1.785))) {
				BOB_LEFT_MARGIN = ver_5_left + 1;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.03)
					&& topmargin < (deviceheight * 0.75)
					&& (leftmargin > (devicewidth * 1.865)) && leftmargin < (devicewidth * 1.935))) {
				BOB_LEFT_MARGIN = ver_6_left + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 1_2

		else if (isMaproad2_2) {
			if ((deviceheight * BOB_T0P_MARGIN) < (deviceheight * 0.98)) {
				isMaproad1_1 = false;
				isMaproad1_2 = true;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 0.93) && topmargin < (deviceheight * 1.90))
					&& (leftmargin > (int) ((metrics.widthPixels * 1.465)) && leftmargin < (int) ((metrics.widthPixels * 1.535)))) {
				BOB_LEFT_MARGIN = ver_4_left + 1;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.76)
					&& (leftmargin > ((devicewidth * 1.065))) && leftmargin < (devicewidth * 1.135))) {
				BOB_LEFT_MARGIN = ver_1_left + 1;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.715)
					&& topmargin < (deviceheight * 1.91)
					&& (leftmargin > (devicewidth * 1.215)) && leftmargin < (devicewidth * 1.285))) {
				BOB_LEFT_MARGIN = ver_2_left + 1;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.61)
					&& (leftmargin > (devicewidth * 1.315)) && leftmargin < (devicewidth * 1.385))) {
				BOB_LEFT_MARGIN = ver_3_left + 1;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.93)
					&& topmargin < (deviceheight * 2.10)
					&& (leftmargin > (devicewidth * 1.715)) && leftmargin < (devicewidth * 1.785))) {
				BOB_LEFT_MARGIN = ver_5_left + 1;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.065)
					&& topmargin < (deviceheight * 2.10)
					&& (leftmargin > (devicewidth * 1.865)) && leftmargin < (devicewidth * 1.935))) {
				BOB_LEFT_MARGIN = ver_6_left + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 2_2

		else if (isMaproad1_3) {
			// -----ver 4
			if ((topmargin > (deviceheight * 0.07) && topmargin < (deviceheight * 0.90))
					&& (leftmargin > (int) ((metrics.widthPixels * 2.465)) && leftmargin < (int) ((metrics.widthPixels * 2.535)))) {
				BOB_LEFT_MARGIN = ver_4_left + 2;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 1.20)
					&& (leftmargin > ((devicewidth * 2.065))) && leftmargin < (devicewidth * 2.135))) {
				BOB_LEFT_MARGIN = ver_1_left + 2;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 0.715)
					&& topmargin < (deviceheight * 0.91)
					&& (leftmargin > (devicewidth * 2.215)) && leftmargin < (devicewidth * 2.285))) {
				BOB_LEFT_MARGIN = ver_2_left + 2;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.61)
					&& (leftmargin > (devicewidth * 2.315)) && leftmargin < (devicewidth * 2.385))) {
				BOB_LEFT_MARGIN = ver_3_left + 2;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.065)
					&& topmargin < (deviceheight * 1.10)
					&& (leftmargin > (devicewidth * 2.715)) && leftmargin < (devicewidth * 2.785))) {
				BOB_LEFT_MARGIN = ver_5_left + 2;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.065)
					&& topmargin < (deviceheight * 0.81)
					&& (leftmargin > (devicewidth * 2.865)) && leftmargin < (devicewidth * 2.935))) {
				BOB_LEFT_MARGIN = ver_6_left + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 1_3
		else if (isMaproad2_3) {

			if ((deviceheight * BOB_T0P_MARGIN) < (deviceheight * 0.98)
					&& (deviceheight * BOB_T0P_MARGIN) > (deviceheight * 0.94)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = true;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 2.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 2.465)) && leftmargin < (int) ((metrics.widthPixels * 2.535)))) {
				BOB_LEFT_MARGIN = ver_4_left + 2;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.93)
					&& topmargin < (deviceheight * 1.75)
					&& (leftmargin > ((devicewidth * 2.065))) && leftmargin < (devicewidth * 2.135))) {
				BOB_LEFT_MARGIN = ver_1_left + 2;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.715)
					&& topmargin < (deviceheight * 1.90)
					&& (leftmargin > (devicewidth * 2.215)) && leftmargin < (devicewidth * 2.285))) {
				BOB_LEFT_MARGIN = ver_2_left + 2;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.60)
					&& (leftmargin > (devicewidth * 2.315)) && leftmargin < (devicewidth * 2.385))) {
				BOB_LEFT_MARGIN = ver_3_left + 2;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.93)
					&& topmargin < (deviceheight * 1.90)
					&& (leftmargin > (devicewidth * 2.715)) && leftmargin < (devicewidth * 2.785))) {
				BOB_LEFT_MARGIN = ver_5_left + 2;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.065)
					&& topmargin < (deviceheight * 2.10)
					&& (leftmargin > (devicewidth * 2.865)) && leftmargin < (devicewidth * 2.935))) {
				BOB_LEFT_MARGIN = ver_6_left + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 2_3
		else if (isMaproad3_1) {

			if ((deviceheight * BOB_T0P_MARGIN) < (deviceheight * 2)
					&& (deviceheight * BOB_T0P_MARGIN) > (deviceheight * 1.94)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = true;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----ver 4
			if ((topmargin > (deviceheight * 2.01) && topmargin < (deviceheight * 3.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 0.465)) && leftmargin < (int) ((metrics.widthPixels * 0.535)))) {
				BOB_LEFT_MARGIN = ver_4_left;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.90)
					&& (leftmargin > ((devicewidth * 0.065))) && leftmargin < (devicewidth * 0.135))) {
				BOB_LEFT_MARGIN = ver_1_left;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.35)
					&& (leftmargin > (devicewidth * 0.215)) && leftmargin < (devicewidth * 0.285))) {
				BOB_LEFT_MARGIN = ver_2_left;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 2.265)
					&& topmargin < (deviceheight * 2.80)
					&& (leftmargin > (devicewidth * 0.315)) && leftmargin < (devicewidth * 0.385))) {
				BOB_LEFT_MARGIN = ver_3_left;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 0.715)) && leftmargin < (devicewidth * 0.785))) {
				BOB_LEFT_MARGIN = ver_5_left;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.90)
					&& (leftmargin > (devicewidth * 0.865)) && leftmargin < (devicewidth * 0.935))) {
				BOB_LEFT_MARGIN = ver_6_left;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is mapRoad 3_1
		else if (isMaproad3_2) {
			if ((deviceheight * BOB_T0P_MARGIN) < (deviceheight * 1.99)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = true;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 3.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 1.465)) && leftmargin < (int) ((metrics.widthPixels * 1.535)))) {
				BOB_LEFT_MARGIN = ver_4_left + 1;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.75)
					&& (leftmargin > ((devicewidth * 1.065))) && leftmargin < (devicewidth * 1.135))) {
				BOB_LEFT_MARGIN = ver_1_left + 1;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 2.715)
					&& topmargin < (deviceheight * 2.905)
					&& (leftmargin > (devicewidth * 1.215)) && leftmargin < (devicewidth * 1.285))) {
				BOB_LEFT_MARGIN = ver_2_left + 1;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.61)
					&& (leftmargin > (devicewidth * 1.315)) && leftmargin < (devicewidth * 1.385))) {
				BOB_LEFT_MARGIN = ver_3_left + 1;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.75)
					&& (leftmargin > (devicewidth * 1.715)) && leftmargin < (devicewidth * 1.785))) {
				BOB_LEFT_MARGIN = ver_5_left + 1;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 1.865)) && leftmargin < (devicewidth * 1.935))) {
				BOB_LEFT_MARGIN = ver_6_left + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 3_2
		else if (isMaproad3_3) {
			if ((deviceheight * BOB_T0P_MARGIN) < (deviceheight * 2)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = true;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----ver 4
			if ((topmargin > (deviceheight * 1.93) && topmargin < (deviceheight * 2.35))
					&& (leftmargin > (int) ((metrics.widthPixels * 2.465)) && leftmargin < (int) ((metrics.widthPixels * 2.535)))) {
				BOB_LEFT_MARGIN = ver_4_left + 2;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.85)
					&& (leftmargin > ((devicewidth * 2.065))) && leftmargin < (devicewidth * 2.135))) {
				BOB_LEFT_MARGIN = ver_1_left + 2;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 2.715)
					&& topmargin < (deviceheight * 2.90)
					&& (leftmargin > (devicewidth * 2.215)) && leftmargin < (devicewidth * 2.285))) {
				BOB_LEFT_MARGIN = ver_2_left + 2;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 2.185)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 2.315)) && leftmargin < (devicewidth * 2.385))) {
				BOB_LEFT_MARGIN = ver_3_left + 2;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 2.715)) && leftmargin < (devicewidth * 2.785))) {
				BOB_LEFT_MARGIN = ver_5_left + 2;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.50)
					&& (leftmargin > (devicewidth * 2.865)) && leftmargin < (devicewidth * 2.935))) {
				BOB_LEFT_MARGIN = ver_6_left + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 3_3

		if (isValidMove)
			setMargins(BOB_IMAGE, BOB_LEFT_MARGIN, BOB_T0P_MARGIN -= 0.0037,
					-6, -6);
		else {
			isGAMEOVER = true;
			GAMEOVERDIALOG("GAME OVER");
		}

	}// end of is moving up RIGHT TO LEFT

	public void MoveDownRight_to_Left(int leftmargin, int topmargin) {

		if (isMaproad1_1) {
			if ((deviceheight * BOB_T0P_MARGIN) > (deviceheight * 0.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = true;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 0.02) && topmargin < (deviceheight * 1.20))
					&& (leftmargin > (int) ((metrics.widthPixels * 0.465)) && leftmargin < (int) ((metrics.widthPixels * 0.535)))) {
				BOB_LEFT_MARGIN = ver_4_left;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.02)
					&& topmargin < (deviceheight * 0.76)
					&& (leftmargin > ((devicewidth * 0.065))) && leftmargin < (devicewidth * 0.135))) {
				BOB_LEFT_MARGIN = ver_1_left;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 0.61)
					&& topmargin < (deviceheight * 0.76)
					&& (leftmargin > (devicewidth * 0.215)) && leftmargin < (devicewidth * 0.245))) {
				BOB_LEFT_MARGIN = ver_2_left;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.51)
					&& (leftmargin > (devicewidth * 0.315)) && leftmargin < (devicewidth * 0.385))) {
				BOB_LEFT_MARGIN = ver_3_left;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.06)
					&& topmargin < (deviceheight * 0.91)
					&& (leftmargin > (devicewidth * 0.715)) && leftmargin < (devicewidth * 0.785))) {
				BOB_LEFT_MARGIN = ver_5_left;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.06)
					&& topmargin < (deviceheight * 1.20)
					&& (leftmargin > (devicewidth * 0.865)) && leftmargin < (devicewidth * 0.935))) {
				BOB_LEFT_MARGIN = ver_6_left;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 1_1
		else if (isMaproad2_1) {
			if ((deviceheight * BOB_T0P_MARGIN) > (deviceheight * 1.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = true;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 0.80) && topmargin < (deviceheight * 1.91))
					&& (leftmargin > (int) ((metrics.widthPixels * 0.465)) && leftmargin < (int) ((metrics.widthPixels * 0.535)))) {
				BOB_LEFT_MARGIN = ver_4_left;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 1.06)
					&& topmargin < (deviceheight * 2.20)
					&& (leftmargin > ((devicewidth * 0.065))) && leftmargin < (devicewidth * 0.135))) {
				BOB_LEFT_MARGIN = ver_1_left;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.61)
					&& topmargin < (deviceheight * 2.20)
					&& (leftmargin > (devicewidth * 0.215)) && leftmargin < (devicewidth * 0.285))) {
				BOB_LEFT_MARGIN = ver_2_left;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 1.06)
					&& topmargin < (deviceheight * 1.61)
					&& (leftmargin > (devicewidth * 0.315)) && leftmargin < (devicewidth * 0.385))) {
				BOB_LEFT_MARGIN = ver_3_left;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.95)
					&& (leftmargin > (devicewidth * 0.715)) && leftmargin < (devicewidth * 0.785))) {
				BOB_LEFT_MARGIN = ver_5_left;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.80)
					&& topmargin < (deviceheight * 1.91)
					&& (leftmargin > (devicewidth * 0.865)) && leftmargin < (devicewidth * 0.935))) {
				BOB_LEFT_MARGIN = ver_6_left;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is mapRoad 2_1
		else if (isMaproad1_2) {
			if ((deviceheight * BOB_T0P_MARGIN) > (deviceheight * 0.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = true;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 0.07) && topmargin < (deviceheight * 1.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 1.465)) && leftmargin < (int) ((metrics.widthPixels * 1.535)))) {
				BOB_LEFT_MARGIN = ver_4_left + 1;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.76)
					&& (leftmargin > ((devicewidth * 1.065))) && leftmargin < (devicewidth * 1.135))) {
				BOB_LEFT_MARGIN = ver_1_left + 1;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 0.715)
					&& topmargin < (deviceheight * 0.91)
					&& (leftmargin > (devicewidth * 1.215)) && leftmargin < (devicewidth * 1.285))) {
				BOB_LEFT_MARGIN = ver_2_left + 1;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.61)
					&& (leftmargin > (devicewidth * 1.315)) && leftmargin < (devicewidth * 1.385))) {
				BOB_LEFT_MARGIN = ver_3_left + 1;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 1.10)
					&& (leftmargin > (devicewidth * 1.715)) && leftmargin < (devicewidth * 1.785))) {
				BOB_LEFT_MARGIN = ver_5_left + 1;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.03)
					&& topmargin < (deviceheight * 0.75)
					&& (leftmargin > (devicewidth * 1.865)) && leftmargin < (devicewidth * 1.935))) {
				BOB_LEFT_MARGIN = ver_6_left + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 1_2

		else if (isMaproad2_2) {
			if ((deviceheight * BOB_T0P_MARGIN) > (deviceheight * 1.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = true;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----ver 4
			if ((topmargin > (deviceheight * 0.93) && topmargin < (deviceheight * 1.90))
					&& (leftmargin > (int) ((metrics.widthPixels * 1.465)) && leftmargin < (int) ((metrics.widthPixels * 1.535)))) {
				BOB_LEFT_MARGIN = ver_4_left + 1;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.76)
					&& (leftmargin > ((devicewidth * 1.065))) && leftmargin < (devicewidth * 1.135))) {
				BOB_LEFT_MARGIN = ver_1_left + 1;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.715)
					&& topmargin < (deviceheight * 1.91)
					&& (leftmargin > (devicewidth * 1.215)) && leftmargin < (devicewidth * 1.285))) {
				BOB_LEFT_MARGIN = ver_2_left + 1;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.61)
					&& (leftmargin > (devicewidth * 1.315)) && leftmargin < (devicewidth * 1.385))) {
				BOB_LEFT_MARGIN = ver_3_left + 1;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.93)
					&& topmargin < (deviceheight * 2.10)
					&& (leftmargin > (devicewidth * 1.715)) && leftmargin < (devicewidth * 1.785))) {
				BOB_LEFT_MARGIN = ver_5_left + 1;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.065)
					&& topmargin < (deviceheight * 2.10)
					&& (leftmargin > (devicewidth * 1.865)) && leftmargin < (devicewidth * 1.935))) {
				BOB_LEFT_MARGIN = ver_6_left + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 2_2
		else if (isMaproad1_3) {

			if ((deviceheight * BOB_T0P_MARGIN) > (deviceheight * 0.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = true;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----ver 4
			if ((topmargin > (deviceheight * 0.07) && topmargin < (deviceheight * 0.90))
					&& (leftmargin > (int) ((metrics.widthPixels * 2.465)) && leftmargin < (int) ((metrics.widthPixels * 2.535)))) {
				BOB_LEFT_MARGIN = ver_4_left + 2;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 1.20)
					&& (leftmargin > ((devicewidth * 2.065))) && leftmargin < (devicewidth * 2.135))) {
				BOB_LEFT_MARGIN = ver_1_left + 2;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 0.715)
					&& topmargin < (deviceheight * 0.91)
					&& (leftmargin > (devicewidth * 2.215)) && leftmargin < (devicewidth * 2.285))) {
				BOB_LEFT_MARGIN = ver_2_left + 2;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 0.07)
					&& topmargin < (deviceheight * 0.61)
					&& (leftmargin > (devicewidth * 2.315)) && leftmargin < (devicewidth * 2.385))) {
				BOB_LEFT_MARGIN = ver_3_left + 2;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.065)
					&& topmargin < (deviceheight * 1.10)
					&& (leftmargin > (devicewidth * 2.715)) && leftmargin < (devicewidth * 2.785))) {
				BOB_LEFT_MARGIN = ver_5_left + 2;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 0.065)
					&& topmargin < (deviceheight * 0.81)
					&& (leftmargin > (devicewidth * 2.865)) && leftmargin < (devicewidth * 2.935))) {
				BOB_LEFT_MARGIN = ver_6_left + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 1_3
		else if (isMaproad2_3) {
			if ((deviceheight * BOB_T0P_MARGIN) > (deviceheight * 1.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = true;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----ver 4
			if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 2.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 2.465)) && leftmargin < (int) ((metrics.widthPixels * 2.535)))) {
				BOB_LEFT_MARGIN = ver_4_left + 2;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 0.93)
					&& topmargin < (deviceheight * 1.75)
					&& (leftmargin > ((devicewidth * 2.065))) && leftmargin < (devicewidth * 2.135))) {
				BOB_LEFT_MARGIN = ver_1_left + 2;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.715)
					&& topmargin < (deviceheight * 1.90)
					&& (leftmargin > (devicewidth * 2.215)) && leftmargin < (devicewidth * 2.285))) {
				BOB_LEFT_MARGIN = ver_2_left + 2;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 1.07)
					&& topmargin < (deviceheight * 1.60)
					&& (leftmargin > (devicewidth * 2.315)) && leftmargin < (devicewidth * 2.385))) {
				BOB_LEFT_MARGIN = ver_3_left + 2;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 0.93)
					&& topmargin < (deviceheight * 1.90)
					&& (leftmargin > (devicewidth * 2.715)) && leftmargin < (devicewidth * 2.785))) {
				BOB_LEFT_MARGIN = ver_5_left + 2;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.065)
					&& topmargin < (deviceheight * 2.10)
					&& (leftmargin > (devicewidth * 2.865)) && leftmargin < (devicewidth * 2.935))) {
				BOB_LEFT_MARGIN = ver_6_left + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 2_3

		else if (isMaproad3_1) {

			// -----ver 4
			if ((topmargin > (deviceheight * 2.01) && topmargin < (deviceheight * 3.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 0.465)) && leftmargin < (int) ((metrics.widthPixels * 0.535)))) {
				BOB_LEFT_MARGIN = ver_4_left;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.90)
					&& (leftmargin > ((devicewidth * 0.065))) && leftmargin < (devicewidth * 0.135))) {
				BOB_LEFT_MARGIN = ver_1_left;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.35)
					&& (leftmargin > (devicewidth * 0.215)) && leftmargin < (devicewidth * 0.285))) {
				BOB_LEFT_MARGIN = ver_2_left;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 2.265)
					&& topmargin < (deviceheight * 2.80)
					&& (leftmargin > (devicewidth * 0.315)) && leftmargin < (devicewidth * 0.385))) {
				BOB_LEFT_MARGIN = ver_3_left;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 0.715)) && leftmargin < (devicewidth * 0.785))) {
				BOB_LEFT_MARGIN = ver_5_left;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.90)
					&& (leftmargin > (devicewidth * 0.865)) && leftmargin < (devicewidth * 0.935))) {
				BOB_LEFT_MARGIN = ver_6_left;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is mapRoad 3_1
		else if (isMaproad3_2) {

			// -----ver 4
			if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 3.10))
					&& (leftmargin > (int) ((metrics.widthPixels * 1.465)) && leftmargin < (int) ((metrics.widthPixels * 1.535)))) {
				BOB_LEFT_MARGIN = ver_4_left + 1;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.75)
					&& (leftmargin > ((devicewidth * 1.065))) && leftmargin < (devicewidth * 1.135))) {
				BOB_LEFT_MARGIN = ver_1_left + 1;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 2.715)
					&& topmargin < (deviceheight * 2.905)
					&& (leftmargin > (devicewidth * 1.215)) && leftmargin < (devicewidth * 1.285))) {
				BOB_LEFT_MARGIN = ver_2_left + 1;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.61)
					&& (leftmargin > (devicewidth * 1.315)) && leftmargin < (devicewidth * 1.385))) {
				BOB_LEFT_MARGIN = ver_3_left + 1;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.75)
					&& (leftmargin > (devicewidth * 1.715)) && leftmargin < (devicewidth * 1.785))) {
				BOB_LEFT_MARGIN = ver_5_left + 1;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 1.865)) && leftmargin < (devicewidth * 1.935))) {
				BOB_LEFT_MARGIN = ver_6_left + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 3_2
		else if (isMaproad3_3) {

			// -----ver 4
			if ((topmargin > (deviceheight * 1.93) && topmargin < (deviceheight * 2.35))
					&& (leftmargin > (int) ((metrics.widthPixels * 2.465)) && leftmargin < (int) ((metrics.widthPixels * 2.535)))) {
				BOB_LEFT_MARGIN = ver_4_left + 2;
				isValidMove = true;
			}
			// -----ver 1
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 2.85)
					&& (leftmargin > ((devicewidth * 2.065))) && leftmargin < (devicewidth * 2.135))) {
				BOB_LEFT_MARGIN = ver_1_left + 2;
				isValidMove = true;
			}
			// -----ver 2
			else if ((topmargin > (deviceheight * 2.715)
					&& topmargin < (deviceheight * 2.90)
					&& (leftmargin > (devicewidth * 2.215)) && leftmargin < (devicewidth * 2.285))) {
				BOB_LEFT_MARGIN = ver_2_left + 2;
				isValidMove = true;
			}
			// -----ver 3
			else if ((topmargin > (deviceheight * 2.185)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 2.315)) && leftmargin < (devicewidth * 2.385))) {
				BOB_LEFT_MARGIN = ver_3_left + 2;
				isValidMove = true;
			}
			// -----ver 5
			else if ((topmargin > (deviceheight * 2.065)
					&& topmargin < (deviceheight * 3.10)
					&& (leftmargin > (devicewidth * 2.715)) && leftmargin < (devicewidth * 2.785))) {
				BOB_LEFT_MARGIN = ver_5_left + 2;
				isValidMove = true;
			}
			// -----ver 6
			else if ((topmargin > (deviceheight * 1.93)
					&& topmargin < (deviceheight * 2.50)
					&& (leftmargin > (devicewidth * 2.865)) && leftmargin < (devicewidth * 2.935))) {
				BOB_LEFT_MARGIN = ver_6_left + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}
		}// end of is mapRoad 3_3

		if (isValidMove)
			setMargins(BOB_IMAGE, BOB_LEFT_MARGIN, BOB_T0P_MARGIN += 0.0037,
					-6, -6);
		else {
			isGAMEOVER = true;
			GAMEOVERDIALOG("GAME OVER");
		}
	}// end of move down RIGHT TO LEFT

	public void MoveRightDown_to_up(int leftmargin, int topmargin) {

		if (isMaproad1_1) {
			if ((devicewidth * BOB_LEFT_MARGIN) > (devicewidth * 0.98)) {
				isMaproad1_1 = false;
				isMaproad1_2 = true;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----hor 5
			if ((topmargin > (deviceheight * 0.465) && topmargin < (deviceheight * 0.535))
					&& (leftmargin > (devicewidth * 0.06) && leftmargin < ((devicewidth * 1.20)))) {
				BOB_T0P_MARGIN = hor_5_top;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 0.065) && topmargin < (deviceheight * 0.135))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_1_top;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 0.185) && topmargin < (deviceheight * 0.255))
					&& (leftmargin > ((devicewidth * 0.165)) && leftmargin < ((devicewidth * 1.20)))) {
				BOB_T0P_MARGIN = hor_2_top;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 0.265) && topmargin < (deviceheight * 0.335))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.76)))) {
				BOB_T0P_MARGIN = hor_3_top;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 0.365) && topmargin < (deviceheight * 0.435))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_4_top;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 0.615) && topmargin < (deviceheight * 0.685))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.51)))) {
				BOB_T0P_MARGIN = hor_6_top;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 0.715) && topmargin < (deviceheight * 0.785))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 1.20)))) {
				BOB_T0P_MARGIN = hor_7_top;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 0.865) && topmargin < (deviceheight * 0.935))
					&& (leftmargin > ((devicewidth * 0.415)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_8_top;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 1_1
		else if (isMaproad2_1) {
			if ((devicewidth * BOB_LEFT_MARGIN) > (devicewidth * 0.93)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = true;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----hor 5
			if ((topmargin > (deviceheight * 1.465) && topmargin < (deviceheight * 1.535))
					&& (leftmargin > (devicewidth * 0.06) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_5_top + 1;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 1.135))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_1_top + 1;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 1.185) && topmargin < (deviceheight * 1.255))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.83)))) {
				BOB_T0P_MARGIN = hor_2_top + 1;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 1.265) && topmargin < (deviceheight * 1.335))
					&& (leftmargin > ((devicewidth * 0.215)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_3_top + 1;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 1.365) && topmargin < (deviceheight * 1.435))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.36)))) {
				BOB_T0P_MARGIN = hor_4_top + 1;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 1.615) && topmargin < (deviceheight * 1.685))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_6_top + 1;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 1.715) && topmargin < (deviceheight * 1.785))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_7_top + 1;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 1.865) && topmargin < (deviceheight * 1.935))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_8_top + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 2_1
		else if (isMaproad1_2) {

			if ((devicewidth * BOB_LEFT_MARGIN) > (devicewidth * 1.96)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = true;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----hor 5
			if ((topmargin > (deviceheight * 0.465) && topmargin < (deviceheight * 0.535))
					&& (leftmargin > (devicewidth * 0.95) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_5_top;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 0.065) && topmargin < (deviceheight * 0.135))
					&& (leftmargin > ((devicewidth * 1.06)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_1_top;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 0.185) && topmargin < (deviceheight * 0.255))
					&& (leftmargin > ((devicewidth * 0.96)) && leftmargin < ((devicewidth * 1.91)))) {
				BOB_T0P_MARGIN = hor_2_top;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 0.265) && topmargin < (deviceheight * 0.335))
					&& (leftmargin > ((devicewidth * 1.06)) && leftmargin < ((devicewidth * 1.35)))) {
				BOB_T0P_MARGIN = hor_3_top;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 0.365) && topmargin < (deviceheight * 0.435))
					&& (leftmargin > ((devicewidth * 1.06)) && leftmargin < ((devicewidth * 1.51)))) {
				BOB_T0P_MARGIN = hor_4_top;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 0.615) && topmargin < (deviceheight * 0.685))
					&& (leftmargin > ((devicewidth * 1.565)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_6_top;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 0.715) && topmargin < (deviceheight * 0.785))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_7_top;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 0.865) && topmargin < (deviceheight * 0.935))
					&& (leftmargin > ((devicewidth * 1.215)) && leftmargin < ((devicewidth * 1.75)))) {
				BOB_T0P_MARGIN = hor_8_top;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 1_2
		else if (isMaproad2_2) {
			if ((devicewidth * BOB_LEFT_MARGIN) > (devicewidth * 1.96)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = true;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----hor 5
			if ((topmargin > (deviceheight * 1.465) && topmargin < (deviceheight * 1.535))
					&& (leftmargin > (devicewidth * 1.065) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 1;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 1.135))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 1;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 1.185) && topmargin < (deviceheight * 1.255))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_2_top + 1;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 1.265) && topmargin < (deviceheight * 1.335))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.25)))) {
				BOB_T0P_MARGIN = hor_3_top + 1;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 1.365) && topmargin < (deviceheight * 1.435))
					&& (leftmargin > ((devicewidth * 1.465)) && leftmargin < ((devicewidth * 1.905)))) {
				BOB_T0P_MARGIN = hor_4_top + 1;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 1.615) && topmargin < (deviceheight * 1.685))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.40)))) {
				BOB_T0P_MARGIN = hor_6_top + 1;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 1.715) && topmargin < (deviceheight * 1.785))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_7_top + 1;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 1.865) && topmargin < (deviceheight * 1.935))
					&& (leftmargin > ((devicewidth * 1.215)) && leftmargin < ((devicewidth * 1.75)))) {
				BOB_T0P_MARGIN = hor_8_top + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 2_2
		else if (isMaproad1_3) {
			// -----hor 5
			if ((topmargin > (deviceheight * 0.465) && topmargin < (deviceheight * 0.535))
					&& (leftmargin > (devicewidth * 2.315) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_5_top;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 0.065) && topmargin < (deviceheight * 0.135))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.91)))) {
				BOB_T0P_MARGIN = hor_1_top;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 0.185) && topmargin < (deviceheight * 0.255))
					&& (leftmargin > ((devicewidth * 2.46)) && leftmargin < ((devicewidth * 2.91)))) {
				BOB_T0P_MARGIN = hor_2_top;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 0.265) && topmargin < (deviceheight * 0.335))
					&& (leftmargin > ((devicewidth * 2.315)) && leftmargin < ((devicewidth * 2.60)))) {
				BOB_T0P_MARGIN = hor_3_top;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 0.365) && topmargin < (deviceheight * 0.435))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.51)))) {
				BOB_T0P_MARGIN = hor_4_top;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 0.615) && topmargin < (deviceheight * 0.685))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.40)))) {
				BOB_T0P_MARGIN = hor_6_top;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 0.715) && topmargin < (deviceheight * 0.785))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_7_top;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 0.865) && topmargin < (deviceheight * 0.935))
					&& (leftmargin > ((devicewidth * 2.215)) && leftmargin < ((devicewidth * 2.75)))) {
				BOB_T0P_MARGIN = hor_8_top;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 1_3
		else if (isMaproad2_3) {
			// -----hor 5
			if ((topmargin > (deviceheight * 1.465) && topmargin < (deviceheight * 1.535))
					&& (leftmargin > (devicewidth * 2.185) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 1;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 1.135))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 1;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 1.185) && topmargin < (deviceheight * 1.255))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.40)))) {
				BOB_T0P_MARGIN = hor_2_top + 1;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 1.265) && topmargin < (deviceheight * 1.335))
					&& (leftmargin > ((devicewidth * 2.315)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_3_top + 1;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 1.365) && topmargin < (deviceheight * 1.435))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_4_top + 1;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 1.615) && topmargin < (deviceheight * 1.685))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_6_top + 1;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 1.715) && topmargin < (deviceheight * 1.785))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.25)))) {
				BOB_T0P_MARGIN = hor_7_top + 1;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 1.865) && topmargin < (deviceheight * 1.935))
					&& (leftmargin > ((devicewidth * 2.215)) && leftmargin < ((devicewidth * 2.75)))) {
				BOB_T0P_MARGIN = hor_8_top + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 2_3
		else if (isMaproad3_1) {
			if ((devicewidth * BOB_LEFT_MARGIN) > (devicewidth * 0.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = true;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----hor 5
			if ((topmargin > (deviceheight * 2.465) && topmargin < (deviceheight * 2.535))
					&& (leftmargin > (devicewidth * 0.06) && leftmargin < ((devicewidth * 0.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 2;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 2.135))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_1_top + 2;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 2.185) && topmargin < (deviceheight * 2.255))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.81)))) {
				BOB_T0P_MARGIN = hor_2_top + 2;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 2.265) && topmargin < (deviceheight * 2.335))
					&& (leftmargin > ((devicewidth * 0.215)) && leftmargin < ((devicewidth * 0.75)))) {
				BOB_T0P_MARGIN = hor_3_top + 2;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 2.365) && topmargin < (deviceheight * 2.435))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.35)))) {
				BOB_T0P_MARGIN = hor_4_top + 2;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 2.615) && topmargin < (deviceheight * 2.685))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.50)))) {
				BOB_T0P_MARGIN = hor_6_top + 2;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 2.715) && topmargin < (deviceheight * 2.785))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_7_top + 2;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 2.865) && topmargin < (deviceheight * 2.935))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_8_top + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 3_1
		else if (isMaproad3_2) {

			if ((devicewidth * BOB_LEFT_MARGIN) > (devicewidth * 1.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = true;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----hor 5
			if ((topmargin > (deviceheight * 2.465) && topmargin < (deviceheight * 2.535))
					&& (leftmargin > (devicewidth * 1.065) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 2;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 2.135))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 2;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 2.185) && topmargin < (deviceheight * 2.255))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.51)))) {
				BOB_T0P_MARGIN = hor_2_top + 2;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 2.265) && topmargin < (deviceheight * 2.335))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.35)))) {
				BOB_T0P_MARGIN = hor_3_top + 2;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 2.365) && topmargin < (deviceheight * 2.435))
					&& (leftmargin > ((devicewidth * 1.465)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_4_top + 2;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 2.615) && topmargin < (deviceheight * 2.685))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_6_top + 2;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 2.715) && topmargin < (deviceheight * 2.785))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.40)))) {
				BOB_T0P_MARGIN = hor_7_top + 2;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 2.865) && topmargin < (deviceheight * 2.935))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.51)))) {
				BOB_T0P_MARGIN = hor_8_top + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 3_2
		else if (isMaproad3_3) {
			// -----hor 5
			if ((topmargin > (deviceheight * 2.465) && topmargin < (deviceheight * 2.535))
					&& (leftmargin > (devicewidth * 2.185) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_5_top + 2;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 2.135))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 2;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 2.185) && topmargin < (deviceheight * 2.255))
					&& (leftmargin > ((devicewidth * 1.99)) && leftmargin < ((devicewidth * 2.40)))) {
				BOB_T0P_MARGIN = hor_2_top + 2;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 2.265) && topmargin < (deviceheight * 2.335))
					&& (leftmargin > ((devicewidth * 2.315)) && leftmargin < ((devicewidth * 2.80)))) {
				BOB_T0P_MARGIN = hor_3_top + 2;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 2.365) && topmargin < (deviceheight * 2.435))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.75)))) {
				BOB_T0P_MARGIN = hor_4_top + 2;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 2.615) && topmargin < (deviceheight * 2.685))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.80)))) {
				BOB_T0P_MARGIN = hor_6_top + 2;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 2.715) && topmargin < (deviceheight * 2.785))
					&& (leftmargin > ((devicewidth * 1.99)) && leftmargin < ((devicewidth * 2.26)))) {
				BOB_T0P_MARGIN = hor_7_top + 2;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 2.865) && topmargin < (deviceheight * 2.935))
					&& (leftmargin > ((devicewidth * 2.215)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_8_top + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 3_3
		if (isValidMove)
			setMargins(BOB_IMAGE, BOB_LEFT_MARGIN += 0.0057, BOB_T0P_MARGIN,
					-6, -6);
		else {
			isGAMEOVER = true;
			GAMEOVERDIALOG("GAME OVER");
		}
	}// end of move Right Bottom to up

	public void MoveLeftDown_to_up(int leftmargin, int topmargin) {
		if (isMaproad1_1) {
			// -----hor 5
			if ((topmargin > (deviceheight * 0.465) && topmargin < (deviceheight * 0.535))
					&& (leftmargin > (devicewidth * 0.06) && leftmargin < ((devicewidth * 1.20)))) {
				BOB_T0P_MARGIN = hor_5_top;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 0.065) && topmargin < (deviceheight * 0.135))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_1_top;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 0.185) && topmargin < (deviceheight * 0.255))
					&& (leftmargin > ((devicewidth * 0.165)) && leftmargin < ((devicewidth * 1.20)))) {
				BOB_T0P_MARGIN = hor_2_top;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 0.265) && topmargin < (deviceheight * 0.335))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.76)))) {
				BOB_T0P_MARGIN = hor_3_top;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 0.365) && topmargin < (deviceheight * 0.435))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_4_top;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 0.615) && topmargin < (deviceheight * 0.685))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.51)))) {
				BOB_T0P_MARGIN = hor_6_top;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 0.715) && topmargin < (deviceheight * 0.785))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 1.20)))) {
				BOB_T0P_MARGIN = hor_7_top;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 0.865) && topmargin < (deviceheight * 0.935))
					&& (leftmargin > ((devicewidth * 0.415)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_8_top;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 1_1
		else if (isMaproad2_1) {
			// -----hor 5
			if ((topmargin > (deviceheight * 1.465) && topmargin < (deviceheight * 1.535))
					&& (leftmargin > (devicewidth * 0.06) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_5_top + 1;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 1.135))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_1_top + 1;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 1.185) && topmargin < (deviceheight * 1.255))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.83)))) {
				BOB_T0P_MARGIN = hor_2_top + 1;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 1.265) && topmargin < (deviceheight * 1.335))
					&& (leftmargin > ((devicewidth * 0.215)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_3_top + 1;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 1.365) && topmargin < (deviceheight * 1.435))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.36)))) {
				BOB_T0P_MARGIN = hor_4_top + 1;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 1.615) && topmargin < (deviceheight * 1.685))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_6_top + 1;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 1.715) && topmargin < (deviceheight * 1.785))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_7_top + 1;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 1.865) && topmargin < (deviceheight * 1.935))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_8_top + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 2_1
		else if (isMaproad1_2) {

			if ((devicewidth * BOB_LEFT_MARGIN) < (devicewidth)) {
				isMaproad1_1 = true;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----hor 5
			if ((topmargin > (deviceheight * 0.465) && topmargin < (deviceheight * 0.535))
					&& (leftmargin > (devicewidth * 0.96) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_5_top;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 0.065) && topmargin < (deviceheight * 0.135))
					&& (leftmargin > ((devicewidth * 1.06)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_1_top;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 0.185) && topmargin < (deviceheight * 0.255))
					&& (leftmargin > ((devicewidth * 0.96)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_2_top;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 0.265) && topmargin < (deviceheight * 0.335))
					&& (leftmargin > ((devicewidth * 1.06)) && leftmargin < ((devicewidth * 1.35)))) {
				BOB_T0P_MARGIN = hor_3_top;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 0.365) && topmargin < (deviceheight * 0.435))
					&& (leftmargin > ((devicewidth * 1.06)) && leftmargin < ((devicewidth * 1.51)))) {
				BOB_T0P_MARGIN = hor_4_top;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 0.615) && topmargin < (deviceheight * 0.685))
					&& (leftmargin > ((devicewidth * 1.565)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_6_top;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 0.715) && topmargin < (deviceheight * 0.785))
					&& (leftmargin > ((devicewidth * 0.96)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_7_top;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 0.865) && topmargin < (deviceheight * 0.935))
					&& (leftmargin > ((devicewidth * 1.215)) && leftmargin < ((devicewidth * 1.75)))) {
				BOB_T0P_MARGIN = hor_8_top;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 1_2
		else if (isMaproad2_2) {
			if ((devicewidth * BOB_LEFT_MARGIN) < (devicewidth)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = true;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----hor 5
			if ((topmargin > (deviceheight * 1.465) && topmargin < (deviceheight * 1.535))
					&& (leftmargin > (devicewidth * 1.065) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 1;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 1.135))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 1;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 1.185) && topmargin < (deviceheight * 1.255))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_2_top + 1;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 1.265) && topmargin < (deviceheight * 1.335))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.25)))) {
				BOB_T0P_MARGIN = hor_3_top + 1;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 1.365) && topmargin < (deviceheight * 1.435))
					&& (leftmargin > ((devicewidth * 1.465)) && leftmargin < ((devicewidth * 1.905)))) {
				BOB_T0P_MARGIN = hor_4_top + 1;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 1.615) && topmargin < (deviceheight * 1.685))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.40)))) {
				BOB_T0P_MARGIN = hor_6_top + 1;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 1.715) && topmargin < (deviceheight * 1.785))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_7_top + 1;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 1.865) && topmargin < (deviceheight * 1.935))
					&& (leftmargin > ((devicewidth * 1.215)) && leftmargin < ((devicewidth * 1.75)))) {
				BOB_T0P_MARGIN = hor_8_top + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 2_2

		else if (isMaproad1_3) {
			if ((devicewidth * BOB_LEFT_MARGIN) < (devicewidth * 2)) {
				isMaproad1_1 = false;
				isMaproad1_2 = true;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----hor 5
			if ((topmargin > (deviceheight * 0.465) && topmargin < (deviceheight * 0.535))
					&& (leftmargin > (devicewidth * 2.315) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_5_top;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 0.065) && topmargin < (deviceheight * 0.135))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.91)))) {
				BOB_T0P_MARGIN = hor_1_top;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 0.185) && topmargin < (deviceheight * 0.255))
					&& (leftmargin > ((devicewidth * 2.46)) && leftmargin < ((devicewidth * 2.91)))) {
				BOB_T0P_MARGIN = hor_2_top;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 0.265) && topmargin < (deviceheight * 0.335))
					&& (leftmargin > ((devicewidth * 2.315)) && leftmargin < ((devicewidth * 2.60)))) {
				BOB_T0P_MARGIN = hor_3_top;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 0.365) && topmargin < (deviceheight * 0.435))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.51)))) {
				BOB_T0P_MARGIN = hor_4_top;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 0.615) && topmargin < (deviceheight * 0.685))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.40)))) {
				BOB_T0P_MARGIN = hor_6_top;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 0.715) && topmargin < (deviceheight * 0.785))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_7_top;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 0.865) && topmargin < (deviceheight * 0.935))
					&& (leftmargin > ((devicewidth * 2.215)) && leftmargin < ((devicewidth * 2.75)))) {
				BOB_T0P_MARGIN = hor_8_top;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 1_3
		else if (isMaproad2_3) {

			if ((devicewidth * BOB_LEFT_MARGIN) < (devicewidth * 2)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = true;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}
			// -----hor 5
			if ((topmargin > (deviceheight * 1.465) && topmargin < (deviceheight * 1.535))
					&& (leftmargin > (devicewidth * 2.185) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 1;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 1.065) && topmargin < (deviceheight * 1.135))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 1;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 1.185) && topmargin < (deviceheight * 1.255))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.40)))) {
				BOB_T0P_MARGIN = hor_2_top + 1;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 1.265) && topmargin < (deviceheight * 1.335))
					&& (leftmargin > ((devicewidth * 2.315)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_3_top + 1;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 1.365) && topmargin < (deviceheight * 1.435))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_4_top + 1;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 1.615) && topmargin < (deviceheight * 1.685))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_6_top + 1;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 1.715) && topmargin < (deviceheight * 1.785))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.25)))) {
				BOB_T0P_MARGIN = hor_7_top + 1;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 1.865) && topmargin < (deviceheight * 1.935))
					&& (leftmargin > ((devicewidth * 2.215)) && leftmargin < ((devicewidth * 2.75)))) {
				BOB_T0P_MARGIN = hor_8_top + 1;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 2_3
		else if (isMaproad3_1) {
			// -----hor 5
			if ((topmargin > (deviceheight * 2.465) && topmargin < (deviceheight * 2.535))
					&& (leftmargin > (devicewidth * 0.06) && leftmargin < ((devicewidth * 0.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 2;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 2.135))
					&& (leftmargin > ((devicewidth * 0.06)) && leftmargin < ((devicewidth * 0.91)))) {
				BOB_T0P_MARGIN = hor_1_top + 2;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 2.185) && topmargin < (deviceheight * 2.255))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.81)))) {
				BOB_T0P_MARGIN = hor_2_top + 2;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 2.265) && topmargin < (deviceheight * 2.335))
					&& (leftmargin > ((devicewidth * 0.215)) && leftmargin < ((devicewidth * 0.75)))) {
				BOB_T0P_MARGIN = hor_3_top + 2;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 2.365) && topmargin < (deviceheight * 2.435))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.35)))) {
				BOB_T0P_MARGIN = hor_4_top + 2;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 2.615) && topmargin < (deviceheight * 2.685))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 0.50)))) {
				BOB_T0P_MARGIN = hor_6_top + 2;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 2.715) && topmargin < (deviceheight * 2.785))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_7_top + 2;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 2.865) && topmargin < (deviceheight * 2.935))
					&& (leftmargin > ((devicewidth * 0.065)) && leftmargin < ((devicewidth * 1.10)))) {
				BOB_T0P_MARGIN = hor_8_top + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 3_1
		else if (isMaproad3_2) {
			if ((devicewidth * BOB_LEFT_MARGIN) < (devicewidth)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = true;
				isMaproad3_2 = false;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----hor 5
			if ((topmargin > (deviceheight * 2.465) && topmargin < (deviceheight * 2.535))
					&& (leftmargin > (devicewidth * 1.065) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_5_top + 2;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 2.135))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 2;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 2.185) && topmargin < (deviceheight * 2.255))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.51)))) {
				BOB_T0P_MARGIN = hor_2_top + 2;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 2.265) && topmargin < (deviceheight * 2.335))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 1.35)))) {
				BOB_T0P_MARGIN = hor_3_top + 2;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 2.365) && topmargin < (deviceheight * 2.435))
					&& (leftmargin > ((devicewidth * 1.465)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_4_top + 2;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 2.615) && topmargin < (deviceheight * 2.685))
					&& (leftmargin > ((devicewidth * 1.065)) && leftmargin < ((devicewidth * 2.10)))) {
				BOB_T0P_MARGIN = hor_6_top + 2;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 2.715) && topmargin < (deviceheight * 2.785))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.40)))) {
				BOB_T0P_MARGIN = hor_7_top + 2;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 2.865) && topmargin < (deviceheight * 2.935))
					&& (leftmargin > ((devicewidth * 0.93)) && leftmargin < ((devicewidth * 1.51)))) {
				BOB_T0P_MARGIN = hor_8_top + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 3_2
		else if (isMaproad3_3) {
			if ((devicewidth * BOB_LEFT_MARGIN) < (devicewidth * 1.95)) {
				isMaproad1_1 = false;
				isMaproad1_2 = false;
				isMaproad1_3 = false;
				isMaproad1_4 = false;
				isMaproad2_1 = false;
				isMaproad2_2 = false;
				isMaproad2_3 = false;
				isMaproad2_4 = false;
				isMaproad3_1 = false;
				isMaproad3_2 = true;
				isMaproad3_3 = false;
				isMaproad3_4 = false;
				isMaproad4_1 = false;
				isMaproad4_2 = false;
				isMaproad4_3 = false;
				isMaproad4_4 = false;
			}

			// -----hor 5
			if ((topmargin > (deviceheight * 2.465) && topmargin < (deviceheight * 2.535))
					&& (leftmargin > (devicewidth * 2.185) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_5_top + 2;
				isValidMove = true;
			}
			// -----hor 1
			else if ((topmargin > (deviceheight * 2.065) && topmargin < (deviceheight * 2.135))
					&& (leftmargin > ((devicewidth * 2.065)) && leftmargin < ((devicewidth * 2.90)))) {
				BOB_T0P_MARGIN = hor_1_top + 2;
				isValidMove = true;
			}
			// -----hor 2
			else if ((topmargin > (deviceheight * 2.185) && topmargin < (deviceheight * 2.255))
					&& (leftmargin > ((devicewidth * 1.99)) && leftmargin < ((devicewidth * 2.40)))) {
				BOB_T0P_MARGIN = hor_2_top + 2;
				isValidMove = true;
			}
			// -----hor 3
			else if ((topmargin > (deviceheight * 2.265) && topmargin < (deviceheight * 2.335))
					&& (leftmargin > ((devicewidth * 2.315)) && leftmargin < ((devicewidth * 2.80)))) {
				BOB_T0P_MARGIN = hor_3_top + 2;
				isValidMove = true;
			}
			// -----hor 4
			else if ((topmargin > (deviceheight * 2.365) && topmargin < (deviceheight * 2.435))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.75)))) {
				BOB_T0P_MARGIN = hor_4_top + 2;
				isValidMove = true;
			}
			// -----hor 6
			else if ((topmargin > (deviceheight * 2.615) && topmargin < (deviceheight * 2.685))
					&& (leftmargin > ((devicewidth * 1.93)) && leftmargin < ((devicewidth * 2.80)))) {
				BOB_T0P_MARGIN = hor_6_top + 2;
				isValidMove = true;
			}
			// -----hor 7
			else if ((topmargin > (deviceheight * 2.715) && topmargin < (deviceheight * 2.785))
					&& (leftmargin > ((devicewidth * 1.99)) && leftmargin < ((devicewidth * 2.26)))) {
				BOB_T0P_MARGIN = hor_7_top + 2;
				isValidMove = true;
			}
			// -----hor 8
			else if ((topmargin > (deviceheight * 2.865) && topmargin < (deviceheight * 2.935))
					&& (leftmargin > ((devicewidth * 2.215)) && leftmargin < ((devicewidth * 3.10)))) {
				BOB_T0P_MARGIN = hor_8_top + 2;
				isValidMove = true;
			} else {
				isGAMEOVER = true;
				GAMEOVERDIALOG("GAME OVER");
			}

		}// end of is Map Road 3_3
		if (isValidMove)
			setMargins(BOB_IMAGE, BOB_LEFT_MARGIN -= 0.0057, BOB_T0P_MARGIN,
					-6, -6);
		else {
			isGAMEOVER = true;
			GAMEOVERDIALOG("GAME OVER");
		}
	}// end of move left Bottom to up

}// end of Activiyt
