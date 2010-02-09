Google AI Challenge in Clojure
------------------------------

This is a sample starter package for the 2010 Google AI Challenge in
Clojure. If I get more time I'll update it with more translated example
bots or some of my own.

To make it work you'll have to add a jar of Clojure 1.1 (not tested with
1.0 but it should work) in a folder called deps. I've only tested it
with the included clj.bat under Cygwin in Windows XP, it should be
pretty easy to make it a bash script to work elsewhere.

## Running as a Script

To see if your setup works, run this command:

    $ java -cp "deps/clojure.jar;." clojure.main MyTronBot.clj -- < maps/empty-room.txt

You can test the sample bot using the provided batch file like this:

    $ java -jar engine/Tron.jar maps/empty-room.txt "./clj.bat MyTronBot.clj" "./clj.bat MyTronBot.clj"

## Compiling    

To compile the sample bot, you'll need first to create a directory for
the generated classes. Then it's a simple matter of calling compile:

    $ mkdir classes
    $ java -cp "deps/clojure.jar;.;classes" clojure.main -e "(compile 'MyTronBot)
    MyTronBot

After that, it's exactly like running Java classes:

    $ java -cp "deps/clojure.jar;classes" MyTronBot < maps/empty-room.txt

I've also provided a batch file to run the class version:    
    
    $ java -jar engine/Tron.jar maps/empty-room.txt "./class.bat MyTronBot" "./class.bat MyTronBot"
