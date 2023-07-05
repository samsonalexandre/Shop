class BetreiberAccount(val userName: String, val pin: String) {
    fun addProdukt(store: Store, produkt: Produkt) {
        store.addProduct(produkt)
    }
    fun removeProdukt(store: Store, produkt: Produkt) {
        store.removeProduct(produkt)
    }
}