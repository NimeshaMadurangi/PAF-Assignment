package lk.jun_we_29.gym_api.repository;

import lk.jun_we_29.gym_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
