package com.iriras.androiddagger2withretrofit.dagger.component;

import com.iriras.androiddagger2withretrofit.MainActivity;
import com.iriras.androiddagger2withretrofit.dagger.module.AppModule;
import com.iriras.androiddagger2withretrofit.dagger.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by irfan on 02/04/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity mMainActivity);
}
