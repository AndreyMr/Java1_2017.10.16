package ru.spec.java1.lec7;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.MapProperty;

public class EntryPoint {

	public static void main(String[] args) throws Exception {
//		specUrls();
		
		ObjectMapper mapper = new ObjectMapper();
		SearchResult result = mapper
				.readValue(new URL("https://api.hh.ru/vacancies?text=java"), 
						SearchResult.class);
		
		result.getItems().forEach(item->System.out.println(item.getName()));
		

	}

	private static void specUrls() throws IOException, MalformedURLException {
		Document doc = Jsoup.parse(new URL("http://specialist.ru/"),5_000);
		Elements refs = doc.select(".menu_main a");
		for (Element ref : refs) {
			System.out.println(ref.text());
			System.out.println(ref.attr("href"));
			System.out.println();
		}
	}

}
