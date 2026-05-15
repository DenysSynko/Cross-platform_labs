package com.example.lr6

import android.content.Context
import android.content.res.Resources

private var _applicationResources: Resources? = null
val applicationResources: Resources
    get() = _applicationResources ?: Resources.getSystem()

fun initializeApplicationResources(context: Context) {
    _applicationResources = context.applicationContext.resources
}