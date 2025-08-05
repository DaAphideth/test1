package controllers

import (
	"net/http"
	"nencer-go/models"
	"nencer-go/repositories"
	"github.com/gin-gonic/gin"
)

var customerRepo = &repositories.CustomerRepository{}

func RegisterCustomerRoutes(r *gin.Engine) {
	group := r.Group("/customers")
	group.GET("/", listCustomers)
	group.POST("/", createCustomer)
}

func listCustomers(c *gin.Context) {
	objs, err := customerRepo.List()
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}
	c.JSON(http.StatusOK, objs)
}

func createCustomer(c *gin.Context) {
	var obj models.CustomerDetailObject
	if err := c.ShouldBindJSON(&obj); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}
	if err := customerRepo.Create(&obj); err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}
	c.JSON(http.StatusCreated, obj)
} 