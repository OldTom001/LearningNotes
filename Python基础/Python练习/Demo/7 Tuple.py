# -*- coding = utf-8 -*-
# @Time: 2021/5/24 16:20
# @Author: ZSL
# @File: 7 Tuple.py
# @Software: PyCharm

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

