import React from "react";
import { Route } from 'react-router-dom';
import PaymentPage from "./components/PaymentPage";
import TicketPage from "./components/TicketPage";

 const Routes = () => (
    <Routes>
        <Route 
            exact path='/' component={PaymentPage}
        />
        <Route component={TicketPage}/>
    </Routes>
 );

 export default Routes;