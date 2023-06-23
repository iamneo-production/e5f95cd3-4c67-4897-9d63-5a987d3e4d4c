import React, { useState } from 'react';
import './PaymentPage.css';
import paypallogo from './logos/paypal-logo.png';
import cdcardlogo from './logos/cdcard-logo.png';
import upilogo from './logos/upi-logo.png';
import cashlogo from './logos/cash-logo.png';
import { useNavigate } from 'react-router-dom';


function PaymentPage () {
  const [paymentmode, setPaymentMode] = useState('Credit/Debit Card');
  const [cardnumber, setCardnumber] = useState('');
  const [cardname, setCardname] = useState('');
  const [expirationdate, setExpirationDate] = useState('');
  const [cvv, setCVV] = useState('');
  const [upi, setUPI] = useState('');

  const navigate = useNavigate();

  const handleTicket = () => {
    navigate('/ticket', {state : {paymentmode:paymentmode, cardname:cardname}})
  };

  const handlePaymentModeChange = (event) => {
    setPaymentMode(event.target.value);
  };

  const handleCardnumberChange = (event) => {
    const input = event.target.value;
    let formattedInput = input;

    // Remove any non-digit characters
    formattedInput = formattedInput.replace(/\D/g, '');

    // Add spacing every 4 digits
    if (formattedInput.length > 0) {
      formattedInput = formattedInput.replace(/\d{4}(?=.)/g, '$& ');
    }

    setCardnumber(formattedInput);
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

  const handleCardnameChange = (event) => {
    setCardname(event.target.value);
  };

  const handleCVVChange = (event) => {
    setCVV(event.target.value);
  };

  const handleUPIChange = (event) => {
    setUPI(event.target.value);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    
    let paymentData = {
      paymentmode,
      cardnumber,
      cardname,
      expirationdate,
      cvv,
      upi,
    };

    fetch('/api/payments', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(paymentData)
    })
      .then(response => response.json())
      .then(data => {
        console.log('Payment data stored successfully:', data);
        // Reset the form after successful submission
      })
      .catch(error => {
        console.error('Error storing payment data:', error);
      });
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
            checked={paymentmode === 'Credit/Debit Card'}
            onChange={handlePaymentModeChange}
          />
          <b>Credit/Debit Card</b>
        </label>
        <label>
          <input
            type="radio"
            name="selectedOption"
            value="PayPal"
            checked={paymentmode === 'PayPal'}
            onChange={handlePaymentModeChange}
          />
          <b>PayPal</b>
        </label>
        <label>
          <input
            type="radio"
            name="selectedOption"
            value="UPI"
            checked={paymentmode === 'UPI'}
            onChange={handlePaymentModeChange}
          />
          <b>UPI</b>
        </label>
        <label>
          <input
            type="radio"
            name="paymentmode"
            value="Cash"
            checked={paymentmode === 'Cash'}
            onChange={handlePaymentModeChange}
          />
          <b>Cash</b>
        </label>
      </div>
      {paymentmode && (
        <form className="card-details-form" onSubmit={handleSubmit}>
          <div className="card-logo">
            {paymentmode === 'Credit/Debit Card' && (
              <img src={cdcardlogo} alt="Credit/Debit Card Logo" />
            )}
            {paymentmode=== 'PayPal' && (
              <img src={paypallogo} alt="PayPal Logo" />
            )}
            {paymentmode === 'UPI' && (
              <img src={upilogo} alt="UPI Logo" />
            )}
            {paymentmode === 'Cash' && (
              <img src={cashlogo} alt="Cash Logo" />
            )}
          </div>
          {paymentmode === 'Credit/Debit Card' && (
          <div className="card-details">
            <label>
              <b>Card Number:</b>
              <input
                type="text"
                placeholder='1234 XXXX XXXX 7890'
                value={cardnumber}
                onChange={handleCardnumberChange}
              />
            </label>
            <label>
              <b>Card Holder Name:</b>
              <input
                type="text"
                placeholder='Peter Parker'
                value={cardname}
                onChange={handleCardnameChange}
              />
            </label>
            <div className="expcvv-input-container">
            <div className="expirationdate-input-container">
            <label>
              <b>expirationdate:</b>
              <input
                type="text"
                placeholder='07/25'
                value={expirationdate}
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
          {paymentmode === 'PayPal' && (
          <div className="card-details">
            <label>
              <b>Paypal Email:</b>
              <input
                type="text"
                placeholder='Email Address'
                value={cardnumber}
                onChange={handleCardnumberChange}
              />
            </label>
            <label>
              <b>Password:</b>
              <input
                type="password"
                placeholder='Password'
                value={expirationdate}
                onChange={handleExpirationDateChange}
              />
            </label>
            </div>)}
            {paymentmode === 'UPI' && (
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
