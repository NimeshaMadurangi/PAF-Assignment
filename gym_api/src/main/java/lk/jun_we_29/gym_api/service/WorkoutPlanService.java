package lk.jun_we_29.gym_api.service;

import lk.jun_we_29.gym_api.controller.dto.request.WorkoutPlanRequestsDTO;
import lk.jun_we_29.gym_api.controller.dto.response.WorkoutPlanResponseDTO;
import lk.jun_we_29.gym_api.model.WorkOutPlan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkoutPlanService {
    WorkOutPlan addPlan(WorkoutPlanRequestsDTO workoutPlanRequestsDTO);
    WorkoutPlanResponseDTO viewWorkoutPlan(Long id);
//    List<WorkoutPlanResponseDTO> allWorkoutPlan();
    void deleteWorkoutPlan(Long id);
    WorkoutPlanRequestsDTO updateWorkoutPlan(WorkoutPlanRequestsDTO workoutPlanRequestsDTO, Long id);

    List<WorkoutPlanResponseDTO> getWorkoutPlans();
}
