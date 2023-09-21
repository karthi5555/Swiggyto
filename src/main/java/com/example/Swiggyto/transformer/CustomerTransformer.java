package com.example.Swiggyto.transformer;

import com.example.Swiggyto.dto.requestDTO.CustomerRequest;
import com.example.Swiggyto.dto.responseDTO.CartResponse;
import com.example.Swiggyto.dto.responseDTO.CustomerResponse;
import com.example.Swiggyto.model.Customer;
import com.example.Swiggyto.repository.CustomerRepository;

public class CustomerTransformer {

    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest){

        return Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .mobileNo(customerRequest.getMobileNo())
                .gender(customerRequest.getGender())
                .build();
    }

    public static CustomerResponse CustomerToCustomerResponse(Customer customer){

        CartResponse cartResponse = CartTransformer.CartToCartResponse(customer.getCart());
        return CustomerResponse.builder()
                .name(customer.getName())
                .mobileNo(customer.getMobileNo())
                .address(customer.getAddress())
                .cart(cartResponse)
                .build();
    }
}