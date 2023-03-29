
program prueba;
type
	arbol = ^nodoArbol;
	
	nodoArbol = record
		elem: integer;
		hi: arbol;
		hd: arbol;
	end;
	
	
procedure crearArbol (var a: arbol; n: integer);
begin
	if (a = nil) then
		begin
			new(a);
			a^.elem := n;
			a^.hi := nil;
			a^.hd := nil;
			
		
		
		end
	else
		begin
			if (n <= a^.elem) then
				crearArbol (a^.hi, n)
			else
				crearArbol (a^.hd, n);
		
		
		end;



end;

procedure cargarNumeros (var a: arbol);
var
	n: integer;

begin
	n := random (10);
	writeln ('El numero ingresado es ', n);
	while (n <> 0) do
		begin
			crearArbol (a, n);
			n := random (10);
			writeln ('El numero ingresado es ', n);
			
		
		end;


end;

procedure imprimirArbol (a: arbol);
begin
	if (a<> nil) then
		begin
			imprimirArbol (a^.hi);
			writeln ('NUMERO: ', a^.elem);
			imprimirArbol (a^.hd);
		
		
		end;


end;
procedure imprimirRangos (a: arbol; r1,r2: integer);
begin
	if (a<> nil) then
		begin
			if (a^.elem>= r1) and (a^.elem <=r2) then
				begin
					imprimirRangos (a^.hi, r1, r2);
					writeln (a^.elem);
					imprimirRangos (a^.hd,r1,r2)
				
				end
			else if (a^.elem < r1) then
					imprimirRangos (a^.hd, r1, r2)
				else
					imprimirRangos (a^.hi, r1, r2);
		
		
		end;


end;

var
	a: arbol;
	r1, r2: integer;

begin
	randomize;
	cargarNumeros (a);
	imprimirArbol (a);
	writeln ('INGRESE EL VALOR 1 del rango');
	readln (r1);
	writeln ('INGRESE EL VALOR 2 del rango');
	readln (r2);
	
	imprimirRangos (a, r1, r2);




end.


