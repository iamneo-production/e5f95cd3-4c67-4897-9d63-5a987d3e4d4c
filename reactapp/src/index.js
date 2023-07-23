import React from 'react';
import ReactDOM from 'react-dom/client';
<<<<<<< HEAD
import "./index.css";
import App from './App';
import reportWebVitals from './reportWebVitals';
import {BrowserRouter} from 'react-router-dom';

=======
import './index.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
>>>>>>> 6d4aab3a96b9fbf4a2e9f9f9c7cfd9f6accb34e4

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
<<<<<<< HEAD
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </React.StrictMode>
);

=======
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
>>>>>>> 6d4aab3a96b9fbf4a2e9f9f9c7cfd9f6accb34e4
reportWebVitals();
