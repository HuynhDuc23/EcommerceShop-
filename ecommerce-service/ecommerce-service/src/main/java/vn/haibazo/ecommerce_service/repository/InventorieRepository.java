package vn.haibazo.ecommerce_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.haibazo.ecommerce_service.entity.Inventory;
@Repository
public interface InventorieRepository extends JpaRepository<Inventory,Long> {
}