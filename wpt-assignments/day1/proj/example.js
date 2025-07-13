
var acy = async () => 100;


 async function abc (){
    setTimeout(()=>{
        console.log("callinf async")
    })
}

 console.log("before await");
 
 console.log(await abc());
 console.log(await acy().catch(e=>"got some error"));
 setTimeout(()=>{console.log("timeout")},0);
 console.log("after await");

