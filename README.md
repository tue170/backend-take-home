# Sr. Software Engineer Coding Exercise

# Summary
Write a Java command line program `quotely` which takes as an argument `English` or `Russian` and returns a quote from the forismatic API with the correct language.
If a language is not specified, default to English.

# Instructions

Please write a java program which 
1. Operates on the command line
1. Accepts a language as an argument (either `English` or `Russian`)
1. Fetches results from the forismatic.com quote api (http://forismatic.com/en/api/)
1. Displays to stdout the quote and author

# Build the Project
```aidl
./gradlew clean build
```

# Run the Project
There should be a jar file in build/libs folder after clean build.
```aidl
java -jar path\to\the\jar\back-end-take-home.jar English
```