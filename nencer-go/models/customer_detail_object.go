package models

type CustomerDetailObject struct {
	DoType    string `gorm:"column:do_type" json:"do_type"`
	DoCode    string `gorm:"primaryKey;column:do_code" json:"do_code"`
	DoName    string `gorm:"column:do_name" json:"do_name"`
	DoBenefit *int   `gorm:"column:do_benefit" json:"do_benefit,omitempty"`
}

func (CustomerDetailObject) TableName() string {
	return "customer_detail_object"
} 