package com.mkyong.Repository;

import com.mkyong.Models.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
}
