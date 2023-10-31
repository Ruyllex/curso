// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async function iniciarSesion(){
    let datos = {};
    datos.email = document.getElementById('exampleInputEmail').value
    datos.password = document.getElementById('exampleInputPassword').value


    const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
    });
    const respuesta = await request.text();
    if(respuesta == "OK"){
        window.location.href = 'usuario.html';
    } else{
        alert("Las credenciales son incorrectas. Por favor intente nuevamente.")
    }
}