package Inap.web.Entity;

import Inap.web.Supporto.Enumerazioni.Professione;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Utente {

    @Id
    private String email;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private Date dataRegistrazione;
    private Date dataDiNascita;
    private String luogoDiNascita;
    private String indirizzoCasa;
    private String Citta;
    private String Provincia;
    private String numeroDiTelefono;
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
        this.Citta = citta;
        this.Provincia = provincia;
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
