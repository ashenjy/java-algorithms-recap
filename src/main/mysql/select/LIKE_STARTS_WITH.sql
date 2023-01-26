Input:
Patients table:
+------------+--------------+--------------+
| patient_id | patient_name | conditions   |
+------------+--------------+--------------+
| 1          | Daniel       | YFEV COUGH   |
| 2          | Alice        |              |
| 3          | Bob          | DIAB100 MYOP |
| 4          | George       | ACNE DIAB100 |
| 5          | Alain        | DIAB201      |
+------------+--------------+--------------+
Output:
+------------+--------------+--------------+
| patient_id | patient_name | conditions   |
+------------+--------------+--------------+
| 3          | Bob          | DIAB100 MYOP |
| 4          | George       | ACNE DIAB100 |
+------------+--------------+--------------+
Explanation: Bob and George both have a condition that starts with DIAB1.

select patient_id, patient_name, conditions
from Patients
where conditions LIKE '% DIAB1%' or conditions like "DIAB1%"

Last test case fails for SABDIAB100 while using like'%DIAB1%'

to solve that we have to use to different condition to eliminate this testcase

'DIAB1%' - when condition directly starts with it
' % DIAB1%' - when DIAB1 is after a word remember to use one space for first character.