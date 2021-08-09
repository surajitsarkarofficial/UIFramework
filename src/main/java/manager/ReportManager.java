package manager;

import manager.reports.AllureManager;
import manager.reports.ExtentManager;

public class ReportManager<T> {

    private ReportManager(){
        loadReportType().initReport();
    }

    private static ReportManager instance = new ReportManager();
    private static IReportManager reportType;
    public static ReportManager getInstance()
    {
        return instance;
    }

    public void setReport()
    {
        reportType =loadReportType().initReport();
    }

    public IReportManager getReportType()
    {
        return reportType;
    }



      private IReportManager loadReportType()
    {
        String reportType=PropertyManager.getInstance().getProperty("app.reportType").toString();
        switch (reportType.toUpperCase())
        {
            case "EXTENT" -> {
                return new ExtentManager();
            }
            case "ALLURE" ->{
                return new AllureManager();
            }
            default -> throw new IllegalStateException("Unsupported report type - "+ reportType);
        }
    }
}
