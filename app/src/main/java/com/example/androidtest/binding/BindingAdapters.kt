/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.androidtest.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidtest.R

/**
 * Data Binding adapters specific to the app.
 */
@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, userId: Int) {
    Glide
        .with(imageView.context)
        .setDefaultRequestOptions(RequestOptions.placeholderOf(R.drawable.account).error(R.drawable.account))
        .load("https://api.adorable.io/avatars/56/$userId")
        .into(imageView)
}

