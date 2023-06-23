package com.base.meditation_composeui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Features(
    val title:String,
    val color:Color,
    @DrawableRes val iconid:Int
)
