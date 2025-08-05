package models

import "time"

type CustomerGroups struct {
	ID        int        `gorm:"primaryKey;column:id" json:"id"`
	Name      string     `gorm:"column:name" json:"name"`
	Code      string     `gorm:"column:code" json:"code"`
	NameArray string     `gorm:"column:name_array" json:"name_array"`
	Sort      *int       `gorm:"column:sort" json:"sort,omitempty"`
	CreatedAt *time.Time `gorm:"column:created_at" json:"created_at,omitempty"`
	UpdatedAt *time.Time `gorm:"column:updated_at" json:"updated_at,omitempty"`
}

func (CustomerGroups) TableName() string {
	return "customer_groups"
} 