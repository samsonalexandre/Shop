fun main() {
    var store = Store()
    createRandomProducts(store)

    var alleProdukte = store.getAllProducts()
    alleProdukte.forEach {produkt -> println("Name: ${produkt.name}, Preis: ${produkt.preis}, Kategorie: ${produkt.category}, Unterkategory: ${produkt.subcategory}")}

}