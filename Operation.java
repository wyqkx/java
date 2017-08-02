/*
 * @作者：王翼
 * @功能：实现控制台上的四则运算和计算圆的面积
 * @局限：只能做到两个数的加减乘除
 * @日期：2017.8.2
 */
package forth;
import java.util.Scanner;
public class Operation {
	public static void main(String[] args) {
		while(true)
		{
			Window window =new Window();
			window.welcome();                        //创建主界面
			Scanner scan=new Scanner(System.in);     
			boolean flag_select=true;
			while(flag_select)         
			{			
				int select=scan.nextInt();		
				switch (select) 
				{
					case 1:
						System.out.print("输入四则运算算式：");
						boolean flag1=true;
						while(flag1)
						{						
							String formula =scan.next();
							String[] a_symbol_b=formula.split("\\+|\\-|\\*|\\/");
							double a=Double.parseDouble(a_symbol_b[0]);
							String symbol="";
							double b=Double.parseDouble(a_symbol_b[1]);
							boolean add=formula.contains("+");
							boolean minux=formula.contains("-");
							boolean mul=formula.contains("*");
							boolean divided=formula.contains("/");
							if(add)
								symbol="+";
							if(minux)
								symbol="-";
							if(mul)
								symbol="*";
							if(divided)
								symbol="/";														
							fouroper oper =new fouroper(a, b);
							oper.GetResult(symbol);										
							System.out.print("是否继续四则运算[y/n]：");
							String yn=scan.next();
							char y_n=yn.charAt(0);						
							System.out.println("............................");
							if(y_n=='y')
							{
								flag1=true;
								System.out.print("输入四则运算算式：");
							}
							else if(y_n=='n')
							{
								flag1=false;
							}
							else 
							{
								System.out.print("是否继续四则运算[y/n]：");
							}					
						}			  //四则运算循环	
						flag_select=false;
						break;
					case 2:
						System.out.print("输入圆的半径：");
						boolean flag2=true;
						while(flag2)
						{
							double r=scan.nextDouble();
							operation oper =new area(r);
							oper.GetResult();
							System.out.print("是否继续圆的面积运算[y/n]：");
							String yn=scan.next();
							char y_n=yn.charAt(0);							
							System.out.println("............................");
							if(y_n=='y')
							{
								flag2=true;
								System.out.print("输入圆的半径：");
							}
							else if(y_n=='n')
							{
								flag2=false;
							}
							else 
							{
								System.out.print("是否继续圆的面积运算[y/n]：");
							}					
						}			  //圆的面积运算循环	
						flag_select=false;
						break;
					default:
						System.out.println("Error:错误的序号！");
						System.out.print("请选择运算序号：");
						flag_select=true;
						break;
				}
			}		
		}
	}
}
class Window
{
	public void welcome() 
	{
		System.out.println("1.四则运算");
		System.out.println("2.圆的面积");
		System.out.print("请选择运算序号：");
	}
}
class operation 
{
	double a=0,b=0;
	double r=0;
	public void GetResult()
	{		
	}
	public void GetResult(String sym)
	{		
	}	
}
class fouroper extends operation 
{
    public fouroper(double i,double j)
    {
    	this.a=i;
    	this.b=j;
    }
    public void GetResult(String sym)
    {
    	switch (sym) {
		case "+":
			System.out.println("="+(this.a+this.b));
			break;
		case "-":
			System.out.println("="+(this.a-this.b));
			break;
		case "*":
			System.out.println("="+(this.a*this.b));
			break;
		case "/":
			System.out.println("="+(this.a/this.b));
			break;
		default:
			System.out.println("Error:错误的运算符！");
			break;
		}
    }
}
class area extends operation 
{
    public area(double k)
    {
    	this.r=k;
    }
    public void GetResult()
    {
    	System.out.println("圆的面积"+"="+(3.14*this.r*this.r));
    }
}


















