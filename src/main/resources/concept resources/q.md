- diff between jdbc and orm is that one is just used to make the connection between db and java
and bij die andere gaat het om dat je java entities worden omgezet in database objecten

- also With JDBC, developers need to write SQL queries to perform CRUD 
- (create, read, update, delete) operations. With ORM, 
- developers can perform these operations by calling methods on objects mapped to database tables. 
- No direct SQL coding is needed.


- Orm is slower bc it needs to translate ur methods into SQL queries
- ORM slaat je objecten op. Persistent and all



# Paradigm mismatch
## Inheritance problem:
- In java kan je subclasses hebben
- oplossing: je gaat 1 tabel hebben met je main type en ongeacht hoeveel subclasses je hebt


## Granularity problem:
- oplossing is gewoon de id's opslaan want obv in je db heb je geen type van een andere class



