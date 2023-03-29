program ejercicio1p2;
const
	VALORALTO = 32000;
type
	comision = record
		codigoEmp : integer;
		nombre: string;
		monto: real;
	
	end;
	
	
	
	archivo = file of comision;


var
	archC : archivo;
	archT : archivo;
	

procedure leer (var archC: archivo; var c: comision);
begin
	if (not eof(archC)) then
		begin
			read (archC, c);
		
		end
	else
		c.codigoEmp := VALORALTO;


end;
procedure compactar (var archC: archivo; var archT: archivo);
var
	c, actual: comision;

begin
	reset (archC);
	rewrite (archT);
	leer (archC, c);
	while (c.codigoEmp <> VALORALTO) do
		begin
			actual.codigoEmp := c.codigoEmp;
			actual.nombre := c.nombre;
			actual.monto := 0;
			while ((c.codigoEmp <> VALORALTO) and (actual.codigoEmp = c.codigoEmp)) do
				begin
					actual.monto := actual.monto + c.monto;
					leer (archC, c);
					
				
				
				end;
			write (archT, actual);
		
		
		end;
	
	close (archC);
	close (archT);

end;

procedure crearArchivo (var archC: archivo);
var
	c: comision;
begin
	rewrite (archC);
	writeln ('Ingrese todos los campos');
	readln(c.codigoEmp);
	readln (c.nombre);
	readln(c.monto);
	while (c.codigoEmp <> -1) do
		begin
			write (archC, c);
			writeln ('Ingrese todos los campos');
			readln(c.codigoEmp);
			readln (c.nombre);
			readln(c.monto);
		
		end;
	close (archC);
	



end;

procedure imprimirEmpleado (var archT: archivo);
var
	c: comision;
begin
	reset (archT);
	while (not eof (archT)) do
		begin
			read (archT, c);
			writeln ('Codigo: ', c.codigoEmp, 'Nombre: ', c.nombre, ' montoTotal: ', c.monto:1:2);
		
		
		end;

end;

begin
	assign (archC, 'archivoComisiones.dat');
	assign (archT, 'archivoEmpleados.dat');
	crearArchivo(archC);
	compactar (archC, archT);
	imprimirEmpleado(archT);


end.
