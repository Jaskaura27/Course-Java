import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class CourseTesterRedirect {
    public static void main(String[] args) {
        ArrayList<String[]> list = new ArrayList<String[]>();
        ArrayList<String> outPut= new ArrayList<String>();
        try{//Read file "input.txt" into an ArrayList of Arrays of Strings
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()){
                String[] s=(scanner.nextLine()).split(" ");
                list.add(s);
            }
            scanner.close();
        } catch(IOException ex){
            System.out.println("Could not found input File");
        }



        Course c1=new Course();
        String choiceStr="Please Choose One of The following:\n"+
            "1: Add new Student\n"+
            "2: Find Student\n"+
            "3: Delete Student\n"+
            "4: Add Quiz\n"+
            "5: Find Top Student\n"+
            "6: Find Student Average\n"+
            "7: Exit";
        int listCurrentRow=0;
        while(listCurrentRow<list.size()){
            int choice =0;
            outPut.add(choiceStr);
            choice=Integer.parseInt(list.get(listCurrentRow)[1]);
            outPut.add(Integer.toString(choice));
            if(choice ==1){
                outPut.add("Please entre First name of the Student:");
                String name=list.get(listCurrentRow)[2];
                outPut.add(name);
                outPut.add("Please entre Family name of the Student:");
                String familyName=list.get(listCurrentRow)[3];
                outPut.add(familyName);
                Student s= c1.addStudent(name, familyName);
                outPut.add(s.toString());
            }
            else if(choice==2){
                outPut.add("Please entre Student Number of the Student");
                long stuNum=Long.parseLong(list.get(listCurrentRow)[2]);
                outPut.add(Long.toString(stuNum));
                Student s=c1.findStudent(stuNum);
                if(s==null){
                    outPut.add("Student does not exist");
                }
                else{
                    outPut.add(s.toString());
                }
            }
            else if(choice==3){
                long stuNum;
                outPut.add("Please entre Student Number of the Student");
                stuNum=Long.parseLong(list.get(listCurrentRow)[2]);
                outPut.add(Long.toString(stuNum));
                Student s=c1.deleteStudent(stuNum);
                if(s==null){
                    outPut.add("Student does not exigetName()st");
                }
                else{
                    outPut.add("Student "+s.toString()+" has been deleted from the class");
                }
            }
            else if (choice==4){
                long stuNum;
                double score ,scale;
                outPut.add("Please Entre the student Number:");
                stuNum=Long.parseLong(list.get(listCurrentRow)[2]);
                outPut.add(Long.toString(stuNum));
                outPut.add("Entre the student score:");
                score=Long.parseLong(list.get(listCurrentRow)[3]);
                outPut.add(Double.toString(score));
                outPut.add("Entre the scale of the quiz:");
                scale=Long.parseLong(list.get(listCurrentRow)[4]);
                outPut.add(Double.toString(scale));
                boolean tf=c1.addQuiz(stuNum, scale, score);
                if(tf){
                    outPut.add("Quiz score has been submited successful");
                }
                else{
                    outPut.add("Quiz score has not been submited successful");
                }

            }
            else if(choice==5){
                Student s=c1.findTopStudent();
                outPut.add(s.toString()+" is the top student");
            }
            else if(choice==6){
                double avg=c1.getAverage();
                outPut.add("class average is:"+avg);
            }
            else{
                outPut.add("Exiting");
                break;
                
            }
            outPut.add("");
            outPut.add("");
            listCurrentRow++;
        }
        try{
            FileWriter writer=new FileWriter("output.txt");
            for(String str: outPut){
                writer.write(str+System.lineSeparator());
            }
            writer.close();
        } catch (IOException ex){
            System.out.println("Output File does not exist");
        }
    }
    
}