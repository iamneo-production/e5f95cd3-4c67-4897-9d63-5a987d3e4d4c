import React, { useState } from 'react';
import './PaymentPage.css';
import paypallogo from './logos/paypal-logo.png';
import cdcardlogo from './logos/cdcard-logo.png';
import upilogo from './logos/upi-logo.png';
import cashlogo from './logos/cash-logo.png';
import { useNavigate } from 'react-router-dom';


function PaymentPage () {
  const [paymentMode, setPaymentMode] = useState('Credit/Debit Card');
  const [cardNumber, setCardNumber] = useState('');
  const [cardName, setCardName] = useState('');
  const [expirationDate, setExpirationDate] = useState('');
  const [cvv, setCVV] = useState('');
  const [upi, setUPI] = useState('');
  //const[payments, setPayments] = useState([]);

  const navigate = useNavigate();

  const handleTicket = () => {
    
  };

  const handlePaymentModeChange = (event) => {
    setPaymentMode(event.target.value);
  };

  const handleCardNumberChange = (event) => {
    const input = event.target.value;
    let formattedInput = input;

    // Remove any non-digit characters
    formattedInput = formattedInput.replace(/\D/g, '');

    // Add spacing every 4 digits
    if (formattedInput.length > 0) {
      formattedInput = formattedInput.replace(/\d{4}(?=.)/g, '$& ');
    }

    setCardNumber(formattedInput);
  };

  const handleExpirationDateChange = (event) => {
    const input = event.target.value;
    let formattedInput = input;

    // Remove any non-digit characters
    formattedInput = formattedInput.replace(/\D/g, '');

    // Add a slash after the second character
    if (formattedInput.length > 2) {
      formattedInput = formattedInput.slice(0, 2) + '/' + formattedInput.slice(2);
    }

    setExpirationDate(formattedInput);
  };

  const handleCardNameChange = (event) => {
    setCardName(event.target.value);
  };

  const handleCVVChange = (event) => {
    setCVV(event.target.value);
  };

  const handleUPIChange = (event) => {
    setUPI(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    
    const payment = {
      paymentMode,
      cardNumber,
      cardName,
      expirationDate,
      cvv,
      upi,
    };

    console.log(payment)
    fetch("http://localhost:8080/api/payment/save",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(payment)

    }).then(()=>{
    console.log("Payment Successful...")
    navigate('/ticket',handleTicket)
    })
  };

  return (
    <div className="paymentbgimg">
    <div className="payment-page">
      <h1>Payment Page</h1>
      <h2 id="gd">Grand Total: {} </h2>
      <div className="payment-options">
        <h2>Select Payment Option:</h2>
        <label>
          <input
            type="radio"
            name="selectedOption"
            value="Credit/Debit Card"
            checked={paymentMode === 'Credit/Debit Card'}
            onChange={handlePaymentModeChange}
          />
          <b>Credit/Debit Card</b>
        </label>
        <label>
          <input
            type="radio"
            name="selectedOption"
            value="PayPal"
            checked={paymentMode === 'PayPal'}
            onChange={handlePaymentModeChange}
          />
          <b>PayPal</b>
        </label>
        <label>
          <input
            type="radio"
            name="selectedOption"
            value="UPI"
            checked={paymentMode === 'UPI'}
            onChange={handlePaymentModeChange}
          />
          <b>UPI</b>
        </label>
        <label>
          <input
            type="radio"
            name="paymentMode"
            value="Cash"
            checked={paymentMode === 'Cash'}
            onChange={handlePaymentModeChange}
          />
          <b>Cash</b>
        </label>
      </div>
      {paymentMode && (
        <form className="card-details-form" onSubmit={handleSubmit}>
          <div className="card-logo">
            {paymentMode === 'Credit/Debit Card' && (
              <img src={cdcardlogo} alt="Credit/Debit Card Logo" />
            )}
            {paymentMode=== 'PayPal' && (
              <img src={paypallogo} alt="PayPal Logo" />
            )}
            {paymentMode === 'UPI' && (
              <img src={upilogo} alt="UPI Logo" />
            )}
            {paymentMode === 'Cash' && (
              <img src={cashlogo} alt="Cash Logo" />
            )}
          </div>
          {paymentMode === 'Credit/Debit Card' && (
          <div className="card-details">
            <label>
              <b>Card Number:</b>
              <input
                type="text"
                placeholder='1234 XXXX XXXX 7890'
                value={cardNumber}
                onChange={handleCardNumberChange}
              />
            </label>
            <label>
              <b>Card Holder Name:</b>
              <input
                type="text"
                placeholder='Peter Parker'
                value={cardName}
                onChange={handleCardNameChange}
              />
            </label>
            <div className="expcvv-input-container">
            <div className="expiry-input-container">
            <label>
              <b>Expiry:</b>
              <input
                type="text"
                placeholder='07/25'
                value={expirationDate}
                onChange={handleExpirationDateChange}
                style={{ width: '40px', fontSize: '14px' }}
              />
            </label>
            </div>
            <div className="cvv-input-container">
            <label>
              <b>CVV:</b>
              <input
                type="numbers"
                placeholder='007'
                value={cvv}
                onChange={handleCVVChange}
                style={{ width: '40px', fontSize: '14px' }}
                maxLength="4"
              />
            </label>
            </div>
          </div>
          </div>)}
          {paymentMode === 'PayPal' && (
          <div className="card-details">
            <label>
              <b>Paypal Email:</b>
              <input
                type="text"
                placeholder='Email Address'
                value={cardNumber}
                onChange={handleCardNumberChange}
              />
            </label>
            <label>
              <b>Password:</b>
              <input
                type="password"
                placeholder='Password'
                value={expirationDate}
                onChange={handleExpirationDateChange}
              />
            </label>
            </div>)}
            {paymentMode === 'UPI' && (
          <div className="card-details">
            <label>
              <b>UPI Id:</b>
              <input
                type="text"
                placeholder='123456789@ybl'
                value={upi}
                onChange={handleUPIChange}
              />
            </label>
          </div>)}
          <button type="submit" onClick={handleTicket}>Pay</button>
        </form>
      )}
    </div>
    </div>
  )
}

export default PaymentPage;
