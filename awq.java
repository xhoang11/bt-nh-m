package baitap;

import java.util.*;
import java.io.IOException;
interface IELECTRONIC_DEVICE{
	double sum_total();
}
abstract class TV implements IELECTRONIC_DEVICE{
	public static boolean idTV;
	String tvID, mainfacturer, entryDate;
	double price, num;
    String brand;
    int size;

    public TV(String tvID, String brand, int size) {
        this.tvID = tvID;
        this.brand = brand;
        this.size = size;}
	public String getTvID() {
		return tvID;
	}
	public void setTvID() {
		this.tvID = tvID;
	}
	public String getMainfacturer() {
		return mainfacturer;
	}
	public void setMainfacturer() {
		this.mainfacturer = mainfacturer;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double prive) {
		this.price = price;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	public TV() {
		this.entryDate = "";
		this.mainfacturer = "";
		this.num = 0;
		this.tvID = "";
		this.price = 0;
	}
	public TV(String tvID, String mainfacturer, String entryDate, double price, double num) {
		super();
		this.tvID = tvID;
		this.mainfacturer = mainfacturer;
		this.entryDate = entryDate;
		this.price = price;
		this.num = num;
	}
	void intput() {
		Scanner objSc = new Scanner(System.in);
		System.out.print("tvID: "+this.tvID);
		tvID = objSc.nextLine();
		System.out.print("Nha san xuat: "+this.mainfacturer);
		mainfacturer = objSc.nextLine();
		System.out.print("Ngay Nhap: "+this.entryDate);
		entryDate = objSc.nextLine();
		System.out.print("Don gia: "+this.price);
		price = objSc.nextDouble();
		System.out.print("So luong: "+this.num);
		num = objSc.nextDouble();
	}
	void output() {
		System.out.println("TvID: "+this.getTvID()+"Nha san xuat: "+this.getMainfacturer()+"Ngay nhap: "+this.getEntryDate()+"Don gia:"+this.getPrice()+"So luong: "+this.getNum());		
	}
public abstract double sum_total();
public abstract double discount();
}
class TV_SAMSUNG extends TV{
	String state;
	public String getState() {
		return state;
	}
	public void setState() {
		this.state = state;
	}
	public TV_SAMSUNG(String tvID, String manidacturer, String entryDate, double price, double num, String state) {
		super(tvID,manidacturer,entryDate,price,num);
	}
	public TV_SAMSUNG() {
		// TODO Auto-generated constructor stub
	}
	void input() {
		super.intput();
		Scanner objSc = new Scanner(System.in);
		System.out.print("state: ");
		this.setState();
	}
	void output() {
		super.output();
		System.out.print("State: "+this.getState());
	}
	public double sum_total() {
		double total = 0;
		total = this.getNum()*this.getPrice()-this.discount();
		return total;
	}
	public double discount() {
		double dis = 0;
		if(this.getState().equals("new")) {
			dis = this.getNum() * this.getPrice() * 0.1;
		}else {
			dis = this.getNum() * this.getPrice() * 0.6;
		}
		return dis;
	}
}
class TV_SONY extends TV{
	double surcharge;
	public double getSurcharge() {
		return surcharge;
	}
	public void setSurcharge() {
		this.surcharge = surcharge;
	}
	public TV_SONY(String tvID, String mainfacturer, String entryDate, double price, double num, double surcharge) {
		super();
	}
	public TV_SONY() {
		// TODO Auto-generated constructor stub
	}
	void input() {
		super.intput();
		Scanner objSc = new Scanner(System.in);
		System.out.print("Phu phi: ");
		this.setSurcharge();
	}
	void output() {
		super.output();
		System.out.println("Surcharge: "+this.getSurcharge());
	}
	public double sum_total() {
		return 0;
	}
	public double discount() {
		double dis = 0;
		dis = this.getNum() * this.getPrice() * 0.05;
		return dis;
	}
}
class LISTTV extends TV{
	void inputList() {
		super.intput();
	}

	@Override
	public double sum_total() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double discount() {
		// TODO Auto-generated method stub
		return 0;
	}
	void outputList() {
		super.output();
	}
}
class TVLIST{
	ArrayList<TV> list = new ArrayList<TV>();
	int n = 0;
	char chon, loai;
	void input() throws IOException{
		TV[] tv = new TV[100];
		do {
			System.out.println("Sumsung(S) hay Sony (N) (S/N)");
			loai = (char) System.in.read();
			if(loai == 'S'||loai =='s') {
				tv[n] = new TV_SAMSUNG();
			}else {
				tv[n] = new TV_SONY();
			}
			list.add(tv[n]);
			System.in.skip(loai);
			tv[n++].intput();
			System.out.println("Tiep tuc (C/K)");
			chon = (char) System.in.read();
			System.in.skip(chon);
			if((n==100)||(chon =='K')||(chon =='k')) {
				break;
			}
		}while(true);
	}
	void output() {
		for(int i = 0; i < list.size(); i++ ) {
			list.get(i).output();
		}
	}
	void findTV(String tvID) {
		int k = 0;
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getTvID().contains(tvID)) {
				k=i;
				System.out.println("Yes !");
				break;
			}else {
				System.out.println("no ");
			}
		}
	}
	void delete(String tvID) {
		for(int i = 0 ; i<list.size(); i++) {
			if(list.get(i).getTvID().contains(tvID)) {
				list.remove(i);
			}
		}
	}
	void update(String tvID) {
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getTvID().contains(tvID)) {
				list.get(i).setMainfacturer();
				list.set(i, list.get(i));
			}
		}
	}
}
public class awq {

	public static void main(String[] args) throws IOException {
		TVLIST list = new TVLIST();
		list.input();
		list.output();
		list.delete("1");
		list.findTV("2");
		list.update("3");
	}

}