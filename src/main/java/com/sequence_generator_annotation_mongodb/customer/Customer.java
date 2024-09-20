package com.sequence_generator_annotation_mongodb.customer;

import com.sequence_generator_annotation_mongodb.configurations.GenerateSequence;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
@Data
public class Customer {
    @Id
    @GenerateSequence(sequenceName = "customer", prefix = "CUST", padding = 3)
    private String id;
    private String name;
    private String email;
    private Long phone;

    /*If you don't want any prefix use prefix="",
    if you leave that field, it will take the default value as USER else change the default value*/
}
