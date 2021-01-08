var colors = ["green", "black", "red", "black", "red",
               "black", "red", "black", "red", "black", "red", "black", "red",
               "black", "red", "black", "red", "black", "red", "green", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black"];
  var number = ["0", "28", "9", "26",
             "30", "11", "7", "20",
             "32", "17", "5", "22", "34", "15", "3", "24", "36", "13", "1", "00", "27", "10", "25", "29", "12", "8", "19", "31", "18", "6", "21", "33", "16", "4", "23", "35", "14", "2"];
  var bets=[];
  var numBet = [];
  var startAngle = 0;
  var arc = Math.PI / 19;
  var spinTimeout = null;
  var answer;
  var totalBet=0; //total de la apuesta
  var total;// total del cupo
  
  var spinArcStart = 10;
  var spinTime = 0;
  var spinTimeTotal = 0;
  
  var ctx;
  var text

$(window).on("load",function(){
	draw();
	cupoActual();
})

function cupoActual(){
  $.ajax({
		type:"GET",
		url: "/user/getUser/"+localStorage.getItem("user"),
		success:function(resp){
			total=resp.credito
			document.getElementById("money").innerHTML = "Credito: $ " + total;
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
			swal({
				  title: "Error",
				  text: "Usuario no existe",
				  icon: "error",
			}); 
        }
	}) 
}

function draw() {
    drawRouletteWheel();
  }
  
 function drawRouletteWheel() {
    var canvas = document.getElementById("wheelcanvas");
    if (canvas.getContext) {
      var outsideRadius = 220;
      var textRadius = 180;
      var insideRadius = 150;
      
      ctx = canvas.getContext("2d");
      ctx.clearRect(0,0,500,500);
      
      
      ctx.strokeStyle = "#000";
      ctx.lineWidth = 10;
      
      ctx.font = 'bold 20px Arial';
      
      for(var i = 0; i < 38; i++) {
        var angle = startAngle + i * arc;
        ctx.fillStyle = colors[i];
        
        ctx.beginPath();
        ctx.arc(250, 250, outsideRadius, angle, angle + arc, false);
        ctx.arc(250, 250, insideRadius, angle + arc, angle, true);
        ctx.stroke();
        ctx.fill();
        
        ctx.save();
        ctx.shadowOffsetX = -1;
        ctx.shadowOffsetY = -1;
        ctx.shadowBlur    = 0;
        ctx.fillStyle = "#FFF";
        ctx.translate(250 + Math.cos(angle + arc / 2) * textRadius, 250 + Math.sin(angle + arc / 2) * textRadius);
        ctx.rotate(angle + arc / 2 + Math.PI / 2);
        text = parseInt(number[i]);
        ctx.fillText(text, -ctx.measureText(text).width / 2, 0);
        ctx.restore();
      } 
      
      //Arrow
      ctx.fillStyle = "white";
      ctx.beginPath();
      ctx.moveTo(250 - 4, 250 - (outsideRadius + 5));
      ctx.lineTo(250 + 4, 250 - (outsideRadius + 5));
      ctx.lineTo(250 + 4, 250 - (outsideRadius - 5));
      ctx.lineTo(250 + 9, 250 - (outsideRadius - 5));
      ctx.lineTo(250 + 0, 250 - (outsideRadius - 13));
      ctx.lineTo(250 - 9, 250 - (outsideRadius - 5));
      ctx.lineTo(250 - 4, 250 - (outsideRadius - 5));
      ctx.lineTo(250 - 4, 250 - (outsideRadius + 5));
      ctx.fill();
    }
  }
  
function spin() {
    spinAngleStart = Math.random() * 10 + 10;
    spinTime = 0;
    spinTimeTotal = Math.random() * 3 + 4 * 1000;
    rotateWheel();
    
 }
  
 function rotateWheel() {
    spinTime += 30;
    if(spinTime >= spinTimeTotal) {
      stopRotateWheel();
      return;
    }
    var spinAngle = spinAngleStart - easeOut(spinTime, 0, spinAngleStart, spinTimeTotal);
    startAngle += (spinAngle * Math.PI / 180);
    drawRouletteWheel();
    spinTimeout = setTimeout('rotateWheel()', 30);
  }
  
 function stopRotateWheel() {
    clearTimeout(spinTimeout);
    var degrees = startAngle * 180 / Math.PI + 90;
    var arcd = arc * 180 / Math.PI;
    var index = Math.floor((360 - degrees % 360) / arcd);
    ctx.save();
    ctx.font = 'bold 60px Arial';
    var text = number[index];
	answer = text;
    ctx.fillText(text, 250 - ctx.measureText(text).width / 2, 250 + 10);
    saveBet(); //Almacena la apuesta
    ctx.restore();
  }
  
 function easeOut(t, b, c, d) {
    var ts = (t/=d)*t;
    var tc = ts*t;
    return b+c*(tc + -3*ts + 3*t);
  }
  
  
  
function putmoney(obj)
{
	var icon;
	var ficha = $('input:radio[name=exampleRadios]:checked').val()
	if(ficha == '1'){
		icon= "<i class='fas fa-plus-circle bet'></i>"
	}else if(ficha == '5'){
		icon= "<i class='fas fa-plus-circle bet' style='color:red'></i>"
	}else if(ficha == '25'){
		icon= "<i class='fas fa-plus-circle bet' style='color:blue'></i>"
	}else if(ficha == '100'){
		icon= "<i class='fas fa-plus-circle bet' style='color:green'></i>"
	}else if (ficha == '500'){
		icon= "<i class='fas fa-plus-circle bet' style='color:black'></i>"
	}else{
		icon= "<i class='fas fa-plus-circle bet' style='color:yellow'></i>"
	}
	$("#"+obj).append(icon);
	if(bets.length == 0){
		var bet = {
				'apuesta': parseInt(ficha),
				'descripcion': obj
		}
		bets.push(bet);
		numBet.push(obj);
	}else{
		var index = numBet.indexOf(obj)
		if(index != -1){
			bets[index].apuesta += parseInt(ficha);
		}else{
			var bet = {
					'apuesta': parseInt(ficha),
					'descripcion': obj
			}
			bets.push(bet);
			numBet.push(obj);
		}
	}
}

function checkwin(){
	var index = numBet.indexOf(text);
	if(index == -1){
		swal({
			  title: "Error",
			  text: "No Ganaste",
			  icon: "error",
			  timer: 3000,
		});
		$.ajax({
			type: "PUT",
			url: "/user/credito/"+localStorage.getItem("user")+"/"+(total-totalBet),
			success:function(resp){
				location.reload()
			},error: function(XMLHttpRequest, textStatus, errorThrown) { 
				swal({
					  title: "Error",
					  text: "Usuario no existe",
					  icon: "error",
				}); 
	        }
		})
	}else{
		swal({
			  title: "Exito",
			  text: "Felicidades ganaste",
			  icon: "success",
			  timer: 3000
		});
		var totalApuesta = total + (bets[index].apuesta*36);
		$.ajax({
			type: "PUT",
			url: "/user/credito/"+localStorage.getItem("user")+"/"+totalApuesta,
			success:function(resp){
				location.reload()
			},error: function(XMLHttpRequest, textStatus, errorThrown) { 
				swal({
					  title: "Error",
					  text: "Usuario no existe",
					  icon: "error",
				}); 
	        }
		})
	}
	//
}

function saveBet(){
	for(i in bets){
		totalBet += bets[i].apuesta
	}
	var apuesta={
		'ruleta':JSON.parse(localStorage.getItem('ruleta')).id,
		'usuario':localStorage.getItem('user'),
		'valortotal':totalBet,
		'fecha': new Date()
	}
	if(totalBet <= total){
		$.ajax({
			type:"POST",
			url: "/bet/save",
			data: JSON.stringify(apuesta),
			contentType: "application/json",
			success:function(resp){
				saveAllBets(resp[resp.length-1].id);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) { 
				swal({
					  title: "Error",
					  text: "No es posible almacenar la apuesta",
					  icon: "error",
				}); 
	        }
		})
	}else{
		swal({
			  title: "Error",
			  text: "No se puede realizar la apuesta, cupo insuficiente",
			  icon: "error",
			  timer: 3000
		});
	}
}


function saveAllBets(id){
	for(i in bets){
		var data={
			'descripcion':bets[i].descripcion,
			'apuesta':id,
			'valor': bets[i].apuesta,
		}
		$.ajax({
			type:"POST",
			url:"/detalle/save",
			data: JSON.stringify(data),
			contentType: "application/json",
			success: function(resp){
				swal({
					  title: "Exito",
					  text: "Apuesta guardada correctamente",
					  icon: "success",
				});
				checkwin()
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) { 
				swal({
					  title: "Error",
					  text: "No se pudo almacenar las apuestas",
					  icon: "error",
				}); 
	        }
		})
	}
}

function volver(){
	location.href="/inicio.html"
}