import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import MainDelete from './MainDelete';

const AllEvents = () => {
  const [allEvents, setAllEvents] = useState([]);

  useEffect(() => {
    axios
      .get('http://localhost:8080/api/events')
      .then((res) => {
        console.log(res);
        setAllEvents(res.data);
      })
      .catch((err) => console.log(err));
  }, []);

  const deleteHandler = (eventId) => {
    setAllEvents(allEvents.filter((singleEvent) => singleEvent.id !== eventId));
  };

  return (
    <div>
      <h1>All Events</h1>
      <Link to="/create">Create an Event</Link>
      {allEvents.map((oneEvent) => {
        return (
          <div key={oneEvent.id}>
            <p>Event Name: {oneEvent.eventName}</p>
            <p>Number Attending: {oneEvent.numberAttending}</p>
            <Link to={`/edit/${oneEvent.id}`} state={oneEvent}>
              Update
            </Link>
            <Link to={`/info/${oneEvent.id}`} state={oneEvent}>
              Details
            </Link>
            <MainDelete eventId={oneEvent.id} deletionHandler={deleteHandler} />
          </div>
        );
      })}
    </div>
  );
};

export default AllEvents;
