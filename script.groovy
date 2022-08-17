def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-admin-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t my-repo:jma-3.60 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push my-repo:jma-3.60'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
