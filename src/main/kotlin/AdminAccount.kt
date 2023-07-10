import kotlin.random.Random

open class AdminAccount(username: String, password: String) : Account(username, password) {
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

    fun getProductList(): List<Product> {
        return products.toList()
    }

    fun getProductByName(name: String): Product? {
        return products.find { it.name == name }
    }

    fun createRandomProducts(numProducts: Int) {
        val categories = listOf("Filme", "Bücher")
        val subCategories = mapOf(
            "Filme" to listOf("Action", "Komödie"),
            "Bücher" to listOf("Roman", "Kinderbuch")
        )
        val filmArtikelName = listOf("Blockbuster", "Thriller", "Horror")
        val bücherArtikelName = listOf("Krimi", "Fantasy", "Biografie")

        repeat(numProducts) {
            val category = categories.random()
            val subCategory = subCategories[category]?.random() ?: ""
            val name = when (category) {
                "Filme" -> filmArtikelName.random()
                "Bücher" -> bücherArtikelName.random()
                else -> ""
            }
            val price = Random.nextDouble(10.0, 100.0)
            val priceString = String.format("%.2f", price)
            val formattedPrice = priceString.replace(",", ".")
            val roundPrice = formattedPrice.toDouble()
            val bewertung = "Bewertung: ${Random.nextInt(1, 6)}"
            val product = Product(name, roundPrice.toDouble(), bewertung, category, subCategory)
            addProduct(product)

        }
    }
}