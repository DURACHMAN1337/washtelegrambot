package ru.itwizard.washtelegrambot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.itwizard.washtelegrambot.Entity.Customer;
import ru.itwizard.washtelegrambot.Repo.CustomerRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public CustomerService() {
    }

    public void delete(Customer customer){
        customerRepo.delete(customer);
    }

    public void deleteById(Long id){
        customerRepo.deleteById(id);
    }

    public List<Customer> findAll(){
        return  customerRepo.findAll();
    }

    public Optional<Customer> findOne(Long userId){
        Customer customer = new Customer();
        customer.setUserId(userId);
        return customerRepo.findOne(Example.of(customer));

    }

    public void save(Customer customer){
        customerRepo.save(customer);
    }


}
