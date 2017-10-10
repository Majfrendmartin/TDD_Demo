package com.wildeastcoders.tdd_demo.presenter;

import com.wildeastcoders.tdd_demo.view.MainActivityView;

/**
 * Created by Majfrendmartin on 2017-10-08.
 */

public interface MainActivityPresenter extends Presenter<MainActivityView> {
    void onButtonClicked();
}
