package com.indocyber.RestAPIPhoenix.repositories;

import com.indocyber.RestAPIPhoenix.models.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<Inventory,String> {

}
