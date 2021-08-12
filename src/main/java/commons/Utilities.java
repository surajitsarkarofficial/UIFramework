package commons;

import manager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
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
        String destinationPath = FrameworkConstants.USRDIR+File.separator+"Screenshots"+File.separator+"SCRSHT_"+getCurrentDateTime("ddMMyyhhmmssSS")+".png";
        FileUtils.copyFile(scr,new File(destinationPath));
        return destinationPath;
    }

    /**
     * This method will parse a json file and return the json object
     * @param file
     * @return JSONObject
     */
    public static JSONObject parseJsonFile(String file) throws FileNotFoundException {
        InputStream is = new FileInputStream(new File(file));
        JSONTokener tokener = new JSONTokener(is);
        return new JSONObject(tokener);

    }
}
