package controllers

import (
	"net/http"
	"nencer-go/models"
	"nencer-go/repositories"
	"github.com/gin-gonic/gin"
)

var customersRepo = &repositories.CustomersRepository{}

func RegisterCustomersRoutes(r *gin.Engine) {
	group := r.Group("/customers-main")
	group.GET("/", listCustomers)
	group.POST("/", createCustomer)
}

func listCustomers(c *gin.Context) {
	objs, err := customersRepo.List()
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}
	c.JSON(http.StatusOK, objs)
}

func createCustomer(c *gin.Context) {
	var obj models.Customers
	if err := c.ShouldBindJSON(&obj); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}
	if err := customersRepo.Create(&obj); err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}
	c.JSON(http.StatusCreated, obj)
} 