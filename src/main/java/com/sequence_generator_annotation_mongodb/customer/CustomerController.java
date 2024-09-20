package com.sequence_generator_annotation_mongodb.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final MongoTemplate mongoTemplate;

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return mongoTemplate.save(customer, "customer");
    }
    /*
    * You can implement other methods if you want
    * For demonstration purposes, I have created only post method
    * */
}
