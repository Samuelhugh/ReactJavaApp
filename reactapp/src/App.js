import { Routes, Route } from 'react-router-dom';
import CreateEvent from './components/CreateEvent';
import AllEvents from './components/AllEvents';
import OneEvent from './components/OneEvent';
import UpdateEvent from './components/UpdateEvent';
import './App.css';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/create" element={<CreateEvent />} />
        <Route path="/" element={<AllEvents />} />
        <Route path="/info/:id" element={<OneEvent />} />
        <Route path="/edit/:id" element={<UpdateEvent />} />
      </Routes>
    </div>
  );
}

export default App;
