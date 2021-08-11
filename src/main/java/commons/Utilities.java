package commons;

import manager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

    public static String getCurrentDateTime(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String takeScreenshot() throws IOException {
        File scr =((TakesScreenshot)DriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"SCRSHT_"+getCurrentDateTime("ddMMyyhhmmssSS")+".png";
        FileUtils.copyFile(scr,new File(destinationPath));
        return destinationPath;
    }

}
