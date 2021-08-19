pipeline {
    agent any
    
    tools {
        terraform 'terraform'
        go 'go'
    }
    environment {
        GO117MODULE = 'on'
        CGO_ENABLED = 0 
        GOPATH = "${JENKINS_HOME}/jobs/${JOB_NAME}/builds/${BUILD_ID}"
    }
        
    
    stages {
        stage ("checkout from GIT") {
            steps {
                git branch: 'main', credentialsId: 'github', url: 'https://github.com/Shivamya30/terratest.git'
            }
        }
        stage ("terraform init") {
            steps {
                sh 'terraform init'
            }
        }
        
        stage ("terrafrom plan") {
            steps {
                sh 'terraform plan '
            }
        }
        stage ("terraform apply") {
            steps {
                sh 'terraform apply --auto-approve'
            }
        }
        stage ("terraform destroy"){
            steps{
                sh 'terraform destroy --auto-approve'
            }
        }
        stage ("terratest apply"){
            steps {
                withEnv(["PATH+GO=${GOPATH}/bin"]){
                sh 'go test -v'
                }
                
            }
        }
        
    }
}
