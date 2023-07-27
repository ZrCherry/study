[TOC]

![脑图](D:\学习笔记\java\脑图.png)

# 1. 数据库概述

MySQL介绍：MySQL是一个开放源代码关系型数据库管理系统。

mysql特点：

1. 开源，成本低
2. 性能卓越，服务稳定
3. 软件体积小，使用简单，便于维护
4. 社区用户非常活跃，便于寻求帮助
5. 许多互联网公司使用，经过了时间的验证

oracle特点（相比mysql)：

oracle性能更高，安全性更好，但需要付费啊。

## 1.1 数据库概念

1. 数据库DB：存储数据的仓库，本质是一个文件系统
2. 数据库管理系统DBMS：操纵和管理数据库的大型软件，用于建立、使用和维护数据库。如Navicat等
3. SQL结构化查询语言：用来与数据库通信的语言
4. 关系型数据库与非关系型数据库

>**关系型数据库**：以行和列的形式存储数据，行和列组合成的二维数组就称为表，一组表组成一个数据库。表和表之间的数据记录有关系。实体和实体之间的各种关系均用关系模型来表示，关系型数据库就是建立在关系模型基础上的数据库。
>
>**非关系型数据库：** 非表格化的数据存储。 主要有键值型数据库（如redis），文档型数据库（MongoDB）搜索引擎数据库（elasticsearch）,列式数据库（Hbase），图形数据库（Neo4j）

   ## 1.2 关系型数据库设计原则（待补充）

>ORM思想（Object Relation Mapping）
>
>数据库一张表 --------java中的一个类
>
>表中一条数据---------类中的一个对象
>
>表中的一个列---------类中的一个字段

1.2.1 E-R模型

E-R模型的三个主要概念是：实体集，属性，联系集。一个实体集对应一张表；一个实体对应表中一行，也称为一条记录；一个属性对应表中一列，也称为一个字段。

## 1.3 常用版本

1. mysql5.7
2. mysql8.0

> mysql5.5之前使用的是MyISAM存储引擎，5.5及之后InnoDB成为MySQL的默认存储引擎。

## 1.4 mysql之卸载步骤

1. 停止mysql服务
2. 卸载软件（不要直接删除mysql包，通过卸载程序进行卸载）
3. 删除对应的库表
4. 删除环境变量
5. msyql5.7之前需要手动清理注册表
6. 重启电脑

  ## 1.5 忘记root密码

![image-20221015203407192](D:\学习笔记\java\image-20221015203407192.png)

# 2. SQL

## 2.1 SQL概述

SQL是使用关系模型的数据库应用语言，与数据直接打交道。

> **SQL分类：DDL，DML，DCL**
>
> DDL（数据定义语言）：create / alter / drop / rename / truncate
>
> DML（数据操作语言）：insert / delete /  update / select
>
> DCL（数据控制语言）：commit / rollback / savepoint / grant / revoke

## 2.2 SQL语言规则与规范

**书写规范：**

- 数据库名，表名，表别名，字段名，字段别名等都小写。
- SQL关键字、函数名，绑定变量都大写

**注释：**

- 单行注释：  #文字  -- 文字（--后有一个空格）
- 多行注释： /* 文字 */

**命名规则：**

- 数据库、表名、变量名不得超过63字符（8.0以后）
- 只能包含a-z，A-Z，0-9，_等29个字符。
- 数据库名、表名、字段名等对象名中间不要包含空格
- 同一个MySQL软件中，数据库不能同名，同一个库中，表不能同名，同一个表中，字段不能重名
- 字段不能和保留字，数据库系统或常用方法冲突，如果坚持使用，必须要用（着重号）引起来。  如`order`
- 保证字段名和类型的一致性，在命名字段并为其指定数据类型的时候一定要保证一致性。

**执行顺序：**

​	首先从FROM ...  WHERE ,然后增删改查的操作，最后排序。 

## 2.3 基本的SQL语句

### 1. 基本的SELECT语句

```sql
#select 字段1，字段2，... from 表名
SELECT * FROM employees;

SELECT employee_id,last_name,salary
FROM employees;


# 查询语句的先后顺序
/*
SELECT ...,...,...
FROM ...
WHERE ... AND/OR/NOT/
ORDERBY ... (ASC/DESC),...,...
LIMIT ...,...
*/
```

### 2.列的别名

1. AS (alias别名)：可以省略

2. 列的别名可以使用一对 “ ” 括起来，别名中有空格等字符时可以使用
2. 列的别名只能在ORDER BY中使用，不能在WHERE中使用。

```sql
SELECT employee_id AS e_id,last_name AS l_name,department_id d_id
FROM employees;

#三种方法 1. as  2.省略as 3.双引号
SELECT employee_id employee_id,last_name AS l_name,department_id "部门id",salary * 12 "annual sal"
FROM employees;
```

### 3.去除重复行 DISTINCT

```sql
SELECT DISTINCT department_id
FROM employees;
```

### 4.空值参与运算 null

>1.  null
>
>2. null 不等同于0，‘ ’ ，‘null'
>3. 空值参与运算，结果一定为空

```sql
SELECT employee_id,salary "月工资",salary * (1 + commission_pct) * 12 "年工资",commission_pct
FROM employees;
#解决方案
SELECT employee_id,salary "月工资",salary * (1 + IFNULL(commission_pct,0)) * 12 "年工资",commission_pct
FROM employees;
```

