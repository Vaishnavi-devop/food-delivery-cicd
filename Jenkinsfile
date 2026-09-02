pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
        ECR = '539555553516.dkr.ecr.us-east-1.amazonaws.com/food-delivery'
        CLUSTER = 'food-delivery-cluster'
        REGION = 'us-east-1'
    }

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t food-delivery:${BUILD_NUMBER} .'
            }
        }

        stage('ECR Login') {
            steps {
                sh '''
                aws ecr get-login-password --region $REGION | \
                docker login --username AWS --password-stdin 539555553516.dkr.ecr.us-east-1.amazonaws.com
                '''
            }
        }

        stage('Push to ECR') {
            steps {
                sh '''
                docker tag food-delivery:${BUILD_NUMBER} $ECR:${BUILD_NUMBER}
                docker push $ECR:${BUILD_NUMBER}
                '''
            }
        }

        stage('Deploy to EKS') {
            steps {
                sh '''
                aws eks update-kubeconfig --region $REGION --name $CLUSTER

                kubectl set image deployment/food-delivery \
                food-delivery=$ECR:${BUILD_NUMBER}

                kubectl rollout status deployment/food-delivery --timeout=180s
                '''
            }
        }
    }
}
