package Inap.web.Entity;

import Inap.web.Supporto.Enumerazioni.Professione;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.LinkedList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "utente")
public class Utente {

    @Id
    @GeneratedValue
    @Column(name = "idutente",nullable = false)
    private Integer idUtente;

    @Basic
    @Column(name = "email",nullable = false)
    private String email;

    @Basic
    @Column(name = "nome",nullable = false)
    private String nome;

    @Basic
    @Column(name = "cognome",nullable = false)
    private String cognome;

    @Basic
    @Column(name = "codicefiscale",nullable = false)
    private String codiceFiscale;

    @Basic
    @Column(name = "dataregistrazione",nullable = false)
    private Date dataRegistrazione;

    @Basic
    @Column(name = "datanascita",nullable = false)
    private Date dataDiNascita;

    @Basic
    @Column(name = "luogonascita",nullable = false)
    private String luogoDiNascita;

    @Basic
    @Column(name = "indirizzocasa",nullable = false)
    private String indirizzoCasa;

    @Basic
    @Column(name = "citta",nullable = false)
    private String citta;

    @Basic
    @Column(name = "provincia",nullable = false)
    private String provincia;

    @Basic
    @Column(name = "numerotelefonico",nullable = false)
    private String numeroDiTelefono;

    @Basic
    @Column(name = "mailing",nullable = false)
    private boolean mailing; //parametro per decidere se voler ricevere o meno le email

    @ElementCollection
    private LinkedList<Integer> anniDiIscrizione;

    //Questo serve per poter esprimere le preferenze (Non si salva direttamente il corso per evitare le correlazioni)
    @ElementCollection
    private LinkedList<Integer> preferenzeCorsi;

    //La presenza di una duplice notazione è necessaria per poter permettere di inserire altro in maniera libera e non vincolata
    //In questo modo è possibile selezionare una professione e nel caso salvarlo come stringa oppure indentificare le altre e
    //salvare quelle.
    private Professione professioneID;
    private String professione;
    //Questa stringa è a libera scrittura dell'utente che si inserisce all'interno del database il quale è libero
    //di poter inserire le proprie competenze
    private String competenze;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "utente")
    private LinkedList<PagamentiAnnuali> pagamentiAnnuali;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "utente")
    private LinkedList<PagamentiCorsi> pagamentiCorsi;

    public Utente(String email, String nome, String cognome, String codiceFiscale, Date dataRegistrazione, Date dataDiNascita, String luogoDiNascita, String indirizzoCasa, String citta, String provincia, String numeroDiTelefono, LinkedList<Integer> anniDiIscrizione, Professione professioneID, String competenze) {
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.dataRegistrazione = dataRegistrazione;
        this.dataDiNascita = dataDiNascita;
        this.luogoDiNascita = luogoDiNascita;
        this.indirizzoCasa = indirizzoCasa;
        this.citta = citta;
        this.provincia = provincia;
        this.numeroDiTelefono = numeroDiTelefono;
        this.anniDiIscrizione = anniDiIscrizione;
        this.professioneID = professioneID;
        this.professione=professioneID.toString();
        this.competenze = competenze;
        this.mailing=true; //Può essere modificato in seguito
        this.pagamentiAnnuali = new LinkedList<>();
        this.pagamentiCorsi = new LinkedList<>();
    }

    public Utente() {

    }

}
