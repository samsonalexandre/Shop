fun userMenu(userAccount: UserAccount, accountManagement: AccountManagement) {
    while (true) {
        println("Benutzer Menü")
        println("Bitte wählen Sie eine Option:")
        println(
            """
            [1] - Produkte anzeigen
            [2] - Produkt zum Warenkorb hinzufügen
            [3] - Produkte im Warenkorb anzeigen
            [4] - Produkt aus dem Warenkorb entfernen
            [5] - Gesamtpreis im Warenkorb anzeigen
            [6] - Bezahlung
            [7] - Ausloggen
        """.trimIndent()
        )

        when (readlnOrNull()?.toIntOrNull()) {
            // Zeigt Liste mit Produkten
            1 -> {
                println("Produkte anzeigen")
                val productList = accountManagement.getProductList()
                if (productList != null) {
                    for (product in productList) {
                        println("${product.name}. Preis: ${product.price}. Menge: ${product.quantity}. Kategorie: ${product.category}. Unterkategorie: ${product.subcategory}")
                    }
                } else {
                    println("Es sind keine produkte verfügbar")
                }

            }
            // Fügt ein Produkt zum Warenkorb
            2 -> {
                println("Produkt zum Warenkorb hinzufügen")
                val allProducts = accountManagement.getProductList()
                println("Bitte wählen Sie ein Produkt")
                val userProdukt = readlnOrNull()
                val product = allProducts.find { it.name == userProdukt }
                if (product != null) {
                    userAccount.addToKorb(product)
                    println(
                        "Sie haben ${product.name}. Preis: ${product.price}. Menge: ${product.quantity}. " +
                                "Kategorie: ${product.category}. Unterkategorie: ${product.subcategory}  in ihren Warenkorb zugefügt"
                    )
                } else {
                    println("Falsche eingabe")
                }
            }
            // Zeigt Produkte im Warenkorb
            3 -> {
                println("Produkte im Warenkorb anzeigen")
                val korbList = userAccount.getKorbProductList()
                for (korb in korbList) {
                    println("${korb.name}. Preis: ${korb.price}")
                }
            }
            // Entfernt ein Produkt aus dem Warenkorb
            4 -> {
                println("Produkt aus dem Warenkorb entfernen")
                val cardProdukts = userAccount.getKorbProductList()
                println("Bitte wählen Sie ein Produkt zum entfernen")
                val userProdukt = readlnOrNull()
                val product = cardProdukts.find { it.name == userProdukt }
                if (product != null) {
                    userAccount.removeFromKorb(product)
                    println("Das Produkt ${product.name} wurde aus Ihrem Warenkorb entfernt")
                }
            }
            // Zeigt den Gesamtpreis der Produkte im Warenkorb an
            5 -> {
                println("Gesamtpreis im Warenkorb anzeigen")
                println("Gesamtpreis: ${userAccount.getTotalPriceInKorb()}")
            }
            // Führt den Bezahlungsprozess durch
            6 -> {
                println("Bezahlung")
                userAccount.pay()
            }
            // Beendet die Schleife und das Menü
            7 -> {
                println("Auf Wiedersehen")
                break
            }

            else -> {
                throw InvalidInputException("Falsche eingabe")
            }
        }

    }
}