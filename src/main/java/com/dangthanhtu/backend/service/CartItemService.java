package com.dangthanhtu.backend.service;

import java.util.List;

import com.dangthanhtu.backend.entity.CartItem;
import com.dangthanhtu.backend.payloads.CartItemDTO;

public interface CartItemService {
    // List<CartItem> getCartItemsByCartId(Long cartId);
        List<CartItemDTO> getCartItemsByCartId(Long cartId);
        CartItemDTO getCartItemByProductIdAndCartId(Long productId, Long cartId);
}