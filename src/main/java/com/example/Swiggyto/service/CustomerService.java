package com.example.Swiggyto.service;

import com.example.Swiggyto.dto.requestDTO.CustomerRequest;
import com.example.Swiggyto.dto.responseDTO.CustomerResponse;
import com.example.Swiggyto.exception.CustomerNotFoundException;
import com.example.Swiggyto.model.Cart;
import com.example.Swiggyto.model.Customer;
import com.example.Swiggyto.repository.CustomerRepository;
import com.example.Swiggyto.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        // dto -> customer model
        Customer customer = CustomerTransformer.CustomerRequestToCustomer(customerRequest);

        //allocate a cart
        Cart cart = Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();

        customer.setCart(cart);

        // save both customer and cart
        Customer savedCustomer = customerRepository.save(customer);  // saves both customer and cart

        // prepare response Dto
        return CustomerTransformer.CustomerToCustomerResponse(savedCustomer);
    }

    public CustomerResponse findCustomerByMobile(String mobile) {

        Customer customer = customerRepository.findByMobileNo(mobile);
        if(customer==null){
            throw new CustomerNotFoundException("Invalid mobile no!!!");
        }
        return CustomerTransformer.CustomerToCustomerResponse(customer);
    }
}