### 5.着重号``

```sql
#order表名与排序关键字order重复，查询时要加上着重号。
SELECT * FROM `order`;
```

### 6.查询常数

```sql
#'尚硅谷'，123就是查询常数，所有查询出来的行都会显示。
SELECT '尚硅谷',123,employee_id,last_name
FROM employees;
```

### 7.显示表结构 decribe table_name

```sql
#也可以简写 DESC
DESCRIBE employees;
DESC employees;
```

### 8.过滤数据 WHRER

```sql
#声明紧跟在FROM后面
SELECT * 
FROM employees
WHERE department_id = 90
AND last_name = 'King';
```

##  2.4 运算符

### 1. 算数运算符 + - * /  mod()

```sql
SELECT 100, 100 + 1, 100 - 9, 100 + 40 * 3, 100 / 3, MOD(100,3)
FROM DUAL;
```

### 2. 比较运算符

	#### 2.1 =  <=>  <>  !=  <  <=  >  >=

```sql
# 等号运算符 =  判断两边的值，相等返回1，不等返回0

# 1. 如果两边的值，字符串或者表达式都为字符串，MySQL会按照字符串比较ANSIC
# 2. 如果两边都是整数，MySQL比较数值大小
# 3. 如果两边一个整数，一个字符串，MySQL会将字符串转换为数字比较，无法转换的话转换为0。 如 'a' = 0 返回 1
# 4. 如果等号两边有一个为null，则比较结果为null

# 返回 null, null
SELECT 'a' = NULL, NULL = NULL

# <=>: 安全等与 处理NULL的比较
# 返回 0 1 
SELECT 'a' <=> NULL, NULL <=> NULL

# 返回  11111
SELECT 'a' = 'a', 'ab' = 0,'1' = 1, 2 != 1, 2 = '2'
FROM DUAL;
```

#### 2.2. 关键字

```sql
# 1. IS NULL / IS NOT NULL / ISNULL
# A IS NULL = ISNULL(A) 
SELECT commission_pct
FROM employees
WHERE commission_pct IS NULL;

SELECT commission_pct
FROM employees
WHERE ISNULL(commission_pct);

SELECT commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;

# 2. LEAST() / GREATEST()
# 最小值 b / 最大值 t
SELECT LEAST('G','B','T','M'),GREATEST('G','B','T','M')

# 3. BETWEEN 条件1 AND 条件2 
# 查询工资在6000到8000之间的，包括边界值，交换6000和8000，查不到数据。
SELECT employee_id, last_name, salary
FROM employees
WHERE salary BETWEEN 6000 and 8000;

# 4. IN / NOT IN
# 在某个范围内()
SELECT last_name, salary,department_id
FROM employees
WHERE department_id IN (10,20,30)

# 5. LIKE 模糊查询
# 查找名字中包含a的名字
SELECT last_name
FROM employees
WHERE last_name LIKE '%a%';

# 6. REGEXP / RLIKE: 正则表达式
SELECT 'shkstart' REGEXP '^s';
```

### 3. 逻辑运算符

> AND= &&		NOT= ！	OR = ||		(异或)XOR ：一真一假。
>
> AND和OR一起使用，AND优先级高于OR

## 2.5 排序与分页

### 1. 排序

- 如果没有使用排序操作，查询显示的数据是按照添加的时间顺序来排列的。

- 使用ORDER BY对查询到的数据进行排序操作。升序 ASC ，降序 DESC，默认是ASC。

```sql
SELECT employee_id,salary
FROM employees
WHERE department_id IN (50,60,70)
ORDER BY department_id DESC;
```

- 二级排序， 先按照department_id降序，salary的升序排列

```sql
SELECT employee_id,salary,department_id
FROM employees
ORDER BY department_id DESC,salary ASC;
```

- 多列排序，首先按照第一列排序，第一列中相同的数据在执行第二列的排序，如果第一列中所有值都是唯一的，不会对第二列排序

### 2. 分页

mysql分页使用LIMIT关键字，其后有两个参数，第一个参数是偏移量，第二个数据是每页显示的数量

每页显示pageSize条记录，此时显示第pageNo页， **LIMIT （pageNo - 1）* PageSize,pageSize **

>LIMIT 子句必须放在整个查询的最后

```sql
SELECT employee_id,last_name
FROM employees
WHERE salary > 6000
ORDER BY salary DESC
LIMIT 0,10;
```

## 2.6 多表 查询

### 2.6.1 多表查询

笛卡尔积错误：直接多表查询会将两张表的数据行进行笛卡尔积运算。

错误原因：缺少了多表的连接条件。

笛卡尔积是一个数学运算，集合x和集合y的所有可能组合，组合个数为两个集合中元素个数的乘积数。

```sql
#这条语句会将 employees 中的 107条数据和 departments中的 27条数据进行笛卡尔积，会查询出2889条数据
SELECT employee_id,department_name
FROM employees,departments
```

**n个表实现多表的查询，则至少需要n-1个连接条件。**

正确的多表查询：

```sql
SELECT e.employee_id,e.last_name,d.department_name,l.city
FROM employees e,departments d,locations l
WHERE e.department_id = d.department_id 
AND d.location_id = l.location_id;
```

