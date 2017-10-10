package com.wildeastcoders.tdd_demo.inject.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Majfrendmartin on 2017-10-10.
 */

@Scope
@Retention(RUNTIME)
public @interface PerApplication {
}
