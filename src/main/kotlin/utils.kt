import kotlin.math.round
import kotlin.random.Random

fun createRandomProducts(store: Store, numProducts: Int = 10) {
    val categories = listOf("Kleidung", "Elektronikartikel", "Filme", "Bücher")
    val subcategories = mapOf(
        "Kleidung" to listOf("T-Shirts", "Jacken", "Schuhe"),
        "Elektronik" to listOf("Fernseher", "Drucker", "Konsole"),
        "Filme" to listOf("Action", "Drama", "Komödie"),
        "Bücher" to listOf("Roman", "Lehrbuch", "Atlas")
    )
    var kleidungArtikelNamen = listOf("Hemd", "Hose", "Kleid", "Bluse", "Anzug")
    var elektronikArtikelNamen = listOf("Smartphone", "Laptop", "Kamera", "Kopfhörer")
    var filmeArtikelNamen = listOf("Blockbuster", "Thriller", "Horror", "Liebesfilm")
    val bücherArtikelNamen = listOf("Krimi", "Fantasy", "Biografie", "Sachbuch")


    repeat(numProducts) {
        val category = categories.random()
        val subcategory = subcategories[category]?.random() ?: ""
        val name = when (category) {
            "Kleidung" -> kleidungArtikelNamen.random()
            "Elektronik" -> elektronikArtikelNamen.random()
            "Filme" -> filmeArtikelNamen.random()
            "Bücher" -> bücherArtikelNamen.random()
            else -> ""
        }
        val price = Random.nextDouble(10.0, 100.0)
        var roundPrice = round(price * 100) / 100
        val review = "Bewertung: ${Random.nextInt(1, 6)}"



        val product = Produkt(name, roundPrice, review, category, subcategory)
        store.addProduct(product)
    }
}
