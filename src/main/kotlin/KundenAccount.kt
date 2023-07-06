class UserAccount(username: String, password: String): Account(username, password) {

    val shoppingCart = Warenkorb()

    fun addToCart(product: Product) {
        shoppingCart.addToCart(product)
    }

    fun removeFromCart(product: Product) {
        shoppingCart.removeFromCart(product)
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
        val paymentMethodChois = readLine()?.toIntOrNull()

        return when(paymentMethodChois) {
            1 -> CreditCardPayment()
            2 -> PayPalPayment()
            else -> null
        }
    }
}