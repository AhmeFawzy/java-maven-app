pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0','1.3.0'],description: '')
        booleanParam(name:'excuteTests', defaultValue: true, description: 'version to deploy on prod')
     }
     stages {        
         stage ("build") {
             steps {
                 echo "building the app"
             }
         }
         stage ("test") {
             when {
                expression {
                    params.excuteTests == true
                }
            }
             steps {
                 echo "testing the app"
             }
         }
         stage ("deploy") {
             steps {
                 echo "deploying the app"
                 echo " deploying verison ${params.VERSION}"
             }
         }
     }
}
