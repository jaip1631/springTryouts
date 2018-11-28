package com.boot.repository;

import com.boot.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jaiprakash on 28/11/18
 */
public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {


}
