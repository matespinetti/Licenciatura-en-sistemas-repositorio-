program ejercicio4REDO;
const	
	dimF = 7;
type
	RANGODIA = 1..dimF;
	entrada = record
		dia: RANGODIA;
		codigoObra: integer;
		asiento: integer;
		monto: real;
	end;
	
	listaEntradas = ^nodoEntradas;
	
	nodoEntradas = record
		elem: entrada;
		sig: listaEntradas;
	end;
	
	vectorD = array [RANGODIA ] of listaEntradas;
	
	
	entradaObra = record
		codigo: integer;
		cant: integer;
	end;
	
	listaTotal = ^nodoT;
	
	nodoT = record
		elem: entradaObra;
		sig: listaTotal;
	end;
	

procedure leerEntrada (var e: entrada);
begin
	e.dia := random (7) + 1;
	writeln ('DIA: ', e.dia);
	e.codigoObra := random (20);
	writeln ('CODIGO OBRA : ', e.codigoObra);
	e.asiento := random (90);
	writeln ('ASIENTO: ', e.asiento);
	e.monto := random (10000);
	writeln ('MONTO: ', e.monto:1:2);	


end;

procedure inicializarVector (var v: vectorD);
var
	i: integer;

begin
	for i:= 1 to dimF do
		begin
			v[i] := nil;
		
		end;



end;


procedure insertarOrdenado (var pi: listaEntradas; e: entrada);
var
	nuevo, act, ant : listaEntradas;

begin
	new (nuevo);
	nuevo^.elem := e;
	nuevo^.sig := nil;
	
	if (pi = nil) then
		pi := nuevo
	else
		begin
			act := pi;
			ant := pi;
			while ((act <> nil) and (nuevo^.elem.codigoObra > act^.elem.codigoObra)) do
				begin
					ant := act;
					act := act^.sig;
				
				end;
				
				if (act = pi) then
					begin
						nuevo^.sig := pi;
						pi := nuevo;
					
					end
				else
					begin
						ant^.sig := nuevo;
						nuevo^.sig := act;
					
					end;
		
		
		end;



end;

procedure cargarEntradas (var v: vectorD);
var
	e: entrada;

begin
	leerEntrada (e);
	while (e.codigoObra <> 0) do
		begin
			insertarOrdenado (v[e.dia], e);
			leerEntrada (e);
		
		
		end;



end;


procedure minimo (var v: vectorD; var max: entradaObra);
var
	indiceMin, i : integer;
begin
	max.codigo := 32000;
	for i := 1 to dimF do
		if (v[i] <> nil) then
			if (v[i]^.elem.codigoObra <= max.Codigo) then
				begin
					max.codigo := v[i]^.elem.codigoObra;
					indiceMin := i; 
				
				end;
		
		
	if (max.codigo <> 32000) then
		v[indiceMin] := v[indiceMin]^.sig;
		

end;
		
		
		
	



procedure agregarAtras (var pi: listaTotal; var pu: listaTotal;e: entradaObra);
var
	nuevo: listaTotal;

begin
	new (nuevo);
	nuevo^.elem := e;
	nuevo^.sig := nil;
	
	if (pi = nil) then
		begin
			pi := nuevo;
			pu := nuevo;
		
		end
	else
		begin
			pu^.sig := nuevo;
			pu := nuevo;
		
		end;


end;
procedure mergeListas ( v: vectorD; var pi: listaTotal; var pu: listaTotal);
var
	act, max: entradaObra;

begin
	pi := nil;
	minimo (v, max);
	while (max.codigo <> 32000) do
		begin
			act.codigo := max.codigo;
			act.cant := 0;
			while ((max.codigo <> 32000) and (act.codigo = max.codigo)) do
				begin
					act.cant := act.cant + 1;
					minimo (v, max);
				
				
				end;
				
			agregarAtras (pi, pu, act);
		
		
		end;
	




end;


procedure informarListaTotal (pi: listaTotal);
begin
	if (pi <> nil) then
		begin
			writeln ('CODIGO: ', pi^.elem.codigo, ' CANT VENDIDAS: ', pi^.elem.cant);
			informarListaTotal (pi^.sig);
		
		
		end;


end;


var
	v: vectorD;
	pi, pu: listaTotal;

begin
	randomize;
	inicializarVector (v);
	cargarEntradas (v);
	mergeListas (v, pi, pu);
	informarListaTotal (pi);



end.

