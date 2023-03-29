program dicotomicaRecursiva;
const
	dimF = 10;
type
	vector = array [1..dimF] of integer;

procedure busquedaDicotomica ( v: vector; pri, ult: integer; var med: integer; busco: integer; var encontre: boolean);
begin
	if (pri <= ult) then
		begin
			med := (pri + ult) div 2;
			if (v[med] <> busco) then
				begin
					if (busco < v[med]) then
						busquedaDicotomica (v, pri, med-1, med,  busco, encontre)
					else
						busquedaDicotomica (v, med+1, ult,med, busco, encontre)
				
				
				end
			else
				encontre := true;
		
	
		end;


end;


procedure cargarArreglo (var v: vector);
var
	i : integer;
begin
	for i := 1 to dimF do
		begin
			v[i] := random (100);
			writeln (v[i]);
		
		
		end;



end;


var
	v: vector;
	pri, ult, med, busco: integer;
	encontre: boolean;

begin	
	randomize;
	pri := 1;
	ult := dimF;
	encontre := false;
	cargarArreglo (v);
	writeln ('Ingrese un elemento a buscar');
	readln (busco);
	busquedaDicotomica (v, pri, ult, med, busco, encontre);
	if (encontre) then
		writeln ('Encontre el elemento en la posicion ', med)
	else
		writeln ('El numero no estaba en el arreglo');



end.