>从sql优化的角度，建议多表查询时，每个字段前都指明其所在的表。表名比较长时可以给表起别名，缩短sql语句

### 2.6.2 内连接和外连接

内连接：合并具有同一列的两个及以上的表，结果集中不包含和另一个表不匹配的行。使用 inner join ... on

外连接：两个表再连接过程中除了返回满足连接条件的行以外，还返回两个表中不满足条件的行。没有匹配的行时返回NULL 

- 左外连接：连接条件中左边的表称为主表，右边的表称为从表，使用 left join ... on
- 右外连接：连接条件中右边的表称为主表，左边的表称为从表，使用right join ... on 
- 满外连接：

```sql
#内连接，查询出106条数据
#INNER JOIN  INNER 可以省略
SELECT employee_id,department_name
FROM employees (INNER) JOIN departments
ON employees.department_id = departments.department_id

SELECT employee_id,department_name
FROM employees,departments
WHERE employees.department_id = departments.department_id

#外连接，查询出107条数据
SELECT employee_id,department_name
FROM employees LEFT JOIN departments
ON employees.department_id = departments.department_id
```

![sql-join](D:\学习笔记\java\sql-join.png)

上图中七种SQL JOINS的实现

```sql
#中图
SELECT employee_id,department_name
FROM employees e JOIN departments d
ON e.department_id = d.department_id;

#左上图 左外连接
SELECT employee_id,department_name
FROM employees e LEFT JOIN departments d
ON e.department_id = d.department_id;

#右上图 右外连接
SELECT employee_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.department_id = d.department_id

#左中图  左外连接只要左边为空的值
SELECT employee_id,department_name
FROM employees e LEFT JOIN departments d
ON e.department_id = d.department_id
WHERE d.department_id IS NULL

#右中图
SELECT employee_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL

#左下图 满外连接
#左上 UNION ALL 右中 或者 左中  UNION ALL 右上
SELECT employee_id,department_name
FROM employees e LEFT JOIN departments d
ON e.department_id = d.department_id
UNION ALL
SELECT employee_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL


#右下图
#左中 UNION ALL 右中
SELECT employee_id,department_name
FROM employees e LEFT JOIN departments d
ON e.department_id = d.department_id
WHERE d.department_id IS NULL
UNION ALL
SELECT employee_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL
```

### 2.6.3 SQL99 新特性

- NATURAL JOIN : 它会帮你自动查询两张表中所有相同的字段进行等值连接
- USING:括号里使用同名字段进行等值连接

### 补充： UNION 和 UNION ALL

UNION 操作符返回两个查询的结果集的并集，并且去重。

UNION ALL 返回两个查询的结果集的并集，不去重。

> 执行UNION ALL所需要的资源比 UNION少，如果明确无重复数据，或者不需要去重，推荐使用UNION ALL

## 2.7 函数

### 2.7.1 单行函数

- 操作数据对象

- 接受参数返回一个结果
- 只对一行进行变换
- 每行返回一个结果
- 可以嵌套
- 参数可以是一个值或者一个列

具体使用查表 

>MySQL中字符串顺序是从1开始的

### 2.7.2 多行函数（聚合函数）

聚合函数作用于一组数据，并对一组数据返回一个值。**MySQL中聚合函数不能嵌套**

1. 常用的聚合函数：AVG() / SUM() /  MAX() / MIN() / COUNT()

- AVG() 求平均值
- SUM() 求和
- MAX() / MIN()  求最大最小值
- COUNT()  求字段出现的个数

>1. 求表中有多少条记录可以使用
>
>COUNT(1)  COUNT(*)  不要使用具体字段，因为COUNT计算的是非空数值个数。
>
>2. 以上聚合函数进行计算时不考虑NULL
>3. avg = sum / count 

2. GROUP BY

>1. SELECT中出现的非组函数的字段必须声明在GROUP BY 中。反之不需要。
>
>2.  声明顺序FROM, WHERE , GROUP BY , ORDER BY ,  LIMIT 。
>3. 可以在GROUP BY 之后加上ROLLUP，效果是在结果最后加一行平均值。 **ROLLUP不能和ORDER BY 一起使用**

3. HAVING

使用的条件：

- 如果过滤条件中使用了聚合函数，必须使用HAVING来替换WHERE，否则报错。
- HAVING 使用必须放在 GROUP BY 之后。
- HAVING 一般不单独使用

>WHERE 和  HAVING 区别
>
>1. 从适用范围来看，having更广
>
>2. 当过滤条件中有聚合函数时，则此过滤条件必须声明在having中
>
>3. 当过滤条件中没有聚合函数时，则此过滤条件声明在where和having中都可以，但是where更快，更推荐
>
>   注：根据执行顺序来看，先执行where，相当于先过滤一部分数据，在进行其他操作。having 需要先进行分组，然后对分组进行判断过滤，执行时间更长。

### 2.7.3 SQL底层执行原理

#### 1. SELECT语句的完整结构

