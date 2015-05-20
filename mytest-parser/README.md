Parser - API jar
============================
1. use maven: 
$ mvn clean install

2. run jar
$ java -jar mytest-parser-0.0.1-SNAPSHOT.jar \
 /home/gtftsdev/Documents/eclipse.testProject/Mytest-Parser/src/test/resources/testComma.txt \
 /home/gtftsdev/Documents/eclipse.testProject/Mytest-Parser/src/test/resources/testPipe.txt \
 /home/gtftsdev/Documents/eclipse.testProject/Mytest-Parser/src/test/resources/testSpace.txt \
 BIRTH_ASC
 

3. run cobertura:
$mvn clean cobertura:instrument && mvn cobertura:cobertura