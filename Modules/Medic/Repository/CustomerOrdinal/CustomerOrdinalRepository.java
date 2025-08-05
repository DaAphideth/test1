package nencer.app.Modules.Medic.Repository.CustomerOrdinal;

import java.util.List;
import java.util.Optional;
import nencer.app.Modules.Medic.Entity.CustomerOrdinal.MedicCustomerOrdinal;
import nencer.app.Modules.Medic.Model.CustomerOrdinal.CustomerOrdinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerOrdinalRepository extends JpaRepository<MedicCustomerOrdinal, Integer> {
  @Query(value = "SELECT date_time as number from( \nselect CONVERT(substr(date_time,-6,6), SIGNED) date_time from medic_customer_ordinal\n    where date_time like concat(:takeNumber,date_format(sysdate(), '%Y%m%d'),'%') \n    order by date_time desc) a", nativeQuery = true)
  List<CustomerOrdinal> getGenerateNumber(@Param("takeNumber") String paramString);
  
  @Query(value = "select calling_number as callingNumber from(SELECT distinct(co.calling_number) calling_number FROM medic_customer_ordinal co  where co.date_time like  concat(:takeNumber, date_format(sysdate(), '%Y%m%d'),'%'))a", nativeQuery = true)
  CustomerOrdinal getCallingNumber(@Param("takeNumber") String paramString);
  
  @Query(value = "select co.id, co.number as number, co.door_code as doorCode,co.calling_number as callingNumber FROM(\nSELECT *  \nFROM medic_customer_ordinal co  \nWHERE co.date_time LIKE CONCAT(:takeNumber, date_format(sysdate(), '%Y%m%d'),'%')\nAND co.door_id IS NOT NULL \nORDER BY co.number DESC\nLIMIT 1\n)co", nativeQuery = true)
  CustomerOrdinal getCallingNumber1(@Param("takeNumber") String paramString);
  
  @Query(value = " SELECT co.id, co.number as number, co.door_code as doorCode,co.calling_number as callingNumber FROM medic_customer_ordinal co\n where co.date_time like  concat(:takeNumber, date_format(sysdate(), '%Y%m%d'),'%') And co.number = :callingNumber", nativeQuery = true)
  CustomerOrdinal findByNumberAndNameRoom(@Param("callingNumber") Integer paramInteger, @Param("takeNumber") String paramString);
  
  @Query(value = " SELECT co.id, co.number as number, co.door_code as doorCode, co.calling_number as callingNumber FROM medic_customer_ordinal co WHERE co.date_time LIKE  concat(:takeNumber, date_format(sysdate(), '%Y%m%d'),'%') AND  co.door_code = :takeNumber AND co.door_id = :doorId ORDER BY co.calling_number desc", nativeQuery = true)
  List<CustomerOrdinal> getByTakeNumberAndDoorId(String paramString1, String paramString2);
  
  @Transactional
  @Modifying
  @Query(value = "update medic_customer_ordinal co set co.calling_number= :callingNumber where co.date_time like concat(:takeNumber, date_format(sysdate(), '%Y%m%d'),'%') ", nativeQuery = true)
  void updateCallingNumber(@Param("callingNumber") Integer paramInteger, @Param("takeNumber") String paramString);
  
  @Transactional
  @Modifying
  @Query("UPDATE MedicCustomerOrdinal co SET co.callingNumber=:callingNumber, co.doorId=:doorId where co.id=:id ")
  void updateCallingNumber1(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  @Transactional
  @Modifying
  @Query(value = "update medic_customer_ordinal co set co.door_id= :doorId where co.date_time like concat(:takeNumber, date_format(sysdate(), '%Y%m%d'),'%') and co.number = :number ", nativeQuery = true)
  void updateDoorCode(@Param("number") Integer paramInteger, @Param("doorId") String paramString1, @Param("takeNumber") String paramString2);
  
  @Query(value = " SELECT co.number as number, co.door_code as doorCode, co.calling_number as callingNumber FROM medic_customer_ordinal co\n            where co.date_time like  concat('ST', date_format(sysdate(), '%Y%m%d'),'%')\n            order by co.number desc limit 1", nativeQuery = true)
  Optional<CustomerOrdinal> findByST();
  
  @Query(value = " SELECT co.number as number, co.door_code as doorCode, co.calling_number as callingNumber FROM medic_customer_ordinal co\n            where co.date_time like  concat('UT', date_format(sysdate(), '%Y%m%d'),'%')\n            order by co.number desc limit 1", nativeQuery = true)
  Optional<CustomerOrdinal> findByUT();
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\CustomerOrdinal\CustomerOrdinalRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */