# -*- coding = utf-8 -*-
# @Time: 2021/5/27 15:45
# @Author: ZSL
# @File: TestBs4.py
# @Software: PyCharm


'''
eautifulSoup4将复杂HTML文档转换成一个复杂的树形结构, 每个节点都是Python对象, 所有对象可以归纳为4类:

* Tag
* NavigableString
* BeautifulSoup
* Comment
'''

import re
from bs4 import BeautifulSoup
file = open("./baidu.html", "rb")  # 二进制读取
html = file.read().decode("utf-8")
bs = BeautifulSoup(html, "html.parser")


# # 1. Tag 标签
# # 通过bs拿到标签及其内容, 只能拿到第一个内容
# # title, a, head都是标签名, 在html代码中以<标签名>开始, </标签名>结束, 如<title>百度一下，你就知道</title>
# print(bs.title)
# print(type(bs.title))  # 类型为Tag
# print(bs.a)
# print(bs.head)

# # 2. NavigableString, 表示标签里的内容
# print(bs.title.string)
# print(type(bs.title.string))  # 类型为NavigableString
#
# print(bs.a.attrs)  # 获取标签中的所有属性

# # 3. BeautifulSoup, 表示整个html文档
# print(bs.name)  # 名字叫document
# print(bs.attrs)  # 没有属性
# print(bs)  # 打印整个html文档

# #  4. Comment, 是一个特殊的NavigableString, 输出内容不包含注释符号
# print(bs.a)  # 带注释打印
# print(bs.a.string)  # 自动去掉注释
# print(type(bs.a.string))  # 网上这个类型是bs4.element.comment, 我的运行结果是bs4.element.NavigableString, 暂时不知道为什么
#


# # 文档遍历
# print(bs.head.contents)  # 这是个列表
# print(bs.head.contents[0])
# # 更多内容搜索BeautifulSoup遍历树

# # 文档搜索
# (1)find_all()
# 字符串过滤: 会查找与字符串完全匹配的内容, 按标签找
# t_list = bs.find_all("a")
# print(t_list)

# # 正则表达式搜索: 使用search()方法匹配内容, 按标签找
# t_list = bs.find_all(re.compile("a"))  # 查找所有含有a的标签
# print(t_list)

# # 定义方法搜索含有name的标签
# def name_is_exists(tag):
#     return tag.has_attr("name")
#
#
# t_list = bs.find_all(name_is_exists)
# # print(t_list)
# for item in t_list:  # 按列表打印
#     print(item)

# # 2. kwargs 参数
# t_list = bs.find_all(id="head")
# t_list = bs.find_all(class_=True)
# t_list = bs.find_all(href="http://news.baidu.com")
# for item in t_list:  # 按列表打印
#     print(item)

# 3. text参数
# t_list = bs.find_all(text = "hao123")  # 查找文本
#
# t_list = bs.find_all(text=["hao123", "地图", "贴吧"])  # 查找多个文本
#
# t_list = bs.find_all(text=re.compile("\d"))  # 用正则表达式查找包含特定文本的内容(标签里的字符串)

# # 4. limit参数
# t_list = bs.find_all("a", limit=3)  # 限定数量
# for item in t_list:
#     print(item)

# css选择器
t_list = bs.select('title')  #通过标签查找

t_list = bs.select(".mnav")  # 通过类名查找

t_list = bs.select("#u1")  #通过id查找

t_list = bs.select("a[class]")  # 通过属性查找, 查找a标签下的class属性
t_list = bs.select("a[class=toindex]")

t_list = bs.select("head > meta")  # 通过子标签查找

t_list = bs.select("meta ~ link")  # 通过兄弟标签查找, 查找meta标签的兄弟link标签

for item in t_list:
    print(item)
