def gv
pipeline {
    agent any
     environment {
        NEW_VERSION ='1.3.0'
        SERVER_CREDENTIALS = credentials ('credentials id')
     }
     tools{
        maven 'Maven'
        gradle
        jdk
     }
     parameters {
        string(name:'VERSION', defaultValue: '',description: 'version to deploy on prod ')
        choice(name: 'VERSION', chices: ['1.1.0', '1.2.0','1.3.0'],description: '')
        booleanParam(name:'excuteTests', defaultValue: true, description: '')
     }
    stages {
        stage("init") {            
            steps {
                echo "building version ${NEW_VERSION}"  //HAVE TO BE WRITTEN INSIDE double quotes
                echo "building version ${SERVER_CREDENTIALS}" // YOU CAN DEFIVE AND RETRIEVE CREDENTIALS FROM JENKINS AS DESCRIPED ABOVE 
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            when {
                expression {
                    params.excuteTests == true
                }
            }
            steps {
                withCredentials([
                    usernamePassowrd(credentials: 'server-credentials',usernameVariable:USER, passwordVariable: PWD)
                ]) {
                    sh "some script ${USER} ${PWD}"
                }
                script {
                    echo "building jar"
                    //gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    //gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                    //gv.deployApp()
                    echo "deploying version ${params.VERSION}"
                }
            }
        }
    }   
}
