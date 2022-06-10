package it.euris.gymsmanager.repository.country;

import it.euris.gymsmanager.entity.country.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
