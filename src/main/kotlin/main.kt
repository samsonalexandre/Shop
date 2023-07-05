fun main() {
    var store = Store()
    createRandomProducts(store)

    var alleProdukte = store.getAllProducts()
    alleProdukte.forEach {produkt -> println("${produkt.name}, Preis: ${produkt.preis}. ${produkt.review}, Kategorie: ${produkt.category}, Unterkategory: ${produkt.subcategory}")}

}