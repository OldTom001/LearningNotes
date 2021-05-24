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

## 字符串

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

## 列表

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



