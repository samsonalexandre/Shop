fun adminMenu(adminAccount: AdminAccount, accountManagement: AccountManagement) {

    while (true) {
        println("Eigentümer Menü")
        println("Bitte wählen Sie eine Option:")
        println(
            """
            [1] - Produkte anzeigen
            [2] - Produkt hinzufügen
            [3] - Produkt entfernen
            [4] - Zufällige Produkte erstellen
            [5] - Zu Benutzerkonto wechseln
            [6] - Ausloggen
        """.trimIndent()
        )

        when (readlnOrNull()?.toIntOrNull()) {
            // Zeigt Liste mit Produkten
            1 -> {
                println("Produkte anzeigen")
                val productList = accountManagement.getProductList()
                if (productList.isNotEmpty()) {
                    for (product in productList) {
                        println("${product.name}. Preis: ${product.price}. Autor: ${product.autor} Menge: ${product.quantity}. Kategorie: ${product.category}. Unterkategorie: ${product.subcategory}")
                    }
                } else {
                    println("Es sind keine produkte verfügbar")
                }

            }
            // Fügt ein Produkt zur Produktliste
            2 -> {
                println("Produkt hinzufügen")
                println("Bitte Name des Produkts eingeben")
                val name = readlnOrNull()
                println("Bitte Preis des Produkts eingeben")
                val price = readlnOrNull()?.toDoubleOrNull()
                println("Bitte Autor des Buches eingeben")
                val autor = readlnOrNull()
                println("Bitte Menge eingeben")
                val quantity = readlnOrNull()
                println("Bitte Kategorie eingeben")
                val category = readlnOrNull()
                println("Bitte Unterkategorie eingeben")
                val subcategory = readlnOrNull()
                if (name != null && price != null && autor != null && quantity != null && category != null && subcategory != null) {
                    val newProduct = Product(name, price, autor, quantity, category, subcategory)
                    accountManagement.addProduct(newProduct)
                    println("Sie haben $newProduct hinzugefügt")
                } else {
                    println("Falsche eingabe")
                }
            }
            // Entfernt ein Produkt aus der Produktliste
            3 -> {
                println("Produkt entfernen")
                println("Welches Produkt möchten Sie entfernen? Bitte Name eingeben")
                val name = readlnOrNull()
                if (name != null) {
                    val produktToRemove = accountManagement.getProductList().find { it.name == name }
                    if (produktToRemove != null) {
                        accountManagement.removeProduct(produktToRemove)
                        println("${produktToRemove.name}. Preis: ${produktToRemove.price} wurde entfernt")
                    } else {
                        println("Produkt nicht gefunden")
                    }
                } else {
                    println("Falsche eingabe")
                }
            }
            // Erstellt zufällige Produkte und fügt sie zur Produktliste
            4 -> {
                println("Zufällige Produkte erstellen")
                println("Bitte geben Sie die Anzahl der zu erstellenden Produkte ein:")
                val numProducts = readlnOrNull()?.toIntOrNull()
                if (numProducts != null && numProducts > 0) {
                    adminAccount.createRandomProducts(accountManagement, numProducts)
                    println("$numProducts zufällige Produkte wurden erstellt.")
                } else {
                    println("Falsche eingaben")
                }
            }
            // Wechselt zum Benutzerkonto und ruft userMenu auf
            5 -> {
                println("Zu Benutzerkonto wechseln")
                val userAccount = adminAccount.switchToUserAccount(accountManagement)
                userMenu(userAccount, accountManagement)
                return
            }
            // Beendet die Schleife und das Menü
            6 -> {
                println("Auf Wiedersehen")
                break
            }

            else -> {
                throw InvalidInputException("Falsche eingabe")
            }
        }

    }
}