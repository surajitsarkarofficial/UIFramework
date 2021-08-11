package manager;

public interface IReportManager {

    public IReportManager initReport();
    //public Object getReport();
    public  void createTest(String testName);
    public void publishReport();
    public void log(Enum e, String msg);

    public Object getTest();
}
