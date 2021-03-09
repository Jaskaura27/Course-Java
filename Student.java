import java.util.ArrayList;

public class Student
{
	private String firstname;
	private String surname;
	private long studentNum;
	private String loginID;
	
	private static long StudentCount=10000000;

	private ArrayList<Quiz> quiz;

	//Constructs Object Student with no parameters
	public Student(){
		firstname=surname=loginID="";
		studentNum=++StudentCount;
		quiz=new ArrayList<Quiz>();
	}

	//Constructs Object student 
	public Student(String firstName,String surName){
		firstname=firstName;
		surname=surName;
		studentNum=++StudentCount;
		loginID=createLogID();
		quiz=new ArrayList<Quiz>();
	}


	//Create a loginID
	private String createLogID(){
		String LogId;
		String Stnum=studentNum+"";
		LogId=firstname.substring(0,1);
		if(surname.length()>4){
			LogId+=surname.substring(0,4);
		}
		else {LogId+=surname;}
		LogId+=Stnum.substring(Stnum.length()-2,Stnum.length());
		LogId=LogId.toLowerCase();
		return LogId;
	}


	/*set Student firstname  surname and studentNum. changing student number does not
	affect loginID
	*/ 
	public void setName(String firstName,String surName){
		firstname=firstName;
		surname=surName;
		if(loginID==""){
			loginID=createLogID();
		}
	}

	//returns student firstname and surname
	public String getName(){
		String fullName=firstname+","+surname;
		return fullName;
	}

	//returns studentNum
	public long getStudentNumber(){
		return studentNum;
	}

	//returns loginID
	public String getLoginId(){
		return loginID;
	}

	/*
	returns student info including firstname, surname, loginID, and studentNum
	*/
	public String getInfo(){
		return firstname+","+surname+"("+loginID+","+studentNum+")";
	}

	
	//add a quiz score to the student
	public void addQuiz(double scale,double grade){
		quiz.add(new Quiz(scale,grade));
	}
	

	//returns the quiz average
	public double getQuizAverage(){
		double totalScale=0;
		double totalGrade=0;
		for(Quiz q :quiz){
			totalGrade+=q.getStudentGrade();
			totalScale+=q.getScale();
		}
		return (totalGrade/totalScale)*100.00;
	}


	@Override
	//override toString() method
	public String toString(){
		return "["+firstname+","+surname+","+studentNum+","+loginID+"]";
	}




}