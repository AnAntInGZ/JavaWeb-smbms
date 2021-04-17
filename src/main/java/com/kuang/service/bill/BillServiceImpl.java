package com.kuang.service.bill;

import com.kuang.dao.BaseDao;
import com.kuang.dao.bill.BillDao;
import com.kuang.dao.bill.BillDaoImpl;
import com.kuang.pojo.Bill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



public class BillServiceImpl implements BillService {
	
	private BillDao billDao;
	public BillServiceImpl(){
		billDao = new BillDaoImpl();
	}
	@Override
	public boolean add(Bill bill) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false);//开启JDBC事务管理
			if(billDao.add(connection,bill) > 0)
				flag = true;
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			//在service层进行connection连接的关闭
			BaseDao.closeResource(connection, null, null);
		}
		return flag;
	}

	@Override
	public List<Bill> getBillList(Bill bill) {
		Connection connection = null;
		List<Bill> billList = null;
		
		try {
			connection = BaseDao.getConnection();
			billList = billDao.getBillList(connection, bill);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return billList;
	}

	@Override
	public boolean deleteBillById(String delId) {
		Connection connection = null;
		boolean flag = false;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false);//开启JDBC事务管理
			if(billDao.deleteBillById(connection, delId) > 0)
				flag = true;
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return flag;
	}

	@Override
	public Bill getBillById(String id) {
		Bill bill = null;
		Connection connection = null;
		try{
			connection = BaseDao.getConnection();
			bill = billDao.getBillById(connection, id);
		}catch (Exception e) {
			e.printStackTrace();
			bill = null;
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return bill;
	}

	@Override
	public boolean modify(Bill bill) {
		Connection connection = null;
		boolean flag = false;
		try {
			connection = BaseDao.getConnection();
			connection.setAutoCommit(false);//开启JDBC事务管理
			if(billDao.modify(connection,bill) > 0)
				flag = true;
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return flag;
	}

}
