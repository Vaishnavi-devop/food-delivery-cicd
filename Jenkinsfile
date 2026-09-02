pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
        ECR = '539555553516.dkr.ecr.us-east-1.amazonaws.com/food-delivery'
    }

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t food-delivery:latest .'
            }
        }

        stage('ECR Login') {
            steps {
                sh 'aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 539555553516.dkr.ecr.us-east-1.amazonaws.com'
            }
        }

        stage('Push to ECR') {
            steps {
                sh 'docker tag food-delivery:latest $ECR:latest'
                sh 'docker push $ECR:latest'
            }
        }
    }
}
