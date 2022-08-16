pipeline {
    agent any
    parameters {
        string(name:'VERSION', defaultValue: '',description: 'version to deploy on prod ')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0','1.3.0'],description: '')
        booleanParam(name:'excuteTests', defaultValue: true, description: '')
     }
     stages {
         when {
                expression {
                    params.excuteTests == true
                }
            }
         stage ("buils") {
             steps {
                 echo "building the app"
             }
         }
         stage ("test") {
             steps {
                 echo "testing the app"
             }
         }
         stage ("deploy") {
             steps {
                 echo "deploying the app"
             }
         }
     }
}
