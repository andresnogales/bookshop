package com.andresnogales.bookshop.service;

import java.util.List;

import com.andresnogales.bookshop.model.PurchaseHistory;
import com.andresnogales.bookshop.repository.projection.IPurchaseItem;

public interface IPurchaseHistoryService {

	PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);
	List<IPurchaseItem> findPurchasedItemsOfUser(Long userId);
}
