package Pack01;

import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
   @Bean(destroyMethod = "close")
   public DataSource dataSource() {
      DataSource ds = new DataSource();
      ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
      ds.setUrl("jdbc:mysql://react200.chg54jtrugg1.ap-northeast-2.rds.amazonaws.com:3306/kafka");
      ds.setUsername("admin");
      ds.setPassword("12345678"); 	// ~ conn
      ds.setInitialSize(2);			// pool ~
      ds.setMaxActive(20);
      ds.setTestWhileIdle(true);
      ds.setMinEvictableIdleTimeMillis(100 * 60 * 3);
      ds.setTimeBetweenEvictionRunsMillis(10*1000);
      return ds;
   }
}