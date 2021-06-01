from flask import Flask, render_template, request  # render_template是渲染模板
import datetime

app = Flask(__name__)


# # 路由解析
# # 相当于 hello_world = app.route('/')(hello_world), 先执行route中定义的功能, 然后打印hello world
# # 网站链接以/结尾
# @app.route('/')
# def hello_world():
#     return 'hello world!'


# # 网站链接以/index结尾
# @app.route("/index")
# def hello():
#     return "你好"
#
#
# # 通过访问路径, 获取用户的字符串参数
# @app.route("/user/<name>")
# def welcome(name):
#     return "你好, %s" % name
#
#
# # 通过访问路径, 获取用户的整形参数, 此外还可以写成float类型
# @app.route("/user/<int:id>")
# def welcome2(id):
#     return "你好, %d" % id


# # 返回给用户渲染后的网站文件
# @app.route("/")
# def index2():
#     return render_template("index.html")

#
# # 向页面传递一个变量
# @app.route("/")
# def index2():
#     time = datetime.date.today()  # 普通变量
#     name = ["孙悟空", "猪悟能", "沙悟净"]
#     task = {"任务" : "打扫卫生", "时间" : "3小时"}  # 字典类型
#     return render_template("index.html", var=time, list=name, task=task)  # 给网页中的变量赋值


# 表单提交
@app.route('/test/register')
def register():
    return render_template("test/register.html")


# 接收表单提交的路由需要指定method为post
@app.route('/result', methods=["GET", "POST"])
def result():
    if request.method == "POST":  # POST必须大写, 不然没法解析
        result = request.form  # 表单中的所有内容当成一个字典
        return render_template("test/result.html", result=result)


if __name__ == '__main__':
    app.run()

