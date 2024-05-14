import React, { useState, useEffect } from "react";
import axios from "axios";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrashAlt, faShare } from '@fortawesome/free-solid-svg-icons';

const WorkoutPlan = () => {
  const [workoutPlans, setWorkoutPlans] = useState([]);

  useEffect(() => {
    fetchWorkoutPlans();
  }, []);

  const fetchWorkoutPlans = async () => {
    try {
      const response = await axios.get('http://localhost:8084/api/workoutPlan');
      const data = response.data;
      console.log("Fetched workout plans:", data);
      setWorkoutPlans(data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const handleEdit = (id) => {
    console.log('Edit exercise with ID:', id);
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8084/api/workoutPlan/${id}`);
      setWorkoutPlans(prevData => prevData.filter(workoutPlan => workoutPlan.id !== id));
    } catch (error) {
      console.error('Error deleting exercise:', error);
    }
  };

  const handleShare = (id) => {
    console.log('Share exercise with ID:', id);
  };

  return (
    <div className="workout-plan">
      <h2>Manage Workout Plan</h2>
      <button onClick={() => {}}>Create New Plan</button>
      <table>
        <thead>
          <tr>
            <th>Goal</th>
            <th>Description</th>
            <th>Exercises</th>
            <th>Sets</th>
            <th>Repetitions</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {workoutPlans.map((workoutPlan) => (
            <tr key={workoutPlan.id}>
              <td>{workoutPlan.goal}</td>
              <td>{workoutPlan.description}</td>
              <td>{workoutPlan.exercises}</td>
              <td>{workoutPlan.sets}</td>
              <td>{workoutPlan.repetition}</td>
              <td>
                <button onClick={() => handleEdit(workoutPlan.id)}>
                  <FontAwesomeIcon icon={faEdit} />
                </button>
                <button onClick={() => handleDelete(workoutPlan.id)}>
                  <FontAwesomeIcon icon={faTrashAlt} />
                </button>
                <button onClick={() => handleShare(workoutPlan.id)}>
                  <FontAwesomeIcon icon={faShare} />
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default WorkoutPlan;
