# 基本操作

## 创建桌面快捷方式

linux会将已安装软件的启动器存入/usr/share/applications，进入该目录，找到需要创建快捷方式的启动器，复制到桌面，右键选择允许启动即可。

直接用通过解压压缩包得到的软件不在/usr/share/applications中，以idea为例，直接在桌面新建一个xxx.desktop文件，双击打开，然后按i输入

```
[Desktop Entry]
Name=IntelliJ IDEA
Exec=/usr/local/ideaIC/bin/idea.sh
Icon=/usr/local/ideaIC/bin/idea.png
Terminal=false
Type=Application
Categories=Development
NoDisplay=true
StartupNotify=true;
```

其中Exec=是可执行文件的位置，Icon是启动器图标的位置

输入完毕后按esc，再输入:wq

![image-20210715201623357](https://gitee.com/zhu-shuailin/pictures/raw/master/pictures/image-20210715201623357.png)

关闭上述界面，右键 xxx.desktop，选择允许启动即可。