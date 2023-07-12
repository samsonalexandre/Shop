class Warenkorb {
    private val products = mutableListOf<Product>()

    // Fügt ein Produkt zum Warenkorb hinzu
    fun addToKorb(product: Product) {
        products.add(product)
    }

    // Entfernt ein Produkt aus dem Warenkorb
    fun removeFromKorb(product: Product) {
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

//    // Fügt eine Liste von Produkten zum Warenkorb hinzu
//    fun addProducts(products: List<Product>) {
//        this.products.addAll(products)
//    }
}