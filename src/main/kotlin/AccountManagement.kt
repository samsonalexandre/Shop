import kotlin.random.Random

open class AccountManagement() {
    private val userAccounts = mutableListOf<UserAccount>()
    private val adminAccounts = mutableListOf<AdminAccount>()
    private val productsList = mutableListOf<Product>()

    fun registerAccount(username: String?, password: String?, isAdmin: Boolean = false): Account {
        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            throw InvalidInputException("Ungültige Benutzerdaten")
        }

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

    fun addProduct(product: Product) {
        productsList.add(product)
    }

    fun removeProduct(product: Product) {
        productsList.remove(product)
    }

    fun getProductList(): List<Product> {
        return productsList.toList()
    }

    fun login(username: String?, password: String?): Account {
        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            throw InvalidInputException("Ungültige Eingabe")
        }
        val userAccount = userAccounts.find { it.username == username && it.password == password }
        val adminAccount = adminAccounts.find { it.username == username && it.password == password }
        return userAccount ?: adminAccount ?: throw UserNotFoundException("Benutzer nicht gefunden")
    }
}

