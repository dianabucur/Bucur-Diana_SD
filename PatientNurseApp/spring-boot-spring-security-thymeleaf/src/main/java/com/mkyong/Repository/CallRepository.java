package com.mkyong.Repository;

import com.mkyong.Models.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepository extends JpaRepository<Call, Integer> {

}
