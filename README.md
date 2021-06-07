## Building the project
From the root of the project directory run the maven package command:
`mvn package`

If you do not have maven installed locally you can user the wrapper files

## Running the project

The package command will create a jar under the target directory. Run the jar file passing in the directory of the file you want to run the word counter on. For example:
On windows: ```java -jar target\WordCounter-1.0.0.jar src\test\resources\example.txt```
On linux: ```java -jar target/WordCounter-1.0.0.jar src/test/resources/example.txt```


