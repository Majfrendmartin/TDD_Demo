package com.wildeastcoders.tdd_demo.presenter;

import com.wildeastcoders.tdd_demo.view.MainActivityView;

/**
 * Created by Majfrendmartin on 2017-10-10.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {
    MainActivityView view;

    @Override
    public void onButtonClicked() {
        if (isViewBound()) {
            view.updateText();
        }
    }

    @Override
    public void bindView(MainActivityView view) {
        this.view = view;
    }

    @Override
    public boolean isViewBound() {
        return view != null;
    }
}
