package com.shivamdev.phonepaynotes.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by shivam on 20/7/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}