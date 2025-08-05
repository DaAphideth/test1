package models

import "time"

type UserResponseInfo struct {
	ID          int64       `json:"id"`
	Username    string      `json:"username"`
	Name        string      `json:"name"`
	Email       string      `json:"email"`
	Phone       string      `json:"phone"`
	JobTitle    *int        `json:"jobTitle,omitempty"`
	CountryCode string      `json:"countryCode"`
	Gender      string      `json:"gender"`
	Avatar      string      `json:"avatar"`
	LastLoginIp string      `json:"lastLoginIp"`
	CreatedAt   *time.Time  `json:"createdAt,omitempty"`
	UpdatedAt   *time.Time  `json:"updatedAt,omitempty"`
	Roles       interface{} `json:"roles"`
	Permissions interface{} `json:"permissions"`
}
