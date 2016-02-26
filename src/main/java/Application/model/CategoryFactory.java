package Application.model;

import javafx.geometry.Pos;

import java.util.ArrayList;

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

        public ArrayList<AcademicDegree> convert(ArrayList<BaseCategoryEntity> entities) {
            ArrayList<AcademicDegree> values = new ArrayList<>();
            for (BaseCategoryEntity entity : entities) {
                values.add(toAcademicDegree(entity));
            }
            return values;
        }

        private AcademicDegree toAcademicDegree(BaseCategoryEntity entity) {
            AcademicDegree academicDegree = new AcademicDegree(entity.getTableName());
            academicDegree.setName(entity.getName());
            academicDegree.setID(entity.getID());
            return academicDegree;
        }
    }

    public class Module extends BaseCategoryEntity {
        private Module(String tableName) {
            super(tableName);
        }

        public ArrayList<Module> convert(ArrayList<BaseCategoryEntity> entities) {
            ArrayList<Module> values = new ArrayList<>();
            for (BaseCategoryEntity entity : entities) {
                values.add(toModule(entity));
            }
            return values;
        }

        private Module toModule(BaseCategoryEntity entity) {
            Module module = new Module(entity.getTableName());
            module.setName(entity.getName());
            module.setID(entity.getID());
            return module;

        }
    }

    public class Subdivision extends BaseCategoryEntity {
        private Subdivision(String tableName) {
            super(tableName);
        }

        public ArrayList<Subdivision> convert(ArrayList<BaseCategoryEntity> entities) {
            ArrayList<Subdivision> values = new ArrayList<>();
            for (BaseCategoryEntity entity : entities) {
                values.add(toSubdivision(entity));
            }
            return values;
        }

        private Subdivision toSubdivision(BaseCategoryEntity entity) {
            Subdivision subdivision = new Subdivision(entity.getTableName());
            subdivision.setName(entity.getName());
            subdivision.setID(entity.getID());
            return subdivision;
        }
    }

    public class Position extends BaseCategoryEntity {
        private Position(String tableName) {
            super(tableName);
        }

        public ArrayList<Position> convert(ArrayList<BaseCategoryEntity> entities) {
            ArrayList<Position> values = new ArrayList<>();
            for (BaseCategoryEntity entity : entities) {
                values.add(toPosition(entity));
            }
            return values;
        }

        private Position toPosition(BaseCategoryEntity entity) {
            Position position = new Position(entity.getTableName());
            position.setName(entity.getName());
            position.setID(entity.getID());
            return position;
        }
    }

    public class AcademicRank extends BaseCategoryEntity {
        private AcademicRank(String tableName) {
            super(tableName);
        }

        public ArrayList<AcademicRank> convert(ArrayList<BaseCategoryEntity> entities) {
            ArrayList<AcademicRank> values = new ArrayList<>();
            for (BaseCategoryEntity entity : entities) {
                values.add(toAcademicRank(entity));
            }
            return values;
        }

        private AcademicRank toAcademicRank(BaseCategoryEntity entity) {
            AcademicRank academicRank = new AcademicRank(entity.getTableName());
            academicRank.setName(entity.getName());
            academicRank.setID(entity.getID());
            return academicRank;
        }

    }

    public class ContractStatus extends BaseCategoryEntity {
        private ContractStatus(String tableName) {
            super(tableName);
        }

        public ArrayList<ContractStatus> convert(ArrayList<BaseCategoryEntity> entities) {
            ArrayList<ContractStatus> values = new ArrayList<>();
            for (BaseCategoryEntity entity : entities) {
                values.add(toContractStatus(entity));
            }
            return values;
        }

        private ContractStatus toContractStatus(BaseCategoryEntity entity) {
            ContractStatus contractStatus = new ContractStatus(entity.getTableName());
            contractStatus.setName(entity.getName());
            contractStatus.setID(entity.getID());
            return contractStatus;
        }

    }
}
