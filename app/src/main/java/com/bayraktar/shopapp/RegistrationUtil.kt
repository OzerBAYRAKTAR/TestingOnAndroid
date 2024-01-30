package com.bayraktar.shopapp

object RegistrationUtil {

    private val nameList = mutableListOf<String>("Peter","Carl")

    /**
     * the input is not valid if
     * ..the username/password is empty
     * ..the username is already taken
     * ..the confirmed password is not the same as the real password
     * .. the password contains less han 2 digits
     */

    fun validateRegistrationInput(
        username: String,
        passwrd: String,
        confirmedPassword: String
    ):Boolean {
        if (username.isEmpty() || passwrd.isEmpty()) {
            return  false
        }
        if (username in nameList) {
            return false
        }
        if (passwrd != confirmedPassword) {
            return false
        }
        if (passwrd.count { it.isDigit() } < 2) {
            return false
        }
        return true
    }
}