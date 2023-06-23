package com.example.springapp.DTO;

public class PaymentSaveDTO {


    private int paymentid;
    private String paymentmode;
    private String cardname;
    private String cardnumber;
    private String expirationdate;
    private int cvv;
    private String upi;

    public PaymentSaveDTO(int paymentid, String paymentmode, String cardname, String cardnumber, String expirationdate, int cvv, String upi) {
        this.paymentid = paymentid;
        this.paymentmode = paymentmode;
        this.cardname = cardname;
        this.cardnumber = cardnumber;
        this.expirationdate = expirationdate;
        this.cvv = cvv;
        this.upi = upi;
    }

    public PaymentSaveDTO() {
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
        return "PaymentSaveDTO{" +
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