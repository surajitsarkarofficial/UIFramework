package manager.reports;

import manager.IReportManager;

public class AllureManager implements IReportManager {
    @Override
    public IReportManager initReport() {
        System.out.println("Report is set for Allure test..");
        return this;
    }

    @Override
    public Object getReport() {
        return null;
    }

    @Override
    public void createTest(String testName) {

    }

    @Override
    public void publishReport() {

    }

    @Override
    public void log(Enum e, String message) {

    }
}
