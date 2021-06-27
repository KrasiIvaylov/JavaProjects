#Exercise 01
SELECT COUNT(*) FROM `wizzard_deposits`;

#Exercise 02
SELECT MAX(`magic_wand_size`) FROM `wizzard_deposits`;

#Exercise 03
SELECT `deposit_group`, MAX(`magic_wand_size`) AS `max_size`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `max_size`, `deposit_group`;

#Exercise 04
SELECT `deposit_group`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY AVG(`magic_wand_size`)
LIMIT 1;

#Exercise 05
SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum`;

#Exercise 06
SELECT `deposit_group`, SUM(`deposit_amount`)
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group`;

#Exercise 07
SELECT 
    `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM
    `wizzard_deposits`
WHERE
    `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;  

#Exercise 08
SELECT 
    `deposit_group`,
    `magic_wand_creator`,
    MIN(`deposit_charge`) AS `min_charge`
FROM
    `wizzard_deposits`
GROUP BY `deposit_group` , `magic_wand_creator`
ORDER BY `magic_wand_creator` , `deposit_group`;

#Exercise 09
SELECT (
CASE 
	WHEN `age` BETWEEN 0 AND 10 THEN '[0-10]'
	WHEN `age` BETWEEN 11 AND 20 THEN '[11-20]'
	WHEN `age` BETWEEN 21 AND 30 THEN '[21-30]'
	WHEN `age` BETWEEN 31 AND 40 THEN '[31-40]'
	WHEN `age` BETWEEN 41 AND 50 THEN '[41-50]'
	WHEN `age` BETWEEN 51 AND 60 THEN '[51-60]'
	ELSE '[61+]'
END
) AS `age_group`, COUNT(*) AS 'wizzards_count'
FROM `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `age_group` ASC;