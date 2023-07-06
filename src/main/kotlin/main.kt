fun main() {
    val accountManagement = AccountManagement()
    var currentUser: Account? = null

    while(true) {
        println("Willkommen in unseren Shop!")
        println("Bitte wählen Sie eine Option")
        println(""" 
            [1] - Registrieren
            [2] - Einloggen
            [3] - Beenden
        """.trimIndent()) // Habe beim Viktor abgeguckt
        val choice = readLine()?.toIntOrNull()

        when(choice) {
            1 -> {
                println("Registrierung")
                println("Bitte Benutzername eingeben")
                val username = readLine()
                println("Bitte Passwort eingeben")
                val password = readLine()
                if (username != null && password != null) {
                    accountManagement.registerUser(username, password)
                }
                println("Sie wurden Registriert.")
            }
        }
    }
}