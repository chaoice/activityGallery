package com.example.chaoice3240.firstactivity.customView;

import com.example.chaoice3240.firstactivity.injectSource.Module;
import com.example.chaoice3240.firstactivity.repository.user.UserRepository;

import dagger.Component;

/**
 * Created by Admin on 2018/3/18.
 */
@Component(modules = Module.class)
public interface CustomViewModelComponent {
    public void inject(CustomView view);
    public void inject(Product product);
    public void inject(UserRepository userRepository);
}
