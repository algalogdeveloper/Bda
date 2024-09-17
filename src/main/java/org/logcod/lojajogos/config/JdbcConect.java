package org.logcod.lojajogos.config;

public enum JdbcConect {

    INTEGRATOR  {
        @Override
        public DataSourceConnection ConectDataSource() {
            return new ConnectionIntegrator();
        }
    },
    HEROKU {
        @Override
        public DataSourceConnection ConectDataSource() {
            return new ConnectionHeroku();
        }
    },
    MATHEUSDB {
        @Override
        public DataSourceConnection ConectDataSource() {
            return new JdbcConectMatheusDB();
        }
    },
    MYSQL_MARIADB {
        @Override
        public  DataSourceConnection ConectDataSource() {
            return new ConectDBMatheusMYSQL();
        }
    },
    POSTGRESQL {
        @Override
        public DataSourceConnection ConectDataSource() {
            return new JdbcConectPostgres();
        }
    };

    public abstract DataSourceConnection ConectDataSource();
}
