import React, {useState, useEffect} from 'react'
import { Link } from 'react-router-dom'
import eventService from '../services/eventservice'
import { useNavigate } from 'react-router-dom'
import '../styles/EventListingAdding.css'



const ListEvents = () => {
  const navigate=useNavigate();
  // Define a state variable to check if the user is an ADMIN

  const [isAdmin, setIsAdmin] = useState(false);
   // Retrieve the user role from the localStorage during component initialization
  useEffect(() => 
  {
    const storedRole = localStorage.getItem('role');
    setIsAdmin(storedRole === 'ADMIN');
  }, []);

// Define state variables to store events 
    const [events, setevents] = useState([])
    // Fetch all events from the backend API during component initialization
    useEffect(() => {

      getAllEvent();
  }, [])

  // Function to fetch all events from the backend API
  const getAllEvent = () => {
      eventService.getAllEvents().then((response) => {
          setevents(response.data)
          console.log(response.data);
      }).catch(error =>{
          console.log(error);
      })
  }
  // Function to delete an event by its ID
  const deleteEvent = (eventId) => {
    eventService.deleteEvent(eventId).then((response) =>{
     getAllEvent();

    }).catch(error =>{
        console.log(error);
    })
}
// Define state variables for searchquery
    const [searchQuery, setSearchQuery] = useState('');
  
    // Handle search input changes and update the searchQuery state
    const handleSearch = (event) => {
      setSearchQuery(event.target.value);
    }
    
    // Filter the events based on the search query
    const filteredEvents = events.filter(event => {
      const eventName = event.name.toLowerCase();
      const eventDate = event.startDate.toLowerCase();
      const eventLocation = event.location.toLowerCase();
      const query = searchQuery.toLowerCase();
      
      return eventName.includes(query) || eventDate.includes(query) || eventLocation.includes(query);
    });
 

    // Render the list of events in a card format with search functionality
return(

<> 
<div className="event-container">
    <div className="event-search-container">
  <input
    type="text"
    value={searchQuery}
    onChange={handleSearch}
    className="event-search-input"
    placeholder="Search by event, date, or location"
  />
</div>
<div className="event-card-container">
 {filteredEvents.map(event=>(
<div className="event-card" key={event.id}>
  
  <div className="event-card-text">
   
    <h2 className="event-card-title">{event.name}</h2>
<div className="box">
    <p className="event-card-body">DATE: {event.startDate}</p>
    <p className="event-card-body">LOCATION: {(event.location)} </p>
    </div>
  <hr/>
  
 
   
  { isAdmin &&<Link  to={`/edit-event/${event.id}`} ><button className="event-btn event-btn-default">Update</button></Link>}
  { isAdmin &&  <button className="event-btn event-btn-default" onClick = {() => deleteEvent(event.id)}> Delete</button>}
  { isAdmin &&  <button className="event-btn event-btn-default" 
           onClick = {() => {localStorage.setItem('sid',event.id); navigate('/salesreport');}}>
            Sales Report
            </button>
  }
  
  
  
   <div>
   <br/>

<button className="event-btn-default event-block" onClick={() => {
  localStorage.setItem('eventId', event.id);
  navigate('/viewevents');
}}>View</button>

            </div>
</div>
</div>
))
}
</div>

 
{ isAdmin &&<div className="add-event">
<Link className="event-btn event-btn-info" to ="/add-event">
<button  className="event-btn event-btn-default">Add Event</button>
 
</Link>
</div>
}
</div>


</>
)
}
export default ListEvents;