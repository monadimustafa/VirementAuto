package com.example.vabpmn.Reositories;

import com.example.vabpmn.entities.VirementAuto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VARepository extends JpaRepository<VirementAuto,Long>
{
    List<VirementAuto> findByStatus(String status);
}
