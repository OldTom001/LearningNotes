# -*- coding = utf-8 -*-
# @Time: 2021/5/24 20:37
# @Author: ZSL
# @File: 10 file.py
# @Software: PyCharm

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

# 修改文件名称
# import os
# os.rename("test.txt", "test.txt")
