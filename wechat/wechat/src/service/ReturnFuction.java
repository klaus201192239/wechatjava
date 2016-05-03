package service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class ReturnFuction {
	ReturnFuction(){}
	public static String a(){
		return "fsd";
	}
	public String byteToStr(byte[] byteArray) {  
		String strDigest = "";  
	    for (int i = 0; i < byteArray.length; i++) {  
		 	 strDigest += byteToHexStr(byteArray[i]);  
		 }  
		 return strDigest;  
     }  
	 public String byteToHexStr(byte mByte) {  
		 char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
		 char[] tempArr = new char[2];  
		 tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
		 tempArr[1] = Digit[mByte & 0X0F]; 
		 String s = new String(tempArr);  
		 return s;  
	 }
	 public boolean CompareStr(String str){
		 char a,b,c,d,e,f;
		 int x,y,z,m,n,sum=0;
		 a=str.charAt(0);
		 if(!(a=='a'||a=='b'||a=='c')){
			 return false;
		 }
		 b=str.charAt(1);
		 m=b-'0';
		 if(!(m==1||m==2||m==3||m==5)){
			 return false;
		 }
		 c=str.charAt(2);d=str.charAt(3);e=str.charAt(4);
		 x=c-'0';y=d-'0';z=e-'0';
		 sum=y*10+z;
		 if(!((x>=1&&x<=7)&&(sum>=1&&sum<=21))){
			 return false;
		 }
		 f=str.charAt(5);
		 n=f-'0';
		 if(!(n>0&&n<5)){
			 return false;
		 }
		 return true;
	 }
	 public static String getBackError(String toName, String FromName,String respContent){
		  String returnStr = "";
		  StringBuffer buffer = new StringBuffer(); 
		  buffer.append(respContent);
		  SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		  String times = format.format(new Date());
		  Element rootXML = new Element("xml");
		  rootXML.addContent(new Element("ToUserName").setText(FromName));
		  rootXML.addContent(new Element("FromUserName").setText(toName));
		  rootXML.addContent(new Element("CreateTime").setText(times));
		  rootXML.addContent(new Element("MsgType").setText("text"));
		  rootXML.addContent(new Element("Content").setText(buffer.toString()));
		  Document doc = new Document(rootXML); 
		  XMLOutputter XMLOut = new XMLOutputter();  
		  returnStr = XMLOut.outputString(doc);
		  return returnStr;
		 }
}