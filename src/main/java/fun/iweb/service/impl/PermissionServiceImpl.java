package fun.iweb.service.impl;

import fun.iweb.dao.IPermissionDao;
import fun.iweb.domain.Permission;
import fun.iweb.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public void deleteById(Integer id) throws Exception {
        permissionDao.deleteFromRole_Permission(id);
        permissionDao.deleteById(id);
    }

    @Override
    public Permission findById(Integer id) throws Exception {
        return permissionDao.findById(id);
    }

    @Override
    public void save(Permission permission) throws Exception{
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findAll() throws Exception{
        return permissionDao.findAll();
    }
}
