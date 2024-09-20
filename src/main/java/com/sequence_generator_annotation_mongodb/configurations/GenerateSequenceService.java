package com.sequence_generator_annotation_mongodb.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.FindAndModifyOptions;

import java.text.DecimalFormat;
import java.util.Objects;

@Service
public class GenerateSequenceService {

    @Autowired
    private MongoOperations mongoOperations;

    public String generateCustomSequence(String seqName, String prefix, int padding) {
        // This will fetch the sequence value and update it by 1 then update the same to database
        DatabaseSequence counter = mongoOperations.findAndModify(
                Query.query(Criteria.where("_id").is(seqName)),
                new Update().inc("seq", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                DatabaseSequence.class);

        long sequenceNumber = Objects.nonNull(counter) ? counter.getSeq() : 1;
        // Formating the id by appending prefix and sequence digit
        String pattern = prefix + String.format("%0" + padding + "d", 0);
        DecimalFormat idFormat = new DecimalFormat(pattern);

        return idFormat.format(sequenceNumber);
    }
}