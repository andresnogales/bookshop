package com.andresnogales.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andresnogales.bookshop.model.PurchaseHistory;
import com.andresnogales.bookshop.security.UserPrincipal;
import com.andresnogales.bookshop.service.IPurchaseHistoryService;

@RestController
@RequestMapping("api/purchase-history")
public class PurchaseHistoryController {

	@Autowired
	private IPurchaseHistoryService purchaseHistoryService;
	
	@PostMapping
	public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory){
		return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllPurchaseOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
		return ResponseEntity.ok(purchaseHistoryService.findPurchasedItemsOfUser(userPrincipal.getId()));
	}
}
