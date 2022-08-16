pipeline {
    agent any
    parameters {
        string(name:'VERSION', defaultValue: '1.55.3',description: 'version to deploy on prod ')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0','1.3.0'],description: '')
        booleanParam(name:'excuteTests', defaultValue: true, description: 'test description')
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
                 echo " deploying verison ${params.VERSION}
             }
         }
     }
}
