package com.sequence_generator_annotation_mongodb.configurations;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@RequiredArgsConstructor
public class GenerateSequenceAnnotationProcessor extends AbstractMongoEventListener<Object> {

    private final GenerateSequenceService sequenceGeneratorService;

    // This method will be called internally before converting the java model object to mongodb document
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object entity = event.getSource();
        // Here we're getting all the fields from the model object
        for (Field field : entity.getClass().getDeclaredFields()) {
            // Checking whether we have a field annotated with GenerateSequence
            if (field.isAnnotationPresent(GenerateSequence.class)) {
                GenerateSequence annotation = field.getAnnotation(GenerateSequence.class);
                // Calling generateCustomSequence method to get the id in the formatted way
                String sequence = sequenceGeneratorService.generateCustomSequence(
                        annotation.sequenceName(),
                        annotation.prefix(),
                        annotation.padding()
                );
                // Just allowing this method to update the model object before converting into mongodb document
                field.setAccessible(true);
                try {
                    // Setting the value to the id field
                    field.set(entity, sequence);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to set custom sequence", e);
                }
            }
        }
    }
}