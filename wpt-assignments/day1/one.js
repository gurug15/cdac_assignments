console.log("1. Start");

setTimeout(() => {
  console.log("4. setTimeout");
}, 0);

setImmediate(() => {
  console.log("5. setImmediate");
});

process.nextTick(() => {
  console.log("2. nextTick");
});

Promise.resolve().then(() => {
  console.log("3. Promise.then");
});

let count = 0;
const id = setInterval(() => {
  console.log("6. setInterval", ++count);
  if (count === 2) clearInterval(id);
}, 10);

async function demo() {
  await new Promise(resolve => setTimeout(resolve, 5));
  console.log("7. async/await done");
}

demo();

console.log("8. End of script");


// var cdac = async ()=> 100;

// const cdac = async () => 100;

// const ans = await cdac().catch(() => "rejected");

console.log(ans); // ✅ prints: 100

var x = (a,b)=> a+a;
console.log(x(10,20));



