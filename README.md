# EasyLogger
Did you ever find yourself using copious amounts of log statements in order to narrow in on that single pesky bug? Were you upset with how little information you were able to glean from your pages and pages of log lines? Well here's something that should help a little bit.

Features:
* A clean tool with limited requirements
* The ability to log method names where the call was used
* The ability to also log the methods that called the current method

DOWNLOAD HERE: https://github.com/eric-dybsetter/EasyLogger/releases

How to use:

1. Download JAR.
2. Add JAR to your current project. (IDE Recommended)
3. Set up import.
   It should look like:
   ![setup](https://github.com/eric-dybsetter/EasyLogger/assets/152906974/db0ae4f3-3310-4061-8e48-8d572cae49ba)
4. Enjoy!
   It will give you logs in this form:
   `2024-01-09T18:02:59.345Z INFO  | location:@Main.bar() @Main.foo() @Main.main() | [FOOBAR] Here be logs.`

CURRENTLY WIP BUT WILL BE ADDING MORE FEATURES
