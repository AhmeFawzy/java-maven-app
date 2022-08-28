

def ingnore-jenkins-commit () {
    withCredentials([usernamePassword(credentialsId: 'gitlab-credintials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        // git config here for the first time run
                        sh 'git config --global user.email "jenkins@example.com"'
                        sh 'git config --global user.name "jenkins"'

                        sh 'git status'
                        sh 'git branch'
                        sh 'git config --list'
                        sh "git remote set-url origin https://${USER}:${PASS}@gitlab.com/ahmedfawzy286/java-maven-app"
                        sh 'git add .'
                        sh 'git commit -m "ci: version bump"'
                        sh 'git push origin HEAD:TEST-INCREMENT-VERSION'
                    }
}
def increment() {
    echo 'incrementing app version...'
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.nextmajorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "flokiboats/my-repo:java-maven-$version-$BUILD_NUMBER" 
}
def deployapp () {
     // def dockerCmd = "docker run -p 8080:8080 -d --name new-trial ${IMAGE_NAME}"
                   //def dockercomposecmd = "docker-compose -f docker-compose.yaml up --detach"
                   def bashscript = "bash ./server-cmds.sh ${IMAGE_NAME}"
                   def ec2instance = "ec2-user@3.83.81.128"
                    echo "deploying docker image to EC2 ..."
                    sshagent(['ec2-server-key']) {
                       sh "scp server-cmds.sh ${ec2instance}:/home/ec2-user"
                       sh "scp docker-compose.yaml ${ec2instance}:/home/ec2-user"
                       sh "ssh -o StrictHostKeyChecking=no ${ec2instance} ${bashscript}"
                       
                    }
}
return this
