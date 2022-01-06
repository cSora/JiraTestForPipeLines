pipeline {
    agent any

    stages {
        stage('First Stage') {
            steps {
            echo 'Clean workspace before'
                cleanWs()
            }
        }
        stage('Test Stage') {
            parallel(){
                stage('Parallel 1'){
                    steps {
                    echo 'Chrome tests'
                    withCredentials([usernamePassword(credentialsId: 'a91b8324-f5cf-4629-821e-42ccbcd06214', passwordVariable: 'password', usernameVariable: 'username')]) {
                    sh "mvn -Dpassword=${password}. -Dusername=${username} '-Duser=Auto Tester 11' test"
                    }
                    }
                    }
                stage('Parallel 2'){
                    steps {
                    echo 'Stage 2 - Parallel 2'
                    }
                    }
                }
            }
     stage('Third Stage') {
            steps {
                echo 'Clean workspace after'
                cleanWs()
            }
        }

    }
}
