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
stage('Deploy to EKS') {
    steps {
        sh 'aws eks update-kubeconfig --region us-east-1 --name food-delivery-cluster'
        sh 'kubectl apply -f deployment.yaml'
        sh 'kubectl apply -f service.yaml'
        sh 'kubectl apply -f hpa.yaml'
        sh 'kubectl rollout status deployment/food-delivery'
    }
}
