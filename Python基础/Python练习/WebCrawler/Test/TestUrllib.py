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
# # 模拟浏览器真实行为, 发送的数据会被httpbin.org原样返回
# import urllib.parse
# data = bytes(urllib.parse.urlencode({"hello": "world"}), encoding="utf-8")
# response = urllib.request.urlopen("http://httpbin.org/post", data = data)  # post请求必须传参数
# print(response.read().decode("utf-8"))

# # 超时处理
# try:
#     response = urllib.request.urlopen("http://httpbin.org/get", timeout=0.01)  # 设置超时时间, 超时会报错
#     print(response.read().decode("utf-8"))
# except urllib.error.URLError as e:
#     print("time out!")

# response = urllib.request.urlopen("http://httpbin.org/get", timeout=1)
# print(response.status)  # 返回状态码, 正常是200

# response = urllib.request.urlopen("http://douban.com", timeout=1)
# print(response.status)  # 返回418发现我是爬虫了

# response = urllib.request.urlopen("http://www.baidu.com")
# print(response.getheaders())  # 返回的是页面Response Headers中的所有信息
# print(response.getheader("Server"))  # 可以拿到具体的一个头信息

# # 直接爬会被识破, 需要包装一下
# url = "https://www.douban.com"

# # 包装一个req对象, 更像一个浏览器
# url = "http://httpbin.org/post"
# headers = {
# "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36 Edg/90.0.818.66"
# }
# data = bytes(urllib.parse.urlencode({'name': 'eric'}), encoding="utf-8")
# req = urllib.request.Request(url=url, data=data, headers=headers, method="POST")
# response = urllib.request.urlopen(req)
# print(response.read().decode("utf-8"))

url = "http://www.douban.com"
headers = {
"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36 Edg/90.0.818.66"
}
req = urllib.request.Request(url=url, headers=headers, method="POST")
response = urllib.request.urlopen(req)
print(response.read().decode("utf-8"))