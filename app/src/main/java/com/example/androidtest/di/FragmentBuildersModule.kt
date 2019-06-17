package com.example.androidtest.di

import com.example.androidtest.ui.postdetail.PostDetailFragment
import com.example.androidtest.ui.postlist.PostListFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributePostListFragment(): PostListFragment

    @ContributesAndroidInjector
    abstract fun contributePostDetailFragment(): PostDetailFragment
}

