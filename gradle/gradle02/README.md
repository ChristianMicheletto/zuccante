# gradle 02
Qui vediamo i [FileCollection](https://docs.gradle.org/current/javadoc/org/gradle/api/file/FileCollection.html) al 19.2 della guida.
```
// Using a relative path
File configFile = file('src/config.xml')

// Using an absolute path
configFile = file(configFile.absolutePath)

// Using a File object with a relative path
configFile = file(new File('src/config.xml'))
```
Ecco un esempio in cui definiamo un fileCollection
```
FileCollection collection = files('src/file1.txt',
 new File('src/file2.txt'),
 ['src/file3.txt', 'src/file4.txt'])
```
Questo è quanto possiamo fare con un fileCollection
```
// Iterate over the files in the collection
collection.each { File file ->
    println file.name
}

// Convert the collection to various types
Set set = collection.files
Set set2 = collection as Set
List list = collection as List
String path = collection.asPath
File file = collection.singleFile
File file2 = collection as File

// Add and subtract collections
def union = collection + files('src/file3.txt')
def different = collection - files('src/file3.txt')
```
