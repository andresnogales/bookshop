package com.andresnogales.bookshop.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andresnogales.bookshop.model.PurchaseHistory;
import com.andresnogales.bookshop.repository.IPurchaseHistoryRepository;
import com.andresnogales.bookshop.repository.projection.IPurchaseItem;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService{

	@Autowired
	private IPurchaseHistoryRepository purchaseHistoryRepository;

	@Override
	public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory) {
		purchaseHistory.setPurchaseTime(LocalDateTime.now());
		return purchaseHistoryRepository.save(purchaseHistory);
	}

	@Override
	public List<IPurchaseItem> findPurchasedItemsOfUser(Long userId) {
		return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
	}
	
	
	
}
