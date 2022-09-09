import React, { useEffect, useState } from 'react';
import { useParams, useNavigate, useLocation } from 'react-router-dom';
import axios from 'axios';
import MainDelete from './MainDelete';

const OneEvent = () => {
  const { id } = useParams();
  const { state } = useLocation();
  const [oneEvent, setOneEvent] = useState({
    eventName: '',
    numberAttending: 0,
  });
  const navigate = useNavigate();

  useEffect(() => {
    if (!state) {
      axios
        .get(`http://localhost:8080/api/events/info/${id}`)
        .then((res) => {
          setOneEvent(res.data);
        })
        .catch((err) => console.log(err));
    } else {
      setOneEvent(state);
    }
  }, [id]);

  const handleDelete = () => {
    navigate('/');
  };

  return (
    <div>
      <h1>Details</h1>
      <div>
        <p>Event Name: {oneEvent.eventName}</p>
        <p>Number Attending: {oneEvent.numberAttending}</p>
        <MainDelete eventId={oneEvent.id} deletionHandler={handleDelete} />
      </div>
    </div>
  );
};

export default OneEvent;
