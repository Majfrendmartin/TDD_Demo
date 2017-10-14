package com.wildeastcoders.tdd_demo.view;

import com.wildeastcoders.tdd_demo.BuildConfig;
import com.wildeastcoders.tdd_demo.inject.module.ActivityModule;
import com.wildeastcoders.tdd_demo.presenter.MainActivityPresenter;
import com.wildeastcoders.tdd_demo.usecase.ProduceTextUsecase;

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
import static org.mockito.Mockito.verify;

/**
 * Created by Majfrendmartin on 2017-10-08.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    @Mock
    private MainActivityPresenter presenter;

    private ActivityController<MainActivity> activityController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        activityController = Robolectric.buildActivity(MainActivity.class);
        activityController.get().setActivityModule(new MockActivityModule(presenter));
    }

    private class MockActivityModule extends ActivityModule {
        private final MainActivityPresenter presenter;

        private MockActivityModule(MainActivityPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public MainActivityPresenter provideMainActivityPresenter(ProduceTextUsecase produceTextUsecase) {
            return presenter;
        }
    }

    @Test
    public void presenterInjectedDuringActivityCreation() throws Exception {
        final MainActivity mainActivity = getCreatedMainActivity();
        assertThat(mainActivity.presenter).isNotNull();
    }

    @Test
    public void buttonClickTriggersPresenterMethod() throws Exception {
        getCreatedMainActivity().onSubmitClicked();
        verify(presenter).onButtonClicked();
    }

    @Test
    public void viewBoundToPresenterAfterCreation() throws Exception {
        final MainActivity mainActivity = getCreatedMainActivity();
        verify(presenter).bindView(mainActivity);
    }

    @Test
    public void updateTextCall() throws Exception {
        final MainActivity mainActivity = getCreatedMainActivity();
        final String text = "text";
        mainActivity.updateText(text);
        assertThat(mainActivity.tvText.getText().toString()).isEqualTo(text);

    }

    private MainActivity getCreatedMainActivity() {
        return activityController.create().get();
    }
}