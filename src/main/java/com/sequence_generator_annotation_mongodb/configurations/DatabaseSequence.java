package com.sequence_generator_annotation_mongodb.configurations;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
@Data
public class DatabaseSequence {
    @Id
    private String id;
    private long seq;

    /*
    * seq will hold the value for digits
    * */
}
