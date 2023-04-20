Main.class: Main.java GUI.class BackgroundPanel.class Logger.class Aircraft.class
	javac -g Main.java
GUI.class: GUI.java BackgroundPanel.class Logger.class
	javac -g GUI.java
Logger.class: Logger.java Aircraft.class
	javac -g Logger.java
Aircraft.class: Aircraft.java
	javac -g Aircraft.java
BackgroundPanel.class: BackgroundPanel.java
	javac -g BackgroundPanel.java

run: Main.class
	java Main

clean:
	rm *.class

debug: Main.class
	jdb Main