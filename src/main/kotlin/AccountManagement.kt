class AccountManagement {
    private val userAccounts = mutableListOf<UserAccount>()
    private val ownerAccounts = mutableListOf<OwnerAccount>()

    fun registerUser(username: String, password: String) {
        val newUserAccount = UserAccount(username, password)
        userAccounts.add(newUserAccount)
    }

    fun registerOwner(username: String, password: String) {
        val newOwnerAccount = OwnerAccount(username, password)
        ownerAccounts.add(newOwnerAccount)
    }

    fun login(username: String, password: String): Account? {
        for (userAccount in userAccounts) {
            if (userAccount.username == username && userAccount.password == password) {
                return userAccount
            }
        }

        for (ownerAccount in ownerAccounts) {
            if (ownerAccount.username == username && ownerAccount.password == password) {
                return ownerAccount
            }
        }

        return null
    }
}