```sql
#SQL 92
SELECT ...,...,...(存在聚合函数)
FROM ...,...,...
WHERE 多表的连接条件 AND 不包含聚合函数的过滤条件
GROUP BY ...,...
HAVING 包含聚合函数的过滤条件
ORDER BY ...,... ASC/DESC
LIMIT ...,...

#SQL 99
SELECT ...,...,...(存在聚合函数)
FROM ... JOIN ... ON 多表的连接条件
WHERE 不包含聚合函数的过滤条件
GROUP BY ...,...
HAVING 包含聚合函数的过滤条件
ORDER BY ...,... ASC/DESC
LIMIT ...,...
```

#### 2. SQL语句的执行过程

![image-20221104173541436](D:\学习笔记\java\image-20221104173541436.png)

FROM--->ON---->LEFT/RIGHT JOIN---->WHERE---->GROUP BY ----> HAVING ---- > SELECT ----> DISTINCT ------> ORDER BY ----> LIMIT

## 2.8 子查询

```sql
SELECT employee_id,last_name
FROM employees
WHERE salary > (
	SELECT salary 
	FROM employees 
	WHERE last_name = "Abel"
)
```

如上代码，其中括号内的叫做子查询或者内查询，括号外面的叫做主查询或者外查询。子查询在主查询之前一次执行完成，子查询的结果被主查询使用。 其中，子查询要放在括号里面，而且需要放在比较条件的右侧。

### 2.8.1 子查询分类

1. 单行子查询与多行子查询：按照查询的结果返回一条还是多条记录，可以分为单行和多行子查询。
2. 相关子查询和非相关子查询：按照内查询是否被执行多次，可以分为相关和非相关子查询。
3. 子查询可以当作一张表使用。

### 2.8.2 单行子查询

```sql
# 查询工资大于"Abel"的员工的employee_id,last_name
SELECT employee_id,last_name
FROM employees
WHERE salary > (
	SELECT salary 
	FROM employees 
	WHERE last_name = "Abel"
)

# 查询工资大于149号员工的last_name,salary
SELECT last_name,salary
FROM employees
WHERE salary > (
	SELECT salary
	FROM employees 
	WHERE employee_id = 149
)

# 查询job_id和141号员工相等且工资大于143好员工的last_name,job_id,job_id
SELECT last_name,job_id,job_id
FROM employees
WHERE job_id = (
    SELECT job_id
    FROM employees
    WHERE employee_id = 141
)
 AND salary > (
     SELECT salary 
     FROM employees
     WHERE employee_id = 143
 )
							 
# 查询工资等于最低工资的员工的last_name,job_id,salary
SELECT last_name,job_id,salary
FROM employees
WHERE salary = (									 
    SELECT MIN(salary)
    FROM employees
)
			
# 查询manage_id,department_id同时等于141号员工的 employee_id,manager_id,department_id
SELECT employee_id,manager_id,department_id
FROM employees
WHERE manager_id = (
    SELECT manager_id
    FROM employees
    WHERE employee_id = 141
)
AND department_id = (
    SELECT department_id
    FROM employees
    WHERE employee_id = 141
)
AND employee_id <> 141

# 查询最低工资大于50号部门最低工资的部门id和最低工资
SELECT department_id,MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (
    SELECT MIN(salary)
    FROM employees
    WHERE department_id = 50
)
```

注：子查询返回为NULL时，整个查询结果也为空。

​		单行操作符 = > < <> 等不能操作多行数据。

### 2.8.3 多行子查询

多行操作符： IN   ANY  ALL

```sql
# 多行操作符直接放在子查询括号的前面就行

# IN 等于列表中的任意一个
# ANY 和单行比较操作符一起使用，和子查询返回的某一个值比较
# ALL 需要和单行比较操作符一起使用，和子查询返回的所有值比较
SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE job_id <> 'IT_PROG'
AND salary < ALL(
	SELECT salary
	FROM employees
	WHERE job_id = 'IT_PROG'
)	
```

### 2.8.4 相关子查询

```sql
# 查询员工中工资大于本部门平均工资的员工的last_name,salary和department_id
SELECT last_name, salary, department_id
FROM employees e1
WHERE salary > (
	SELECT AVG(salary)
	FROM employees e2
	WHERE e2.department_id = e1.department_id
)
```

## 2.9 创建和管理表

### 2.9.1 创建数据库

```mysql
# 方式一 隐式使用数据库默认的字符集
CREATE DATABASE mytest1;

# 方式二 显示指明字符集
CREATE DATABASE mytest2 CHARACTER SET 'gbk';

# 方式三 防止重复创建 推荐
CREATE DATABASE IF NOT EXISTS mytest1 CHARACTER SET 'UTF8';
```

### 2.9.2 管理数据库

```mysql
# 查看当前连接中的数据库
SHOW DATABASES;

# 切换数据库
USE 数据库名;

# 查看当前数据库下的数据表
SHOW TABLES;

# 查看当前使用的数据库
SELECT DATABASE();

# 查看指定数据库下保存表
SHOW TABLES FROM 数据库名;

# 修改数据库字符集
ALTER DATABASE 数据库名 CHARACTER SET 'UTF8'

# 删除数据库
DROP DATABASE IF EXISTS mytest1;
```

### 2.9.3 创建数据表

```mysql
# 方式一 
CREATE TABLE IF NOT EXISTS mytable1(
	id INT,
    name VARCHAR(15),
    hire_date DATE
);

# 方式二 基于现有的表创建新的表,会将原有表中的数据也复制过来
CREATE TABLE myemp1
AS
SELECT employee_id,last_name,salary
FROM employees;
```

