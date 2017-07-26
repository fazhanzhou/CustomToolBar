package zhoufazhan.com.customtoolbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhoufazhan on 2017/7/25.
 */

public class CustomTextView  extends android.support.v7.widget.AppCompatTextView  {
    public DrawableLeftListener mDrawableLeftListener;
    public DrawableRightListener mDrawableRightListener;

    public void setmDrawableLeftListener(DrawableLeftListener mDrawableLeftListener) {
        this.mDrawableLeftListener = mDrawableLeftListener;
    }

    public void setmDrawableRightListener(DrawableRightListener mDrawableRightListener) {
        this.mDrawableRightListener = mDrawableRightListener;
    }

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        Log.i("zhou", action + "");

        switch (action) {
            case MotionEvent.ACTION_UP:
                if (mDrawableLeftListener != null) {
                    //左边图片
                    Drawable drawable = getCompoundDrawables()[0];
                    //判断点击区域,手指点击的X坐标与CustomTextView靠左边界的距离+drawable的宽度比较
                    float rawX = event.getRawX();
                    Log.i("zhou", "getRight()="+getRight() );
                    Log.i("zhou", "getLeft()="+getLeft() );
                    if (getRight() >= rawX && rawX >= getLeft()) {
                        mDrawableLeftListener.onDrawableLeftClick(this);
                        return true;
                    }
                }
                if (mDrawableRightListener != null) {
                    //右边图片
                    Drawable drawable = getCompoundDrawables()[2];
                    //判断点击区域,手指点击的X坐标与CustomTextView靠右边界的距离 - drawable的宽度比较
                    float rawX = event.getRawX();

                    if (getRight() >= rawX && rawX >= getLeft()) {
                        mDrawableRightListener.onDrawableRightClick(this);
                        return true;
                    }
                }

                break;

        }
        return super.onTouchEvent(event);
    }

    interface DrawableLeftListener {
        void onDrawableLeftClick(View view);
    }

    interface DrawableRightListener {
        void onDrawableRightClick(View view);
    }
}
