fun userMenu(userAccount: UserAccount, accountManagement: AccountManagement) {
    while (true) {
        println("Benutzer Menü")
        println("Bitte wählen Sie eine Option:")
        println(
            """
            [1] - Produkte anzeigen
            [2] - Produkt zum Warenkorb hinzufügen
            [3] - Produkt aus dem Warenkorb entfernen
            [4] - Gesamtpreis im Warenkorb anzeigen
            [5] - Bezahlung
            [6] - Ausloggen
        """.trimIndent()
        )

        val userWahl = readlnOrNull()?.toIntOrNull()
        if (userWahl != null) {
            when (userWahl) {
                1 -> {
                    println("Produkte anzeigen")
                    val productList = accountManagement.getProductList()
                    for (product in productList) {
                        println("${product.name}. Preis: ${product.price}. Menge: ${product.quantity}. Kategorie: ${product.category}. Unterkategorie: ${product.subcategory}")
                    }
                }

                2 -> {
                    println("Produkt zum Warenkorb hinzufügen")
                    val allProducts = accountManagement.getProductList()
                    println("Bitte wählen Sie ein Produkt")
                    val userProdukt = readlnOrNull()
                    val product = allProducts.find { it.name == userProdukt }
                    if (product != null) {
                        userAccount.addToCart(product)
                        println("Sie haben ${product.name}. Preis: ${product.price}. Menge: ${product.quantity}. " +
                                "Kategorie: ${product.category}. Unterkategorie: ${product.subcategory}  in ihren Warenkorb zugefügt")
                    } else {
                        println("Falsche eingabe")
                    }
                }

                3 -> {
                    println("Produkt aus dem Warenkorb entfernen")
                    val cardProdukts = userAccount.getCartProductList()
                    println("Bitte wählen Sie ein Produkt zum entfernen")
                    val userProdukt = readlnOrNull()
                    val product = cardProdukts.find { it.name == userProdukt }
                    if (product != null) {
                        userAccount.removeFromCart(product)
                        println("Das Produkt ${product.name} wurde aus Ihrem Warenkorb entfernt")
                    }
                }

                4 -> {
                    println("Gesamtpreis im Warenkorb anzeigen")
                    println("Gesamtpreis: ${userAccount.getTotalPriceInCart()}")
                }

                5 -> {
                    println("Bezahlung")
                    userAccount.pay()
                }

                6 -> {
                    println("Auf Wiedersehen")
                    break
                }

                else -> {
                    println("Falsche eingabe")
                }
            }
        }
    }
}