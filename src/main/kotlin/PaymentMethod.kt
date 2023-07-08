import java.util.*

enum class PaymentMethod {
    CREDIT_CARD {
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
                },
    PAYPAL {
        override fun makePayment(amount: Double): Boolean {
            val random = Random()
            val isPaymentSuccessful = random.nextBoolean()
            if (isPaymentSuccessful) {
                println("Sie haben mit PayPal $amount bezahlt.")
            } else {
                println("Fehler beim bezahlen mit PayPal.")
            }
            return isPaymentSuccessful
        }
    };
    abstract fun makePayment(amount: Double): Boolean
}