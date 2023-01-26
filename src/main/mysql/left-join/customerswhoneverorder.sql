Write an SQL query to report all customers who never order anything.

Return the result table in any order.

Input:
Customers table:
+----+-------+
| id | name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Orders table:
+----+------------+
| id | customerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Output:
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+

select c.Name as Customers from Customers c
LEFT JOIN Orders o ON c.Id = o.CustomerId
where o.CustomerId IS NULL
