/**
 * Created by keith for the second coursework assignment.
 * Modified by Zsolt Balvanyos on 22.11.2014
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        
			// test multiply
		Fraction f = new Fraction(3,10);
		Fraction g = new Fraction(1,2);
		Fraction h = new Fraction(3,5);
		if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
		
		   // test divide
		Fraction df = new Fraction(20,21);
		Fraction dg = new Fraction(5,7);
		Fraction dh = new Fraction(3,4);
		if (!df.equals(dg.divide(dh))) System.out.println("Divide failed");
		  
		  // test add
		Fraction af = new Fraction(41,28);
		Fraction ag = new Fraction(5,7);
		Fraction ah = new Fraction(3,4);
		if (!af.equals(ag.add(ah))) System.out.println("Add failed");
		
		   // test subtract
		Fraction sf = new Fraction(-1,28);
		Fraction sg = new Fraction(5,7);
		Fraction sh = new Fraction(3,4);
		if (!sf.equals(sg.subtract(sh))) System.out.println("Subtract failed");
		
			// test absValue
		Fraction a = new Fraction(5,7);
		Fraction b = new Fraction(-5,7);
		Fraction c = new Fraction(5,-7);
		if (!a.equals(a.absValue())) System.out.println("AbsValue failed");
		if (!a.equals(b.absValue())) System.out.println("AbsValue failed");
		if (!a.equals(c.absValue())) System.out.println("AbsValue failed");
		
			// test negate
		Fraction na = new Fraction(5,7);
		Fraction nb = new Fraction(-5,7);
		if (!na.equals(nb.negate())) System.out.println("Negate failed");
		
			// test toString
		Fraction sa = new Fraction(5,7);
		Fraction sb = new Fraction(5,1);
		if (!sa.toString().equals("5/7")) System.out.println("ToString failed");
		if (!sb.toString().equals("5")) System.out.println("ToString failed");
		
			// test equals
		test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
		test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
		test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
		test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
		test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");

    }

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
