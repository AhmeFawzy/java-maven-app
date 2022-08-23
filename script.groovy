//def buildJar() {
 //   echo "building the application..."
  //  sh 'mvn test'
  //  sh 'mvn package'
//} 

//def buildImage() {
  //  echo "building the docker image... and we will try to upload it to nexus repository"
    //withCredentials([usernamePassword(credentialsId: 'nexus-admin-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    //    sh 'docker build -t 207.154.251.118:8083/microsoft:master .'
    //    sh "echo $PASS | docker login -u $USER --password-stdin 207.154.251.118:8083"
     //   sh 'docker push 207.154.251.118:8083/microsoft:master'
  //  }
//} 

//def deployApp() {
   // echo 'deploying the application...and the image successfully uploaded to nexus repository, go and check it now '
//} 

//return this
