package com.melgar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.melgar.entities.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
