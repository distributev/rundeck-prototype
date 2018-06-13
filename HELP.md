# How to start client server

### Installing npm
First of all you need npm to be installed. It is available at the following link: https://nodejs.org/en/download/
To verify it is installed correctly please use these commands:
```
node -v 
npm -v
```

### Installing angular CLI
It is required to have installed angular CLI if you want run project onto embedded server.
To install angular CLI please use command 
```
npm install -g @angular/cli
```

### Start the server
To start the server you should move to client folder and serve the application
``` 
cd client
# and 
ng serve
```


# How to start backend server
Please move to /server directory 
```
cd server
```

### How to build executable jar file
Using gradlew or gradlew.bat located in `server` directory execute task `build`
Mac OS: ``./gradlew build``
Windows: ``gradlew.bat build``

### How to start built application
To start the server with the application please execute following command from the current directory:
```
java -jar build/libs/server-0.0.1-SNAPSHOT.jar
```