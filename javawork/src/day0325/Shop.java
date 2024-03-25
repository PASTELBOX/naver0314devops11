package day0325;

public class Shop {
	private String sang;
	private int su;
	private int dan;
	private int money;
	
	public Shop()
	{
		this("이름없음",0,0);
	}
	
	public Shop(String sang)
	{
		this(sang,0,0);
	}
	public Shop(int su,int dan)
	{
		this("이름 없음",su,dan);
	}
	public Shop(String sang, int su, int dan) {
		// TODO Auto-generated constructor stub
		this.sang=sang;
		this.su=su;
		this.dan=dan;
	}

	public void setSang(String sang)
	{
		this.sang=sang;
	}
	
	public void setSu(int su)
	{
		this.su=su;
	}
	
	public void setDan(int dan)
	{
		this.dan=dan;
	}
	
	public void setMoney(int money)
	{
		this.money=su*dan;
	}
	
	public void setSangpum(String sang,int su,int dan)
	{
//		this.sang=sang;
//		this.su=su;
//		this.dan=dan;
		setSang(sang);
		setSu(su);
		setDan(dan);
	}
	
	public String getSang()
	{
		return sang;
	}
	
	public int getSu()
	{
		return su;
	}
	
	public int getDan()
	{
		return dan;
	}
	
	public int getMoney()
	{
		return dan*su;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
