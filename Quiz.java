public class Quiz{
    private double scale;
    private double studentGrade;


    //Create a object quiz
    public Quiz(double scale ,double studentGrade){
        this.scale=scale;
        this.studentGrade=studentGrade;
    }

    //returns the scale 
    public double getScale(){
        return scale;
    }

    //returns the studentGrade
    public double getStudentGrade(){
        return studentGrade;
    }
}