#!/usr/bin/env groovy
pipeline {
    agent any    
    
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

            steps {
                script {
                    echo "building the application"
                    gv.buildJar()
                }
            }
        }
        stage("deploy") {

            steps {
                script {
                    echo "deploying the application"
                   gv.deployApp()
                }
            }
        }
   }   
}
  
