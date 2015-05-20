A Minimal RestExpress Server
============================
A template RestExpress project that contains minimal external dependencies.

To run the project:
	mvn clean package exec:java

To create a project deployable assembly (zip file):
	mvn clean package
	mvn assembly:single

Post usage:
wget http://localhost:8081/records --post-data 'LastName | FirstName | MALE | FavoriteColor | 05/15/2015'
wget http://localhost:8081/records --post-data 'LastName, FirstName, MALE, FavoriteColor, 05/15/2015'
wget http://localhost:8081/records --post-data 'LastName FirstName MALE FavoriteColor 05/15/2015'

XML:	http://localhost:8081/records/name
JSON:	http://localhost:8081/records/name.json


