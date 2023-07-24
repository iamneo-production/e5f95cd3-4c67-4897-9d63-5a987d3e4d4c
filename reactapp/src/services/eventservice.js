import axios from 'axios';

const baseURL = 'https://8080-ceabacddbcbfcaaafaebabceaeaadbdbabf.project.examly.io/event';

class EventService {
  getAllEvents() {
    return axios.get(baseURL, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
  }

  createEvent(event) {
    return axios.post(baseURL, event, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
  }

  getEventById(eventId) {
    return axios.get(`${baseURL}/${eventId}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
  }

  updateEvent(event) {
    return axios.put(baseURL, event, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
  }

  deleteEvent(eventId) {
    return axios.delete(`${baseURL}/${eventId}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
  }
}

const eventService = new EventService();

export default eventService;
