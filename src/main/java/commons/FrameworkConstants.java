package commons;

import java.io.File;

public final class FrameworkConstants {

    private FrameworkConstants(){}


    public  static final String USRDIR = System.getProperty("user.dir");
    public static final String DATAPATH = USRDIR+ File.separator+"src"+File.separator+"test"
                                            +File.separator+"data";

}
