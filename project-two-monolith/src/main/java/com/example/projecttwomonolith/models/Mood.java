package com.example.projecttwomonolith.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "MOODS")
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_INPUT")
    private String userInput;

    @Column(name = "API_OUTPUT")
    private String apiOutput;

    @Column(name = "NOTE")
    private String note;


    public Mood(String userInput, String apiOutput, String note) {
        this.userInput = userInput;
        this.apiOutput = apiOutput;
        this.note = note;
    }

}
