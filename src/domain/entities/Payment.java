package domain.entities;

import domain.enums.PaymentMethod;

import java.util.Date;

public class Payment {
    private Integer id;
    private Rent rent;
    private Double value;
    private String currency;
    private PaymentMethod paymentMethod;
    private String transactionId;
    private Date date;

    public Payment(Integer id, Rent rent, Double value, String currency, PaymentMethod paymentMethod, String transactionId, Date date) {
        this.id = id;
        this.rent = rent;
        this.value = value;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
