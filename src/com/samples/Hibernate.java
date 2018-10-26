package com.samples;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class Hibernate {
    public static void main(String args[]) {
        //Hibernate and Spring JDBC template
    }

}

class ProjectLeaseDetailsHome extends LeaseDetailsHome {

    @SuppressWarnings("unchecked")
    public List <LeaseDetails> findByOrderId(long orderId) {
        log.debug("finding LeaseDetails instance by orderId " + orderId);
        try {
            List<LeaseDetails> results = (List<LeaseDetails>) sessionFactory.getCurrentSession().createCriteria(LeaseDetails.class)
                    .add(Restrictions.eq("ord.orderId", orderId)).list();
            log.debug("find by orderId successful, result size: " + results.size());
            return results;
        } catch (HibernateException re) {
            log.error("find by orderId failed", re);
            throw re;
        }

    }

}

class LeaseDetailsHome extends BaseDao {

    public void persist(LeaseDetails transientInstance) {
        log.debug("persisting LeaseDetails instance");
        try {
            //SessionFactory is in BaseDao which is Hibernate Session factory
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }

    }

    public LeaseDetails findById(java.lang.Integer id) {
        log.debug("getting LeaseDetails instance with id: " + id);
        try {
            LeaseDetails instance = (LeaseDetails) sessionFactory.getCurrentSession().get(
                    "com.ecom.domain.LeaseDetails", id);
            if (instance == null) {
                log.debug("get successful, no instance found");
            } else {
                log.debug("get successful, instance found");
            }
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(LeaseDetails instance) {
        log.debug("finding LeaseDetails instance by example");
        try {
            List results = sessionFactory.getCurrentSession().createCriteria("com.ecom.domain.LeaseDetails").add(
                    Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}



class MyJDBCHelper extends BaseJDBCHelper {
    public ArrayList<Integer> getParentList(final Integer releaseNum, final Long orderId) throws Exception {
        final String METHOD_NAME = "getParentList";
        LOGGER.info("Entering" + CLASS_NAME + "." + METHOD_NAME);
        try {
            //jdbc.queryForList(getMsgStringSql, new Object[] { orderId, orderId }, String.class);
            ArrayList<Integer> parentResultList = (ArrayList<Integer>) this.getJdbcTemplate().query(ServiceQueryConstants.CHECK_PARENT_RELEASE, new PreparedStatementSetter() {
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setLong(1, orderId);
                    preparedStatement.setInt(2, releaseNum);
                }
            }, new ResultSetExtractor() {
                public Object extractData(ResultSet result) throws SQLException, DataAccessException {
                    ArrayList<Integer> resultList = new ArrayList<Integer>();
                    while (result.next()) {
                        LOGGER.info("PARENT_ORDER_ITEM_ID IS :: " + result.getInt("PARENT_ORDER_ITEM_ID"));
                        resultList.add(result.getInt("PARENT_ORDER_ITEM_ID"));
                        break;
                    }
                    return resultList;
                }
            });
            return parentResultList;
        } catch (Exception e) {


            throw e;
        }

    }
}