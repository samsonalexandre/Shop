val adminAccount: AdminAccount? = null
fun login () {
    var versuche = 0
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
                        println("Hallo $username Sie haben sich eingelogt.")
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
            userMenu(currentUser)
        } else if (currentUser is AdminAccount) {
            adminMenu(currentUser)
        }
    }
}