# Database Programming Java Guide - PostgreSQL

This Java code package provides a guide for performing various activities using PostgreSQL database operations. The activities include deleting records, updating records, and inserting new records into different tables of a PostgreSQL database. The code utilizes JDBC for database connectivity.

# Getting Started

To use this code package, ensure you have the following prerequisites:

Java Development Kit (JDK) installed
PostgreSQL database server installed and running
JDBC driver for PostgreSQL (typically included in the project or can be added separately)

# Configuration

Make sure to update the following parameters in the dbprogramming class according to your PostgreSQL database configuration:

url: The JDBC URL for connecting to the PostgreSQL database.
user: The username for connecting to the PostgreSQL database.
pwd: The password for connecting to the PostgreSQL database.

# Activities
Activity 1: Deleting product p1 from Product and Stock

Activity 2: Deleting depot d1 from Depot and Stock

Activity 3: Changing product p1 name to pp1 in Product and Stock

Activity 4: Changing depot d1 name to dd1 in Depot and Stock

Activity 5: Adding a product (p100, cd, 5) in Product and (p100, d2, 50) in Stock

Activity 6: Adding a new depot (d100, Chicago, 100) in Depot and (p1, d100, 100) in Stock

# Execution
Run the main method in the dbprogramming class to execute the activities. The program will connect to the PostgreSQL database, perform the specified activities, and commit the changes.

Ensure that the PostgreSQL server is running and accessible.

# Notes
This code package assumes the existence of the required tables (product, depot, stock) in the PostgreSQL database.
Always handle database connections, transactions, and exceptions appropriately in a production environment.

Feel free to adapt the code according to your specific database structure and requirements.



