package controllers

import (
	"nencer-go/models"
	"nencer-go/utils"
	"net/http"

	"github.com/gin-gonic/gin"
)

func RegisterAuthRoutes(r *gin.Engine) {
	group := r.Group("/api")
	group.POST("/login", loginHandler)
}

// For demo: hardcoded user
var demoUser = struct {
	ID       int64
	Username string
	Password string
	Name     string
	Email    string
}{
	ID:       1,
	Username: "admin",
	Password: "password",
	Name:     "Admin User",
	Email:    "admin@example.com",
}

func loginHandler(c *gin.Context) {
	var req models.LoginRequest
	if err := c.ShouldBindJSON(&req); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}
	if req.Username != demoUser.Username || req.Password != demoUser.Password {
		c.JSON(http.StatusUnauthorized, gin.H{"error": "invalid credentials"})
		return
	}
	token, err := utils.GenerateJWT(demoUser.ID, demoUser.Username)
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": "failed to generate token"})
		return
	}
	userInfo := models.UserResponseInfo{
		ID:       demoUser.ID,
		Username: demoUser.Username,
		Name:     demoUser.Name,
		Email:    demoUser.Email,
	}
	c.JSON(http.StatusOK, gin.H{
		"accessToken": token,
		"token_type":  "JWT",
		"user":        userInfo,
	})
}
