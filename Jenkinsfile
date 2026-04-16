pipeline {
    agent any

    tools {
        // This ensures Maven is available. 
        // Note: "maven3" must match the name in Global Tool Configuration
        maven 'maven3' 
    }

    environment {
        DOCKER_IMAGE = "https://github.com/mathewjohn-14/Leave-management.git"
    }

    stages {
        stage('Checkout') {
            steps {
                // Pulls the latest code from your repository
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Using 'bat' instead of 'sh' for Windows compatibility
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build the image using the JAR created in the previous stage
                bat "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                // Use Jenkins credentials for Docker Hub login
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    bat "docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD%"
                    bat "docker push ${DOCKER_IMAGE}"
                }
            }
        }

        stage('Deploy to K8s') {
            steps {
                // Forces Kubernetes to use the new image immediately
                bat "kubectl rollout restart deployment leave-management-deployment"
            }
        }
    }

    post {
        always {
            echo 'Build Process Completed.'
        }
    }
}
