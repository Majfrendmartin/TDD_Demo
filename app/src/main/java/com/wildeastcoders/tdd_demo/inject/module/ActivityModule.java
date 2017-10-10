package com.wildeastcoders.tdd_demo.inject.module;

import com.wildeastcoders.tdd_demo.inject.scope.PerActivity;
import com.wildeastcoders.tdd_demo.presenter.MainActivityPresenter;
import com.wildeastcoders.tdd_demo.presenter.MainActivityPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Majfrendmartin on 2017-10-10.
 */

@Module
public class ActivityModule {

    @PerActivity
    @Provides
    public MainActivityPresenter provideMainActivityPresenter() {
        return new MainActivityPresenterImpl();
    }
}
