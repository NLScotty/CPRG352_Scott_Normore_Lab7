package ca.sait.lab7.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ca.sait.lab7.models.generated.Role;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class RoleDB {

    public List<Role> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query query=em.createNamedQuery("Role.findAll");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public int lookupRoleID(String roleName) throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Query query = em.createNamedQuery("Role.findByRoleName");
            query.setParameter("roleName",roleName);
            Role role = (Role) query.getSingleResult();
            return role.getRoleId();
        } finally {
            em.close();
        }
    }
}
