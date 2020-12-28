package lab4.controller;

import lab4.model.dao.GeneralDAO;
import lab4.model.dao.WorkerDAO;
import lab4.model.entity.Worker;

import java.util.List;

public class WorkerController implements GeneralDAO<Worker> {


    WorkerDAO workerDAO = new WorkerDAO();

    @Override
    public List<Worker> findAll() {
        return workerDAO.findAll();
    }

    @Override
    public Worker findOne(Integer id) {
        return workerDAO.findOne(id);
    }

    @Override
    public void create(Worker worker) {
        workerDAO.create(worker);
    }

    @Override
    public void update(Integer id, Worker worker) {
        workerDAO.update(id, worker);
    }

    @Override
    public void delete(Integer id) {
        workerDAO.delete(id);
    }
}
