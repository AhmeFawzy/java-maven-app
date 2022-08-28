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

    stages {
          stage('increment the app version') {
            steps {
                script {
                    echo 'incrementing app version...'
                    sh 'mvn build-helper:parse-version versions:set \
                         -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                            versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER" 
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
                    gv.ingnore-jenkins-commit()
                }
            }
        }
   
   }
}