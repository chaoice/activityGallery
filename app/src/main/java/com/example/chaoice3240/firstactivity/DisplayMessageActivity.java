package com.example.chaoice3240.firstactivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chaoice3240.firstactivity.adapter.MyAdapter;

public class DisplayMessageActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private CustomView mCustomView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar=(Toolbar) findViewById(R.id.messagetoolbar);
        setSupportActionBar(toolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        String nameStr=intent.getStringExtra(FirstActivity.EXTRA_NAME);
        String[] datas=new String[]{"jkfjf","fff","ffff"};

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recyclelistview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter=new MyAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);
        mCustomView =(CustomView) findViewById(R.id.custom_view);
    }

    public void onshowclick(View view) {

        //mCustomView.scrollTo(-25,-25);
        //ObjectAnimator.ofFloat(mCustomView,"translationX",10,100).setDuration(100).start();
        LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams)mCustomView.getLayoutParams();
        layoutParams.setMargins(100,0,0,0);
        mCustomView.requestLayout();
// get the center for the clipping circle
        int cx = (mCustomView.getLeft() + mCustomView.getRight()) / 2;
        int cy = (mCustomView.getTop() + mCustomView.getBottom()) / 2;

// get the final radius for the clipping circle
        int finalRadius = Math.max(mCustomView.getWidth(), mCustomView.getHeight());

// create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(mCustomView, cx, cy, 0, finalRadius);

// make the view visible and start the animation
        mCustomView.setVisibility(View.VISIBLE);
        //anim.start();

    }
    public void ondisclick(View view) {
        final View myView = findViewById(R.id.custom_view);
        //ObjectAnimator.ofFloat(mCustomView,"translationX",100,10).setDuration(100).start();
        LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams)mCustomView.getLayoutParams();
        layoutParams.setMargins(10,0,0,0);
        mCustomView.requestLayout();
// get the center for the clipping circle
        int cx = (myView.getLeft() + myView.getRight()) / 2;
        int cy = (myView.getTop() + myView.getBottom()) / 2;

// get the initial radius for the clipping circle
        int initialRadius = myView.getWidth();

// create the animation (the final radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);

// make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //myView.setVisibility(View.INVISIBLE);
            }
        });

// start the animation
        //anim.start();
    }



}
