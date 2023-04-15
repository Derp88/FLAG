Logger.class: Logger.java Aircraft.class
	javac -g Logger.java
Aircraft.class: Aircraft.java
	javac -g Aircraft.java

run: Logger.class
	java Logger

clean:
	rm *.class

debug: Logger.class
	jdb Logger