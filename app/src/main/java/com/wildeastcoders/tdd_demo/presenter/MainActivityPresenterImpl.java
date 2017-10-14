package com.wildeastcoders.tdd_demo.presenter;

import com.wildeastcoders.tdd_demo.usecase.ProduceTextUsecase;
import com.wildeastcoders.tdd_demo.view.MainActivityView;

/**
 * Created by Majfrendmartin on 2017-10-10.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {
    private final ProduceTextUsecase produceTextUsecase;
    /*package*/ MainActivityView view;


    public MainActivityPresenterImpl(ProduceTextUsecase produceTextUsecase) {
        this.produceTextUsecase = produceTextUsecase;
    }

    @Override
    public void onButtonClicked() {
        produceTextUsecase.execute()
                .subscribe(this::handleUpdateText);
    }

    private void handleUpdateText(String text) {
        if (isViewBound()) {
            view.updateText(text);
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
