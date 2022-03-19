# Google
Google is always watching you, so it should come as no surprise that they know everything about you (even your pokemon collection), since you’re a really good at writing classes Google asked you to design a Class that can hold all the information they need for people.
From the console you will receive an unkown amount of lines until the command "End" is red, on each of those lines there will be information about a person in one of the following formats:
•	"<Name> company <companyName> <department> <salary>"  
•	"<Name> pokemon <pokemonName> <pokemonType>"
•	"<Name> parents <parentName> <parentBirthday>"
•	"<Name> children <childName> <childBirthday>"
•	"<Name> car <carModel> <carSpeed>"
You should structure all information about a person in a class with nested subclasses. People names are unique - there won’t be 2 people with the same name, a person can also have only 1 company and car, but can have multiple parents, chidlren and pokemons. After the command "End" is received on the next line you will receive a single name, you should print all information about that person. Note that information can change during the input, for instance if we receive multiple lines which specify a person company, only the last one should be the one remembered. The salary must be formated to two decimal places after the seperator.
Note: print the information in format:
	{personName}
	Company:
	{companyName} {companyDepartment} {salary}
	...
	Children:
	{childName} {childBirthday}
	{childName} {childBirthday}
