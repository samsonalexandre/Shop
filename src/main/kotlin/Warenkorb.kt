class Warenkorb {
    private val products = mutableListOf<Product>()

    fun addToCart(product: Product) {
        products.add(product)
    }

    fun removeFromCart(product: Product) {
        products.remove(product)
    }

    fun getTotalPrice(): Double {
        var totalPrice = 0.0
        for (product in products) {
            totalPrice += product.price
        }
        return totalPrice
    }

    fun getCartProductList(): List<Product> {
        return products
    }

    fun addProducts(products: List<Product>) {
        this.products.addAll(products)
    }
}