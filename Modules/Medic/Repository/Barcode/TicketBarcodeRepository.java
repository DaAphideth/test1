package nencer.app.Modules.Medic.Repository.Barcode;

import java.util.List;
import nencer.app.Modules.Medic.Entity.OrderTicket.MedicTicketBarcode;
import nencer.app.Modules.Medic.Model.Ticket.TicketBarcodeInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBarcodeRepository extends JpaRepository<MedicTicketBarcode, Integer> {
  @Query(value = "SELECT date_time as number FROM(\n\tSELECT MAX(CONVERT(substr(date_time,-:max,:max), SIGNED)) date_time from medic_ticket_barcode  \n   where date_time like CONCAT('%',date_format(sysdate(), '%Y'),'%')  \n   order by date_time desc\n) a", nativeQuery = true)
  List<TicketBarcodeInterface> getGenerateBarcode(Integer paramInteger);
}


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Medic\Repository\Barcode\TicketBarcodeRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */