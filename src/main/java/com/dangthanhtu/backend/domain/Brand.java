package com.dangthanhtu.backend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "brands")
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;
    private String image; 
    private String brandName; 
}
