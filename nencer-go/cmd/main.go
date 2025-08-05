package main

import (
	"fmt"
	"nencer-go/config"
	"nencer-go/controllers"
	"nencer-go/utils"

	"github.com/gin-gonic/gin"
)

func main() {
	config.LoadConfig()
	fmt.Printf("Loaded Redis config: host=%s, port=%d\n", config.AppConfig.RedisHost, config.AppConfig.RedisPort)

	if err := utils.InitDB(); err != nil {
		panic(fmt.Sprintf("Failed to connect to DB: %v", err))
	}

	r := gin.Default()
	controllers.RegisterAuthRoutes(r)
	controllers.RegisterCustomerRoutes(r)
	controllers.RegisterCustomerFamilyRoutes(r)
	controllers.RegisterCustomerGroupsRoutes(r)
	controllers.RegisterCustomersRoutes(r)
	controllers.RegisterCustomersInsuranceRoutes(r)
	r.GET("/ping", func(c *gin.Context) {
		c.JSON(200, gin.H{"message": "pong"})
	})
	r.Run() // listen and serve on 0.0.0.0:8080
}
