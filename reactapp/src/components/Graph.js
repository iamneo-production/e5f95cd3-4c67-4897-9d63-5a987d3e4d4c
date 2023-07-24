import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Bar } from 'react-chartjs-2';
import { Chart } from 'chart.js/auto';
Chart.register()

const Graph = () => {
  const [events, setEvents] = useState([]);
  const token =localStorage.getItem('token');

  useEffect(() => {
    axios
      .get('https://8080-ceabacddbcbfcaaafaebabceaeaadbdbabf.project.examly.io/event',{
        method: 'GET',
        headers:
         {
          'Content-Type': 'application/json',
          Authorization: `Bearer ${token}`,
        },
      })
      .then((response) => {
        setEvents(response.data);
      })
      .catch((error) => {
        console.error('Error fetching event adata:', error);
      });
  }, [token]);

  const eventData = events.map((event) => ({
    eventName: event.name,
    attendeesCount: event.attendees.length,
  }));

  const eventNames = eventData.map((data2) => data2.eventName);
  const attendeesCount = eventData.map((data1) => data1.attendeesCount);

  const data = {
    labels: eventNames,
    datasets: [
      {
        label: 'Attendees Count ',
        data: attendeesCount,
        backgroundColor: 	'rgb(145, 95, 109)',
        hoverBackgroundColor:'rgb(119, 7, 55)',
        barPercentage:0.3,
        barThickness:90,
      },
    ],
  };

  const options = {
   plugins:
   {
     legend:{
        position:'top',
     },
     title:
     {
        display:true,
        title:'Events and Attendees Data'
     },
   }
    

  };

  return (
    <div style={{"height":400,"width":800,margin:"auto"}}>
      <h2>Event Attendees Graph</h2>
      <Bar data={data} options={options} />
    </div>
  );
};

export default Graph;