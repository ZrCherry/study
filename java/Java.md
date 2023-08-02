# 1. Java语言概述

## 1.1 Java概述

1. JDK与JRE

- ​	JDK（Java Development Kit）：是Java程序开发工具包，包含JRE和开发人员使用的工具。
- ​	JRE （Java RuntimeEnvironment）：是Java程序运行的运行时环境，包含JVM和运行时需要的核心类库。

2. JDK版本  （选择长期维护版本 8.0 ,11.0,17.0）
3. 优缺点

​	3.1 优点

- 跨平台性：这是Java的核心优势，通过Java语言编写的应用程序可以在不同的操作系统上运行。只是需要在Java应用程序的操作系统上安装一个Java虚拟机，由JVM来负责程序的运行。

- 面向对象：Java是面向对象的程序设计技术，支持封装，继承，多态等特性，让程序更好的高内聚，低耦合。

- 健壮性：提供了一个相对安全的内存管理和访问机制。

- 安全性高：Java适合于网络/分布式环境，需要提供一个安全机制以防恶意代码的攻击。如：安全防范机制（类加载器），可以分配不同的命名空间以防本地的同名类，字节代码检查。

- 简单性：Java就是C++语法的简化版，去掉了头文件，指针，结构，联合，操作符重载，虚基类等。

- 高性能：Java语言在发展过程中通过虚拟机的优化提升了运行效率。比如，通过JIT即时编译技术提高运行效率。

  >拥有大量的社区和开源库，方便开发。

​	3.2 缺点：

- 语法过于复杂，严谨，对程序员约束较多。
- 一般用于大型网站开发，整个架构会比较重。
- 并非适用于所有领域，比如Objective C,Swift在iOS设备上有无可替代的地位，Windows程序通常用C++或者C#编写。Java在服务端编程和跨平台应用领域则很有优势。

## 1.2 编译运行

Java程序编写和执行的过程：

1. 编写，将Java代码写在.java结尾的文件中
2. 编译，正对.Java结尾的源文件进行编译操作，生成一个或多个.class结尾的字节码文件，每一个字节码文件对应一个类（字节码文件内容不包含注释信息）。  格式：javac 源文件名.java
3. 运行，针对与编译后生成的字节码文件，进行解释运行。格式：java 字节码文件名

## 1.3 注释

Java注释分为单行注释，多行注释，文档注释，编译时跳过注释。

```Java
//这是单行注释

/*
这是多行注释	不能嵌套使用
*/

/**
这是文档注释，可以被JDK提供的工具Javadoc所解析，生成一套网页文件形式体现的该程序的说明文档。
*/
```

 # 2. Java基础语法

## 2.1 标识符

标识符就是自己定义的名称。比如，类名，方法名，变量名，包名等等。

1. 标识符的命名规则：

- 标识符由26个英文字母大小写，0-9，_或$组成
- 不能以数字开头       //比如  int 123L = 12;  long l = 123L 有歧义
- 不能包含关键字和保留字，可以包含
- Java严格区分大小写，长度无限制
- 标识符不能包含空格

2. 标识符的命名规范:

- 包名：多单词组成时所有字母都小写。如Java.lang / com.xx.yy等
- 类名，接口名：多单词组成时，所有单词的首字母大写。如HelloWorld，String等
- 变量名，方法名：多单词组成时，第一个单词首字母小写，第二个单词开始首字母大写。如：bookName，userName等
- 常量名：所有字母都大写，多单词时每个单词之间用下划线连接。如MAX_VALUE,MIN_VALUE等。

## 2.2 变量

变量的概念：变量是内存中的一个存储区域，该区域的数据可以在同一类型范围内不断变化。

变量的作用：用于内存中存储数据。

使用变量需要注意： 1. Java中变量是强类型，必须先声明，后使用

​									2. 变量名要遵循标识符的命名规则

​									3. 在同一个作用域内，不能声明两个同名的变量

```java
//数据类型 变量名 = 变量值
int a = 1;
```

数据类型分类：

1. 基本数据类型：
   - 整型：byte(1) / short(2) / int(4) / long(8)
   - 浮点型：float(4) / double(8)
   - 字符型：char(2)
   - 布尔型：boolean (4)     内存分配四个字节。

2. 引用数据类型：
   - 数组 (array)
   - 接口（interface）
   - 类（class）

```java
// 可以表示数值范围  低--------------------高
byte,short,char ---> int ---> long ---> float ---> double
    
//从低到高，自动类型转换。
//从高到低，强制转换。 强制转换可能造成精度丢失(截断而不是四舍五入)。
//byte,short,char 类型之间变量运算，结果要用int接收
    byte b= 10;
	int a = b + 1;
```

## 2.3 运算符

运算符按照功能可以分为：算术运算符，赋值运算符，比较运算符，逻辑运算符，位运算符，条件运算符，Lambda运算符

运算符按照操作数的个数可以分为：一元运算符，二元运算符，三元运算符。

### 2.3.1 算术运算符

算术运算符： +(正，加，连接) - * / % ++(前++，++后)  --(前--，--后)

```java
int a = 2;
int b = 3;
int c;
c = a + b;	//+ - * / %
c = a++;
c = --a;
        

int m = 2;
m = m++;     //2        1. 将m的值2取出来放入操作数栈中，2.m++，m=3,3.把操作数栈中的2赋值给m m=2

int k = 2;
k = ++k;	//3 		1.先++操作得到k=3放入操作数栈中，2.拿出操作数栈中的3赋值给k
```

> ++ 和 +1 的小区别
>比如 short a = 1;
>
>a = a+1;   编译报错，返回类型应该位int
>
>a++ ;	成功

### 2.3.2 赋值运算符

符号：=， 扩展 += ，-=，*=，/=，%=

```java
int i = 1;
byte b = (byte)i;	//当 = 两侧数据类型不一致，需要进行类型转换。
i += 5；		// i=i+5  其余类似 区别同上。

int n = 10;
n += (n++) + (++n)	// n = n + (n++) + (++n) = 10 + 10 + 12 = 32
```

### 2.3.3 比较运算符

符号：==，!= ，> ，< ，>= ，<= ，instanceof

### 2.3.4 逻辑运算符

符号: &   &&   |   ||  ！ ^

>区别&和&&
>
>相同点：两个符号都是且的关系。
>
>不同点：&&前的条件为false，后面的条件不运行。而&两边的条件都要运行

### 2.3.5 位运算符

符号： <<   >>  >>>   &   |   ^   ~

```
<< 左移，末位补0
>> 右移，正数高位补0，负数高位补1
>>> 无符号右移，  高位补0
& 与运算
| 或运算
^ 异或运算
~ 取反运算
```

> 交换a,b的值，不新增变量。
>
> a = a + b;  b = a - b; a = a - b;

### 2.3.6 条件运算符

符号：A ? B : C

A true 返回B，A false 返回C。

## 2.4 流程控制语句

流程控制语句是用来控制语句执行顺序的语句，在程序设计中分为三种结构：

- 顺序结构
  - 程序从上到下逐步执行，中间没有任何跳转和判断。

- 分支结构
  - 根据条件，选择性的执行某段代码
  - 有if...else...和switch-case语句

  >switch-case: 
  >
  >case穿透，没有break，会执行匹配到的case之后的所有语句。
  >
  >```java
  >//几月几日是今年的第几天
  >		
  >int mouth = 12;
  >int day = 20;
  >int sumDays = 0;
  >switch (mouth){
  >    case 12:
  >    sumDays += 30;
  >    case 11:
  >    sumDays += 31;
  >    case 10:
  >    sumDays += 30;
  >    case 9:
  >    sumDays += 31;
  >    case 8:
  >    sumDays += 31;
  >    case 7:
  >    sumDays += 30;
  >    case 6:
  >    sumDays += 31;
  >    case 5:
  >    sumDays += 30;
  >    case 4:
  >    sumDays += 31;
  >    case 3:
  >    sumDays += 28;
  >    case 2:
  >    sumDays += 31;
  >    case 1:
  >    sumDays += day;
  >}
  >System.out.println(sumDays);
  >```
  
