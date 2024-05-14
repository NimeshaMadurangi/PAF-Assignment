package lk.jun_we_29.gym_api.repository;

import lk.jun_we_29.gym_api.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
