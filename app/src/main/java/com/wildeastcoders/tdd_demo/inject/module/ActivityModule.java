package com.wildeastcoders.tdd_demo.inject.module;

import com.wildeastcoders.tdd_demo.inject.scope.PerActivity;
import com.wildeastcoders.tdd_demo.presenter.MainActivityPresenter;
import com.wildeastcoders.tdd_demo.presenter.MainActivityPresenterImpl;
import com.wildeastcoders.tdd_demo.usecase.ProduceTextUsecase;
import com.wildeastcoders.tdd_demo.usecase.ProduceTextUsecaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Majfrendmartin on 2017-10-10.
 */

@Module
public class ActivityModule {

    @PerActivity
    @Provides
    public MainActivityPresenter provideMainActivityPresenter(ProduceTextUsecase produceTextUsecase) {
        return new MainActivityPresenterImpl(produceTextUsecase);
    }

    @PerActivity
    @Provides
    public ProduceTextUsecase provideProduceTextUsecase() {
        return new ProduceTextUsecaseImpl();
    }
}
