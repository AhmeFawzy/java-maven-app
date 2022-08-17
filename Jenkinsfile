#!/usr/bin/env groovy
@Library('jenkins-shared-lib')
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
        stage("build jar") {
            steps {
                script {
                    echo "deploying the branch $BRANCH_NAME"
                    buildJar()
                }
            }
        }
        stage("build image") {

            steps {
                script {
                    
                    buildImage()
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
                    
                    gv.deployApp()
                }
            }
        }
   }   
}
  
