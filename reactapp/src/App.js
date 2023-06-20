import React from 'react';
import PaymentPage from './components/Payment/PaymentPage';
import { Routes, Route } from 'react-router-dom';
import TicketPage from './components/Ticket/TicketPage';


function App () {
  return (
    <div>
      <Routes>
        <Route path='/home' element={<PaymentPage />} />
        <Route path='/ticket' element={<TicketPage />} />
      </Routes> 
    </div>
  )
}

export default App;
