package controllers

import (
	"net/http"
	"nencer-go/models"
	"nencer-go/repositories"
	"github.com/gin-gonic/gin"
)

var customerGroupsRepo = &repositories.CustomerGroupsRepository{}

func RegisterCustomerGroupsRoutes(r *gin.Engine) {
	group := r.Group("/customer-groups")
	group.GET("/", listCustomerGroups)
	group.POST("/", createCustomerGroup)
}

func listCustomerGroups(c *gin.Context) {
	objs, err := customerGroupsRepo.List()
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}
	c.JSON(http.StatusOK, objs)
}

func createCustomerGroup(c *gin.Context) {
	var obj models.CustomerGroups
	if err := c.ShouldBindJSON(&obj); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}
	if err := customerGroupsRepo.Create(&obj); err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}
	c.JSON(http.StatusCreated, obj)
} 