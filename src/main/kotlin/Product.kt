data class Product(val name: String, var price: Double, var quantity: String, val category: String, val subcategory: String) {
    override fun toString(): String {
        return "$name, $price, $quantity, $category, $subcategory"
    }
}