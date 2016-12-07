# gradle 08
Abbiamo tratto il custom task dalla seguente fonte:[qui](https://github.com/gradle/oreilly-gradle-book-examples/blob/master/tasks-custom-task-buildsrc/buildSrc/src/main/groovy/org/gradle/example/task/MySqlTask.groovy)
```
class MySqlTask extends DefaultTask {
    def hostname = 'localhost'
    def port = 3306
    def sql
    def database
    def username = 'root'
    def password = 'password'

    @TaskAction
    def runQuery() {
        def cmd
        if(database) {
            cmd = "mysql -u ${username} -p${password} -h ${hostname} -P ${port} ${database} -e "
        }
        else {
           cmd = "mysql -u ${username} -p${password} -h ${hostname} -P ${port} -e "
        }

        project.exec {
            commandLine = cmd.split().toList() + sql
        }
    }
}
```
Rimandiamo alla documentazione per `project.exec`: [qui](https://docs.gradle.org/current/javadoc/org/gradle/api/Project.html).

Ci soffermiamo in particolare sulla seguente riga
```
project.exec {
            commandLine = cmd.split().toList() + sql
        }
```
come si può osservare viene passato al metodo `exec` una closure: vedasi la [documentazione](https://docs.gradle.org/current/javadoc/org/gradle/api/Project.html#exec).
Resta da spiegare l'interno della closure. Sempre leggendo la documentazione, [qui](https://docs.gradle.org/current/dsl/org.gradle.api.tasks.Exec.html#org.gradle.api.tasks.Exec:commandLine), si vede che `commandLine` è una lista di stringhe: il comando coi sui argomenti e le sue opzioni (eccho `split().toList()`).

