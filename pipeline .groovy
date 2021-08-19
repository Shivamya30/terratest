pipeline {
    agent any
    
    tools {
        terraform 'terraform'
    }
    stages {
        stage ("checkout from GIT") {
            steps {
                git branch: 'main', url: 'https://github.com/Shivamya30/Terraform_RDS_ec2_vpc.git'
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
                if ()
            }
        }
        stage ("terraform apply") {
            steps {
                sh 'terraform apply --auto-approve'
            }
        }
        stage ("terraform destroy"){
            steps{
                sh 'terrform destroy'
            }
        }
        
    }
}

