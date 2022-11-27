/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sapmle.utils.DBUtil;

/**
 *
 * @author minhq
 */
public class UserDAO {
    private final String LOGIN="Select fullname, roleID "
                       + " From tblUsers "
                       + " where userID =? and password =? and status = 1 ";
    
        private final String SEARCH ="Select userID, fullname, roleID, status  "
                       + " From tblUsers "
                       + " where fullname like ? ";
        
        private final String DELETE=" Update tblUsers "
                + " set  status = ?  "
                + " where userID = ? ";
        
        private final String UPDATE=" Update tblUsers "
                + " set  roleID = ? , fullname = ?  "
                + " where userID like  ? ";
        
      private final String CHECKID="Select userID "
                       + " From tblUsers "
                       + " where userID =?  ";
      
      private final String INSERT=" Insert into tblUsers (userID,fullname,password,roleID,status) "
              + " values(?,?,?,?,?) ";
    
   public  UserDTO checkLogin(String userId,String password) throws SQLException{
         UserDTO user= null;
       boolean check=false;
       Connection conn=null;
       PreparedStatement pst=null;
       ResultSet rs=null;
       
       try{
           conn=DBUtil.getConnection();
           if(conn!=null){
               String sql=LOGIN;
               pst=conn.prepareStatement(sql);
               pst.setString(1, userId);
               pst.setString(2, password);
               rs=pst.executeQuery();
               if(rs.next()){
                 String fullname=rs.getString("fullname");
                 String roleID=rs.getString("roleID");
                 user=new UserDTO(userId,fullname,"",roleID,true);
               }
           }
       } catch(Exception e){
       e.printStackTrace();
   } finally {
       if(rs!=null){
           rs.close();
       } 
       if(pst!=null){
           pst.close();
       } 
       if(conn!=null){
           conn.close();
       }
   }
       return user;
}
   public List<UserDTO> getListUser(String search) throws SQLException{
       List<UserDTO> listUser=new ArrayList<>();
       Connection conn=null;
       PreparedStatement pst=null;
       ResultSet rs=null;
       try{
           conn=DBUtil.getConnection();
           if(conn!=null){
               String sql=SEARCH;
               pst=conn.prepareStatement(sql);
               pst.setString(1, "%" + search + "%");
               rs=pst.executeQuery();
               while(rs.next()){
                   String userID =rs.getString("userID");
                    String fullname =rs.getString("fullname");
                    String password ="***";
                   String roleID =rs.getString("roleID");
                   boolean status=rs.getBoolean("status");
             listUser.add(new UserDTO(userID,fullname,password,roleID,status ));
                    
               }
           }
       } catch (Exception e){
           e.printStackTrace();
       } finally {
           if(rs!=null){
               rs.close();
           } if(pst!=null){
               pst.close();
           } if(conn!=null){
               conn.close();
           }
       }
       return listUser;
} 
   public boolean delete(String userID) throws SQLException{
       boolean result=false;
       Connection conn=null;
       PreparedStatement pst=null;
       try{
           conn=DBUtil.getConnection();
           if (conn!=null){
               String sql=DELETE;
               pst=conn.prepareStatement(sql);
               pst.setBoolean(1, false);
               pst.setString(2,userID);
               result=pst.executeUpdate()>0 ?true : false ;
               
           }
       } catch (Exception e){
           e.printStackTrace();
       } finally{
           if(pst!=null){
               pst.close();
           } if(conn!=null){
               conn.close();
           }
       }
       return result;
   }
      public boolean update(UserDTO user) throws SQLException{
       boolean result=false;
       Connection conn=null;
       PreparedStatement pst=null;
       try{
           conn=DBUtil.getConnection();
           if (conn!=null){
               String sql=UPDATE;
               pst=conn.prepareStatement(sql);
            pst.setString(1, user.getRoleID());
            pst.setString(2, user.getFullname());
            pst.setString(3, user.getUserID());
            result=pst.executeUpdate()>0 ?true : false ;
               
           }
       } catch (Exception e){
           e.printStackTrace();
       } finally{
           if(pst!=null){
               pst.close();
           } if(conn!=null){
               conn.close();
           }
       }
       return result;
   }
      public boolean checkID(String userID) throws SQLException{
       boolean result=false;
       Connection conn=null;
       PreparedStatement pst=null;
       ResultSet rs=null;
       try{
           conn=DBUtil.getConnection();
           if (conn!=null){
               String sql=CHECKID;
               pst=conn.prepareStatement(sql);
               pst.setString(1,userID);
               rs=pst.executeQuery();
               if(rs.next()){
               result=true;
               } 
           }
       } catch (Exception e){
           e.printStackTrace();
       } finally{
           if(pst!=null){
               pst.close();
           } if(conn!=null){
               conn.close();
           }
       }
       return result;
   }
      public boolean insert(UserDTO user) throws SQLException{
       boolean result=false;
       Connection conn=null;
       PreparedStatement pst=null;
       try{
           conn=DBUtil.getConnection();
           if (conn!=null){
               String sql=INSERT;
               pst=conn.prepareStatement(sql);
            pst.setString(1, user.getUserID());
            pst.setString(2, user.getFullname());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getRoleID());
            pst.setBoolean(5, true);
            result=pst.executeUpdate()>0 ?true : false ;
               
           }
       } catch (Exception e){
           e.printStackTrace();
       } finally{
           if(pst!=null){
               pst.close();
           } if(conn!=null){
               conn.close();
           }
       }
       return result;
   }
       public boolean insertV2(UserDTO user) throws SQLException, ClassNotFoundException, NamingException{
       boolean result=false;
       Connection conn=null;
       PreparedStatement pst=null;
       try{
           conn=DBUtil.getConnection();
           if (conn!=null){
               String sql=INSERT;
               pst=conn.prepareStatement(sql);
            pst.setString(1, user.getUserID());
            pst.setString(2, user.getFullname());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getRoleID());
            pst.setBoolean(5, true);
            result=pst.executeUpdate()>0 ?true : false ;
               
           }
       }  finally{
           if(pst!=null){
               pst.close();
           } if(conn!=null){
               conn.close();
           }
       }
       return result;
}
}
