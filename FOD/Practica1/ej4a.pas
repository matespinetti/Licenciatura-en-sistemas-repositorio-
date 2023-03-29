program ej4a;
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
	arch_num : archivo;
	eAgregar, e: empleado;
	esUnico : boolean;
	

begin
	assign(arch_num, 'ej3.txt');
	
	leerEmpleado (eAgregar);
	while (eAgregar.apellido <> 'fin') do
		begin
			esUnico := true;
			reset (arch_num);
			while ((not eof (arch_num)) and (esUnico)) do
				begin
					read (arch_num, e);
					if (eAgregar.numero = e.numero) then
						esUnico := false;
				
				end;
			if (esUnico) then
				write (arch_num, eAgregar);
			
			close (arch_num);
			
			leerEmpleado (eAgregar);
		
		
		end;


end.

