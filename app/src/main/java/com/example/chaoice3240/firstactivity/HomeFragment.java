package com.example.chaoice3240.firstactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by Admin on 2018/3/12.
 */

public class HomeFragment extends Fragment {
    private View view;
    private WebView webView;
    private String url;
    private static final String URL_KEY="url";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.home_fragment_layout,container,false);
        webView=(WebView) view.findViewById(R.id.web_content);
        webView.loadUrl(getArguments().getString(URL_KEY));
        return view;
    }
     public static HomeFragment newInstance(String url) {
        Bundle args = new Bundle();
         args.putString(URL_KEY,url);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
