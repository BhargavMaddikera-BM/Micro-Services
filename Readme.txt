The following are the Micro Services:

1) User Service:

  - runs on http port 8085 and https port 8443
  - It has operations Create User, Update User, Delete User, Get All Users, Get Single User
  - name is userservice
  
  Tables:

  - user, user_address
  - there will be a user_id that will be a logical foreign key in user_address

2) Book Service:

  - runs on http port 8086 and https port 8444
  - It has operations Create Book, Update Book, Delete Book, Get All Books, Get Single Book
  - name is bookservice
  
  Tables:

  - book
  
3) User Book Service:

  - runs on http port 8087 and https port 8445
  - It has operations bookNewRequest, updateExistingRequest,closeExistingRequest,getAllBooksOfUser
  - name is userbookservice
  
  Tables:

  - user_book(user_id and book_id will be a logical foreign key to user and book tables). 
  - user_book will have status column
  
4) Inventory Book Service

  - runs on http port 8088 and https port 8446
  - It has operations getInventoryOfaBook
  - name is inventorybookservice
  
   Tables:

  - book_inventory(book_id will be a logical foreign key to book table). 
  - book_inventory will have count column
  
  
Other Micro Services:

1)Spring Cloud Config Service will be used that will act as a Config Server which will hold external properties file instead of git properties.
2)Gateway service that will have zuul proxy which will be a facade to the outside world. none of the above micro services would be exposed to the outside world. only gateway service will be exposed
3)Netflix Eureka Service would be used as a registry and discovery service. All the services would be registred in Eureka. Any Micr Service interaction would happen via Eureka only
4)Distributed Tracing Service that will have ZipKin Server. It will have in memory default configuration. Sleuth would be available in all the Services
5)Authentication and Authorization Service will be used for authentication and authorization. tokens that will be generated post login will be stored in Hazelcast Cache in this service which will be validated for each and every request. This will be called from gateway service in pre filter flow.Zuul Proxy has pre, post, error, route filters. 
6)Password Service: It will have Change Password, Forgot Password, Reset Password
7)Login And Registration Service: It will have Login and Registration API's
  
  
Assumptions:

- A Book Id will have many inventories  
- Java 8
- MySQL 8
- Hazelcast 4.1
- log4j is used that will have logs in /logs folder for all the 4 micro services separately in 4 different folders inside /logs. please have a look at log4j.properties file 



