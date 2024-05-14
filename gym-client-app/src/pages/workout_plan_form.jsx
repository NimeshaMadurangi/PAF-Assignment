import React, { useState } from 'react';
import axios from 'axios';
import '../styles/WorkoutPlanForm.css';

const WorkoutPlanForm = () => {

  const [goal, setGoal] = useState('');
  const [description, setDescription] = useState('');
  const [exercises, setExercises] = useState('');
  const [sets, setSets] = useState('');
  const [repetition, setRepetition] = useState('');
  const [error, setError] = useState(null);
  const [showForm, setShowForm] = useState(true);

  const handleSubmit = (event) => {
    event.preventDefault();
    
    const formData = {
      goal,
      description,
      exercises,
      sets,
      repetition
    };

    axios.post('http://localhost:8084/api/workoutPlan', formData)
      .then(response => {
        console.log('Exercise added successfully:', response.data);
        setGoal('');
        setDescription('');
        setExercises('');
        setSets('');
        setRepetition('');
        setError(null);
      })
      .catch(error => {
        console.error('Error adding exercise:', error);
        setError('Error adding exercise. Please try again.');
      });
  };

  const onCancel = () => {
    // Reset form fields and hide the form
    setGoal('');
    setDescription('');
    setExercises('');
    setSets('');
    setRepetition('');
    setError(null);
    setShowForm(false);
  };

  return (
    <div>
      {showForm && (
        <div className="workout-plan-form">
          <h2>Create Workout Plan</h2>
          {error && <div className="error-message">{error}</div>}
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label htmlFor="goal">Goal:</label>
              <input
                type="text"
                id="goal"
                value={goal}
                onChange={(e) => setGoal(e.target.value)}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="description">Description:</label>
              <input
                type="text"
                id="description"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="exercises">Exercise:</label>
              <input
                type="text"
                id="exercises"
                value={exercises}
                onChange={(e) => setExercises(e.target.value)}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="sets">Sets:</label>
              <input
                type="text"
                id="sets"
                value={sets}
                onChange={(e) => setSets(e.target.value)}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="repetition">Repetitions:</label>
              <input
                type="text"
                id="repetition"
                value={repetition}
                onChange={(e) => setRepetition(e.target.value)}
                required
              />
            </div>
            <button type="submit">Share</button>
            <button type="button" onClick={onCancel}>Cancel</button>
          </form>
        </div>
      )}
    </div>
  );
};

export default WorkoutPlanForm;
