package com.example.androidtest.di

import com.example.androidtest.ui.post.PostFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostFragment
}
