class Warenkorb {
    private val products = mutableListOf<Product>()

    // Fügt ein Produkt zum Warenkorb hinzu
    fun addToKorb(product: Product) {
        if (product.quantity.isBlank()) {
            throw InvalidProductException("Produkt kann nicht zum Warenkorb hinzugefügt werden")
        }
        products.add(product)
    }

    // Entfernt ein Produkt aus dem Warenkorb
    fun removeFromKorb(product: Product) {
        if (product.quantity.isBlank()) {
            throw InvalidProductException("Produkt kann nicht von Warenkorb entfernt werden")
        }
        products.remove(product)
    }

    // Berechnet den Gesamtpreis der Produkte im Warenkorb
    fun getTotalPrice(): Double {
        var totalPrice = 0.0
        for (product in products) {
            totalPrice += product.price
        }
        return totalPrice
    }
    // Gibt eine Liste der Produkte im Warenkorb zurück
    fun getKorbProductList(): List<Product> {
        return products
    }
}