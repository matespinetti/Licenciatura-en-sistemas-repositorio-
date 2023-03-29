program ej3b;
type
	empleado = record
		numero: integer;
		apellido: string;
		nombre: string;
		edad: integer;
		dni: longInt;
	end;
	
	archivo = file of empleado;
	
procedure imprimirEmpleado (var e: empleado);
begin
	writeln ('numero: ', e.numero);
	writeln ('apellido: ', e.apellido);
	writeln ('nombre: ', e.nombre);
	writeln ('edad: ', e.edad);
	writeln ('dni: ' , e.dni);
	

end;


var
	arch_emp: archivo;
	apellido: string;
	e: empleado;

begin
	assign (arch_emp, 'ej3.txt');
	reset (arch_emp);
	writeln ('Ingrese un apellido a buscar en el archivo');
	readln (apellido);
	while (not eof(arch_emp)) do
		begin
			read (arch_emp, e);
			if (e.apellido = apellido) then
				begin
					imprimirEmpleado (e);
				
				end;
		
		end;
	
	close (arch_emp);


end.

