program ejercicio5;
type
	celular = record
		codigo: integer;
		precio: real;
		marca: string;
		stockD: integer;
		stockM: integer;
		descripcion: string;
		nombre: string;
	end;
	
	archivo = file of celular;
	

procedure leerCelular (var c: celular);
begin
	writeln ('Ingrese el codigo de celular');
	readln (c.codigo);
	writeln ('Ingrese el precio de celular');
	readln (c.precio);
	writeln ('Ingrese la marca de celular');
	readln (c.marca);
	writeln ('Ingrese el stock disponible de celular');
	readln (c.stockD);
	writeln ('Ingrese el stock minimo de celular');
	readln (c.stockM);
	writeln ('Ingrese la descripcion de celular');
	readln (c.descripcion);
	writeln ('Ingrese el nombre de celular');
	readln (c.nombre);
	


end;
	
procedure crearArchivo (var arch_cel: archivo; var celulares: text);
var
	c: celular;
begin
	rewrite (arch_cel);
	reset (celulares);
	while (not eof(celulares)) do
		begin
			readln (celulares, c.codigo, c.precio, c.marca);
			readln (celulares, c.stockD, c.stockM, c.descripcion);
			readln (celulares, c.nombre);
			write (arch_cel, c);
		
		end;
	
	close (celulares);
	close (arch_cel);

end;

procedure imprimirCelular (c: celular);
begin
	with c do
		writeln ('Codigo: ', codigo, 'precio: ', precio:1:2, ', marca:  ', marca, ' stock disponible: ', stockD, ', stock minimo ', stockM, ' descripcion: ', descripcion, ' nombre: ', nombre );


end;

procedure stockMenor (var arch_cel: archivo);
var
	c: celular;
begin
	reset (arch_cel);
	while (not eof(arch_cel)) do
		begin
			read (arch_cel, c);
			if (c.stockD < c.stockM) then
				imprimirCelular (c);
				
		end;
		
	close (arch_cel);


end;



procedure buscarDescripcion (var arch_cel: archivo);
var
	desc: string;
	c: celular;
begin
	writeln ('Ingrese la descripcion del celular a buscar');
	readln (desc);
	reset (arch_cel);
	while (not eof (arch_cel)) do
		begin
			read (arch_cel, c);
			if (c.descripcion = desc) then
				imprimirCelular (c);
		
		end;
	close (arch_cel);


end;

procedure exportar (var arch_cel: archivo; var celulares: text);
var
	c: celular;
begin
	reset (arch_cel);
	rewrite (celulares);
	while (not eof (arch_cel)) do
		begin
			read (arch_cel, c);
			writeln (celulares, c.codigo, ' ', c.precio:1:2, ' ', c.marca);
			writeln (celulares, c.stockD, ' ', c.stockM, ' ', c.descripcion);
			writeln (celulares, c.nombre);
		
		end;
	close (arch_cel);
	close (celulares);


end;

procedure agregarCelular (var arch_cel: archivo);
var
	c: celular;
	n, i: integer;

begin
	writeln ('Ingrese cuantos celulares quiere agregar');
	readln (n);
	reset (arch_cel);
	seek(arch_cel, FileSize (arch_cel));
	for i:= 1 to n do
		begin
			leerCelular (c);
			write (arch_cel, c);
		
		end;
	
	close (arch_cel)
	
end;

procedure modificarStock (var arch_cel: archivo);
var
	nombre: string;
	encontre: boolean;
	c: celular;
begin
	encontre := false;
	writeln ('Ingrese el nombre del celular a modificar el stock');
	readln (nombre);
	reset (arch_cel);
	while ((not encontre) and (not eof (arch_cel))) do
		begin
			read (arch_cel, c);
			if (c.nombre = nombre) then
				begin
					encontre := true;
					writeln ('Ingrese el nuevo stock disponible');
					readln (c.stockD);
					seek (arch_cel, filePos (arch_cel) - 1);
					write (arch_cel, c);
		
				end;
				
		
			
	
		
		
		end;
	if (not encontre) then
		writeln ('El nombre ingresado no se encuentra en la lista de productos');
		
	close (arch_cel);



end;

procedure sinStock (var arch_cel: archivo; var sinS: text);
var
	c: celular;
begin
	reset (arch_cel);
	rewrite (sinS);
	while (not eof (arch_cel)) do
		begin
			read (arch_cel, c);
			if (c.stockD = 0) then
				begin
					writeln (sinS, c.codigo, ' ', c.precio:1:2, ' ', c.marca);
					writeln (sinS, c.stockD, ' ', c.stockM, ' ', c.descripcion);
					writeln (sinS, c.nombre);
				
				end;
		
		
		end;
	
	close (arch_cel);
	close (sinS);



end;
procedure menu (var arch_cel: archivo; var celulares: text; var sinS: text);
var
	num: integer;
begin
	writeln ('Opcion 1: Crear archivo');
	writeln ('Opcion 2: Listar stock menor al minimo');
	writeln ('Opcion 3: Buscar celulares con una descripcion');
	writeln ('Opcion 4: Exportar archivo');
	writeln ('Opcion 5: Agregar celular');
	writeln ('Opcion 6: Modificar stock');
	writeln ('Opcion 7: Exportar sin stock');
	
	writeln ('Ingrese una opcion');
	readln (num);
	case num of
		1: crearArchivo(arch_cel, celulares);
		2: stockMenor (arch_cel);
		3: buscarDescripcion (arch_cel);
		4: exportar (arch_cel, celulares);
		5: agregarCelular (arch_cel);
		6: modificarStock (arch_cel);
		7: sinStock (arch_cel, sinS);
	end;
	
	while (num <> -1) do
		begin
			writeln ('Opcion 1: Crear archivo');
			writeln ('Opcion 2: Listar stock menor al minimo');
			writeln ('Opcion 3: Buscar celulares con una descripcion');
			writeln ('Opcion 4: Exportar archivo');
			writeln ('Opcion 5: Agregar celular');
			writeln ('Opcion 6: Modificar stock');
			writeln ('Opcion 7: Exportar sin stock');
			writeln ('Ingrese una opcion');
			readln (num);
			case num of
				1: crearArchivo(arch_cel, celulares);
				2: stockMenor (arch_cel);
				3: buscarDescripcion (arch_cel);
				4: exportar (arch_cel, celulares);
				5: agregarCelular (arch_cel);
				6: modificarStock (arch_cel);
				7: sinStock (arch_cel, sinS);
			end;
		
		end;



end;


var
	celulares, sinS: text;
	arch_cel: archivo;
	nFisico: string;

begin
	assign (celulares, 'celulares.txt');
	assign (sinS, 'sinStock.txt');
	writeln ('Ingresa el nombre fisico del archivo');
	readln (nFisico);
	assign (arch_cel, nFisico);
	menu (arch_cel, celulares, sinS);
	


end.
