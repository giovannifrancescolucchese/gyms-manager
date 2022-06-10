package it.euris.gymsmanager.repository.country;

import it.euris.gymsmanager.entity.country.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {

}
