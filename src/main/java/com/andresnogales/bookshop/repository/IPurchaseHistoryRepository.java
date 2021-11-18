package com.andresnogales.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.andresnogales.bookshop.model.PurchaseHistory;
import com.andresnogales.bookshop.repository.projection.IPurchaseItem;

public interface IPurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long>{

	@Query("select b.title as title, ph.price as price, ph.purchaseTime as purchaseTime"
			+ " from PurchaseHistory ph left join Book b on b.id = ph.bookId "
			+ "where ph.userId = :userId")
	List<IPurchaseItem> findAllPurchasesOfUser(@Param ("userId") Long userId); 
}
