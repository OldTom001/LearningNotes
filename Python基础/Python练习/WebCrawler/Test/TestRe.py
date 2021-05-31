# -*- coding = utf-8 -*-
# @Time: 2021/5/28 17:54
# @Author: ZSL
# @File: TestRe.py
# @Software: PyCharm

# 正则表达式: 字符串模式, 判断字符串是否符合一定的标准

import re

# 创建模式对象
pat = re.compile("AA")  # 此处的AA是正则表达式, 用来检验其他的字符串
m = pat.search("CBA")  # CBA是被检验的字符串
print(m)  # 返回none表示没有匹配的结果

m = pat.search("ABCAA")
print(m)  # 下标3,4匹配

m = pat.search("ABCAADDCCAA")
print(m)  # search方法只返回第一次匹配的结果


# 不创建模式对象
m = re.search("asd", "Aasd")  # 第一个参数是规则, 第二个参数是被检验的对象
print(m)

print(re.findall("a", "ASDaDFGAa"))  # 前面字符串是规则(正则表达式), 后面字符串是被检验的字符串, 打印所有符合条件的字符串

print(re.findall("[A-Z]", "ASDaDFGAa"))  # 打印字符串中所有大写字母

print(re.findall("[A-Z]+", "ASDaDFGAa"))  # >=一个大写字母则匹配

# sub, 替换
print(re.sub("a", "A", "abcdcasd"))  # 找到a, 并用A替换
# 建议在正则表达式中, 被检验的字符串前加上r, 避免转义字符的问题
a = r"\aadafsd-\'"
print(a)
