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
                Product("Wenn der Wind singt. Pinball 1973", 25.0, "15", "Kateg1", "UnterKateg1"),
                Product("Wilde Schafsjagd", 25.0, "20", "Kateg1", "UnterKateg1"),
                Product("Hard-Boiled Wonderland und das Ende der Welt", 25.0, "17", "Kateg1", "UnterKateg1"),
                Product("Tanz mit dem Schafsmann", 25.0, "12", "Kateg1", "UnterKateg1"),
                Product("1Q84", 25.0, "34", "Kateg1", "UnterKateg1"),
                Product("Die Ermordung des Commendatore", 25.0, "10", "Kateg1", "UnterKateg1"),
                Product("Sputnik Sweetheart", 25.0, "2", "Kateg1", "UnterKateg1"),
                Product("Gefährliche Geliebte / Südlich der Grenze, westlich der Sonne", 25.0, "4", "Kateg1", "UnterKateg1")
            )
        }
    }
}