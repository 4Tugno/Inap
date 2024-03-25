package Inap.web.Repositories;

import Inap.web.Entity.InfoCorso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InforCorsoRepository extends JpaRepository<InfoCorso,Integer> {

}
