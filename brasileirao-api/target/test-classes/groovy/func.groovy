package groovy
import groovy.json.JsonSlurper;

def set1 = new JsonSlurper().parseText(dataset1);
def set2 = new JsonSlurper().parseText(dataset2);

def resultado = [:];

for(def i=0; i < set1.funcionarios.size(); i++) {
	def exist = false;
	for(def j=0; j < set2.funcionarios.size(); j++){
		if(set1.funcionarios[i]['nomé do êmp'] == set2.funcionarios[j]['nomé do êmp']){
			exist = true;
			continue;
		}
	}

	if(!exist){
		resultado['resultado'] = set1.funcionarios[i]['nomé do êmp'];
	}
}

return resultado;
