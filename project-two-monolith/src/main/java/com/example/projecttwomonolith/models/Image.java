package com.example.projecttwomonolith.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "IMAGES")

public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ORIGINAL_IMAGE")
    private String originalImage;

    @Column(name = "COLORIZED_IMAGE")
    private String colorizedImage;

    @Column(name = "NOTE")
    private String note;

    public Image(String originalImage, String colorizedImage, String note) {
        this.originalImage = originalImage;
        this.colorizedImage = colorizedImage;
        this.note = note;
    }

}





