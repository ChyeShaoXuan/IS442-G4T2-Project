package com.g4t2project.g4t2project.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.g4t2project.g4t2project.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Optional<Worker> findFirstByAvailableTrue();
    
     // Custom JPQL query to find an available worker for a specific date and shift
     @Query("SELECT w FROM Worker w WHERE w.available = true AND w.deployed = false AND NOT EXISTS (" +
     "SELECT t FROM CleaningTask t WHERE t.worker = w AND t.date = :date AND t.shift = :shift)")
    Optional<Worker> findAvailableWorker(@Param("date") LocalDate date, @Param("shift") CleaningTask.Shift shift);

    // Custom query to find all deployed workers
    @Query("SELECT w FROM Worker w WHERE w.curPropertyId > :value")
    List<Worker> findAllDeployed(@Param("value") int value);

    // Custom query to find all not deployed workers
    @Query("SELECT w FROM Worker w WHERE w.curPropertyId = :value")
    List<Worker> findAllNotDeployed(@Param("value") int value);
}
