package com.oakraw.bluetoothrssi.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by Rawipol on 4/30/15 AD.
 */
public class GestureLayout extends FrameLayout {
    public GestureLayout(Context context) {
        super(context);
        init(context);
    }

    public GestureLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GestureLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public GestureLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    GestureDetector gestureDetector;

    public void init(Context context) {
        // creating new gesture detector
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    // skipping measure calculation and drawing

    // delegate the event to the gesture detector
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return gestureDetector.onTouchEvent(e);
    }


    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        // event when double tap occurs
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            onDoubleClickListener.onDoubleClick(2);

            return true;
        }


        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            onDoubleClickListener.onDoubleClick(1);
            return super.onSingleTapConfirmed(e);
        }
    }

    public interface OnDoubleClickListener{
        void onDoubleClick(int type);
    }

    protected OnDoubleClickListener onDoubleClickListener;

    public void setOnDoubleClickListener(OnDoubleClickListener onDoubleClickListener) {
        this.onDoubleClickListener = onDoubleClickListener;
    }
}
