package com.example.chaoice3240.firstactivity.customView;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import android.widget.Toast;

import com.example.chaoice3240.firstactivity.R;
import com.example.chaoice3240.firstactivity.database.user.UserEntity;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Admin on 2018/3/8.
 */

public class CustomView extends View {
    private static final String TAG = "CustomView";
    private boolean mShowText;
    private int mTextPos;
    private String mName;
    private Paint mPaint;
    private Paint mShadowPaint;
    private GestureDetector mDetector;
    private Scroller mScroller;
    private ValueAnimator mScrollAnimator;
    private String viewText="";
    private float m_lastx;
    private float m_lasty;
    @Inject
    Product injectProduct;


    public CustomView(Context context,AttributeSet attrs) {
        super(context,attrs);
        TypedArray array= context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView,0,0);
        mShowText= array.getBoolean(R.styleable.CustomView_showText,false);
        mTextPos=array.getInteger(R.styleable.CustomView_labelPosition,0);
        mName=array.getString(R.styleable.CustomView_Name);
        init();
    }

    public boolean ismShowText() {
        return mShowText;
    }
    @Override
    public boolean onTouchEvent(MotionEvent envent)
    {
        Log.d(TAG, "onTouchEvent: ");
        float x=envent.getRawX();
        float y=envent.getRawY();
        switch (envent.getAction())
        {
            case MotionEvent.ACTION_MOVE:
            {
                float deltax=x-m_lastx;
                float deltay=y-m_lasty;
                ObjectAnimator.ofFloat(this,"translationX",getTranslationX()+deltax,getTranslationX()+deltax).setDuration(10).start();
                ObjectAnimator.ofFloat(this,"translationY",deltay+getTranslationY(),deltay+getTranslationY()).setDuration(10).start();

            }
        }
        m_lastx=x;
        m_lasty=y;
        return mDetector.onTouchEvent(envent);

    }

    public void setmShowText(boolean mShowText) {
        this.mShowText = mShowText;
        invalidate();
        requestLayout();
    }

    public int getmTextPos() {
        return mTextPos;
    }


    public void setmTextPos(int mTextPos) {
        this.mTextPos = mTextPos;
        invalidate();
        requestLayout();
    }

    class CusGesListener extends GestureDetector.SimpleOnGestureListener
    {
        public boolean onDown(MotionEvent e)
        {
            Log.d(TAG, "onDown: ");
            return true;
        }
        public boolean onDoubleTap(MotionEvent e) {
            Log.d(TAG, "onDoubleTap: ");
            return true;
        }
        public boolean onContextClick(MotionEvent e) {
            Log.d(TAG, "onContextClick: ");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d(TAG, "onScroll: "+distanceX+"y:"+distanceY);
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
    }
    private void init()
    {
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(0xff101010);
        mPaint.setTextSize(20);
        mPaint.setStyle(Paint.Style.STROKE);

        mShadowPaint = new Paint(0);
        mShadowPaint.setColor(0xff101010);
        mShadowPaint.setMaskFilter(new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL));

        mDetector = new GestureDetector(CustomView.this.getContext(), new CusGesListener());
        mScroller = new Scroller(getContext(), null, true);
        mScrollAnimator = ValueAnimator.ofFloat(0,1);
        mScrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!mScroller.isFinished()) {
                    mScroller.computeScrollOffset();

                } else {
                    mScrollAnimator.cancel();

                }
            }
        });
        setBackgroundResource(R.drawable.my_rect);
        setElevation(100);
//        DaggerCustomViewComponent.create().inject(this);
//        Log.d(TAG, "init: "+injectProduct.getGetU());
        DaggerCustomViewModelComponent.create().inject(this);
        DaggerCustomViewModelComponent.create().inject(injectProduct);
        Log.d(TAG, "init: "+injectProduct.getGetU());
        injectProduct.insertUser().observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onNext(Boolean aBoolean) {
                Toast.makeText(getContext(),"result="+aBoolean,Toast.LENGTH_SHORT);
            }
        });
        injectProduct.getUser("zhang")
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<UserEntity>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onNext(UserEntity userEntity) {
                Log.d(TAG, "onNext: "+userEntity.firstName+userEntity.lastName);
            }
        });
        injectProduct.getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserEntity>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        Log.d(TAG, "onNext: ");
                    }
                });
//        injectProduct.getuserinfos();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        viewText=viewText+(char)keyCode;
        Log.d(TAG, "onKeyDown: "+(char)keyCode);
        postInvalidate();
        return true;
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        RectF rectF=new RectF(10,0,450,80);
        canvas.drawRect(rectF,mPaint);
        canvas.drawText(mName,40,40,mPaint);
        canvas.drawLine(80, 60, 400, 60, mPaint);
        canvas.drawText(viewText,100,40,mPaint);

    }

}
