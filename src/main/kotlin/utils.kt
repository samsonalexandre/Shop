import kotlin.random.Random

fun createRandomProducts(store: Store, numProducts: Int = 100) {
    val categories = listOf("Modeartikel", "Elektronikartikel", "Filme", "Bücher")
    val subcategories = mapOf(
        "Modeartikel" to listOf("T-Shirts", "Jacken", "Schuhe"),
        "Elektronikartikel" to listOf("Fernseher", "Drucker", "Konsole"),
        "Filme" to listOf("Action", "Drama", "Komödie"),
        "Bücher" to listOf("Roman", "Lehrbuch", "Atlas")
    )

    repeat(numProducts) {
        val name = "Produkt ${it + 1}"
        val price = Random.nextDouble(10.0, 100.0)
        val review = "Bewertung: ${Random.nextInt(1, 6)}"
        val category = categories.random()
        val subcategory = subcategories[category]?.random() ?: ""

        val product = Produkt(name, price, review, category, subcategory)
        store.addProduct(product)
    }
}
