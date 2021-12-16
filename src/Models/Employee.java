package Models;

    public class Employee {

        public String forename;
        public String surname;
        public String username;
        public String password;
        public int service;
        public boolean isAdmin;

        public Employee(String forename, String surname, String username, String password, int service, boolean admin) {
            this.forename = forename;
            this.surname = surname;
            this.username = username;
            this.password = password;
            this.service = service;
            this.isAdmin = admin;
        }

        public String getForename() {

            return forename;
        }

        public void setForename(String forename) {

            this.forename = forename;
        }

        public String getSurname() {

            return surname;
        }

        public void setSurname(String surname) {

            this.surname = surname;
        }

        public String getUsername() {

            return username;
        }

        public void setUsername(String username) {

            this.username = username;
        }

        public String getPassword() {

            return password;
        }

        public void setPassword(String password) {

            this.password = password;
        }


        public int getService() {

            return service;
        }

        public void setService(int service) {

            this.service = service;
        }

        public boolean getIsAdmin() {

            return isAdmin;
        }
        public boolean setIsAdmin(boolean isAdmin) {

            this.isAdmin = isAdmin;


            return isAdmin;
        }

    }