### 2.9.4 管理数据表

```mysql
# 查看表结构
DESC 表名;

# 修改表
# 添加字段
ALTER TABLE 表名
ADD salary DOUBLE(10) [frist]

# 修改字段
ALTER TABLE 表名
MODIFY salary DOUBLE(20)

# 重命名字段
ALTER TABLE 表名
CHANGE salary my_salary VARCHAR(50)

#删除一个字段
ALTER TABLE 表名
DROP COLUMN my_salary

#重命名表
RENAME TABLE 表名
TO 表名2 

#删除表  删除表结构和数据
DROP TABLE IF EXISTS 表名

#清空表 只删除数据
TRUNCATE TABLE 表名
```

> modify和change区别：change可以修改表名称，而modify不可以，其他的都一样，在不修改名称的情况下，推荐使用modify

### 2.9.5 其他

#### 1. DELETE 和 TRUNCATE 区别

>相同点：都可以实现表中所有数据的删除，同时保留表结构
>
>不同点：DELETE FROM 一旦执行此操作，表数据全部清除，数据可以回滚
>
>​				TRUNCATE TABLE 一旦执行此操作，表数据全部清除，数据不可以回滚

#### 2. DDL 和 DML 的说明

> DDL 一旦执行，不可回滚
>
> DML操作默认 autocommit = true，设置为false，则可以回滚。

#### 3. DCL中COMMIT 和 ROLLBACK

> COMMIT： 提交数据，一旦执行，数据永久化，不可回滚
>
> ROLLBACK：回滚数据，数据回滚到最近一次COMMIT之后。

## 2.10 数据管理之增删改

>```mysql
>CREATE TABLE IF NOT EXISTS emp1(
>id INT,
>`name` VARCHAR(15),
>hire_date DATE,
>salary DOUBLE(10,2)
>);
>```

###  2.10.1 插入数据

```mysql
# 方式一 单条插入
# 未指明要添加的字段 一定要按照声明字段的先后顺序添加
INSERT INTO emp1
VALUES (1,'Tom','2000-12-21',3400)

# 声明添加的字段时，与声明顺序一致即可 （推荐）
INSERT INTO emp1(id,)
VALUES (1,'Tom','2000-12-21',3400)

#可以将多个插入语句合并，且效率更高
INSERT INTO emp1(id,salary,`name`)
VALUES 
(4,5000,'张'),
(5,4000,'瑞');

# 方式2 将查询数据插入到表中 查询的字段要与添加到的表字段类型一一对应
# 要插入表字段长度不能低于查询表字段长度，否则有添加不成功的风险
INSERT INTO emp1(id,`name`,salary,hire_date)
SELECT employee_id,last_name,salary,hire_date
FROM employees
WHERE department_id IN (60,70)
```

### 2.10.2 修改数据

```mysql
# UPDATE ... SET ... WHERE 
UPDATE emp1
SET hire_date = CURDATE(),salary = 5000
WHERE id = 4
```

### 2.10.3 删除数据

```mysql
# DELETE FROM ... WHERE ...
DELETE FROM emp1
WHERE id > 100
```

### 2.10.4 MYSQL8新特性 ：计算列

计算列： 某一列的数据通过别的列计算得来的。mysql 8.0 中，CREATE 和 ALTER 都支持增加计算列，

举例：定义表test1,定义id,a,b,c列 使得 c列 = a列 +  b列

```mysql
# GENERATED ALWAYS AS (计算公式) VIRTUAL
CREATE TABLE test1(
a INT,
b INT,
c INT GENERATED ALWAYS AS (a + b) VIRTUAL
);
```

# 3. 数据类型

## 3.1 整数类型

```mysql
#五种整型
CREATE TABLE demo(
	f1 TINYINT,
	f2 SMALLINT,
	f3 MEDIUMINT,
	f4 INT,
	f5 BIGINT
);

CREATE TABLE demo1(
	f1 UNSIGNED int,		#无符号数
	f2 int(5),
	f3 int(5) ZEROFILL		#最少显示五位，不够的前面用0填充
);
```

## 3.2 浮点类型

```mysql
CREATE TABLE demo2(
	f1 FLOAT(5,2),	#单精度 代表总共5位，三位整数，两位小数
	f2 DOUBLE	#双精度
);
```

> 1. FlOAT和DOUBLE区别：FLOAT占用字节数少，取值范围小；DOUBLE占用字节数多，取值范围多
>
> 2. 浮点数的无符号数范围和有符号数范围相同，因为无论有无符号，MySQL都会存储表示符号的部分。
>
> MySQL存储浮点数的格式为：符号（S）、尾数（M）、阶码（E）
>
> 3. 浮点数求和要注意误差问题，避免使用=判断两个浮点数是否相等。

## 3.3 定点数类型

```mysql
CREATE TABLE demo2(
	f1 DECIMAL(5,2),	#定点数类型
);
```

> 适用对于精度极高的场景，比如金额计算的场景。（阿里规范中，不推荐使用）

## 3.4 位类型

```mysql
CREATE TABLE demo2(
	f1 BIT(5),	#默认是1，取值范围是1-64，多少位二进制数，BIT(5)可以存储1-31
)
```

## 3.5时间日期类型

