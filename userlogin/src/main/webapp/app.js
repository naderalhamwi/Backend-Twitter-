document.getElementById("getData").addEventListener("click", event=>{
  saveData();
  event.preventDefault();
});

document.getElementById("loginB").addEventListener("click", event=>{
  getData();
  event.preventDefault();
});

function saveData(){
  let form = document.getElementById("rigisterform");
  let name = form.elements.username.value;
  let password = form.elements.password.value;
  let email = form.elements.email.value;
  let phonenumber = form.elements.phoneNumber.value;

  let data = {
    "username" : name,
    "password": window.btoa(password),
    "email": email,
    "phonenumber": phonenumber
  };

  postMethod(data);


}

function  postMethod(data){
    fetch('http://localhost:8080/userlogin/resources/user',{
      method: 'POST',
      headers:{
        'Content-Type': 'text/plain',
      },
      body: JSON.stringify(data),
    })
    .then((response) => {
      window.open("Home.html", target = "_self");
      return response.json();
    })
    .then((data) => {

    })
    .catch((e) => {

  });
}


function getData(){
  let form = document.getElementById("loginform");

  let email = form.elements.email.value;
  let password = form.elements.password.value;

  let data = {
    "email": email,
    "password": window.btoa(password),
  };
  getMethod(data);
}


function getMethod(data){
  fetch('http://localhost:8080/userlogin/resources/user',{
    method: 'GET',
    body: JSON.stringify(data),
  })
  .then((response) => {
    window.open("Home.html", target = "_self");
    return response.json();
  })
  .then((data) => {

  })
  .catch((e) => {

});

}