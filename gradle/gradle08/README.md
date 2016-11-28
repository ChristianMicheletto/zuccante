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