MySQL中支持YEAR，DATE，TIME，DATETIME，TIMESTAMP等类型。

```mysql
#YEAR,1个字节，用来表示年份，从1900-2155
#DATE,3个字节，用来表示时间年月日，格式YYYY-MM-DD
#TIME,3个字节，用来表示时间时分秒，格式HH:MM:SS
#DATETIME,8个字节，表示年月日时分秒，格式YYYY-MM-DD HH:MM:SS
#TIMESTAMP,4个字节，表示年月日时分秒，范围比DATETIME小  1970-01-01 00:00:01 UTC 到 2038-01-19 03:14:07UTC
```

> DATETIME和TIMESTAMP：
>
> 1. TIMESTAMP存储空间小，表示范围也小
> 2. 底层存储方式不同，TIMESTAMP存储的是毫秒值，距离1970-01-01 00:00:00毫秒的毫秒值
> 3. 比较大小或者日期计算时，TIMESTAMP更方便，更快
> 4. TIMESTAMP和时区有关，可以通过设置不同的时区来显示不同的结果。

## 3.6文本类型

```mysql
# char(M)  固定长度，0-255 占用M个字节 不指定M，默认M=1，不计算空格的长度
# varchar(M)  可变长度，0-65535  必须指定M，表示最多存储M个字符 占用实际长度+1个字节
# 汉字占一个字符，utfmb3占三个字节
# 固定长度或者长度极小时用char，其他情况用varchar

#TEXT 保存文本数据 TEXT和BLOB类型删除之后容易导致"空洞"，频繁使用的表不建议包含TEXT类型，可以分出取单独用一个表。
#分为TINYTEXT,TEXT MEDIUMTEXT,LONGTEXT 长度不同。

#ENUM 保存枚举类型，忽略大小写。可以使用索引进行枚举的调用
CREATE TABLE test_enum(
	season ENUM('春','夏','秋','冬','unknow')
)

INSERT INTO test_enum
VALUES('春'),(3),('UNKNOW'),(NULL)


#SET 插入重复的set类型字段时，会自动去重，插入set中不存在的字段时，会抛出错误。
```

## 3.7 二进制字符串类型和JSON类型

```mysql
# MySQL中的二进制类型用来存储图片，音频和视频等二进制数据。
# 主要包括BINARY,VARBINARY,TINYBLOB,BLOB,MEDIUMBLOB和LONGBLOB 
# 类比   CHAR,VARCHAR,TINYTEXT,TEXT,MEDIUMTEXT,LONGTEXT
#json类型存储json字符串，可以通过箭头的方式取出对于key的value

#注意 实际工作中，不会存储blob对象，而是会直接将文件上传到文件服务器，MySQL中只会存储url路径
```

## 3.8 小结（可以参考Java开发手册之MySQL数据库）

定义数据类型，字段如果非负数，必须用UNSIGNED。

如果是整数，定义int；如果小数，定义DECIMAL(M，D)，如果范围超过了DECIMAL的范围，建议将数据拆分成整数和小数分开存储；,如果是日期，定义DATETIME。字符串类型

字符串长度几乎相等(如电话号码)，使用CHAR定长

VARCHAR是可变字符串，长度不要超过5000，如果大于5000，定义字段类型位TEXT，独立出来一张表，用主键对应，避免影响其他的效率。

# 4. 约束

## 4.1 约束概述

> 数据完整性是指数据的精确性和可靠性。它是防止数据库中存在不符合语义规定的数据和防止因错误信息的输入输出造成无效操作或错误信息而提出的。
>
> 实体完整性：同一个表中，不能存在两条完全相同无法区分的记录
>
> 域完整性：性别范围 男/女
>
> 引用完整性：员工所在部门，在部门表中能找到这个部门
>
> 用户自定义完整性：用户名唯一，密码不能为空等

约束是表级的强制规定，可以在创建表时规定（create table）或者修改表时增加或修改约束（alter table）。*约束可以保证数据的完整性。*

约束的作用来分类 1.非空，2.唯一性，3.主键，4.外键，5.检查，6，默认值

```mysql
#查看约束代码
SELECT * FROM information_schema.TABLE_CONSTRAINTS
WHERE table_name = '表名称';
```



## 4.2 非空约束

作用：限制某个字段不能为空

```mysql
#NOT NULL 非空约束
#非空约束只能添加到表的列上
#空字符串不是NULL，0也不是NULL
CREATE TABLE test1{
	id INT NOT NULL,
	last_name Varchar(15) NOT NULL
} 
INSERT INTO test1(id,last_name) VALUES(1,NULL) #报错，cannot be NULL
```

## 4.3 唯一性约束

作用：用来限制某个字段不能重复（允许出现多个NULL值）

```mysql
#unique 唯一性约束
#唯一性约束可以添加到列上，也可以添加到表上
#创建唯一性约束的时候不命名，就默认和列明相同

CREATE TABLE test2(
	id INT UNIQUE,
	email VARCHAR(15),
    CONSTRAINT uk_test2_email UNIQUE(emial)
);

# 复合的唯一性约束		比如选课表中，学号和课程号唯一性约束
CREATE TABLE user(
	id INT UNIQUE,
	name VARCHAR(15),
    password VARCHAR(25),
	#表级约束 只有name和password同时相同，才会报错	
    CONSTRAINT uk_user_name_pwd UNIQUE(name,password)
);
```

