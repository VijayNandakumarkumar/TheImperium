package com.neurosky.algo_sdk_sample;

/**
 * Created by VijayKumar on 3/26/2018.
 */
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.*;
import java.lang.Object;

import static com.neurosky.algo_sdk_sample.Globals.view;

public class FloatingViewService extends Service {

    static WindowManager mWindowManager;
    static View mFloatingView;

    public FloatingViewService() {
    }
    static int gxval=480;
    static int gyval=960;
    static int myflag=0 ;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    static int a=5;
/*public static void bb(int blink){
    brainmoveatt(blink);
}*/
/*public static void clickbut()
{
    long downTime = SystemClock.uptimeMillis();
    long eventTime = SystemClock.uptimeMillis() + 100;
    int metaState = 0;
    MotionEvent motionEvent = MotionEvent.obtain(
            downTime,
            eventTime,
            MotionEvent.ACTION_UP,
            gxval,
            gyval,
            metaState
    );
    Toast.makeText(FloatingViewService.this,"clicking",Toast.LENGTH_LONG ).show();
    view.dispatchTouchEvent(motionEvent);
}*/
    public static void brainmoveblink(int blink) {
        // View add_phone = View.getLayoutInflater().inflate(R.layout.layout_floating_widget, null);


        if (blink > 80) {
            // clickbut();
            //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            Log.d("bank func", " ****************************** BLINK *************************************");
        }
        if ((blink > 70) && (myflag == 0)) {
            myflag = 1;
            Log.d("blnk func", "inside the blink funct" + myflag);
            return;
        } else if ((blink > 70) && (myflag == 1)) {
            myflag = 0;
            Log.d("blnk func", "inside the blink funct" + myflag);
            return;
        }
    }

    public static void brainmoveatt(int attention)
    {
        a=10;
        /*String si= "hi";

        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(brainmove(1),
                        getString(si),
                        Toast.LENGTH_SHORT).show();
            }
        });*/
        int myx=0;
        int myy=0;

        //Display disp = getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.TOP | Gravity.LEFT;        //Initially view will be added to top-left corner


        //up if att < 50
        if( (attention < 60)&&(myflag==0) )
        {
            gxval=gxval;
            gyval=gyval+20;
            params.x = gxval;
            params.y = gyval;
        }
        //down
        else if( (attention >=60 )&&(myflag==0) )
        {
            gxval=gxval;
            gyval=gyval-20;
            params.x = gxval;
            params.y = gyval;
        }
        //right
        if( (attention < 70)&&(myflag==1) )
        {
            gxval=gxval+20;
            gyval=gyval;
            params.x = gxval;
            params.y = gyval;
        }
        //left
        else if( (attention >=60 )&&(myflag==1) )
        {
            gxval=gxval-20;
            gyval=gyval;
            params.x = gxval;
            params.y = gyval;
        }



        //Update the layout with new X & Y coordinate
        mWindowManager.updateViewLayout(mFloatingView, params);

    }
    @Override
    public void onCreate() {
        super.onCreate();
        //Inflate the floating view layout we created
        mFloatingView = LayoutInflater.from(this).inflate(R.layout.layout_floating_widget, null);
        WindowManager wm=(WindowManager) getBaseContext().getSystemService(Context.WINDOW_SERVICE);
        Display display=wm.getDefaultDisplay();


        //Add the view to the window.
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        //Specify the view position
        params.gravity = Gravity.TOP | Gravity.LEFT;        //Initially view will be added to top-left corner
        params.x = 000;
        params.y = 100;

        //Add the view to the window
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(mFloatingView, params);

        //The root element of the collapsed view layout
        final View collapsedView = mFloatingView.findViewById(R.id.collapse_view);
        //The root element of the expanded view layout
        //final View expandedView = mFloatingView.findViewById(R.id.expanded_container);


        //Set the close button
        ImageView closeButtonCollapsed = (ImageView) mFloatingView.findViewById(R.id.close_btn);
        closeButtonCollapsed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //close the service and remove the from from the window
                stopSelf();
            }
        });

        //Set the view while floating view is expanded.
        //Set the play button.


        //vijay****************************************************88
        /*ImageView playButton = (ImageView) mFloatingView.findViewById(R.id.play_btn);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FloatingViewService.this, "Playing the song.", Toast.LENGTH_LONG).show();
            }
        });*/
//vijay*********************
        //Set the next button.
        /*ImageView nextButton = (ImageView) mFloatingView.findViewById(R.id.next_btn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FloatingViewService.this, "Playing next song.", Toast.LENGTH_LONG).show();
            }
        });*/
//vijay***************************************************
        //Set the pause button.
        /*ImageView prevButton = (ImageView) mFloatingView.findViewById(R.id.prev_btn);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FloatingViewService.this, "Playing previous song.", Toast.LENGTH_LONG).show();
            }
        });
*/
  //vijay****************************8

        //Set the close button
        /*ImageView closeButton = (ImageView) mFloatingView.findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                collapsedView.setVisibility(View.VISIBLE);
                expandedView.setVisibility(View.GONE);
            }
        });*/
//////vijay************88
        /*//Open the application on thi button click
        ImageView openButton = (ImageView) mFloatingView.findViewById(R.id.open_button);
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open the application  click.
                Intent intent = new Intent(FloatingViewService.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                //close the service and remove view from the view hierarchy
                stopSelf();
            }
        });*/

        //Drag and move floating view using user's touch action.
        mFloatingView.findViewById(R.id.hello).setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;



            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        //remember the initial position.
                        initialX = params.x;
                        initialY = params.y;

                        //get the touch location
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        int Xdiff = (int) (event.getRawX() - initialTouchX);
                        int Ydiff = (int) (event.getRawY() - initialTouchY);

                        //The check for Xdiff <10 && YDiff< 10 because sometime elements moves a little while clicking.
                        //So that is click event.
                        if (Xdiff < 10 && Ydiff < 10) {
                            if (isViewCollapsed()) {
                                //When user clicks on the image view of the collapsed layout,
                                //visibility of the collapsed layout will be changed to "View.GONE"
                                //and expanded view will become visible.
                                collapsedView.setVisibility(View.GONE);
//                                expandedView.setVisibility(View.VISIBLE);
                            }
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        //Calculate the X and Y coordinates of the view.
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);

                        //Update the layout with new X & Y coordinate
                        mWindowManager.updateViewLayout(mFloatingView, params);

                        return true;
                }
                return false;
            }
        });
    }

    /**
     * Detect if the floating view is collapsed or expanded.
     *
     * @return true if the floating view is collapsed.
     */
    private boolean isViewCollapsed() {
        return mFloatingView == null || mFloatingView.findViewById(R.id.collapse_view).getVisibility() == View.VISIBLE;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFloatingView != null) mWindowManager.removeView(mFloatingView);
    }
}
