## **智能教育系统 包括问答系统和答题系统两部分**

采用技术：java8、js、springboot、vue2、mybatis、Es、jsoup等、算法正在研究中
后续需要部署到服务器上，使用screw生成数据库文档。

A QA-system about circuit knowledge for students
20200920 增加了HanLP工具的使用，参照https://github.com/hankcs/HanLP/tree/1.x
需要：

- 下载HanLP的两个文件data.zip
http://nlp.hankcs.com/download.php?file=data
和hanlp-release.zip
http://nlp.hankcs.com/download.php?file=jar

- 分别解压后得到hanlp-1.7.6.jar和data文件夹

- 把data文件夹移动到java项目中(我这里为了使项目精简，把此文件夹放到了本地C:/hanLP文件夹下)
将jar包引入到项目中

- 修改hanlp.properties中的root路径（data的父目录）：
root=C:/hanLP
在CustomDictionaryPath中加入自定义词典circuitDict.txt

