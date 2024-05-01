
public class Customer {
		Clock time = new Clock ();
		int serviceType;

		public Customer (Clock tm, int sType)
		  {
			      time.setTime(tm.getHours(),tm.getMinutes(),tm.getSeconds());
			      serviceType = sType;
		  }

		public Customer()
		  {
		      time.setTime(0,0,0);
			  serviceType =0;   
		  }

		public int getSeviceType()
		  {
			  int temp;
              temp=this.serviceType;

			  return temp;
		  }

		public int setSeviceType()
		  {
			  int temp;
              temp=this.serviceType;

			  return temp;
		  }
		
		 public Customer CopyCustomer()
		  {
			      Customer temp = new Customer();

			      //temp.time.getTime(this.time.getHours(), this.time.getMinutes(), this.time.getSeconds()); 
			      temp.time = time.getCopy();
			      temp.serviceType= getSeviceType();
                  temp.toString();
			      return temp;
		  }
		
		 public String toString()
		  {
			String str;
			
			    //System.out.print("Customer arrival time: " );
			    str = this.time.toString();   
			    str = str +  " (" + serviceType + ") ";
           	    return str;
		}
}
