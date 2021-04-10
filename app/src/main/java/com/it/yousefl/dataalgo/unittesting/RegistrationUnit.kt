package com.it.yousefl.dataalgo.unittesting

object RegistrationUnit {

    private val existingUsers = listOf("Peter", "Carl");

    /**
     * the input is not valid if
     * ..... the username/password is empty
     * ..... the username is already taken
     * ..... the confirmPassword!=password
     * ..... the password contain less than 2 digits
     * */
    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty() ||
            username in existingUsers ||
            password != confirmPassword ||
            password.count { it.isDigit() }<2)
        return false

        return true
    }
}