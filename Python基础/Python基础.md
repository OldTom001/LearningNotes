# 基础语法

## 运算符

![算术运算符](Python基础.assets/算术运算符.png)

![比较运算符](Python基础.assets/比较运算符.png)

![赋值运算符](Python基础.assets/赋值运算符.png)

![位运算符](Python基础.assets/位运算符.png)

![逻辑运算符](Python基础.assets/逻辑运算符.png)

![身份运算符](Python基础.assets/身份运算符.png)

![成员运算符](Python基础.assets/成员运算符.png)

![运算符优先级](Python基础.assets/运算符优先级.png)

## 条件判断语句

![条件判断](Python基础.assets/条件判断.png)

**注意判断条件后的冒号, 且必须缩进, 空格缩进和tab缩进均可**

```python
a = 10
if a >= 10:
    print("a>=10")
elif a >= 5:
    print(a >= 5)
else:
    print("a<5")
```

## 循环

### for循环

```python
for i in range(0, 10): # i>=0, i<10, 步进1
    print(i)
print("------------------------")
for i in range(0, 10, 3):  # i>=0, i<10, 步进3
    print(i)
```

### while循环

```python
# while测试
n = 100
sum = 0
counter = 1
while counter <=100:
    sum = sum + counter
    counter += 1

print("1到100的和为%d"%sum)

# while-else测试
counter = 1
while counter < 5:
    print("小于5")
    counter += 1
else:
    print("大于5")
```

### break, continue, pass

* break: 跳出for和while循环体
* continue: 跳出当前循环, 直接进入下一轮循环
* pass: 空语句, 一般用作占位语句, 不作任何事情

## 数据结构

### 字符串



* Python字符串可以使用单引号, 双引号, 和三引号(三个双引号)括起来, 使用反斜杠\转义特殊字符

* Python3源码文件默认以UTF-8编码, 所有字符串都是unicode字符串

* 支持字符串拼接, 截取等多种运算

```python
word ='字符串'
sentence = "这个一个句子"
paragraph = """
    这是一个段落
    可以有多行
    保留格式
"""
print(word)
print(sentence)
print(paragraph)

# 单引号和双引号有些区别
mystr1 = "I'm a student"
mystr2 = 'I\'m a student'  # 需要转义单引号
print(mystr1)
print(mystr2)
str = "chengdu"
print(str[1:7:2])  # 选择打印范围, 1~6, 步进2
print(str + "你好")  # 拼接
print(str * 3)  # 重复打印

# 转义字符与取消转义
print("hello\nchengdu")  # 反斜杠表示转义
print(r"hello\nchengdu")  # 前面加r表示直接显示, 没有转义功能
```

### 列表

![列表](Python基础.assets/列表-1621152280098.png)

  ```python
  namelist = ["孙悟空", "猪悟能", "沙悟净"]
  for name in namelist:
      print(name)
  
  # 增删改查测试
  print("增删改查测试")
  print("增")
  nametemp = input("请输入添加学生的姓名")
  namelist.append(nametemp)
  for name in namelist:
      print(name)
  # extend, insert
  
  print("删")
  del namelist[1]
  for name in namelist:
      print(name)
  
  # namelist.pop()  # 弹出最后一个元素
  # namelist.remove("孙悟空")  # 若有重复数据, 则只能删除第一个
  
  print("改")
  namelist[0] = "齐天大圣"
  for name in namelist:
      print(name)
  
  print("查")
  namefind = input("请输入要查找的名字")
  if namefind in namelist:
      print("找到了")
  else:
      print("不存在")
  
  print(namelist.index("齐天大圣", 0, 3)) # 在列表0~2的范围内查找"齐天大圣", 若查到, 则返回索引, 否则会报错
  
  print("看看列表里边有多少个齐天大圣")
  print(namelist.count("齐天大圣"))
  
  namelist.reverse()  # 反转
  namelist.sort()  # 排序(升序)
  namelist.sort(reverse=True)  # 排序(降序)
  
  ```

### 案例: 分配办公室

