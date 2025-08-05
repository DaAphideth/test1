/*    */ package nencer.app.Modules.ComPort.Service;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import org.springframework.stereotype.Service;
/*    */ import purejavacomm.CommPort;
/*    */ import purejavacomm.CommPortIdentifier;
/*    */ import purejavacomm.SerialPort;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class SerialPortService
/*    */ {
/*    */   public void readFromSerialPort(String portName) {
/*    */     try {
/* 15 */       CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
/* 16 */       if (portIdentifier.isCurrentlyOwned()) {
/* 17 */         System.out.println("Port is currently in use");
/*    */       } else {
/* 19 */         CommPort commPort = portIdentifier.open(getClass().getName(), 3000);
/*    */         
/* 21 */         if (commPort instanceof SerialPort) {
/* 22 */           SerialPort serialPort = (SerialPort)commPort;
/* 23 */           serialPort.setSerialPortParams(9600, 8, 1, 0);
/*    */           
/* 25 */           InputStream inputStream = serialPort.getInputStream();
/*    */           
/*    */           while (true) {
/* 28 */             int data = inputStream.read();
/* 29 */             System.out.print((char)data);
/*    */           } 
/*    */         } 
/* 32 */         System.out.println("Only serial ports are handled by this example.");
/*    */       }
/*    */     
/* 35 */     } catch (Exception e) {
/* 36 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\ComPort\Service\SerialPortService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */