import kotlin.math.round
import kotlin.random.Random

fun createRandomProducts(store: Store, numProducts: Int) {
    val categories = listOf("Elektronik", "Filme", "Bücher")
    val subcategories = mapOf(
        "Elektronik" to listOf("Fernseher", "Drucker", "Konsole"),
        "Filme" to listOf("Action", "Drama", "Komödie"),
        "Bücher" to listOf("Roman", "Lehrbuch", "Atlas")
    )
    val elektronikArtikelNamen = listOf("Smartphone", "Laptop", "Kamera", "Kopfhörer")
    val filmeArtikelNamen = listOf("Blockbuster", "Thriller", "Horror", "Liebesfilm")
    val bücherArtikelNamen = listOf("Krimi", "Fantasy", "Biografie", "Sachbuch")

    var counter = 1
    repeat(numProducts) {
        val category = categories.random()
        val subcategory = subcategories[category]?.random() ?: ""
        val name = when (category) {
            "Elektronik" -> "${counter++}: ${elektronikArtikelNamen.random()}"
            "Filme" -> "${counter++}: ${filmeArtikelNamen.random()}"
            "Bücher" -> "${counter++}: ${bücherArtikelNamen.random()}"
            else -> ""
        }
        val price = Random.nextDouble(10.0, 100.0)
        var roundPrice = round(price * 100) / 100
        val bewertung = "Bewertung: ${Random.nextInt(1, 6)}"



        val product = Produkt(name, roundPrice, bewertung, category, subcategory)
        store.addProduct(product)
    }
}
