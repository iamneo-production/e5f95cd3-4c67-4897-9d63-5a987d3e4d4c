import React, { useEffect, useState } from 'react'
//import { useParams } from 'react-router-dom';
import '../styles/EventDetails.css'
import { useNavigate } from 'react-router-dom';

const EventDetails = () => 
{
  const navigate=useNavigate();
  // Define a state variable to store the event data fetched from the API
    const[data,setEventData]=useState([]);
    // Retrieve the token from the localStorage (assuming it was previously set during authentication)
    const token =localStorage.getItem('token');

    //const {id}=useParams();
     // Retrieve the event ID from the localStorage (it was previously set when viewing events event listing page)
    const id = Number(localStorage.getItem('eventId'));
    console.log(id);

    // useEffect hook to fetch the event details when the component mounts or when the event ID or token changes
    useEffect(() => {
        const fetchEventDetails = async () => {
          try
           {
            const response = await fetch(`https://8080-ceabacddbcbfcaaafaebabceaeaadbdbabf.project.examly.io/event/${id}`,{
              method: 'GET',
              headers:
               {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`,
              },
            });
            const jsonData = await response.json();
            setEventData(jsonData);
          } 
          catch (error)
           {
            console.log(error);
          }
        };
        fetchEventDetails();
      },[id,token]);


      return(
    <div>
    <div>
      <h1 > Event Details</h1>
      <center>

          <table>
            <thead></thead>
            <tbody>
            <tr>
              <th>  Event Name </th>
              <th> {data.name}</th>
            </tr>
            <tr>
              <th>  Event Description </th>
              <th> {data.description}</th>
            </tr>
            <tr>
              <th> Starts From</th>
              <th>{data.startDate}</th>
            </tr>
            <tr>
              <th>Ends At</th>
              <th>{data.endDate}</th>
            </tr>
            <tr>
              <th>Location</th>
              <th>{data.location}</th>
            </tr>
            <tr>
              <th>TotalTickets</th>
              <th>{data.totalTicket}</th>
            </tr>
  
            </tbody>
          </table>
         
          <button className='buttonregiback'   onClick={() => navigate('/registerpage')}>Register</button>
          <button className='buttonregiback'    onClick={() => navigate('/event')}>Back</button>
          
      </center>
      
    </div>
      
    </div>
  )
}

export default EventDetails


