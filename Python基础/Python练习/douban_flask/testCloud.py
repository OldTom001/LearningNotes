# -*- coding = utf-8 -*-
# @Time: 2021/6/4 16:15
# @Author: ZSL
# @File: testCloud.py
# @Software: PyCharm

import jieba  # 分词
from matplotlib import pyplot as plt  # 绘图, 数据可视化
from wordcloud import WordCloud, STOPWORDS  # 词云
from PIL import Image  # 图片处理
import numpy as np  # 矩阵运算
import sqlite3  # 数据库


con = sqlite3.connect('豆瓣电影Top250.db')
cur = con.cursor()
sql = 'select introduction from movie250'
data = cur.execute(sql)
text = ''
for item in data:
    text = text + item[0]
# print(text)
cur.close()
con.close()

# 分词, 将句子拆分成一个一个词, 用空格隔开
cut = jieba.cut(text)
string = ''
# 去除单字
for everyWord in cut:
    if len(everyWord) == 1:
        continue
    string = string + everyWord + ' '
    # string = ' '.join([string, everyWord])  # 和上面的语句效果一样
print(string)  # 打印分词结果


# img = Image.open(r'.\static\assets\img\tree.jpg')  # 打开遮罩图片
# img_array = np.array(img)  # 将图片转换成数组
#
# wc = WordCloud(
#     background_color='white',
#     mask=img_array,
#     font_path="msyh.ttc",  # 字体所在位置:C:\Windows\Fonts
#     stopwords=STOPWORDS
# )
# wc.generate_from_text(string)  # 生成词云图片
# fig = plt.figure(1)
# plt.imshow(wc)
# plt.axis('off')  # 是否显示坐标轴
#
# # plt.show()  # 显示生成的词云图片
#
# plt.savefig(r'.\static\assets\img\word.jpg', dpi=500)
