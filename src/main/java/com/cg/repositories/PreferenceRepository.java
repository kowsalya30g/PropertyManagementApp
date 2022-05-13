package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Preference;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference,Long>{

}
