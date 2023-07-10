fun adminMenu(adminAccount: AdminAccount) {
    adminAccount.createRandomProducts(25)

    while (true) {
        println("Eigentümer Menü")
        println("Bitte wählen Sie eine Option:")
        println(
            """
            [1] - Produkte anzeigen
            [2] - Produkt hinzufügen
            [3] - Produkt entfernen
            [4] - Zufällige Produkte erstellen
            [5] - Ausloggen
        """.trimIndent()
        )

        val adminWahl = readLine()?.toIntOrNull()

        when (adminWahl) {
            1 -> {
                println("Produkte anzeigen")
                val productList = adminAccount.getProductList()
                for (product in productList) {
                    println(product)
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
                    adminAccount.addProduct(newProduct)
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
                    val produktToRemove = adminAccount.getProductByName(name)
                    if (produktToRemove != null) {
                        val removedProduct = adminAccount.removeProduct(produktToRemove)
                        println("$removedProduct")
                    } else {
                        println("Falsche eingabe")
                    }
                } else {
                    println("Falsche eingabe")
                }
            }

            4 -> {
                println("Zufällige Produkte erstellen")
                println("Bitte geben Sie die Anzahl der zu erstellenden Produkte ein:")
                val numProducts = readLine()?.toIntOrNull()
                if (numProducts != null && numProducts > 0) {
                    adminAccount.createRandomProducts(numProducts)
                    println("$numProducts zufällige Produkte wurden erstellt.")
                } else {
                    println("Falsche eingaben")
                }
            }

            5 -> {
                println("Auf Wiedersehen")
                break
            }
        }

    }
}