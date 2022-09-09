import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import MainForm from './MainForm';

const CreateEvent = () => {
  const [newEvent, setNewEvent] = useState({
    eventName: '',
    numberAttending: 0,
  });
  const navigate = useNavigate();

  const changeHandler = (e) => {
    setNewEvent({ ...newEvent, [e.target.name]: e.target.value });
  };

  const submitHandler = (e) => {
    e.preventDefault();
    // console.log('New event here ' + newEvent);
    axios
      .post('http://localhost:8080/api/events/create', newEvent)
      .then((res) => {
        // console.log('res' + res);
        navigate('/');
      })
      .catch((err) => console.log(err));
  };

  return (
    <div>
      <h1>Create an Event!</h1>
      <MainForm
        onSubmitHandler={submitHandler}
        onChangeHandler={changeHandler}
        newOrUpdatedEvent={newEvent}
        buttonText="Add Event"
      />
    </div>
  );
};

export default CreateEvent;
