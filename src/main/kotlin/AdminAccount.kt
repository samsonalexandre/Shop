import kotlin.random.Random

open class AdminAccount(username: String, password: String) : Account(username, password) {

    fun switchToUserAccount(accountManagement: AccountManagement): UserAccount {
        println("Möchten Sie ein neues Benutzerkonto erstellen oder sich mit einem vorhandenen Konto anmelden?")
        println("[1] - Neues Benutzerkonto erstellen")
        println("[2] - Mit vorhandenem Konto anmelden")

        when (readLine()?.toIntOrNull()) {
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

        // Falls ein Fehler auftritt oder die Eingabe ungültig ist, wird standardmäßig ein leeres UserAccount zurückgegeben.
        return UserAccount("", "")
    }

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
