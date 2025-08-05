package models

import "time"

type CustomerFamily struct {
	FaId          int        `gorm:"primaryKey;column:fa_id" json:"fa_id"`
	CustomerId    *int       `gorm:"column:customer_id" json:"customer_id,omitempty"`
	FaCustomerId  *int       `gorm:"column:fa_customer_id" json:"fa_customer_id,omitempty"`
	FaName        string     `gorm:"column:fa_name" json:"fa_name"`
	FaIdCard      string     `gorm:"column:fa_id_card" json:"fa_id_card"`
	FaEducation   string     `gorm:"column:fa_education" json:"fa_education"`
	FaAddress     string     `gorm:"column:fa_address" json:"fa_address"`
	FaPhone       string     `gorm:"column:fa_phone" json:"fa_phone"`
	FaParentsType string     `gorm:"column:fa_parents_type" json:"fa_parents_type"`
	CreatedAt     *time.Time `gorm:"column:created_at" json:"created_at,omitempty"`
	CreatorId     *int       `gorm:"column:creator_id" json:"creator_id,omitempty"`
}

func (CustomerFamily) TableName() string {
	return "customer_family"
} 