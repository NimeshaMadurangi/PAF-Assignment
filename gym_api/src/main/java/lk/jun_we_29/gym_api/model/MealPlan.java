package lk.jun_we_29.gym_api.model;

import jakarta.persistence.*;
import lk.jun_we_29.gym_api.enums.DietType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "mealPlan")
@Data
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mealName;

    private String ingredients;

    private String instructions;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DietType dietType;

    @Column(nullable = false)
    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @ManyToOne
    private User user;

    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updateDate = LocalDateTime.now();
    }
}
