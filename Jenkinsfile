pipeline {
    agent any

    stages {

        stage('Deploy to EKS') {
            steps {
                sh '''
                    aws eks update-kubeconfig --region us-east-1 --name food-delivery-cluster
                    kubectl get nodes
                '''
            }
        }

    }
}
