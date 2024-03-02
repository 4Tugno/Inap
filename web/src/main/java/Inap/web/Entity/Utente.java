package Inap.web.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Collection;

@Entity
public class Utente {
    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "utente")
    private Collection<PagamentiAnnuali> pagamentiAnnuali;

    public Collection<PagamentiAnnuali> getPagamentiAnnuali() {
        return pagamentiAnnuali;
    }

    public void setPagamentiAnnuali(Collection<PagamentiAnnuali> pagamentiAnnuali) {
        this.pagamentiAnnuali = pagamentiAnnuali;
    }

    @OneToMany(mappedBy = "utente")
    private Collection<PagamentiCorsi> pagamentiCorsi;

    public Collection<PagamentiCorsi> getPagamentiCorsi() {
        return pagamentiCorsi;
    }

    public void setPagamentiCorsi(Collection<PagamentiCorsi> pagamentiCorsi) {
        this.pagamentiCorsi = pagamentiCorsi;
    }
}
