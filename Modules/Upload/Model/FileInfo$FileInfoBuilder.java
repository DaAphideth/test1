/*    */ package nencer.app.Modules.Upload.Model;
/*    */ public class FileInfoBuilder { private String file_name;
/*    */   private String file_type_image;
/*    */   private String file_description;
/*    */   private String document_name;
/*    */   private String process_instance_id;
/*    */   private String server_file_name;
/*    */   private String batch_code;
/*    */   private String err_msg;
/*    */   
/* 11 */   public FileInfoBuilder file_name(String file_name) { this.file_name = file_name; return this; } public FileInfoBuilder file_type_image(String file_type_image) { this.file_type_image = file_type_image; return this; } public FileInfoBuilder file_description(String file_description) { this.file_description = file_description; return this; } public FileInfoBuilder document_name(String document_name) { this.document_name = document_name; return this; } public FileInfoBuilder process_instance_id(String process_instance_id) { this.process_instance_id = process_instance_id; return this; } public FileInfoBuilder server_file_name(String server_file_name) { this.server_file_name = server_file_name; return this; } public FileInfoBuilder batch_code(String batch_code) { this.batch_code = batch_code; return this; } public FileInfoBuilder err_msg(String err_msg) { this.err_msg = err_msg; return this; } public FileInfo build() { return new FileInfo(this.file_name, this.file_type_image, this.file_description, this.document_name, this.process_instance_id, this.server_file_name, this.batch_code, this.err_msg); } public String toString() { return "FileInfo.FileInfoBuilder(file_name=" + this.file_name + ", file_type_image=" + this.file_type_image + ", file_description=" + this.file_description + ", document_name=" + this.document_name + ", process_instance_id=" + this.process_instance_id + ", server_file_name=" + this.server_file_name + ", batch_code=" + this.batch_code + ", err_msg=" + this.err_msg + ")"; }
/*    */    }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Upload\Model\FileInfo$FileInfoBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */