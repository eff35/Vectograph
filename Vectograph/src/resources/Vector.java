package resources;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Vector {
	public static ObservableList<Vector> all =FXCollections.observableArrayList();
	public double[] v=new double[3];
	public double xAngle,yAngle, zAngle;
	String name ="";
	Vector (double x, double y, double z){
			this.v[0] = x;
			this.v[1] = y;
			this.v[2] = z;
			
	}
	public double value=0;
	
	
	public Vector (String name,double x, double y, double z){
		this.name=name;
		this.v[0] = x;
		this.v[1] = y;
		this.v[2] = z;
		
		this.value= Math.sqrt(x*x+y*y+z*z);
		
		calculateAngles(x,y,z);
		
		System.out.println(xAngle + " "+ yAngle + " " + zAngle);
		
		ui.whiteBoard.WhiteBoard.addVector(this);
		
		all.add(this);
}
	void calculateAngles(double x,double y,double z) {
		if(y==0&z==0) {
			this.xAngle = 0;
		} else {
		this.xAngle = (180/Math.PI)*Math.acos((y/Math.sqrt((Math.pow(z, 2)+Math.pow(y, 2)))));
		}
		if(z==0&x==0) {
			this.yAngle = 0;
		} else {
		this.yAngle = (180/Math.PI)*Math.acos((z/Math.sqrt((Math.pow(x, 2)+Math.pow(z, 2)))));
		}
		if(y==0&x==0) {
			this.zAngle = 0;
		} else {
		this.zAngle = (180/Math.PI)*Math.acos((y/Math.sqrt((Math.pow(x, 2)+Math.pow(y, 2)))));
		}
	}
	
	Vector(){
		for (int i =0;i<3;i++) {
			this.v[i]=0;
			
		}
	}
	void calculateValue() {
		double tempVal = 0;
		for (int i = 0; i<3;i++) {
			tempVal += Math.pow(this.v[i], 2);
		}
		value = Math.sqrt(tempVal);
	}
	@Override
	public String toString() {
		String returnString = "Vector "+this.name+": [";
		for (int i = 0; i<3;i++) {
			if (this.v[i] % 1 == 0) returnString += (int) this.v[i];			
			else if(this.v[i] % 1 != 0) returnString += this.v[i];
			if(i<2) returnString += ", ";
			else returnString += "]";
		}
		return returnString;
		
		
	}
	
	public static double dotp (Vector v1, Vector v2){
		double res = 0.0;
		for (int i = 0; i<3; i++) {
			res += v1.v[i]*v2.v[i];
		}
		return res;
	}
	public static Vector crossp(Vector v1, Vector v2) {
		double resx = v1.v[1]*v2.v[2]-v1.v[2]*v2.v[1];
		double resy = v1.v[2]*v2.v[0]-v1.v[0]*v2.v[2];
		double resz = v1.v[0]*v2.v[1]-v1.v[1]*v2.v[0];
		
		Vector res = new Vector(resx, resy, resz);
		return res;
	}
	public static Vector scale (Vector v, double a) {
		for (int i = 0; i<3;i++) {
			v.v[i]*=a;
		}
		return v;
	}
	public static Vector add (Vector v1, Vector v2) {
		Vector res =new Vector();
		for (int i = 0; i<3;i++) {
			res.v[i]=v1.v[i]+v2.v[i];
		}
		return res;
	}
}
