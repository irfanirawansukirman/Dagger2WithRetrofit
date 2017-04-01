package com.iriras.androiddagger2withretrofit;

import android.app.Application;

import com.iriras.androiddagger2withretrofit.dagger.component.DaggerNetComponent;
import com.iriras.androiddagger2withretrofit.dagger.component.NetComponent;
import com.iriras.androiddagger2withretrofit.dagger.module.AppModule;
import com.iriras.androiddagger2withretrofit.dagger.module.NetModule;
import com.iriras.androiddagger2withretrofit.util.Constant;

/**
 * Created by irfan on 02/04/17.
 */

public class MyApp extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * Component module configuration
         */
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(Constant.BASE_URL))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
