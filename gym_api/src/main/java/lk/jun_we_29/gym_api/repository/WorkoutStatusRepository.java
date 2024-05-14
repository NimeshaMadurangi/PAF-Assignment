package lk.jun_we_29.gym_api.repository;

import lk.jun_we_29.gym_api.model.CurrentWorkoutStatus;
import lk.jun_we_29.gym_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutStatusRepository extends JpaRepository<CurrentWorkoutStatus,Long> {
    List<CurrentWorkoutStatus> findAllByUserId(Long id);


}
