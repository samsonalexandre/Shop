abstract class PaymentMethod {
    abstract fun makePayment(amount: Double): Boolean
}