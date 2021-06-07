from flask import Flask, render_template
import sqlite3

app = Flask(__name__)


@app.route('/')
def index():
    return render_template("index.html")


# 首页
@app.route('/index')
def home():
    # return render_template("index.html")
    return index()


# 电影页
@app.route('/movie')
def movie():
    movieList = []
    con = sqlite3.connect("豆瓣电影Top250.db")
    cur = con.cursor()
    sql = "select * from movie250"
    data = cur.execute(sql)
    for item in data:
        movieList.append(item)
    cur.close()
    con.close()
    return render_template("movie.html", movies=movieList)



@app.route('/score')
def score():
    score = []  # 评分
    number = []  # 每个评分的电影数量
    con = sqlite3.connect("豆瓣电影Top250.db")
    cur = con.cursor()
    # 从数据库中提取评分和每个评分对应电影数量
    sql = "select score, count(score) from movie250 group by score"
    data = cur.execute(sql)
    # 根据提取结果构造两个列表
    for item in data:
        score.append(str(item[0]))  # 不转换成字符串也可
        number.append(item[1])

    cur.close()
    con.close()
    return render_template("score.html", score=score, number=number)


@app.route('/word')
def word():
    return render_template("word.html")


@app.route('/team')
def team():
    return render_template("team.html")


if __name__ == '__main__':
    app.run()
