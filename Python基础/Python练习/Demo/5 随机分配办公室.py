# -*- coding = utf-8 -*-
# @Time: 2021/5/16 17:40
# @Author: ZSL
# @File: 5 随机分配办公室.py
# @Software: PyCharm

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
