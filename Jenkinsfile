pipeline{
    agent any

    stages {

        stage("Test & Build Artifact") {
            steps {
                sh './gradlew clean build'
            }
        }

        stage("create docker image") {
            steps {
                echo 'create docker image'
                //connect to docker:
                //sh 'docker login -u "$REGISTRY_USER" -p "$REGISTRY_PASSWORD" $REGISTRY'

                //create image:
                //sh 'docker-compose build'

                //push image
                //sh 'docker-compose push'
            }
        }
        stage("deploy") {
            steps {
                echo 'deploy'
                //sh 'mkdir -p $HOME/.kube'
                //sh 'cd kubernetes/first-environment'
                //sh 'kubectl apply -k .'

                //Delete all previous pods
                //sh 'kubectl delete --all pods --namespace=default'
            }
        }
    }
}