- 循环结构
  - 根据循环条件，重复性的执行某段代码
  
  - 有for，while，do-while三种
  
    > 有明显的循环次数用for，没有明显的循环次数用while，如果循环体至少执行一次用do-while。	

# 3. Java面向对象

## 3.1 面向对象概述

面向对象，是软件开发中的一种变成风格，开发范式。除了面向对象，还有面向过程，指令式编程和函数式编程。我们接触最多的就是面向过程和面向对象。

1. 面向过程的程序设计思想，简称POP
   - 关注的是过程：过程就是操作数据的步骤。
   - 典型的语言：C语言
   - 代码结构：以函数为单位
   - 是一种执行者思维，适合坚决简单问题。扩展能力差，后期维护难度较大。	

2. 面向对象的程序设计思想，简称OOP
   - 关注的是类：在计算机程序设计中，参照现实中的事物，将事物的属性特征，行为特征抽象出来，用类来表示。
   - 典型的语言：Java，C++，PHP等
   - 代码结构：以类为单位，每个类有自己的属性和方法。
   - 是一种设计者思维，适合解决复杂问题。代码扩展性强，维护度高。		

## 3.2 Java语言的基本要素：类和对象

类和对象是面向对象的核心概念。

- 类：具有相同特征的事物的抽象描述，是抽象的，概念上的定义。
- 对象：实际存在的该类事物的每个个体，是具体的，因而也称为实例。

> 类 ===》抽象概念的人； 对象===》实实在在的你我他。

类的内部成员：

- 属性：该类事物的状态信息。对应类中的成员变量
- 方法：该类事物要做什么操作。对应类中的成员方法。
- 构造器：初始化对象
- 代码快：初始化复杂操作的对象
- 内部类：

### 3.2.1 属性

成员变量   VS   局部变量

1.相同点

变量声明的格式相同： 数据类型 变量名 = 变量值

变量都有其作用域，出了作用域无效

变量必须先声明，后赋值，再使用。

2.不同点

1.在类中声明的位置不同：

​	属性：声明在类内，方法外的变量

​    局部变量：声明方法，构造器内部的变量

2.在内存中分配的位置不同

​	属性：随着对象的创建，存储在堆中

​	局部变量：存储在栈空间中。

3.生命周期

​	属性：随着对象的创建而创建，随着对象的消亡而消亡

​	局部变量：随着方法对应的栈帧入栈，局部变量会在栈中分						配。随着方法出栈而消亡。

4.作用域

​	属性：在整个类的内部都是有效的

​	局部变量：仅限于局部变量所在的方法。

5.是否可以有权限修饰符修饰

​	属性：public/protected/默认/private

​	局部变量：不能使用。

6.是否有默认值

​	属性：都有初始化默认值

​	局部变量：都没有默认初始化值

属性的赋值：

1.默认初始化

2.显示初始化或代码块初始话   谁先执行谁

3.构造器初始化

4.对象.属性初始化

### 3.2.3 方法

封装方法的目的是实现代码复用，减少代码冗余，简化代码。Java里面方法必须定义在类中。

Java中的方法，不调用不执行，方法可以调用其他方法或者自己本身。方法顺序可以随意。

```java
权限修饰符  返回值类型 方法名（形参列表） [throws 异常类型]{
    //方法体
}

方法的调用： 方法名。
```

1.方法的重载

​	定义：在一个类中，允许存在一个以上的同名方法，只要他们的				参数列表不同即可，这样的多个方法，彼此之间构成方法				的重载。**1.参数个数不同，2.参数类型不同**（方法重载与				形参名称无关）

2.可变个数参数

​	格式： （参数类型  ...参数名）

- 可变参数的方法在调用时，正对可变参数的类型可以赋予0个，1	个，多个。
- 可变参数的方法在同一个类中，同名的多个方法可以构成重载
- 可变参数的方法和同一个类中另一个方法同名，编译器会优先寻找确定的方法。最后再找可变参数的方法。
- 如果有多个参数，那么可变形参必须放在参数列表最后一个，且只能有一个可变参数。

3.方法的值传递机制 -------- 值传递

- 如果是基本数据类型变量，则将此变量保存的数据值传递出去
- 如果是引用数据类型变量，则将此变量保存的地址值传递出去

4.方法的重写

方法重写是基于继承的，子类继承父类之后，获取了父类中所有的方法，但是可能不满足子类的要求，所以需要对父类的方法进行重写，覆盖。

- 父类被重写的方法与子类重写的方法名称，形参列表碧血相同
- 子类重写的方法的权限修饰符不小于父类呗=被重写方法的权限修饰符
- 父类冲写的方法返回值类型是void或者是基本数据类型，子类重写的方法返回类型必须保持一致
- 父类冲写的方法返回值类型是引用类型，子类返回值类型可以是父类返回值类型的子类。
- 子类重写方法的抛出类型可以是父类方法抛出异常的子类。

## 3.3 关键字package，import

package包的作用：

- 可以包含类和子包，划分项目层次，便于管理
- 帮助大型软件系统，将相同的功能划分到一个包里面，例如MVC
- 解决类命名冲突问题
- 控制访问权限

import 用来引入其他包中的类，当前包下的类互相调用不需要导包。

## 3.4 面向对象的特点

1.封装性

封装就是把客观事物封装成抽象概念的类，并且类可以把自己的数据和方法只向可信的类或者对象开放，像没必要开放的类和对象隐藏信息。Java通过**权限修饰符**来修饰类及类的内部成员，实现封装性。

> 4种权限修饰符 private  缺省  protected  public 修饰访问范围
>
> private:  本类内部
>
> 缺省：	本包内部
>
> protected： 其他包的子类
>
> public： 所有包的类

2.继承性 extends

- 自上而下，定义了一个A类，在定义另一个类B时与A类相似，考虑B继承A。
- 自下而上，定义了B，C，D类，发现他们有相似的部分，可以把公共类抽取出来定义为一个A类，B，C，D类继承与A类。

继承的好处：

1. 减少了代码冗余，提高了代码的复用性
2. 有利于功能的扩展
3. 为多态的使用提供了前提

继承的作用：

- 子类可以获取父类所有的属性和方法
- 子类可以扩展自己的特有的属性和方法。
- Java中的所有类的父类 Java.lang.Object类。

>Java只能单继承，一个类只能有一个父类，不可以有多个父类。
>
>Java支持多层继承，A继承B，B继承C。

3.多态性

多态性可以理解为一个事物的多种形态。适用于方法，不适用于属性。使用前提，要有类的继承和方法重写。

父类  名称  =  new  子类（）；

不能调用子类特有的属性和方法。要想调用需要强转成子类。在强转之前，可以使用instanceof进行类型判断。

优点：

- 减少代码冗余，不需要定义多个重载的方法。

## 3.5 关键字this和super

this：

this 针对于方法内部的非静态方法， 对应当前对象。一般情况下，在方法内调用a的属性或者方法时，可以使用this.方法/属性，但是这里this一般省略，只有在方法的形参和对象的属性同名的特殊情况下，才用this.属性 进行区分，使用this的变量为属性，没有this的为形参。

this可以调用构造器，必须把this语句写在第一行语句，且只能声明一个。 this(形参列表)的方式调用。

super：

super的作用： 用于区分父类和子类的方法和属性，并且可以在子类中调用父类的属性和方法。this.属性/方法，调用自身类的。super.属性/方法调用父类的方法 不写默认为this。

