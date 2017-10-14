package com.wildeastcoders.tdd_demo.usecase;

import io.reactivex.Observable;

/**
 * Created by Majfrendmartin on 2017-10-14.
 */

public class ProduceTextUsecaseImpl extends AbstractUsecase<String> implements ProduceTextUsecase {
    @Override
    protected Observable<String> produceObservable() {
        return Observable.just("123");
    }
}
