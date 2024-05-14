package lk.jun_we_29.gym_api.controller;

import lk.jun_we_29.gym_api.controller.dto.request.MealPlanRequestDTO;
import lk.jun_we_29.gym_api.controller.dto.response.MealPlanCreateResponseDTO;
import lk.jun_we_29.gym_api.controller.dto.response.MealPlanDeleteResponseDTO;
import lk.jun_we_29.gym_api.controller.dto.response.MealPlanResponseDTO;
import lk.jun_we_29.gym_api.service.MealPlanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mealplans")
@AllArgsConstructor
public class MealPlanController {

    private final MealPlanService mealPlanService;

    @PostMapping
    public void createMealPlan(@RequestBody MealPlanRequestDTO mealPlanRequestDTO){

        mealPlanService.addMealPlan(mealPlanRequestDTO);
    }

    @GetMapping
    public List<MealPlanResponseDTO> getMealPlan(){
        return mealPlanService.getAllMealPlan();
    }

    @DeleteMapping("/{id}")
    public MealPlanDeleteResponseDTO deleteMealPlan(@PathVariable Long id){
        return mealPlanService.deleteMealPlan(id);
    }

    @PutMapping("/{id}")
    public MealPlanCreateResponseDTO updateMealPlan( @RequestBody MealPlanRequestDTO mealPlanRequestDTO,@PathVariable Long id){
        return mealPlanService.updateMealPlan(mealPlanRequestDTO,id);
    }

}
