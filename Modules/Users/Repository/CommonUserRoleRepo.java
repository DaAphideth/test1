/*     */ package nencer.app.Modules.Users.Repository;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import nencer.app.Modules.Users.Entity.Group.Groups;
/*     */ import nencer.app.Modules.Users.Entity.Role.Roles;
/*     */ import nencer.app.Modules.Users.Entity.User.Permissions;
/*     */ import nencer.app.Modules.Users.Entity.User.Users;
/*     */ import nencer.app.Modules.Users.Model.Role.PermissionsModel;
/*     */ import nencer.app.Utils.DataUtil;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.core.env.Environment;
/*     */ import org.springframework.jdbc.core.BeanPropertyRowMapper;
/*     */ import org.springframework.jdbc.core.JdbcTemplate;
/*     */ import org.springframework.jdbc.core.RowMapper;
/*     */ import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
/*     */ import org.springframework.jdbc.core.namedparam.SqlParameterSource;
/*     */ import org.springframework.jdbc.core.simple.SimpleJdbcCall;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Repository
/*     */ public class CommonUserRoleRepo
/*     */ {
/*     */   @Autowired
/*     */   JdbcTemplate jdbcTemplate;
/*     */   @Autowired
/*     */   public Environment env;
/*     */   public SimpleJdbcCall simpleJdbcCallRefCursor;
/*     */   
/*     */   public List<Roles> spGetRolesByUserId(Integer userId) {
/*  35 */     this
/*     */ 
/*     */       
/*  38 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_roles_by_userid").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(Roles.class));
/*     */ 
/*     */ 
/*     */     
/*  42 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_USER_ID", userId);
/*     */     
/*  44 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  45 */     List<Roles> list = (List<Roles>)out.get("V_DATASET");
/*     */     
/*  47 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Groups> spGetGroupsByUserId(Integer userId) {
/*  53 */     this
/*     */ 
/*     */       
/*  56 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_group_by_userid").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(Groups.class));
/*     */ 
/*     */ 
/*     */     
/*  60 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_USER_ID", userId);
/*     */     
/*  62 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  63 */     List<Groups> list = (List<Groups>)out.get("V_DATASET");
/*     */     
/*  65 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PermissionsModel> spGetPermissionByUserId(int userId) {
/*  72 */     this
/*     */ 
/*     */       
/*  75 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_permission_by_userid").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(PermissionsModel.class));
/*     */ 
/*     */ 
/*     */     
/*  79 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_USER_ID", Integer.valueOf(userId));
/*     */     
/*  81 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  82 */     List<PermissionsModel> list = (List<PermissionsModel>)out.get("V_DATASET");
/*     */     
/*  84 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Users> spGetUserByRoleId(Integer roleId) {
/*  89 */     this
/*     */ 
/*     */       
/*  92 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_user_by_role_id").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(Users.class));
/*     */ 
/*     */ 
/*     */     
/*  96 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ROLE_ID", roleId);
/*     */     
/*  98 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/*  99 */     List<Users> list = (List<Users>)out.get("V_DATASET");
/*     */     
/* 101 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Permissions> spGetPermissionByRoleId(Integer id) {
/* 106 */     this
/*     */ 
/*     */       
/* 109 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_permission_by_role_id").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(Permissions.class));
/*     */ 
/*     */ 
/*     */     
/* 113 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_ROLE_ID", id);
/*     */     
/* 115 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 116 */     List<Permissions> list = (List<Permissions>)out.get("V_DATASET");
/*     */     
/* 118 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Permissions> spGetAllPermission(String searchValue, String perType) {
/* 127 */     this
/*     */ 
/*     */       
/* 130 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_all_permission").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(Permissions.class));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_SEARCH_VALUE", DataUtil.safeToString2(searchValue)).addValue("P_PER_TYPE", DataUtil.safeToString2(perType));
/*     */     
/* 137 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 138 */     List<Permissions> list = (List<Permissions>)out.get("V_DATASET");
/*     */     
/* 140 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Permissions> spSearchPermission(String searchValue, String perType, String fieldSort, String direction, int page, int size) {
/* 152 */     this
/*     */ 
/*     */       
/* 155 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_search_permission").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(Permissions.class));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_SEARCH_VALUE", DataUtil.safeToString2(searchValue)).addValue("P_PER_TYPE", DataUtil.safeToString2(perType)).addValue("P_ORDER_COLUMN", fieldSort).addValue("P_ORDER_TYPE", direction).addValue("P_PAGE", Integer.valueOf(page)).addValue("P_SIZE", Integer.valueOf(size));
/*     */     
/* 166 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 167 */     List<Permissions> list = (List<Permissions>)out.get("V_DATASET");
/*     */     
/* 169 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PermissionsModel> spGetMenuPermission(String searchValue) {
/* 174 */     this
/*     */ 
/*     */       
/* 177 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_menu_permission").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(PermissionsModel.class));
/*     */ 
/*     */ 
/*     */     
/* 181 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_SEARCH_VALUE", DataUtil.safeToString2(searchValue));
/*     */     
/* 183 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 184 */     List<PermissionsModel> list = (List<PermissionsModel>)out.get("V_DATASET");
/*     */     
/* 186 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PermissionsModel> spGetChillPermission(Long perId) {
/* 191 */     this
/*     */ 
/*     */       
/* 194 */       .simpleJdbcCallRefCursor = (new SimpleJdbcCall(this.jdbcTemplate)).withCatalogName(this.env.getProperty("spring.datasource.hikari.schema")).withProcedureName("sp_get_chill_permission").returningResultSet("V_DATASET", (RowMapper)new BeanPropertyRowMapper(PermissionsModel.class));
/*     */ 
/*     */ 
/*     */     
/* 198 */     MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("P_PER_ID", perId);
/*     */     
/* 200 */     Map out = this.simpleJdbcCallRefCursor.execute((SqlParameterSource)mapSqlParameterSource);
/* 201 */     List<PermissionsModel> list = (List<PermissionsModel>)out.get("V_DATASET");
/*     */     
/* 203 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Modules\Users\Repository\CommonUserRoleRepo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */