package com.example.tripease.controller;

import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.enums.Gender;
import com.example.tripease.model.Customer;
import com.example.tripease.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add-customer")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);

    }

    @GetMapping("/getById/customer-id/{customerId}")
    public CustomerResponse getCustomerById(@PathVariable int customerId){
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/getByGender/gender/{gender}")
    public List<CustomerResponse> getAllByGender(@PathVariable Gender gender){
        return customerService.getAllByGender(gender);
    }

    @GetMapping("/get-By-GenderAndAge")
    public List<CustomerResponse> getAllByGenderAndAge( @RequestParam("gender") Gender gender, @RequestParam("age") int age){
        return customerService.getAllByGenderAndAge(gender, age);
    }

    //Using HQL
//    @GetMapping("/get-by-age-greater-than")
//    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan( @RequestParam("gender") Gender gender, @RequestParam("age") int age){
//        return customerService.getAllByGenderAndAgeGreaterThan(gender, age);
//    }

    @GetMapping("/get-by-age-greater-than")
    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan( @RequestParam("gender") String gender, @RequestParam("age") int age){
        return customerService.getAllByGenderAndAgeGreaterThan(gender, age);
    }
}