## 3.6 Object类

java.lang.Object是类层次结构的根类，即所有其他Java类的父类，Object类中声明的属性/方法具有通用性。

- Object类没有声明属性
- Object类提供了一个空参构造器。
- Object提供了许多方法：  clone，equals， finalize ，toString，getClass, hashCode, notify , notifyAll ,wait

1.equals()方法：

自定义的类如果没有重写equals方法，那么调用的是Object类中的equals方法，相当于==，判断的是两个对象的地址。

对于String，File，Date和包装类等，它们都重写了equals方法，用于比较两个对象的内容是否相等。

> 区分 ==  和 equals()
>
> ==运算符
>
> 1.使用范围：基本数据类型，引用数据类型
>
> 2.基本数据类型，判断数据值是否相等
>
> 3.引用数据类型，比较两个引用变量的地址值是否相等。
>
> equals()
>
> 适用范围：只能使用在引用数据类型。
>
> 具体使用：重写与否，判断的东西不一样。如果没有重写equals方法，那么调用的是Object类中的equals方法，相当于==，判断的是两个对象的地址

2.toString()

自定义的类，如果没有重写Object的toString(),默认返回的是当前对象的地址值。

对于String，File，Date和包装类等，它们都重写了toString()方法，返回当前对象的实体内容。

## 3.7 static

如果想让一个成员变量或者成员方法被类的所有实例所共享，就用static修饰即可，称为类变量/类方法。

static可以修饰属性，方法，代码快，内部类。（除了构造器的所有）被static修饰的东西，整个类共用。

在类的非静态方法中，可以调用当前类的静态和非静态属性/方法。反之不行。非静态方法调用金

***静态方法不能重写。*** 父类和子类可以有同名的静态方法，但是不是重写，没有多态性。

> 静态变量 VS 实例变量
>
> |          | 静态变量                         | 实例变量                 |
> | -------- | -------------------------------- | ------------------------ |
> | 个数     | 内存空间中只有一个，多个实例共享 | 每个实例一个             |
> | 内存位置 | 存放在堆空间，                   | 存放在堆空间的对象实体中 |
> | 加载时机 | 随着类的加载而加载               | 随着对象的创建而加载     |
> | 调用者   | 类，对象                         | 对象                     |
> | 消亡时机 | 随着类的消亡而消亡               | 随着对象的消亡而消亡     |

## 3.8 final

final 最终的，最后的，final修饰的类，方法，变量。

final修饰类，类不能被继承，如String类；修饰方法不能重写；如Object类的getClass()方法；修饰变量不能修改值，此时的变量就是变成了常量。

## 3.9 abstract

abstract可以修饰类，方法

1.abstract修饰类，此类称为抽象类，不能实例化，抽象类包含构造器，子类实例化时调用，抽象类可以没有抽象方法。

2.abstract修饰方法，此方法称为抽象方法，抽象方法只有声明没有方法体{}，抽象方法的功能时确定的，只是没有实现，子类必须重写父类所有的抽象方法之后才可实例化，否则，子类仍然是一个抽象类。

## 3.10 interface

interface接口的本质是规范，制定好规范之后大家都要遵守。

可以声明属性，方法(可以省略修饰，默认有)，没有构造器，代码块。
修饰属性，public static final.
修饰抽象方法：public abstract

类可以实现多个接口，单继承多实现。接口可以多继承。

> 抽象类和接口的区别：
>
> | NO.  | 区别点   | 抽象类                                   | 接口                                 |
> | ---- | -------- | ---------------------------------------- | ------------------------------------ |
> | 1    | 定义     | 可以包含抽象方法的类                     | 主要是全局常量和抽象方法的集合       |
> | 2    | 组成     | 构造方法，抽象方法，普通方法，常量，变量 | 常量，抽象方法，默认方法，静态方法   |
> | 3    | 使用     | 继承                                     | 实现                                 |
> | 4    | 关系     | 抽象类可以实现多个接口                   | 接口不能继承抽象类，可以继承多个接口 |
> | 5    | 设计模式 | 模板模式                                 | 简单工厂，工厂方法，代理模式         |
> | 6    | 对象     | 都通过对象的多态性实例化对象             |                                      |
> | 7    | 局限     | 单继承限制                               |                                      |
> | 8    | 实际     | 作为一个模板                             | 作为一个标准                         |
> | 9    | 选择     | 优先使用接口，避免单继承局限             |                                      |

# 4.异常处理

## 4.1 异常概述

异常：指的是程序在执行过程中，出现的非正常情况，如果不处理最终会导致JVM的非正常停止。

> 异常指的不是语法错误和逻辑错误。

异常的抛出机制，一旦发生异常，就会创建该异常的对象，throw抛出异常，程序员进行catch捕获。 

异常的体系结构：

java.lang.Throwable:异常体系的根父类

			- Java.lang.Error:错误，Java虚拟机无法结局的严重问题，如：虚拟机内部错误，资源耗尽等。
   - java.lang.Exception：异常，可以针对代码进行处理。
     - 编译时异常：javac.exe编译时出现的异常
     - 运行时异常：java.exe运行时出现的异常

## 4.2 常见的异常

1.常见的运行时异常 ---不用异常处理，直接修改代码

- ArrayIndexOutOfBoundsException 数组越界
- NullPotionerException 空指针异常
- ClassCastExeption 强制转换异常
- NumberFormatException 数值转换异常（123s 转换为int）
- InputMismatchException 输入不匹配异常（scanner.nextInt 输入了s）
- ArithmeticException 算术异常（0做被除数）

2.常见的编译时异常(可以加上try-catch)  不处理编译不通过

- ClassNotFoundException
- FileNotFoundException
- IOException

## 4.3 异常处理的方式

方式一：try-catch-finally

```java
try{
	//可能发生异常代码
}catch(异常1 e){
	//异常1时的处置措施
}catch(异常2 e){
	//异常2时的处置措施
}finally{
	//无论是否发生异常，都会执行的语句
   	//特殊，若system.exit(0)系统退出，则不会执行finally
}

/*
  *结果
  	try
	2
	finally
	1
*/


 public int yichang(){
     int i = 1;
     try {
         System.out.println("try");
         //System.exit(0);
         return i++;
     }catch (Exception e){
         System.out.println("catch");
         return -1;
     }finally{
         System.out.println(i);
         System.out.println("finally");
     }
 }


```

catch中处理异常的方式：

1.自己编写的代码

2.printStackTrace()方法（推荐二）	打印错误堆栈信息

3.getMessage()方法	

什么样的代码一定要卸载finally里面呢

- 开发中的一些资源（输入输出流，数据库连接，socket连接等），使用完成之后，必须显示的调用关闭操作，否则GC不会自动回收这些资源，而造成内存泄漏。为了保证这些资源使用完成之后能够保证关闭，就卸载finally里面就行。

方式二：throws + 异常类型

```java
public void method1() throws e1,e2{
	//可能异常代码
}

public void method(){
    //这里调用有异常的方法可以继续把异常往出抛，也可以try-catch彻底解决
    method1();	
}
```

throws的方式并未真正处理异常，try-catch才是真正的牛啊。

> throw和throws区别
>
> throw在方法内。后跟对象抛出异常，throws在方法定义上，后跟异常类型

# 5.多线程

## 5.1 概述

- 程序：为完成特定任务，用某种语言编写的一组指令的集合。

- 进程：正在运行中的应用程序。

  - 每个进程都有一个独立的内存空间，系统运行一个程序就是一个进程从创建，运行，消亡的过程
  - 程序时静态的，进程时动态的
  - 进程时操作系统调度和分配资源的最小单位。
  - 现在的系统支持多进程

