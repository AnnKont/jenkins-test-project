pipeline{
    agent any

    tools { //tool from Jenkins, only 3: gradle, mvn, jdk
        gradle 'gradle-7.1.1' //you should have this in Jenkins plugins with current name
    }

    environment { //your own environment, it will available in all stages
        SERVER_CREDENTIALS = credentials('server-credentials') //should be 'Credential' and 'Credential Binding' plugins in Jenkins and global credential with this ID
    }

    parameters { //your parameters
        string(name: 'RELEASE', defaultValue: '', description: 'release to deploy') // string type
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'version to deploy') // choice type
        booleanParam(name: 'executeTests', defaultValue: true, description: 'need to execute tests') // boolean type
    }

    stages {

        stage("Test & Build Artifact") {
            when {
                expression {
                    params.executeTests //can be params.executeTests == true
                }
            }
            steps {
                sh './gradlew clean build'
            }
        }

        stage("create docker image") {
            when {
                expression {
                    BRANCH_NAME == 'master' || 'develop'
                }
            }
            steps {
                echo "create docker imaging for release {$params.RELEASE}"

                withCredentials([ //credentials available only here
                    usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'USER', passwordVariable: 'PSW')
                ]) {
                    //connect to docker:
                    //sh "docker login -u {$USER} -p {$PSW} {$REGISTRY}" -- in "" because use variables

                    //create image:
                    //sh 'docker-compose build'

                    //push image
                    //sh 'docker-compose push'
                }

            }
        }
        stage("deploy") {
            when {
                expression {
                    BRANCH_NAME == 'master' || 'develop'
                }
            }
            steps {
                echo "deploying version {$params.VERSION}"
                //sh 'mkdir -p $HOME/.kube'
                //sh 'cd kubernetes/first-environment'
                //sh 'kubectl apply -k .'

                //Delete all previous pods
                //sh 'kubectl delete --all pods --namespace=default'
            }
        }
    }
}