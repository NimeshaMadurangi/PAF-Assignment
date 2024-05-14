package lk.jun_we_29.gym_api.service.impl;

import lk.jun_we_29.gym_api.controller.dto.request.MealPlanRequestDTO;
import lk.jun_we_29.gym_api.controller.dto.response.MealPlanCreateResponseDTO;
import lk.jun_we_29.gym_api.controller.dto.response.MealPlanDeleteResponseDTO;
import lk.jun_we_29.gym_api.controller.dto.response.MealPlanResponseDTO;
import lk.jun_we_29.gym_api.enums.DietType;
import lk.jun_we_29.gym_api.model.MealPlan;
import lk.jun_we_29.gym_api.repository.MealPlanRepository;
import lk.jun_we_29.gym_api.service.MealPlanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MealPlanServiceImpl implements MealPlanService {

    private final MealPlanRepository mealPlanRepository;

    @Override
    public MealPlanCreateResponseDTO addMealPlan(MealPlanRequestDTO mealPlanRequestDTO) {
        MealPlan mealPlan = new MealPlan();
        mealPlan.setMealName(mealPlanRequestDTO.getMealName());
        mealPlan.setIngredients(mealPlanRequestDTO.getIngredients());
        mealPlan.setInstructions(mealPlanRequestDTO.getInstructions());
        mealPlan.setDietType(DietType.valueOf(mealPlanRequestDTO.getDietType()));

        mealPlanRepository.save(mealPlan);

        return new MealPlanCreateResponseDTO("Meal Plan added successfully");
    }

    @Override
    public List<MealPlanResponseDTO> getAllMealPlan() {
        List<MealPlan> mealPlans = mealPlanRepository.findAll();
        List<MealPlanResponseDTO> mealPlanResponseDTOS = new ArrayList<>();

        for (MealPlan mealPlan : mealPlans) {
            MealPlanResponseDTO mealPlanResponseDTO = MealPlanResponseDTO.builder()
                    .mealName(mealPlan.getMealName())
                    .ingredients(mealPlan.getIngredients())
                    .instructions(mealPlan.getInstructions())
                    .dietType(mealPlan.getDietType().name())
                    .createDate(mealPlan.getCreateDate())
                    .build();
            mealPlanResponseDTOS.add(mealPlanResponseDTO);
        }
        return mealPlanResponseDTOS;
    }

    @Override
    public MealPlanDeleteResponseDTO deleteMealPlan(Long id) {
            mealPlanRepository.deleteById(id);

            return new MealPlanDeleteResponseDTO("Meal plan delete successfully");
    }

    @Override
    public MealPlanCreateResponseDTO updateMealPlan(MealPlanRequestDTO mealPlanRequestDTO, Long id) {
        Optional<MealPlan>mealPlanOptional = mealPlanRepository.findById(id);

        if (mealPlanOptional.isPresent()){
            MealPlan mealPlan = mealPlanOptional.get();
            mealPlan.setMealName(mealPlanRequestDTO.getMealName());
            mealPlan.setIngredients(mealPlanRequestDTO.getIngredients());
            mealPlan.setInstructions(mealPlanRequestDTO.getInstructions());
            mealPlanRepository.save(mealPlan);
        }
        return new MealPlanCreateResponseDTO("Meal Plan update successfully");
    }


}
