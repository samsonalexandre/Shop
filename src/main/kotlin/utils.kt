//import kotlin.math.round
//import kotlin.random.Random
//
//fun createRandomProducts(product: Product, numProducts: Int) {
//    val categories = listOf("Filme", "Bücher")
//    val subcategories = mapOf(
//        "Filme" to listOf("Action", "Komödie"),
//        "Bücher" to listOf("Roman", "Kinderbuch")
//    )
//    val filmeArtikelNamen = listOf("Blockbuster", "Thriller", "Horror")
//    val bücherArtikelNamen = listOf("Krimi", "Fantasy", "Biografie")
//
//    var counter = 1
//    repeat(numProducts) {
//        val category = categories.random()
//        val subcategory = subcategories[category]?.random() ?: ""
//        val name = when (category) {
//            "Filme" -> "${counter++}: ${filmeArtikelNamen.random()}"
//            "Bücher" -> "${counter++}: ${bücherArtikelNamen.random()}"
//            else -> ""
//        }
//        val price = Random.nextDouble(10.0, 100.0)
//        var roundPrice = round(price * 100) / 100
//        val bewertung = "Bewertung: ${Random.nextInt(1, 6)}"
//
//
//
//        val product = Product(name, roundPrice, bewertung, category, subcategory)
//        product.addProduct(product)
//    }
//}

//    accountManagement.registerUser("Alex", "123456")
//    accountManagement.registerOwner("Andreas", "654321")
//
//    //Loge mich ein als Benutzer
//    val userAccount = accountManagement.login("Alex", "123456") as? UserAccount // as? UserAccount habe ich bei Chat GPT gefunden. Sonst zeile 11 und 12 waren falsch
//    if (userAccount != null) {
//        //Produkt hinzufügen
//        val product1 = Product("Produkt 1", 9.99, "1", "Kategorie", "Unterkategorie")
//        val product2 = Product("Produkt 2", 19.99, "1", "Kategorie", "Unterkategorie")
//        userAccount.shoppingCart.addToCart(product1)
//        userAccount.shoppingCart.addToCart(product2)
//
//        // Gesamtpreis im Warenkorb anzeigen
//        val totalPrice = userAccount.getTotalPriceInCart()
//        println("Gesamtpreis im Warenkorb: $totalPrice")
//
//        // Bezahlung
//        userAccount.pay()
//    }
//    val ownerAccount = accountManagement.login("owner1", "password") as? OwnerAccount
//    if (ownerAccount != null) {
//        // Produkt hinzufügen
//        val newProduct = Product("Neues Produkt", 29.99, "1", "Kategorie", "Unterkategorie")
//        ownerAccount.addProduct(newProduct)
//
//        // Produkt entfernen
//        ownerAccount.removeProduct(newProduct)
//
//        // Produkt Preis ändern
//        ownerAccount.changeProductPrice(newProduct, 14.99)
//    }
