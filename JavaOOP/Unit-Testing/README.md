<<<<<<< HEAD
# JavaOOP
=======
# Unit-Testing
https://softuni.bg

Software University

Technical Trainers

SoftUni Team

Building Rock-Solid Software

Unit Testing

2

Seven Testing Principles

What Is Unit Testing?

Unit Testing Frameworks - JUnit

3A Pattern

Best Practices

Dependency Injection

Mocking and Mock Objects

Table of Contents


3

sli.do

#java-advanced

Have a Question?


Seven Testing Principles


Testing is context dependent

Testing is done differently in different contexts 

Example: 

Safety-critical software is tested differently from an e-commerce site

Seven Testing Principles (1)

5


6

Exhaustive testing is impossible

All combinations of inputs and preconditions are usually almost infinite number

Testing everything is not feasible

Except for trivial cases

Risk analysis and priorities should be used to focus testing 
efforts

Seven Testing Principles (2)


7

Defect clustering

Testing effort shall be focused proportionally 

To the expected and later observed defect density of modules

A small number of modules usually contains most of the 
defects discovered

Responsible for most of the operational failures

Seven Testing Principles (3)


8

Early testing is always preferred

Testing activities shall be started as early as possible 

And shall be focused on defined objectives

The later a bug is found – the more it costs!

Seven Testing Principles (4)


9

Pesticide paradox

Same tests repeated over and over again tend to lose their 
effectiveness

Previously undetected defects remain undiscovered

New and modified test cases should be developed

Seven Testing Principles (5)


10

Testing shows presence of defects

Testing can show that defects are present

Cannot prove that there are no defects

Appropriate testing reduces the probability for defects

Seven Testing Principles (6)


11

Absence-of-errors fallacy

Finding and fixing defects itself does not help in these cases:

The system built is unusable

Does not fulfill the users needs and expectations

Seven Testing Principles (7)


What is Unit Testing


Not structured

Not repeatable

Can't cover all of the code

Not as easy as it should be

Manual Testing (1)

void testSum() {

  if (this.sum(1, 2) != 3) {

    throw new Exception("1 + 2 != 3");

}

13


14

We need a structured approach that:

Allows refactoring

Reduces the cost of change

Decreases the number of defects in the code 

Bonus:

Improves design

Manual Testing (2)


15

System tests

Integration tests

Unit tests

Automated Testing

A single class

The whole system

A single module

System

Integration

Unit


16

The first popular unit testing framework

Most popular for Java development

Based on Java, written by Kent Beck & Co.

Junit (1)




17

Maven Repository – Junit 4.12

Copy JUnit repository and paste in pom.xml

Junit (2)

<project …>

…

<dependencies>

        <dependency>

            <groupId>junit</groupId>

            <artifactId>junit</artifactId>

            <version>4.12</version>

            <scope>test</scope>

        </dependency>

    </dependencies>

</project>


18

Create new package (e.g. tests)

Create a class for test methods (e.g. BankAccountTests)

Create a public void method annotated with @Test

Junit – Writing Tests

@Test

public void depositShouldAddMoney() {

  /* magic */

}


19

Arrange - Preconditions

Act - Test a single behavior

Assert - Postconditions

3A Pattern

@Test

public void depositShouldAddMoney() {

  BankAccount account = new BankAccount();

  account.deposit(50);

  Assert.assertTrue(account.getBalance() == 50)

}

Each test should test a single behavior!


20

Sometimes throwing an exception is the expected behavior

Exceptions

@Test(expected = IllegalArgumentException.class) 

public void depositNegativeShouldNotAddMoney() {

  BankAccount account = new BankAccount();

  account.deposit(-50);

}

Arrange

Act

Assert


21

Create a Maven project

Add provided classes (Axe, Dummy, Hero) to project

In test/java folder, create a package rpg_tests

Create a class AxeTests

Create the following tests:

Test if weapon loses durability after attack

Test attacking with a broken weapon

Problem: Test Axe


22

Solution: Test Axe (1)

@Test

public void weaponLosesDurabilityAfterAttack() {

  // Arrange

  Axe axe = new Axe(10, 10);

  Dummy dummy = new Dummy(10, 10);

  // Act

  axe.attack(dummy);

  // Assert

  Assert.assertTrue(axe.getDurabilityPoints() == 9);

}


23

Solution: Test Axe (2)

@Test(expected = IllegalStateException.class) // Assert

public void brokenWeaponCantAttack() {

  // Arrange

  Axe axe = new Axe(10, 1);

  Dummy dummy = new Dummy(10, 10);

  // Act

  axe.attack(dummy);

  axe.attack(dummy);

}


24

Create a class DummyTests

Create the following tests

Dummy loses health if attacked

Dead Dummy throws exception if attacked

Dead Dummy can give XP

Alive Dummy can't give XP

Problem: Test Dummy


25

Solution: Test Dummy

@Test

public void attackedTargetLoosesHealth() {

  // Arrange

  Dummy dummy = new Dummy(10, 10);

  // Act

  dummy.takeAttack(5);

  // Assert

  Assert.assertTrue(dummy.getHealth() == 5);

}

// TODO: Write the rest of the tests

There is a better solution…


Unit Testing Best Practices


27

assertTrue() vs assertEquals()

assertTrue()





assertEquals(expected, actual)

Assertions

Assert.assertTrue(account.getBalance() == 50);

Assert.assertEquals(50, account.getBalance());

Better description when expecting value


28

Assertions can show messages

Helps with diagnostics

Hamcrest is useful tool for test diagnostics

Assertion Messages

Assert.assertEquals(

    "Wrong balance", 50, account.getBalance());

Helps finding the problem


29

Avoid using magic numbers (use constants instead)

Magic Numbers

private static final int AMOUNT = 50;

@Test

public void depositShouldAddMoney() {

  BankAccount account = new BankAccount();

  account.deposit(AMOUNT);

  Assert.assertEquals("Wrong balance",    

               AMOUNT, account.getBalance());

}


30

Use @Before annotation

@Before

private BankAccount account;

@Before

public void createAccount() {

  this.account = new BankAccount();

}

@Test

public void depositShouldAddMoney() { … }

Executes before each test


31

Test names

Should use business domain terminology

Should be descriptive and readable

Naming Test Methods

depositAddsMoneyToBalance() {}

depositNegativeShouldNotAddMoney() {}

transferSubtractsFromSourceAddsToDestAccount() {}

incrementNumber() {}

test1() {}

testTransfer() {}


32

Refactor the tests for Axe and Dummy classes

Make sure that:

Names of test methods are descriptive

You use appropriate assertions (assert equals vs assert true)

You use assertion messages

There are no magic numbers

There is no code duplication (Don’t Repeat Yourself)

Problem: Refactor Tests


33

Solution: Refactor Tests (1)

private static final int AXE_ATTACK = 10;

private static final int AXE_DURABILITY = 1;

private static final int DUMMY_HEALTH = 20;

private static final int DUMMY_XP = 10;

private Axe axe;

private Dummy dummy;

@Before

public void initializeTestObjects() {

  this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);

  this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);  }


