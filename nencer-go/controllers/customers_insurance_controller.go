package controllers

import (
	"net/http"
	"nencer-go/models"
	"nencer-go/repositories"
	"github.com/gin-gonic/gin"
)

var customersInsuranceRepo = &repositories.CustomersInsuranceRepository{}

func RegisterCustomersInsuranceRoutes(r *gin.Engine) {
	group := r.Group("/customers-insurance")
	group.GET("/", listCustomersInsurance)
	group.POST("/", createCustomersInsurance)
}

func listCustomersInsurance(c *gin.Context) {
	objs, err := customersInsuranceRepo.List()
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}
	c.JSON(http.StatusOK, objs)
}

func createCustomersInsurance(c *gin.Context) {
	var obj models.CustomersInsurance
	if err := c.ShouldBindJSON(&obj); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}
	if err := customersInsuranceRepo.Create(&obj); err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}
	c.JSON(http.StatusCreated, obj)
} 