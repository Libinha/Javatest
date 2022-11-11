# 一、Spring bean

## 1、概念

在 Spring 中，构成应用程序主干并由Spring IoC容器管理的对象称为bean。bean是一个由Spring IoC容器实例化、组装和管理的对象。

Spring bean是任何Spring应用程序的基本构建块。我们编写的大多数应用程序逻辑代码都将放在Spring bean中。


## 2、bean的作用域

	在bean声明时它有一个scope属性,它是用来描述bean的作用域

	可取值有:
	Singleton: 单例 代表在spring容器中只有一个bean的实例(默认的scope)
	Prototype: 多例 每一次从spring容器中获取时,都会返回一个新的实例
	Request: 用在web开发中,将bean对象request.setAttribute()存储到request域中
	Session:	用在web开发中,将bean对象session.setAttribute()存储到session域中

## 3、bean生命周期
Spring Bean的完整生命周期从创建Spring容器开始，直到最终Spring容器销毁Bean的全过程

	1.	instantiate bean对象实例化
	2.	populate properties 封装属性
	3.	如果Bean实现BeanNameAware执行setBeanName
	4.	如果Bean实现BeanFactoryAware或ApplicationContextAware设置工厂setBeanFactory或上下文对象setApplicationContext
	5.	如果存在类实现BeanPostProcessor(后处理Bean),执行postProcessBeforeInitialization
	6.	如果Bean实现InitializingBean执行afterPropertiesSet
	7.	调用自定义的init-method方法
	8.	如果存在类实现BeanPostProcessor(处理Bean),执行postProcessAfterInitialization
	9.	执行业务处理
	10.	如果Bean实现DisposableBean执行destroy
	11.	调用自定义的destroy-method


# 二、IOC控制反转

## 1、IOC概念
概念：Ioc(inverse of control)控制反转,Ioc简单来说,就是将原来由我们实例化的对象,交由spring框架来进行实例化.这是对象的实例化的权利就会反转.

## 2、IOC xml-based配置方式

1）在applicationContext.xml文件中配置bean

	<bean id="userService" class="com.example.iocTest.UserServiceImpl"/>

2.创建一个applicationContext对象

        /*
        * 使用spring提供的ioc
        * ioc本质是通过xml配置文件+反射+factory通用工厂来实现
        * 在spring中提供beanFactory,我们一般使用其子接口ApplicationContext
        */
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService service = (IUserService) context.getBean("userService");
        service.sayHello();

> 注：applicationContext对象它是beanFactory的一个子接口,我们在使用的时候使用的是它的实现类classPathXmlApplicationContext;
> 可以通过applicationContext对象的getBean(配置文件中id名称)来获取指定的对象

## 3、IOC annotation-based的配置

1）在applicationContext.xml文件中配置注解扫描

	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.example"/>

	</beans>

2）编写IUserService接口及UserServiceImpl类

	//IUserService接口
	public interface IUserService {

    	public void sayHello();
	}
 
	//UserServiceImpl类
	@Component("userService")
	public class UserServiceImpl implements IUserService {
    @Override
    public void sayHello() {
        System.out.println("Hello spring!!!");
    }
	}

3）编写测试类

	public class IocTest4 {

    @Test
    public void test(){
        //获取ApplicationContext对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        //获取目标对象并调用方法
        IUserService service = context.getBean("userService", IUserService.class);
        service.sayHello();
    }
	}

4）编写测试类2

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations = "classpath:applicationContext2.xml")
	public class IocTest2 {
    	@Autowired
    	private IUserService userService;

    	@Test
    	public void test(){
        	userService.sayHello();

    	}
	}

> @RunWith：用于指定junit运行环境
> @ContextConfiguration：导入配置文件
> @Autowired：自动加载

## 4、IOC java-based配置方式

1）编写User类

	@Component("user")
	@Scope("singleton")
	@Lazy(false)
	public class User {
    	private int id;
    	private String name;
    	private int age;
	}

2）编写AppConfig类

注解：@Configuration、@ComponentScan、@Import

	
	@Configuration
	@ComponentScan(basePackages = "com.example")
	@Import(SubAppConfig.class)
	public class AppConfig {

    	@Bean
    	public User user(){
        	return new User();
    	}
	}

3）编写SubAppConfig类

	@Configuration
	public class SubAppConfig {

	}

