package com.test.springbootdrools.service;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.test.springbootdrools.config.DroolsConfiguration;
import com.test.springbootdrools.model.Customer;



@Service
public class CustomerService {

    private KieSession kieSession=new DroolsConfiguration().getKieSession();

    public Customer insertCustomer(Customer customer){
        kieSession.insert(customer);
        kieSession.fireAllRules();
        return  customer;

    }

}
