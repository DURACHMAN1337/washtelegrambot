package ru.itwizard.washtelegrambot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.itwizard.washtelegrambot.Entity.Cart;
import ru.itwizard.washtelegrambot.Entity.Customer;
import ru.itwizard.washtelegrambot.Repo.CartRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;

    public CartService() {
    }

    public void delete(Cart cart) {
        cartRepo.delete(cart);
    }

    public void deleteById(Long id) {
        cartRepo.deleteById(id);
    }

    public List<Cart> findAll() {
        return cartRepo.findAll();
    }

    public Optional<Cart> findOne(Customer customer) {
        Cart cart = new Cart();
        cart.setCustomer(customer);
        return cartRepo.findOne(Example.of(cart));
    }

    public void save(Cart cart){
        cartRepo.save(cart);
    }


}
