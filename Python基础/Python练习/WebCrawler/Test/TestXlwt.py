# -*- coding = utf-8 -*-
# @Time: 2021/5/29 16:26
# @Author: ZSL
# @File: TestXlwt.py
# @Software: PyCharm

import xlwt

# workBook = xlwt.Workbook(encoding="utf-8")  # 创建workBook对象
# workSheet = workBook.add_sheet('sheet1')  # 创建工作表
# workSheet.write(0, 0, 'hello')  # 写入参数, 行, 列, 内容
# workBook.save('students.xls')

workBook = xlwt.Workbook(encoding="utf-8")  # 创建workBook对象
workSheet = workBook.add_sheet('sheet1')  # 创建工作表
for i in range(0, 9):
    for j in range(0, i+1):
        workSheet.write(i, j, "%d * %d = %d"%(i+1, j+1, (i+1)*(j+1)))

workBook.save('students.xls')