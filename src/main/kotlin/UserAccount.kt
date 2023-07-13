class UserAccount(username: String, password: String) : Account(username, password) {
    private val shoppingKorb = Warenkorb()

    fun addToKorb(product: Product) {
        if (product.quantity.isBlank()) {
            throw InvalidProductException("Produkt kann nicht zum Warenkorb hinzugefügt werden")
        }
        shoppingKorb.addToKorb(product)
    }
    // Entfernt ein Produkt aus dem Warenkorb
    fun removeFromKorb(product: Product) {
        shoppingKorb.removeFromKorb(product)
    }

    // Gibt eine Liste der Produkte im Warenkorb zurück
    fun getKorbProductList(): List<Product> {
        return shoppingKorb.getKorbProductList()
    }

    // Gibt den Gesamtpreis der Produkte im Warenkorb zurück
    fun getTotalPriceInKorb(): Double {
        return shoppingKorb.getTotalPrice()
    }

    // Führt den Bezahlungsprozess durch, indem die gewählte Zahlungsmethode verwendet wird
    // gibt eine InvalidProductException, wenn die Bezahlung fehlschlägt
    fun pay() {
        val totalPrice = getTotalPriceInKorb()
        if (totalPrice <= 0.0) {
            throw InvalidProductException("Warenkorb ist leer. Sie können nicht Bezahlen")
        }
        val paymentMethod = paymentMethod()
        if (paymentMethod != null) {
            val isBezahlenErfolgreich = paymentMethod.makePayment(totalPrice)
            if (!isBezahlenErfolgreich) {
                throw InvalidProductException("Bezahlung fehlgeschlagen")
            }
        } else {
            throw InvalidProductException("Bezahlung abgebrochen")
        }
    }

    // Fragt den Benutzer nach der gewünschten Zahlungsmethode und gibt diese zurück
    private fun paymentMethod(): PaymentMethod? {
        println("Womit möchten Sie bezahlen")
        println("[1] Kreditkarte")
        println("[2] PayPal")

        return when (readlnOrNull()?.toIntOrNull()) {
            1 -> PaymentMethod.CREDIT_CARD
            2 -> PaymentMethod.PAYPAL
            else -> null
        }
    }
}