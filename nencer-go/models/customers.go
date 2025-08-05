package models

import "time"

type Customers struct {
	ID             int        `gorm:"primaryKey;column:id" json:"id"`
	Name           string     `gorm:"column:name" json:"name"`
	Phone          string     `gorm:"column:phone" json:"phone"`
	IdCardType     string     `gorm:"column:id_card_type" json:"id_card_type"`
	PatientNumber  string     `gorm:"column:patient_number" json:"patient_number"`
	IdCard         string     `gorm:"column:id_card" json:"id_card"`
	IssueDate      *time.Time `gorm:"column:issue_date" json:"issue_date,omitempty"`
	Email          string     `gorm:"column:email" json:"email"`
	Type           string     `gorm:"column:type" json:"type"`
	Gender         string     `gorm:"column:gender" json:"gender"`
	DayBorn        string     `gorm:"column:day_born" json:"day_born"`
	MonthBorn      string     `gorm:"column:month_born" json:"month_born"`
	YearBorn       string     `gorm:"column:year_born" json:"year_born"`
	Birthday       *time.Time `gorm:"column:birthday" json:"birthday,omitempty"`
	Lang           string     `gorm:"column:lang" json:"lang"`
	City           string     `gorm:"column:city" json:"city"`
	CountryCode    string     `gorm:"column:country_code" json:"country_code"`
	Nationality    string     `gorm:"column:nationality" json:"nationality"`
	Address        string     `gorm:"column:address" json:"address"`
	CustomerWards  string     `gorm:"column:customer_wards" json:"customer_wards"`
	CustomerDistrict string   `gorm:"column:customer_district" json:"customer_district"`
	CustomerProvince string   `gorm:"column:customer_province" json:"customer_province"`
	PostCode       string     `gorm:"column:post_code" json:"post_code"`
	Ethnic         string     `gorm:"column:ethnic" json:"ethnic"`
	DetailObject   string     `gorm:"column:detail_object" json:"detail_object"`
	Address2       string     `gorm:"column:address2" json:"address2"`
	JobTitle       string     `gorm:"column:job_title" json:"job_title"`
	UserId         *int       `gorm:"column:user_id" json:"user_id,omitempty"`
	CreatedAt      *time.Time `gorm:"column:created_at" json:"created_at,omitempty"`
	UpdatedAt      *time.Time `gorm:"column:updated_at" json:"updated_at,omitempty"`
	CheckinLevel   string     `gorm:"column:checkin_level" json:"checkin_level"`
	Poisition      string     `gorm:"column:poisition" json:"poisition"`
	CheckinUnit    string     `gorm:"column:checkin_unit" json:"checkin_unit"`
}

func (Customers) TableName() string {
	return "customers"
} 