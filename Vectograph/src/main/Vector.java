package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Vector {
	static ObservableList<Vector> all =FXCollections.observableArrayList();
	public double[] v=new double[3];
	String name ="";
	Vector (double x, double y, double z){
			this.v[0] = x;
			this.v[1] = y;
			this.v[2] = z;
			
	}
	
	Vector (String name,double x, double y, double z){
		this.name=name;
		this.v[0] = x;
		this.v[1] = y;
		this.v[2] = z;
		all.add(this);
}
	
	Vector(){
		for (int i =0;i<3;i++) {
			this.v[i]=0;
			
		}
	}
	@Override
	public String toString() {
		return "Vector "+name+": ["+this.v[0]+","+this.v[1]+","+this.v[2]+"]";
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
