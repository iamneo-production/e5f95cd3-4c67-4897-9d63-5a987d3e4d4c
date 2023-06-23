package com.example.springapp.entity;

import javax.persistence.*;
@Entity
@Table(name = "payment_db")
public class Payment {
    @Id
    @Column(name = "payment_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentid;

    @Column(name = "payment_mode", length =20)
    private String paymentmode;

    @Column(name = "card_name", length = 20)
    private String cardname;

    @Column(name = "card_number", length = 16)
    private String cardnumber;

    @Column(name = "expiry", length = 5)
    private String expirationdate;

    @Column(name = "cvv", length = 3)
    private int cvv;

    @Column(name = "upi", length = 20)
    private String upi;

    public Payment(int paymentid, String paymentmode, String cardname, String cardnumber, String expirationdate, int cvv, String upi) {
        this.paymentid = paymentid;
        this.paymentmode = paymentmode;
        this.cardname = cardname;
        this.cardnumber = cardnumber;
        this.expirationdate = expirationdate;
        this.cvv = cvv;
        this.upi = upi;
    }

    public Payment() {
    }

    public Payment(String cardname, String paymentmode, String cardnumber, String expirationdate, int cvv, String upi) {
        this.paymentmode = paymentmode;
        this.cardname = cardname;
        this.cardnumber = cardnumber;
        this.expirationdate = expirationdate;
        this.cvv = cvv;
        this.upi = upi;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getPaymentMode() {
        return paymentmode;
    }

    public void setPaymentMode(String paymentmode) {
        this.paymentmode = paymentmode;
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
        return expirationdate;
    }

    public void setExpirationDate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public int getCVV() {
      return cvv;
    }

    public void setCVV(int cvv) {
      this.cvv = cvv;
    }

    public String getUPI() {
        return upi;
     }
   
     public void setUPI(String upi) {
        this.upi = upi;
     }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentid=" + paymentid +
                ", paymentmode='" + paymentmode + '\'' +
                ", cardname='" + cardname + '\'' +
                ", cardnumber='" + cardnumber + '\'' +
                ", expirationdate='" + expirationdate + '\'' +
                ", cvv='" + cvv + '\'' +
                ", upi='" + upi +
                '}';
    }
}