package Inap.web.Entity;

import jakarta.persistence.*;

@Entity
public class InfoCorso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idInfoCorso;

    //TO-DO Inserire Parametri

    @OneToOne(mappedBy = "idCorso",cascade = CascadeType.ALL)
    Corso corso;

    public InfoCorso(){

    }
}
