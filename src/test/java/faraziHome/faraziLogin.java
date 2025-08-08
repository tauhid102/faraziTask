package faraziHome;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class faraziLogin {
	
	static WebDriver driver;
	static String signUpField="//label[text()='%s']/following-sibling::div/input";
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		
		try {
			driver.get("https://farazi.staging.dokandev.com/");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			WebElement signUp=driver.findElement(By.xpath("(//a[@class='hover:text-primary-500'])[4]"));
			signUp.click();
			Thread.sleep(3000);
			String currentUrl=driver.getCurrentUrl();
			String expectedUrl="https://farazi.staging.dokandev.com/register";
			if(currentUrl.equalsIgnoreCase(expectedUrl)) {
				System.out.println("Landed successfully in the signup page");
			}
			else {
				System.out.println("User not in the expected Page.");
			}
			//create a new account
			WebElement firstName=driver.findElement(By.xpath(String.format(signUpField,"First Name")));
			firstName.sendKeys("Tauhid");
			WebElement lastName=driver.findElement(By.xpath(String.format(signUpField,"Last Name")));
			lastName.sendKeys("Rahman");
			
			String gmail=generateGmail("test");
			WebElement email=driver.findElement(By.xpath(String.format(signUpField,"Email")));
			email.sendKeys(gmail);
			Thread.sleep(2000);
			WebElement password=driver.findElement(By.xpath(String.format(signUpField,"Password")));
			password.sendKeys("12345678@");
			WebElement confirmPassword=driver.findElement(By.xpath(String.format(signUpField,"Confirm Password")));
			confirmPassword.sendKeys("12345678@");
			Thread.sleep(3000);
			
			WebElement createAccBtn=driver.findElement(By.xpath("//button[contains(text(),'Create Account')]"));
			createAccBtn.click();
			Thread.sleep(3000);
			System.out.println(gmail);
			
			//login to the system
			WebElement loginEmail=driver.findElement(By.xpath("//input[@name='email']"));
			loginEmail.sendKeys(gmail);
			WebElement loginPass=driver.findElement(By.xpath("//input[@name='password']"));
			loginPass.sendKeys("12345678@");
			WebElement signInBtn=driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
			signInBtn.click();
			Thread.sleep(5000);
			
			String actPageTitle=driver.getTitle();
			String expactedTitle="Sell your products on Jamuna Future Park";
			if(actPageTitle.equalsIgnoreCase(expactedTitle)) {
				System.out.println("User login to the system successfully");
			}
			else {
				System.out.println("User unable to login the system");
			}
			
			
			
			//navigate to my account page
			WebElement profilebtn=driver.findElement(By.xpath("(//p[text()='Hello'])[2]"));
			profilebtn.click();
			WebElement profile=driver.findElement(By.xpath("//a[text()='My Account']"));
			profile.click();
			//navigate to edit page
			Thread.sleep(5000);
			WebElement edit=driver.findElement(By.xpath("//a[text()='Edit']"));
			edit.click();
			Thread.sleep(3000);
			
			WebElement profileHeading=driver.findElement(By.xpath("//h2[text()='Edit Profile']"));
			String parofileHeadingtitle=profileHeading.getText();
			String actText="Edit Profile";
			if(parofileHeadingtitle.equalsIgnoreCase(actText)) {
				System.out.println("User on the edit profile page");
			}
			else {
				System.out.println("User is not on the edit profile page.");
			}
			
			
			
			//update my account information
			WebElement updateName=driver.findElement(By.xpath(String.format(signUpField,"First Name")));
			updateName.clear();
			updateName.sendKeys("Muhit");
			WebElement updateMobile=driver.findElement(By.xpath(String.format(signUpField,"Mobile")));
			updateMobile.clear();
			updateMobile.sendKeys("01551807434");
			WebElement svaeChanges=driver.findElement(By.xpath("//button[text()='Save Changes']"));
			svaeChanges.click();
			Thread.sleep(5000);
			
			driver.navigate().refresh();
			WebElement profileName=driver.findElement(By.xpath("//div[@class='content']/p/following-sibling::p"));
			String nameText=profileName.getText();
			String actName="Muhit";
			if(nameText.equalsIgnoreCase(actName)) {
				System.out.println("Profile update successfully");
			}
			else {
				System.out.println("Profile is not update successfully.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Thread.sleep(5000);
			driver.close();
		}

	}
	 public static String generateGmail(String prefix) {
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder randomPart = new StringBuilder();
	        Random rnd = new Random();

	        for (int i = 0; i < 5; i++) {
	            randomPart.append(characters.charAt(rnd.nextInt(characters.length())));
	        }

	        return prefix + randomPart.toString() + "@gmail.com";
	    }

}
