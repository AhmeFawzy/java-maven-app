#!usr/bin/env groovy
pipeline {
    agent any      
    stages {
        stage("test") {            
            steps {
                script {
                    echo "i'm just wondering, when i will pass all that shit"                                    
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo " jar bar disco"
            
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo " image loves you so much"
                 
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    def dockerCmd = 'docker run -p 80:80 -d --name jenkinswebapp flokiboats/my-repo:webapp'
                    echo "deploying"
                    sshagent(['ec2-server-key']) {
                       sh "ssh -o StrictHostKeyChecking=no ec2-user@3.83.81.128 ${dockerCmd}"
                    }
              
                }
            }
        }
   }   
}
  
