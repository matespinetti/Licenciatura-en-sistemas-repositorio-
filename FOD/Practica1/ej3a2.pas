program ej3a2;
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
	writeln ('numero: ', e.numero, ', apellido: ', e.apellido, ', nombre: ', e.nombre, ' edad: ', e.edad, ' dni: ', e.dni);
	

end;


var
	arch_emp: archivo;
	apellido: string;
	e: empleado;

begin
	assign (arch_emp, 'ej3.txt');
	reset (arch_emp);
	while (not eof(arch_emp)) do
		begin
			read (arch_emp, e);
			imprimirEmpleado (e);
		
		end;
	
	close (arch_emp);


end.
