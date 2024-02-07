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
3. Set up import.
   It should look like:
   ![setup](https://github.com/eric-dybsetter/EasyLogger/assets/152906974/db0ae4f3-3310-4061-8e48-8d572cae49ba)
4. Enjoy!
   It will give you logs in this form:
   `2024-01-09T18:02:59.345Z INFO  | location:@Main.bar() @Main.foo() @Main.main() | [FOOBAR] Here be logs.`

Types of Logs:

There are a variety of different methods you can use (all methods are overloaded):

`public static void log(String logMessage)`
`public static void log(String prefix, String logMessage)`
The most basic of logs, will simply log your message at the point in the code where it is written.

`public static void logWithLocation(String logMessage)`
`public static void logWithLocation(String prefix, String logMessage)`
Logs the method where the log method was called along with your message.

`public static void logBreadcrumbs(String logMessage)`
`public static void logBreadcrumbs(int depth, String prefix, String logMessage)`
Logs the current method and every calling method based on the `depth`. By default, it will log the current method and the method that called the prior method. The depth parameter defines how many methods + the current method to log.
i.e. - `depth` == 2
`MyClass.bar()` - depth: 0 <--- logBreadcrubs() called here
 |--->`MyClass.foo()` - depth: 1
       |--->`MyClass.main()` depth: 2      

There are 3 default log levels that you can log to: INFO, WARN, and ERROR. INFO and WARN write to System.out and ERROR writes to System.err. 
Examples: `EasyLog.log() - EasyLog.logWithLocation()` `EasyLog.logWarn() - EasyLog.logWarnWithLocation()` `EasyLog.logError() - EasyLog.logErrorWithLocation()`
All logging methods follow these naming conventions so you should be able to extrapolate what each should do.

There is also the ability to create custom log levels. Using the CustomLevel class you define the PrintStream where the logs should be written (such as System.out and System.err) and the descriptor for the level (such as INFO, WARN, ERROR). After creating an instance of CustomLevel, you can pass the instance as the first parameter into the basic log methods (e.g. `EasyLog.log() - EasyLog.logWithLocation()`).

CURRENTLY WIP BUT WILL BE ADDING MORE FEATURES
