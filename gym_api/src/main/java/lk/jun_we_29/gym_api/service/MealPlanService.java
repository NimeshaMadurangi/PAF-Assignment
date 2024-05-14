package lk.jun_we_29.gym_api.service;

import lk.jun_we_29.gym_api.controller.dto.request.MealPlanRequestDTO;
import lk.jun_we_29.gym_api.controller.dto.response.MealPlanCreateResponseDTO;
import lk.jun_we_29.gym_api.controller.dto.response.MealPlanDeleteResponseDTO;
import lk.jun_we_29.gym_api.controller.dto.response.MealPlanResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MealPlanService {

    MealPlanCreateResponseDTO addMealPlan(MealPlanRequestDTO mealPlanRequestDTO);

    List<MealPlanResponseDTO> getAllMealPlan();

    MealPlanDeleteResponseDTO deleteMealPlan(Long id);

    MealPlanCreateResponseDTO updateMealPlan(MealPlanRequestDTO mealPlanRequestDTO,Long id);
}
