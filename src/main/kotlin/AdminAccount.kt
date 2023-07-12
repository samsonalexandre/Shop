import kotlin.random.Random

open class AdminAccount(username: String, password: String) : Account(username, password) {

    // Erstellt ein neues UserAccount-Objekt und gibt es zurück
    // Wenn Konto existiert mit dem Konto anmelden
    /*
    Hier, habe ich hilfe bekommen vom Sergei Shkredov
    https://habr.com/ru/companies/jugru/articles/274091/
    https://habr.com/ru/companies/jugru/articles/314524/
     */
    fun switchToUserAccount(accountManagement: AccountManagement): UserAccount {
        println("Möchten Sie ein neues Benutzerkonto erstellen oder sich mit einem vorhandenen Konto anmelden?")
        println(
            """
            [1] - Neues Benutzerkonto erstellen
            [2] - Mit vorhandenem Konto anmelden
        """.trimIndent()
        )

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                println("Neues Benutzerkonto erstellen")
                println("Bitte Benutzername eingeben")
                val username = readlnOrNull()
                println("Bitte Passwort eingeben")
                val password = readlnOrNull()

                try {
                    val userAccount = accountManagement.registerAccount(username, password)
                    println("Benutzerkonto erfolgreich erstellt")
                    return userAccount as UserAccount
                } catch (ex: InvalidInputException) {
                    println("Fehler: ${ex.message}")
                }
            }

            2 -> {
                println("Mit vorhandenem Konto anmelden")
                println("Bitte Benutzername eingeben")
                val username = readlnOrNull()
                println("Bitte Passwort eingeben")
                val password = readlnOrNull()

                try {
                    val userAccount = accountManagement.login(username, password)
                    if (userAccount is UserAccount) {
                        println("Anmeldung erfolgreich")
                        return userAccount
                    } else {
                        println("Fehler: Ungültiges Benutzerkonto")
                    }
                } catch (ex: InvalidInputException) {
                    println("Fehler: ${ex.message}")
                } catch (ex: UserNotFoundException) {
                    println("Fehler: ${ex.message}")
                }
            }

            else -> {
                println("Ungültige Eingabe")
            }
        }

        // Wenn ein Fehler auftritt, wird standardmäßig ein leeres UserAccount zurückgegeben.
        return UserAccount("", "")
    }

    // Erstellt eine bestimmte Anzahl zufälliger Produkte und fügt sie zur Produktliste in accountManagement hinzu
    fun createRandomProducts(accountManagement: AccountManagement, numProducts: Int) {
        val categories = listOf("Filme", "Bücher")
        val subCategories = mapOf(
            "Filme" to listOf("Action", "Komödie"),
            "Bücher" to listOf("Roman", "Kinderbuch")
        )
        val filmArtikelName = listOf("Blockbuster", "Thriller", "Horror")
        val bücherArtikelName = listOf("Krimi", "Fantasy", "Biografie")

        repeat(numProducts) {
            val category = categories.random()
            val subCategory = subCategories[category]?.random() ?: ""
            val name = when (category) {
                "Filme" -> filmArtikelName.random()
                "Bücher" -> bücherArtikelName.random()
                else -> ""
            }
            val price = Random.nextDouble(10.0, 100.0)
            val priceString = String.format("%.2f", price)
            val formattedPrice = priceString.replace(",", ".")
            val roundPrice = formattedPrice.toDouble()
            val bewertung = "Bewertung: ${Random.nextInt(1, 6)}"
            val product = Product(name, roundPrice.toDouble(), bewertung, category, subCategory)
            accountManagement.addProduct(product)
        }
    }
}
