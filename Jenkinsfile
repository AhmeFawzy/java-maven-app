def gv
pipeline {
    agent any    
     tools{
        maven 'maven-3.8.6'    
     }
    
    stages {
        stage("init") {            
            steps {
                script {
                    echo " testing the integration"
                    echo " i missed her way so much "
                    gv = load "script.groovy"
                    
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                    gv.deployApp()
                }
            }
        }
   }   
}
  
