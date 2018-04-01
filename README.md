# Oauth2 Resource Template
This template is a Rest Api with Oauth2 security classes which can consume the tokens that Oauth2 Server generated for authorized client.

## How to Run
- To use this template you need to add your connection string to database in application.yml file.
- Also You need to add your public key to resources folder.
- This template uses Freemarker to generate layers of a Restful Api. To generate all layers you just need to add table name and then field name and type of each field in columns.txt file.
- Run ClassFreeMarkerStyle class and then it will generate all required classes i.e. Controller, Service, Dao, Model for each table.
- One more step! Refresh the project to see generated classes.

That's it! Your Rest Api is ready and can be tested by postman.

