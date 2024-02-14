pipeline {
    agent any

	environment {
		DOCKERHUB_CREDENTIALS = credentials('8a8418cd-d831-434d-96a9-827bfbbed073')
	}
	
    tools {
        maven "MVN"
    }
    
    stages {
        stage('Build Maven') {
            steps {
                //git 'https://github.com/samirahmedmustafa/Demo-Jenkins'

                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/samirahmedmustafa/Demo-Jenkins']])
                
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                //bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

           // post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
               // success {
                    //junit '**/target/surefire-reports/TEST-*.xml'
                    //archiveArtifacts 'target/*.jar'
              //  }
           // }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t samir82show/demo-jenkins ."   
                    //sh "docker version"   
                }
            }
        }
        
        stage("Login to dockerhub"){
        	steps {
	        	sh "echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u DOCKERHUB_CREDENTIALS_USR --password-stdin"
        	}    
        }
        
        stage("Push the Image"){
        	steps {	
        		sh "docker push samir82show/demo-jenkins:$BUILD_NUMBER"
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
