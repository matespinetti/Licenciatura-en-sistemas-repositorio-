program ejercicio6;
type
	novela = record
		codigo: integer;
		nombre: string;
		genero: string;
		precio: real;
	end;

	archivo = file of novela;




procedure crear (var archNov: archivo; var novelas: text);
var
	n: novela;
begin
	rewrite (archNov);
	reset (novelas);
	while (not eof (novelas)) do
		begin
			readln (novelas, n.codigo, n.precio, n.genero);
			readln (novelas, n.nombre);
			write (archNov, n);
		
		end;
	
	close (archNov);
	close (novelas);
end;
procedure opciones(var archNov: archivo; var novelas: text; var num: integer);
begin
	writeln ('Opcion 1: Crear Archivo');
	readln (num);
	
	case num of
		1: crear (archNov, novelas);
	
	end;




end;


procedure menu (var archNov: archivo; var novelas: text);
var
	num: integer;
begin
	opciones (archNov, novelas, num);
	while (num <> -1) do 
		opciones (archNov, novelas, num);


end;

var
	archNov : archivo;
	novelas : text;

begin
	assign (archNov, 'novelas.dat');
	assign (novelas, 'novelasTexto.txt');
	menu (archNov, novelas);
	



end.
