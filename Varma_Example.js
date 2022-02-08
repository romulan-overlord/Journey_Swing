/* 
// string, numbers, boolean,  null, undefined

const name = 'John';
const age = 30;
const rating = 4.5;
const isCool = true;
const x = null;
const y = undefined;
let z;

//console.log(typeof z);

// concatenation
console.log('My name is '+ name + ' and I am' + age);
//Template String
const hello = `My name is ${name} and I am ${age}`;
console.log(hello);

const s = 'Hello World';
console.log(s.toUpperCase());
console.log(s.length);
console.log(s.substring(0,7));
console.log(s.substring(0,7).toUpperCase());

console.log(s.split(''));


const s = 'technology, computes, it, code';
console.log(s.split(', '));


// Arrays - variables that hold multiple values

const numbers = new Array(1,2,3,4,5);
console.log(numbers);

const fruits = ['apples','oranges','mango'];
console.log(fruits);
console.log(fruits[1]);
fruits[3]='grapes';
console.log(fruits);

fruits.push('guava'); // adds at last
fruits.unshift('strawberries'); //adds at first
fruits.pop(); // removes the last one
console.log(Array.isArray(fruits));
console.log(fruits.indexOf('oranges'));
console.log(fruits);



// object literals
const person =
{
    firstName: 'John',
    lastName: 'Doe',
    age:30,
    hobbies: ['music','code','games'],
    address:
    {
        doornum: '50-1-56/9',
        aptname: 'suryatowers',
        city: 'vskp',
        state: 'AP',
    }
}

console.log(person.firstName,person.age,person.hobbies[1],person.address.city);
const {firstName, lastName, address:{city}} = person;   // destructing - pulls it out
console.log(firstName,city);

person.email = 'john@gmail.com';
console.log(person);


// arrays of objects
const todos = [
{
    id:1,
    text:'take out trash',
    isCompleted: true,
},
{
    id:2,
    text:'boss meet',
    isCompleted: true,
},
{
    id:3,
    text:'dentist appt',
    isCompleted: true,
},
];

console.log(todos);
console.log(todos[1].text);

const todoJSN = JSON.stringify(todos);
console.log(todoJSN);


// For loops
for(let i=0; i < 10; i++)
{
    console.log(`For Loop Number: ${i}`);
}

// While loops
let i=0;
while(i<10)
{
    console.log(`While loop number: ${i}`);
    i++;
}


for(let i=0; i < todos.length; i++)
{
    console.log(todos[i].text);
}

for(let todo of todos)
{
    console.log(todo.id);
}

// high order arrays - forEach, map, filter
todos.forEach(function(todo)
{
    console.log(todo.text)
}
);

const todoText = todos.map(function(todo)
{
    return todo.text;
}
);
console.log(todoText);

const todoCompleted = todos.filter(function(todo)
{
    return todo.isCompleted === true;
}
);
console.log(todoCompleted);

const todoCompleted = todos.filter(function(todo)
{
    return todo.isCompleted === true;
}
).map(function(todo)
{
    return todo.text;
});
console.log(todoCompleted);


// conditionals
const x = 20;
const y = 10;
if(x === 10)
{
    console.log('x is 10');
}
else if(x>10)
{
 console.log('x is greater than 10')
}
else
{
    console.log('x is less than 10');
}

const x = 4;
const y = 12;

if(x>5 || y>10)
{
    console.log('x is more than 5 or y is more than 10');
}


// ternary operator
const x = 11;
const color = x > 10 ? 'red' : 'blue';
console.log(color);

// switches
switch(color)
{
    case 'red': 
        console.log('color is red');
        break;
    case 'blue':
        console.log('color is blue');
        break;
    default:
        console.log('color is NOT red or blue');
        break;
}


// functions
function addNums(num1, num2)
{
    return num1+num2;
}
console.log(addNums(5,7));

//array function
const addNums = (num1, num2) =>    // const addNums = (num1,num2) => num1 + num2;
{
    return num1+num2;
}
console.log(addNums(5,7));

const addNums = num1 => num1 + 5;
console.log(addNums(5));


// Object Oriented Programming
function Person(firstName, lastName, birth, dob)   // function constructor should start with capital
{
    this.firstName=firstName;
    this.lastName=lastName;
    this.birth=birth;
    this.dob=new Date(dob);
    this.getBirthYear = function() { return this.dob.getFullYear();}
    this.getFullName = function() { return `${this.firstName} ${this.lastName}`;}
}
// Instantiate object
const person1 = new Person('John', 'Doe', 'birth1', '5-7-1987');
const person2 = new Person('Sandy', 'Rdoe', 'birth2','7-4-1578');
console.log(person1);
console.log(person2);
console.log(person2.dob);
console.log(person2.dob.getFullYear());
console.log(person1.getBirthYear());
console.log(person1.getFullName());

// with prototypes
function Person(firstName, lastName, dob)   // function constructor should start with capital
{
    this.firstName=firstName;
    this.lastName=lastName;
    this.dob=new Date(dob);
    this.getBirthYear = function() { return this.dob.getFullYear();}
    this.getFullName = function() { return `${this.firstName} ${this.lastName}`;}
}

Person.prototype.getBirthYear = function()
{
    return this.dob.getFullYear();
}

Person.prototype.getFullName = function()
{
    return `${this.firstName} ${this.lastName}`;
}

// Class
class Person
{
    constructor(firstName, lastName, dob)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.dob=new Date(dob);
    }
    getBirthYear()
    {
        return this.dob.getFullYear();
    }
    getFullName() 
    {
        return `${this.firstName} ${this.lastName}`;
    }
}
// Instantiate object
const person1 = new Person('John', 'Doe', '5-7-1987');
const person2 = new Person('Sandy', 'Rdoe','7-4-1578');
console.log(person2.getFullName());
console.log(person1);


// Class
class Person
{
    constructor(firstName, lastName, dob)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.dob=new Date(dob);
    }
    getBirthYear()
    {
        return this.dob.getFullYear();
    }
    getFullName() 
    {
        return `${this.firstName} ${this.lastName}`;
    }
}

// Instantiate object
const person1 = new Person('John', 'Doe', '5-7-1987');
const person2 = new Person('Sandy', 'Rdoe','7-4-1578');
console.log(person2.getFullName());
console.log(person1);
*/
/*
console.log(window);
alert(1);
*/

