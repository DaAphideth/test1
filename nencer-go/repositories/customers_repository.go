package repositories

import (
	"nencer-go/models"
	"nencer-go/utils"
)

type CustomersRepository struct{}

func (r *CustomersRepository) GetById(id int) (*models.Customers, error) {
	var obj models.Customers
	err := utils.DB.First(&obj, "id = ?", id).Error
	if err != nil {
		return nil, err
	}
	return &obj, nil
}

func (r *CustomersRepository) Create(obj *models.Customers) error {
	return utils.DB.Create(obj).Error
}

func (r *CustomersRepository) List() ([]models.Customers, error) {
	var objs []models.Customers
	err := utils.DB.Find(&objs).Error
	return objs, err
} 