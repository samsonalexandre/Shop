data class Product(
    val name: String,
    var price: Double,
    var quantity: String,
    val category: String,
    val subcategory: String
) {
    companion object {
        fun getPredefinedProducts(): List<Product> {
            return listOf(
                Product("Pr1", 10.0, "10", "Kateg1", "UnterKateg1")
                //weitere Produkte
            )
        }
    }
}