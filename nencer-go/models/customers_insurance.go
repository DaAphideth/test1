package models

import "time"

type CustomersInsurance struct {
	InsuranceId            int        `gorm:"primaryKey;column:insurance_id" json:"insurance_id"`
	CustomerId             *int       `gorm:"column:customer_id" json:"customer_id,omitempty"`
	InsuranceNumber        string     `gorm:"column:insurance_number" json:"insurance_number"`
	InsuranceNumber1       string     `gorm:"column:insurance_number_1" json:"insurance_number_1"`
	InsuranceNumber2       string     `gorm:"column:insurance_number_2" json:"insurance_number_2"`
	InsuranceNumber3       string     `gorm:"column:insurance_number_3" json:"insurance_number_3"`
	InsuranceNumber4       string     `gorm:"column:insurance_number_4" json:"insurance_number_4"`
	InsuranceCskcb         string     `gorm:"column:insurance_cskcb" json:"insurance_cskcb"`
	InsuranceCskcb1        string     `gorm:"column:insurance_cskcb_1" json:"insurance_cskcb_1"`
	InsuranceCskcb2        string     `gorm:"column:insurance_cskcb_2" json:"insurance_cskcb_2"`
	InsuranceFromDate      *time.Time `gorm:"column:insurance_from_date" json:"insurance_from_date,omitempty"`
	InsuranceExpirationDate *time.Time `gorm:"column:insurance_expiration_date" json:"insurance_expiration_date,omitempty"`
	InsuranceAddress       string     `gorm:"column:insurance_address" json:"insurance_address"`
	InsuranceLine          string     `gorm:"column:insurance_line" json:"insurance_line"`
	InsuranceLive          string     `gorm:"column:insurance_live" json:"insurance_live"`
	Status                 string     `gorm:"column:status" json:"status"`
	Note                   string     `gorm:"column:note" json:"note"`
	CreatorId              *int       `gorm:"column:creator_id" json:"creator_id,omitempty"`
	CreatedAt              *time.Time `gorm:"column:created_at" json:"created_at,omitempty"`
	UpdatedAt              *time.Time `gorm:"column:updated_at" json:"updated_at,omitempty"`
	UpdatedId              *int       `gorm:"column:updated_id" json:"updated_id,omitempty"`
	BenefitRate            *int       `gorm:"column:benefit_rate" json:"benefit_rate,omitempty"`
}

func (CustomersInsurance) TableName() string {
	return "customers_insurance"
} 