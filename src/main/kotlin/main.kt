fun main() {
    val accountManagement = AccountManagement()

    while (true) {
        println("Willkommen in unseren Shop!")
        println("Bitte wählen Sie eine Option")
        println(
            """ 
            [1] - Registrieren
            [2] - Einloggen
            [3] - Beenden
        """.trimIndent()
        ) // Habe beim Viktor abgeguckt
        val userWahl = readLine()?.toIntOrNull()

        when (userWahl) {
            1 -> {
                println("Registrierung")
                println("Bitte Benutzername eingeben")
                val username = readLine()
                println("Bitte Passwort eingeben")
                val password = readLine()
                println("Möchten Sie einen Admin-Account erstellen? (Ja/Nein):")
                val isAdminInput = readLine()
                val isAdmin = isAdminInput == "Ja"
                try {
                    accountManagement.registerAcoount(username, password, isAdmin)
                    println("Registrierung erfolgreich")
                } catch (ex: InvalidInputException) {
                    println("Fehler: ${ex.message}")
                }

            }

            2 -> {
                println("Einlogen")
                println("Bitte Benutzername eingeben")
                val username = readLine()
                println("Bitte Passwort eingeben")
                val password = readLine()

                try {
                    val account = accountManagement.login(username, password)
                    if (account is UserAccount) {
                        userMenu(account)
                    } else if (account is AdminAccount) {
                        adminMenu(account)
                    }
                } catch (ex: InvalidInputException) {
                    println("Fehler: ${ex.message}")
                } catch (ex: UserNotFoundException) {
                    println("Fehler: ${ex.message}")
                }

            }

            3 -> {
                println("Auf Wiedersehen!")
                break
            }

            else -> {
                println("Bitte eine Zahl zwischen 1 und 3")
            }
        }
    }
}

