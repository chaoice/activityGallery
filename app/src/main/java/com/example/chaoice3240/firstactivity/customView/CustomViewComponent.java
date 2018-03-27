package com.example.chaoice3240.firstactivity.customView;

import dagger.Component;

/**
 * Created by Admin on 2018/3/18.
 */
//@Component
interface  CustomViewComponent {
    public void inject(CustomView view);
    public void inject(Product product);
}
