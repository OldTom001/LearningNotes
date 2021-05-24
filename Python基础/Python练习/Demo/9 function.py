# -*- coding = utf-8 -*-
# @Time: 2021/5/24 18:19
# @Author: ZSL
# @File: 9 function.py
# @Software: PyCharm

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
