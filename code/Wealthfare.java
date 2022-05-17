public class Wealthfare {

	private Education Eb;
	private Medical Mb;
	private Housing Hb;
	private AnnualLeave Al;

	public Wealthfare() {
		Eb = new Education();
		Mb = new Medical();
		Hb = new Housing();
		Al = new AnnualLeave();
	}

	public Wealthfare(int eb, int mb, int hb, int al) {
		Eb = new Education(eb);
		Mb = new Medical(mb);
		Hb = new Housing(hb);
		Al = new AnnualLeave(al);
	}

	public void check() {
		System.out.println("Wealthfare total balance is: $" + (Eb.getbalance()+Mb.getbalance()+Hb.getbalance())+"\n"+Eb.toString()+"\n"+Mb.toString()+"\n"+Hb.toString()+"\n"+Al.toString());
	}

	public void AddEducation(int amount){
		Eb.add(amount);
	}

	public void AddMedical(int amount){
		Mb.add(amount);
	}

	public void AddHousing(int amount){
		Hb.add(amount);
	}

	public void AddAnnualLeave(int amount){
		Hb.add(amount);
	}

	public Education getEducation(){
		return Eb;
	}

	public Medical getMedical(){
		return Mb;
	}

	public Housing getHousing(){
		return Hb;
	}

	public AnnualLeave getAnnualLeave(){
		return Al;
	}

}