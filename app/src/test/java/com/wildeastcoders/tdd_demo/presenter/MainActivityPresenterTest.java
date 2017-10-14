package com.wildeastcoders.tdd_demo.presenter;

import com.wildeastcoders.tdd_demo.usecase.ProduceTextUsecase;
import com.wildeastcoders.tdd_demo.utils.RxJavaTestRunner;
import com.wildeastcoders.tdd_demo.view.MainActivityView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Majfrendmartin on 2017-10-10.
 */

@RunWith(RxJavaTestRunner.class)
public class MainActivityPresenterTest {

    public static final String TEST_TEXT = "123";
    @Mock
    MainActivityView view;

    @Mock
    ProduceTextUsecase produceTextUsecase;

    private MainActivityPresenterImpl presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new MainActivityPresenterImpl(produceTextUsecase);
        when(produceTextUsecase.execute()).thenReturn(Observable.just(TEST_TEXT));
    }

    @Test
    public void bindViewPopulatesField() throws Exception {
        presenter.bindView(view);
        assertThat(presenter.view).isEqualTo(view);
    }

    @Test
    public void onButtonClickedTriggersViewUpdateTextViewBound() throws Exception {
        presenter.view = view;
        presenter.onButtonClicked();
        verify(produceTextUsecase).execute();
        verify(view).updateText(eq(TEST_TEXT));
    }

    @Test
    public void onButtonClickedTriggersViewUpdateTextViewNotBound() throws Exception {
        presenter.onButtonClicked();
        verify(view, never()).updateText(anyString());
    }

    @Test
    public void isViewBoundReturnsTrueWhenViewBound() throws Exception {
        presenter.view = view;
        assertThat(presenter.isViewBound()).isTrue();
    }

    @Test
    public void isViewBoundReturnsFalseWhenViewBound() throws Exception {
        assertThat(presenter.isViewBound()).isFalse();
    }
}