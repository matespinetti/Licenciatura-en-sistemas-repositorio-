program ejercicio2p2;
const
	VALORALTO = 32000;

Type

	alumno= record
		codigo: integer;
		apellido: string;
		nombre :string;
		cursadas: integer;
		finales: integer;
	end;
	
	
	regDetalle = record
		codigo: integer;
		estado: string;
	end;
	
	
	archivoA = file of alumno;
	archivoD = file of regDetalle;


procedure leer (var archD: archivoD; var regD: regDetalle);
begin
	if (not eof(archD)) then
		read (archD, regD)
	else
		regD.codigo := VALORALTO;


end;


procedure actualizar (var archA: archivoA; var archD: archivoD);
var
	regD: regDetalle;
	actual, regM: alumno;
	
begin
	reset (archA);
	reset (archD);
	leer (archD, regD);
	read (archA, regM);
	while (regD.codigo <> VALORALTO) do
		begin
			actual.codigo := regD.codigo;
			actual.cursadas:= 0;
			actual.finales := 0;
			while ((regD.codigo <> VALORALTO) and(actual.codigo = regD.codigo)) do
				begin
					if (regD.estado = 'cursada') then
						actual.cursadas := actual.cursadas + 1
					else
						actual.finales := actual.finales + 1;
					
					leer (archD, regD);
				
				
				end;
			
			while (regM.codigo <> actual.codigo) do
				begin
					read (archA, regM);

				end;
			
			seek (archA, filePos(archA) - 1);
			regM.cursadas := regM.cursadas + actual.cursadas;
			regM.finales := regM.finales + actual.finales;
			write (archA, regM);
			
		
		end;
	
	close (archA);
	close (archD);

end;

procedure menu (var archA: archivoA; var archD: archivoD);
var
	num: integer;
begin
	readln(num);
	case num of
		1: actualizar (archA, archD);
	end;
	
	


end;


procedure crearMaestro (var archA: archivoA);
var
	a: alumno;
begin
	writeln ('Codigo: ');
	readln (a.codigo);
	writeln ('Apellido: ');
	readln (a.apellido);
	writeln ('nombre: ');
	readln (a.nombre);
	writeln ('Cursadas: ');
	readln (a.cursadas);
	writeln ('finales: ');
	readln (a.finales);
	rewrite (archA);
	while (a.codigo <> -1) do
		begin
			write (archA, a);
			writeln ('Codigo: ');
			readln (a.codigo);
			writeln ('Apellido: ');
			readln (a.apellido);
			writeln ('nombre: ');
			readln (a.nombre);
			writeln ('Cursadas: ');
			readln (a.cursadas);
			writeln ('finales: ');
			readln (a.finales);
		
		end;
	
	close (archA);
end;


procedure crearDetalle (var archD: archivoD);
var
	regD: regDetalle;
	num: integer;
begin
	rewrite (archD);
	writeln ('Codigo: ');
	readln (regD.codigo);
	writeln ('1 si final o 2 si cursada');
	readln (num);
	if (num = 1) then
		regD.estado := 'final'
	else
		regD.estado := 'cursada';
		
	while (regD.codigo <> -1) do
		begin
			write (archD, regD);
			writeln ('Codigo: ');
			readln (regD.codigo);
			writeln ('1 si final o 2 si cursada');
			readln (num);
			if (num = 1) then
				regD.estado := 'final'
			else
				regD.estado := 'cursada';
		end;
	
	close (archD);

end;

procedure imprimirMaestro (var archA: archivoA);
var
	a: alumno;
begin
	reset (archA);
	while (not eof (archA)) do
		begin
			read (archA, a);
			writeln ('Codigo: ', a.codigo);
			writeln ('Cursadas: ', a.cursadas);
			writeln ('Finales: ', a.finales);
		
		end;
	
	close (archA);


end;
var
	archA : archivoA;
	archD: archivoD;

begin
	assign (archA, 'maestro.dat');
	assign (archD, 'detalle.dat');
	//crearMaestro (archA);
	crearDetalle (archD);
	menu (archA, archD);
	imprimirMaestro (archA);
	
	
	




end.
	
	
		
		

