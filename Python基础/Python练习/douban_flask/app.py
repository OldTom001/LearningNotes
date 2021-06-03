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
    return render_template("score.html")


@app.route('/word')
def word():
    return render_template("word.html")


@app.route('/team')
def team():
    return render_template("team.html")


if __name__ == '__main__':
    app.run()
