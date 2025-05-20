pipeline {
    agent { label 'agent2' }

    environment {
        IMAGE_NAME = 'my-spring-app'
    }

    stages {
        stage("📥 Clone the project") {
            steps {
                git branch: 'development', url: 'https://github.com/codewiser116/simple-java-app.git'
            }
        }

        stage("⚙️ Compilation and Tests") {
            steps {
                sh "./mvnw clean install -DskipTests"
                sh "./mvnw test"
            }
        }

        stage("🧪 Diagnostics") {
            steps {
                sh "ls -la"
                sh "pwd"
            }
        }

        stage("🧹 Cleanup Docker") {
            steps {
                sh '''
                  docker ps -q | xargs -r docker stop || true
                  docker container prune -f || true
                  docker image prune -af || true
                '''
            }
        }

        stage("🐳 Build Docker Image") {
            steps {
                sh "docker build -t $IMAGE_NAME ."
            }
        }

        stage("🚀 Run Docker Container") {
            steps {
                sh '''
                  docker run -d -p 80:8001 --name my-spring-app $IMAGE_NAME
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Application built and deployed successfully!'
        }
        failure {
            echo '❌ Build failed. Please check the logs.'
        }
    }
}
