package Inap.web.Repositories;

import Inap.web.Entity.PagamentiAnnuali;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentiAnnualiRepository extends JpaRepository<PagamentiAnnuali,Integer> {

}
