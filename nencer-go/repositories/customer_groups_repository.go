package repositories

import (
	"nencer-go/models"
	"nencer-go/utils"
)

type CustomerGroupsRepository struct{}

func (r *CustomerGroupsRepository) GetById(id int) (*models.CustomerGroups, error) {
	var obj models.CustomerGroups
	err := utils.DB.First(&obj, "id = ?", id).Error
	if err != nil {
		return nil, err
	}
	return &obj, nil
}

func (r *CustomerGroupsRepository) Create(obj *models.CustomerGroups) error {
	return utils.DB.Create(obj).Error
}

func (r *CustomerGroupsRepository) List() ([]models.CustomerGroups, error) {
	var objs []models.CustomerGroups
	err := utils.DB.Find(&objs).Error
	return objs, err
} 