- 线程：进程可以进一步细化为线程，是程序内部的一条执行路径，一个进程至少有一个线程。

  - 一个进程同时可以运行多个线程
  - 线程是CPU调度和执行的最小单元
  - 一个进程中的多个线程共享相同的内存单元，它们从一个堆中分配对象，可以访问相同的
  - Java中线程共享的是方法区和堆

  > 不同进程之间不共享内存
  >
  > 进程之间的数据交换和通信成本很高

  优点：

  1. 提高应用程序的响应
  2. 提高CPU的利用率
  3. 改善程序结构，将复杂的进程细分为多个线程，独立运行，利于理解和修改

  > 并行和并发
  >
  > 并行：多个指令在同一时刻在多个CPU发生。
  >
  > 并发：多条指令在单个CPU上快速轮换交替运行。

## 5.2 线程的创建方式

1.继承Thread类

```java
/**
1.创建一个继承于thread的子类
2.重写run()方法
3.创建子类对象
4.通过对象调用start()
*/

public class EvenNumberThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            if (i % 2 == 0){
                System.out.println(i + Thread.currentThread().getName());
            }
        }
    }
}

@Test
public void test4(){
    EvenNumberThread thread1 = new EvenNumberThread();
    thread1.start();
    for (int i = 1; i < 1000; i++) {
        if (i % 2 == 0){
            System.out.println(i + Thread.currentThread().getName());
        }
    }
}
//注意：
/*
1.run()方法不能替换start（），不能启动线程
2.不能用一个对象启动两次线程，否则报异常，
*/
```

2.实现Runnable接口，实现run()方法

```java
/*
1.创建一个实现Runnable接口的实现类
2.实现run()方法
3.创建当前类的对象
4.将此对象传递到Thread类的构造器中，创建Thread类的实例
5.通过此实例来调用start()方法。
*/

public class EvenNumberThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            if (i % 2 == 0){
                System.out.println(i + Thread.currentThread().getName());
            }
        }
    }
}
@Test
public void test5(){
    EvenNumberThread2 thread2 = new EvenNumberThread2();
    new Thread(thread2).start();
}


```

> 前两种创建方式对比：
>
> 共同点：1.启动线程都是Thread类中定义的start()方法
>
> ​				2.创建的线程对象，都是Thread或者其子类的实例
>
> 不同点：1.一个是继承，一个是实现
>
> ​				2.实现的方式，可以避免单继承的局限性。
>
> ​				3.实现的方式更适合处理有共享数据的问题，因为只创建了一个实例对象
>
> ​				4.实现的方法实现了代码和数据的分离
>
> 联系：public class Thread implements Runnable（ Thread也实现了Runnable接口 ）

方式三：实现Callable接口

好处:

- call有返回值，更灵活
- call可以使用throws方式处理异常，更灵活
- callable使用了泛型参数，可以指明call方法的返回值类型。

缺点：如果要在主线程中获取call的返回值，此时主线程是阻塞状态的。

```java
/*
 1.创建一个实现Callable的实现类
 2.实现call方法
 3.创建Callable接口实现类的对象
 4.将实现类的对象传递到FutureTask的构造器中，创建Futuretask对象
 5.将Futuretask对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start方法
 6.通过futureTask.get方法获取返回值
*/
public class EvenNumberThread3 implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public void test6(){
    EvenNumberThread3 thread3 = new EvenNumberThread3();
    FutureTask futureTask = new FutureTask<>(thread3);
    Thread thread = new Thread(futureTask);
    thread.start();
    try {
        System.out.println("总合" + futureTask.get());
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    } catch (ExecutionException e) {
        throw new RuntimeException(e);
    }
}
```

方式4：线程池 （开发中使用的方法）

提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中，可以避免频繁创建，销毁，实现重复利用。

好处：

- 提高响应速度（减少了创建线程的时间）
- 降低资源消耗（重复利用，不用每次都创建）
- 可以设置相关的参数，对线程池中的线程进行管理

## 5.3 线程的生命周期

1.线程的常用方法

- start(): 启动线程，并且调用run()方法

- run(): 线程要执行的操作
- currentThread()：获取当前执行代码的线程
- getName()：获取线程名
- setName(): 设置线程名
- sleep(): 静态方法，使当前线程休眠指定的毫秒数
- yield()：静态方法，释放CPU的执行权
- join():线程a中通过b调用join方法，线程a进入阻塞状态，等到b线程执行结束，a才会继续执行
- isAlive():线程是否存活

过时的方法：不建议使用

- stop：强行执行线程执行，直接进入死亡状态，
- suspend/resume：暂停/恢复线程，可能造成死锁

线程的优先级：

- getPriority(): 获得当前线程的优先级
- setPriority(): 设置当前线程的优先级	最高优先级10，最低优先级1，普通优先级5

2.线程的生命周期

jdk1.5之前：（这个辅助记忆）

![image-20230718100009900](D:\学习笔记\java\image-20230718100009900-16896456184911.png)

jdk1.5之后：(面试说这个)

![image-20230718100455792](D:\学习笔记\java\image-20230718100455792-16896458975133.png)

---

## 5.4 线程的安全问题

线程安全问题：当我们使用多个线程访问同一资源，若多个线程只有读操作，不会发生安全问题，但是多个线程中对资源有读写操作时，就可能回发生线程安全操作。

例：多线程买票，会出现重票或者错票。

原因：线程1操作ticket的过程中，还未结束的情况下，其他线程也参与进来，对ticket进行操作。

如何解决：必须保证线程a在操作ticket的操作中，其他线程必须等待，知道a线程操作结束之后，其他线程才可以进来。

Java中通过线程的同步机制来解决线程的安全问题。

```java
//方式一：同步代码块
synchronized(同步监视器){
	//需要被同步的代码
}
/*说明：
 需要被同步的代码，即操作共享数据的代码
 synchronized包裹之后，就使得一个线程操作这些代码的过程中，其他线程必须等待。
 同步监视器；俗称锁，哪个线程获取了锁，哪个线程就能执行这些代码。
 同步监视器：可以使用一个类的对象充当锁。但是，多个线程必须共用同一个同步监视器。
 实现的时候同步监视器可以写this，继承的时候同步监视器要慎用this,可以写 当前类.class
*/
//
@Override
public void run() {
    while (true){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //    synchronized (obj){       对象唯一即可使用
        synchronized (this){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}

//方式二:同步方法 
@Override
public void run() {
    while (isFlag){
        sale();
    }
}


public synchronized void show(){
    if (ticket > 0){
        System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket);
        ticket--;
    }else{
        isFlag = false;
    }
}
```

synchronized好处：解决了线程安全问题

弊端：在操作共享数据时，多线程其实是串行的，性能低。

除了synchronized之外还有一种方法，就是加锁lock

> synchronized和Lock对比
>
> synchronized不管是同步代码块还是方法，都需要再结束{}之后，释放对同步监视器的调用
>
> Lock是通过调用两个方法控制需要被同步的代码，灵活一些。
>
> Lock作为接口，提供了更多的实现类，适合更多的场景，效率更高。

## 5.5 线程通信问题------生产者消费者模型

1.方法

- wait ：线程执行此方法，就进入等待状态，同时，会释放对同步监视器的使用
- notify：唤醒被wait的线程中优先级最高的一个线程，如果多个线程优先级相同，那么随机唤醒一个
- notifyAll：唤醒所有被wait的线程。

注意：这三个方法必须放在同步代码块或者同步方法中使用。这三个方法的调用者必须是同步监视器。 

> wait和sleep区别：
>
> 相同点：1.一旦执行，当前线程都会进入阻塞状态。
>
> 不同点：1.声明的位置不同，wait声明再Object类中，sleep声明再Thread类中，静态的。
>
> ​				2.使用场景不同，wait只能在同步代码块或者同步方法中使用，sleep在任何地方都可以使用
>
> ​				3.使用在同步代码块或同步方法中：wait会释放同步监视器，sleep不会释放
>
> ​				4.结束阻塞的方式不同：wait：到指定时间或者被notify唤醒。sleep只能到指定时间后结束

