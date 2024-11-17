package md5.exercise.ss2.bt4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    private String name;
    private String description;
    private String technology;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;
}
