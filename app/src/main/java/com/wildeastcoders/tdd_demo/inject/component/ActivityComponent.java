package com.wildeastcoders.tdd_demo.inject.component;

import com.wildeastcoders.tdd_demo.inject.module.ActivityModule;
import com.wildeastcoders.tdd_demo.inject.scope.PerActivity;
import com.wildeastcoders.tdd_demo.view.MainActivity;

import dagger.Component;

/**
 * Created by Majfrendmartin on 2017-10-10.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
