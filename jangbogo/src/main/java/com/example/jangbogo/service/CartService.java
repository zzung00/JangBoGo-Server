package com.example.jangbogo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.example.jangbogo.domain.Cart;
import com.example.jangbogo.domain.CartItem;
import com.example.jangbogo.domain.Product;
import com.example.jangbogo.domain.User;
import com.example.jangbogo.dto.CartDTO;
import com.example.jangbogo.dto.CartItemDTO;
import com.example.jangbogo.repository.CartItemRepository;
import com.example.jangbogo.repository.CartRepository;
import com.example.jangbogo.repository.ProductRepository;
import com.example.jangbogo.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CartDTO loadCart(Integer userId) {
        Optional<Cart> optionalCart = cartRepository.findByUserId(userId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);
            return cartDTO;
        } else {
            User user = userRepository.getById(userId);
            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
            CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);
            return cartDTO;
        }
    }

    public List<CartItemDTO> loadCartItem(Integer cartId) {
        List<CartItemDTO> response;
        List<CartItem> cartItems = cartItemRepository.findByCartId(cartId);
        response = cartItems.stream().map(c -> modelMapper.map(c, CartItemDTO.class)).collect(Collectors.toList());
        return response;
    }

    public void addCartItem(Integer userId, Integer productId, int count, int price) {
        Optional<Cart> optionalCart = cartRepository.findByUserId(userId);
        if(optionalCart.isPresent()) {
            CartItem item = new CartItem();
            Product product = productRepository.findById(productId).get();
            item.setProduct(product);
            item.setCart(optionalCart.get());
            item.setCount(count);
            item.setPrice(price);
            cartItemRepository.save(item);
        }
    }

    public void deleteCartItem(Integer cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void updateCartItem(Integer cartItemId, int count) {
        CartItem item = cartItemRepository.getById(cartItemId);
        item.setCount(count);
        cartItemRepository.save(item);
    }
}
