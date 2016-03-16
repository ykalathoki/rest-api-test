package com.example;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Abstract class for unit testing. Added comments in each and every method(s)
 * or line(s) to understand easily why this line of code has been written. We
 * can go to official documentation for this information. But I thought adding
 * comments in line would be better to understand instead to visit official
 * documentation.
 * 
 * @author Yuba Raj Kalathoki
 * @version 0.1.0
 * @since 0.1.0
 */

/**
 * When a class is annotated with <code>&#064;RunWith</code> or extends a class
 * annotated with <code>&#064;RunWith</code>, JUnit will invoke the class it
 * references to run the tests in that class instead of the runner built into
 * JUnit. We added this feature late in development. While it seems powerful we
 * expect the runner API to change as we learn how people really use it. Some of
 * the classes that are currently internal will likely be refined and become
 * public.
 *
 * For example, suites in JUnit 4 are built using RunWith, and a custom runner
 * named Suite:
 *
 * <pre>
 * &#064;RunWith(Suite.class)
 * &#064;SuiteClasses({ATest.class, BTest.class, CTest.class})
 * public class ABCSuite {
 * }
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)

/**
 * Class-level annotation that is used to determine how to load and configure an
 * {@code ApplicationContext} for integration tests.
 * <p>
 * Similar to the standard {@link ContextConfiguration @ContextConfiguration}
 * but uses Spring Boot's {@link SpringApplicationContextLoader}.
 * 
 */
@SpringApplicationConfiguration(classes = RestApiTestApplication.class)

/**
 * {@code @WebAppConfiguration} is a class-level annotation that is used to
 * declare that the {@code ApplicationContext} loaded for an integration test
 * should be a {@link org.springframework.web.context.WebApplicationContext
 * WebApplicationContext}.
 *
 * <p>
 * The mere presence of {@code @WebAppConfiguration} on a test class ensures
 * that a {@code WebApplicationContext} will be loaded for the test using a
 * default for the path to the root of the web application. To override the
 * default, specify an explicit resource path via the {@link #value} attribute.
 *
 * <p>
 * Note that {@code @WebAppConfiguration} must be used in conjunction with
 * {@link org.springframework.test.context.ContextConfiguration @ContextConfiguration}
 * , either within a single test class or within a test class hierarchy.
 *
 * <p>
 * As of Spring Framework 4.0, this annotation may be used as a
 * <em>meta-annotation</em> to create custom <em>composed annotations</em>.
 * 
 */
@WebAppConfiguration
public abstract class Tester {
	// protected static final String CONTEXT_PATH = "/rest/api/v1";
	// protected static final String BASE_URI = "http://localhost:8080";
	/**
	 * to Generate JSON content from Java objects
	 */
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	/**
	 * Interface to provide configuration for a web application. This is
	 * read-only while the application is running, but may be reloaded if the
	 * implementation supports this.
	 * 
	 * This interface adds a getServletContext() method to the generic
	 * ApplicationContext interface, and defines a well-known application
	 * attribute name that the root context must be bound to in the bootstrap
	 * process.
	 * 
	 * Like generic application contexts, web application contexts are
	 * hierarchical. There is a single root context per application, while each
	 * servlet in the application (including a dispatcher servlet in the MVC
	 * framework) has its own child context.
	 * 
	 * In addition to standard application context lifecycle capabilities,
	 * WebApplicationContext implementations need to detect ServletContextAware
	 * beans and invoke the setServletContext method accordingly.
	 * 
	 */
	@Autowired
	protected WebApplicationContext webApplicationContext;
	/**
	 * Main entry point for server-side Spring MVC test support.
	 */
	protected MockMvc mockMvc;

	// Initializing mockMvc.
	/**
	 * When writing tests, it is common to find that several tests need similar
	 * objects created before they can run. Annotating a
	 * <code>public void</code> method with <code>&#064;Before</code> causes
	 * that method to be run before the {@link org.junit.Test} method. The
	 * <code>&#064;Before</code> methods of superclasses will be run before
	 * those of the current class, unless they are overridden in the current
	 * class. No other ordering is defined.
	 * <p>
	 * Here is a simple example:
	 * 
	 * <pre>
	 * public class Example {
	 *    List empty;
	 *    &#064;Before public void initialize() {
	 *       empty= new ArrayList();
	 *    }
	 *    &#064;Test public void size() {
	 *       ...
	 *    }
	 *    &#064;Test public void remove() {
	 *       ...
	 *    }
	 * }
	 * </pre>
	 */
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}
}
