# -*- coding = utf-8 -*-
# @Time: 2021/5/17 16:17
# @Author: ZSL
# @File: 6 逛超市.py
# @Software: PyCharm

# 打印商品清单
productList = [["iphone", 6888], ["MacPro", 14800], ["小米6", 2499], ["Coffee", 31], ["Book", 60], ["Nike", 699]]
print("-"*10, "商品列表", "-"*10)

productIndex = 0
for product in productList:  # 逐个打印
    print("%d\t%s\t%d" % (productIndex, product[0], product[1]))
    productIndex += 1

shopTrolley = []  # 购物车

productNumber = input("请输入要购买的商品编号:")

while not(productNumber is "q"):
    shopTrolley.append(productList[int(productNumber)])  # 添加被选择的物品
    productNumber = input("请输入要购买的商品编号(按q结束购物):")

print("-"*10, "购物清单", "-"*10)
productIndex = 0
for product in shopTrolley:  #打印购物车
    print("%d\t%s\t%d" % (productIndex, product[0], product[1]))
    productIndex += 1
