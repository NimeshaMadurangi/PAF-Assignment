import React from 'react';
import Header from '../Components/Header';
import '../styles/UserProfile.css';
import { Link } from 'react-router-dom';
import UserImage from '../Images/user.png'; // Import the image properly

function UserProfile() {
    return (
        <div>
            <Header />
            <div className="user-profile">
                <div className="profile-info">
                    <img src={UserImage} alt="User Avatar" className="avatar" /> {/* Use src attribute instead of URL */}
                    <h2>Nimesha</h2>
                    <p>Email: nimesha@gmail.com</p>
                    <p>Address: Colombo 08</p>
                    <p>Contact Number: 0784828918</p>
                    {/* Add more user profile information here */}
                    <Link to="/ViewWorkoutPlan">
                        <button className='manage-button'>Manage WorkoutPlans</button>
                        <button className='manage-button'>Manage Workout Status</button>
                        <button className='manage-button'>Manage Meal plans</button>
                    </Link>
                </div>
            </div>
        </div>
    );
}

export default UserProfile;
