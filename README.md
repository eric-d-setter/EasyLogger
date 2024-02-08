# EasyLogger
Did you ever find yourself using copious amounts of log statements in order to narrow in on that single pesky bug? Were you upset with how little information you were able to glean from your pages and pages of log lines? Well here's something that should help a little bit.

Features:
* A clean tool with limited requirements
* The ability to log method names where the call was used
* The ability to also log the methods that called the current method

DOWNLOAD [HERE](https://github.com/eric-d-setter/EasyLogger/releases) 

How to use:

1. Download JAR.
2. Add JAR to your current project. (IDE Recommended)
3. Set up import. <br>
   It should look like:
   ![setup](https://github.com/eric-dybsetter/EasyLogger/assets/152906974/db0ae4f3-3310-4061-8e48-8d572cae49ba)
4. Enjoy!
   It will give you logs in this form: <br>
   `2024-01-09T18:02:59.345Z INFO  | location:@Main.bar() @Main.foo() @Main.main() | [FOOBAR] Here be logs.`

Types of Logs:

There are a variety of different methods you can use (all methods are overloaded):

`public static void log(String logMessage)`<br>
`public static void log(String prefix, String logMessage)`<br>
The most basic of logs, will simply log your message at the point in the code where it is written.

`public static void logWithLocation(String logMessage)`<br>
`public static void logWithLocation(String prefix, String logMessage)`<br>
Logs the method where the log method was called along with your message.

`public static void logBreadcrumbs(String logMessage)`<br>
`public static void logBreadcrumbs(int depth, String logMessage)`<br>
`public static void logBreadcrumbs(int depth, String prefix, String logMessage)`<br>
Logs the current method and every calling method based on the `depth`. By default, it will log the current method and the method that called the prior method. The depth parameter defines how many methods + the current method to log.
<br>i.e. - `depth` == 2
<br>`MyClass.bar()` - depth: 0 <--- logBreadcrubs() called here
<br> |--->`MyClass.foo()` - depth: 1
<br> ______|--->`MyClass.main()` - depth: 2      

There are 3 default log levels that you can log to: INFO, WARN, and ERROR. INFO and WARN write to System.out and ERROR writes to System.err. <br>
Examples: `log() - logWithLocation() - logBreadcrumbs()` `logWarn() - logWarnWithLocation() - logWarnBreadcrumbs()` `logError() - logErrorWithLocation() - logErrorBreadcrumbs()`<br>

There is also the ability to create custom log levels. Using the [`CustomLevel`](https://github.com/eric-d-setter/EasyLogger/blob/main/EasyLogger/src/com/easylogger/log/CustomLevel.java) class you define the `PrintStream` where the logs should be written (such as System.out and System.err) and the descriptor for the level (such as INFO, WARN, ERROR). After creating an instance of [`CustomLevel`](https://github.com/eric-d-setter/EasyLogger/blob/main/EasyLogger/src/com/easylogger/log/CustomLevel.java), you can pass the instance as the first parameter into the basic log methods (i.e. `log() - logWithLocation() - logBreadcrumbs()`).

CURRENTLY WIP BUT WILL BE ADDING MORE FEATURES
