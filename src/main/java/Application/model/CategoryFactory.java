package Application.model;

/**
 * Created by Rushan on 12.02.2016.
 */
public class CategoryFactory {
    public AcademicDegree academicDegreeCreate() {
        return new AcademicDegree("academic_degree");
    }
    public Module moduleCreate() {
        return new Module("module");
    }
    public Subdivision subdivisionCreate() {
        return new Subdivision("subdivision");
    }
    public Position positionCreate() {
        return new Position("position");
    }
    public AcademicRank academicRankCreate() {
        return new AcademicRank("academic_rank");
    }
    public ContractStatus contractStatusCreate() {
        return new ContractStatus("contract_status");
    }

    public class AcademicDegree extends BaseCategoryEntity {
        private AcademicDegree(String tableName) {
            super(tableName);
        }
    }
    public class Module extends BaseCategoryEntity {
        private Module(String tableName) {
            super(tableName);
        }
    }
    public class Subdivision extends BaseCategoryEntity {
        private Subdivision(String tableName) {
            super(tableName);
        }
    }
    public class Position extends BaseCategoryEntity {
        private Position(String tableName) {
            super(tableName);
        }
    }
    public class AcademicRank extends BaseCategoryEntity {
        private AcademicRank(String tableName) {
            super(tableName);
        }
    }
    public class ContractStatus extends BaseCategoryEntity {
        private ContractStatus(String tableName) {
            super(tableName);
        }
    }
}
