package ru.itwizard.washtelegrambot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itwizard.washtelegrambot.Entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
}
