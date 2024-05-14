package lk.jun_we_29.gym_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workoutPlan")
@Data
public class WorkOutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goal;

    private String description;

    private String exercises;

    private int sets;

    private String repetition;

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

//    @OneToMany(mappedBy = "workoutPlan", cascade = CascadeType.ALL)
//    private List<Comment> comments;

}
