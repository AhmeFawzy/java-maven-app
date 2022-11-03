def gv
pipeline {
    agent any    
    tools {
        maven 'maven-3.8.6'
    }
    stages {
        stage ("init") {
            steps {
                script{
                gv = load "script.groovy"
            }
            }
        }
        stage("test") {            
            steps {
                script {
                    echo "deploying the branch $BRANCH_NAME"
                    gv.buildJar()
                }
            }
        }
        stage("build ") {
            steps {
                script {
                    
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    
                    gv.deployApp()
                }
            }
        }
   }   
}
  
