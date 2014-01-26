## Simple project using Oracle database with Spring, and Maven 

## Installation

* You will need to have setup the Oracle database and populate the data using the script provided (see below)
* You will need to copy the Oracle's jar file and install it to manually (see below) 
* Edit your hibernate.cfg.xml file to your Oracle's setup (username, password, host, port, etc)

### Install Oracle's jar manually using the following command

```
mvn install:install-file -Dfile=./ojdbc.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar
```

The reason we need to do this because we have the following section in ```pom.xml``` file

    <dependency>
      <groupId>com.oracle</groupId>
      <artifactId>ojdbc6</artifactId>
      <version>11.2.0</version>
    </dependency>

### You will also need to create following table in Oracle using the following DDL.

    CREATE TABLE DBUSER ( 
      USER_ID      NUMBER(12)    NOT NULL, 
      USER_NAME    VARCHAR2(20)  NOT NULL, 
      CREATED_BY   VARCHAR2(20)  NOT NULL, 
      CREATED_DATE DATE          NOT NULL, 
      PRIMARY KEY (USER_ID) 
    );

    CREATE TABLE DEPARTMENT ( 
      DEPT_ID     NUMBER(12)   NOT NULL, 
      DEPT_NAME   VARCHAR2(20) NOT NULL, 
      PRIMARY KEY (DEPT_ID) 
    );

    CREATE TABLE EMPLOYEE (
        EMP_ID     NUMBER(12)  NOT NULL,
        FIRST_NAME VARCHAR2(50) NOT NULL,
        LAST_NAME  VARCHAR2(50) NOT NULL,
        BIRTH_DATE DATE            NULL,
        CELL_PHONE VARCHAR2(15)     NULL,
        DEPT_ID    NUMBER(12)      NULL,
        PRIMARY KEY(EMP_ID)
    );

    ALTER TABLE EMPLOYEE ADD (
      CONSTRAINT EMP_DEPT_FK 
      FOREIGN KEY (EMP_ID) 
      REFERENCES DEPARTMENT(DEPT_ID));

    CREATE SEQUENCE EMP_SEQ
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NOCACHE 
    NOCYCLE 
    NOORDER;

### Edit your hibernate configuration file to your environment

    <?xml version="1.0" encoding="utf-8"?>
    <!DOCTYPE hibernate-configuration PUBLIC
    "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
    "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
    <hibernate-configuration>
      <session-factory>
        <property name="hibernate.connection.driver_class">oracle.jdbc.driver.OracleDriver</property>
        <property name="hibernate.connection.url">jdbc:oracle:thin:@<YOUR_SERVER_IP>:1521:<YOUR_SID></property>
        <property name="hibernate.connection.username">YOUR_DB_LOGIN</property>
        <property name="hibernate.connection.password">YOUR_DB_PASSWORD</property>
        <property name="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</property>
        <property name="hibernate.default_schema">YOUR_SCHEMA_NAME</property>
        <property name="show_sql">true</property>
        <mapping resource="com/demo/example/dbuser.hbm.xml"></mapping>
        <mapping resource="com/demo/example/department.hbm.xml"></mapping>
        <mapping resource="com/demo/example/employee.hbm.xml"></mapping>
      </session-factory>
    </hibernate-configuration>

### Once this is done you can then

Then you can run the following command

```
$mvn clean eclipse:eclipse install
```

If you want so use it from Eclipse then just use File->Import 

### Author

[Burin Choomnuan](https://github.com/agilecoders)