package Inap.web.Repositories;

import Inap.web.Entity.PagamentiCorsi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentiCorsiRepository extends JpaRepository<PagamentiCorsi,Integer> {

}
