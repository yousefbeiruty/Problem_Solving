package com.it.yousefl.dataalgo


import com.google.common.truth.Truth.assertThat
import com.it.yousefl.dataalgo.unittesting.RegistrationUnit
import org.junit.Test

class RegistrationUnitTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUnit.validateRegistrationInput(
            "",
            "123",
            "123")
        assertThat(result).isFalse()

    }

    @Test
    fun `valid username and correctly repeated password return true `() {
        val result = RegistrationUnit.validateRegistrationInput(
            "Yousef",
            "123",
            "123")
        assertThat(result).isTrue()

    }

    @Test
    fun `username already exits return  false`() {
        val result = RegistrationUnit.validateRegistrationInput(
            "Carl",
            "123",
            "123")
        assertThat(result).isFalse()

    }

    //empty password
    //the password was repeated incorrectly
    //password contains less than 2 digits

    @Test
    fun `empty password`() {
        val result = RegistrationUnit.validateRegistrationInput(
            "Lana",
            "",
            "")

        assertThat(result).isFalse()
    }

    @Test
    fun `the password was repeated incorrectly`() {
        val result = RegistrationUnit.validateRegistrationInput(
            "Lana",
            "1234",
            "123")

        assertThat(result).isFalse()
    }

    @Test
    fun `password contains less than 2 digits`() {
        val result = RegistrationUnit.validateRegistrationInput(
            "Lana",
            "abcdefg5",
            "abcdefg5")


        assertThat(result).isFalse()
    }

}