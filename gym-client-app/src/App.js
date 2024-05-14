import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Splash from './pages/Splash';
import Home from './pages/Home';
import LoginForm from './pages/Login';
import Register from './pages/Register';
import WorkoutPlanList from './pages/WorkoutPlanList';
import UserProfile from './pages/UserProfile';
import ViewWorkoutPlan from './pages/ViewWorkoutPlan';

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Splash />} />
        <Route path="/Home" element={<Home />} />
        <Route path="/LoginForm" element={<LoginForm />} />
        <Route path="/Register" element={<Register />} />
        <Route path="/WorkoutPlanList" element={<WorkoutPlanList />} />
        <Route path="/UserProfile" element={<UserProfile />} />
        <Route path="/ViewWorkoutPlan" element={<ViewWorkoutPlan />} />

      </Routes>
    </BrowserRouter>
  );
};

export default App;
