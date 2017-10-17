package com.le.slideanddraglistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by damai on 17/10/16.
 */

public class SlideAndDragListView extends LinearLayout {

    private View mContentView;
    private View mDeleteView;
    private View mOnTopView;

    private float mX;
    private float mLeftX;
    private float mMaxWidth;

    public SlideAndDragListView(Context context) {
        super(context);
        init(context);
    }

    public SlideAndDragListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SlideAndDragListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mLeftX = getLeft();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("testX", "this is item touch event" + event.getAction());
        mMaxWidth = getChildAt(1).getWidth() + getChildAt(2).getWidth();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                mX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                float dis = event.getX() - mX;
                if (dis < 0) {
                    Log.i("testX", "this is slided to left" + getChildAt(1).getWidth()/2);
                    Log.i("testX", "this is slided to max" + mMaxWidth);
                    if (Math.abs(getLeft()) < mMaxWidth){
                        layout((int) (getLeft() + dis), getTop(), getRight(), getBottom());
                    }
                }

                Log.i("testX", "dis " + dis + " mLeftX: " + mLeftX);
                if (dis > 0 ) {
                    Log.i("testX", "this is slided to right");
                    if (getLeft() < 0){
                        layout((int) (getLeft() + dis), getTop(), getRight(), getBottom());
                    }
                }
                break;
            case MotionEvent.ACTION_UP:

                break;

        }

        return super.onTouchEvent(event);
    }
}
