#sequence-generator-annotation-mongodb

  In this project, I have created an annotation which will generate sequential data which can be used with your document object to generate Id automatically. 
  This is an exact replica of @GeneratedValue annotation which comes with spring-boot-starter-jpa dependency, where we can use with relational databases. 
  So this project aims to replicate @GeneratedValue annotation but for NoSQL databases. In this example, I have used mongodb as database.
  Here, I have created @GenerateSequence(sequenceName="sequence", prefix="USER", padding=3) - sequenceName is just an identifier to uniquely identify the collection name, prefix will give you some flexibility to add something before that sequence number i.e., USER001 and padding refers to number of digits we have to include after prefix, here we're using 3 digits. Padding is just a representation after the value 999, it'll moe to 4 digits value, then 5 digits value and so on.
sequenceName="sequence", prefix="USER" and padding=3 these are the default values.
  Let's dive into the application. Hope you'll like it!
