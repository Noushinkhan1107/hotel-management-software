package java_advanced_day_15;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.WebElement;		
import org.openqa.selenium.chrome.ChromeDriver;		
import org.openqa.selenium.interactions.Actions;		


public class DragAndDrop {				

	public static void main(String args[]) throws InterruptedException					
	{		
		WebDriver driver= new ChromeDriver();					
		driver.get("http://demo.guru99.com/test/drag_drop.html");					

		//Element which needs to drag.    		
		WebElement bank = driver.findElement(By.xpath("//*[@id='credit2']/a"));	
		WebElement amount = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		WebElement sales = driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));	
		

		//Element on which need to drop.		
		WebElement column1 = driver.findElement(By.xpath("//*[@id='bank']/li"));	
		WebElement column2 = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));					
		WebElement column3 = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
		WebElement column4 = driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));					

		//Using Action class for drag and drop.		
		Actions act = new Actions(driver);					

		//Dragged and dropped.	
		act.dragAndDrop(bank,column1).build().perform();
		// Verify the element is inside the target container
		WebElement updatedColumn1 = driver.findElement(By.xpath("//*[@id='bank']/li"));

		String actualText = updatedColumn1.getText();
		if (actualText.contains("BANK")) {
			System.out.println("Drag and Drop successful: BANK is in the correct column.");
		} else {
			System.out.println("Drag and Drop failed: BANK is not in the correct column.");
		}
		Thread.sleep(2000);
		act.dragAndDrop(amount,column2).build().perform();
		Thread.sleep(2000);
		act.dragAndDrop(sales,column3).build().perform();
		Thread.sleep(2000);
		act.dragAndDrop(amount,column4).build().perform();
		
		driver.close();
	}		
}