# 6. 常用类及基础API

## 6.1 String

```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence{
    private final char value[];		//该数组一旦初始化，其地址不可变。
    //jdk9以后
    //private final byte value[]; 为了节省空间，做了优化
}
```

- final：String不可继承
- Serializable：可序列化的接口，对象可以通过网络或者本地流进行数据传输。
- Comparable：对象可以比较大小

字符串常量的存储位置：

- 字符串常量存储在字符串常量池中

- 不允许有两个相同的常量
- 字符串常量池存放位置：jdk7之前，放在方法区，jdk7之后，放在堆中。

```java
public void test7(){
    String s1 = "hello";
    String s2 = "hello";
    String s3 = new String("hello");
    System.out.println(s1 == s2);		//true	s1和s2存储在常量池中
    System.out.println(s1 == s3);		//false	s3存储在堆中
}
```

> new String("hello")创建了两个对象，一个是堆空间中new的对象，另一个是字符串常量池中生成的字面量。

String中的连接操作：

- 常量 + 常量 	结果仍然存储在常量池中。
- 常量 + 变量 / 变量 + 常量  结果new一个新的字符串对象，返回对空间中该字符串对象的地址。
- 调用字符串的intern方法，返回的是字符串常量池中字面量的地址。
- 调用字符串的concat方法，返回的是一个新的对象。

```java
public void test7(){
    String s1 = "hello";
    String s2 = "world";
    String s3 = "helloworld";
    String s4 = "hello"+"world";
    String s5 = "hello" + s2;
    String s6 = s1 + s2;
    
    System.out.println(s3 == s4);		//true
    System.out.println(s3 == s5);		//false
    System.out.println(s3 == s6);		//false
    //注意：如果s1定义为final的话，s1 + "world" 相当于常量+常量
}
```

String，StringBuffer和StringBuilder对比

- String：不可变的字符序列
- StringBuffer：可变的字符序列；jdk1.0声明，线程安全的。
- StringBuilder：可变的字符序列；jdk5.0声明，线程不安全的。

底层都是用char[]存储信息。String是final的数组，两外两个数组是没有final修饰的。如果频繁操作字符串的话，不建议使用String。

StringBuilder内部属性：

- char[] valur;	//存储字符序列

- int count; //实际存储的字符数量

## 6.2 日期时间类

1.jdk1.8之前的API

- System类的currentTimeMills():获取当前时间对应的毫秒数，long类型，时间戳，常用来计算时间差。
- java.util.Date(Java中对应的时间类)
  - 两个构造器： new Date()     new Date(Long ms)
  - 两个方法：getTime()获取当前时间戳       toString() 获取当前时间

- java.sql.Date(数据库对应的时间类)

- SimpleDateFormat类：用于日期时间的格式化和解析
- Calendar类：日历类，抽象类

2.jdk8：新的时间API

- java.time
  - LocalDate	日期
  - LocalTime    时间
  - LocalDateTime    日期时间



## 6.3 比较器

方式一：实现Comparable接口

步骤：

1. 具体的类实现接口
2. 重写compareTo方法，在此方法中指明大小比较标准
3. 创建实例，进行比较

方式二：实现Comparator接口   定制比较器，对于一些不能修改源码且没有实现Comparable接口的类对象比较大小，或者不想使用实现Comparable接口的类的比较方法，可以使用该接口。

步骤：

1. 创建一个实现类实现接口
2. 重写compare(Object o1,Object o2)方法，此方法中指明大小比较标准
3. 创建实现类的对象，将对象作为参数传入比较方法即可。

> Comparable 和 Comparator 区别
>
> Comparable ：1.单一的，唯一的；2.一劳永逸；3.对于的接口是Comparable，对应的方法compareTo(Object obj)
>
> Comparator ：1.灵活的，多样的；2.临时的；3.对于的接口是Comparator，对应的方法compare(Object obj1,Object obj2)

# 7. 集合框架

## 7.1 概述

1.数组的特点和弊端

特点：

- 数组一旦初始化，其长度就确定了
- 数组中的多个元素是一次紧密排列的，有序的，可重复的
- （优点）数组一旦初始化完成，其元素的类型就是确定的，不是该类型的元素不能添加到此数组中。
- 元素的类型可以是基本数据类型，也可以是引用数据类型。

弊端：

- 数组一旦初始化，其长度就不可变了
- 数组中存储数据特点的单一性，对于无序，不可重复的多个数据就无能为力了。
- 数组中可用的方法，属性极少。无法满足具体需求，需要自己实现。
- 针对于数组中元素的增删操作，性能较差。

Java集合框架的体系结构

- java.util

  - Collection
    - List:有序的，可重复的数据 (动态数组，可扩容数组)
      - ArrayList 主要实现类，线程不安全的，效率高。底层使用Object[]的数组存储。
      - LinkedList:底层使用双向链表的方式存储。
      - Vector: 古老实现类：线程安全的（不用），效率低。底层使用Object[]的数组存储。
    - Set：无序的，不可重复的数据 （高中学过的集合类似）
      - HashSet	主要实现类，底层是HashMap，底层使用数组+单链表+红黑树存储
      - LinkedHashSet：是HashSet子类，在原有存储基础上，添加了双向链表
      - TreeSet：底层使用红黑树存储，可以按照添加的元素的指定的属性的大小顺序进行遍历。

  > 无序性，指的是添加元素的位置并不是依次紧密排列的，而是通过哈希算法来进行存储的。并非是随机性，也不是说添加和查询元素的顺序不一致。
  >
  > 添加到HashSet/LinkedHashSet中的元素要求类重写equals和hashCode方法，因为哈希算法可能会有哈希冲突，此时再比较下两个对象是否一样，可以确保Set的不可重复性
  >
  > 添加到TreeSet中的  存储元素key的类型必须一致。

  - Map：存储一对一的数据（key-value键值对）
    - HashMap：主要实现类，线程不安全地 ，效率高，可以添加null的key和value值，底层使用数组+单链表+红黑树存储
      - LinkedHashMap：是HashMap的子类，在HashMap基础上添加了一堆双向链表，用于记录插入的先后顺序。遍历时可以根据插入的顺序遍历。
    - TreeMap：底层使用红黑树存储，可以按照添加的元素的key指定的顺序的大小顺序进行遍历。
    - Hashtable：古老实现类，线程安全地 ，效率低，可以添加null的key和value值，底层使用数组+单链表。
    - Properties：key和value都是String类型，用来处理属性文件

Collections 和 collection区别：



## 7.2泛型

泛型，就是允许定义类，接口时通过一个标识表示类中的某个属性的类型或者某个方法的返回值或参数的类型。这个类型参数在使用时确定。

在集合中使用泛型之前可能存在的问题。

- 类型不安全，不使用泛型，则默认时Object类型，任意类型都可以输入。
- 获取集合内的数据需要进行强转操作，繁琐，还可能导致ClassCastException异常。

使用说明：

- 集合框架在声明接口和其实现类时，使用了泛型，在实例化对象时，如果没有使用泛型，则认为操作的时Object类型，如果使用了泛型，则需要指明泛型的具体类型，则在相关的方法中，所有的泛型都替换为具体的类型。
- 在创建自定义泛型类的对象时，弱国没有指明泛型参数类型，那么泛型被擦除，对应的类型按照Object类处理，但是不等价于Object
- 泛型的指定中必须使用引用类型，不能使用基本数据类型。
- 除了创建泛型类对象外，子类继承泛型类时，实现类实现接口时，也可以确定泛型类结构中的泛型参数。如果再给泛型类提供子类时，子类也不确定泛型的类型，则可以继续使用泛型参数，可以在父类泛型参数的基础上，新增泛型参数。

