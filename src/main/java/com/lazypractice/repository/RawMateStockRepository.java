package com.lazypractice.repository;

import com.lazypractice.beans.RawMateStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawMateStockRepository extends JpaRepository<RawMateStock,Long> {
    RawMateStock findRawMateById(Long id);
    RawMateStock findRawMateByItem(String itemName);
}
