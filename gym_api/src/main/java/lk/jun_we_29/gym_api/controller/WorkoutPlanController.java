package lk.jun_we_29.gym_api.controller;

import lk.jun_we_29.gym_api.controller.dto.request.WorkoutPlanRequestsDTO;
import lk.jun_we_29.gym_api.controller.dto.response.WorkoutPlanResponseDTO;
import lk.jun_we_29.gym_api.model.WorkOutPlan;
import lk.jun_we_29.gym_api.service.WorkoutPlanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/workoutPlan")
public class WorkoutPlanController {
    private WorkoutPlanService workoutPlanService;

    @PostMapping
    public WorkOutPlan addPlan(@RequestBody WorkoutPlanRequestsDTO workoutPlanRequestsDTO) {
        return workoutPlanService.addPlan(workoutPlanRequestsDTO);
    }

    @GetMapping
    public List<WorkoutPlanResponseDTO> getWorkoutPlan() {
        return workoutPlanService.getWorkoutPlans();
    }

    @GetMapping("/{id}")
    public WorkoutPlanResponseDTO viewPlan(@PathVariable Long id) {
        return workoutPlanService.viewWorkoutPlan(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkoutPlan(@PathVariable Long id) {
        workoutPlanService.deleteWorkoutPlan(id);
    }

    @PutMapping("/{id}")
    public WorkoutPlanRequestsDTO updateWorkoutPlan (@RequestBody WorkoutPlanRequestsDTO workoutPlanRequestsDTO,@PathVariable Long id) {
        return workoutPlanService.updateWorkoutPlan(workoutPlanRequestsDTO, id);
    }

}
