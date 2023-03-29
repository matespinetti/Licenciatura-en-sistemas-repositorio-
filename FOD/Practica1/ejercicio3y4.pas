program ej3y4;
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

procedure imprimirEmpleado (var e: empleado);
begin
	writeln ('numero: ', e.numero, ', apellido: ', e.apellido, ', nombre: ', e.nombre, ' edad: ', e.edad, ' dni: ', e.dni);
	

end;



procedure crearArchivo (var nLogico: archivo);
var
	e: empleado;
begin
	rewrite (nLogico);
	leerEmpleado (e);
	while (e.apellido <> 'fin') do
		begin
			write (nLogico, e);
			leerEmpleado (e);
		
		end;
	close (nLogico);
	


end;

procedure buscarNombre (var nLogico: archivo);
var
	e: empleado;
	nombre: string;
begin
	writeln ('Ingrese el nombre a buscar');
	readln (nombre);
	while (not eof(nLogico)) do
		begin
			read (nLogico, e);
			if (e.nombre = nombre) then
				imprimirEmpleado (e);		
		
		end;


end;

procedure buscarApellido (var nLogico: archivo);
var
	e: empleado;
	ap: string;
begin
	writeln ('Ingrese el apellido a buscar');
	readln (ap);
	while (not eof(nLogico)) do
		begin
			read (nLogico, e);
			if (e.apellido = ap) then
				imprimirEmpleado (e);		
		
		end;


end;

procedure listarTodos (var nLogico: archivo);
var
	e: empleado;
begin

	while (not eof(nLogico)) do
		begin
			read (nLogico, e);
			imprimirEmpleado (e);		
		
		end;


end;


procedure listar70 (var nLogico: archivo);
var
	e: empleado;
begin
	while (not eof(nLogico)) do
		begin
			read (nLogico, e);
			if (e.edad > 70) then
				imprimirEmpleado (e);
		
		end;


end;

procedure abrirArchivo (var nLogico: archivo);
var
	opcion: char;
begin
	reset (nLogico);
	writeln ('Opcion a: listar en pantalla empleados por nombre');
	writeln ('opcion b: listar en pantalla empleados por apellido');
	writeln ('Opcion c: Listar todos los empleados');
	writeln ('Opcion d: Listar empleados mayores a 70 anos');
	writeln ('Ingresar opcion: ');
	readln (opcion);
	case opcion of
		'a': buscarNombre(nLogico);
		'b': buscarApellido(nLogico);
		'c': listarTodos(nLogico);
		'd': listar70 (nLogico);
	end;
	close (nLogico);


end;


procedure agregarEmpleados (var arch_num: archivo);
var
	esUnico: boolean;
	eAgregar, e: empleado;
begin
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



end;

procedure modificarEdad (var nLogico: archivo);
var
	n, edad: integer;
	e: empleado;
	encontre : boolean;

begin
	writeln ('Ingrese el numero de empleado a modificar edad');
	readln (n);
	while (n <> -1) do
		begin
			encontre := false;
			writeln ('Ingrese nueva edad');
			readln (edad);
			reset (nLogico);
			while (not eof(nLogico) and not(encontre)) do
				begin
					
					read (nLogico, e);
					if (e.numero = n) then
						begin
							encontre := true;
							e.edad := edad;
							seek (nLogico, filePos(nLogico) - 1);
							write (nLogico, e);
						
						end;
				
				
				
				end;
			
			
			close (nLogico);
			
			
		
		
		end;


end;


procedure exportar (var nLogico: archivo; var todosEmp: text);
var
	e: empleado;
begin
	reset (nLogico);
	rewrite (todosEmp);
	while (not eof(nLogico)) do
		begin 
			read (nLogico, e);
			with e do
				begin
					writeln (todosEmp, 'numero: ',numero, ', apellido: ', apellido, ', nombre: ', nombre, ', edad: ', edad, ', dni: ', dni);
				
				
				end;
				
		
		end;
	close (nLogico);
	close (todosEmp);

end;


procedure imprimirOpciones;
begin
	writeln ('Opcion 1: Crear archivo');
	writeln ('Opcion 2: Abrir archivo');
	writeln ('Opcion 3: Agregar empleados');
	writeln ('Opcion 4: Modificar archivo');
	writeln ('Opcion 5: Exportar');
	writeln ('Opcion 6: Salir');


end;

procedure menu (var nLogico: archivo; var todosEmp: text);
var
	num: integer;
begin
	imprimirOpciones();
	readln (num);
	while (num <> 6) do
		begin
			case num of
				1: crearArchivo (nLogico);
				2: abrirArchivo (nLogico);
				3: agregarEmpleados (nLogico);
				4: modificarEdad (nLogico);
				5: exportar (nLogico, todosEmp)
			end;
			
			imprimirOpciones();
			readln(num);
		
		
		end;
	


end;

var
	nLogico: archivo;
	todosEmp: text;
	nFisico: string;
	
begin
	writeln ('Ingrese el nombre del archivo');
	readln (nFisico);
	assign (nLogico, nFisico);
	assign (todosEmp, 'todos_empleados.txt');
	menu(nLogico, todosEmp);


end.
