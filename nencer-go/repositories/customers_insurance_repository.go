package repositories

import (
	"nencer-go/models"
	"nencer-go/utils"
)

type CustomersInsuranceRepository struct{}

func (r *CustomersInsuranceRepository) GetById(id int) (*models.CustomersInsurance, error) {
	var obj models.CustomersInsurance
	err := utils.DB.First(&obj, "insurance_id = ?", id).Error
	if err != nil {
		return nil, err
	}
	return &obj, nil
}

func (r *CustomersInsuranceRepository) Create(obj *models.CustomersInsurance) error {
	return utils.DB.Create(obj).Error
}

func (r *CustomersInsuranceRepository) List() ([]models.CustomersInsurance, error) {
	var objs []models.CustomersInsurance
	err := utils.DB.Find(&objs).Error
	return objs, err
} 