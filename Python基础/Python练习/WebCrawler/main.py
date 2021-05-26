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
    SaveData(savePath)


# 爬取网页
def GetData(baseUrl):
    dataList = []
    # 2. 逐一解析数据
    return dataList


def SaveData(savePath):
    print()


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
