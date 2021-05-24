# -*- coding = utf-8 -*-
# @Time: 2021/5/24 16:42
# @Author: ZSL
# @File: 8 dict.py
# @Software: PyCharm

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

