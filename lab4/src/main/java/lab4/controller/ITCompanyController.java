package lab4.controller;

import lab4.model.dao.GeneralDAO;
import lab4.model.dao.ITCompanyDAO;
import lab4.model.entity.ITCompany;

import java.util.List;

public class ITCompanyController implements GeneralDAO<ITCompany> {


    ITCompanyDAO itCompanyDAO = new ITCompanyDAO();

    @Override
    public List<ITCompany> findAll() {
        return itCompanyDAO.findAll();
    }

    @Override
    public ITCompany findOne(Integer id) {
        return itCompanyDAO.findOne(id);
    }

    @Override
    public void create(ITCompany itCompany) {
        itCompanyDAO.create(itCompany);
    }

    @Override
    public void update(Integer id, ITCompany itCompany) {
        itCompanyDAO.update(id, itCompany);
    }

    @Override
    public void delete(Integer id) {
        itCompanyDAO.delete(id);
    }
}