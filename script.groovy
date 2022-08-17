def buildJar() {
    echo "building the application..."
    sh 'mvn package'
    sh 'mvn test'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-admin-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t 207.154.251.118:8083/microsoft:jenkins-jobs .'
        sh "echo $PASS | docker login -u $USER --password-stdin 207.154.251.118:8083"
        sh 'docker push 207.154.251.118:8083/microsoft:jenkins-jobs'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
