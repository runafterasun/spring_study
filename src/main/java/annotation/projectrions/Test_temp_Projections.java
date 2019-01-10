package annotation.projectrions;

import org.springframework.data.rest.core.config.Projection;

import annotation.entity.Table_temp;

@Projection(name = "tabletest", types = {Table_temp.class})
public interface Test_temp_Projections {
	
	Integer getPhone();
	String getRate();
	String getRate_two();

}
 