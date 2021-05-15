# -*- coding = utf-8 -*-
# @Time: 2021/5/15 17:19
# @Author: ZSL
# @File: 1 Print.py
# @Software: PyCharm

print("直接打印")
print("hello,world")

'''
格式化输出
'''
print("格式化打印")
age = 20
print("我的年龄是: %d岁"%age)

name = '孙悟空'
print("我的名字叫: %s"%name)

print("我的名字是%s, 我的国籍是%s"%("孙悟空","花果山"))

#打印www.baidu.com
print("测试一个分割符, 打印www.baidu.com")
print("www", "baidu", "com", sep=".") #用.分割

print("hello", end="")
print("后面空一格", end ="\t")
print("后面换个行", end = "\n")
print("结束了")

print("测试输入数据的类型")
a = input("输入: ")
print(type(a))

print("输入测试")
password = input("请输入密码")
print("您刚刚输入的密码是: ",password)