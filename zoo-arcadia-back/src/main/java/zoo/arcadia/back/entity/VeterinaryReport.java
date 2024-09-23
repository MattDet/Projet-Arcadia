package zoo.arcadia.back.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "veterinary_report")
public class VeterinaryReport {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="report_date")
    private LocalDateTime reportDate;
    @Column(name="content")
    private String content;
    @ManyToOne
    @JoinColumn(name="animal_id")
    private Animal animal;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
