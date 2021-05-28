# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


from bs4 import BeautifulSoup
# import bs4  # 网页解析, 获取数据
import re  # 正则表达式, 进行文字匹配
import urllib.request, urllib.error  # 制定URL, 获取网页数据
import xlwt  # 进行excel操作
import sqlite3  # 进行SQLite数据库操作


def main():
    baseUrl = "https://movie.douban.com/top250?start="
    # 1. 爬取网页
    dataList = GetData(baseUrl)
    savePath = ".\\豆瓣电影Top250.xls"
    # 3. 保存数据
    # SaveData(savePath)
    AskUrl("https://movie.douban.com/top250?start=")

# 爬取网页
def GetData(baseUrl):
    dataList = []
    for i in range(0,10):  # 调用获取页面信息的函数, 10次
        url = baseUrl + str(i*25)
        html = AskUrl(url)  # 保存获取到的网页源码

        # 2. 逐一解析数据

    return dataList


# 得到指定一个URL的网页内容
def AskUrl(url):
    head = {  # 模拟浏览器头部信息, 想豆瓣服务器发送消息
    "User-Agent":"Mozilla / 5.0(Windows NT 10.0;Win64;x64) AppleWebKit / 537.36(KHTML, likeGecko) Chrome / 90.0.4430.212Safari / 537.36Edg / 90.0.818.66"
    }  # 用户代理, 发送服务器信息, 告诉豆瓣我们是什么类型的机器/浏览器, 本质上是高速浏览器, 我们可以接收什么水平的文件内容
    # User-Agent一定不能有空格

    request = urllib.request.Request(url, headers=head)
    html = ""
    try:
        response = urllib.request.urlopen(request)
        html = response.read().decode("utf-8")
        print(html)
    except urllib.error.URLError as e:
        if hasattr(e, "code"):  # 如果返回信息中有"code"标签, 则打印出来
            print(e.code)
        if hasattr(e, "reason"):
            print(e.reason)

    return html



def SaveData(savePath):
    print()


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
