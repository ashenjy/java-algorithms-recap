Input:
Activities table:
+------------+------------+
| sell_date  | product     |
+------------+------------+
| 2020-05-30 | Headphone  |
| 2020-06-01 | Pencil     |
| 2020-06-02 | Mask       |
| 2020-05-30 | Basketball |
| 2020-06-01 | Bible      |
| 2020-06-02 | Mask       |
| 2020-05-30 | T-Shirt    |
+------------+------------+
Output:
+------------+----------+------------------------------+
| sell_date  | num_sold | products                     |
+------------+----------+------------------------------+
| 2020-05-30 | 3        | Basketball,Headphone,T-shirt |
| 2020-06-01 | 2        | Bible,Pencil                 |
| 2020-06-02 | 1        | Mask                         |
+------------+----------+------------------------------+
Explanation:
For 2020-05-30, Sold items were (Headphone, Basketball, T-shirt), we sort them lexicographically and separate them by a comma.
For 2020-06-01, Sold items were (Pencil, Bible), we sort them lexicographically and separate them by a comma.
For 2020-06-02, the Sold item is (Mask), we just return it.

select
sell_date,
COUNT(distinct product) as num_sold,
group_concat(distinct product) as products
from Activities
group by sell_date


Create table If Not Exists Activities (sell_date date, product varchar(20))
    Truncate table Activities
    insert into Activities (sell_date, product) values ('2020-05-30', 'Headphone')
    insert into Activities (sell_date, product) values ('2020-06-01', 'Pencil')
    insert into Activities (sell_date, product) values ('2020-06-02', 'Mask')
    insert into Activities (sell_date, product) values ('2020-05-30', 'Basketball')
    insert into Activities (sell_date, product) values ('2020-06-01', 'Bible')
    insert into Activities (sell_date, product) values ('2020-06-02', 'Mask')
    insert into Activities (sell_date, product) values ('2020-05-30', 'T-Shirt')
