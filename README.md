档案管理系统
=============

### 系统描述
		在校期间做的第一个完整的用于线上使用的项目。

### 功能简介
		普通用户：
			查看并下载文档；
			修改用户名密码；
			档案搜索和查找；
		档案管理员：
			数据备份；
			导入数据；
			添加档案；
			录入档案；
			普通用户的所有功能；
		超级管理员：
			权限管理；
			档案管理员的所有功能；

### 实现方式
		后端使用语言：java
		Web Server：Apache Tomcat
		数据持久化：mysql
		操作数据库：Hibernate
		前端框架：jQuery/jQueryUI
		word转pdf：openOffice
		pdf/png/jpg转swf：swfTools
		swf文件的页面展示：Flexpaper
		多文件上传：Uploadify
		录入文档：ZUI框架的富文本插件

### 需求分析
![需求](https://github.com/JYFiaueng/KPArchiveMIS/blob/master/docs/档案管理系统.png)

### 如何部署
		1、下载系统源码
		2、下载mysql便携版
		3、下载openOffice便携版[点此下载](http://www.openoffice.org/zh-cn/download/)
		4、下载swfTools[点此下载](http://www.swftools.org/download.html)
		5、下载安装myeclipse 2010及以上版本
		6、jdk使用6.0及以上版本
		7、将便携版的mysql、openOffice、swfTools放入tomcat的bin目录中
		8、修改tomcat的项目目录，指定在tomcat根目录的外面，在tomcat/conf/server.xml 158行中修改
		9、mysql表结构：
![目录结构](https://github.com/JYFiaueng/KPArchiveMIS/blob/master/docs/bin目录.png)
![目录结构](https://github.com/JYFiaueng/KPArchiveMIS/blob/master/docs/mysql.png)

### 用户文件存储方式：
		用户上传的源文件都会以二进制文件（blob）的形式存储在数据库中。
		在编译后代码的userFile目录中会将用户上传的文件和转换的文件全部存储一份。
		存储结构：
![文件持久化](https://github.com/JYFiaueng/KPArchiveMIS/blob/master/docs/文件目录组织结构.png)

### 最终效果
![1](https://github.com/JYFiaueng/KPArchiveMIS/blob/master/docs/效果1.png)
![2](https://github.com/JYFiaueng/KPArchiveMIS/blob/master/docs/效果2.png)