4）编写测试类

	public class IocTest3 {

    @Test
    public void test(){
        //获取注解配置容器
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //获取对象
        User user = context.getBean("user", User.class);
        System.out.println(user);

    }
	}

5）注解总结

	@Configuration 就类似于我们之前定义的beans.xml

	@ComponentScan 用于扫描
	例如，注解 @ComponentScan(basePackages = “com.example”) 相当于如下xml配置：
	<context:component-scan base-package="com.example"/>

	@Import用于引入其他注解配置类
	例如，注解 @Import(SubAppConfig.class) 功能相当于如下xml配置：
	<import resource="beans.xml"/>

	@Bean 用于方法上，返回值：相当于bean标签中的class属性。方法名：相当于bean标签中的id属性。
	
	
	@Scope注解
	是 Spring IOC 容器中的一个作用域，在 Spring IOC 容器中，他用来配置Bean实例的作用域对象。
	singleton 单例(默认)-全局有且仅有一个实例
	prototype 多实例的(多例)-每次获取Bean的时候会有一个新的实例
	reqeust 同一次请求-request：每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP request内有效
	session 同一个会话级别-session：每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP session内有效

	@Lazy懒加载注解
	SpringIoC容器会在启动的时候实例化所有单实例bean。@Lazy可以实现 Spring 在启动的时候延迟加载 bean，即在首次调用bean的时候再去执行初始化。
	使用@Lazy的前提是要操作的Bean要使用默认的单例模式

# 三、DI依赖注入

## 1、DI概念

概念：DI（dependency injection）依赖注入，在spirng框架负责创建bean对象时,动态的将依赖对象注入到bean组件中.


## 2、构造方法注入方式

1）在User类中添加有参构造

	public class User {

    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name=name;
        this.age=age;
    }
	}


2）在ApplicationContext.xml中配置

    <bean id="user" class="com.example.bean.User">
        <constructor-arg name="id" value="1"/>
        <constructor-arg name="name" value="张三"/>
        <constructor-arg name="age" value="18"/>
    </bean>

3）编写测试类

	@Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

## 3、Setter方法注入方式

1）在User2类中添加setter方法

	public class User2 {

    private int id;
    private String name;
    private int age;

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
	}


2）在ApplicationContext.xml中配置

	<bean id="user2" class="com.example.bean.User2">
        <property name="id" value="2"/>
        <property name="name" value="李四"/>
        <property name="age" value="20"/>
    </bean>

3）编写测试类

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User2 user = context.getBean("user2", User2.class);
        System.out.println(user);
    }

## 4、通过参数直接注入

1）在User2类中添加setter方法,使用@Value()注解注入属性

	@Component("user3")
	@Scope("singleton")
	@Lazy(false)
	public class User3 {

    	@Value("3")
    	private int id;

    	@Value("王五")
    	private String name;

    	@Value("22")
    	private int age;

	}

2）编写AppConfig类

	@Configuration
	@ComponentScan(basePackages = "com.example")
	public class AppConfig {

	}

3）编写测试类

	@Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User3 user = context.getBean("user3", User3.class);
        System.out.println(user);
    }



## 5、DI注入外部配置文件示例

1）编写db.properties配置文件

	jdbc.url=jdbc:mysql://localhost:3306/test
	jdbc.drivername=com.mysql.jdbc.Driver
	jdbc.username=root
	jdbc.password=123456

2）编写ConnectionPool类

	@Component("conn")
	public class ConnectionPool {

    	@Value("${jdbc.url}")
    	private String url;

    	@Value("${jdbc.drivername}")
    	private String driverName;

    	@Value("${jdbc.username}")
    	private String userName;

    	@Value("${jdbc.password}")
    	private String passWord;
	}

3）编写配置类，用于扫描bean和properties文件

	@Configuration
	@ComponentScan(basePackages = "com.example")
	@PropertySource({"classpath:db.properties"})
	public class AppConfig {
	}

4）编写测试类

	@Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConnectionPool conn = context.getBean("conn", ConnectionPool.class);
        System.out.println(conn);
    }

# 四、IOC和DI的区别

IOC 控制反转,是指对象实例化权利交由spring容器来管理

DI	依赖注入 在spring创建bean对象过程中,动态的将对象所依赖的属性通过配置注入到对象中

# 五、测试代码下载
[https://github.com/Libinha/Javatest/archive/refs/heads/master.zip](https://github.com/Libinha/Javatest/archive/refs/heads/master.zip)