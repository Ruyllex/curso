// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async function registrarUsuarios(){
    let datos = {};
    datos.nombre = document.getElementById('exampleFirstName').value
    datos.apellido = document.getElementById('exampleLastName').value
    datos.email = document.getElementById('exampleInputEmail').value
    datos.password = document.getElementById('exampleInputPassword').value
    let repetirPassword = document.getElementById('exampleRepeatPassword').value

    if(datos.password != repetirPassword){
        alert('Contraseña no repetida');
        return;
    }
    const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
    });
}