# -*- coding = utf-8 -*-
# @Time: 2021/5/26 20:14
# @Author: ZSL
# @File: TestUrllib.py
# @Software: PyCharm

import urllib.request
import urllib.parse

# # 获取一个get请求
# response = urllib.request.urlopen("http://www.baidu.com")
# # print(response)  # 返回response对象, 其中保存了网页的所有信息
# # print(response.read())  # 读取网页源代码
# print(response.read().decode("utf-8"))  # 解码, 解码后的代码可以保存为html文件, 然后用浏览器打开

# # 获取一个post请求
# # 模拟浏览器真实行为, httpbin.org会将请求信息放在Response body中返回
# data = bytes(urllib.parse.urlencode({"hello": "world"}), encoding="utf-8")
# response = urllib.request.urlopen("http://httpbin.org/post", data=data)  # post请求必须传参数
# print(response.read().decode("utf-8"))


# # 超时处理
# try:
#     response = urllib.request.urlopen("http://httpbin.org/get", timeout=0.01)  # 设置超时时间, 超时会报错
#     print(response.read().decode("utf-8"))
# except urllib.error.URLError as e:
#     print("time out!")
#
#
# response = urllib.request.urlopen("http://httpbin.org/get", timeout=1)
# print(response.status)  # 返回状态码, 正常是200
#

# response = urllib.request.urlopen("http://www.baidu.com")
# print(response.getheaders())  # 返回的是页面Response Headers中的所有信息
# print(response.getheader("Server"))  # 可以拿到具体的一个头信息
#
#
# response = urllib.request.urlopen("http://douban.com", timeout=1)
# print(response.status)  # 返回418发现我是爬虫了
#
#
# # 直接爬会被识破, 需要包装一下
# # 包装一个req对象, 更像一个浏览器
# url = "http://httpbin.org/post"
# headers = {
# "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36 Edg/90.0.818.66"
# }  # 这里可以加入Request Headers中的更多信息, 可以把真实Request Headers中的信息全都写进去
# data = bytes(urllib.parse.urlencode({'name': 'eric'}), encoding="utf-8")
# req = urllib.request.Request(url=url, data=data, headers=headers, method="POST")
# response = urllib.request.urlopen(req)
# print(response.read().decode("utf-8"))
#
# url = "http://www.douban.com"
# headers = {
# "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36 Edg/90.0.818.66"
# }
# req = urllib.request.Request(url=url, headers=headers, method="POST")
# response = urllib.request.urlopen(req)
# print(response.read().decode("utf-8"))

url = "http://www.baidu.com"
headers = {
"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36 Edg/90.0.818.66"
}
req = urllib.request.Request(url=url, headers=headers, method="GET")
response = urllib.request.urlopen(req)
print(response.read().decode("utf-8"))
