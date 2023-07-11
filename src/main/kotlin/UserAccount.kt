class UserAccount(username: String, password: String) : Account(username, password) {
    private val shoppingCart = Warenkorb()

    fun addToCart(product: Product) {
        if (product.quantity.isBlank()) {
            throw InvalidProductException("Produkt kann nicht zum Warenkorb hinzugefügt werden")
        }
        shoppingCart.addToCart(product)
    }

    fun addProducts(products: List<Product>) {
        shoppingCart.addProducts(products)
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
        if (totalPrice <= 0.0) {
            throw InvalidProductException("Warenkorb ist leer. Sie könnenZ nicht Bezahlen")
        }
        val paymentMethod = choosePaymentMethod()
        if (paymentMethod != null) {
            val isPaymenSuccessful = paymentMethod.makePayment(totalPrice)
            if (!isPaymenSuccessful) {
                throw InvalidProductException("Bezahlung fehlgeschlagen")
            }
        } else {
            throw InvalidProductException("Bezahlung abgebrochen")
        }
    }

    private fun choosePaymentMethod(): PaymentMethod? {
        println("Womit möchten Sie bezahlen")
        println("[1] Kreditkarte")
        println("[2] PayPal")

        val paymentMethodChois = readlnOrNull()?.toIntOrNull()

        return when (paymentMethodChois) {
            1 -> PaymentMethod.CREDIT_CARD
            2 -> PaymentMethod.PAYPAL
            else -> null
        }
    }
}