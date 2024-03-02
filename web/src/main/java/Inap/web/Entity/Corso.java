package Inap.web.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCorso;

    String nomeCorso;

    @OneToMany(mappedBy = "TO-DO",cascade = CascadeType.ALL)
    List<Fattura> fattureCorso=new LinkedList<>();

    @OneToOne(mappedBy = "idInfoCorso",cascade = CascadeType.ALL)
    InfoCorso info;

    public Corso(String nomeCorso){
        this.nomeCorso=nomeCorso;
    }

    public Corso() {

    }
}
