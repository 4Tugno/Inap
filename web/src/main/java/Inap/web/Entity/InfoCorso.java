package Inap.web.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "infoCorso")
public class InfoCorso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idInfoCorso", nullable = false)
    private Integer idInfoCorso;

    //TO-DO Inserire Parametri

    @OneToOne(mappedBy = "idCorso",cascade = CascadeType.ALL)
    Corso corso;

    public InfoCorso(){

    }
}
