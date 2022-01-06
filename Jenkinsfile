pipeline {
    agent any

    stages {
        stage('First Stage') {
            steps {
            echo 'Clean workspace before'
                cleanWs()
            }
        }
        stage('Second Stage') {
            parallel(){
                stage('Parallel 1'){
                    steps {
                    echo 'Stage 2 - Parallel 1'
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
