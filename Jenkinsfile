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
                BRANCH_NAME == 'master || jenkins-shared-lib'
            }
        }
            steps {
                script {
                    echo "deploying the branch $BRANCH_NAME"
                    buildJar()
                }
            }
        }
        stage("build and push image") {

            steps {
                script {
                    
                    buildImage '207.154.251.118:8083/microsoft:jenkins-shared-lib222'
                    DockerLogin()
                    dockerPush'207.154.251.118:8083/microsoft:jenkins-shared-lib222'
                }
            }
        }
        stage("deploy") {
            when{
                expression {
                    BRANCH_NAME == 'master || jenkins-shared-lib'
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
  
