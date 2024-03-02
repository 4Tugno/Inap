package Inap.web.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "pagamentiCorsi")
public class PagamentiCorsi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPagamentoCorso",nullable = false)
    private Integer idPagamentoCorso;

    @Basic
    @Column(name = "dataPagamentoCorso", nullable = false)
    private Date dataPagamentoCorso;

    @ManyToOne(optional = false)
    private Utente utente;

    public PagamentiCorsi(){

    }
}
