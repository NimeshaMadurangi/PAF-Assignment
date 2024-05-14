package lk.jun_we_29.gym_api.service.impl;

import lk.jun_we_29.gym_api.controller.dto.request.WorkoutPlanRequestsDTO;
import lk.jun_we_29.gym_api.controller.dto.response.WorkoutPlanResponseDTO;
import lk.jun_we_29.gym_api.model.WorkOutPlan;
import lk.jun_we_29.gym_api.repository.WorkOutPlanRepository;
import lk.jun_we_29.gym_api.service.WorkoutPlanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WorkoutPlanServiceImpl implements WorkoutPlanService {
    private WorkOutPlanRepository repo;

    @Override
    public WorkOutPlan addPlan(WorkoutPlanRequestsDTO workoutPlanRequestsDTO) {
        WorkOutPlan workOutPlan = new WorkOutPlan();

        workOutPlan.setGoal(workoutPlanRequestsDTO.getGoal());
        workOutPlan.setDescription(workoutPlanRequestsDTO.getDescription());
        workOutPlan.setExercises(workoutPlanRequestsDTO.getExercises());
        workOutPlan.setSets(workoutPlanRequestsDTO.getSets());
        workOutPlan.setRepetition(workoutPlanRequestsDTO.getRepetition());
        workOutPlan.setUser(workoutPlanRequestsDTO.getUser());

        repo.save(workOutPlan);
        return null;
    }

    @Override
    public WorkoutPlanResponseDTO viewWorkoutPlan(Long id) {

        Optional<WorkOutPlan> workOutPlanOptional = repo.findById(id);

        if (workOutPlanOptional.isPresent()) {
            WorkOutPlan workOutPlan = workOutPlanOptional.get();
            return new WorkoutPlanResponseDTO(
                    workOutPlan.getId(),
                    workOutPlan.getGoal(),
                    workOutPlan.getDescription(),
                    workOutPlan.getExercises(),
                    workOutPlan.getSets(),
                    workOutPlan.getRepetition(),
                    workOutPlan.getCreateDate(),
                    workOutPlan.getUpdateDate(),
                    workOutPlan.getUser());
        }
        return null;
    }

    @Override
    public void deleteWorkoutPlan(Long id) {
        repo.deleteById(id);
    }

    public WorkoutPlanRequestsDTO updateWorkoutPlan(WorkoutPlanRequestsDTO requestsDTO, Long id) {
        Optional<WorkOutPlan> workOutPlanOptional = repo.findById(id);

        if (workOutPlanOptional.isPresent()) {
            WorkOutPlan workOutPlan = workOutPlanOptional.get();

            workOutPlan.setGoal(requestsDTO.getGoal());
            workOutPlan.setDescription(requestsDTO.getDescription());
            workOutPlan.setExercises(requestsDTO.getExercises());
            workOutPlan.setRepetition(requestsDTO.getRepetition());
            workOutPlan.setUser(requestsDTO.getUser());

            repo.save(workOutPlan);
        }
        return requestsDTO;
    }

    @Override
    public List<WorkoutPlanResponseDTO> getWorkoutPlans() {

        List<WorkOutPlan> workOutPlans = repo.findAll();
        List<WorkoutPlanResponseDTO> workoutPlanResponseDTOList = new ArrayList<>();

        for(WorkOutPlan workOutPlan: workOutPlans) {
            WorkoutPlanResponseDTO workoutPlanResponseDTO = WorkoutPlanResponseDTO.builder()
                    .id(workOutPlan.getId())
                    .goal(workOutPlan.getGoal())
                    .description(workOutPlan.getDescription())
                    .exercises(workOutPlan.getExercises())
                    .sets(workOutPlan.getSets())
                    .repetition(workOutPlan.getRepetition())
                    .build();

            workoutPlanResponseDTOList.add(workoutPlanResponseDTO);
        }

        return workoutPlanResponseDTOList;
    }
}
