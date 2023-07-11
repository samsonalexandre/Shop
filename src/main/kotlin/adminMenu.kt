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
            1 -> {
                println("Produkte anzeigen")
                val productList = accountManagement.getProductList()
                for (product in productList) {
                    println("${product.name}. Preis: ${product.price}. Menge: ${product.quantity}. Kategorie: ${product.category}. Unterkategorie: ${product.subcategory}")
                }
            }

            2 -> {
                println("Produkt hinzufügen")
                println("Bitte Name des Produkts eingeben")
                val name = readlnOrNull()
                println("Bitte Preis des Produkts eingeben")
                val price = readLine()?.toDoubleOrNull()
                if (name != null && price != null) {
                    val newProduct = Product(name, price, "", "", "")
                    accountManagement.addProduct(newProduct)
                    println("Sie haben $newProduct hinzugefügt")
                } else {
                    println("Falsche eingabe")
                }
            }

            3 -> {
                println("Produkt entfernen")
                println("Welches Produkt möchten Sie entfernen? Bitte Name eingeben")
                val name = readlnOrNull()
                if (name != null) {
                    val produktToRemove = accountManagement.getProductList().find { it.name == name }
                    if (produktToRemove != null) {
                        accountManagement.removeProduct(produktToRemove)//adminAccount.removeProduct(produktToRemove)
                        println("$produktToRemove wurde entfernt")
                    } else {
                        println("Produkt nicht gefunden")
                    }
                } else {
                    println("Falsche eingabe")
                }
            }

            4 -> {
                println("Zufällige Produkte erstellen")
                println("Bitte geben Sie die Anzahl der zu erstellenden Produkte ein:")
                val numProducts = readlnOrNull()?.toIntOrNull()
                if (numProducts != null && numProducts > 0) {
                    adminAccount.createRandomProducts(accountManagement ,numProducts)
                    println("$numProducts zufällige Produkte wurden erstellt.")
                } else {
                    println("Falsche eingaben")
                }
            }

            5 -> {
                println("Zu Benutzerkonto wechseln")
                val userAccount = adminAccount.switchToUserAccount(accountManagement)
                userMenu(userAccount, accountManagement)
                return
            }

            6 -> {
                println("Auf Wiedersehen")
                break
            }
        }

    }
}