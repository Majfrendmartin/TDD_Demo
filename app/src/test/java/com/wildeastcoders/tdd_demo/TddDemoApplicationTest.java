package com.wildeastcoders.tdd_demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by Majfrendmartin on 2017-10-10.
 */

@RunWith(RobolectricTestRunner.class)
public class TddDemoApplicationTest {
    private TddDemoApplication tddDemoApplication;

    @Before
    public void setUp() throws Exception {
       tddDemoApplication = new TddDemoApplication();
    }

    @Test
    public void applicationComponentCreatedOnCreate() throws Exception {
        tddDemoApplication.onCreate();
        assertThat(tddDemoApplication.getApplicationComponent()).isNotNull();
    }

}