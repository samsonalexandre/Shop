class UserAccount(username: String, password: String): Account(username, password) {
    private val shoppingCart = Warenkorb()
    private var adminAccount: AdminAccount? = null //Chat GPT

    fun addToCart(product: Product) {
        shoppingCart.addToCart(product)
    }

    fun removeFromCart(product: Product) {
        shoppingCart.removeFromCart(product)
    }
    fun getCartProductList(): List<Product> {
        return shoppingCart.getCartProductList()
    }

    fun getTotalPriceInCart(): Double {
        return shoppingCart.getTotalPrice()
    }

    fun pay() {
        val totalPrice = getTotalPriceInCart()
        val paymentMethod = choosePaymentMethod()
        if (paymentMethod != null) {
            val isPaymentSuccessful = paymentMethod.makePayment(totalPrice)
            if (isPaymentSuccessful) {
                println("Sie haben bezahlt $totalPrice")
            } else {
                println("Es ist ein Fehler passiert, bitte versuchen Sie noch ein mal")
            }
        } else {
            println("Bezahlung abgebrochen")
        }

    }
    private fun choosePaymentMethod(): PaymentMethod? {
        println("Womit möchten Sie bezahlen")
        println("[1] Kreditkarte")
        println("[2] PayPal")

        val paymentMethodChois = readlnOrNull()?.toIntOrNull()

        return when(paymentMethodChois) {
            1 -> PaymentMethod.CREDIT_CARD
            2 -> PaymentMethod.PAYPAL
            else -> null
        }
    }
    fun setOwnerAccount(ownerAccount: AdminAccount) { // Chat GPT.
        this.adminAccount = ownerAccount
    }
    fun viewAllProducts(): List<Product> {
        return adminAccount?.getProductList() ?: emptyList()
    }
}