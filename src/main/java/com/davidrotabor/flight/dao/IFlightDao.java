package com.davidrotabor.flight.dao;

import com.davidrotabor.flight.model.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlightDao extends CrudRepository<Flight, Long> {

    @Query("from Flight f where f.rating >= 4 AND f.cumplido=true")
    public List<Flight> viewBestFlight();

}
