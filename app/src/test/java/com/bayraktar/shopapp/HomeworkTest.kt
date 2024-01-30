package com.bayraktar.shopapp

import com.google.common.truth.Truth
import org.junit.Test


class HomeworkTest {

    @Test
    fun `are starting braces counts equal to closing ones`(){
        val result = Homework.checkBraces(
            "(Ozerr)))",

        )
        Truth.assertThat(result).isFalse()
    }
}