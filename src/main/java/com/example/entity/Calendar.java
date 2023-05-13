package com.example.entity;

import com.example.enums.Day;
import com.example.enums.ExecutionFrequency;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendar_gen")
    @SequenceGenerator(name = "calendar_gen", sequenceName = "calendar_seq", allocationSize = 1, initialValue = 5)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToOne
    private User user;

    @OneToMany
    private List<Habit> habits;

    public void addHabit(Habit habit){
        if (habits == null){
            habits = new ArrayList<>();
        }
        habits.add(habit);
    }
}