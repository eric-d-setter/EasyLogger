import com.easylogger.log.EasyLog;

public class Testing {
    public static void main(String[] args) {
        foo();
    }

    private static void foo() {
        EasyLog.logWithLocation("This is foo");
        bar();


    }

    private static void bar() {
        EasyLog.logBreadcrumbs(2,"This is bar");
    }
}
