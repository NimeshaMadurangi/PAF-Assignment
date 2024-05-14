import React, { useState } from 'react';
import '../styles/EditWorkoutPlan.css';

const EditWorkoutPlan = ({ workoutPlan, onSave, onCancel }) => {
  const [editedPlan, setEditedPlan] = useState(workoutPlan);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setEditedPlan({ ...editedPlan, [name]: value });
  };

  const handleSave = () => {
    onSave(editedPlan);
  };

  return (
    <div className="edit-workout-plan">
      <h2>Edit Workout Plan</h2>
      <div className="form-group">
        <label>Goal : </label>
        <input type="text" name="goal" value={editedPlan.goal} onChange={handleInputChange} />
      </div>
      <div className="form-group">
        <label>Description : </label>
        <input type="text" name="description" value={editedPlan.description} onChange={handleInputChange} />
      </div>
      <div className="form-group">
        <label>Exercise : </label>
        <input type="text" name="exercises" value={editedPlan.exercises} onChange={handleInputChange} />
      </div>
      <div className="form-group">
        <label>Sets : </label>
        <input type="text" name="sets" value={editedPlan.sets} onChange={handleInputChange} />
      </div>
      <div className="form-group">
        <label>Repetitions : </label>
        <input type="text" name="repetition" value={editedPlan.repetition} onChange={handleInputChange} />
      </div>
      <div className="button-group">
        <button className="save-button" onClick={handleSave}>Save</button>
        <button className="cancel-button" onClick={onCancel}>Cancel</button>
      </div>
    </div>
  );
};

export default EditWorkoutPlan;