> MySQL会给唯一性约束的列上默认创建一个唯一索引
>
> 删除唯一性约束只能通过删除唯一索引的方式删除
>
> 删除时需要指定唯一索引名，唯一索引名就是唯一约束名

## 4.4 主键约束

作用：用来唯一标识表中的一行记录

```mysql
#primary key 主键约束 = 唯一约束+非空约束
#一个表只能有一个主键约束，主键约束可以是一列或者多列的组合，复合主键每一列都不能为NULL
#主键约束的名称是PRIMARY,自己命名无效

CREATE TABLE test3(
	id INT PRIMARY KEY,
	last_name VARCHAR(15)
)
```

## 4.5 自增约束

作用：某个字段的自增

```mysql
# 一个表只能有一个自增列，一般设置为主键
# 自增列必须是整数类型
# 当我们向主键（自增）的字段上添加0或者NULL时，实际上会自动增加，实际开发中，不给主键字段赋值即可
# 如果指定了不存在的值，如10，-10等，会直接插入

CREATE TABLE test3(
	id INT PRIMARY KEY AUTO_INCREMENT,
	last_name VARCHAR(15)
)
```

> MySQL5.7 新增id=12345,删除掉45之后，在插入，自增为6，但是如果重启服务，那么自增为4，
>
> 这是因为MySQL5.7对于自增主键的分配规则，是由InnoDB数据字典内部的一个计数器来决定的，而该计数器只在内存中维护，并不会持久化到磁盘中，当数据库重启时，该计数器会被初始化。
>
> 而MySQL8.0自增新特性----自增持久化，将自增主键的计数器持久化到日志中，每次的变化都会写入日志，重启服务时，InnoDB会根据重做日志中的信息来初始化计数器的内存值。还是上面的例子，8.0重启后，自增为6

## 4.6 外键约束

作用：限定某个表的某个字段的引用完整性。（实际开发中不用）

```mysql
# 1.从表的外键列，必须引用主表的唯一约束列/主键
# 2.创建表时指定外键约束的话，先创建主表，再创建从表
# 3.删除表时，先删除从表，再删除主表
# 4.主表数据被从表参照时，不允许删除，必须先删除从表的引用，才能删除主表的约束
# 5.在从表指定外键约束，一个表可以指定多个外键约束
# 6.从表的外键列和主表的列名字可以不同，但是数据类型必须一样。
# 7.创建外键约束时，系统会默认给所在的列建立对应的普通索引。
# 8.删除外键约束后，必须手动删除外键的索引

#外键约束，最好采用级联更新：ON UPDATE CASCADE ON DELETE RESTRICT
#添加这个之后，更新主表，会自动更新从表的数据，限制删除主表数据
```

## 4.7 CHECK约束（8.0）

作用：检查某个字段的值是否符合要求，一般指的是值的范围。

```mysql
CREATE TABLE test3(
	id INT PRIMARY KEY AUTO_INCREMENT,
	last_name VARCHAR(15),
	salary DECIMAL(10,2) CHECK(salary > 2000)
)
```

## 4.8 默认值约束

作用：给某个字段默认值，一旦设置了默认值，插入数据时没有显示赋值，则赋值为默认值

```mysql
# 默认值约束 DEFAULT

CREATE TABLE test3(
	id INT PRIMARY KEY AUTO_INCREMENT,
	last_name VARCHAR(15),
	salary DECIMAL(10,2) DEFAULT 2000		#插入不输入salary,会插入默认值2000
)
```

# 5.视图

视图是一种虚拟表，本身是不具有数据的，占用空间少。可以理解为**存储起来的SELECT语句**。

视图建立在已有表的基础上，视图赖以建立的表称为基表。

视图的创建和删除只影响视图本身，不影响相应的基表。但是增删改操作，基表中的数据会随之改动，反之亦然。

## 5.1 操作

```mysql
# 创建视图
CREATE VIEW vu_emp2(id,name,salary)	# 视图中的字段名称方式一 名称列表
AS  
SELECT employee_id id,last_name,salary	#视图中的字段名方式二 别名
FROM employees;

SELECT * FROM vu_emp2;
#视图中的字段基表中没有

#利用视图进行数据格式化 产生 张三(a部门) 格式的数据
CREATE VIEW vu_emp_dept 
AS
SELECT CONCAT(e.last_name,'(',d.department_name,')') emp_info
FROM employees e JOIN departments d
ON e.department_id = d.department_id;

SELECT * FROM vu_emp_dept;


#查看视图
SHOW TABLES;
#查看视图的结构
DESC vu_emp1;
#查看视图的属性信息
SHOW TABLE STATUS LIKE 'vu_emp1'\G
查看视图的详细定义信息
SHOW CREATE VIEW vu_emp1


#更新视图中的数据
SELECT * FROM vu_emp2;

SELECT employee_id id,last_name,salary
FROM employees;
#更新视图中的数据会导致表中的数据修改，反之亦然 更新=增删改
UPDATE vu_emp2
SET salary = 20000
WHERE id = 101;

#不能更新的场景，很多

#修改视图
ALTER VIEW vu_emp1
AS
SELECT * FROM employee;

#删除视图  如果基于A创建的视图B，那么A不能直接删除
DROP VIEW vu_emp1;
```

