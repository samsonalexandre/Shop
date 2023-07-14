data class Product(
    val name: String,
    val autor: String,
    var price: Double,
    var quantity: String,
    val category: String,
    val subcategory: String
) {
    companion object {
        fun getPredefinedProducts(): List<Product> {
            return listOf(
                Product("Wenn der Wind singt. Pinball 1973", "Haruki Murakami", 25.0, "15", "Roman", "Popkultur in Japan"),
                Product("Wilde Schafsjagd", "Haruki Murakami", 25.0, "20", "Roman", "Detektivgeschichte"),
                Product("Hard-Boiled Wonderland und das Ende der Welt", "Haruki Murakami", 25.0, "17", "Roman", "Phantasy"),
                Product("Tanz mit dem Schafsmann", "Haruki Murakami", 25.0, "12", "Roman", "Mystisch und Real"),
                Product("1Q84", "Haruki Murakami", 49.99, "34", "Roman", "Phantasy"),
                Product("Die Ermordung des Commendatore", "Haruki Murakami", 49.99, "10", "Roman", "Phantasy"),
                Product("Sputnik Sweetheart", "Haruki Murakami", 22.0, "2", "Roman", "Mystisch und Real"),
                Product("Gefährliche Geliebte / Südlich der Grenze, westlich der Sonne", "Haruki Murakami", 25.0, "4", "Roman", "Liebe und Leidenschaft")
            )
        }
    }
}