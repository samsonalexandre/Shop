import java.util.Random
class CreditCardPayment: PaymentMethod() {
    override fun makePayment(amount: Double): Boolean {
        val random = Random()
        val isPaymentSuccessful = random.nextBoolean()
        if (isPaymentSuccessful) {
            println("Sie haben mit Kreditkarte $amount bezahlt.")
        } else {
            println("Fehler beim bezahlen mit Kreditkarte.")
        }
        return isPaymentSuccessful
    }
}