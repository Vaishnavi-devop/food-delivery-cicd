pipeline {
    agent any
stage('Deploy to EKS') {
    steps {
        sh '''
        aws eks update-kubeconfig --region $REGION --name $CLUSTER

    stages {

        stage('Deploy to EKS') {
            steps {
                sh '''
                    aws eks update-kubeconfig --region us-east-1 --name food-delivery-cluster
                    kubectl get nodes
                '''
            }
        }
        kubectl set image deployment/food-delivery \
        food-delivery=$ECR:${BUILD_NUMBER}

        if ! kubectl rollout status deployment/food-delivery --timeout=180s; then
            echo "Deployment failed - rolling back..."
            kubectl rollout undo deployment/food-delivery
            kubectl rollout status deployment/food-delivery --timeout=180s
            exit 1
        fi
        '''
    }
}
