fun adminMenu(adminAccount: AdminAccount) {
    adminAccount.createRandomProducts(25)

    while (true) {
        println("Eigentümer Menü")
        println("Bitte wählen Sie eine Option:")
        println("""
            [1] - Produkte anzeigen
            [2] - Produkt hinzufügen
            [3] - Produkt entfernen
            [4] - Ausloggen
        """.trimIndent())

        val adminWahl = readLine()?.toIntOrNull()
        if (adminWahl != null) {
            when (adminWahl) {
                1 -> {
                    println("Produkte anzeigen")
                    val producte = adminAccount.getProductList()
                    for (product in producte) {
                        println("${product.name}, Preis: ${product.price}")
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
                        println("Sie haben ${newProduct.name}, mit dem Preis: ${newProduct.price} zugefügt")
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
                    println("Auf Wiedersehen")
                    break
                }
            }
        } else {
            println("Falsche eingabe")
        }
    }
}