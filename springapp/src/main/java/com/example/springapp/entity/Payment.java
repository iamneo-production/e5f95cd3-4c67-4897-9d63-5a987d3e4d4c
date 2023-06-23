package com.example.springapp.entity;

import javax.persistence.*;
@Entity
@Table(name = "payment_db")
public class Payment {
    @Id
    @Column(name = "payment_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentid;

    @Column(name = "card_name", length = 20)
    private String cardname;

    @Column(name = "card_number", length = 16)
    private String cardnumber;

    @Column(name = "expiry", length = 5)
    private String expirationDate;

    @Column(name = "cvv", length = 3)
    private int cvv;

    public Payment(int paymentid, String cardname, String cardnumber, String expirationDate, int cvv) {
        this.paymentid = paymentid;
        this.cardname = cardname;
        this.cardnumber = cardnumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public Payment() {
    }

    public Payment(String cardname, String cardnumber, String expirationDate, int cvv) {
        this.cardname = cardname;
        this.cardnumber = cardnumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvv() {
      return cvv;
    }

    public void setCvv(int cvv) {
      this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentid=" + paymentid +
                ", cardname='" + cardname + '\'' +
                ", cardnumber='" + cardnumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvv='" + cvv +
                '}';
    }
}