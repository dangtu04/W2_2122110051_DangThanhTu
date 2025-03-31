package com.dangthanhtu.backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangthanhtu.backend.entity.CartItem;
import com.dangthanhtu.backend.payloads.CartItemDTO;
import com.dangthanhtu.backend.repository.CartItemRepo;
import com.dangthanhtu.backend.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepo cartItemRepo;

    @Override
    public List<CartItemDTO> getCartItemsByCartId(Long cartId) {
        List<CartItem> cartItems = cartItemRepo.findCartItemsByCartId(cartId);
        return cartItems.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CartItemDTO getCartItemByProductIdAndCartId(Long productId, Long cartId) {
        CartItem cartItem = cartItemRepo.findCartItemByProductIdAndCartId(cartId, productId);
        return convertToDTO(cartItem);
    }

    private CartItemDTO convertToDTO(CartItem cartItem) {
        CartItemDTO dto = new CartItemDTO();
        dto.setCartItemId(cartItem.getCartItemId());
        dto.setProduct(null);
        dto.setQuantity(cartItem.getQuantity());
        dto.setDiscount(cartItem.getDiscount());
        dto.setProductPrice(cartItem.getProductPrice());
        return dto;
    }
}