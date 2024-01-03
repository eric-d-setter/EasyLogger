import com.easylogger.log.EasyLog;

public class Testing {
    private static final String PREFIX = "FooBarTest";
    public static void main(String[] args) {
        foo();
    }

    private static void foo() {
        EasyLog.logWithLocation(PREFIX,"This is foo");
        EasyLog.log("This is also foo");
        bar();
    }

    private static void bar() {
        EasyLog.logBreadcrumbs(2, PREFIX,"This is bar");
        EasyLog.log(PREFIX, "This could also be bar");
    }
}
