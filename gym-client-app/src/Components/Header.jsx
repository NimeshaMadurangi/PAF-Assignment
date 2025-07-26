import React from 'react';
import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSearch, faUser, faBell, faEnvelope } from '@fortawesome/free-solid-svg-icons';
import '../styles/Header.css';

function Header() {
    return (
        <div className='header-container'>
            <nav className="navbar navbar-expand-lg navbar-light bg-custom">
                <div className="container">
                    <Link to="/" className="navbar-brand">
                        <img src="https://graphicsfamily.com/wp-content/uploads/edd/2021/02/Vector-Gym-Logo-PSD-Template-PNG-Transparent-600x600.png" alt="Logo" />
                    </Link>
                    <div className="input-group">
                        <input type="text" className="form-control" placeholder="Search Workout Plan"/>
                    </div>
                    <div className="navbar-collapse">
                        <ul className="navbar-nav ml-auto">
                            <li className="nav-item">
                                <Link to="/" className="nav-link">Home</Link>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Workout Status</a>
                            </li>
                            <li className="nav-item">
                                <Link to="/WorkoutPlanList" className="nav-link">Workout Plan</Link> {/* Link to WorkoutPlanList */}
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Meal Plan</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">
                                    <FontAwesomeIcon icon={faEnvelope} />
                                </a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">
                                    <FontAwesomeIcon icon={faBell} />
                                </a>
                            </li>
                            <li className="nav-item">
                                <Link to="/UserProfile" className="nav-link">
                                    <FontAwesomeIcon icon={faUser} />
                                </Link>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    );
}

export default Header;
