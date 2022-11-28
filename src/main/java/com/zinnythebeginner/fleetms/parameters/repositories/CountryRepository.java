package com.zinnythebeginner.fleetms.parameters.repositories;

import com.zinnythebeginner.fleetms.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository <Country,Integer>{
}
