package ru.itwizard.washtelegrambot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itwizard.washtelegrambot.Entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {
}
