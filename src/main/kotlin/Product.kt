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
                Product("Wenn der Wind singt. Pinball 1973", 25.0, "15", "Roman", "Popkultur in Japan"),
                Product("Wilde Schafsjagd", 25.0, "20", "Roman", "Detektivgeschichte"),
                Product("Hard-Boiled Wonderland und das Ende der Welt", 25.0, "17", "Roman", "Phantasy"),
                Product("Tanz mit dem Schafsmann",25.0, "12", "Roman", "Mystisch und Real"),
                Product("1Q84", 49.99, "34", "Roman", "Phantasy"),
                Product("Die Ermordung des Commendatore", 49.99, "10", "Roman", "Phantasy"),
                Product("Sputnik Sweetheart",22.0, "2", "Roman", "Mystisch und Real"),
                Product("Gefährliche Geliebte / Südlich der Grenze, westlich der Sonne",25.0, "4", "Roman", "Liebe und Leidenschaft")
            )
        }
    }
}