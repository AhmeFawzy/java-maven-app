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
        IMAGE_NAME = 'flokiboats/my-repo:java-maven-1.0'
    }
    stages {
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
                    def dockerCmd = "docker run -p 8080:8080 -d --name new-trial ${IMAGE_NAME}"
                    echo "deploying docker image to EC2 ..."
                    sshagent(['ec2-server-key']) {
                       sh "ssh -o StrictHostKeyChecking=no ec2-user@3.83.81.128 ${dockerCmd}"
                    }

                }
            }
        }   
   }
}