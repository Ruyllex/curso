// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuario').DataTable();
});
async function cargarUsuarios(){
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
    });
  const usuarios = await request.json();
  console.log(usuarios);
  let listadoHTML ='';

  for(let usuario of usuarios ){
    let botonEliminar = '<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
    let usuarioHTML = '<tr><th>'+usuario.id+'</th><th>'+usuario.nombre+'</th><th>'+usuario.apellido+'</th><th>'+usuario.email+'</th><th>'+usuario.dni+'</th><th>'+botonEliminar+'</th></tr>';
    listadoHTML += usuarioHTML;
}
  document.querySelector('#usuario tbody').outerHTML = listadoHTML;
  }

async function eliminarUsuario(id){

  const request = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
    });
}