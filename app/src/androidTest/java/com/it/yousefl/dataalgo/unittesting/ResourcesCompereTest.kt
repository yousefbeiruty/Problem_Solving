package com.it.yousefl.dataalgo.unittesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import com.it.yousefl.dataalgo.R
import org.junit.After
import org.junit.Before

import org.junit.Test

class ResourcesCompereTest{

  private  lateinit var  resourcesCompere :ResourcesCompere

    @Before
    fun setUp(){
        resourcesCompere = ResourcesCompere()
    }

    @After
    fun tearDown(){

    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue(){
        val context=ApplicationProvider.getApplicationContext<Context>()
        val result=resourcesCompere.isEqual(context, R.string.app_name,"DataAlgo")

        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse(){
        val context=ApplicationProvider.getApplicationContext<Context>()
        val result=resourcesCompere.isEqual(context, R.string.app_name,"Data")

        assertThat(result).isFalse()
    }
}