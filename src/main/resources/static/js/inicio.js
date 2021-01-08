
$(window).on("load",function(){
	getRuletas();
})

/**
 * Method for to show all roulettes
 */
function getRuletas(){
	$.ajax({
		type:"GET",
		url:"/rulette/all",
		success: function(resp){
			$("#body").empty();
			$.each(resp,function(index,value){
				var status;
				if(value.estado==true){
					status = "ABIERTA"
				}else{
					status = "CERRADA"
				}
				var fila=`
					<tr>
				      <th scope="row">${value.id}</th>
				      <td>${value.nombre}</td>
				      <td>${status}</td>
				      <td><button id="ver${index}" type="button" class="btn btn-primary" onclick="verRuleta(${value.id},'${value.nombre}')">APOSTAR</button></td>
				    </tr>
				`
				if(value.estado==true){
					$("#body").append(fila);
				}
			})
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
			swal({
				  title: "Error",
				  text: "No hay ruletas disponibles",
				  icon: "error",
			}); 
        }
	})
}


function verRuleta(id,nombre){
	var ruleta={
			'id': id,
			'nombre': nombre
	}
	localStorage.setItem("ruleta",JSON.stringify(ruleta));
	location.href='/ruleta.html';
}