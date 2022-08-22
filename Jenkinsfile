pipeline {
    agent any    
     tools{
        maven 'maven-3.8.6'    
     }
    
    stages {
        stage("build app") {            
            steps {
                script {
                    echo "building the app"
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building the docker image ..."
                    echo "building the docker image... and we will try to upload it to nexus repository"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'docker build -t flokiboats/my-repo:master .'
                    sh "echo $PASS | docker login -u $USER --password-stdin "
                    sh 'docker push flokiboats/my-repo:master'
    }
                }
            }
        }
        stage("deply") {
            steps {
                script {
                    echo "deploying docker image to ec2..."
                    
                }
            }
        }
   }   
}
  
