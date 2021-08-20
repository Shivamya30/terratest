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
        stage ("terraform ") {
            steps {
                sh 'terraform init'
                sh 'terraform plan '
                sh 'terraform apply --auto-approve'
                sh 'terraform destroy --auto-approve'
                if 
                
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
