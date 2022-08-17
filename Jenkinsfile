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
        when {
            expression{
                BRANCH_NAME == 'master'
            }
        }
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
                    
                    buildImage '207.154.251.118:8083/new-test-shared:1.0'
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
  
