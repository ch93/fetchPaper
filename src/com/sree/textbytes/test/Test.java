package com.sree.textbytes.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.sree.textbytes.readabilityBUNDLE.Article;
import com.sree.textbytes.readabilityBUNDLE.ContentExtractor;

public class Test
{
	public static void main(String[] args)
	{
		//
		String url = "http://news.qq.com/a/20151101/034156.htm";
		
		Document doc = null;
		try
		{
			doc = Jsoup.connect(url).userAgent("Mozilla").timeout(30000).get();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		
		Article article = new ContentExtractor().extractContent(doc.body().toString(), "ReadabilitySnack");
		//带 html 标签
		String content = article.getCleanedArticleText();
		System.out.println(content);
		//去除 html 标签，如 <p> <h1>
		content = Jsoup.parse(content).text();
		System.out.println("\n----------------------------------------------------\n");
		System.out.println(content);
	}
}
