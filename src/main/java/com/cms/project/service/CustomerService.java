package com.cms.project.service;

import com.cms.project.dao.CustomerDao;
import com.cms.project.exception.CustomerNotFoundException;
import com.cms.project.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public Customer addCustomer(Customer customer) {
     /*   customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;*/

        return customerDao.save(customer);
/*
        return customer;
*/
    }

    public List<Customer> getCustomers() {
        return customerDao.findAll();
        /* return customerList;*/
    }

    public Customer getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        if (!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer is not present");

        return optionalCustomer.get();

      /*  return customerList.stream().filter(c -> c.getCustomerId() == customerId)
                .findFirst().get();*/
    }


    public Customer updateCustomer(int customerId, Customer customer) {

        customer.setCustomerId(customerId);

        return customerDao.save(customer);

   /*     customerList.stream()
                .forEach(c -> {
                    if (c.getCustomerId() == customerId) {
                        c.setFirstName(customer.getFirstName());
                        c.setLastName(customer.getLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });
        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();*/
    }


    public void deleteCustomer(int customerId) {

       /* customerList.stream().forEach(c -> {
                    if (c.getCustomerId() == customerId) {
                        customerList.remove(c);
                    }
                }
        );*/

        customerDao.deleteById(customerId);
    }
}
