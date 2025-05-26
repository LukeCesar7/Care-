package com.care.record.domain;
import com.care.record.domain.enums.StatusService;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private StatusService status;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;
}
