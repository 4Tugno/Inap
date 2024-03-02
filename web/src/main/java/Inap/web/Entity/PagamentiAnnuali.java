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
@Table(name = "PagamentiAnnuali")
public class PagamentiAnnuali {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPagamentiAnnuale",nullable = false)
    private Integer idPagamentoAnnuale;

    @Basic
    @Column(name = "dataPagamentoAnnuale", nullable = false)
    private Date dataPagamentoAnnuale;

    @ManyToOne(optional = false)
    private Utente utente;

    public PagamentiAnnuali(){}

}