注意：

- 多个泛型参数，此时将多个参数放在一个括号内，<E1，E2>
- 如果泛型类是接口或抽象类，不能创建实现类。
- 异常类不能带泛型。
- 不可以new E[]对象，如果需要创建不确定类型的对象，只能使用Object

## 7.3 源码分析（未完待续）

1.ArrayList特点：

- 实现了List接口，存储有序的，可以重复的数据
- 底层使用Object[]数组存储
- 线程不安全的

源码解析：

- 执行构造方法时，会初始化数组为{}，首次添加元素时，会初始化数组容量，初始容量为10。

- 容量满时，会进行1.5倍扩容。

2.Vector特点：

- 实现了List接口，存储有序的，可以重复的数据
- 底层使用Object[]数组存储
- 线程安全的

源码解析：

- 构造方法，会初始化数组容量，容量为10，
- 容量满时，默认会进行2倍扩容。

3.LinkedList特点：

- 实现了List接口，存储有序的，可以重复的数据
- 底层使用双向链表存储
- 线程不安全的

源码解析：

- 内部核心时Node节点：

  ```java
  private static class Node<E> {
      E item;
      Node<E> next;
      Node<E> prev;
  }
  ```

- 不存在扩容问题

> 三者对比：
>
> 1. Vector基本不用
> 2. ArrayList底层使用数组结构，查找和添加（尾部添加）效率高，时间复杂度为O(1),删除和插入效率低，时间复杂度为O(n)
> 3. LinkedList底层使用双向链表，删除和插入效率高，时间复杂度为O(1),查找和添加（尾部添加）效率低，时间复杂度为O(n)
> 4. 开发中如果大体确认数组的长度，使用ArrayList（初始容量）。

4.HashMap特点：

- key彼此之间不可重复，无序的，所有的key就构成了一个set集合。=====key所在的类需要重写hashCode和equals方法
- value彼此之间是可重复，无序的，所有的value就构成了一个Collection集合=====value所在的类需要重写equals方法
- HashMap中的一个key-value，就构成了一个entry，所有的entry之间是补课重复的，无序的。

源码解析：

1.创建对象时，底层会初始化数组，

2.默认容量为16。加载因子默认为0.75

```java

```

# 8.File类和IO流

## 8.1 File概述

File类位于java.io包下，file类的一个实例对象对应操作系统下的一个文件目录或者一个具体的文件。file类中声明了文件的创建，删除，重命名等方法，但是并没有操作文件的内容，要操作文件内的内容的话，需要用到IO流

绝对路径：包括盘符在内的文件或者文件目录的完整路径

相对路径：相对于项目目录的路径。idea中，main方法中的相对路径，相对于当前工程，test中的相对方法，相对于当前module。

常用方法：

- File(String pathname):
- File(String parent, String child)
- File(File parent, String child)

- getName:获取名称
- getPath:获取路径
- getAbsolutePath:获取绝对路径
- getAbsoluteFile：获取绝对路径对应的文件
- getParent:获取上层文件目录路径：无返回null
- length：获取文件长度，不能获取目录的长度。
- lastModified：获取最后一次修改的修改时间，毫秒值
- String[] list:表示该File目录中所有的子目录或文件,返回名称。
- File[] listFiles:表示该File目录中所有的子目录或文件，返回文件对象
- renameTo：执行此方法的要求，file1必须存在，file2不存在，但是file2的父目录存在。
- createNewFile:创建文件，如果存在，则不创建，返回false。
- mkdir:创建文件目录，如果文件目录存在就不创建。如果待创建的文件目录上层目录不存在，返回false
- mkdirs:如果待创建的文件目录上层目录不存在，一并创建。
- delete:注意 ：删除不走回收站，删除一个文件目录，必须遍历删除子文件和子文件目录。

## 8.2 IO流

I/O流时input/output的缩写，java程序中，对于数据的输入/输出以流的方式操作。 

流的分类

1.以数据的流向不同分类：

- 输入input：读取外部数据（磁盘，光盘等存储设备）到程序（内存）中
- 输出output：将程序（内存）数据输出到磁盘，光盘等存储设备中

2.以操作数据单位的不同分为字节流/字符流

字节流：以字节为基本单位传输 Stream

字符流：以字符为基本单位传输 Reader/writer

3.根据IO流的角色不同分为:节点流，处理流

节点流：直接从数据源或目的地读写数据

处理流：不直接连接数据源或者目的地，而是连接再已存在的流之上，通过对数据的处理

| 抽象基类     | 节点流           | 缓冲流               |      |
| ------------ | ---------------- | -------------------- | ---- |
| InputStraem  | FileInputStream  | BufferedInputStream  |      |
| OutputStream | FileOutputStream | BufferedOutputStream |      |
| Reader       | FileReader       | BufferedReader       |      |
| Writer       | FileWriter       | BufferedWriter       |      |



---

文件操作的步骤：

1.创建文件对象

2.创建输入/输出流

3.具体操作

4.关闭流资源

> 涉及到流操作，建议使用try-catch-finally处理异常，保证六资源关闭
>
> 对于输入流，要求FIle类对象必须存在，否则FileNotFoundException异常。
>
> ​	    输出流，文件可以不存在，输出的过程中，会自动创建该文件。
>
> ​						文件存在：使用有true参数的构造器，会在现有的文件的末尾处追加写出内容，无true/false，则会直接覆盖文件。



FileReader/FileWriter操作代码：

