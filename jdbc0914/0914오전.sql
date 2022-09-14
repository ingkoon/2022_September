use ssafydb;
show tables;

desc employees;
desc departments;
desc locations;
desc jobs;

select * 
from employees;

select employee_id, concat(first_name, ' ', last_name) name, 12*(salary + salary* (1 + ifnull(commission_pct, 0.0))) ysal
from employees
order by 3 desc
limit 10;

-- 꾸미면 된다
select concat(format(250500.5634, 3),'$') won from dual;

-- legth 예제
select * from employees;
select first_name, hire_date from employees;
select first_name, substr(hire_date,1, 4) from employees;
select first_name, year(hire_date) from employees;

select round(datediff(now(), hire_date)/365) dates from employees;

-- 연도별 입사인원을 구하시오.
select year(hire_date) year, count(*) count 
from employees 
group by year(hire_date) 
order by 2 desc;

-- 입사년도별 평균월급을 구하시오
select year(hire_date), round(avg(salary)) sal
from employees
group by year(hire_date)
order by 2 desc;

select weekday("2022-09-14"); -- 0 monday
select sysdate(); -- 날 + 시간
select now(); -- 날 + 시간
select curdate(); -- 날 
select curtime(); -- 시간
select time();     

-- create view view이름 as 
select * from employees;
select * from departments;
select * from locations;
select * from countries;
select * from regions; -- n-1개 즉 4개의 조인연산으로 연결할 수 있다.

create view empviewcity
as 
select e.employee_id, e.first_name, 
	   d.department_id, d.department_name,
       l.location_id, l.street_address, l.postal_code, l.city,
       c.country_id, c.country_name,
       r.region_id, r.region_name
from employees e, departments d, locations l, countries c, regions r
where e.department_id=d.department_id and 
	d.location_id = l.location_id and
    l.country_id = c.country_id and
    c.region_id = r.region_id; -- 늘려서 쓰는건 넘모 귀찮다
    
create table emptablecity
as 
select e.employee_id, e.first_name, 
	   d.department_id, d.department_name,
       l.location_id, l.street_address, l.postal_code, l.city,
       c.country_id, c.country_name,
       r.region_id, r.region_name
from employees e, departments d, locations l, countries c, regions r
where e.department_id=d.department_id and 
	d.location_id = l.location_id and
    l.country_id = c.country_id and
    c.region_id = r.region_id; -- 늘려서 쓰는건 넘모 귀찮다

select * from empviewcity;

-- create index index_name on table_name (column_list)

select * from emptablecity;

create index index_city_c_id on emptablecity(city, country_id);

show indexes from employees;

select first_name, last_name 
from employees 
where salary > (select salary from employees where employee_id = 163);

select count(*) from employees;

select first_name, last_name, department_id, job_id from employees where job_id = (select job_id from employees where employee_id = 169);

select first_name, last_name, department_id
from employees 
where salary = (select salary from employees order by salary asc limit 1);

-- 부서별 최저 급여를 받는 직원들의 정보를 반환할 수 있도록 한다.
select first_name, last_name, department_id
from employees
where salary in (select min(salary) from employees group by department_id);

-- 평균 급여 이상을 받는 직원을 찾는 SQL 쿼리 작성
select employee_id, first_name, last_name
from employees where salary > (select avg(salary) from employees);

-- 이름이 Payam인 해당 관리자에게 보고하는 직원을 찾는 쿼리작성
-- 이름, 성, 직원ID 및 급여를 반환한다.
select last_name, first_name, employee_id, salary
from employees
where manager_id = (select employee_id from employees where first_name = 'Payam');

select e.last_name, e.first_name, e.employee_id
from employees e, employees m 
where e.manager_id = m.employee_id
and m.first_name = "Payam";