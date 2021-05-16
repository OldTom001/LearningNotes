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

 



