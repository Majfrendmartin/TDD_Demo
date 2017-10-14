package com.wildeastcoders.tdd_demo.usecase;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Majfrendmartin on 2017-10-14.
 */

abstract class AbstractUsecase<T> implements Usecase<T> {
    @NonNull
    @Override
    public final Observable<T> execute() {
        return produceObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    protected abstract Observable<T> produceObservable();
}
