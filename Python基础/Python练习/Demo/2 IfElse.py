# -*- coding = utf-8 -*-
# @Time: 2021/5/15 21:54
# @Author: ZSL
# @File: 2 IfElse.py
# @Software: PyCharm

print("条件判断测试")
a = 10
if a >= 10:
    print("a>=10")
elif a >= 5:
    print(a >= 5)
else:
    print("a<5")

print("for循环测试")
for i in range(0, 10): # i>=0, i<10, 步进1
    print(i)
print("------------------------")
for i in range(0, 10, 3):  # i>=0, i<10, 步进3
    print(i)

print("while循环测试: 1-100求和")
n = 100
sum = 0
counter = 1
while counter <=100:
    sum = sum + counter
    counter += 1

print("1到100的和为%d"%sum)

print("while-else测试")
counter = 1
while counter < 5:
    print("小于5")
    counter += 1
else:
    print("大于5")
