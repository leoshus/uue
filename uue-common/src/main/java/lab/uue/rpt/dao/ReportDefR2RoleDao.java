package lab.uue.rpt.dao;

import java.util.List;

import lab.uue.core.dao.BaseDao;
import lab.uue.rpt.entity.ReportDefR2Role;

import org.springframework.stereotype.Repository;

@Repository
public interface ReportDefR2RoleDao extends BaseDao<ReportDefR2Role, String> {

    List<ReportDefR2Role> findByRole_Id(String roleId);
    
    List<ReportDefR2Role> findByReportDef_Id(String reportDefId);
}