34

Solution: Refactor Tests (2)

@Test

public void weaponLosesDurabilityAfterAttack() {

  this.axe.attack(this.dummy);

  Assert.assertEquals("Wrong durability", 

	AXE_DURABILITY - 1, 

	axe.getDurabilityPoints());  }

@Test(expected = IllegalStateException.class)

public void brokenWeaponCantAttack() {

  this.axe.attack(this.dummy);

  this.axe.attack(this.dummy);  }


Dependencies


36

Consider testing the following code:

We want to test a single behavior

Coupling and Testing (1)

public class Bank {

  private AccountManager accountManager;

  public Bank() {

    this.accountManager = new AccountManager();

  }

  public AccountInfo getInfo(String id) { … }

}

Bank depends on AccoutManager

Concrete Implementation


37

Need to find solution to decouple classes

Coupling and Testing (2)

Bank

AccountManager

Bank

AccountManager



+Account getAccount()

uses



Interface

Bank inherits bugs


Decouples classes and makes code testable

Dependency Injection

interface AccountManager { 

  Account getAccount();

}

public class Bank {

  private AccountManager accountManager;

  public Bank(AccountManager accountManager) {

    this.accountManager = accountManager;

  }

}

Using Interface

Injecting dependencies

Independent from Implementation

38


39

In other words, to fixate all moving parts

Goal: Isolating Test Behavior

@Test

