package com.bayraktar.shopapp

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{


    @Test
    fun `empty username return false`(){
            val result = RegistrationUtil.validateRegistrationInput(
                "",
                "213",
                "123"
            )
        assertThat(result).isFalse()
    }


    @Test
    fun `valid username and correctly repeated password returns true`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "ozer",
            "234",
            "234"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "234",
            "234"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password is empty returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Ozerr",
            "",
            "234"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password was not repeated correctly returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Ozerr",
            "asdfas1",
            "asdfa124"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password has less than 2 digits returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Ozerr",
            "asdgag1",
            "asdgag1"
        )
        assertThat(result).isFalse()
    }

}