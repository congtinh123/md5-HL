package md5.exercise.ss1.bt1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String name;
    private Double price;
    private int stock;
    private LocalDateTime createdAt;
    private boolean status = true;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
}
