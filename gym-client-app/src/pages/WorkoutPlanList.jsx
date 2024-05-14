import React, { useState, useEffect } from "react";
import Header from "../Components/Header";
import WorkoutPlanForm from "./workout_plan_form";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHeart, faComment, faTrashAlt, faEdit } from '@fortawesome/free-solid-svg-icons';
import '../styles/workoutplanlist.css';

const WorkoutPlanList = ({ id }) => {
  // State to hold workout plans
  const [workoutPlans, setWorkoutPlans] = useState([]);
  // State to hold like counts
  const [likeCounts, setLikeCounts] = useState({});
  // State to hold comments for each workout plan
  const [comments, setComments] = useState({});
  // State to control visibility of the form
  const [showForm, setShowForm] = useState(false);
  // State to hold the value of the comment input
  const [commentValue, setCommentValue] = useState("");
  // State to hold the ID of the comment being edited
  const [editCommentId, setEditCommentId] = useState(null);
  
  // Effect to fetch workout plans from the backend on component mount
  useEffect(() => {
    // Fetch workout plans from the backend
    fetchWorkoutPlans();
  }, []);

  // Function to fetch workout plans from the backend
  const fetchWorkoutPlans = async () => {
    try {
      const response = await fetch("http://localhost:8084/api/workoutPlan");
      if (!response.ok) {
        throw new Error("Failed to fetch data");
      }
      const data = await response.json();
      setWorkoutPlans(data); // Update workout plans state with fetched data
      // Initialize like counts with 0 for each workout plan
      const initialLikeCounts = {};
      data.forEach(workoutPlan => {
        initialLikeCounts[workoutPlan.id] = 0;
      });
      setLikeCounts(initialLikeCounts);
      // Initialize comments with empty array for each workout plan
      const initialComments = {};
      data.forEach(workoutPlan => {
        initialComments[workoutPlan.id] = [];
      });
      setComments(initialComments);
    } catch (error) {
      console.error("Error fetching workout plans:", error);
    }
  };

  // Function to handle liking a workout plan
  const handleLike = (id) => {
    // Increase like count for the given workout plan ID
    setLikeCounts(prevCounts => ({
      ...prevCounts,
      [id]: prevCounts[id] + 1
    }));
  };

  // Function to handle commenting on a workout plan
  const handleComment = (id, commentValue) => {
    // Append the username along with the comment
    const commentWithUsername = `Nimesha: ${commentValue}`;
    // Update comments for the given workout plan ID
    setComments(prevComments => ({
      ...prevComments,
      [id]: [...prevComments[id], commentWithUsername]
    }));
    // Clear the comment input field
    setCommentValue("");
  };

  // Function to handle editing a comment
  const handleEditComment = (id, commentIndex, editedComment) => {
    const editedComments = [...comments[id]];
    editedComments[commentIndex] = `Nimesha: ${editedComment}`;
    setComments(prevComments => ({
      ...prevComments,
      [id]: editedComments
    }));
    setEditCommentId(null); // Reset edit mode
  };

  // Function to handle deleting a comment
  const handleDeleteComment = (id, commentIndex) => {
    const updatedComments = [...comments[id]];
    updatedComments.splice(commentIndex, 1);
    setComments(prevComments => ({
      ...prevComments,
      [id]: updatedComments
    }));
  };

  // Function to handle change in the comment input
  const handleCommentChange = (event) => {
    setCommentValue(event.target.value);
  };

  // Function to toggle visibility of the form
  const toggleForm = () => {
    setShowForm(!showForm);
  };

  return (
    <div>
      <Header/>
      <h1 style={{ textAlign: 'center' }}>Workout Plans</h1>
      {/* Button to toggle form visibility */}
      <button onClick={toggleForm} className="create-plan-button">Create New Plan</button>
      
      {/* Render form conditionally */}
      {showForm && <WorkoutPlanForm onClose={toggleForm} />}

      <div className="workout-plan-list">
        {workoutPlans.map((workoutPlan) => (
          <li key={workoutPlan.id} className="workout-plan-item">
            <div className="workout-plan-details">
              <p>Goal : {workoutPlan.goal}</p>
              <p>Description : {workoutPlan.description}</p>
              <p>Exercises : {workoutPlan.exercises}</p>
              <p>Sets : {workoutPlan.sets}</p>
              <p>Repetitions : {workoutPlan.repetition}</p>
            </div>
            {/* Like count */}
            <div className="workout-plan-actions">
              <p>
                <FontAwesomeIcon icon={faHeart} onClick={() => handleLike(workoutPlan.id)} className="like-comment-icons" />
                {likeCounts[workoutPlan.id]}
                <FontAwesomeIcon icon={faComment} className="like-comment-icons" />
                {comments[workoutPlan.id].length} {/* Display comment count */}
              </p>
              {/* Add space between like button and comment area */}
              <div>
                {/* Comment section */}
                <input 
                  type="text" 
                  placeholder="Add a comment..." 
                  value={commentValue} 
                  onChange={handleCommentChange} 
                />
                <button onClick={() => handleComment(workoutPlan.id, commentValue)} className="comment-button">Comment</button>
                {/* Display comments */}
                {comments[workoutPlan.id].map((comment, index) => (
                  <div key={index} className="comment-container">
                    {comment}
                    <div>
                      <FontAwesomeIcon icon={faEdit} onClick={() => setEditCommentId(index)} className="comment-action-icons" />
                      <FontAwesomeIcon icon={faTrashAlt} onClick={() => handleDeleteComment(workoutPlan.id, index)} className="comment-action-icons" />
                    </div>
                    {editCommentId === index && (
                      <div className="comment-edit">
                        <input type="text" value={commentValue} onChange={(e) => setCommentValue(e.target.value)} />
                        <button onClick={() => handleEditComment(workoutPlan.id, index, commentValue)}>Save</button>
                      </div>
                    )}
                  </div>
                ))}
              </div>
            </div>
          </li>
        ))}
      </div>
    </div>
  );
};

export default WorkoutPlanList;
