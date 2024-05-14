package lk.jun_we_29.gym_api.service.impl;

import lk.jun_we_29.gym_api.controller.dto.request.UserRequestDTO;
import lk.jun_we_29.gym_api.controller.dto.request.WorkoutPlanRequestsDTO;
import lk.jun_we_29.gym_api.model.User;
import lk.jun_we_29.gym_api.model.WorkOutPlan;
import lk.jun_we_29.gym_api.repository.UserRepository;
import lk.jun_we_29.gym_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepo;

    public  User addUser(UserRequestDTO userRequestDTO) {
        User user = new User();

        user.setId(user.getId());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());

        userRepo.save(user);
        return null;
    }


//    public WorkOutPlan addPlan(WorkoutPlanRequestsDTO workoutPlanRequestsDTO) {
//        WorkOutPlan workOutPlan = new WorkOutPlan();
//
//        workOutPlan.setGoal(workoutPlanRequestsDTO.getGoal());
//        workOutPlan.setDescription(workoutPlanRequestsDTO.getDescription());
//        workOutPlan.setExercises(workoutPlanRequestsDTO.getExercises());
//        workOutPlan.setSets(workoutPlanRequestsDTO.getSets());
//        workOutPlan.setRepetition(workoutPlanRequestsDTO.getRepetition());
//        workOutPlan.setUser(workoutPlanRequestsDTO.getUser());
//
//        repo.save(workOutPlan);
//        return null;
//    }


}
