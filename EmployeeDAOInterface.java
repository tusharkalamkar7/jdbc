package com.project.dao;
public interface EmployeeDAOInterface{
        public void save(int empNo, String name, double sal, int dNo);
        public boolean updateSal(int empNo, double newSal);
        public String getEmp(int empNo);
        boolean delete(int empno);
}