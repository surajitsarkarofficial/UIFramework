package dataProviders;

import commons.FrameworkConstants;
import commons.Utilities;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;

public class SearchProductDataProvider {

    @DataProvider(name="searchProduct",parallel = true)
    public Object[] getSearchProductData() throws FileNotFoundException {
        JSONObject data = Utilities.parseJsonFile(FrameworkConstants.DATAPATH+ File.separator+"searchProduct.json");
        JSONArray dataSets =data.getJSONArray("dataset");
        Object[][] obj = new Object[dataSets.length()][2];
        for(int index=0;index<dataSets.length();index++)
        {
            JSONObject jsonObject = dataSets.getJSONObject(index);
            obj[index][0] = jsonObject.get("productName");
            obj[index][1] = jsonObject.get("expectedText");
        }
        return obj;
    }
}
