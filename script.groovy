def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t flokiboats/my-repo:jma-4.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin 207.154.251.118:8083"
        sh 'docker push flokiboats/my-repo:jma-4.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
