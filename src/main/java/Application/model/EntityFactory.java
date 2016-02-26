package Application.model;

import Application.utils.AbstractEntity;
import Application.utils.TableNames;

/**
 * Created by Rushan on 24.02.2016.
 */
public class EntityFactory {

    public static AbstractEntity createEntity(String tableName) throws Exception{
        AbstractEntity entity;
        switch (tableName){
            case TableNames.ACADEMIC_DEGREE:
                entity = new CategoryFactory().academicDegreeCreate();
                break;
            case TableNames.ACADEMIC_RANK:
                entity = new CategoryFactory().academicRankCreate();
                break;
            case TableNames.CONTRACT:
                entity = new Contract();
                break;
            case TableNames.CONTRACT_STATUS:
                entity = new CategoryFactory().contractStatusCreate();
                break;
            case TableNames.GRADUATE:
                entity = new Graduate();
                break;
            case TableNames.LISTENER:
                entity = new Listener();
                break;
            case TableNames.MODULE:
                entity = new CategoryFactory().moduleCreate();
                break;
            case TableNames.POSITION:
                entity = new CategoryFactory().positionCreate();
                break;
            case TableNames.SUBDIVISION:
                entity = new CategoryFactory().subdivisionCreate();
                break;
            case TableNames.TRAINING_PLAN:
                entity = new TrainingProgram();
                break;
            default:
                throw new Exception();
        }
        return entity;
    }
}
