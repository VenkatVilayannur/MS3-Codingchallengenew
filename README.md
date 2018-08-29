INSTRUCTIONS TO RUN THE PROJECT AND APPROACH:

--> Change the path to load the CSV and add the connectivity for the database connection

--> I have created the application based on assuming the employee personal information rather than going by the column
name. This is the scope which I personally identified as this seems to be structured and reliable too.

--> The approach which I followed to develop the application is
	a. I have made two different JAVA files
		1) CSVLoader.java
		2) Employee.java
--> CSV loader java file will depict the database connectivity, and the employee related information like the firstname,
lastname, email, contact. Create the database connection using the connection object, pull the data, write the insert query
and print the resultset using the DRL statement resultset, which uses the cursour with the while().

--> There is a employee class in java where it has the model layer for the application that has the getter() and setter() for the
application.

