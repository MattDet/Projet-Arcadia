package zoo.arcadia.back.entity;

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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "health_status")
    private String healthStatus;
    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;
    @ManyToOne
    @JoinColumn(name = "habitat_id")
    private Habitat habitat;

    // @OneToMany(mappedBy = "animal")
    // private List<VeterinaryReport> veterinaryReports;
}
