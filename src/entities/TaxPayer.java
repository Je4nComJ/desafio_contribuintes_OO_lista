package entities;

public class TaxPayer {

		private Double salaryIncome;
		private Double servicesIncome;
		private Double capitalIncome;
		private Double healthSpending;
		private Double educationSpending;
		
		public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
				Double educationSpending) {
			this.salaryIncome = salaryIncome;
			this.servicesIncome = servicesIncome;
			this.capitalIncome = capitalIncome;
			this.healthSpending = healthSpending;
			this.educationSpending = educationSpending;
		}

		public Double getSalaryIncome() {
			return salaryIncome;
		}

		public void setSalaryIncome(Double salaryIncome) {
			this.salaryIncome = salaryIncome;
		}

		public Double getServicesIncome() {
			return servicesIncome;
		}

		public void setServicesIncome(Double servicesIncome) {
			this.servicesIncome = servicesIncome;
		}

		public Double getCapitalIncome() {
			return capitalIncome;
		}

		public void setCapitalIncome(Double capitalIncome) {
			this.capitalIncome = capitalIncome;
		}

		public Double getHealthSpending() {
			return healthSpending;
		}

		public void setHealthSpending(Double healthSpending) {
			this.healthSpending = healthSpending;
		}

		public Double getEducationSpending() {
			return educationSpending;
		}

		public void setEducationSpending(Double educationSpending) {
			this.educationSpending = educationSpending;
		}
		
		public double salaryTax() {
			
			double monthSalary = salaryIncome /12.0;
			
			if (monthSalary < 3000.0) {
				return 0.0;
			}
			else if (monthSalary == 3000.0 || monthSalary < 5000.0) {
				return salaryIncome * 0.10;
			}
			
			else {
				return salaryIncome * 0.20;
			}
		}
		
		public double servicesTax() {
			if(servicesIncome > 0.0) {
				return servicesIncome * 0.15;
			}
			else {
				return 0.0;
			}
		}
		
		public double capitalTax() {
			if(capitalIncome > 0.0) {
				return capitalIncome * 0.20;
			}
			else {
				return 0.0;
			}
		}
		
		public double grossTax() {
			return salaryTax() + servicesTax() + capitalTax();
		}
		
		public double taxRebate() {
			double totalSpending = healthSpending + educationSpending;
			
			if(totalSpending >= 0.30 * grossTax()) {
				double rebate = 0.30 * grossTax();
				return rebate;
			}
			else if (totalSpending >= 0 && totalSpending < 0.3 * grossTax()) {
				return totalSpending;
			}
			else {
				return 0.0;
			}
		}
		
		public double netTax() {
			return grossTax() - taxRebate();
		}
}
