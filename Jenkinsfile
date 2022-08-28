#!/usr/bin/env groovy
library identifier: 'jenkins-shared-library@master', retriever: modernSCM(
        [$class: 'GitSCMSource',
         remote: 'https://gitlab.com/ahmedfawzy286/jenkins-shared-library.git',
         credentialsId: 'gitlab-credintials'
        ]
)

def gv
pipeline {
    agent any    
    tools {
        maven 'maven-3.8.6'
    }
    environment {
        //IMAGE_NAME = 'flokiboats/my-repo:java-maven-'
    }
    stages {
          stage('increment version') {
            steps {
                script {
                    gv.increment ()
                }
            }
        }

        stage ("build app") {
            steps {
                script{ 
                    echo "building application jar ..."
                    buildJar()

            }
            }
        }
        stage("build and push image") {

            steps {
                script {
                    echo "building docker image ... "
                    buildImage(env.IMAGE_NAME)
                    DockerLogin()
                    dockerPush(env.IMAGE_NAME)
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                  gv.deployapp ()

                }
            }
        }
        stage('commit version update') {
            steps {
                script {
                    gv.ignore-jenkins-commit ()
                }
            }
        }
   
   }
}