import java.util.ArrayList;

public class Course {
	private ArrayList<Student> studentList;
	private double size;


	//Constructs object Course 
	public Course(){
		studentList=new ArrayList<Student>();
		size=0;
	}

	//add object Student to the studentList
	public Student addStudent(String name, String lastName){
		studentList.add(new Student(name,lastName));
		size++;
		return studentList.get((int)size-1);
	}

	//Find a Student and returns it
	public Student findStudent(long studentId){
		for(Student s : studentList){
			if(s.getStudentNumber()==studentId){
				return s;
			}
		}
		return null;
	}

	//remove specified student from the studentList and retrns it.
	public Student deleteStudent(long studentId){
		for(Student s : studentList){
			if(s.getStudentNumber()==studentId){
				studentList.remove(s);
				return s;
			}
		}
		return null;
	}

	//add quiz to the specified student object
	public boolean addQuiz(long studentId, double scale, double grade){
		for(Student s : studentList){
			if(s.getStudentNumber()==studentId){
				s.addQuiz(scale,grade);
				return true;
			}
		}
		return false;
	}

	//Find a student with highest average and return it
	public Student findTopStudent(){
		double topScore=0;
		for(Student s : studentList){
			if(s.getQuizAverage()>topScore){
				topScore=s.getQuizAverage();
			}
		}
		for(Student s : studentList){
			if(s.getQuizAverage()==topScore){
				return s;
			}
		}
		return null;
	}

	//returns the class average
	public double getAverage(){
		double avgSum=0;
		for(Student s : studentList){
			avgSum+=s.getQuizAverage();
		}
		return avgSum/this.size;
	}
	

	

}