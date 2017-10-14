package com.wildeastcoders.tdd_demo.usecase;

import android.support.annotation.NonNull;

import io.reactivex.Observable;

/**
 * Created by Majfrendmartin on 2017-10-14.
 */

public interface Usecase<T> {
    @NonNull
    Observable<T> execute();
}
