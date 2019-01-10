package annotation.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import annotation.entity.Table_temp;
import annotation.projectrions.Test_temp_Projections;

@RepositoryRestResource(path="api", excerptProjection = Test_temp_Projections.class)
public interface TableTempRepository extends CrudRepository<Table_temp, String>, Test_tableNewFunction {
	
}