```python
import random

print("为每个老师随机分配办公室")

offices = [[], [], []]  # 嵌套列表
names = ["A", "B", "C", "D", "E", "F", "G", "H"]
for name in names:
    index = random.randint(0, 2)  # 随机分配索引
    offices[index].append(name)

# 打印每个办公室的人
i = 0
for office in offices:
    print("办公室%d内的人数为%d, 他们是: " % (i, len(office)))
    for name in office:
        print("%s" % name, end="\t")
    print("\n")
    i += 1
```

> 办公室0内的人数为4, 他们是: 
> A	B	E	H	
>
> 办公室1内的人数为3, 他们是: 
> C	D	F	
>
> 办公室2内的人数为1, 他们是: 
> G	

  ### 案例: 逛超市

![作业 逛超市](Python基础.assets/作业 逛超市-1621158847434.png)

```python
# 打印商品清单
productList = [["iphone", 6888], ["MacPro", 14800], ["小米6", 2499], ["Coffee", 31], ["Book", 60], ["Nike", 699]]
print("-"*10, "商品列表", "-"*10)

# productIndex = 0
# for product in productList:  # 逐个打印
#     print("%d\t%s\t%d" % (productIndex, product[0], product[1]))
#     productIndex += 1

# 用枚举函数替换上述代码
for i, product in enumerate(productList):
    print(i, product[0], product[1])

shopTrolley = []  # 购物车

productNumber = input("请输入要购买的商品编号(按q结束购物): ")

while not(productNumber is "q"):
    if int(productNumber) > len(productList):
        print("该商品不存在, 请重新输入")
        productNumber = input("请输入要购买的商品编号(按q结束购物): ")
    else:
        shopTrolley.append(productList[int(productNumber)])  # 添加被选择的物品
        productNumber = input("请输入要购买的商品编号(按q结束购物): ")

print("-"*10, "购物清单", "-"*10)

# productIndex = 0
# for product in shopTrolley:  #打印购物车
#     print("%d\t%s\t%d" % (productIndex, product[0], product[1]))
#     productIndex += 1

# 用枚举函数替换上面的代码
for i, product in enumerate(shopTrolley):
    print(i, product[0], product[1])

```

### 元组(tuple)

![元组(Tuple)](Python基础.assets/元组(Tuple).png)

```python
tup1 = ("abc", "def", 2000, 2020, 333, 444, 555, 666)  # 必须用逗号隔开, 如果只有一个元素后面也必须加逗号

print(tup1[0])  # 访问第一个元素
print(tup1[-1])  # 访问最后一个元素
print(tup1[1:5])  # 左闭右开, 切片

# 增
tup2 = (12, 34, 56)
tup3 = ("abc", "xyz")
tup4 = tup2 + tup3
print(tup4)

# 删
# del tup2[0]  # tulle不允许删除
del tup2  # 删除了整个变量, 无法再进行打印
# print(tup2)

```

### 字典(dict, Java中叫Map)

![字典](Python基础.assets/字典.png)

```python
info = {"name": "孙悟空", "age": 500}

print(info["name"])
print(info["age"])

# print(info["gender"])  # 直接访问不存在的键, 会报错
print(info.get("gender"))  # 使用get方法, 若没有找到对应的键, 默认返回None
print(info.get("gender"), "m")  # 这是没有找到时的返回值, 返回m

# 增删改查
# 增
# newID = input("请输入学号: ")
# info["id"] = newID
# print(info["id"])

# 删, 分为del和clear, del可以删除整个变量, clear只是清空字典, 但是变量仍然存在
# del
print("删除一个键值对")
print("删除前: %s"%info["name"])
del info["name"]
# print("删除后: "%info["name"])  # 删除整个键值对, 再次访问报错

info["name"] = "孙悟空"

print("删除整个dict")
print("删除前: ")
print(info)
del info
print("删除后: ")
# print(info)  # 删除整个dict, 再次访问报错
print("-"*30)
# clear
info = {"name": "孙悟空", "age": 500}
print("清空: ")
print("请空前: ")
print(info)
info.clear()
print("清空后: ")
print(info)
print("-"*30)
# 查
info = {"id": "1", "name": "孙悟空", "age": 500}
print(info.keys())  # 打印所有的键(键的形式是列表)
print(info.values())  # 打印所有的值
print(info.items())  # 打印所有的项

# 遍历所有的键
print("遍历所以的键")
for key in info.keys():
    print(key)
# 遍历所有的值
print("遍历所有的值")
for value in info.values():
    print(value)
# 遍历所有的项(键值对)
print("遍历所有的项(键值对)")
for key, value in info.items():
    print("key = %s, value = %s"%(key, value))

# 使用枚举函数, 同时拿到列表中的下标和元素内容
myList = ["a", "b", "c", "d"]

for i, x in enumerate(myList):
    print(i, x)

```

