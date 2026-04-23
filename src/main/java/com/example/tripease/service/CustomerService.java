package com.example.tripease.service;

import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.enums.Gender;
import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.model.Customer;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        //request Dto to Entity
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        //save entity to db
        Customer savedCustomer = customerRepository.save(customer);

        //saved Entity to response dto
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);

    }

    public CustomerResponse getCustomerById(int customerId) {
       Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
       if(optionalCustomer.isEmpty()){
           throw new CustomerNotFoundException("Invalid customer Id");
       }
       Customer savedCustomer = optionalCustomer.get();

       //saved entity to DTo
       return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }


    public List<CustomerResponse> getAllByGender(Gender gender) {
        List<Customer> customerList = customerRepository.findByGender(gender);

        List<CustomerResponse> customerResponseList = new ArrayList<>();

        for(Customer customer : customerList){
            customerResponseList.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponseList;
    }

    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age) {
        List<Customer> customerList = customerRepository.findByGenderAndAge(gender, age);

        List<CustomerResponse> customerResponseList = new ArrayList<>();
        for(Customer customer : customerList){
            customerResponseList.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponseList;
    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(String gender, int age) {
        List<Customer> customerList = customerRepository.getAllByGenderAndAgeGreaterThan(gender, age);

        List<CustomerResponse> customerResponseList = new ArrayList<>();
        for(Customer customer : customerList){
            customerResponseList.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponseList;
    }
}
