package com.example.springapp.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PaymentDTO {


    private int paymentid;
    private String cardname;
    private String cardnumber;
    private String expirationDate;
    private int cvv;

    public PaymentDTO(int paymentid, String cardname, String cardnumber, String expirationDate, int cvv) {
        this.paymentid = paymentid;
        this.cardname = cardname;
        this.cardnumber = cardnumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public PaymentDTO() {
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
        return "PaymentSaveDTO{" +
                "paymentid=" + paymentid +
                ", cardname='" + cardname + '\'' +
                ", cardnumber='" + cardnumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvv='" + cvv +
                '}';
    }
}