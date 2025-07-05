package com.eneds.first_spring_app.Repository;

import com.eneds.first_spring_app.model.FaturaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturaRepository extends JpaRepository<FaturaModel, Long>{
}
