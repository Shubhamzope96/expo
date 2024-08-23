package practicejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> list = List.of(
			new Employee(1,"sh"
					+ "bham", 50000.00, "IT"),
			new Employee(5,"mayur", 60000.00, "EL"),
			new Employee(2,"krishna", 70000.00, "IT"),
			new Employee(3,"kavi", 40000.00, "EL"),
			new Employee(4,"anshul", 30000.00, "ME"),
			new Employee(8,"mahesh", 35000.00, "ME"),
			new Employee(6,"ritesh", 40000.00, "IT"),
			new Employee(7,"pranav", 40000.00, "IT")
		);
		System.out.println("contains output = "+list.contains(new Employee(5,"mayur", 60000.00, "EL")));
		
		List<String> strList = list.stream().map(employee->employee.getName()).collect(Collectors.toList());
		
		// print any single property of each employee by using map and method refference
		list.stream().map(Employee::getName).forEach(e->System.out.println(e));
		
		//print highest salary among employee
		double n0 = list.stream().map(Employee:: getSalary).collect(Collectors.maxBy(Comparator.naturalOrder())).get();
		System.out.println(n0);
		
		//print highest salary among employee in department
		double n1 = list.stream().filter(e->e.getDepartment().equals("ME")).map(Employee:: getSalary).collect(Collectors.maxBy(Comparator.naturalOrder())).get();
		System.out.println(n1);
		
		//print highest salary among employee in department without refference variable
		list.stream().filter(e->e.getDepartment().equals("ME")).map(Employee:: getSalary).collect(Collectors.maxBy(Comparator.naturalOrder())).ifPresent(e->System.out.println(e));;

		//print sorted list among employee based on names and print the list again with new stream
		list.stream().map(e->e.getName()).sorted().forEach(System.out::println);
		
		//print returned sorted list among employee based on names and print the list again with new stream
		List<String> l = list.stream().map(e->e.getName()).sorted().collect(Collectors.toList());
		System.out.println(l);
		
		//print sorted list among employee based on salary and print the list again with new stream
		list.stream().map(Employee::getSalary).sorted().forEach(System.out::println);
		
		//print sorted list among employee based on salary in reverse and print the list again with new stream
		list.stream().map(e->e.getSalary()).sorted(Comparator.reverseOrder()).forEach(e-> System.out.println(e));	
		
		//print sum of salaries in list
		Double sum = list.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		
		//print sum of salaries in list using reduce
		Double sum2 = list.stream().map(Employee::getSalary).reduce(0.0, (a,b)->a+b);
		System.out.println(sum2);
		
		// count employees in list with IT department
		long count = list.stream().filter(e->e.getDepartment().equals("IT")).count();
		System.out.println(count);
		
		// average of all salaries
		Double avg = list.stream().collect(Collectors.averagingDouble(e->e.getSalary()));
		System.out.println(avg);
		
		// average of all salaries by department
		Double avgIT = list.stream().filter(e->e.getDepartment().equals("IT")).collect(Collectors.averagingDouble(e->e.getSalary()));
		System.out.println(avgIT);
		
		List<String> vovelStr =  strList.stream().filter(e-> e.matches("^[aeiouAEIOU].*")).collect(Collectors.toList());
		System.out.println(vovelStr);
		
		// sort employees based on id and print ids and name
		list.stream().sorted(Comparator.comparingInt(e->e.getId())).forEach(e->System.out.println(e.getId()+" "+e.getName()));
	
		
		List<Integer> intList = Arrays.asList(1,2,3,2,7,6,9,8,7,4,5,6,7,8,9);
		
		//find dupplicate salary in list - print with ifPresent
		intList.stream().distinct().filter(n->Collections.frequency(intList, n)>1).findFirst().ifPresent(System.out::println);
	
		//find dupplicate salary in list - print with or else
		int i = intList.stream().distinct().filter(n->Collections.frequency(intList, n)>1).findFirst().orElse(0);
		System.out.println(i);//prints 0
		
		//find the first string that contains the vovels  from the list
		list.stream().map(e->e.getName()).filter(e->e.matches(".*[aeiouAEIOU].*")).findFirst().ifPresent(System.out::println);
	
		strList.stream().filter(n->n.matches(".*[aeiouAEIOU].*")).findFirst().ifPresent(System.out::println);
		
		//grouping employees by departmnt and print
		Map<String, List<Employee>> m = list.stream().collect(Collectors.groupingBy(e->e.getDepartment()));
		System.out.println(m);
		m.forEach((dept,empList)->{
			System.out.println("department "+dept);
			empList.forEach(emp->System.out.println(emp.getName()));
		});
		
		//grouping employees by department single line
		list.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((dept,empList)->{
			System.out.println("department "+dept); 
			empList.forEach(e->System.out.println(e.getName()));
		});
		
		
		List<String> ls = List.of("aa","bb","cc","aa","ab");
		//remove duplicate from list of strings
		ls.stream().distinct().forEach(e->System.out.println(e));
		
		//Find the sum of squares of numbers in a list.
		double sm = intList.stream().map(e->e*e).collect(Collectors.summingDouble(e->e));
		System.out.println(sm);
		
		Stream.concat(ls.stream(), list.stream()).collect(Collectors.toList()).forEach(System.out::println);
		
		//find most frequent number in list
		intList.stream().distinct().map(e->Collections.frequency(intList, e)).sorted(Comparator.reverseOrder()).findFirst().ifPresent(System.out::println);
		//above line is incorrect to meet requirements it prints max of frequency not the actual number associated with it.
		
		
		
		Employee t1 = new Employee(10, "dummy", 1000, "dev");
		Employee t2 = new Employee(10, "dummy", 1000, "dev");
		ArrayList<Employee> el=new ArrayList<Employee>();
		el.add(t1);
		if (!el.contains(new Employee(10, "dummy", 1000, "dev"))) {
			System.out.println("gggggggggggggggg");
			el.add(new Employee(10, "dummy", 1000, "dev"));

		}
		if (el.contains(new Employee(10, "dummy", 1000, "dev"))) {
			System.out.println("hhhhhhhhhhhhhh");
		}
		System.out.println(el);
		Employee t3 = t1;
		System.out.println("equals output = "+ t1.equals(t2));
		System.out.println("equals output = "+( t1==t2));
		System.out.println("equals output = "+( t1==t3));
		System.out.println(t1.equals(t2));
		System.out.println(t1.hashCode()+"--"+t2.hashCode()+"--"+t3.hashCode());
		
	}

}
