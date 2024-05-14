import React, { useState } from 'react';
import '../styles/CommentSection.css';

const CommentSection = ({ onClose, workoutPlanId }) => {
    const [comment, setComment] = useState('');
    const [comments, setComments] = useState([]);

    const handleCommentChange = (event) => {
        setComment(event.target.value);
    };

    const handleAddComment = () => {
        if (comment.trim() !== '') {
            // Add the comment to the comments array
            setComments([...comments, comment]);
            // Clear the comment input field after adding the comment
            setComment('');
        }
    };

    return (
        <div className="comment-section">
            <h2>Comments</h2>
            <div>
                <textarea
                    value={comment}
                    onChange={handleCommentChange}
                    placeholder="Add your comment here..."
                ></textarea>
                <button onClick={handleAddComment}>Add Comment</button>
                <button onClick={onClose}>Close</button>
            </div>
            <div>
                {comments.length > 0 ? (
                    <ul>
                        {comments.map((comment, index) => (
                            <li key={index}>{comment}</li>
                        ))}
                    </ul>
                ) : (
                    <p>No comments yet.</p>
                )}
            </div>
        </div>
    );
}

export default CommentSection;
