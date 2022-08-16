    def gv
pipeline {
    agent any
    tools{
        maven 'maven-3.8.6'
    }
     parameters {
        string(name:'VERSION', defaultValue: '',description: 'version to deploy on prod ')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0','1.3.0'],description: '')
        booleanParam(name:'excuteTests', defaultValue: true, description: '')
     }
    stages {
        stage("init") {            
            steps {           
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
                script {
                    echo "building jar"
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {    
                    env.ENV= input message: "select the env you want to deploy to", ok "Done", parameters:[choice(name:"ENV", choices: ['dev', 'staging', 'prod'],description: '')]            
                    gv.deployApp()
                    echo "deploying to ${ENV}"
                }
            }
        }
    }   
}
