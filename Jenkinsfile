pipeline {
    agent any

    environment {
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-21"   // adjust path to your JDK
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'resara', url: 'https://github.com/Resara/cicdproject'
            }
        }

        stage('Build & Test') {
            steps {
                dir('myservice') {
                   bat '../mvnw.cmd clean test'
                }
            }
            post {
              always {
                 junit 'myservice/target/surefire-reports/*.xml'
              }
            }
        }

        stage('Package') {
                    steps {
                        dir('myservice') {
                            bat '../mvnw.cmd package -DskipTests'
                        }
                    }
                }
    }

    post {
        success {
            echo '✅ Build completed successfully!'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}