### 集合(set)

![集合](Python基础.assets/集合.png)

### 数据结构小结

![数据结构小结](Python基础.assets/数据结构小结.png)

## 函数

![函数](Python基础.assets/函数.png)

```python
# 定义函数
def printinfo():
    print("-----------------------")
    print("      我乃齐天大圣")
    print("-----------------------")


printinfo()


# 带参数和返回值的函数
def add2Num(a, b):
    return a+b


result = add2Num(11, 22)
print(result)


# 多个返回值的函数
def divide(a, b):
    shang = a // b
    yushu = a % b
    return shang, yushu

sh, yu = divide(5, 2)
print("商: %d, 余: %d" % (sh, yu))

```

## 文件操作

```python
# 创建一个文件并打开
f = open("test.txt", "w")  # 打开文件, w模式下, 若文件不存在, 则新建
f.write("Hello world, I am here. -0\nHello world, I am here. -1\nHello world, I am here. -2")  # 写入内容
f.close()


# read方法: 读取文件中的字符, 开始时定位在文件头部, 每次执行之后自动后移
f = open("test.txt", "r")
content = f.read(5)  # 读5个字符
print(content)

content = f.read(5)  # 再读5个字符
print(content)

f.close()

# 一次性读取整个文档
f = open("test.txt", "r")
content = f.readlines()  # 读取结果是列表, 按行读, 从第一行一直读到最后一行

for i, temp in enumerate(content):  # 输出行号+内容
    print("第%d行: %s" % (i, temp), end="")
print("\n")
f.close()

# 每次读取1行
f = open("test.txt", "r")
content = f.readline()
print("第0行: %s" % content, end="")

content = f.readline()
print("第1行: %s" % content)
f.close()

# import os
# os.rename("test.txt", "test.txt")

```

## 错误与异常

```python
# 发生异常
print("----test 1----")  # 这一句正常执行

f = open("123.txt", "r")  # 打开一个不存在的文件, 报错, 下一句不再执行

print("----test 2----")

# 捕获异常
try:
    print("----test 1----")
    f = open("123.txt", "r")  # 不报错, 但下一句仍然不执行
    print("----test 2----")
except IOError:  # 文件没找到, 属于IO异常
    pass  # 捕获异常后, 执行的代码

# 同时捕获多个异常
try:
    print("----test 1----")
    f = open("123.txt", "r")  # 下面的代码不会执行, 异常也不会被捕获
    print("----test 2----")

    print(num)  # 这是一个NameError
except (NameError, IOError):  # 把可能发生的异常都放到这里
    print("产生错误了")

# 显示异常信息
try:
    print("----test 1----")
    f = open("123.txt", "r")  # 下面的代码不会执行, 异常也不会被捕获
    print("----test 2----")

    print(num)  # 这是一个NameError
except (NameError, IOError) as result:  # 把可能发生的异常都放到这里
    print("产生错误了")
    print(result)

# 捕获所有异常
try:
    print("----test 1----")
    f = open("123.txt", "r")  # 下面的代码不会执行, 异常也不会被捕获
    print("----test 2----")

    print(num)  # 这是一个NameError
except Exception as result:  # 承接所有异常
    print("产生错误了")
    print(result)

# 文件异常处理
import time

try:
    f = open("test.txt", "r")
    # f = open("123.txt", "r")  # 这里报错不能进入finally

    try:
        while True:
            content = f.readline()
            if len(content) == 0:
                break
            time.sleep(2)  # 每隔两秒打印一次
            print(content)
    finally:  # 如果读取过程中发生异常, 如上面的break, 也要保证文件正常关闭
        f.close()
        print("文件关闭")

except Exception as result:
    print("发生异常")
    print(result)

```

![古诗](Python基础.assets/古诗.png)

