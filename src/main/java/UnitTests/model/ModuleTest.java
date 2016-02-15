package UnitTests.model;

import Application.model.CategoryFactory;
import org.json.simple.JSONObject;
import org.junit.Test;

/**
 * Created by Rushan on 12.02.2016.
 */
public class ModuleTest {

    @Test
    public void testToJSON1() throws Exception {
        CategoryFactory factory = new CategoryFactory();
        CategoryFactory.ContractStatus contractStatus = factory.contractStatusCreate();
        CategoryFactory.AcademicDegree academicDegree = factory.academicDegreeCreate();
        CategoryFactory.AcademicRank academicRank = factory.academicRankCreate();
        CategoryFactory.Module module = factory.moduleCreate();
        CategoryFactory.Position position = factory.positionCreate();
        CategoryFactory.Subdivision subdivision = factory.subdivisionCreate();

        contractStatus.setID(10);
        contractStatus.setName("contractStatus");
        System.out.println(contractStatus.toJSON().toJSONString());

        academicDegree.setID(10);
        academicDegree.setName("academicDegree");
        System.out.println(academicDegree.toJSON().toJSONString());

        academicRank.setID(10);
        academicRank.setName("academicRank");
        System.out.println(academicRank.toJSON().toJSONString());

        module.setID(10);
        module.setName("module");
        System.out.println(module.toJSON().toJSONString());

        position.setID(10);
        position.setName("position");
        System.out.println(position.toJSON().toJSONString());

        subdivision.setID(10);
        subdivision.setName("subdivision");
        System.out.println(subdivision.toJSON().toJSONString());

    }

    @Test
    public void testToJSON2() throws Exception {
        CategoryFactory factory = new CategoryFactory();
        CategoryFactory.ContractStatus contractStatus = factory.contractStatusCreate();
        CategoryFactory.AcademicDegree academicDegree = factory.academicDegreeCreate();
        CategoryFactory.AcademicRank academicRank = factory.academicRankCreate();
        CategoryFactory.Module module = factory.moduleCreate();
        CategoryFactory.Position position = factory.positionCreate();
        CategoryFactory.Subdivision subdivision = factory.subdivisionCreate();

//        contractStatus.setID(10);
        contractStatus.setName("contractStatus");
        System.out.println(contractStatus.toJSON().toJSONString());

//        academicDegree.setID(10);
        academicDegree.setName("academicDegree");
        System.out.println(academicDegree.toJSON().toJSONString());

//        academicRank.setID(10);
        academicRank.setName("academicRank");
        System.out.println(academicRank.toJSON().toJSONString());

//        module.setID(10);
        module.setName("module");
        System.out.println(module.toJSON().toJSONString());

//        position.setID(10);
        position.setName("position");
        System.out.println(position.toJSON().toJSONString());

//        subdivision.setID(10);
        subdivision.setName("subdivision");
        System.out.println(subdivision.toJSON().toJSONString());

    }

    @Test
    public void testFromJSON1() throws Exception {
    }

    @Test
    public void testFromJSON2() throws Exception {
    }

    @Test
    public void testToInsertQuery() throws Exception {
        CategoryFactory factory = new CategoryFactory();
        CategoryFactory.ContractStatus contractStatus = factory.contractStatusCreate();
        CategoryFactory.AcademicDegree academicDegree = factory.academicDegreeCreate();
        CategoryFactory.AcademicRank academicRank = factory.academicRankCreate();
        CategoryFactory.Module module = factory.moduleCreate();
        CategoryFactory.Position position = factory.positionCreate();
        CategoryFactory.Subdivision subdivision = factory.subdivisionCreate();

        contractStatus.setID(10);
        contractStatus.setName("contractStatus");
        System.out.println(contractStatus.toInsertQuery());

        academicDegree.setID(10);
        academicDegree.setName("academicDegree");
        System.out.println(academicDegree.toInsertQuery());

        academicRank.setID(10);
        academicRank.setName("academicRank");
        System.out.println(academicRank.toInsertQuery());

        module.setID(10);
        module.setName("module");
        System.out.println(module.toInsertQuery());

        position.setID(10);
        position.setName("position");
        System.out.println(position.toInsertQuery());

        subdivision.setID(10);
        subdivision.setName("subdivision");
        System.out.println(subdivision.toInsertQuery());

    }
}