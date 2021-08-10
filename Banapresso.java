package com.koreait.crawling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Banapresso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String DRIVER_ID = "webdriver.chrome.driver";
		String DRIVER_PATH = "C:/somin/JSP3/chromedriver.exe";
		
		System.setProperty(DRIVER_ID, DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		
		String base_url = "https://www.banapresso.com/store";
		
		try {
			driver.get(base_url);
			Thread.sleep(1000); //스크롤 아래로 내리기
			
			int i = 2;
			while(true) {
				try {
					Thread.sleep(1000);
					List<WebElement> elements = driver.findElements(By.className("store_name_map"));
					for(WebElement el : elements) {
						 String[] temp = el.getText().split("\n");
			               System.out.println(temp[1]);
			               System.out.println(temp[2]);
			               System.out.println("------------지점-------------");

					} 
					if(i % 6 == 0) {
						List<WebElement> Nextpage = driver.findElements(By.cssSelector("div.pagination > span > a"));
						for(WebElement el : Nextpage) {
							if(el.getText().equals("다음")) {
								el.click();
								i = 2;
								break;
							}
						}
					}else {
						  WebElement Nextpage = driver.findElement(By.cssSelector("div.pagination > ul > li:nth-child("+ i +") > a"));
						  Nextpage.click();
						  i++;

					}
					
				}catch(Exception e) {
					System.out.println("프로그램을 종료합니다");
					break;
				}
		
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
