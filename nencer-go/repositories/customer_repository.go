package repositories

import (
	"nencer-go/models"
	"nencer-go/utils"
)

type CustomerRepository struct{}

func (r *CustomerRepository) GetByCode(code string) (*models.CustomerDetailObject, error) {
	var obj models.CustomerDetailObject
	err := utils.DB.First(&obj, "do_code = ?", code).Error
	if err != nil {
		return nil, err
	}
	return &obj, nil
}

func (r *CustomerRepository) Create(obj *models.CustomerDetailObject) error {
	return utils.DB.Create(obj).Error
}

func (r *CustomerRepository) List() ([]models.CustomerDetailObject, error) {
	var objs []models.CustomerDetailObject
	err := utils.DB.Find(&objs).Error
	return objs, err
} 