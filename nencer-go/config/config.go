package config

import (
	"log"

	"github.com/spf13/viper"
)

// AppConfig holds all configuration values
var AppConfig *Config

// Config struct for application configuration
type Config struct {
	RedisHost string
	RedisPort int
	DBHost    string
	DBPort    int
	DBUser    string
	DBPass    string
	DBName    string
}

// LoadConfig initializes configuration using Viper
func LoadConfig() {
	viper.SetConfigName("config")
	viper.SetConfigType("yaml")
	viper.AddConfigPath(".")
	viper.AddConfigPath("./config")

	viper.SetDefault("redis.host", "localhost")
	viper.SetDefault("redis.port", 6379)
	viper.SetDefault("db.host", "localhost")
	viper.SetDefault("db.port", 3306)
	viper.SetDefault("db.user", "root")
	viper.SetDefault("db.pass", "")
	viper.SetDefault("db.name", "nencer")

	err := viper.ReadInConfig()
	if err != nil {
		log.Printf("Config file not found, using defaults: %v", err)
	}

	AppConfig = &Config{
		RedisHost: viper.GetString("redis.host"),
		RedisPort: viper.GetInt("redis.port"),
		DBHost:    viper.GetString("db.host"),
		DBPort:    viper.GetInt("db.port"),
		DBUser:    viper.GetString("db.user"),
		DBPass:    viper.GetString("db.pass"),
		DBName:    viper.GetString("db.name"),
	}
}

// Java constants/enums ported to Go
const (
	// ApiFwConstants.Status
	StatusOK    = "OK"
	StatusFAILE = "FAILE"
	StatusERROR = "ERROR"

	// DataDefine
	DrugType               = "drugType"
	TicketType             = "ticketType"
	CompanyName            = "company_name"
	CompanyName1           = "HOSPITAL"
	OrdinalDoor            = "ordinal_door"
	DepartmentHealth       = "department_health"
	Department             = "DEPARTMENT"
	Hospital               = "HOSPITAL"
	Bhyt                   = "bhyt"
	ShTypeBhyt             = "shTypeBhyt"
	Address                = "ADDRESS"
	HospitalRepresentative = "hospitalRepresentative"
	Option                 = "option"
)

type Seperator string

const (
	SeperatorSpace Seperator = "space"
	SeperatorComma Seperator = "comma"
	SeperatorDot   Seperator = "dot"
)
