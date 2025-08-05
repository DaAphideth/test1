package repositories

import (
	"nencer-go/models"
	"nencer-go/utils"
)

type CustomerFamilyRepository struct{}

func (r *CustomerFamilyRepository) GetById(id int) (*models.CustomerFamily, error) {
	var obj models.CustomerFamily
	err := utils.DB.First(&obj, "fa_id = ?", id).Error
	if err != nil {
		return nil, err
	}
	return &obj, nil
}

func (r *CustomerFamilyRepository) Create(obj *models.CustomerFamily) error {
	return utils.DB.Create(obj).Error
}

func (r *CustomerFamilyRepository) List() ([]models.CustomerFamily, error) {
	var objs []models.CustomerFamily
	err := utils.DB.Find(&objs).Error
	return objs, err
} 