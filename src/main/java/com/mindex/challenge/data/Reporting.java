package com.mindex.challenge.data;

public class Reporting {
        private Employee employee;
        private Integer numberOfReports = 0;

        public Reporting() {
        }

        public Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
        }

        public Integer getNumOfDirectReports() {
            return numberOfReports;
        }

        public void setNumOfDirectReports(Integer numberOfReports) {
            this.numberOfReports = numberOfReports;
        }
}
