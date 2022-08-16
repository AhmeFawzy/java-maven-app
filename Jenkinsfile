def gv
pipeline {
    agent any    
     tools{
        maven 'maven-3.8.6'    
     }
    
    stages {
        stage("test") {            
            steps {
                script {
                    echo "deploying the branch $BRANCH_NAME"
                    gv = load "script.groovy"
                }
            }
        }
        stage("build ") {
            when{
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    echo "building the application"
                    gv.buildJar()
                }
            }
        }
        stage("deploy") {
            when{
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    echo "deploying the application"
                    gv.deployApp()
                }
            }
        }
   }   
}
  
