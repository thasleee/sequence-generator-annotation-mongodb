#sequence-generator-annotation-mongodb

  In this project, I have created an annotation which will generate sequential data which can be used with your document object to generate Id automatically. 
  This is an exact replica of @GeneratedValue annotation which comes with spring-boot-starter-jpa dependency, where we can use with relational databases. 
  So this project aims to replicate @GeneratedValue annotation but for NoSQL databases. In this example, I have used mongodb as database.
  I've created @GenerateSequence(sequenceName="sequence", prefix="USER", padding=3) - sequenceName is just an identifier, prefix will give you some flexibility to add something before that sequence number i.e., USER001. sequenceName="sequence", prefix="USER" and padding=3 these are the default values.
  Let's dive into the application and I'll explain you how I did!
