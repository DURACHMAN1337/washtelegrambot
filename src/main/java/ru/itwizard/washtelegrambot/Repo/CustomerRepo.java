package ru.itwizard.washtelegrambot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itwizard.washtelegrambot.Entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
