pipeline {
    agent any    
     tools{
        maven 'maven-3.8.6'    
     }
    
    stages {
        stage("increment version"){
            steps{
                script{
                echo " incrementing the version..."
                sh "mvn build-helper:parse-version versions:set -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion}"
                def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                def version = matcher[0][1]
                env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }
        stage("build app") {            
            steps {
                script {
                    echo "building the app"
                    sh 'mvn clean package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building the docker image ..."
                    echo "building the docker image... and we will try to upload it to nexus repository"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh " docker build -t flokiboats/my-repo:$IMAGE_NAME . "
                    sh " echo $PASS | docker login -u $USER --password-stdin "
                    sh " docker push flokiboats/my-repo:$IMAGE_NAME "

    }
                }
            }
        }
        stage("deply") {
            steps {
                script {
                    echo "deploying docker image to EC2...here we goOoO"
                    
                }
            }
        }
   }   
}
  
