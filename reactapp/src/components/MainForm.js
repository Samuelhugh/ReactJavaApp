import React from 'react';

const MainForm = (props) => {
  // Try error handling
  const { onSubmitHandler, onChangeHandler, newOrUpdatedEvent, buttonText } =
    props;

  return (
    <div>
      <form onSubmit={onSubmitHandler}>
        <div>
          <label htmlFor="eventName">Event Name:</label>
          <input
            type="text"
            name="eventName"
            value={newOrUpdatedEvent.eventName}
            onChange={onChangeHandler}
          />
        </div>

        <div>
          <label htmlFor="numberAttending">Number Attending?</label>
          <input
            type="number"
            name="numberAttending"
            value={newOrUpdatedEvent.numberAttending}
            onChange={onChangeHandler}
          />
        </div>

        <button>{buttonText}</button>
      </form>
    </div>
  );
};

export default MainForm;
