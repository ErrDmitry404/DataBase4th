package lab4.controller;

import lab4.model.dao.GeneralDAO;
import lab4.model.dao.MonitorDAO;
import lab4.model.entity.Monitor;

import java.util.List;

public class MonitorController implements GeneralDAO<Monitor> {


    MonitorDAO itCompanyDAO = new MonitorDAO();

    @Override
    public List<Monitor> findAll() {
        return itCompanyDAO.findAll();
    }

    @Override
    public Monitor findOne(Integer id) {
        return itCompanyDAO.findOne(id);
    }

    @Override
    public void create(Monitor monitor) {
        itCompanyDAO.create(monitor);
    }

    @Override
    public void update(Integer id, Monitor monitor) {
        itCompanyDAO.update(id, monitor);
    }

    @Override
    public void delete(Integer id) {
        itCompanyDAO.delete(id);
    }
}
