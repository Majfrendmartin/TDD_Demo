package com.wildeastcoders.tdd_demo.usecase;

import com.wildeastcoders.tdd_demo.utils.RxJavaTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Majfrendmartin on 2017-10-14.
 */


@RunWith(RxJavaTestRunner.class)
public class ProduceTextUsecaseTest {

    private ProduceTextUsecase produceTextUsecase;

    @Before
    public void setUp() throws Exception {
        produceTextUsecase = new ProduceTextUsecaseImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void executeReturnsObservable() throws Exception {
        final Observable<String> observable = produceTextUsecase.execute();
        assertThat(observable).isNotNull();
        assertThat(observable).isInstanceOf(Observable.class);
    }

    @Test
    public void executeObservableReturnsString() throws Exception {
        final Observable<String> observable = produceTextUsecase.execute();
        final TestObserver<String> testObserver = observable.test();

        testObserver.assertNoErrors();
        testObserver.assertResult("123");
    }
}