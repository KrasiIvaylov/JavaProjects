#Exercise01
SELECT * FROM soft_uni.departments
ORDER BY `department_id`;

#Exercise02
SELECT `name` FROM `departments`
ORDER BY `department_id`;

#Exercise03
SELECT `first_name`, `last_name`, `salary` FROM `employees`;

#Exercise 04
SELECT `first_name`, `middle_name`, `last_name` FROM `employees`;

#Exercise 05
SELECT 
    CONCAT(`first_name`,
            '.',
            `last_name`,
            '@softuni.bg') AS 'full_email_address'
FROM
    `employees`;

#Exercise 06
SELECT DISTINCT `salary` FROM `employees`
ORDER BY `employee_id`;

#Exercise 07
SELECT * FROM `employees`
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id`;

#Exercise 08
SELECT 
    `first_name`, `last_name`, `job_title`
FROM
    `employees`
WHERE
    `salary` BETWEEN 20000 AND 30000
ORDER BY `employee_id`;

#Exercise 09
SELECT 
    CONCAT_WS(' ',
            `first_name`,
            `middle_name`,
            `last_name`) AS 'Full Name'
FROM
    `employees`
WHERE
    `salary` IN (25000 , 14000, 12500, 23600);
    
#Exercise 10
SELECT * FROM `employees`
WHERE `manager_id` IS NULL;
