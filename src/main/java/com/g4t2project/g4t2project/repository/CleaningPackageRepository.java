package com.g4t2project.g4t2project.repository;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.g4t2project.g4t2project.entity.CleaningPackage;

public interface CleaningPackageRepository extends JpaRepository<CleaningPackage, Long> {
    // @Query("SELECT p FROM CleaningPackage p WHERE p.packageId = :packageId")
    // Optional<CleaningPackage> findByIdWithEagerFetching(@Param("packageId") Long packageId);
}
