package controllers

import (
	"net/http"
	"nencer-go/models"
	"nencer-go/repositories"
	"github.com/gin-gonic/gin"
)

var customerFamilyRepo = &repositories.CustomerFamilyRepository{}

func RegisterCustomerFamilyRoutes(r *gin.Engine) {
	group := r.Group("/customer-families")
	group.GET("/", listCustomerFamilies)
	group.POST("/", createCustomerFamily)
}

func listCustomerFamilies(c *gin.Context) {
	objs, err := customerFamilyRepo.List()
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}
	c.JSON(http.StatusOK, objs)
}

func createCustomerFamily(c *gin.Context) {
	var obj models.CustomerFamily
	if err := c.ShouldBindJSON(&obj); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}
	if err := customerFamilyRepo.Create(&obj); err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}
	c.JSON(http.StatusCreated, obj)
} 