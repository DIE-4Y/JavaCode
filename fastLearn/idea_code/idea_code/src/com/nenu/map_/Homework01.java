package com.nenu.map_;

import java.util.ArrayList;
import java.util.List;

public class Homework01 {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度教新图赴恒河\"圣浴\"引担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        List list1 = new ArrayList();
        list1.add(news1);
        list1.add(news2);

        //倒序遍历 不是数组不能用[]  substring方法能直接返回子串，方法更简单
        for (int i = list1.size() - 1; i >= 0; i--) {
            News news = (News) list1.get(i);
            try {
                String ch = news.getTitle().charAt(14) + "";
                String str1 = news.getTitle().split(ch)[0];
                news.setTitle(str1.concat("..."));
                System.out.println(news);
            } catch (Exception e) {
                System.out.println(news);
            }

//            if (news.getTitle().length() > 15){
//                String substring = news.getTitle().substring(0, 15);
//                System.out.println(substring+"...");
//            }else {
//                System.out.println(news.getTitle());
//            }
        }
    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
