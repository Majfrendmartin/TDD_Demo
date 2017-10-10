package com.wildeastcoders.tdd_demo.inject.component;

import com.wildeastcoders.tdd_demo.inject.module.ApplicationModule;
import com.wildeastcoders.tdd_demo.inject.scope.PerApplication;

import dagger.Component;

/**
 * Created by Majfrendmartin on 2017-10-10.
 */

@PerApplication
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
}
