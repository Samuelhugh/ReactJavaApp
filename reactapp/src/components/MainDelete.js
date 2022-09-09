import React from 'react';
import axios from 'axios';

const MainDelete = (props) => {
  const { eventId, deletionHandler } = props;

  const deleteHandler = () => {
    axios
      .delete(`http://localhost:8080/api/events/delete/${eventId}`)
      .then((res) => {
        console.log(res);
        deletionHandler(eventId);
      })
      .catch((err) => console.log(err));
  };

  return <button onClick={deleteHandler}>Delete</button>;
};

export default MainDelete;
