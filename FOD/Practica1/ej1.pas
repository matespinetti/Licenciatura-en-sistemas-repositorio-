program ejercicio1p1;
type
	archivo = file of integer;
	
var
	arch_int: archivo;
	num: integer;
	nFisico: string;

begin
	writeln ('Escriba el nombre del archivo');
	readln (nFisico);
	assign (arch_int, nFisico);
	rewrite (arch_int);
	writeln ('Ingrese un numero');
	readln (num);
	while (num <> 30000) do
		begin
			write (arch_int, num);
			writeln ('Ingrese un numero');
			readln (num);
		
		end;
	
	close (arch_int);




end.
