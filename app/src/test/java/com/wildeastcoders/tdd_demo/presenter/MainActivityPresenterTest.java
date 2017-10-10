package com.wildeastcoders.tdd_demo.presenter;

import com.wildeastcoders.tdd_demo.view.MainActivityView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by Majfrendmartin on 2017-10-10.
 */

@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    @Mock
    MainActivityView view;

    private MainActivityPresenterImpl presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new MainActivityPresenterImpl();
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
        verify(view).updateText();
    }

    @Test
    public void onButtonClickedTriggersViewUpdateTextViewNotBound() throws Exception {
        presenter.onButtonClicked();
        verify(view, never()).updateText();
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