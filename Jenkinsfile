pipeline {
    agent any
    environment {
        NEW_VERSION ='1.3.0'
        SERVER_CREDENTIALS = credentials ('gitlab-credintials')
     }
     parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0','1.3.0'],description: 'choose the right choice for you')
        booleanParam(name:'excuteTests', defaultValue: true, description: '')
     }
    stages {
        stage("init") {            
            steps {
                //echo "building version ${NEW_VERSION}"  //HAVE TO BE WRITTEN INSIDE double quotes
                //echo "building version ${SERVER_CREDENTIALS}" // YOU CAN DEFIVE AND RETRIEVE CREDENTIALS FROM JENKINS AS DESCRIPED ABOVE 
                //script {
                    gv = load "script.groovy"
                }
                echo " welcome ya hamada "
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
                    usernamePassowrd(credentials: 'gitlab-credintials',usernameVariable:USER, passwordVariable: PWD)
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
