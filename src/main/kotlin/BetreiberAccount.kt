open class OwnerAccount(username: String, password: String): Account(username, password) {
    private val products = mutableListOf<Product>()

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun removeProduct(product: Product) {
        products.remove(product)
    }

    fun changeProductPrice(product: Product, newPrice: Double) {
        product.price = newPrice
    }
}