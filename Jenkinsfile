pipeline {
    agent any

    tools {
        maven "3.8.1"
    }

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/samirahmedmustafa/Demo-Jenkins'
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/samirahmedmustafa/Demo-Jenkins']])
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Test') {
            steps {
                echo "Testing app.."
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploy app.!!!!"
            }
        }
    }
}
