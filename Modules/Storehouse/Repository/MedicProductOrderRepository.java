package nencer.app.Modules.Storehouse.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import nencer.app.Modules.Storehouse.Entity.MedicProductOrder;
import nencer.app.Modules.Storehouse.Model.IMedicProductOrderName;
import nencer.app.Modules.Storehouse.Model.MedicProductOrderCategoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MedicProductOrderRepository extends JpaRepository<MedicProductOrder, Integer>, JpaSpecificationExecutor<MedicProductOrder> {
  Optional<MedicProductOrder> findByCode(String paramString);
  
  @Query("select 1 from MedicProductOrder u where u.code = :code ")
  Integer checkExistsByCode(String paramString);
  
  @Query(value = "SELECT a.orderType, a.groupOrderType, a.orderTypeName, a.totalRecord\nfrom ( with tongBanGhi as \n(SELECT null orderType, null groupOrderType, 'Tất cả' orderTypeName, SUM(1) totalRecord \n\tFROM medic_product_order a\n inner join medic_product_storehouse c on a.storehouse_id = c.id    where (c.sh_type <> 'kho_ngoai_tru' or (c.sh_type = 'kho_ngoai_tru' and a.order_status in ('DD', 'DXK', 'DNK') and a.ticket_id is not null) or (c.sh_type = 'kho_ngoai_tru' and a.ticket_id is null))  and (:orderType is null or a.order_type = :orderType)\n\t\t and (:fromDate is null or a.created_at >= :fromDate)\n\t\t and (:toDate is null or a.created_at <= :toDate)),\ntongBanGhiGroup as \n(SELECT a.group_order_type orderType, null groupOrderType, b.medic_name orderTypeName, SUM(1) totalRecord\n\tFROM medic_product_order a inner join medic_master_data b on a.group_order_type = b.medic_code  inner join medic_product_storehouse c on a.storehouse_id = c.id\n    where (c.sh_type <> 'kho_ngoai_tru' or (c.sh_type = 'kho_ngoai_tru' and a.order_status in ('DD', 'DXK', 'DNK') and a.ticket_id is not null) or (c.sh_type = 'kho_ngoai_tru' and a.ticket_id is null))  and (:orderType is null or a.group_order_type = :orderType)\n\t\t and (:fromDate is null or a.created_at >= :fromDate)\n\t\t and (:toDate is null or a.created_at <= :toDate)\tgroup by a.group_order_type, b.medic_name),\ntongBanGhiType as  \n(SELECT a.order_type orderType, a.group_order_type groupOrderType, b.medic_name orderTypeName, SUM(1) totalRecord\n\tFROM medic_product_order a inner join medic_master_data b on a.order_type = b.medic_code\n  inner join medic_product_storehouse c on a.storehouse_id = c.id\twhere (c.sh_type <> 'kho_ngoai_tru' or (c.sh_type = 'kho_ngoai_tru' and a.order_status in ('DD', 'DXK', 'DNK') and a.ticket_id is not null) or (c.sh_type = 'kho_ngoai_tru' and a.ticket_id is null))  and (:orderType is null or a.order_type = :orderType)\n\t\t and (:fromDate is null or a.created_at >= :fromDate)\n\t\t and (:toDate is null or a.created_at <= :toDate)\tgroup by a.order_type, a.group_order_type, b.medic_name)\nselect orderType, groupOrderType, orderTypeName, totalRecord from tongBanGhi\nunion\nselect orderType, groupOrderType, orderTypeName, totalRecord from tongBanGhiGroup\nunion\nselect orderType, groupOrderType, orderTypeName, totalRecord from tongBanGhiType ) a", nativeQuery = true)
  List<MedicProductOrderCategoryInterface> getMedicProductOrderCategory(@Param("orderType") String paramString, Date paramDate1, Date paramDate2);
  
  @Query(value = "select a.name supplierName, b.name storehouseName, c.name roomName, d.name customerName, e.medic_name orderTypeName, f.medic_name orderStatusName, g.name storehouseFromName, h.medic_name productSrcName, i.medic_name productEvenSrcName\nfrom medic_product_order o\nleft join medic_product_supplier a on o.supplier_id = a.id\nleft join medic_product_storehouse b on o.storehouse_id = b.id\nleft join medic_rooms c on o.room_id = c.id\nleft join customers d on o.customer_id = d.id\nleft join medic_master_data e on o.order_type = e.medic_code\nleft join medic_master_data f on o.order_status = f.medic_code\nleft join medic_product_storehouse g on o.storehouse_from_id = b.id\nleft join medic_master_data h on o.product_src = h.medic_code\nleft join medic_master_data i on o.product_even_src = i.medic_code\nwhere o.id = :orderId  limit 1", nativeQuery = true)
  IMedicProductOrderName getMedicProductOrderName(@Param("orderId") Integer paramInteger);
  
  @Query("SELECT COUNT(u) FROM MedicProductOrder u WHERE u.ticketId=:ticketId And u.orderStatus=:orderStatus")
  Integer hasTicketIdAndOrderstatus(@Param("ticketId") Integer paramInteger, @Param("orderStatus") String paramString);
  
  @Query("SELECT u FROM MedicProductOrder u WHERE u.ticketId=:ticketId And u.orderStatus=:orderStatus")
  Optional<MedicProductOrder> findByTicketIdAndOrderStatus(@Param("ticketId") Integer paramInteger, @Param("orderStatus") String paramString);
  
  void deleteByTicketId(@Param("ticketId") Integer paramInteger);
  
  List<MedicProductOrder> findAllByTicketIdIn(Set<Integer> paramSet);
  
  List<MedicProductOrder> findAllByFundLogId(Integer paramInteger);
  
  Optional<MedicProductOrder> findByTicketId(Integer paramInteger);
  
  @Transactional
  @Modifying
  @Query("UPDATE MedicProductOrder u SET u.orderStatus = :productOrderStatus WHERE u.id in :orderIds")
  void updateStatusByIds(Set<Integer> paramSet, String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Storehouse\Repository\MedicProductOrderRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */