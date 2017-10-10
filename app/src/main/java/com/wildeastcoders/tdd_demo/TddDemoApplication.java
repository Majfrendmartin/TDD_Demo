package com.wildeastcoders.tdd_demo;

import android.app.Application;

import com.wildeastcoders.tdd_demo.inject.component.ApplicationComponent;
import com.wildeastcoders.tdd_demo.inject.component.DaggerApplicationComponent;
import com.wildeastcoders.tdd_demo.inject.module.ApplicationModule;

/**
 * Created by Majfrendmartin on 2017-10-10.
 */

public class TddDemoApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupInjector();
    }

    private void setupInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
