import React from 'react';
import './TicketPage.css';
import bookinglogo from './logos/success.png';
import { useLocation, useNavigate } from 'react-router-dom';

export default function TicketPage (props) {
  const navigate = useNavigate();
  const location = useLocation();
  console.log(location.state)

  const handlehome = () => {
    navigate('/')
  };

  return (
    <div className="ticket-confirmation">
      <div className="ticket">
        <h2>Booking Confirmation</h2>
        <img src={bookinglogo} alt="Booking Logo" style={{maxHeight: '200px', width: '100px', marginLeft: 'auto', marginRight: 'auto', display: 'block'}}/>
        <div className="ticket-info">
          <div className="ticket-field">
            <span className="ticket-label">Event:</span>
            <span className="ticket-value">Music Concert</span>
          </div>
          <div className="ticket-field">
            <span className="ticket-label">Date:</span>
            <span className="ticket-value">July 15, 2023</span>
          </div>
          <div className="ticket-field">
            <span className="ticket-label">Time:</span>
            <span className="ticket-value">8:00 PM</span>
          </div>
          <div className="ticket-field">
            <span className="ticket-label">Venue:</span>
            <span className="ticket-value">Concert Hall</span>
          </div>
          <div className="ticket-field">
            <span className="ticket-label">Admit:</span>
            <span className="ticket-value">{}</span>
          </div>
          <div className="ticket-field">
            <span className="ticket-label">Payee Name:</span>
            <span className="ticket-value">{location.state.cardName}</span>
          </div>
          <div className="ticket-field">
            <span className="ticket-label">Payment Mode:</span>
            <span className="ticket-value">{location.state.paymentmode}</span>
          </div>
        </div>
        <button onclick={handlehome} style={{display: 'block', marginRight: 'auto', marginLeft: 'auto', bottom: '0px'}}>
        Home
        </button>
      </div>
    </div>
  )
}

