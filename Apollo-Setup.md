# Setup

Apollo needs the MySQL DB to store the data of config and portal, so you must have MySQL installed on a host (in my test case: 192.168.1.102)

**Steps:**

1. Download `apollo-adminservice-1.8.1-github.zip`, [`apollo-configservice-1.8.1-github.zip`](http://apollo-configservice-1.8.1-github.zip) and [`apollo-portal-1.8.1-github.zip`](http://apollo-portal-1.8.1-github.zip) from [https://github.com/ctripcorp/apollo/releases/tag/v1.8.1](https://github.com/ctripcorp/apollo/releases/tag/v1.8.1)
2. cd to the directory and unzip the zip files
3. `scp -r ./apollo-* root@apollo:/root`
4. Check or download the SQL for the MySQL DB and table setup: [https://github.com/ctripcorp/apollo/tree/master/scripts/sql](https://github.com/ctripcorp/apollo/tree/master/scripts/sql)
5. Run all the SQLs in `apolloconfigdb.sql` and `apolloportaldb.sql` in MySQL command line. 
6. Change the MySQL server IP, username and password in file `apollo-configservice-1/config/application-github.properties`

    ```java
    # DataSource
    spring.datasource.url = jdbc:mysql://192.168.1.102:3306/ApolloConfigDB?characterEncoding=utf8
    spring.datasource.username = FillInCorrectUser
    spring.datasource.password = FillInCorrectPassword
    ```

7. `java -jar apollo-configservice-1.8.1.jar`
8. Verify the above service has started: [http://192.168.1.17:8080](http://192.168.1.17:8080/)
9. Repeat 6 and 7 for `apollo-adminservice-1/config/application-github.properties`
10. Repeat 6 and 7 for `apollo-portal-1/config/application-github.properties` but the DB name in the MtSQL url must be `ApolloPortalDB`
11. Modify the `apollo-portal-1/config/apollo-env.properties` 

    ```java
    local.meta=http://localhost:8080
    dev.meta=http://localhost:8080
    #fat.meta=http://fill-in-fat-meta-server:8080
    #uat.meta=http://fill-in-uat-meta-server:8080
    #lpt.meta=${lpt_meta}
    #pro.meta=http://fill-in-pro-meta-server:8080
    ```

    Now just for test

12. `java -jar apollo-portal-1.8.1.jar`
13. Verify the above service has started: [http://192.168.1.17:80](http://192.168.1.17:8080/)70

    ```java
    username: apollo
    password: admin
    ```