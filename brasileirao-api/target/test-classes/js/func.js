var set1 = JSON.parse(dataset1);
var set2 = JSON.parse(dataset2);

var resultado = [];
for(var i=0; i < set1.funcionarios.length; i++){
	var exist = false;
	for(var j=0; j < set2.funcionarios.length; j++){
		if(set1.funcionarios[i]['nomé do êmp'] == set2.funcionarios[j]['nomé do êmp']){
			exist = true;
			continue;
		}
	}

	if(!exist){
		resultado['resultado'] = set1.funcionarios[i]['nomé do êmp'];
	}
}
