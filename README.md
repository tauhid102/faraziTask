🚀 How to Run
1. Clone or download the project
bash
Copy
Edit
git clone https://github.com/your-repo/farazi-automation.git
cd farazi-automation
2. Open in an IDE (Eclipse / IntelliJ IDEA / VS Code)
Import as a Java Project.

Add Selenium .jar files to the Build Path.

3. Update ChromeDriver path (if required)
If chromedriver is not in PATH, set it explicitly:

java
Copy
Edit
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
4. Run the script
Right-click on faraziLogin.java → Run as → Java Application.

📌 Notes
The script uses Thread.sleep() for waits — replace with WebDriverWait for better stability in production.

ChromeDriver must match your Chrome version.