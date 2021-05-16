# -*- coding = utf-8 -*-
# @Time: 2021/5/16 16:06
# @Author: ZSL
# @File: 4 List.py
# @Software: PyCharm

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
