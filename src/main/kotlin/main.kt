fun main() {
    var store = Store()
    createRandomProducts(store, 45)

    var alleProdukte = store.getAllProducts()
    alleProdukte.forEach {produkt -> println("${produkt.name}, Preis: ${produkt.preis}. ${produkt.bewertung}, Kategorie: ${produkt.category}, Unterkategory: ${produkt.subcategory}")}

    var produktKat = store.getProductsByCategory("Kleidung")
    produktKat.forEach {produkt ->  println("${produkt.name}")}
}