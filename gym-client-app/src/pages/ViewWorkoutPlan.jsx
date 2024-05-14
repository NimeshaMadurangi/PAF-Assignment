import React, { useState, useEffect } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import '../styles/ViewWorkoutPlan.css';
import EditWorkoutPlan from './EditWorkoutPlan';

const ViewWorkoutPlan = () => {
  const [workoutPlans, setWorkoutPlans] = useState([]);
  const [error, setError] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const [searchTerm, setSearchTerm] = useState('');
  const [editWorkoutPlan, setEditWorkoutPlan] = useState(null);

  useEffect(() => {
    fetchWorkoutPlans();
  }, []);

  const fetchWorkoutPlans = async () => {
    try {
      const response = await fetch(`http://localhost:8084/api/workoutPlan`);
      if (!response.ok) {
        throw new Error('Failed to fetch workout plans');
      }
      const data = await response.json();
      setWorkoutPlans(data);
      setIsLoading(false);
    } catch (error) {
      console.error('Error fetching workout plans:', error);
      setError(error.message);
      setIsLoading(false);
    }
  };

  const handleEdit = (workoutPlan) => {
    setEditWorkoutPlan(workoutPlan);
  };

  const handleSaveEdit = async (editedPlan) => {
    try {
      const response = await fetch(`http://localhost:8084/api/workoutPlan/${editedPlan.id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(editedPlan),
      });
      if (!response.ok) {
        throw new Error('Failed to save workout plan');
      }
      setWorkoutPlans(prevWorkoutPlans =>
        prevWorkoutPlans.map(plan => (plan.id === editedPlan.id ? editedPlan : plan))
      );
      setEditWorkoutPlan(null);
    } catch (error) {
      console.error('Error saving workout plan:', error);
      setError('Error saving workout plan. Please try again.');
    }
  };

  const handleCancelEdit = () => {
    setEditWorkoutPlan(null);
  };

  const handleDelete = async (id) => {
    try {
      const response = await fetch(`http://localhost:8084/api/workoutPlan/${id}`, {
        method: 'DELETE',
      });
      if (!response.ok) {
        throw new Error('Failed to delete workout plan');
      }
      setWorkoutPlans(prevWorkoutPlans =>
        prevWorkoutPlans.filter(plan => plan.id !== id)
      );
    } catch (error) {
      console.error('Error deleting workout plan:', error);
    }
  };
  

  if (isLoading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  const filteredWorkoutPlans = workoutPlans.filter(workoutPlan =>
    workoutPlan.goal.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="view-workout-plan-container">
        <div className="workout-plan-table">
          <h2>Manage Workout Plans</h2>
          <input
            type="text"
            placeholder="Search by Goal..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
            className="search-bar"
          />
          {editWorkoutPlan ? (
            <EditWorkoutPlan 
              workoutPlan={editWorkoutPlan} 
              onSave={handleSaveEdit} 
              onCancel={handleCancelEdit} 
            />
          ) : (
            <div className="table-container">
              <table>
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Goal</th>
                    <th>Description</th>
                    <th>Exercises</th>
                    <th>Sets</th>
                    <th>Repetitions</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  {filteredWorkoutPlans.map(workoutPlan => (
                    <tr key={workoutPlan.id}>
                      <td>{workoutPlan.id}</td>
                      <td>{workoutPlan.goal}</td>
                      <td>{workoutPlan.description}</td>
                      <td>{workoutPlan.exercises}</td>
                      <td>{workoutPlan.sets}</td>
                      <td>{workoutPlan.repetition}</td>
                      <td>
                        <FontAwesomeIcon 
                          icon={faEdit} 
                          onClick={() => handleEdit(workoutPlan)} 
                          style={{ cursor: 'pointer', marginRight: '10px' }} 
                        />
                        <FontAwesomeIcon 
                          icon={faTrash} 
                          onClick={() => handleDelete(workoutPlan.id)} 
                          style={{ cursor: 'pointer' }} 
                        />
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          )}
        </div>
      </div>
  );
};

export default ViewWorkoutPlan;
