import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate, useParams, useLocation } from 'react-router-dom';
import MainForm from './MainForm';

const UpdateEvent = () => {
  const { id } = useParams();
  const { state } = useLocation();
  const [updatedEvent, setUpdatedEvent] = useState({
    eventName: '',
    numberAttending: 0,
  });
  const navigate = useNavigate();

  useEffect(() => {
    if (!state) {
      axios
        .get(`http://localhost:8080/api/events/info/${id}`)
        .then((res) => {
          // console(`res NOT from state ${res}`);
          setUpdatedEvent(res.data);
        })
        .catch((err) => console.log(err));
    } else {
      // console.log('From state' + state);
      setUpdatedEvent(state);
    }
  }, [id]);

  const changeHandler = (e) => {
    setUpdatedEvent({ ...updatedEvent, [e.target.name]: e.target.value });
  };

  const submitHandler = (e) => {
    e.preventDefault();
    axios
      .put(`http://localhost:8080/api/events/edit/${id}`, updatedEvent)
      .then((res) => {
        // console.log('res' + res);
        navigate('/');
      })
      .catch((err) => console.log(err));
  };

  return (
    <div>
      <h1>Update Your Event!</h1>
      <MainForm
        onSubmitHandler={submitHandler}
        onChangeHandler={changeHandler}
        newOrUpdatedEvent={updatedEvent}
        buttonText="Edit"
      />
    </div>
  );
};

export default UpdateEvent;
