# -*- coding = utf-8 -*-
# @Time: 2021/5/24 21:06
# @Author: ZSL
# @File: 11 exception.py
# @Software: PyCharm

# # 发生异常
# print("----test 1----")  # 这一句正常执行
#
# f = open("123.txt", "r")  # 打开一个不存在的文件, 报错, 下一句不再执行
# 
# print("----test 2----")
#
# # 捕获异常
# try:
#     print("----test 1----")
#     f = open("123.txt", "r")  # 不报错, 但下一句仍然不执行
#     print("----test 2----")
# except IOError:  # 文件没找到, 属于IO异常
#     pass  # 捕获异常后, 执行的代码
#
# # 同时捕获多个异常
# try:
#     print("----test 1----")
#     f = open("123.txt", "r")  # 下面的代码不会执行, 异常也不会被捕获
#     print("----test 2----")
#
#     print(num)  # 这是一个NameError
# except (NameError, IOError):  # 把可能发生的异常都放到这里
#     print("产生错误了")
#
# # 显示异常信息
# try:
#     print("----test 1----")
#     f = open("123.txt", "r")  # 下面的代码不会执行, 异常也不会被捕获
#     print("----test 2----")
#
#     print(num)  # 这是一个NameError
# except (NameError, IOError) as result:  # 把可能发生的异常都放到这里
#     print("产生错误了")
#     print(result)
#
# # 捕获所有异常
# try:
#     print("----test 1----")
#     f = open("123.txt", "r")  # 下面的代码不会执行, 异常也不会被捕获
#     print("----test 2----")
#
#     print(num)  # 这是一个NameError
# except Exception as result:  # 承接所有异常
#     print("产生错误了")
#     print(result)

# 文件异常处理
import time

try:
    f = open("test.txt", "r")
    # f = open("123.txt", "r")  # 这里报错不能进入finally

    try:
        while True:
            content = f.readline()
            if len(content) == 0:
                break
            time.sleep(2)  # 每隔两秒打印一次
            print(content)
    finally:  # 如果读取过程中发生异常, 如上面的break, 也要保证文件正常关闭
        f.close()
        print("文件关闭")

except Exception as result:
    print("发生异常")
    print(result)

