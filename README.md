# circuitQA
A QA-system about circuit knowledge for students
20200920 增加了HanLP工具的使用，参照https://github.com/hankcs/HanLP/tree/1.x需要：

1.下载HanLP的两个文件data.ziphttp://nlp.hankcs.com/download.php?file=data
和hanlp-release.ziphttp://nlp.hankcs.com/download.php?file=jar

2.分别解压后得到hanlp-1.7.6.jar和data文件夹

3.把data文件夹移动到java项目中(我这里为了使项目精简，把此文件夹放到了本地C:/hanLP文件夹下)
将jar包引入到项目中

4.修改hanlp.properties中的root路径（data的父目录）：
root=C:/hanLP
在CustomDictionaryPath中加入自定义词典circuitDict.txt

