package cn.sysu.circuitQA.utils;

import cn.sysu.circuitQA.pojo.Questionspider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class HtmlParseUtil {
    // Test
    public static void main(String[] args) throws IOException {
        Questionspider a = paraseQuetion("什么是拉普拉斯变换");
        System.out.println(a.getAnswer());

    }

    public static Questionspider paraseQuetion(String question) throws IOException {
        question = "百度知道电路" + question;
        // 从百度知道上面爬取问题 把问题转换为GBK编码

        // 获取请求 从百度搜索找到页面上百度知道的URL来跳转
        String url = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=" + question;
        // 解析网页 Jsoup返回Document就是浏览器对象
        Document document = Jsoup.parse(new URL(url), 30000);
        Elements elementsByClass = document.getElementsByClass("wenda-abstract-wrap-new c-border");
        Elements a = elementsByClass.get(0).getElementsByTag("a");
        String answerHref = a.attr("href");

        //百度知道没有就到知乎上查找


        //跳转到百度知道页面解析
        Document documentAnswer = Jsoup.parse(new URL(answerHref), 30000);
        Element element = documentAnswer.getElementById("wgt-best");
        Elements lineContent = element.getElementsByClass("line content");
        Elements contentClass = lineContent.get(0).getElementsByClass("best-text mb-10");   //找到内容

        // 正则删除
        String replace = "展开全部";
        String content = contentClass.text();
        Pattern p = Pattern.compile(replace);
        Matcher m = p.matcher(content);
        content = m.replaceAll("");

        String replace1 = " ";
        Pattern p1 = Pattern.compile(replace1);
        Matcher m1 = p1.matcher(content);
        content = m1.replaceAll("");

        //返回对象
        Questionspider questionspider = new Questionspider();
        questionspider.setQuestion(question);
        questionspider.setAnswer(content);


        return questionspider;
    }
}
