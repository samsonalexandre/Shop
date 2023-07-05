class Store(var products: MutableList<Produkt> = mutableListOf()) {
    fun addProduct(product: Produkt) {
        products.add(product)
    }

    fun removeProduct(product: Produkt) {
        products.remove(product)
    }

    fun getAllProducts(): List<Produkt> {
        return products.toList()
    }

    fun getProductsByCategory(category: String): List<Produkt> {
        return products.filter { it.category == category }
    }

    fun getProductsBySubcategory(subcategory: String): List<Produkt> {
        return products.filter { it.subcategory == subcategory }
    }
}