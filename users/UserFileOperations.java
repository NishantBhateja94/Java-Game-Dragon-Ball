package users;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserFileOperations {

	public static String objectRead(UserDTO userDTO) throws IOException, ClassNotFoundException{
		String message = "Invalid Userid or Password";
		String path ="D:\\FileOutput";
		FileInputStream fs = new FileInputStream(path);
//deserializabilty karta hai
		ObjectInputStream os = new ObjectInputStream(fs);
      try{
    	  UserDTO userObject = (UserDTO)os.readObject();
    	  if(userObject.getUserid().equals(userDTO.getUserid()) && userObject.getPassword().equals(userDTO.getPassword())){
    		  message = "Welcome" + userDTO.getUserid();
    	  }
    	  return message;
    	  
      }
     finally {
		if(os!=null){
			os.close();
		}
		if(fs!=null){
			fs.close();
		}
	} 
	
	}
	public static String objectWrite(UserDTO userDTO) throws IOException{
	String result = "Register Successfully";
	String path ="D:\\FileOutput";
	FileOutputStream fs = new FileOutputStream(path);
     ObjectOutputStream os = new ObjectOutputStream(fs);
     try{
    	 os.writeObject(userDTO);
     }
     finally{
    	 if(os!=null){
    		 os.close();
    	 }
     }
     return result;
	
	}
	
	static void writeFile(){
	FileOutputStream fs=null;
	String path="D:\\FileOutput";
	File file = new File(path);
	FileOutputStream fs1 = null;
	String data = "hello nishant";
	try{
		if(!file.exists()){
	if(file.createNewFile()){
		System.out.println("File Created");
	}}
		else{
			System.out.println("File exist");
		}
		 fs1 = new FileOutputStream(file);
		fs1.write(data.getBytes());
		System.out.println("data closed");
}
catch(IOException e) {
	System.out.println("problem in file creation");
}
	finally{
		System.out.println("Finally Call Always");
		try{
			if(fs1!=null){
		fs1.close();
		
			}}
	catch(Exception e){
		e.printStackTrace();
	}
	}
}
static void readFile(){
	
	FileInputStream fs = null;
	final int EOF = -1;
	
	String path = "D:\\FileOutput";
		File file = new File(path);
		if(file.exists()){
			try{
				fs = new FileInputStream(file);
		            int singleByte = fs.read();
		            while(singleByte!=EOF){
		            	System.out.println((char)singleByte);
		            	singleByte = fs.read();
		            }
			}
			catch(IOException e){
				e.printStackTrace();
			}
		finally{
			if(fs!=null){
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
}
	public static void main(String[] args) {
		System.out.println("DB Connection open");
System.out.println("doing query fromdb");
try{
	int xx = 10/0;//throw new ArithmeticException()
}
catch(ArithmeticException e){ //Handling
	System.out.println("u DIvide with zero");
}

System.out.println("result");
System.out.println("process the query rersult");
System.out.println("close db connection");
	}

}
