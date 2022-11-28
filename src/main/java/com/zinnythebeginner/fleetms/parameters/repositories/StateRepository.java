package com.zinnythebeginner.fleetms.parameters.repositories;

import com.zinnythebeginner.fleetms.parameters.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State,Integer> {
}