```java
@Test
public void test2(){
    File file = new File("hello.txt");
    if (!file.exists()){
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    System.out.println(file.getAbsoluteFile());
}

@Test
public void test3(){
    String str = "helloWorld123";
    File file = new File("hello.txt");
    Writer writer = null;
    try {
        writer = new FileWriter(file);  //覆盖文件内容
        writer = new FileWriter(file,true);  //接着写文件内容
        writer.write(str);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }finally {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

@Test
public void test4(){
    File file = new File("hello.txt");
    Reader reader = null;
    try {
        reader = new FileReader(file);  
        //             方式一
        //            int data = reader.read();
        //            while (data != -1){
        //                System.out.print((char)data);
        //                data = reader.read();
        //            }
        char[] chs = new char[3];
        int len;
        while((len = reader.read(chs)) != -1){
            System.out.println(String.copyValueOf(chs,0,len));
        }
    }  catch (IOException e) {
        throw new RuntimeException(e);
    } finally {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

FileInputStream/FileOutputStream 操作代码：

```java
@Test
public void test5() {
    File srcFile = new File("cherry.jpg");
    File destFile = new File("cherry_copy.jpg");
    FileInputStream fis = null;
    FileOutputStream fos = null;
    try {
        fis = new FileInputStream(srcFile);
        fos = new FileOutputStream(destFile);
        
        byte[] buffer = new byte[1024];     //1kb
        int len;
        while ((len = fis.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }finally {
        try {
            if (fis != null)
                fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if(fos != null)
                fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
```

注意点：

- 字符流只能用来操作文本文件，不能用来处理非文本文件。Reader/writer
- 字节流，通常用来处理非文本文件的。 Stream

> 文本文件： txt, java,c,cpp,py
>
> 非文本文件：.doc,.xls,jpg,mp3,mp4,avi等

处理流：

1. 4个缓冲流：BufferedInputStream/BufferedOutputStream/BufferedReader/BufferedWriter

​	缓冲流的作用：提高文件读写的效率。

```java
 @Test
    public void test5() {
        File srcFile = new File("cherry.jpg");
        File destFile = new File("cherry_copy.jpg");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //添加一层缓冲流。直接进行操作
            bufferedInputStream = new BufferedInputStream(fis);
            bufferedOutputStream = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1024];     //1kb
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭外层流，自动关闭内层流
            try {
                if (bufferedInputStream != null)
                    bufferedInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if(bufferedOutputStream != null)
                    bufferedOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
```

转换流：

InputStreamReader：将输入型的字节流转换为输入型的字符流

OutputStreamWriter: 将输出型的字节流转换为输出型的字符流

作用：实现字节与字符的转换

> 如果文件本来时GBK格式的，读取数据时，可以通过字节转字符来显示的使用GBK方式读取，否则会出现乱码。
>
> 编码集和解码集必须兼容，否则可能会出现乱码。

数据流：了解即可

DataInputStream：将文件中保存的数据还原为内存中的基本数据类型的变量，String类型的变量。

DataOutputStream： 可以将内存中的基本数据类型的变量，String类型的变量写出到具体的文件中。

对象流：

ObjectInputStream：对使用对象流存储的数据和对象进行读入操作。

ObjectOutputStream：将Java基本数据类型和对象写入字节输出流中。

作用：可以读写基本数据类型，引用数据类型的变量。

> 对象的序列化机制：允许内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘中，或者通过网络将这种二进制流传输到另一个网络节点，当其他程序获取了这种二进制流，就可以恢复成原来地java对象。
>
> 序列化过程：使用ObjectOutputStream流实现，将内存中地对象保存在文件中。
>
> 反序列化过程：使用ObjectInputStream流实现，将文件中地数据或者网络中地数据还原成内存中的Java对象。
>
> 自定义类要实现序列化机制，需要满足：
>
> 1.实现Serializable接口
>
> 2.声明一个全局常量：static final long servialVersionUID，唯一标识该类    如果先反序列化，修改了类属性，那么反序列化会报错，加上唯一标识，就会避免这种错误。
>
> 3.要求类中的属性必须可序列化。引用数据类型也要实现Serializable接口。
>
> 注意：
>
> 1.如果不声明servialVersionUID，系统会自动生成一个UID，修改属性之后，会重新生成一个UID，会导致反序列化错误。
>
> 2.类中的属性如果声明为transient或static，则不会实现序列化。

```java
@Test
public void test6() throws IOException {
    File file = new File("object.txt");
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
    oos.writeUTF("江山如此多娇，引无数英雄尽折腰");
    oos.flush();
    oos.close();
}

@Test
public void test7() throws IOException {
    File file = new File("object.txt");
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
    String s = ois.readUTF();
    System.out.println(s);
    ois.close();
}
```

其他流：

System.in:标准输入流，默认从键盘输入

System.out:标准输出流，默认从控制台输出

# 9.网络编程

## 9.1概述

软件架构：C/S架构和B/S架构

C/S架构：client/Server结构，指客户端和服务器结构，常见的程序有QQ，美团app等。

B/S架构：Browser/Server结构，浏览器和服务器结构，常见的IE，谷歌，火狐等等。

两种架构都离不开网络的支持。网络编程，就是在一定的协议下，实现两台计算机的通信的程序。

实现网络传输的三要素：

- IP地址：可以唯一标识一台主机

- 端口号：可以唯一标识一个进程
- 网络通信协议

## 9.2 TCP和UDP协议

TCP协议和UDP协议的对比：

 TCP协议：

- 进行通信的两个应用进程：客户端，服务端
- 使用TCP协议前，先建立TCP连接，形成基于字节流的数据传输通道
- 传输前，采用三次握手方式，点对点通信，是可靠的
  - TCP协议使用重发机制，A向B发送消息后，没有收到B的回复，则会再次重复刚才发送的消息。
- 可以进行大量的数据传输
- 传输完毕，需要释放建立的连接，效率低

UDP协议：

- 进行通信的两个应用进程：发送端，接收端
- 将数据，源，目的封装成数据包，不需要建立连接
- 发送不管对方，接收方收到不确认，无法保证数据的完整性，不可靠。
- 单个数据包的大小限制64K
- 发送数据结束时无需释放资源，开销小，通信效率高。

> TCP:可靠的连接（三次握手，四次挥手）进行大量数据的传输，效率低
>
> UDP：不可靠的连接，使用数据包传输（限制在64kb以内），效率高

# 10.反射

## 10.1反射概述

1.反射出现背景：

Java程序中，所有的对象有两种类型：编译时类型和运行时类型，而很多时候对象的两种类型不一致。Object obj = new String("hello");

例如:变量或者形参声名类型时Object类型,但是程序却需要调用该对象的运行时类型的方法,该方法不是Object种的方法.这种情况该如何解决呢

- 方案一:可以使用instanceof运算符进行判断,在使用强制类型转换即可
- 方案二:编译时无法预知该对象和类的真实信息,程序只能依靠运行时信息来发现该对象和类的真实信息,所以就需要用到反射

反射时被视为动态语言的关键,反射机制允许程序在运行期间借助于反射API取得任何类的内部信息，并且能操作任意对象的内部属性和方法。 

> 1.面向对象中创建对象，调用属性方法等，使用反射和不使用反射的区别：
>
> 不使用反射，我们需要考虑其封装性。比如：除了Person类之后，就不能调用Person的私有成员。
> 使用反射，我们就可以调用其所有的构造器，属性，方法，包括私有成员。
>
> 2.两种创建对象的方式，哪种用的多？场景？
>
> 开发者角度，主要是完成业务代码，对于相关的对象，方法的调用都是确定的，所以我们基本上使用的是非反射的方式。
> 因为反射体现了动态性，可以在运行时动态的获取对象所属的类，动态的调用相关的方法，所以在设计框架的时候，会大量的使用反射。所以学习源码的时候用到反射。框架 = 注解 + 反射 + 设计模式
>
> 3.单例模式的饿汉式和懒汉式，私有化的构造器，此时通过反射可以创建单例模式中类的多个对象。
>
> 4.通过反射，可以调用类中的私有结构，是否与面向对象的封装性有冲突？是不是Java语言设计存在BUG？
>
> 不存在BUG！封装性是告诉我们不建议我们外部调用，但是万一需要调用的时候得有方法去调用，这就是反射的作用。有了反射就可以去调用私有成员，但是封装性不建议调用，就是可以不用，但是不能没有。

反射的优缺点：

优点：

- 提高了Java程序的灵活性和扩展性，降低了耦合性，提高了自适应能力
- 允许程序创建和控制任何类的对象，无需提前硬编码目标类

缺点：

- 反射的性能较低
- 反射会模糊程序内部逻辑，可读性较差。

## 10.2 Class类

1.Class类的理解

针对于编写好的.java源文件进行编译，会生成一个或多个.class字节码文件。接着使用对.class文件进行解释运行。这个解释运行的过程中，我们需要将.class文件加载（类的加载器）到内存中。加载到内存中的.class文件对应的结构即为Class的一个实例。例：Person.class

Class类，描述类的类，是反射的源头

> 注意:只要类的元素类型和维度一样,就是同一个类,例: int[] a = new int[10];int[] b = new int[20];这两个类反射的clazz是一个值

2.获取Class实例的方法：

```java
@Test
public void test4() throws ClassNotFoundException {
    //方式一：通过运行时类的静态属性Class
    Class clazz1 = Person.class;

    //方式二：通过对象的getClass()方法
    Person p1 = new Person();
    Person p2 = new Student();
    Class clazz2 = p1.getClass();
    Class clazz3 = p2.getClass();
    System.out.println(clazz1==clazz2);     //true
    System.out.println(clazz2);     //class Person
    System.out.println(clazz3);     //class Student
    //方式三:调用Class的静态方法forName(String className)
    Class clazz4 = Class.forName("Person");
    System.out.println(clazz1 == clazz4);   //ture
    //方法四:使用类的加载器
    Class clazz5 = ClassLoader.getSystemClassLoader().loadClass("Person");
    System.out.println(clazz1 == clazz5);   //true
}
```

## 10.3 类的加载过程

![image-20230729104500996](E:/cherry/studyNote/study/java/image-20230729104500996.png)

步骤如下:

过程1:类的装载(loading)

将类的class文件读入内存,并为之创建一个java.lang.Class对象,此过程由类的加载器完成

> 类的加载器：负责类的加载，并对应一个Class的实例
>
> - BootStrapClassLoader 启动类加载器
>
>   1. 使用C/C++编写，不能获取其实例
>
>   2. 负责加载Java的核心库（JAVA_HOME/jre/lib/rt.jar）
>
> - 继承于ClassLoader的类加载器
>
>   - ExtensionClassLoader 扩展类加载器
>     1. java语言编写，由sun.misc.Launcher$ExtClassLoader实现。
>     2. 从JDK安装的目录 jre/lib/ext子目录下加载类库。
>   - ApplicationClassLoader 应用程序类加载器
>     1. 我们自定义的类，默认使用的类的加载器。
>   - 用户自定义类加载器
>     1. 实现应用隔离（同一个类，在一个应用程序中，可以加载多份）
>     2. 实现数据的加密



过程2:链接(linking)

- 验证:确保类的信息复合JVM规范.
- 准备:正式为类变量(static)分配内存并设置类变量默认初始值.这些内存都在方法区分配
- 解析:虚拟机常量池的符号引用替换为直接引用的过程

过程3:初始化（initialization）

执行类构造器 < clinit >()方法的过程。

类构造器方法是由编译期自动收集类中所有类变量的赋值操作和静态代码块中的语句产生的。

## 10.4 反射的应用

1. 创建运行时类的对象：通过Class的实例直接调用newInstance方法即可

但是该方法要满足两个条件：1.空参构造器，2.空参构造器的权限要足够。

> JavaBean为什么要求当前类提供一个空参构造器？
>
> 1. 子类对象在实例化时，第一行默认调用父类的空参构造器。
> 2. 在反射中，经常用来创建运行时类的对象，所以要求具备空参构造器，便于我们编写创建运行时类的对象的代码。

在jdk9中，通过Constructor类调用newInstance()可以调用有参构造器。

2.获取运行时类的内部结构

- 获取运行时类的所有属性，所有方法，所有构造器

- 获取运行时类的父类，接口，包，泛型，父类的泛型等

- 调用指定的属性，方法，构造器。

  1. 通过Class实例调用getDeclareField(String filedName)获取属性
  2. setAccessible（true）确保属性可以访问
  3. 通过Filed类的实例set/get方法，进行操作。

  ```java
  @Test
  public void test3() throws Exception {
      //调用私有构造器
      Class<Person> clazz = Person.class;
      Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
      constructor.setAccessible(true);
      Person p1 = constructor.newInstance("Tom", 12);
      System.out.println(p1);
  
      //调用私有属性
      Field name = clazz.getDeclaredField("name");
      name.setAccessible(true);
      name.set(p1,"jerry");
      System.out.println(name.get(p1));
  
      //调用私有方法
      Method showNation = clazz.getDeclaredMethod("showNation", String.class);
      showNation.setAccessible(true);
      System.out.println(showNation.invoke(p1, "中国"));
  }
  ```


# 11.新特性

## 11.1 jdk8-Lambda表达式

```java
@Test
public void test2(){
    Comparator<Integer> com2 = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1,o2);
        }
    };

    Comparator<Integer> com1 = (Integer o1, Integer o2) -> {
        return Integer.compare(o1,o2);
    };
    System.out.println(com1.compare(1,2));

    //简化版
    Comparator<Integer> com3 = (i1,i2) -> Integer.compare(i1,i2);

    //方法引用
    Comparator<Integer> com4 = Integer::compare;
    System.out.println(com4.compare(1, 2));
}
```

- -> : Lambda操作符
- ->的左边:lambda的形参列表,对应要重写的方法的形参列表
- ->的右边:lambda体,对应重写的方法体.

lambda充当了接口实现类的对象,它是一个匿名函数.

**函数式接口**:如果接口中只声明一个抽象方法，这个接口就叫做函数式接口。只有给函数式接口提供实现类的对象时，才能使用lambda表达式。

语法规则总结：

- ->左边，形参列表，参数的类型可以省略，如果形参只有一个，则小括号也可以省略
- ->右边，lambda体，如果方法体中只有一条执行语句，则一堆大括号可以省略，如果return只有一条语句，则return和大括号可以同时省略。

## 11.2 jdk8-方法引用

方法引用：可以看作是基于lambda表达式的进一步刻画。

当需要一个函数式接口的实例时，可以使用lambda表达式来提供实例，当满足一定的条件时，可以使用方法引用或者构造器引用替换lambda表达式。

格式：  类（或者对象） ::  方法名

## 11.3 jdk8-Stream API

Stream API关注的时多个数据的计算，面向CPU的。集合关注的是数据的存储，面向内存的。

Stream API 和集合的关系类似于 SQL和数据表的查询。

使用说明：

1. Stream自己不会存储元素
2. Stream不会改变源对象，结果会返回一个新的Stream对象
3. Stream是延迟执行的，意味着他们会等到需要结果的时候再执行。
4. Stream一旦执行了操作，就不能再调用其它中间操作或者终止操作了。

执行流程：

步骤1：Stream的实例化

步骤2：一系列的中间操作

步骤3：执行终止操作。

## 11.4 jdk8之后的新特性：语法层面

- jshell工具
- try-catch结构的变化：try（）{}
- 局部变量的类型推断：var
- instanceof的模式匹配   o1 instanceof String s
- switch表达式，模式匹配
- 文本块的使用:"""  文本块 """
- 新的类型：record
- 密封类：sealed class

# 12.JDBC

## 12.1 概述

数据的持久化:把数据保存到可掉电式存储设备中供以后使用.一般时间过数据存储在数据库种.

java中的数据存储技术：

- JDBC直接访问数据库
- JDO（Java Data Object）技术
- 第三方框架：如Mybatis，Hibernate等

JDBC是java访问数据库的基石，其他的技术只是封装了JDBC。

## 12.2JDBC介绍

- JDBC是一个独立于特定数据库管理系统，通用的SQL数据库存取和操作的公共接口，定义了用来访问数据库标准Java类库。
- JDBC为访问不同的数据库提供了统一的途径。

JDBC包括两个层次：

- 面向应用的API，抽象接口，供开发人员使用，数据库的连接，Sql的操作等等
- 面向驱动的API，供开发商开发数据库驱动程序使用。

## 12.3 JDBC编写步骤

配置文件：

```properties
#jdbc5.7版本 driver
#driver=com.jdbc.mysql.driver
#url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8
#jdbc 8.0版本 driver
username =root
password=123456
url=jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true
driver=com.mysql.cj.jdbc.Driver
```

代码：

```java
//优点：1.实现了数据和代码的分离，实现了解耦
//	   2.如果需要修改配置信息，直接修改配置文件，避免重新打包


@Test
public void test1() throws Exception {
    Properties properties = new Properties();
    InputStream is = JDBCTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
    //1.加载配置文件
    properties.load(is);
    String driver = properties.getProperty("driver");
    String username = properties.getProperty("username");
    String password = properties.getProperty("password");
    String url = properties.getProperty("url");
    //2.加载驱动
    Class.forName(driver);
    //3.获取连接
    Connection connection = DriverManager.getConnection(url, username, password);
    System.out.println(connection);
}
```

## 12.4 CRUD

1.statement操作，可能会发生SQL注入问题。

2.PreparedStatement操作：可以操作BLOB类型的数据，可以实现更加高效的批量操作。



