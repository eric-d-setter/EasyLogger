import com.easylogger.log.CustomLevel;
import com.easylogger.log.EasyLog;

public class Testing {
    private static final String PREFIX = "FooBarTest";
    private static final CustomLevel wack = new CustomLevel(System.out, "WACK");
    public static void main(String[] args) {
        foo();
    }

    private static void foo() {
        EasyLog.logWithLocation(PREFIX,"This is foo");
        EasyLog.log("This is also foo");
        EasyLog.logErrorWithLocation("This is an error");
        bar();
    }

    private static void bar() {
        EasyLog.logBreadcrumbs(2, PREFIX,"This is bar");
        EasyLog.logWithLocation(wack, "Hello");
        EasyLog.logWarnWithLocation(PREFIX,"This is a warning");
        EasyLog.log(PREFIX, "This could also be bar");
    }
}
