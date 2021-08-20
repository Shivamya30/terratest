provider "aws" {
     access_key = "***********************"
     secret_key = "*******************************"
     region = "us-east-2"
}
data "aws_availability_zones" "all" {}