public void testGetInfoById() {

  // Arrange

  AccountManager manager = new AccountManager() {

    public Account getAccount(String id) { … } 

  }

  Bank bank = new Bank(manager);

  AccountInfo info = bank.getInfo(ID);

  // Assert…  }

Fake interface implementation with fixed behavior

Anonymous class


40

Test if hero gains XP when target dies

To do this, first: 

Make Hero class testable (use Dependency Injection)

Introduce Interfaces for Axe and Dummy

Interface Weapon 

Interface Target 

Create test using a fake Weapon and fake Dummy

Problem: Fake Axe and Dummy


41

Solution: Fake Axe and Dummy (1)

public interface Target {

  void takeAttack(int attackPoints);

  int getHealth();

  int giveExperience();

  boolean isDead();

}

public interface Weapon {

  void attack(Target target);

  int getAttackPoints();

  int getDurabilityPoints();  }


42

Solution: Fake Axe and Dummy (2)

// Hero: Dependency Injection through constructor

public Hero(String name, Weapon weapon) {

  this.name = name;      /* Hero: Dependency Injection */

  this.experience = 0;   /* through constructor */

  this.weapon = weapon; }

public class Axe implements Weapon {

  public void attack(Target target) { … }

}

// Dummy: implement Target interface

public class Dummy implements Target { }


43

Solution: Fake Axe and Dummy (3)

@Test

public void heroGainsExperienceAfterAttackIfTargetDies() {

  Target fakeTarget = new Target() {

    public void takeAttack(int attackPoints) { }

    public int getHealth() { return 0; }

    public int giveExperience() { return TARGET_XP; }

    public boolean isDead() { return true; }

  };

  // Continues on next slide…


44

Solution: Fake Axe and Dummy (4)

  // …

  Weapon fakeWeapon = new Weapon() {

    public void attack(Target target) {}

    public int getAttackPoints() { return WEAPON_ATTACK; }

    public int getDurabilityPoints() { return 0; }

  };

  Hero hero = new Hero(HERO_NAME, fakeWeapon);

  hero.attack(fakeTarget);  

  // Assert…

}


45

Not readable, cumbersome and boilerplate

Fake Implementations

@Test

public void testRequiresFakeImplementationOfBigInterface() {

  // Arrange

  Database db = new BankDatabase() {

    // Too many methods…

  };

  AccountManager manager = new AccountManager(db);

  // Act & Assert…

}

Not suitable for big interfaces


46

Mock objects simulate behavior of real objects

Supplies data exclusively for the test - e.g. network data,             random data, big data (database), etc.

Mocking

@Test

public void testAlarmClockShouldRingInTheMorning() {

  Time time = new Time();

  AlarmClock clock = new AlarmClock(time);

  if (time.isMorning()) {

    Assert.assertTrue(clock.isRinging());

  } }

Test will pass only in the morning!


47

Mockito Web Site - Mockito 3.0.0 dependency

Copy dependency in pom.xml

Mockito

<dependency>

    <groupId>org.mockito</groupId>

    <artifactId>mockito-core</artifactId>

    <version>3.0.0</version>

    <scope>test</scope>

</dependency>


48

Framework for mocking objects

Mockito

@Test

public void testAlarmClockShouldRingInTheMourning() {

  Time mockedTime = Mockito.mock(Time.class);

  Mockito.when(mockedTime.isMorning()).thenReturn(true);

  AlarmClock clock = new AlarmClock(mockedTime);

  if (mockedTime.isMorning()) {

    Assert.assertTrue(clock.isRinging());

  }

}

Always true


49

Include Mockito in the project dependencies

Mock fakes from previous problem

Implement Hero Inventory, holding unequipped weapons

method - Iterable<Weapon> getInventory()

Implement Target giving random weapon upon death

field - private List<Weapon> possibleLoot

Test Hero killing a target getting loot in his inventory

Test Target drops random loot

Problem: Mocking


50

Solution: Mocking (1)

@Test

public void attackGainsExperienceIfTargetIsDead() {

  Weapon weaponMock = Mockito.mock(Weapon.class);

  Target targetMock = Mockito.mock(Target.class);

  Mockito.when(targetMock.isDead()).thenReturn(true);

  Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

  Hero hero = new Hero(HERO_NAME, weaponMock);

  hero.attack(targetMock);



  Assert.assertEquals("Wrong experience", TARGET_XP, 

	hero.getExperience());

}


51

Create RandomProvider Interface

Hero method

attack(Target target, RandomProvider rnd)

Target method

dropLoot(RandomProvider rnd)

Mock weapon, target and random provider for test

Solution: Mocking (2)


52

Summary













Unit Testing helps us build solid code

Structure your unit tests – 3A Pattern

Use descriptive names for your tests

Use different assertions depending on the situation

Dependency Injection

makes your classes testable

Looses coupling and improves design

Mock objects to isolate tested behavior


Questions?


Software University – High-Quality Education, Profession and Job for Software Developers

softuni.bg

Software University Foundation

softuni.foundation

Software University @ Facebook

facebook.com/SoftwareUniversity

Software University Forums

forum.softuni.bg

Trainings @ Software University (SoftUni)

54


55

This course (slides, examples, demos, exercises, homework, documents, videos and other assets) is copyrighted content

Unauthorized copy, reproduction or use is illegal

© SoftUni – https://about.softuni.bg

© Software University – https://softuni.bg

License
>>>>>>> Unit-Testing/JavaOOP
