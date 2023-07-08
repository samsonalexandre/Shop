open class AccountManagement {
    private val userAccounts = mutableListOf<UserAccount>()
    private val adminAccounts = mutableListOf<AdminAccount>()

    fun registerUser(username: String, password: String) {
        val newUserAccount = UserAccount(username, password)
        userAccounts.add(newUserAccount)
    }

    fun registerAdmin(username: String, password: String) {
        val newOwnerAccount = AdminAccount(username, password)
        adminAccounts.add(newOwnerAccount)
    }

    fun login(username: String, password: String): Account? {
        for (userAccount in userAccounts) {
            if (userAccount.username == username && userAccount.password == password) {
                return userAccount
            }
        }

        for (adminAccount in adminAccounts) {
            if (adminAccount.username == username && adminAccount.password == password) {
                return adminAccount
            }
        }
        return null
    }
}