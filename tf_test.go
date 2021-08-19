package test

import (
	"log"
	"testing"

	"github.com/gruntwork-io/terratest/modules/terraform"
)

func TestTerraformJENKINS_TASK(t *testing.T) {

	Options := &terraform.Options{
		TerraformDir: "../JENKINS_TASK",
	}
	defer terraform.Destroy(t, Options)
	init, err := terraform.InitE(t, Options)

	if err != nil {
		log.Println(err)
	}
	t.Log(init)

	plan, err := terraform.PlanE(t, Options)

	if err != nil {
		log.Println(err)
	}
	t.Log(plan)

	apply, err := terraform.ApplyE(t, Options)

	if err != nil {
		log.Println(err)
	}
	t.Log(apply)
}
