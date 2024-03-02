package Inap.web.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.LinkedList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "corso")
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCorso",nullable = false)
    private Integer idCorso;

    @Basic
    @Column(name = "nomeCorso", nullable = false)
    private String nomeCorso;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "corso")
    private LinkedList<PagamentiCorsi> fattureCorsi;

    @OneToOne(mappedBy = "idInfoCorso",cascade = CascadeType.ALL)
    private InfoCorso info;

    public Corso(String nomeCorso){
        this.nomeCorso=nomeCorso;
    }

    public Corso() {

    }

}
