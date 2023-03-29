program ej3;

type
	empleado = record
		numero: integer;
		apellido: string;
		nombre: string;
		edad: integer;
		dni: longInt;
	end;
	
	archivo = file of empleado;
	
procedure leerEmpleado (var e: empleado);
begin
	writeln ('Ingrese el numero de empleado');
	readln (e.numero);
	writeln ('Ingrese el apellido de empleado');
	readln (e.apellido);
	writeln ('Ingrese el nombre de empleado');
	readln (e.nombre);
	writeln ('Ingrese la edad de empleado');
	readln (e.edad);
	writeln ('Ingrese el dni de empleado');
	readln (e.dni);
	

end;

var
	arch_emp : archivo;
	e: empleado;


begin
	assign (arch_emp, 'ej3.txt');
	rewrite (arch_emp);
	leerEmpleado (e);
	while (e.apellido <> 'fin') do
		begin
			write (arch_emp, e);
			leerEmpleado (e);
		
		end;
	close (arch_emp);


end.


	

