package bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class dbBean {

    /**
     * rdmsConfig : {"rdmsType":"MySQL","connectionInfo":"jdbc:mysql://172.24.5.19:3306/","username":"root","password":"baifendian","dbConfig":{"dbnumber":5,"schemaConfig":{"scNumber":5},"appointConfig":{"ratio":0.1},"tableSpaceConfig":{"tsName":"bi_space","tsAddress":"/opt/u01/app/oraclebi_tspace","tsSize":"500MB"},"userConfig":{"oracleUsername":"root","oraclePassword":"root","otSpace":"bi_space"},"tableConfig":{"tableNumber":5,"tableRatio":0.1,"columnConfig":{"minNumber":20,"maxNumber":100,"specialSize":"2MB"},"rowNumberConfig":{"minNumber":1000000,"maxNumber":10000000}}}}
     */

    private RdmsConfigBean rdmsConfig;

    public RdmsConfigBean getRdmsConfig() {
        return rdmsConfig;
    }

    public void setRdmsConfig(RdmsConfigBean rdmsConfig) {
        this.rdmsConfig = rdmsConfig;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RdmsConfigBean {
        /**
         * rdmsType : MySQL
         * connectionInfo : jdbc:mysql://172.24.5.19:3306/
         * username : root
         * password : baifendian
         * dbConfig : {"dbnumber":5,"schemaConfig":{"scNumber":5},"appointConfig":{"ratio":0.1},"tableSpaceConfig":{"tsName":"bi_space","tsAddress":"/opt/u01/app/oraclebi_tspace","tsSize":"500MB"},"userConfig":{"oracleUsername":"root","oraclePassword":"root","otSpace":"bi_space"},"tableConfig":{"tableNumber":5,"tableRatio":0.1,"columnConfig":{"minNumber":20,"maxNumber":100,"specialSize":"2MB"},"rowNumberConfig":{"minNumber":1000000,"maxNumber":10000000}}}
         */

        private String rdmsType;
        private String connectionInfo;
        private String username;
        private String password;
        private DbConfigBean dbConfig;

        public String getRdmsType() {
            return rdmsType;
        }

        public void setRdmsType(String rdmsType) {
            this.rdmsType = rdmsType;
        }

        public String getConnectionInfo() {
            return connectionInfo;
        }

        public void setConnectionInfo(String connectionInfo) {
            this.connectionInfo = connectionInfo;
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

        public DbConfigBean getDbConfig() {
            return dbConfig;
        }

        public void setDbConfig(DbConfigBean dbConfig) {
            this.dbConfig = dbConfig;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DbConfigBean {
            /**
             * dbnumber : 5
             * schemaConfig : {"scNumber":5}
             * appointConfig : {"ratio":0.1}
             * tableSpaceConfig : {"tsName":"bi_space","tsAddress":"/opt/u01/app/oraclebi_tspace","tsSize":"500MB"}
             * userConfig : {"oracleUsername":"root","oraclePassword":"root","otSpace":"bi_space"}
             * tableConfig : {"tableNumber":5,"tableRatio":0.1,"columnConfig":{"minNumber":20,"maxNumber":100,"specialSize":"2MB"},"rowNumberConfig":{"minNumber":1000000,"maxNumber":10000000}}
             */

            private int dbnumber;
            private SchemaConfigBean schemaConfig;
            private AppointConfigBean appointConfig;
            private TableSpaceConfigBean tableSpaceConfig;
            private UserConfigBean userConfig;
            private TableConfigBean tableConfig;

            public int getDbnumber() {
                return dbnumber;
            }

            public void setDbnumber(int dbnumber) {
                this.dbnumber = dbnumber;
            }

            public SchemaConfigBean getSchemaConfig() {
                return schemaConfig;
            }

            public void setSchemaConfig(SchemaConfigBean schemaConfig) {
                this.schemaConfig = schemaConfig;
            }

            public AppointConfigBean getAppointConfig() {
                return appointConfig;
            }

            public void setAppointConfig(AppointConfigBean appointConfig) {
                this.appointConfig = appointConfig;
            }

            public TableSpaceConfigBean getTableSpaceConfig() {
                return tableSpaceConfig;
            }

            public void setTableSpaceConfig(TableSpaceConfigBean tableSpaceConfig) {
                this.tableSpaceConfig = tableSpaceConfig;
            }

            public UserConfigBean getUserConfig() {
                return userConfig;
            }

            public void setUserConfig(UserConfigBean userConfig) {
                this.userConfig = userConfig;
            }

            public TableConfigBean getTableConfig() {
                return tableConfig;
            }

            public void setTableConfig(TableConfigBean tableConfig) {
                this.tableConfig = tableConfig;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SchemaConfigBean {
                /**
                 * scNumber : 5
                 */

                private int scNumber;

                public int getScNumber() {
                    return scNumber;
                }

                public void setScNumber(int scNumber) {
                    this.scNumber = scNumber;
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class AppointConfigBean {
                /**
                 * ratio : 0.1
                 */

                private double ratio;

                public double getRatio() {
                    return ratio;
                }

                public void setRatio(double ratio) {
                    this.ratio = ratio;
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class TableSpaceConfigBean {
                /**
                 * tsName : bi_space
                 * tsAddress : /opt/u01/app/oraclebi_tspace
                 * tsSize : 500MB
                 */

                private String tsName;
                private String tsAddress;
                private String tsSize;

                public String getTsName() {
                    return tsName;
                }

                public void setTsName(String tsName) {
                    this.tsName = tsName;
                }

                public String getTsAddress() {
                    return tsAddress;
                }

                public void setTsAddress(String tsAddress) {
                    this.tsAddress = tsAddress;
                }

                public String getTsSize() {
                    return tsSize;
                }

                public void setTsSize(String tsSize) {
                    this.tsSize = tsSize;
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UserConfigBean {
                /**
                 * oracleUsername : root
                 * oraclePassword : root
                 * otSpace : bi_space
                 */

                private String oracleUsername;
                private String oraclePassword;
                private String otSpace;

                public String getOracleUsername() {
                    return oracleUsername;
                }

                public void setOracleUsername(String oracleUsername) {
                    this.oracleUsername = oracleUsername;
                }

                public String getOraclePassword() {
                    return oraclePassword;
                }

                public void setOraclePassword(String oraclePassword) {
                    this.oraclePassword = oraclePassword;
                }

                public String getOtSpace() {
                    return otSpace;
                }

                public void setOtSpace(String otSpace) {
                    this.otSpace = otSpace;
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class TableConfigBean {
                /**
                 * tableNumber : 5
                 * tableRatio : 0.1
                 * columnConfig : {"minNumber":20,"maxNumber":100,"specialSize":"2MB"}
                 * rowNumberConfig : {"minNumber":1000000,"maxNumber":10000000}
                 */

                private int tableNumber;
                private double tableRatio;
                private ColumnConfigBean columnConfig;
                private RowNumberConfigBean rowNumberConfig;

                public int getTableNumber() {
                    return tableNumber;
                }

                public void setTableNumber(int tableNumber) {
                    this.tableNumber = tableNumber;
                }

                public double getTableRatio() {
                    return tableRatio;
                }

                public void setTableRatio(double tableRatio) {
                    this.tableRatio = tableRatio;
                }

                public ColumnConfigBean getColumnConfig() {
                    return columnConfig;
                }

                public void setColumnConfig(ColumnConfigBean columnConfig) {
                    this.columnConfig = columnConfig;
                }

                public RowNumberConfigBean getRowNumberConfig() {
                    return rowNumberConfig;
                }

                public void setRowNumberConfig(RowNumberConfigBean rowNumberConfig) {
                    this.rowNumberConfig = rowNumberConfig;
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class ColumnConfigBean {
                    /**
                     * minNumber : 20
                     * maxNumber : 100
                     * specialSize : 2MB
                     */

                    private int minNumber;
                    private int maxNumber;
                    private String specialSize;

                    public int getMinNumber() {
                        return minNumber;
                    }

                    public void setMinNumber(int minNumber) {
                        this.minNumber = minNumber;
                    }

                    public int getMaxNumber() {
                        return maxNumber;
                    }

                    public void setMaxNumber(int maxNumber) {
                        this.maxNumber = maxNumber;
                    }

                    public String getSpecialSize() {
                        return specialSize;
                    }

                    public void setSpecialSize(String specialSize) {
                        this.specialSize = specialSize;
                    }
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class RowNumberConfigBean {
                    /**
                     * minNumber : 1000000
                     * maxNumber : 10000000
                     */

                    private int minNumber;
                    private int maxNumber;

                    public int getMinNumber() {
                        return minNumber;
                    }

                    public void setMinNumber(int minNumber) {
                        this.minNumber = minNumber;
                    }

                    public int getMaxNumber() {
                        return maxNumber;
                    }

                    public void setMaxNumber(int maxNumber) {
                        this.maxNumber = maxNumber;
                    }
                }
            }
        }
    }
}
