package monprojet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import monprojet.entity.Country;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring 
//

public interface CountryRepository extends JpaRepository<Country, Integer> {
       @Query(value =" Select sum(City.population) as population "
               +" FROM City "
               +" INNER JOIN Country on City.country_id =Country.id "
               +" WHERE country.ID = :countryID ",
               nativeQuery = true)
       public int calculPopulation(int countryID);
       @Query(value =" SElect Country.nom as nomPays, sum(City.population) as populationPays "
               +" from Country "
               +" INNER JOIN City on City.country_id = Country.id ",
              nativeQuery = true)
       public List<ContryPop> CountryPop();
}
