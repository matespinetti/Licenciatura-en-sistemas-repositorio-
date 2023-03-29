program ejercicio4;
const
	VALORALTO = 32000;
type
	f = record
		dia: integer;
		mes: integer;
		ano: integer;
	end;
	
	usuario = record
		codigo: integer;
		fecha: f;
		tiempoSesion: integer;
	end;
	
	maestro = file of usuario;
	detalle = file of usuario;
	vectorDetalles = array[1..5] of detalle;
	vectorRegistros = array [1..5] of usuario;
	



	
	
procedure leer (var archD: detalle; var regD: usuario);
begin
	if (not eof(archD)) then
		read (archD, regD)
	else
		regD.codigo := 32000;


end;


procedure minimo (var vectorD: vectorDetalles; var vectorR: vectorRegistros ; var min: usuario);
var
	i, minIndice : integer;
begin
	min.codigo := 32000;
	min.fecha.dia := 32000;
	min.fecha.mes := 32000 ;
	min.fecha.ano := 32000;
	for i := 1 to 5 do
		begin
			if (vectorR[i].codigo < min.Codigo) then
				begin
					if (vectorR[i].fecha.dia < min.fecha.dia ) then
						begin
							if (vectorR[i].fecha.mes < min.fecha.mes) then
								begin
									if (vectorR[i].fecha.ano < min.fecha.ano) then
										begin
											minIndice := i;
											min := vectorR[i];
										
										
										end;
								
								end;
						
						
						end;
				
				
				end;
		
		end;
		
		leer (vectorD[minIndice], vectorR[minIndice]);
		
	



end;
procedure procesar (var vectorD: vectorDetalles; var vectorR: vectorRegistros; var archM: maestro);
var
	i: integer;
	min, actual: usuario;
begin
	for i := 1 to 5 do
		begin
			reset (vectorD[i]);
			leer (vectorD[i], vectorR[i]);
		
		end;
		
	rewrite (archM);
		
	
	minimo (vectorD, vectorR, min);
	
	while (min.codigo <> VALORALTO) do
		begin
			actual := min;
			actual.tiempoSesion := 0;
			
			while ( (min.codigo <> VALORALTO) and(actual.codigo = min.codigo) and (actual.fecha.dia = min.fecha.dia) and (actual.fecha.mes = min.fecha.mes) and (actual.fecha.ano = min.fecha.ano)) do
				begin
						actual.tiempoSesion := actual.tiempoSesion + min.tiempoSesion;
						minimo (vectorD, vectorR, min)
				
				end;
				
			write (archM, actual);
		
				
				
			
		
		
		end;
	
	
	for i := 1 to 5 do
		begin
			close (vectorD[i]);
		
		end;
		
	close (archM);
		
	
	




end;


procedure leerUsuario (var u: usuario);
begin
	writeln ('Ingrese codigo de usuario');
	readln (u.codigo);
	if (u.codigo <> -1) then
		begin
			writeln ('Ingrese dia');
			readln (u.fecha.dia);
			writeln ('Ingrese mes');
			readln (u.fecha.mes);
			writeln ('Ingrese ano');
			readln (u.fecha.ano);
			writeln ('Ingrese tiempo sesion');
			readln (u.tiempoSesion);
		
		end;

end;

procedure crearDetalles (var vectorD: vectorDetalles);
var
	i: integer;
	u: usuario;
begin
	for i := 1 to 5 do
		begin
			writeln ('DETALLE: ', i);
			rewrite (vectorD[i]);
			leerUsuario (u);
			while (u.codigo <> -1) do
				begin
					write (vectorD[i], u);
					leerUsuario (u);
				
				end;
			
			close (vectorD[i]);
			
		
		end;
	


end;


var
	archM: maestro;
	vectorD: vectorDetalles;
	vectorR: vectorRegistros;


begin
	assign (vectorD[1], 'detalle1.dat');
	assign (vectorD[2], 'detalle2.dat');
	assign (vectorD [3], 'detalle3.dat');
	assign (vectorD [4], 'detalle4.dat');
	assign (vectorD [5], 'detalle5.dat');
	assign (archM, 'maestro.dat');
	//crearDetalles (vectorD);
	procesar (vectorD, vectorR, archM);
	




end.
	
	


	

	

