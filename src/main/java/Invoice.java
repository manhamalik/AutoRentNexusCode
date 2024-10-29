import java.util.Date;

public class Invoice {
    private int id;
    private double invoicedAmount;
    private double amountPaid;
    private Date paymentDate;
    private String paymentMethod;

    public Invoice(int id, double invoicedAmount, double amountPaid, Date paymentDate, String paymentMethod) {
        this.id = id;
        this.invoicedAmount = invoicedAmount;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public int getId() {
        return id;
    }

    public double getInvoicedAmount() {
        return invoicedAmount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public String toString() {
        return "Invoice ID: " + id +
                "\n----------------" +
                "\nInvoiced Amount: $" + invoicedAmount +
                "\nAmount Paid: $" + amountPaid +
                "\nPayment Date: " + paymentDate +
                "\nPayment Method: " + paymentMethod + "\n";
    }
}
