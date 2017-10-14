package com.wildeastcoders.tdd_demo.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wildeastcoders.tdd_demo.R;
import com.wildeastcoders.tdd_demo.TddDemoApplication;
import com.wildeastcoders.tdd_demo.inject.component.DaggerActivityComponent;
import com.wildeastcoders.tdd_demo.inject.module.ActivityModule;
import com.wildeastcoders.tdd_demo.presenter.MainActivityPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @BindView(R.id.tvText)
    TextView tvText;

    @Inject
    MainActivityPresenter presenter;

    private ActivityModule activityModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerActivityComponent.builder()
                .applicationComponent(((TddDemoApplication) getApplication()).getApplicationComponent())
                .activityModule(getActivityModule())
                .build()
                .inject(this);

        presenter.bindView(this);
    }

    @OnClick(R.id.btnSubmit)
    void onSubmitClicked() {
        presenter.onButtonClicked();
    }

    private ActivityModule getActivityModule() {
        if (activityModule == null) {
            activityModule = new ActivityModule();
        }
        return activityModule;
    }

    void setActivityModule(ActivityModule activityModule) {
        this.activityModule = activityModule;
    }

    @Override
    public void updateText(@NonNull String text) {
        tvText.setText(text);
    }
}
