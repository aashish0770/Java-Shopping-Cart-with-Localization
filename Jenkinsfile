pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'jdk-17'
    }

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'darksolu'
        DOCKERHUB_REPO = 'darksolu/javashoppingcart'
        DOCKER_IMAGE_TAG = 'v1'
    }



    stages {

        stage('Checkout') {
            steps {
                 git branch: 'main', url: 'https://github.com/aashish0770/Java-Shopping-Cart-with-Localization.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Generate Report') {
            steps {
                bat 'mvn jacoco:report'
            }
        }


        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }



    }
}