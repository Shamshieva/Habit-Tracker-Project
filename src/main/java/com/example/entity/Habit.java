package com.example.entity;

import com.example.enums.ExecutionFrequency;
import jakarta.persistence.*;
import lombok.*;


import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.REFRESH;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habit_gen")
    @SequenceGenerator(name = "habit_gen", sequenceName = "habit_seq", allocationSize = 1, initialValue = 5)
    private Long id;
    private String name;
    private String description;
    private Integer goal;
    @Enumerated(EnumType.STRING)
    private ExecutionFrequency frequency;
    private Boolean isDone;
    @ManyToOne
    private Calendar calendar;
    @OneToOne(cascade = CascadeType.ALL)
    private Measurement measurement;
}
