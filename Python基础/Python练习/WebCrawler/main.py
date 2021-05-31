# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


from bs4 import BeautifulSoup
import re  # 正则表达式, 进行文字匹配
import urllib.request, urllib.error  # 制定URL, 获取网页数据
import xlwt  # 进行excel操作
import sqlite3  # 进行SQLite数据库操作

# 影片详情链接
findLink = re.compile(r'<a href="(.*?)">')  # 创建正则表达式对象, 表示规则, 用来查找链接 <a href="https://movie.douban.com/subject/1291560/">
# 影片图片链接
findImgSrc = re.compile(r'<img.*src="(.*?)"', re.S)  # re.S让换行符包含在字符中
# 影片片名
findTitle = re.compile(r'<span class="title">(.*)</span>')
# 影片评分
findRating = re.compile(r'<span class="rating_num" property="v:average">(.*)</span>')
# 评价人数
findJudge = re.compile(r'<span>(\d*)人评价</span>')
# 找到概况
findInq = re.compile(r'<span class="inq">(.*)</span>')
# 相关内容
findBd = re.compile(r'<p class="">(.*?)</p>', re.S)

def main():
    baseUrl = "https://movie.douban.com/top250?start="
    # 1. 爬取网页
    dataList = GetData(baseUrl)
    savePath = "豆瓣电影Top250.xls"  # excel保存地址
    dbPath = "豆瓣电影Top250.db"  # 数据库地址
    # 3. 保存数据
    # SaveData(savePath, dataList)  # 将数据保存到excel
    SaveData2DB(dbPath, dataList)



# 爬取网页
def GetData(baseUrl):

    dataList = []
    for i in range(0, 10):  # 调用获取页面信息的函数, 10次
        url = baseUrl + str(i*25)
        html = AskUrl(url)  # 保存获取到的网页源码

        # 2. 逐一解析数据
        soup = BeautifulSoup(html, "html.parser")
        for item in soup.find_all('div', class_="item"):  # div标签, class(属性) = item
            # print(item)  # 测试, 查看电影item, 全部信息
            data = []  # 保存一部电影的所有信息
            item = str(item)  # 变成字符串, 方便用正则表达式

            # 影片详情的链接
            link = re.findall(findLink, item)[0]  # re库用来通过正则表达式查找指定的字符串
            data.append(link)
            imgSrc = re.findall(findImgSrc, item)[0]
            data.append(imgSrc)

            titles = re.findall(findTitle, item)
            # 影片可能只有一个中文名, 也可能有一个中文名和一个外文名, 需要分别处理
            if(len(titles) == 2):
                ctitle = titles[0]
                data.append(ctitle)  # 中文名
                otitle = titles[1].replace("/", "")
                data.append(otitle)  # 外文名, 去掉/
            else:
                data.append(titles[0])  # 中文名
                data.append(' ')  # 留空

            rating = re.findall(findRating, item)[0]
            data.append(rating)

            judgeNum = re.findall(findJudge, item)[0]
            data.append(judgeNum)

            inq = re.findall(findInq, item)
            if len(inq) != 0:
                inq = inq[0].replace("。", "")
                data.append(inq)
            else:
                data.append(" ")

            bd = re.findall(findBd, item)[0]
            bd = re.sub('<br(\s+)?/>(\s+)?', " ", bd)  # 去掉<br/>
            bd = re.sub('/', " ", bd)  # 替换/
            data.append(bd.strip())

            dataList.append(data)  # 保存处理好的一部电影信息

    # print(dataList)
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
        # print(html)
    except urllib.error.URLError as e:
        if hasattr(e, "code"):  # 如果返回信息中有"code"标签, 则打印出来
            print(e.code)
        if hasattr(e, "reason"):
            print(e.reason)

    return html


# 将数据保存到excel
def SaveData(savePath, dataList):
    print("save....")
    book = xlwt.Workbook(encoding="utf-8", style_compression=0)  # 创建workBook对象
    sheet = book.add_sheet('sheet1', cell_overwrite_ok=True)  # 创建工作表
    col = ("电影详情链接", "图片链接", "中文名", "外文名", "评分", "评价数", "概况", "相关信息")  # 列名
    for i in range(0, 8):
        sheet.write(0, i, col[i])  # 列名
    for i in range(0, 250):  # 保存250条信息
        print("第%d条" % (i+1))
        data = dataList[i]
        for j in range(0, 8):  # 每条信息有8列
            sheet.write(i+1, j, data[j])
    print("爬取完毕!")
    book.save(savePath)  #  # 将数据




# 将数据保存到SQLite
def SaveData2DB(dbPath, dataList):
    Init_db(dbPath)
    conn = sqlite3.connect(dbPath)
    cur = conn.cursor()
    for data in dataList:
        for index in range(len(data)):
            if index == 4 or index == 5:  # 第四列和第五列是评分和评价人数, 是数字不是字符串, 所以不需要加双引号
                continue
            data[index] = '"' + data[index] + '"'  # 给每一项数据加双引号
        sql = '''
            insert into movie250 (
                info_link, pic_link, cname, ename, score, rated, introduction, info
            )  
            values(%s)''' % ",".join(data)  # 用逗号把data中的数据隔开, 并链接到每一列, 因为id设置了自增, 所以不需要手动插入
        print(sql)
        cur.execute(sql)
        conn.commit()
    cur.close()
    conn.close()



def Init_db(dbPath):
    sql = '''
        create table movie250
        (
            id integer primary key autoincrement,
            info_link text, 
            pic_link text, 
            cname varchar,
            ename varchar,
            score numeric,
            rated numeric, 
            introduction text,
            info text
        )
    '''  # 创建数据表

    conn = sqlite3.connect(dbPath)
    cursor = conn.cursor()
    cursor.execute(sql)
    conn.commit()
    conn.close()


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()
    # Init_db("MovieTest.db")  # 测试数据库初始化结果
    print("爬取完毕!")
# See PyCharm help at https://www.jetbrains.com/help/pycharm/