/*
//DOM
// single element
console.log(document.getElementById('my-form'));
//const form = document.getElementById('my-form');
//console.log(form); // same as 321
console.log(document.querySelector('.container'));

// Multiple element
console.log(document.querySelectorAll('.item'));
//console.log(document.getElementsByClassName('item'));
//console.log(document.getElementsByTagName('li'));


const items = document.querySelectorAll('.item');
items.forEach((item) => console.log(item));


//manipulating DOM
const ul = document.querySelector('.items');
//ul.remove();
//ul.lastElementChild.remove();
ul.firstElementChild.textContent='Hello';
ul.children[1].innerText='Brad';
ul.lastElementChild.innerHTML='<h1>Hello</h1>';

const btn = document.querySelector('.btn');
btn.style.background='red';


//Events
const btn = document.querySelector('.btn');
btn.addEventListener('click', (e) => {  // mouseout & hover
    e.preventDefault();
    //console.log('click');
    //console.log(e.target.className);
    document.querySelector('#my-form').style.background='#ccc';
    document.querySelector('body').classList.add('bg-dark');
    document.querySelector('.items').lastElementChild.innerHTML='<h1>Hello</h1>';
});
*/

//Form Script
const myForm = document.querySelector('#my-form');
const nameInput = document.querySelector('#name');
const emailInput = document.querySelector('#email');
const msg = document.querySelector('.msg');
const userList = document.querySelector('#users');

myForm.addEventListener('submit', onsubmit);
function onsubmit(e)
{
    e.preventDefault();
    //console.log(nameInput.value);
    if(nameInput.value === '' || emailInput.value === '')
    {
        //alert('Please enter fields');
        msg.classList.add('error');
        msg.innerHTML='Please enter all fields';
        setTimeout(() => msg.remove(), 3000);
    }
    else
    {
        //console.log('success');
        const li =  document.createElement('li');
        li.appendChild(document.createTextNode(`${nameInput.value} : ${emailInput.value}`));

        userList.appendChild(li);

        // Clear fields
        nameInput.value ='';
        emailInput.value='';
    }
}