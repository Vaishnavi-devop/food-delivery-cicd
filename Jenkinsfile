stage('Deploy to EKS') {
    steps {
        sh '''
        aws eks update-kubeconfig --region $REGION --name $CLUSTER

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
