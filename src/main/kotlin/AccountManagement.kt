import kotlin.random.Random

open class AccountManagement() {
    private val userAccounts = mutableListOf<UserAccount>()
    private val adminAccounts = mutableListOf<AdminAccount>()
    private val productsList = mutableListOf<Product>()

    // Registriert einen neuen Benutzer oder Admin-Account
    // Gibt den erstellten Account zurück
    fun registerAccount(username: String?, password: String?, isAdmin: Boolean = false): Account {
        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            throw InvalidInputException("Ungültige Benutzerdaten")
        }
        /*
        Die Bedingung beginnt mit dem Ausdruck userAccounts.any, der darauf hinweist, dass die Funktion any auf der Liste
        userAccounts angewendet wird. any ist eine Funktion, die über jedes Element der Liste iteriert und überprüft,
        ob ein bestimmtes Kriterium erfüllt ist. In diesem Fall wird überprüft, ob das Attribut username eines Elements in userAccounts mit der Variable username übereinstimmt.
        https://developer.alexanderklimov.ru/android/kotlin/class.php#any
         */
        if (userAccounts.any { it.username == username }) {
            throw InvalidInputException("Benutzername existiert bereits")
        }
        if (isAdmin && adminAccounts.any { it.username == username }) {
            throw InvalidInputException("Admin Benutzername existiert bereits")
        }
        val account = if (isAdmin) AdminAccount(username, password) else UserAccount(username, password)
        if (isAdmin) {
            adminAccounts.add(account as AdminAccount)
        } else {
            userAccounts.add(account as UserAccount)
        }
        return account
    }

    // Fügt ein Produkt zur Produktliste hinzu
    fun addProduct(product: Product) {
        productsList.add(product)
    }

    // Entfernt ein Produkt aus der Produktliste
    fun removeProduct(product: Product) {
        productsList.remove(product)
    }

    // Gibt eine Kopie der Produktliste zurück
    fun getProductList(): List<Product> {
        return productsList.toList()
    }

    // Überprüft die Benutzerdaten und gibt den entsprechenden Account zurück
    // Gibt eine InvalidInputException oder UserNotFoundException, wenn die Benutzerdaten falsch sind
    fun login(username: String?, password: String?): Account {
        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            throw InvalidInputException("Ungültige Eingabe")
        }
        val userAccount = userAccounts.find { it.username == username && it.password == password }
        val adminAccount = adminAccounts.find { it.username == username && it.password == password }
        return userAccount ?: adminAccount ?: throw UserNotFoundException("Benutzer nicht gefunden")
    }
}

