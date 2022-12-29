package employeedata;

public enum Unit {

	FS("Financial Services"), 
	EDC("Extended Centre"), 
	OIL_GAS("Oil & Gas");

	private String unitName;

	private Unit(String name) {
		this.unitName = name;
	}
	
	public String getUnitName() {
		return unitName;
	}

}
