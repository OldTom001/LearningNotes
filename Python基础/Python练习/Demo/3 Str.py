# -*- coding = utf-8 -*-
# @Time: 2021/5/16 14:59
# @Author: ZSL
# @File: 3 Str.py
# @Software: PyCharm

print("测试字符串")
word ='字符串'
sentence = "这个一个句子"
paragraph = """
    这是一个段落
    可以有多行
    保留格式
"""
print(word)
print(sentence)
print(paragraph)

# 单引号和双引号有些区别
print("测试单引号和双引号的区别")
mystr1 = "I'm a student"
mystr2 = 'I\'m a student'  # 需要转义单引号
print(mystr1)
print(mystr2)

str = "chengdu"
print(str[1:7:2])  # 选择打印范围, 1~6, 步进2
print(str + "你好")  # 拼接
print(str * 3)  # 重复打印

# 转义字符与取消转义
print("hello\nchengdu")  # 反斜杠表示转义
print(r"hello\nchengdu")  # 前面加r表示直接显示, 没有转义功能