## 优缺点

视图的优点：1.操作简单，2.减少数据冗余，3.数据安全，4.适应灵活多变的需求 5.能够分解复杂的查询逻辑

使徒的不足：可读性差，维护成本高。

# 6.存储过程与函数

存储过程：就是一组经过预先编译的sql语句的封装。

执行过程：存储过程预先存储在 MySQL 服务器上，需要执行的时候，客户端只需要向服务器端发出调用

存储过程的命令，服务器端就可以把预先存储好的这一系列 SQL 语句全部执行。

> 存储过程与视图，函数的对比：
>
> 它和视图有着同样的优点，清晰、安全，还可以减少网络传输量。不过它和视图不同，视图是 虚拟表 ，
>
> 通常不对底层数据表直接操作，而存储过程是程序化的 SQL，可以 直接操作底层数据表 ，相比于面向集
>
> 合的操作方式，能够实现一些更复杂的数据处理。
>
> 一旦存储过程被创建出来，使用它就像使用函数一样简单，我们直接通过调用存储过程名即可。相较于
>
> 函数，存储过程是 没有返回值 的。

## 6.1 操作

```mysql
#创建存储过程
#1. BEGIN…END：BEGIN…END 中间包含了多个语句，每个语句都以（;）号为结束符。
#2. DECLARE：DECLARE 用来声明变量，使用的位置在于 BEGIN…END 语句中间，而且需要在其他语句使用之前进行变量的声明。
#3. SET：赋值语句，用于对变量进行赋值。
#4. SELECT… INTO：把从数据表中查询的结果存放到变量中，也就是为变量赋值。
#5. DELIMITER 新的结束标记 避免和mysql中结束语句;冲突
DELIMITER $
CREATE PROCEDURE 存储过程名(IN|OUT|INOUT 参数名 参数类型,...)
[characteristics ...]
BEGIN
sql语句1;
sql语句2;
END $

DELIMITER //
CREATE PROCEDURE show_min_salary(OUT ms DOUBLE)
BEGIN
SELECT MIN(salary) INTO ms FROM employees;
END //
DELIMITER ;

#调用存储过程，使用Call
CALL show_min_salary(@min);
SELECT @min;

#删除
DROP PROCEDURE show_min_salary


#存储函数
DELIMITER //
CREATE FUNCTION email_by_id(emp_id INT)
RETURNS VARCHAR(25)
DETERMINISTIC
CONTAINS SQL
BEGIN
RETURN (SELECT email FROM employees WHERE employee_id = emp_id);
END //
DELIMITER ;
#调用
SET @emp_id = 102;
SELECT email_by_id(102);

```

## 6.2 优缺点

**优点：**

**1、存储过程可以一次编译多次使用。**存储过程只在创建时进行编译，之后的使用都不需要重新编译，

这就提升了 SQL 的执行效率。

**2、可以减少开发工作量。**将代码 封装 成模块，实际上是编程的核心思想之一，这样可以把复杂的问题

拆解成不同的模块，然后模块之间可以 重复使用 ，在减少开发工作量的同时，还能保证代码的结构清

晰。

**3、存储过程的安全性强。**我们在设定存储过程的时候可以 设置对用户的使用权限 ，这样就和视图一样具

有较强的安全性。

**4、可以减少网络传输量。**因为代码封装到存储过程中，每次使用只需要调用存储过程即可，这样就减

少了网络传输量。

**5、良好的封装性。**在进行相对复杂的数据库操作时，原本需要使用一条一条的 SQL 语句，可能要连接

多次数据库才能完成的操作，现在变成了一次存储过程，只需要 连接一次即可 。

**缺点：**

**1、可移植性差。**存储过程不能跨数据库移植，比如在 MySQL、Oracle 和 SQL Server 里编写的存储过

程，在换成其他数据库时都需要重新编写。

**2、调试困难。**只有少数 DBMS 支持存储过程的调试。对于复杂的存储过程来说，开发和维护都不容

易。虽然也有一些第三方工具可以对存储过程进行调试，但要收费。

**3、存储过程的版本管理很困难。**比如数据表索引发生变化了，可能会导致存储过程失效。我们在开发

软件的时候往往需要进行版本管理，但是存储过程本身没有版本控制，版本迭代更新的时候很麻烦。

**4、它不适合高并发的场景。**高并发的场景需要减少数据库的压力，有时数据库会采用分库分表的方

式，而且对可扩展性要求很高，在这种情况下，存储过程会变得难以维护， 增加数据库的压力 ，显然就

不适用了

# 7.触发器

## 7.1 操作

```mysql
DELIMITER //
CREATE TRIGGER emps_insert_trigger
AFTER INSERT ON emps
FOR EACH ROW
BEGIN
	INSERT INTO emps_back(employee_id,last_name,salary)
	VALUES(NEW.employee_id,NEW.last_name,NEW.salary);
END //
DELIMITER;

SHOW TRIGGERS;
```



## 7.2 优缺点

优点:

1. 触发器可以确保数据的完整性
2. 触发器可以帮助我们记录日志
3. 触发器还可以在操作数据前，对数据进行合法检查。

缺点：

1. 可读性差，可能不受应用层控制，维护困难。
2. 相关数据的变更可能回导致触发器出错。





































