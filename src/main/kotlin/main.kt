fun main() {
    val accountManagement = AccountManagement()
    var currentUser: Account? = null

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
                val password = readLine()//!!!
                if (username != null && password != null) {
                    accountManagement.registerUser(username, password)
                }
                println("Sie wurden Registriert.")
            }

            2 -> {
                println("Einlogen")
                println("Bitte Benutzername eingeben")
                val username = readLine()
                println("Bitte Passwort eingeben")
                val password = readLine()//!!!
                if (username != null && password != null) {
                    val account = accountManagement.login(username, password)
                    if (account != null) {
                        currentUser = account
                        println("Sie haben sich eingelogt.")
                    } else {
                        println("Falsche eingabe")
                    }
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
        if (currentUser is UserAccount) {
            showUserMenu(currentUser)
        } else if (currentUser is OwnerAccount) {
            showOwnerMenu(currentUser)
        }
    }
}
fun showUserMenu(userAccount: UserAccount) {
    while (true) {
        println("Benutzer Menü")
        println("Bitte wählen Sie eine Option:")
        println("""
            [1] - Produkte anzeigen
            [2] - Produkt zum Warenkorb hinzufügen
            [3] - Produkt aus dem Warenkorb entfernen
            [4] - Gesamtpreis im Warenkorb anzeigen
            [5] - Bezahlung
            [6] - Ausloggen
        """.trimIndent())

    }
}
fun showOwnerMenu(ownerAccount: OwnerAccount) {
    while (true) {
        println("Eigentümer Menü")
        println("Bitte wählen Sie eine Option:")
        println("""
            [1] - Produkte anzeigen
            [2] - Produkt hinzufügen
            [3] - Produkt entfernen
        """.trimIndent())

        val userWahl = readLine()?.toIntOrNull()

        when (userWahl) {
            1 -> {
                println("Produkte anzeigen")

            }
        }
    }
}