package com.apress.jooq;

import com.apress.jooq.generated.tables.records.CompleteCarListingRecord;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.ParserException;
import org.jooq.tools.jdbc.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import static com.apress.jooq.executable.JooqSelect.selectWithOptionalCondition;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class JooqUnitTests {

	static MockedStatic mockedDriver;

	final Logger logger = LoggerFactory.getLogger(JooqUnitTests.class);

	@BeforeAll
	public static void prepare(){
		 mockedDriver = mockStatic(DriverManager.class);
	}

	@ParameterizedTest
	@CsvSource({
			"BLUE,2020",
			"SILVER,2020"
	})
	void test_dynamic_condition_api(String color,String year) throws SQLException {
		MockDataProvider mockJooqProvider = ctx -> {
			MockResult[] results = new MockResult[1];
			String sql = ctx.sql();
			logger.info(()->"Binding 1: "+ctx.bindings()[0]);
			assertAll(()->{
				assertTrue(ctx.bindings().length == 2 ); //two parameters are bound;
				assertEquals(ctx.bindings()[0],color);
				assertEquals(ctx.bindings()[1],year);
			});
			CompleteCarListingRecord completeCarListing = new CompleteCarListingRecord();
			results[0] = new MockResult(completeCarListing);
			return new MockResult[0];
		};
		MockConnection mockConnection = new MockConnection(mockJooqProvider);
		mockedDriver.when(()-> DriverManager.getConnection(anyString())).thenReturn(mockConnection);
		selectWithOptionalCondition(true,Map.of("color",color,"year",year));
	}

	@Test
	void validate_my_dodgy_sql(){
		assertThrows(ParserException.class, ()->
				DSL.using(SQLDialect.MYSQL)
						.parser()
						.parse("selecet * from table group by 1 where having max (column) > 10"));
	}


}
