package com.wildeastcoders.tdd_demo.view;

import com.wildeastcoders.tdd_demo.BuildConfig;
import com.wildeastcoders.tdd_demo.presenter.MainActivityPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Majfrendmartin on 2017-10-08.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    @Mock
    private MainActivityPresenter presenter;

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void presenterInjectedDuringActivityCreation() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        assertThat(mainActivity.presenter).isNotNull();
    }
}