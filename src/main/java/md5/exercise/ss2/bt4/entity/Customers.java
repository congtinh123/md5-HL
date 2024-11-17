package md5.exercise.ss2.bt4.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String fullName;
    private String email;
    private String address;
    private String phone;
    private LocalDate dob;
    private boolean status;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Projects> projects;
}
